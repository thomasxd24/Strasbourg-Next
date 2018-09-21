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

package eu.strasbourg.service.project.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Initiative service. Represents a row in the &quot;project_Initiative&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see InitiativeModel
 * @see eu.strasbourg.service.project.model.impl.InitiativeImpl
 * @see eu.strasbourg.service.project.model.impl.InitiativeModelImpl
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.project.model.impl.InitiativeImpl")
@ProviderType
public interface Initiative extends InitiativeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link eu.strasbourg.service.project.model.impl.InitiativeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Initiative, Long> INITIATIVE_ID_ACCESSOR = new Accessor<Initiative, Long>() {
			@Override
			public Long get(Initiative initiative) {
				return initiative.getInitiativeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Initiative> getTypeClass() {
				return Initiative.class;
			}
		};

	/**
	* Retourne l'AssetEntry rattaché cet item
	*/
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	* Renvoie la liste des AssetCategory rattachées à cet item (via
	* l'assetEntry)
	*/
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getCategories();

	/**
	* Retourne la liste des lieux placit liés à l'initiative
	*/
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace> getPlacitPlaces();

	/**
	* Retourne les noms des lieux placit de l'initiative
	*/
	public java.util.List<java.lang.String> getPlaceNames(
		java.util.Locale locale);

	/**
	* Retourne les ids SIG des lieux placit de l'initiative
	*/
	public java.util.List<java.lang.String> getPlaceSIGIds(
		java.util.Locale locale);

	/**
	* Retourne les thematiques de la initiative (
	*/
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getThematicCategories();

	/**
	* Retourne les catégories 'Territoire' correspondant aux pays de la initiative
	*/
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getTerritoryCategories();

	/**
	* Retourne les sous-catégories 'Territoire' correspondant aux villes de la initiative
	*
	* @return : null si vide, sinon la liste des catégories
	*/
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getCityCategories();

	/**
	* Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de la initiative
	*
	* @return : null si vide, sinon la liste des catégories
	*/
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getDistrictCategories();

	/**
	* Retourne une chaine des 'Territoires' correspondant aux quartiers de la initiative
	*
	* @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	*/
	public java.lang.String getDistrictLabel(java.util.Locale locale);

	/**
	* Retourne une chaine des 'Thematics' sépararée d'un '-'
	*/
	public java.lang.String getThematicsLabel(java.util.Locale locale);

	/**
	* Retourne le copyright de l'image principale
	*/
	public java.lang.String getImageCopyright(java.util.Locale locale);

	/**
	* Retourne le projet de l'initiative (
	*/
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getProjectsCategory();

	/**
	* Retourne l'URL de l'image à partir de l'id du DLFileEntry
	*/
	public java.lang.String getImageURL();

	/**
	* Retourne le statut de l'initiative (
	*/
	public com.liferay.asset.kernel.model.AssetCategory getStatusCategory();

	/**
	* Retourne le nombre d'aides de l'initiative
	*/
	public int getNbHelpInitiative();

	/**
	* Retourne la liste des like/dislike de l'entité
	*
	* @see eu.strasbourg.service.like.model.LikeType
	*/
	public java.util.List<eu.strasbourg.service.like.model.Like> getLikesDislikes();

	/**
	* Retourne la liste des likes de l'entité
	*
	* @see eu.strasbourg.service.like.model.LikeType
	*/
	public java.util.List<eu.strasbourg.service.like.model.Like> getLikes();

	/**
	* Retourne la liste des dislikes de l'entité
	*
	* @see eu.strasbourg.service.like.model.LikeType
	*/
	public java.util.List<eu.strasbourg.service.like.model.Like> getDislikes();

	/**
	* Retourne le nombre de likes/dislikes de l'entité
	*
	* @see eu.strasbourg.service.like.model.LikeType
	*/
	public int getNbLikesDislikes();

	/**
	* Retourne le nombre de likes de l'entité
	*
	* @see eu.strasbourg.service.like.model.LikeType
	*/
	public int getNbLikes();

	/**
	* Retourne le nombre de dislikes de l'entité
	*
	* @see eu.strasbourg.service.like.model.LikeType
	*/
	public int getNbDislikes();
}