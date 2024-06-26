/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PublicHolidayLocalService}.
 *
 * @author Angelique Zunino Champougny
 * @see PublicHolidayLocalService
 * @generated
 */
public class PublicHolidayLocalServiceWrapper
	implements PublicHolidayLocalService,
			   ServiceWrapper<PublicHolidayLocalService> {

	public PublicHolidayLocalServiceWrapper() {
		this(null);
	}

	public PublicHolidayLocalServiceWrapper(
		PublicHolidayLocalService publicHolidayLocalService) {

		_publicHolidayLocalService = publicHolidayLocalService;
	}

	/**
	 * Adds the public holiday to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublicHolidayLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publicHoliday the public holiday
	 * @return the public holiday that was added
	 */
	@Override
	public eu.strasbourg.service.place.model.PublicHoliday addPublicHoliday(
		eu.strasbourg.service.place.model.PublicHoliday publicHoliday) {

		return _publicHolidayLocalService.addPublicHoliday(publicHoliday);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publicHolidayLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new public holiday with the primary key. Does not add the public holiday to the database.
	 *
	 * @param publicHolidayId the primary key for the new public holiday
	 * @return the new public holiday
	 */
	@Override
	public eu.strasbourg.service.place.model.PublicHoliday createPublicHoliday(
		long publicHolidayId) {

		return _publicHolidayLocalService.createPublicHoliday(publicHolidayId);
	}

	/**
	 * Crée une période vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.place.model.PublicHoliday createPublicHoliday(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publicHolidayLocalService.createPublicHoliday(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publicHolidayLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the public holiday with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublicHolidayLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publicHolidayId the primary key of the public holiday
	 * @return the public holiday that was removed
	 * @throws PortalException if a public holiday with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.place.model.PublicHoliday deletePublicHoliday(
			long publicHolidayId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publicHolidayLocalService.deletePublicHoliday(publicHolidayId);
	}

	/**
	 * Deletes the public holiday from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublicHolidayLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publicHoliday the public holiday
	 * @return the public holiday that was removed
	 */
	@Override
	public eu.strasbourg.service.place.model.PublicHoliday deletePublicHoliday(
		eu.strasbourg.service.place.model.PublicHoliday publicHoliday) {

		return _publicHolidayLocalService.deletePublicHoliday(publicHoliday);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _publicHolidayLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _publicHolidayLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _publicHolidayLocalService.dynamicQuery();
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

		return _publicHolidayLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.PublicHolidayModelImpl</code>.
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

		return _publicHolidayLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.PublicHolidayModelImpl</code>.
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

		return _publicHolidayLocalService.dynamicQuery(
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

		return _publicHolidayLocalService.dynamicQueryCount(dynamicQuery);
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

		return _publicHolidayLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.place.model.PublicHoliday fetchPublicHoliday(
		long publicHolidayId) {

		return _publicHolidayLocalService.fetchPublicHoliday(publicHolidayId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _publicHolidayLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _publicHolidayLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _publicHolidayLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publicHolidayLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the public holiday with the primary key.
	 *
	 * @param publicHolidayId the primary key of the public holiday
	 * @return the public holiday
	 * @throws PortalException if a public holiday with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.place.model.PublicHoliday getPublicHoliday(
			long publicHolidayId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publicHolidayLocalService.getPublicHoliday(publicHolidayId);
	}

	/**
	 * Returns a range of all the public holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @return the range of public holidays
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PublicHoliday>
		getPublicHolidays(int start, int end) {

		return _publicHolidayLocalService.getPublicHolidays(start, end);
	}

	/**
	 * Returns the number of public holidays.
	 *
	 * @return the number of public holidays
	 */
	@Override
	public int getPublicHolidaysCount() {
		return _publicHolidayLocalService.getPublicHolidaysCount();
	}

	/**
	 * Updates the public holiday in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublicHolidayLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publicHoliday the public holiday
	 * @return the public holiday that was updated
	 */
	@Override
	public eu.strasbourg.service.place.model.PublicHoliday updatePublicHoliday(
		eu.strasbourg.service.place.model.PublicHoliday publicHoliday) {

		return _publicHolidayLocalService.updatePublicHoliday(publicHoliday);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _publicHolidayLocalService.getBasePersistence();
	}

	@Override
	public PublicHolidayLocalService getWrappedService() {
		return _publicHolidayLocalService;
	}

	@Override
	public void setWrappedService(
		PublicHolidayLocalService publicHolidayLocalService) {

		_publicHolidayLocalService = publicHolidayLocalService;
	}

	private PublicHolidayLocalService _publicHolidayLocalService;

}