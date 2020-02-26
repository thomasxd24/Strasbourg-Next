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

package eu.strasbourg.service.formSendRecordField.model.impl;

import aQute.bnd.annotation.ProviderType;

import eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement;
import eu.strasbourg.service.formSendRecordField.service.FormSendRecordFieldSignalementLocalServiceUtil;

/**
 * The extended model base implementation for the FormSendRecordFieldSignalement service. Represents a row in the &quot;formSendRecordField_FormSendRecordFieldSignalement&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FormSendRecordFieldSignalementImpl}.
 * </p>
 *
 * @author Angélique Zunino
 * @see FormSendRecordFieldSignalementImpl
 * @see FormSendRecordFieldSignalement
 * @generated
 */
@ProviderType
public abstract class FormSendRecordFieldSignalementBaseImpl
	extends FormSendRecordFieldSignalementModelImpl
	implements FormSendRecordFieldSignalement {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a form send record field signalement model instance should use the {@link FormSendRecordFieldSignalement} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			FormSendRecordFieldSignalementLocalServiceUtil.addFormSendRecordFieldSignalement(this);
		}
		else {
			FormSendRecordFieldSignalementLocalServiceUtil.updateFormSendRecordFieldSignalement(this);
		}
	}
}