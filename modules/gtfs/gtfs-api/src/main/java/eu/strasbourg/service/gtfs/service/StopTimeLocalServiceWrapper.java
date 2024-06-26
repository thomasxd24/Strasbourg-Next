/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link StopTimeLocalService}.
 *
 * @author Cedric Henry
 * @see StopTimeLocalService
 * @generated
 */
public class StopTimeLocalServiceWrapper
	implements ServiceWrapper<StopTimeLocalService>, StopTimeLocalService {

	public StopTimeLocalServiceWrapper() {
		this(null);
	}

	public StopTimeLocalServiceWrapper(
		StopTimeLocalService stopTimeLocalService) {

		_stopTimeLocalService = stopTimeLocalService;
	}

	/**
	 * Adds the stop time to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StopTimeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stopTime the stop time
	 * @return the stop time that was added
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.StopTime addStopTime(
		eu.strasbourg.service.gtfs.model.StopTime stopTime) {

		return _stopTimeLocalService.addStopTime(stopTime);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stopTimeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new stop time with the primary key. Does not add the stop time to the database.
	 *
	 * @param id the primary key for the new stop time
	 * @return the new stop time
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.StopTime createStopTime(long id) {
		return _stopTimeLocalService.createStopTime(id);
	}

	/**
	 * Crée un StopTime vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.StopTime createStopTime(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stopTimeLocalService.createStopTime(sc);
	}

	/**
	 * Crée un temps d'arret à partir d'une entrée GTFS
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.StopTime createStopTimeFromGTFS(
			eu.strasbourg.utils.models.StopTimesGTFS entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stopTimeLocalService.createStopTimeFromGTFS(entry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stopTimeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the stop time with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StopTimeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the stop time
	 * @return the stop time that was removed
	 * @throws PortalException if a stop time with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.StopTime deleteStopTime(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stopTimeLocalService.deleteStopTime(id);
	}

	/**
	 * Deletes the stop time from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StopTimeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stopTime the stop time
	 * @return the stop time that was removed
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.StopTime deleteStopTime(
		eu.strasbourg.service.gtfs.model.StopTime stopTime) {

		return _stopTimeLocalService.deleteStopTime(stopTime);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _stopTimeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _stopTimeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stopTimeLocalService.dynamicQuery();
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

		return _stopTimeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.StopTimeModelImpl</code>.
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

		return _stopTimeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.StopTimeModelImpl</code>.
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

		return _stopTimeLocalService.dynamicQuery(
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

		return _stopTimeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _stopTimeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.gtfs.model.StopTime fetchStopTime(long id) {
		return _stopTimeLocalService.fetchStopTime(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stopTimeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stopTimeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stopTimeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stopTimeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the stop time with the primary key.
	 *
	 * @param id the primary key of the stop time
	 * @return the stop time
	 * @throws PortalException if a stop time with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.StopTime getStopTime(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stopTimeLocalService.getStopTime(id);
	}

	/**
	 * Returns a range of all the stop times.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @return the range of stop times
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.StopTime>
		getStopTimes(int start, int end) {

		return _stopTimeLocalService.getStopTimes(start, end);
	}

	/**
	 * Returns the number of stop times.
	 *
	 * @return the number of stop times
	 */
	@Override
	public int getStopTimesCount() {
		return _stopTimeLocalService.getStopTimesCount();
	}

	/**
	 * Import des temps d'arret de calendrier sous le format de données GTFS
	 */
	@Override
	public void importFromGTFS(
			java.util.Map
				<String,
				 java.util.List<eu.strasbourg.utils.models.StopTimesGTFS>> data)
		throws com.liferay.portal.kernel.exception.PortalException {

		_stopTimeLocalService.importFromGTFS(data);
	}

	/**
	 * Supprime toutes le StopTime
	 */
	@Override
	public void removeAllStopTimes()
		throws com.liferay.portal.kernel.exception.PortalException {

		_stopTimeLocalService.removeAllStopTimes();
	}

	/**
	 * Supprime un StopTime
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.StopTime removeStopTime(
			long stopTimeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stopTimeLocalService.removeStopTime(stopTimeId);
	}

	/**
	 * Updates the stop time in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StopTimeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stopTime the stop time
	 * @return the stop time that was updated
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.StopTime updateStopTime(
		eu.strasbourg.service.gtfs.model.StopTime stopTime) {

		return _stopTimeLocalService.updateStopTime(stopTime);
	}

	/**
	 * Met à jour un StopTime et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.StopTime updateStopTime(
			eu.strasbourg.service.gtfs.model.StopTime stopTime,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stopTimeLocalService.updateStopTime(stopTime, sc);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _stopTimeLocalService.getBasePersistence();
	}

	@Override
	public StopTimeLocalService getWrappedService() {
		return _stopTimeLocalService;
	}

	@Override
	public void setWrappedService(StopTimeLocalService stopTimeLocalService) {
		_stopTimeLocalService = stopTimeLocalService;
	}

	private StopTimeLocalService _stopTimeLocalService;

}