/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import eu.strasbourg.service.agenda.model.CampaignEventStatus;
import eu.strasbourg.service.agenda.service.CampaignEventStatusLocalServiceUtil;

/**
 * The extended model base implementation for the CampaignEventStatus service. Represents a row in the &quot;agenda_CampaignEventStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CampaignEventStatusImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see CampaignEventStatusImpl
 * @see CampaignEventStatus
 * @generated
 */
public abstract class CampaignEventStatusBaseImpl
	extends CampaignEventStatusModelImpl implements CampaignEventStatus {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a campaign event status model instance should use the <code>CampaignEventStatus</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CampaignEventStatusLocalServiceUtil.addCampaignEventStatus(this);
		}
		else {
			CampaignEventStatusLocalServiceUtil.updateCampaignEventStatus(this);
		}
	}

}