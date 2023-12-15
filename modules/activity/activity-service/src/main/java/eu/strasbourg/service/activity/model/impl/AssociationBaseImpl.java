/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model.impl;

import eu.strasbourg.service.activity.model.Association;
import eu.strasbourg.service.activity.service.AssociationLocalServiceUtil;

/**
 * The extended model base implementation for the Association service. Represents a row in the &quot;activity_Association&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AssociationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssociationImpl
 * @see Association
 * @generated
 */
public abstract class AssociationBaseImpl
	extends AssociationModelImpl implements Association {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a association model instance should use the <code>Association</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			AssociationLocalServiceUtil.addAssociation(this);
		}
		else {
			AssociationLocalServiceUtil.updateAssociation(this);
		}
	}

}