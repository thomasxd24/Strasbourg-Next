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

package eu.strasbourg.service.agenda.service.impl;

import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.link.model.AssetLink;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.link.service.AssetLinkLocalService;
import com.liferay.asset.link.service.AssetLinkLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import eu.strasbourg.service.agenda.model.AgendaExport;
import eu.strasbourg.service.agenda.model.AgendaExportPeriod;
import eu.strasbourg.service.agenda.service.AgendaExportPeriodLocalServiceUtil;
import eu.strasbourg.service.agenda.service.base.AgendaExportLocalServiceBaseImpl;
import eu.strasbourg.utils.AssetVocabularyHelper;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the agenda export local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.agenda.service.AgendaExportLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author BenjaminBini
 * @see AgendaExportLocalServiceBaseImpl
 * @see eu.strasbourg.service.agenda.service.AgendaExportLocalServiceUtil
 */
public class AgendaExportLocalServiceImpl
	extends AgendaExportLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link eu.strasbourg.service.agenda.service.AgendaExportLocalServiceUtil} to access the agenda export local service.
	 */
	
	/**
	 * Crée un Agenda Export vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public AgendaExport createAgendaExport(ServiceContext sc) throws PortalException {
		User user = UserLocalServiceUtil.getUser(sc.getUserId());

		long pk = counterLocalService.increment();

		AgendaExport agendaExport = this.agendaExportLocalService.createAgendaExport(pk);

		agendaExport.setGroupId(sc.getScopeGroupId());
		agendaExport.setUserName(user.getFullName());
		agendaExport.setUserId(sc.getUserId());

		agendaExport.setStatus(WorkflowConstants.STATUS_DRAFT);

		return agendaExport;
	}
	
	@Override
	public AgendaExport copyAgendaExport(ServiceContext sc, AgendaExport agendaToCopy) throws PortalException {
		User user = UserLocalServiceUtil.getUser(sc.getUserId());

		long pk = counterLocalService.increment();

		AgendaExport agendaExport = (AgendaExport)agendaToCopy.clone();

		agendaExport.setGroupId(sc.getScopeGroupId());
		agendaExport.setUserName(user.getFullName());
		agendaExport.setUserId(sc.getUserId());
		agendaExport.setNew(true);
		agendaExport.setPrimaryKey(pk);

		String uuid = PortalUUIDUtil.generate();

		agendaExport.setUuid(uuid);

		//Clone periods
		List<AgendaExportPeriod> periodsToCopy = AgendaExportPeriodLocalServiceUtil.getByAgendaExportId(agendaToCopy.getAgendaExportId());
		for(AgendaExportPeriod period : periodsToCopy) {
			AgendaExportPeriod agendaExportPeriod = AgendaExportPeriodLocalServiceUtil.createAgendaExportPeriod();
			agendaExportPeriod.setStartDate(period.getStartDate());
			agendaExportPeriod.setEndDate(period.getEndDate());
			agendaExportPeriod.setAgendaExportId(agendaExport.getAgendaExportId());
			AgendaExportPeriodLocalServiceUtil.addAgendaExportPeriod(agendaExportPeriod);
		}

		return agendaExport;
	}
	
	/**
	 * Met à jour un Agenda Export et l'enregistre en base de données
	 */
	@Override
	public AgendaExport updateAgendaExport(AgendaExport agendaExport, ServiceContext sc) throws PortalException {
		User user = UserLocalServiceUtil.getUser(sc.getUserId());

		agendaExport.setStatusByUserId(sc.getUserId());
		agendaExport.setStatusByUserName(user.getFullName());
		agendaExport.setStatusDate(sc.getModifiedDate());

		// Si on n'utilise pas le framework workflow, simple gestion
		// brouillon/publié
		if (!WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(sc.getCompanyId(), sc.getScopeGroupId(),
				AgendaExport.class.getName())) {
			if (sc.getWorkflowAction() == WorkflowConstants.ACTION_PUBLISH) {
				agendaExport.setStatus(WorkflowConstants.STATUS_APPROVED);
			} else {
				agendaExport.setStatus(WorkflowConstants.STATUS_DRAFT);
			}
			agendaExport = this.agendaExportLocalService.updateAgendaExport(agendaExport);
			this.updateAssetEntry(agendaExport, sc);
			this.reindex(agendaExport, false);
		} else { // Si le framework worflow est actif, c'est celui-ci qui gère
					// l'enregistrement
			agendaExport = this.agendaExportLocalService.updateAgendaExport(agendaExport);
			WorkflowHandlerRegistryUtil.startWorkflowInstance(agendaExport.getCompanyId(), agendaExport.getGroupId(),
					agendaExport.getUserId(), AgendaExport.class.getName(), agendaExport.getPrimaryKey(), agendaExport, sc);
		}

		return agendaExport;
	}
	
	/**
	 * Met à jour l'AssetEntry rattachée à l'AgendaExport
	 */
	private void updateAssetEntry(AgendaExport agendaExport, ServiceContext sc) throws PortalException {
		this.assetEntryLocalService.updateEntry(sc.getUserId(), // User ID
				sc.getScopeGroupId(), // Group ID
				agendaExport.getCreateDate(), // Date of creation
				agendaExport.getModifiedDate(), // Date of modification
				AgendaExport.class.getName(), // Class name
				agendaExport.getPrimaryKey(), // Class PK
				agendaExport.getUuid(), // UUID
				0, // Class type ID
				sc.getAssetCategoryIds(), // Categories IDs
				sc.getAssetTagNames(), // Tags IDs
				true, // Listable
				agendaExport.isApproved(), // Visible
				agendaExport.getCreateDate(), // Start date
				null, // End date
				agendaExport.getCreateDate(), // Publication date
				null, // Date of expiration
				ContentTypes.TEXT_HTML, // Content type
				agendaExport.getTitle(), // Title
				agendaExport.getTitle(), // Description
				agendaExport.getTitle(), // Summary
				null, // URL
				null, // Layout uuid
				0, // Width
				0, // Height
				null); // Priority

		// Réindexe l'AgendaExport
		this.reindex(agendaExport, false);
	}
	
	/**
	 * Met à jour le statut de l'AgendaExport par le framework workflow
	 */
	@Override
	public AgendaExport updateStatus(long userId, long entryId, int status, ServiceContext sc,
			Map<String, Serializable> workflowContext) throws PortalException {
		Date now = new Date();
		// Statut de l'entité
		AgendaExport agendaExport = this.getAgendaExport(entryId);
		agendaExport.setStatus(status);
		User user = UserLocalServiceUtil.fetchUser(userId);
		if (user != null) {
			agendaExport.setStatusByUserId(user.getUserId());
			agendaExport.setStatusByUserName(user.getFullName());
		}
		agendaExport.setStatusDate(new Date());
		agendaExport = this.agendaExportLocalService.updateAgendaExport(agendaExport);

		// Statut de l'entry
		AssetEntry entry = this.assetEntryLocalService.getEntry(AgendaExport.class.getName(), agendaExport.getPrimaryKey());
		entry.setVisible(status == WorkflowConstants.STATUS_APPROVED);
		if (entry.isVisible()) {
			entry.setPublishDate(now);
		}
		this.assetEntryLocalService.updateAssetEntry(entry);

		this.reindex(agendaExport, false);

		return agendaExport;
	}
	

	/**
	 * Met à jour le statut de l'AgendaExport "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(AgendaExport agendaExport, int status) throws PortalException {
		this.updateStatus(agendaExport.getUserId(), agendaExport.getAgendaExportId(), status, null, null);
	}

	/**
	 * Supprime un AgendaExport
	 */
	@Override
	public AgendaExport removeAgendaExport(long agendaExportId) throws PortalException {
		AssetEntry entry = AssetEntryLocalServiceUtil.fetchEntry(AgendaExport.class.getName(), agendaExportId);

		if (entry != null) {
			// Delete the link with categories
			AssetEntryAssetCategoryRelLocalServiceUtil.
					deleteAssetEntryAssetCategoryRelByAssetEntryId(entry.getEntryId());
			// Delete the link with tags
			long[] tagIds = AssetEntryLocalServiceUtil.getAssetTagPrimaryKeys(entry.getEntryId());
			for (int i = 0; i < tagIds.length; i++) {
				AssetEntryLocalServiceUtil.deleteAssetTagAssetEntry(tagIds[i], entry.getEntryId());
			}

			// Supprime lien avec les autres entries
			List<AssetLink> links = this.assetLinkLocalService.getLinks(entry.getEntryId());
			for (AssetLink link : links) {
				this.assetLinkLocalService.deleteAssetLink(link);
			}

			// Delete the AssetEntry
			AssetEntryLocalServiceUtil.deleteEntry(AgendaExport.class.getName(), agendaExportId);

		}

		// Delete the AgendaExport
		AgendaExport agendaExport = agendaExportPersistence.remove(agendaExportId);	

		// Delete the index
		this.reindex(agendaExport, true);

		// Supprime ce qui a rapport au workflow
		WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(agendaExport.getCompanyId(), agendaExport.getGroupId(),
				AgendaExport.class.getName(), agendaExport.getAgendaExportId());


		return agendaExport;
	}
	
	/**
	 * Reindex l'AgendaExport dans le moteur de recherche
	 */
	private void reindex(AgendaExport agendaExport, boolean delete) throws SearchException {
		Indexer<AgendaExport> indexer = IndexerRegistryUtil.nullSafeGetIndexer(AgendaExport.class);
		if (delete) {
			indexer.delete(agendaExport);
		} else {
			indexer.reindex(agendaExport);
		}
	}
	
	/**
	 * Retourne les vocabulaires rattrachés à ce type d'entité pour un groupe
	 */
	@Override
	public List<AssetVocabulary> getAttachedVocabularies(long groupId) {
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(AgendaExport.class);
		return AssetVocabularyHelper.getVocabulariesForAssetType(groupId, classNameId);
	}

	/**
	 * Retourne tous les AGendaExport d'un groupe
	 */
	@Override
	public List<AgendaExport> getByGroupId(long groupId) {
		return this.agendaExportPersistence.findByGroupId(groupId);
	}
	
	/**
	 * Lance une recherche selon le searchContext
	 */
	@Override
	public Hits search(SearchContext searchContext) throws SearchException {
		Indexer<AgendaExport> indexer = IndexerRegistryUtil.nullSafeGetIndexer(AgendaExport.class);
		return indexer.search(searchContext);
	}
	
	/**
	 * Lance une recherche par mots-clés
	 */
	@Override
	public List<AgendaExport> findByKeyword(String keyword, long groupId,
		int start, int end) {
		DynamicQuery dynamicQuery = dynamicQuery();

		if (keyword.length() > 0) {
			dynamicQuery.add(
				RestrictionsFactoryUtil.like("title", "%" + keyword + "%"));
		}
		if (groupId > 0) {
			dynamicQuery
				.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
		}

		return agendaExportPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}
	
	/**
	 * Compte de la recherche par mots-clés
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		DynamicQuery dynamicQuery = dynamicQuery();
		if (keyword.length() > 0) {
			dynamicQuery.add(
				RestrictionsFactoryUtil.like("title", "%" + keyword + "%"));
		}
		if (groupId > 0) {
			dynamicQuery
				.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
		}

		return agendaExportPersistence.countWithDynamicQuery(dynamicQuery);
	}

	@Reference
	private AssetLinkLocalService assetLinkLocalService;
}