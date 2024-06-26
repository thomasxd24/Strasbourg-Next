/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model.impl;

import eu.strasbourg.service.gtfs.model.Ligne;
import eu.strasbourg.service.gtfs.service.LigneLocalServiceUtil;

/**
 * The extended model base implementation for the Ligne service. Represents a row in the &quot;gtfs_Ligne&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LigneImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see LigneImpl
 * @see Ligne
 * @generated
 */
public abstract class LigneBaseImpl extends LigneModelImpl implements Ligne {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ligne model instance should use the <code>Ligne</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			LigneLocalServiceUtil.addLigne(this);
		}
		else {
			LigneLocalServiceUtil.updateLigne(this);
		}
	}

}