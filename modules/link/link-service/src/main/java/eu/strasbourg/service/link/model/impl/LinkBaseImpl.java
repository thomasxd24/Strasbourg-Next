/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.link.model.impl;

import eu.strasbourg.service.link.model.Link;
import eu.strasbourg.service.link.service.LinkLocalServiceUtil;

/**
 * The extended model base implementation for the Link service. Represents a row in the &quot;link_Link&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LinkImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see LinkImpl
 * @see Link
 * @generated
 */
public abstract class LinkBaseImpl extends LinkModelImpl implements Link {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a link model instance should use the <code>Link</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			LinkLocalServiceUtil.addLink(this);
		}
		else {
			LinkLocalServiceUtil.updateLink(this);
		}
	}

}