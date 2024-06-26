/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;

/**
 * The extended model base implementation for the Event service. Represents a row in the &quot;agenda_Event&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EventImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see EventImpl
 * @see Event
 * @generated
 */
public abstract class EventBaseImpl extends EventModelImpl implements Event {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a event model instance should use the <code>Event</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			EventLocalServiceUtil.addEvent(this);
		}
		else {
			EventLocalServiceUtil.updateEvent(this);
		}
	}

}