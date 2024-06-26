/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model.impl;

import eu.strasbourg.service.csmap.model.Thematic;
import eu.strasbourg.service.csmap.service.ThematicLocalServiceUtil;

/**
 * The extended model base implementation for the Thematic service. Represents a row in the &quot;csmap_Thematic&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ThematicImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThematicImpl
 * @see Thematic
 * @generated
 */
public abstract class ThematicBaseImpl
	extends ThematicModelImpl implements Thematic {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a thematic model instance should use the <code>Thematic</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			ThematicLocalServiceUtil.addThematic(this);
		}
		else {
			ThematicLocalServiceUtil.updateThematic(this);
		}
	}

}