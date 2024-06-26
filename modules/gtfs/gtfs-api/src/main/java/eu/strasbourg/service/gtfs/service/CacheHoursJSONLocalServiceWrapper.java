/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CacheHoursJSONLocalService}.
 *
 * @author Cedric Henry
 * @see CacheHoursJSONLocalService
 * @generated
 */
public class CacheHoursJSONLocalServiceWrapper
	implements CacheHoursJSONLocalService,
			   ServiceWrapper<CacheHoursJSONLocalService> {

	public CacheHoursJSONLocalServiceWrapper() {
		this(null);
	}

	public CacheHoursJSONLocalServiceWrapper(
		CacheHoursJSONLocalService cacheHoursJSONLocalService) {

		_cacheHoursJSONLocalService = cacheHoursJSONLocalService;
	}

	/**
	 * Adds the cache hours json to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheHoursJSONLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheHoursJSON the cache hours json
	 * @return the cache hours json that was added
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheHoursJSON addCacheHoursJSON(
		eu.strasbourg.service.gtfs.model.CacheHoursJSON cacheHoursJSON) {

		return _cacheHoursJSONLocalService.addCacheHoursJSON(cacheHoursJSON);
	}

	/**
	 * Creates a new cache hours json with the primary key. Does not add the cache hours json to the database.
	 *
	 * @param cacheHoursJSONPK the primary key for the new cache hours json
	 * @return the new cache hours json
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheHoursJSON createCacheHoursJSON(
		eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPK
			cacheHoursJSONPK) {

		return _cacheHoursJSONLocalService.createCacheHoursJSON(
			cacheHoursJSONPK);
	}

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheHoursJSON createCacheHoursJSON(
		String stopCode, int type) {

		return _cacheHoursJSONLocalService.createCacheHoursJSON(stopCode, type);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheHoursJSONLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the cache hours json from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheHoursJSONLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheHoursJSON the cache hours json
	 * @return the cache hours json that was removed
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheHoursJSON deleteCacheHoursJSON(
		eu.strasbourg.service.gtfs.model.CacheHoursJSON cacheHoursJSON) {

		return _cacheHoursJSONLocalService.deleteCacheHoursJSON(cacheHoursJSON);
	}

	/**
	 * Deletes the cache hours json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheHoursJSONLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheHoursJSONPK the primary key of the cache hours json
	 * @return the cache hours json that was removed
	 * @throws PortalException if a cache hours json with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheHoursJSON deleteCacheHoursJSON(
			eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPK
				cacheHoursJSONPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheHoursJSONLocalService.deleteCacheHoursJSON(
			cacheHoursJSONPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheHoursJSONLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _cacheHoursJSONLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _cacheHoursJSONLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cacheHoursJSONLocalService.dynamicQuery();
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

		return _cacheHoursJSONLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CacheHoursJSONModelImpl</code>.
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

		return _cacheHoursJSONLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CacheHoursJSONModelImpl</code>.
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

		return _cacheHoursJSONLocalService.dynamicQuery(
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

		return _cacheHoursJSONLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cacheHoursJSONLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	/**
	 * Retourne le cache d'un arret et type
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheHoursJSON
		fetchByStopCodeAndType(String stopCode, int type) {

		return _cacheHoursJSONLocalService.fetchByStopCodeAndType(
			stopCode, type);
	}

	@Override
	public eu.strasbourg.service.gtfs.model.CacheHoursJSON fetchCacheHoursJSON(
		eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPK
			cacheHoursJSONPK) {

		return _cacheHoursJSONLocalService.fetchCacheHoursJSON(
			cacheHoursJSONPK);
	}

	/**
	 * Returns the cache hours json with the primary key.
	 *
	 * @param cacheHoursJSONPK the primary key of the cache hours json
	 * @return the cache hours json
	 * @throws PortalException if a cache hours json with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheHoursJSON getCacheHoursJSON(
			eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPK
				cacheHoursJSONPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheHoursJSONLocalService.getCacheHoursJSON(cacheHoursJSONPK);
	}

	/**
	 * Returns a range of all the cache hours jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @return the range of cache hours jsons
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.CacheHoursJSON>
		getCacheHoursJSONs(int start, int end) {

		return _cacheHoursJSONLocalService.getCacheHoursJSONs(start, end);
	}

	/**
	 * Returns the number of cache hours jsons.
	 *
	 * @return the number of cache hours jsons
	 */
	@Override
	public int getCacheHoursJSONsCount() {
		return _cacheHoursJSONLocalService.getCacheHoursJSONsCount();
	}

	/**
	 * Met à jour le jsonHour du stop
	 */
	@Override
	public String getJsonHour(String stopCode, int type, int timeOut) {
		return _cacheHoursJSONLocalService.getJsonHour(stopCode, type, timeOut);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cacheHoursJSONLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheHoursJSONLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cache hours json in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheHoursJSONLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheHoursJSON the cache hours json
	 * @return the cache hours json that was updated
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheHoursJSON updateCacheHoursJSON(
		eu.strasbourg.service.gtfs.model.CacheHoursJSON cacheHoursJSON) {

		return _cacheHoursJSONLocalService.updateCacheHoursJSON(cacheHoursJSON);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _cacheHoursJSONLocalService.getBasePersistence();
	}

	@Override
	public CacheHoursJSONLocalService getWrappedService() {
		return _cacheHoursJSONLocalService;
	}

	@Override
	public void setWrappedService(
		CacheHoursJSONLocalService cacheHoursJSONLocalService) {

		_cacheHoursJSONLocalService = cacheHoursJSONLocalService;
	}

	private CacheHoursJSONLocalService _cacheHoursJSONLocalService;

}