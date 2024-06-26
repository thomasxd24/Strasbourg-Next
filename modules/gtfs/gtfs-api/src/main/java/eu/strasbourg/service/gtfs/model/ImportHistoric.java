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
 * The extended model interface for the ImportHistoric service. Represents a row in the &quot;gtfs_ImportHistoric&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see ImportHistoricModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.gtfs.model.impl.ImportHistoricImpl"
)
@ProviderType
public interface ImportHistoric extends ImportHistoricModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.gtfs.model.impl.ImportHistoricImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ImportHistoric, Long>
		IMPORT_HISTORIC_ID_ACCESSOR = new Accessor<ImportHistoric, Long>() {

			@Override
			public Long get(ImportHistoric importHistoric) {
				return importHistoric.getImportHistoricId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ImportHistoric> getTypeClass() {
				return ImportHistoric.class;
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
	 * Renvoie le label affichable du resultat de l'import
	 *
	 * @return
	 */
	public String getResultLabel();

	/**
	 * Ajout d'une ligne dans le resultat de l'import
	 *
	 * @return
	 */
	public void addNewOperation(String operation);

	/**
	 * Envoi du mail d'import
	 */
	public void sendMail();

}