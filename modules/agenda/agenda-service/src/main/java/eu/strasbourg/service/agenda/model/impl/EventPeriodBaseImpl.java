/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import eu.strasbourg.service.agenda.model.EventPeriod;
import eu.strasbourg.service.agenda.service.EventPeriodLocalServiceUtil;

/**
 * The extended model base implementation for the EventPeriod service. Represents a row in the &quot;agenda_EventPeriod&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EventPeriodImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see EventPeriodImpl
 * @see EventPeriod
 * @generated
 */
public abstract class EventPeriodBaseImpl
	extends EventPeriodModelImpl implements EventPeriod {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a event period model instance should use the <code>EventPeriod</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			EventPeriodLocalServiceUtil.addEventPeriod(this);
		}
		else {
			EventPeriodLocalServiceUtil.updateEventPeriod(this);
		}
	}

}