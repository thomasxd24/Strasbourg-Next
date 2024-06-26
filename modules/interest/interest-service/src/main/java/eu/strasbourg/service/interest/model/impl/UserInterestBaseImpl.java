/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.interest.model.impl;

import eu.strasbourg.service.interest.model.UserInterest;
import eu.strasbourg.service.interest.service.UserInterestLocalServiceUtil;

/**
 * The extended model base implementation for the UserInterest service. Represents a row in the &quot;interest_UserInterest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserInterestImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see UserInterestImpl
 * @see UserInterest
 * @generated
 */
public abstract class UserInterestBaseImpl
	extends UserInterestModelImpl implements UserInterest {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user interest model instance should use the <code>UserInterest</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			UserInterestLocalServiceUtil.addUserInterest(this);
		}
		else {
			UserInterestLocalServiceUtil.updateUserInterest(this);
		}
	}

}