/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.project.model.impl;

import eu.strasbourg.service.project.model.BudgetSupport;
import eu.strasbourg.service.project.service.BudgetSupportLocalServiceUtil;

/**
 * The extended model base implementation for the BudgetSupport service. Represents a row in the &quot;project_BudgetSupport&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BudgetSupportImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see BudgetSupportImpl
 * @see BudgetSupport
 * @generated
 */
public abstract class BudgetSupportBaseImpl
	extends BudgetSupportModelImpl implements BudgetSupport {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a budget support model instance should use the <code>BudgetSupport</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			BudgetSupportLocalServiceUtil.addBudgetSupport(this);
		}
		else {
			BudgetSupportLocalServiceUtil.updateBudgetSupport(this);
		}
	}

}