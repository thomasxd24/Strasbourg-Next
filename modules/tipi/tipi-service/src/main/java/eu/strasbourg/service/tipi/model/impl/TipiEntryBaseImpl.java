/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.tipi.model.impl;

import eu.strasbourg.service.tipi.model.TipiEntry;
import eu.strasbourg.service.tipi.service.TipiEntryLocalServiceUtil;

/**
 * The extended model base implementation for the TipiEntry service. Represents a row in the &quot;tipi_TipiEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TipiEntryImpl}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see TipiEntryImpl
 * @see TipiEntry
 * @generated
 */
public abstract class TipiEntryBaseImpl
	extends TipiEntryModelImpl implements TipiEntry {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tipi entry model instance should use the <code>TipiEntry</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			TipiEntryLocalServiceUtil.addTipiEntry(this);
		}
		else {
			TipiEntryLocalServiceUtil.updateTipiEntry(this);
		}
	}

}