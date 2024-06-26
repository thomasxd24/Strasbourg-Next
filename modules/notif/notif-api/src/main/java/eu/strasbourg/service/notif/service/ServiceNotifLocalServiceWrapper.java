/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notif.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ServiceNotifLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceNotifLocalService
 * @generated
 */
public class ServiceNotifLocalServiceWrapper
	implements ServiceNotifLocalService,
			   ServiceWrapper<ServiceNotifLocalService> {

	public ServiceNotifLocalServiceWrapper() {
		this(null);
	}

	public ServiceNotifLocalServiceWrapper(
		ServiceNotifLocalService serviceNotifLocalService) {

		_serviceNotifLocalService = serviceNotifLocalService;
	}

	/**
	 * Adds the service notif to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceNotifLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceNotif the service notif
	 * @return the service notif that was added
	 */
	@Override
	public eu.strasbourg.service.notif.model.ServiceNotif addServiceNotif(
		eu.strasbourg.service.notif.model.ServiceNotif serviceNotif) {

		return _serviceNotifLocalService.addServiceNotif(serviceNotif);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceNotifLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Crée un service vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.notif.model.ServiceNotif createService() {
		return _serviceNotifLocalService.createService();
	}

	/**
	 * Creates a new service notif with the primary key. Does not add the service notif to the database.
	 *
	 * @param serviceId the primary key for the new service notif
	 * @return the new service notif
	 */
	@Override
	public eu.strasbourg.service.notif.model.ServiceNotif createServiceNotif(
		long serviceId) {

		return _serviceNotifLocalService.createServiceNotif(serviceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceNotifLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the service notif with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceNotifLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceId the primary key of the service notif
	 * @return the service notif that was removed
	 * @throws PortalException if a service notif with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.notif.model.ServiceNotif deleteServiceNotif(
			long serviceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceNotifLocalService.deleteServiceNotif(serviceId);
	}

	/**
	 * Deletes the service notif from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceNotifLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceNotif the service notif
	 * @return the service notif that was removed
	 */
	@Override
	public eu.strasbourg.service.notif.model.ServiceNotif deleteServiceNotif(
		eu.strasbourg.service.notif.model.ServiceNotif serviceNotif) {

		return _serviceNotifLocalService.deleteServiceNotif(serviceNotif);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _serviceNotifLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _serviceNotifLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceNotifLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _serviceNotifLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notif.model.impl.ServiceNotifModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _serviceNotifLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notif.model.impl.ServiceNotifModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _serviceNotifLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _serviceNotifLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _serviceNotifLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.notif.model.ServiceNotif fetchServiceNotif(
		long serviceId) {

		return _serviceNotifLocalService.fetchServiceNotif(serviceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _serviceNotifLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<eu.strasbourg.service.notif.model.ServiceNotif>
		getByOrganisationIds(long[] organisationIds) {

		return _serviceNotifLocalService.getByOrganisationIds(organisationIds);
	}

	@Override
	public eu.strasbourg.service.notif.model.ServiceNotif getByTopic(
			String topic)
		throws eu.strasbourg.service.notif.exception.
			NoSuchServiceNotifException {

		return _serviceNotifLocalService.getByTopic(topic);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _serviceNotifLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _serviceNotifLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceNotifLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the service notif with the primary key.
	 *
	 * @param serviceId the primary key of the service notif
	 * @return the service notif
	 * @throws PortalException if a service notif with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.notif.model.ServiceNotif getServiceNotif(
			long serviceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _serviceNotifLocalService.getServiceNotif(serviceId);
	}

	/**
	 * Returns a range of all the service notifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notif.model.impl.ServiceNotifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service notifs
	 * @param end the upper bound of the range of service notifs (not inclusive)
	 * @return the range of service notifs
	 */
	@Override
	public java.util.List<eu.strasbourg.service.notif.model.ServiceNotif>
		getServiceNotifs(int start, int end) {

		return _serviceNotifLocalService.getServiceNotifs(start, end);
	}

	/**
	 * Returns the number of service notifs.
	 *
	 * @return the number of service notifs
	 */
	@Override
	public int getServiceNotifsCount() {
		return _serviceNotifLocalService.getServiceNotifsCount();
	}

	/**
	 * Supprime un service
	 */
	@Override
	public void removeService(long serviceId) {
		_serviceNotifLocalService.removeService(serviceId);
	}

	/**
	 * Updates the service notif in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceNotifLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceNotif the service notif
	 * @return the service notif that was updated
	 */
	@Override
	public eu.strasbourg.service.notif.model.ServiceNotif updateServiceNotif(
		eu.strasbourg.service.notif.model.ServiceNotif serviceNotif) {

		return _serviceNotifLocalService.updateServiceNotif(serviceNotif);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _serviceNotifLocalService.getBasePersistence();
	}

	@Override
	public ServiceNotifLocalService getWrappedService() {
		return _serviceNotifLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceNotifLocalService serviceNotifLocalService) {

		_serviceNotifLocalService = serviceNotifLocalService;
	}

	private ServiceNotifLocalService _serviceNotifLocalService;

}