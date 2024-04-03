/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Ligne service. Represents a row in the &quot;gtfs_Ligne&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see LigneModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.gtfs.model.impl.LigneImpl")
@ProviderType
public interface Ligne extends LigneModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.gtfs.model.impl.LigneImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Ligne, Long> LIGNE_ID_ACCESSOR =
		new Accessor<Ligne, Long>() {

			@Override
			public Long get(Ligne ligne) {
				return ligne.getLigneId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Ligne> getTypeClass() {
				return Ligne.class;
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
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * Renvoie la liste des Directions de cette ligne
	 */
	public java.util.List<eu.strasbourg.service.gtfs.model.Direction>
		getDirections();

	/**
	 * Retourne les couleurs de la ligne au format JSON
	 */
	public com.liferay.portal.kernel.json.JSONObject getColors();

}