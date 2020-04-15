/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.council.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLink;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.council.model.Deliberation;
import eu.strasbourg.service.council.service.base.DeliberationLocalServiceBaseImpl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the deliberation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.council.service.DeliberationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DeliberationLocalServiceBaseImpl
 * @see eu.strasbourg.service.council.service.DeliberationLocalServiceUtil
 */
public class DeliberationLocalServiceImpl extends DeliberationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link eu.strasbourg.service.council.service.DeliberationLocalServiceUtil} to access the deliberation local service.
	 */

	public final static Log log = LogFactoryUtil.getLog(DeliberationLocalServiceImpl.class);

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public Deliberation createDeliberation(ServiceContext sc) throws PortalException {
		User user = UserLocalServiceUtil.getUser(sc.getUserId());

		long pk = this.counterLocalService.increment();
		Deliberation deliberation = this.deliberationLocalService.createDeliberation(pk);

		deliberation.setUserName(user.getFullName());
		deliberation.setUserId(sc.getUserId());
		deliberation.setGroupId(sc.getScopeGroupId());
		deliberation.setStatus(WorkflowConstants.STATUS_DRAFT);

		return deliberation;
	}

	/**
	 * Met à jour une entité et l'enregistre en base de données
	 */
	@Override
	public Deliberation updateDeliberation(Deliberation deliberation, ServiceContext sc) throws PortalException {
		User user = UserLocalServiceUtil.getUser(sc.getUserId());

		deliberation.setStatusByUserId(sc.getUserId());
		deliberation.setStatusByUserName(user.getFullName());
		deliberation.setStatusDate(sc.getModifiedDate());

		if (sc.getWorkflowAction() == WorkflowConstants.ACTION_PUBLISH) {
			deliberation.setStatus(WorkflowConstants.STATUS_APPROVED);
		} else {
			deliberation.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		deliberation = this.deliberationLocalService.updateDeliberation(deliberation);

		this.updateAssetEntry(deliberation, sc);
		this.reindex(deliberation, false);

		return deliberation;
	}

	/**
	 * Met à jour l'AssetEntry rattachée à l'entité
	 */
	private void updateAssetEntry(Deliberation deliberation, ServiceContext sc)
			throws PortalException {
		this.assetEntryLocalService.updateEntry(sc.getUserId(), // User ID
				sc.getScopeGroupId(), // Group ID
				deliberation.getCreateDate(), // Date of creation
				deliberation.getModifiedDate(), // Date of modification
				Deliberation.class.getName(), // Class name
				deliberation.getPrimaryKey(), // Class PK
				deliberation.getUuid(), // UUID
				0, // Class type ID
				sc.getAssetCategoryIds(), // Categories IDs
				sc.getAssetTagNames(), // Tags IDs
				true, // Listable
				deliberation.isApproved(), // Visible
				deliberation.getCreateDate(), // Start date
				null, // End date
				deliberation.getCreateDate(), // Publication date
				null, // Date of expiration
				ContentTypes.TEXT_HTML, // Content type
				deliberation.getTitle(), // Title
				deliberation.getText(), // Description
				deliberation.getText(), // Summary
				null, // URL
				null, // Layout uuid
				0, // Width
				0, // Height
				null); // Priority

		// Réindexe l'entité
		this.reindex(deliberation, false);
	}

	/**
	 * Met à jour le statut de l'entité par le framework workflow
	 */
	@Override
	public Deliberation updateStatus(long userId, long entryId, int status,
								ServiceContext sc, Map<String, Serializable> workflowContext)
			throws PortalException {
		Date now = new Date();
		// Statut de l'entité
		Deliberation deliberation = this.getDeliberation(entryId);
		deliberation.setStatus(status);
		User user = UserLocalServiceUtil.fetchUser(userId);
		if (user != null) {
			deliberation.setStatusByUserId(user.getUserId());
			deliberation.setStatusByUserName(user.getFullName());
		}
		deliberation.setStatusDate(new Date());
		deliberation = this.deliberationLocalService.updateDeliberation(deliberation);

		// Statut de l'entry
		AssetEntry entry = this.assetEntryLocalService
				.getEntry(Deliberation.class.getName(), deliberation.getPrimaryKey());
		entry.setVisible(status == WorkflowConstants.STATUS_APPROVED);
		if (entry.isVisible()) {
			entry.setPublishDate(now);
		}
		this.assetEntryLocalService.updateAssetEntry(entry);

		this.reindex(deliberation, false);

		return deliberation;
	}

	/**
	 * Met à jour le statut de l'entité "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(Deliberation deliberation, int status) throws PortalException {
		this.updateStatus(deliberation.getUserId(), deliberation.getDeliberationId(), status, null,
				null);
	}

	/**
	 * Supprime une entité
	 */
	@Override
	public Deliberation removeDeliberation(long deliberationId) throws PortalException {
		AssetEntry entry = AssetEntryLocalServiceUtil
				.fetchEntry(Deliberation.class.getName(), deliberationId);

		if (entry != null) {
			// Supprime les liens avec les catégories
			for (long categoryId : entry.getCategoryIds()) {
				this.assetEntryLocalService.deleteAssetCategoryAssetEntry(
						categoryId, entry.getEntryId());
			}

			// Supprime les liens avec les étiquettes
			long[] tagIds = AssetEntryLocalServiceUtil
					.getAssetTagPrimaryKeys(entry.getEntryId());
			for (long tagId : tagIds) {
				AssetEntryLocalServiceUtil.deleteAssetTagAssetEntry(tagId,
						entry.getEntryId());
			}

			// Supprime lien avec les autres entries
			List<AssetLink> links = this.assetLinkLocalService
					.getLinks(entry.getEntryId());
			for (AssetLink link : links) {
				this.assetLinkLocalService.deleteAssetLink(link);
			}

			// Supprime l'AssetEntry
			AssetEntryLocalServiceUtil.deleteEntry(Deliberation.class.getName(), deliberationId);
		}

		// Supprime le projet
		Deliberation deliberation = deliberationPersistence.remove(deliberationId);

		// Supprime l'index
		this.reindex(deliberation, true);

		// Supprime ce qui a rapport au workflow
		WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(
				deliberation.getCompanyId(), deliberation.getGroupId(), Deliberation.class.getName(),
				deliberation.getDeliberationId());

		return deliberation;
	}

	/**
	 * Reindex l'entité dans le moteur de recherche
	 */
	private void reindex(Deliberation deliberation, boolean delete) throws SearchException {
		Indexer<Deliberation> indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(Deliberation.class);
		if (delete) {
			indexer.delete(deliberation);
		} else {
			indexer.reindex(deliberation);
		}
	}

	/**
	 * Recherche par ID de CouncilSession
	 */
	@Override
	public List<Deliberation> findByCouncilSessionId(long councilSessionId){
		return this.deliberationPersistence.findByCouncilSessionId(councilSessionId);
	}

}