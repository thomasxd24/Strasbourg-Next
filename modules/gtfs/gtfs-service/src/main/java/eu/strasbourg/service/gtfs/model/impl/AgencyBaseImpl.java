/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model.impl;

import eu.strasbourg.service.gtfs.model.Agency;
import eu.strasbourg.service.gtfs.service.AgencyLocalServiceUtil;

/**
 * The extended model base implementation for the Agency service. Represents a row in the &quot;gtfs_Agency&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AgencyImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see AgencyImpl
 * @see Agency
 * @generated
 */
public abstract class AgencyBaseImpl extends AgencyModelImpl implements Agency {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a agency model instance should use the <code>Agency</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			AgencyLocalServiceUtil.addAgency(this);
		}
		else {
			AgencyLocalServiceUtil.updateAgency(this);
		}
	}

}