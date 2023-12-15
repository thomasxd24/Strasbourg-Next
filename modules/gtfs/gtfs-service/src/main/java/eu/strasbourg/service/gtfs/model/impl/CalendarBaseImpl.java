/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model.impl;

import eu.strasbourg.service.gtfs.model.Calendar;
import eu.strasbourg.service.gtfs.service.CalendarLocalServiceUtil;

/**
 * The extended model base implementation for the Calendar service. Represents a row in the &quot;gtfs_Calendar&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CalendarImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see CalendarImpl
 * @see Calendar
 * @generated
 */
public abstract class CalendarBaseImpl
	extends CalendarModelImpl implements Calendar {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a calendar model instance should use the <code>Calendar</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CalendarLocalServiceUtil.addCalendar(this);
		}
		else {
			CalendarLocalServiceUtil.updateCalendar(this);
		}
	}

}