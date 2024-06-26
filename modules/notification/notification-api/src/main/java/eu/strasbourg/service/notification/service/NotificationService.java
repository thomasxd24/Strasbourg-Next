/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Notification. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author BenjaminBini
 * @see NotificationServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=notification",
		"json.web.service.context.path=Notification"
	},
	service = NotificationService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface NotificationService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.notification.service.impl.NotificationServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the notification remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link NotificationServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Envoie une notification à un utilisateur
	 */
	public JSONObject addNotification(
		String userId, boolean isGlobal, String title, String description,
		String url, String publicationDate, String expirationDate,
		String typeId);

	/**
	 * Retourne la liste des canaux de notifications
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getChannels();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Retourne la liste des types de notifications
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getTypes() throws PortalException;

	/**
	 * Retourne la liste des notifications d'un utilisateur
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getUserNotifications(String userId);

	/**
	 * Retourne la liste des types et des canaux de communication d'un
	 * utilisateur
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getUserSettings(String userId);

	/**
	 * Modification des abonnements et des canaux de communication d'un
	 * utilisateur
	 */
	public JSONObject setUserSettings(
		String userId, String typeIds, String channelIds);

}