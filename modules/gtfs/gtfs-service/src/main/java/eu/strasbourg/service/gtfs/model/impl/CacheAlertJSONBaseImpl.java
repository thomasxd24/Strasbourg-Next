/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model.impl;

import eu.strasbourg.service.gtfs.model.CacheAlertJSON;
import eu.strasbourg.service.gtfs.service.CacheAlertJSONLocalServiceUtil;

/**
 * The extended model base implementation for the CacheAlertJSON service. Represents a row in the &quot;gtfs_CacheAlertJSON&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CacheAlertJSONImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see CacheAlertJSONImpl
 * @see CacheAlertJSON
 * @generated
 */
public abstract class CacheAlertJSONBaseImpl
	extends CacheAlertJSONModelImpl implements CacheAlertJSON {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cache alert json model instance should use the <code>CacheAlertJSON</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CacheAlertJSONLocalServiceUtil.addCacheAlertJSON(this);
		}
		else {
			CacheAlertJSONLocalServiceUtil.updateCacheAlertJSON(this);
		}
	}

}