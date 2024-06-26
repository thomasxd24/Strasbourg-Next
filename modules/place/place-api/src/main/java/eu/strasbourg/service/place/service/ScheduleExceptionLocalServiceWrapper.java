/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ScheduleExceptionLocalService}.
 *
 * @author Angelique Zunino Champougny
 * @see ScheduleExceptionLocalService
 * @generated
 */
public class ScheduleExceptionLocalServiceWrapper
	implements ScheduleExceptionLocalService,
			   ServiceWrapper<ScheduleExceptionLocalService> {

	public ScheduleExceptionLocalServiceWrapper() {
		this(null);
	}

	public ScheduleExceptionLocalServiceWrapper(
		ScheduleExceptionLocalService scheduleExceptionLocalService) {

		_scheduleExceptionLocalService = scheduleExceptionLocalService;
	}

	/**
	 * Adds the schedule exception to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ScheduleExceptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param scheduleException the schedule exception
	 * @return the schedule exception that was added
	 */
	@Override
	public eu.strasbourg.service.place.model.ScheduleException
		addScheduleException(
			eu.strasbourg.service.place.model.ScheduleException
				scheduleException) {

		return _scheduleExceptionLocalService.addScheduleException(
			scheduleException);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _scheduleExceptionLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new schedule exception with the primary key. Does not add the schedule exception to the database.
	 *
	 * @param exceptionId the primary key for the new schedule exception
	 * @return the new schedule exception
	 */
	@Override
	public eu.strasbourg.service.place.model.ScheduleException
		createScheduleException(long exceptionId) {

		return _scheduleExceptionLocalService.createScheduleException(
			exceptionId);
	}

	/**
	 * Crée une exception vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.place.model.ScheduleException
			createScheduleException(
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _scheduleExceptionLocalService.createScheduleException(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _scheduleExceptionLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the schedule exception with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ScheduleExceptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param exceptionId the primary key of the schedule exception
	 * @return the schedule exception that was removed
	 * @throws PortalException if a schedule exception with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.place.model.ScheduleException
			deleteScheduleException(long exceptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _scheduleExceptionLocalService.deleteScheduleException(
			exceptionId);
	}

	/**
	 * Deletes the schedule exception from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ScheduleExceptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param scheduleException the schedule exception
	 * @return the schedule exception that was removed
	 */
	@Override
	public eu.strasbourg.service.place.model.ScheduleException
		deleteScheduleException(
			eu.strasbourg.service.place.model.ScheduleException
				scheduleException) {

		return _scheduleExceptionLocalService.deleteScheduleException(
			scheduleException);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _scheduleExceptionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _scheduleExceptionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _scheduleExceptionLocalService.dynamicQuery();
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

		return _scheduleExceptionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.ScheduleExceptionModelImpl</code>.
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

		return _scheduleExceptionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.ScheduleExceptionModelImpl</code>.
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

		return _scheduleExceptionLocalService.dynamicQuery(
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

		return _scheduleExceptionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _scheduleExceptionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.place.model.ScheduleException
		fetchScheduleException(long exceptionId) {

		return _scheduleExceptionLocalService.fetchScheduleException(
			exceptionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _scheduleExceptionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Retourne les ScheduleException rattachés à un lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.ScheduleException>
		getByPlaceId(long placeId) {

		return _scheduleExceptionLocalService.getByPlaceId(placeId);
	}

	/**
	 * Retourne les ScheduleException rattachés à un sous-lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.ScheduleException>
		getBySubPlaceId(long subPlaceId) {

		return _scheduleExceptionLocalService.getBySubPlaceId(subPlaceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _scheduleExceptionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _scheduleExceptionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _scheduleExceptionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the schedule exception with the primary key.
	 *
	 * @param exceptionId the primary key of the schedule exception
	 * @return the schedule exception
	 * @throws PortalException if a schedule exception with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.place.model.ScheduleException
			getScheduleException(long exceptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _scheduleExceptionLocalService.getScheduleException(exceptionId);
	}

	/**
	 * Returns a range of all the schedule exceptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @return the range of schedule exceptions
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.ScheduleException>
		getScheduleExceptions(int start, int end) {

		return _scheduleExceptionLocalService.getScheduleExceptions(start, end);
	}

	/**
	 * Returns the number of schedule exceptions.
	 *
	 * @return the number of schedule exceptions
	 */
	@Override
	public int getScheduleExceptionsCount() {
		return _scheduleExceptionLocalService.getScheduleExceptionsCount();
	}

	/**
	 * Updates the schedule exception in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ScheduleExceptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param scheduleException the schedule exception
	 * @return the schedule exception that was updated
	 */
	@Override
	public eu.strasbourg.service.place.model.ScheduleException
		updateScheduleException(
			eu.strasbourg.service.place.model.ScheduleException
				scheduleException) {

		return _scheduleExceptionLocalService.updateScheduleException(
			scheduleException);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _scheduleExceptionLocalService.getBasePersistence();
	}

	@Override
	public ScheduleExceptionLocalService getWrappedService() {
		return _scheduleExceptionLocalService;
	}

	@Override
	public void setWrappedService(
		ScheduleExceptionLocalService scheduleExceptionLocalService) {

		_scheduleExceptionLocalService = scheduleExceptionLocalService;
	}

	private ScheduleExceptionLocalService _scheduleExceptionLocalService;

}