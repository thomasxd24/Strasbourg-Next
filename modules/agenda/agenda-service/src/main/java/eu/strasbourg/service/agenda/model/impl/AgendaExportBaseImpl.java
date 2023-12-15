/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import eu.strasbourg.service.agenda.model.AgendaExport;
import eu.strasbourg.service.agenda.service.AgendaExportLocalServiceUtil;

/**
 * The extended model base implementation for the AgendaExport service. Represents a row in the &quot;agenda_AgendaExport&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AgendaExportImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see AgendaExportImpl
 * @see AgendaExport
 * @generated
 */
public abstract class AgendaExportBaseImpl
	extends AgendaExportModelImpl implements AgendaExport {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a agenda export model instance should use the <code>AgendaExport</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			AgendaExportLocalServiceUtil.addAgendaExport(this);
		}
		else {
			AgendaExportLocalServiceUtil.updateAgendaExport(this);
		}
	}

}