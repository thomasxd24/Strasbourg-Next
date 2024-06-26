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
 * The extended model interface for the Petition service. Represents a row in the &quot;project_Petition&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see PetitionModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.project.model.impl.PetitionImpl"
)
@ProviderType
public interface Petition extends PersistedModel, PetitionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.project.model.impl.PetitionImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Petition, Long> PETITION_ID_ACCESSOR =
		new Accessor<Petition, Long>() {

			@Override
			public Long get(Petition petition) {
				return petition.getPetitionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Petition> getTypeClass() {
				return Petition.class;
			}

		};

	/**
	 * Retourne les catégories 'Territoire' correspondant aux pays de la petition
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritoryCategories();

	public String getProjectTitle(java.util.Locale locale);

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de la petition
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistrictCategories();

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux communes de la pétition
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCityCategories();

	/**
	 * méthode permettant de récuperer les faux signataires d'une pétitions.
	 *
	 * @return les faux signataires.
	 */
	public int getCountFakeSignataire();

	/**
	 * méthode permettant de récupérer le pourcentage de signatures obtenu.
	 *
	 * @return le pourcentage en long.
	 */
	public double getPourcentageSignature();

	/**
	 * Méthode permettant de retourner le nombre de signataire de la pétition
	 *
	 * @return le nombre.
	 */
	public long getNombreSignature();

	/**
	 * méthode permettant d'afficher le nombre de signature.
	 *
	 * @return le nombre avec des zeros devant.
	 */
	public String getNombreSignatureBoard();

	/**
	 * Retourne une chaine des 'Territoires' correspondant aux quartiers de la petition
	 *
	 * @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	 */
	public String getDistrictLabel(java.util.Locale locale);

	public String getThematicLabel(java.util.Locale locale);

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

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
	 * Calcul la différence de jours entre la date du jour et celle d'expiration
	 */
	public int getTodayExpirationDifferenceDays();

	/**
	 * Retourne la liste des URLs des documents
	 */
	public java.util.List<String> getFilesURLs();

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	public String getImageURL();

	/**
	 * Retourne X suggestions max pour une pétition
	 *
	 * @param request
	 la requete
	 * @param nbSuggestions
	 le nombre de suggestions.
	 * @return la liste de pétition.
	 */
	public java.util.List<eu.strasbourg.service.project.model.Petition>
			getSuggestions(
				javax.servlet.http.HttpServletRequest request,
				int nbSuggestions)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.search.SearchException;

	/**
	 * Retourne le copyright de l'image principale
	 */
	public String getImageCopyright(java.util.Locale locale);

	/**
	 * Retourne le label de 5 digits du nombre de commentaires de l'entité
	 */
	public String getNbApprovedCommentsLabel();

	/**
	 * Retourne le nombre de commentaires de l'entité
	 */
	public int getNbApprovedComments();

	/**
	 * Retourne les commentaires de l'entité
	 */
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getApprovedComments();

	/**
	 * Retourne les thematiques de la petition (
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThematicCategories();

	/**
	 * Retourne le projet de la petition (
	 */
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory();

	public String getAssetEntryTitle();

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	public java.util.List<eu.strasbourg.service.project.model.Signataire>
		getSignataires();

	/**
	 * Retourne le status de la petition
	 */
	public com.liferay.asset.kernel.model.AssetCategory
		getPetitionStatusCategory();

	/**
	 * méthode permettant de récuperer le nombre de signataire nécessaire pour finir la pétition.
	 *
	 * @return le nombre
	 */
	public long getSignataireNeeded();

	/**
	 * méthode de récupération du status
	 *
	 * @return le status.
	 */
	public String getPetitionStatus();

	/**
	 * Retourne l'auteur en publik user
	 *
	 * @return
	 */
	public eu.strasbourg.service.oidc.model.PublikUser getAuthorPublikUser();

	/**
	 * Retourne l'URL de l'image de l'utilisateur
	 */
	public String getAuthorImageURL();

	/**
	 * Retourne le nom du depositaire sous forme "Truc M." ou le "Au nom de ..."
	 */
	public String getAuthorLabel();

	/**
	 * méthode de récupération du status
	 *
	 * @return le status.
	 */
	public String getFrontStatusFR();

	/**
	 * méthode d'affichage des information du status pour excel.
	 *
	 * @return le status.
	 */
	public String getPetitionStatusExcel();

	/**
	 * méthode de récupération du status
	 *
	 * @return le status.
	 */
	public String getProDureeFR();

	/**
	 * Retourne la liste des lieux placit liés à la petition
	 */
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlaces();

	/**
	 * Demande si l'utilisateur demandé a signe la petition
	 *
	 * @throws PortletException
	 */
	public boolean hasUserSigned(String publikUserId)
		throws javax.portlet.PortletException;

	public String getPublicationDateFr();

	/**
	 * Retourne la version JSON de l'entité
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON(
		String publikUserId);

}