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

package eu.strasbourg.service.csmap.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.csmap.model.RefreshToken;
import eu.strasbourg.service.csmap.service.RefreshTokenLocalService;
import eu.strasbourg.service.csmap.service.base.RefreshTokenLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the refresh token local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>eu.strasbourg.service.csmap.service.RefreshTokenLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RefreshTokenLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=eu.strasbourg.service.csmap.model.RefreshToken",
	service = AopService.class
)
public class RefreshTokenLocalServiceImpl extends RefreshTokenLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>eu.strasbourg.service.csmap.service.RefreshTokenLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>eu.strasbourg.service.csmap.service.RefreshTokenLocalServiceUtil</code>.
	 */

	public final static Log log = LogFactoryUtil.getLog(RefreshTokenLocalServiceImpl.class);

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public RefreshToken createRefreshToken(ServiceContext sc) throws PortalException {
		long pk = counterLocalService.increment();
		return refreshTokenLocalService.createRefreshToken(pk);
	}



}