/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import eu.strasbourg.service.agenda.model.CacheJson;
import eu.strasbourg.service.agenda.service.CacheJsonLocalServiceUtil;

/**
 * The extended model base implementation for the CacheJson service. Represents a row in the &quot;agenda_CacheJson&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CacheJsonImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see CacheJsonImpl
 * @see CacheJson
 * @generated
 */
public abstract class CacheJsonBaseImpl
	extends CacheJsonModelImpl implements CacheJson {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cache json model instance should use the <code>CacheJson</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CacheJsonLocalServiceUtil.addCacheJson(this);
		}
		else {
			CacheJsonLocalServiceUtil.updateCacheJson(this);
		}
	}

}