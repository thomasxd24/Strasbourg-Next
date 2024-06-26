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

package eu.strasbourg.service.activity.model.impl;

import org.osgi.annotation.versioning.ProviderType;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import eu.strasbourg.service.activity.model.Association;
import eu.strasbourg.service.activity.model.Practice;
import eu.strasbourg.service.activity.model.PracticeCategories;
import eu.strasbourg.service.activity.service.AssociationLocalServiceUtil;
import eu.strasbourg.service.activity.service.PracticeLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * The extended model implementation for the Association service. Represents a row in the &quot;activity_Association&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.activity.model.Association} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class AssociationImpl extends AssociationBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a association model instance should use the {@link eu.strasbourg.service.activity.model.Association} interface instead.
	 */
	public AssociationImpl() {
	}

	/**
	 * Retourne la version live de cette entité
	 */
	@Override
	public Association getLiveVersion() {
		long groupId = this.getGroupId();
		Group group = GroupLocalServiceUtil.fetchGroup(groupId);
		if (group == null || !group.isStagingGroup()) {
			return null;
		}
		long liveGroupId = group.getLiveGroupId();
		Association liveAssociation = AssociationLocalServiceUtil
				.fetchAssociationByUuidAndGroupId(this.getUuid(),
						liveGroupId);
		return liveAssociation;
	}

	/**
	 * Retourne l'AssetEntry rattaché à cette entité
	 */
	@Override
	public AssetEntry getAssetEntry() {
		return AssetEntryLocalServiceUtil.fetchEntry(Association.class.getName(),
				this.getPrimaryKey());
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cette entité (via
	 * l'assetEntry)
	 */
	@Override
	public List<AssetCategory> getCategories() {
		return AssetVocabularyHelper
				.getAssetEntryCategories(this.getAssetEntry());
	}

	/**
	 * Retourne les activités de l'association
	 */
	@Override
	public List<Practice> getPractices() {
		return PracticeLocalServiceUtil.getByAssociation(this.getAssociationId());
	}

	/**
	 * Retourne les catégories des activités triées par domaine de l'association
	 */
	@Override
	public List<PracticeCategories> getPracticesCategories() {
		return PracticeLocalServiceUtil.getPracticesSortedByAssociation(this.getAssociationId());
	}

	/**
	 * Retourne les territoires de l'association
	 */
	@Override
	public List<AssetCategory> getTerritories() {
		List<AssetCategory> territories = new ArrayList<>();
		// for each practice, get the territories
		List<Practice> practices = this.getPractices();
		for (Practice practice : practices) {
			List<AssetCategory> practiceTerritories = AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(practice.getAssetEntry(), "territoire");
			// add the territories to the list
			for (AssetCategory territory : practiceTerritories) {
				if (!territories.contains(territory)) {
					territories.add(territory);
				}
			}
		}
		return territories;
	}
}