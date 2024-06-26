/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model.impl;

import eu.strasbourg.service.activity.model.ActivityCourseSchedule;
import eu.strasbourg.service.activity.service.ActivityCourseScheduleLocalServiceUtil;

/**
 * The extended model base implementation for the ActivityCourseSchedule service. Represents a row in the &quot;activity_ActivityCourseSchedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ActivityCourseScheduleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourseScheduleImpl
 * @see ActivityCourseSchedule
 * @generated
 */
public abstract class ActivityCourseScheduleBaseImpl
	extends ActivityCourseScheduleModelImpl implements ActivityCourseSchedule {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a activity course schedule model instance should use the <code>ActivityCourseSchedule</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			ActivityCourseScheduleLocalServiceUtil.addActivityCourseSchedule(
				this);
		}
		else {
			ActivityCourseScheduleLocalServiceUtil.updateActivityCourseSchedule(
				this);
		}
	}

}