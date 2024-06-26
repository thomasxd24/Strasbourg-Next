/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Participation service. Represents a row in the &quot;project_Participation&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see ParticipationModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.project.model.impl.ParticipationImpl"
)
@ProviderType
public interface Participation extends ParticipationModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.project.model.impl.ParticipationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Participation, Long>
		PARTICIPATION_ID_ACCESSOR = new Accessor<Participation, Long>() {

			@Override
			public Long get(Participation participation) {
				return participation.getParticipationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Participation> getTypeClass() {
				return Participation.class;
			}

		};

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	public String getImageAuthorURL(
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException;

	public String getAuthorFullName()
		throws com.liferay.portal.kernel.exception.PortalException;

	/**
	 * Retourne la liste des like/dislike de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	public java.util.List<eu.strasbourg.service.like.model.Like>
		getLikesDislikes();

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

	/**
	 * Peut apporter une reaction (commenter, liker, participer) a l'entite
	 */
	public boolean isJudgeable();

	/**
	 * Retourne les commentaires de l'entité
	 */
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getApprovedComments();

	/**
	 * Retourne le nombre de commentaires de l'entité
	 */
	public int getNbApprovedComments();

	/**
	 * Retourne le label de 5 digits du nombre de commentaires de l'entité
	 */
	public String getNbApprovedCommentsLabel();

	/**
	 * Retourne la liste des événements liés à la participation
	 */
	public java.util.List<eu.strasbourg.service.agenda.model.Event> getEvents();

	/**
	 * Retourne la liste des lieux placit liés à la participation
	 */
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlaces();

	/**
	 * Retourne les noms des lieux placit de la participation
	 */
	public java.util.List<String> getPlaceNames(java.util.Locale locale);

	/**
	 * Retourne les ids SIG des lieux placit de la participation
	 */
	public java.util.List<String> getPlaceSIGIds(java.util.Locale locale);

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * Retourne le type de la participation (
	 */
	public com.liferay.asset.kernel.model.AssetCategory getTypeCategory();

	/**
	 * Retourne le projet de la participation (
	 */
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory();

	/**
	 * Retourne la couleur hexa du type de la participation contenu dans la
	 * propriete 'code_color' de la categorie associee
	 */
	public String getTypeCategoryColor();

	/**
	 * Retourne les thematiques de la participation (
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThematicCategories();

	/**
	 * Retourne les catégories 'Territoire' correspondant aux pays de la
	 * participation
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritoryCategories();

	/**
	 * Retourne les sous-catégories 'Territoire' correspondant aux villes de la
	 * participation
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCityCategories();

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de
	 * la participation
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistrictCategories();

	/**
	 * Retourne une chaine des 'Territoires' correspondant aux quartiers de la
	 * participation
	 *
	 * @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	 */
	public String getDistrictLabel(java.util.Locale locale);

	/**
	 * Retourne une chaine des 'Thematics' sépararée d'un '-'
	 */
	public String getThematicsLabel(java.util.Locale locale);

	/**
	 * Retourne le status de la participation
	 */
	public com.liferay.asset.kernel.model.AssetCategory
		getParticipationStatusCategory();

	/**
	 * Retourne le status de la participation selon la temporalité actuelle
	 *
	 * @return le status suivant l'ordre : [soon_arrived] : date du jour antérieur à
	 la date de publication [new] : 7 jour après la publication
	 [in_progress] : toute la durée de la période de participation
	 [soon_finished] : 7 jours avant l'expiration [finished] : date du
	 jour postérieur à la date d'expiration
	 */
	public String getParticipationStatus();

	/**
	 * Calcul la différence de jours entre la date du jour et celle de publication
	 */
	public int getTodayPublicationDifferenceDays();

	/**
	 * Calcul la différence de jours entre la date du jour et celle d'expiration
	 */
	public int getTodayExpirationDifferenceDays();

	/**
	 * Retourne la liste des URLs des documents
	 */
	public java.util.List<String> getFilesURLs();

	/**
	 * Retourne le label d'affichage détaillant le statut
	 */
	public String getStatusDetailLabel();

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	public String getImageURL();

	/**
	 * Retourne le copyright de l'image principale
	 */
	public String getImageCopyright(java.util.Locale locale);

	/**
	 * Retourne la version JSON de l'entité
	 *
	 * @throws PortalException
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON(
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException;

}