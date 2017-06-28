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

package eu.strasbourg.service.strasbourg.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StrasbourgService}.
 *
 * @author Brian Wing Shun Chan
 * @see StrasbourgService
 * @generated
 */
@ProviderType
public class StrasbourgServiceWrapper implements StrasbourgService,
	ServiceWrapper<StrasbourgService> {
	public StrasbourgServiceWrapper(StrasbourgService strasbourgService) {
		_strasbourgService = strasbourgService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getCopyright(
		long groupId, java.lang.String uuid, java.lang.String language) {
		return _strasbourgService.getCopyright(groupId, uuid, language);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _strasbourgService.getOSGiServiceIdentifier();
	}

	@Override
	public StrasbourgService getWrappedService() {
		return _strasbourgService;
	}

	@Override
	public void setWrappedService(StrasbourgService strasbourgService) {
		_strasbourgService = strasbourgService;
	}

	private StrasbourgService _strasbourgService;
}