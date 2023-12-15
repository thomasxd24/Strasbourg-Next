/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model.impl;

import eu.strasbourg.service.activity.model.Practice;
import eu.strasbourg.service.activity.service.PracticeLocalServiceUtil;

/**
 * The extended model base implementation for the Practice service. Represents a row in the &quot;activity_Practice&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PracticeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PracticeImpl
 * @see Practice
 * @generated
 */
public abstract class PracticeBaseImpl
	extends PracticeModelImpl implements Practice {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a practice model instance should use the <code>Practice</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			PracticeLocalServiceUtil.addPractice(this);
		}
		else {
			PracticeLocalServiceUtil.updatePractice(this);
		}
	}

}