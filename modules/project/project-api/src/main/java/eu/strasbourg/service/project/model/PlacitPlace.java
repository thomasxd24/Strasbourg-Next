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
 * The extended model interface for the PlacitPlace service. Represents a row in the &quot;project_PlacitPlace&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see PlacitPlaceModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.project.model.impl.PlacitPlaceImpl"
)
@ProviderType
public interface PlacitPlace extends PersistedModel, PlacitPlaceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.project.model.impl.PlacitPlaceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PlacitPlace, Long> PLACIT_PLACE_ID_ACCESSOR =
		new Accessor<PlacitPlace, Long>() {

			@Override
			public Long get(PlacitPlace placitPlace) {
				return placitPlace.getPlacitPlaceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PlacitPlace> getTypeClass() {
				return PlacitPlace.class;
			}

		};

	/**
	 * Retourne le projet du lieu Placit
	 */
	public eu.strasbourg.service.project.model.Project getProject();

	/**
	 * Retourne la participation du lieu Placit
	 */
	public eu.strasbourg.service.project.model.Participation getParticipation();

	/**
	 * Retourne l'AssetEntry rattaché à cette entité
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Retourne la liste des AssetCategory rattachées à cette entité (via
	 * l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * Retourne le nom du lieu SIG
	 */
	public String getSIGPlaceAlias(java.util.Locale locale);

	/**
	 * Retourne le nom du lieu SIG ou "manuel"
	 */
	public String getPlaceAlias(java.util.Locale locale);

	/**
	 * Retourne l'adresse (num + rue) du lieu SIG ou "manuel"
	 */
	public String getAddress();

	/**
	 * Retourne l'adresse complete du lieu SIG ou "manuel"
	 */
	public String getCompleteAddress(java.util.Locale locale);

	/**
	 * Retourne le code postal du lieu SIG ou "manuel"
	 */
	public String getZipCode();

	/**
	 * Retourne la ville du lieu SIG ou "manuel"
	 */
	public String getCity(java.util.Locale locale);

	/**
	 * Retourne les coordonnees mercator en axe X (longitude)
	 */
	public String getMercatorX();

	/**
	 * Retourne les coordonnees mercator en axe Y (latitude)
	 */
	public String getMercatorY();

	/**
	 * Retourne les coordonnees mercator en axe X et Y
	 * Notes : permet de ne pas multiplier les appels
	 *
	 * @return tableau [mercatorX, mercatorY] sinon tableau vide
	 */
	public java.util.List<String> getMercators();

	/**
	 * Retourne l'ID de l'image du lieu SIG ou "manuel"
	 */
	public String getImageURL();

	/**
	 * Renvoie si le lieu placit est SIG ou manuel
	 *
	 * @return True : lieu SIG ; False : lieu manuel
	 */
	public boolean isSIG();

	/**
	 * Retourne la version JSON de l'entité
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

}