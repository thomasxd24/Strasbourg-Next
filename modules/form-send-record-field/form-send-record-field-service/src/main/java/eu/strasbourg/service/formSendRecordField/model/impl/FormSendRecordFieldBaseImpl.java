/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.formSendRecordField.model.impl;

import eu.strasbourg.service.formSendRecordField.model.FormSendRecordField;
import eu.strasbourg.service.formSendRecordField.service.FormSendRecordFieldLocalServiceUtil;

/**
 * The extended model base implementation for the FormSendRecordField service. Represents a row in the &quot;formSendRecordField_FormSendRecordField&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FormSendRecordFieldImpl}.
 * </p>
 *
 * @author Angélique Zunino
 * @see FormSendRecordFieldImpl
 * @see FormSendRecordField
 * @generated
 */
public abstract class FormSendRecordFieldBaseImpl
	extends FormSendRecordFieldModelImpl implements FormSendRecordField {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a form send record field model instance should use the <code>FormSendRecordField</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			FormSendRecordFieldLocalServiceUtil.addFormSendRecordField(this);
		}
		else {
			FormSendRecordFieldLocalServiceUtil.updateFormSendRecordField(this);
		}
	}

}