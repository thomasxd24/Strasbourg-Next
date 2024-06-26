/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link RouteLocalService}.
 *
 * @author Cedric Henry
 * @see RouteLocalService
 * @generated
 */
public class RouteLocalServiceWrapper
	implements RouteLocalService, ServiceWrapper<RouteLocalService> {

	public RouteLocalServiceWrapper() {
		this(null);
	}

	public RouteLocalServiceWrapper(RouteLocalService routeLocalService) {
		_routeLocalService = routeLocalService;
	}

	/**
	 * Adds the route to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RouteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param route the route
	 * @return the route that was added
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Route addRoute(
		eu.strasbourg.service.gtfs.model.Route route) {

		return _routeLocalService.addRoute(route);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _routeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new route with the primary key. Does not add the route to the database.
	 *
	 * @param id the primary key for the new route
	 * @return the new route
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Route createRoute(long id) {
		return _routeLocalService.createRoute(id);
	}

	/**
	 * Crée une Route vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Route createRoute(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _routeLocalService.createRoute(sc);
	}

	/**
	 * Crée un Route à partir d'une entrée GTFS
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Route createRouteFromGTFS(
			eu.strasbourg.utils.models.RoutesGTFS entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _routeLocalService.createRouteFromGTFS(entry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _routeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the route with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RouteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the route
	 * @return the route that was removed
	 * @throws PortalException if a route with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Route deleteRoute(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _routeLocalService.deleteRoute(id);
	}

	/**
	 * Deletes the route from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RouteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param route the route
	 * @return the route that was removed
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Route deleteRoute(
		eu.strasbourg.service.gtfs.model.Route route) {

		return _routeLocalService.deleteRoute(route);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _routeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _routeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _routeLocalService.dynamicQuery();
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

		return _routeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.RouteModelImpl</code>.
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

		return _routeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.RouteModelImpl</code>.
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

		return _routeLocalService.dynamicQuery(
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

		return _routeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _routeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.gtfs.model.Route fetchRoute(long id) {
		return _routeLocalService.fetchRoute(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _routeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Recuperer toutes les lignes
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Route>
		getAllRoutes() {

		return _routeLocalService.getAllRoutes();
	}

	/**
	 * Recuperer une ligne via son routeId
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Route getByRouteId(String routeId) {
		return _routeLocalService.getByRouteId(routeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _routeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _routeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _routeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the route with the primary key.
	 *
	 * @param id the primary key of the route
	 * @return the route
	 * @throws PortalException if a route with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Route getRoute(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _routeLocalService.getRoute(id);
	}

	/**
	 * Returns a range of all the routes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.RouteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of routes
	 * @param end the upper bound of the range of routes (not inclusive)
	 * @return the range of routes
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Route> getRoutes(
		int start, int end) {

		return _routeLocalService.getRoutes(start, end);
	}

	/**
	 * Returns the number of routes.
	 *
	 * @return the number of routes
	 */
	@Override
	public int getRoutesCount() {
		return _routeLocalService.getRoutesCount();
	}

	/**
	 * Import des lignes sous le format de données GTFS
	 */
	@Override
	public void importFromGTFS(
			java.util.Map<String, eu.strasbourg.utils.models.RoutesGTFS> data)
		throws com.liferay.portal.kernel.exception.PortalException {

		_routeLocalService.importFromGTFS(data);
	}

	/**
	 * Supprime toutes les Routes
	 */
	@Override
	public void removeAllRoutes()
		throws com.liferay.portal.kernel.exception.PortalException {

		_routeLocalService.removeAllRoutes();
	}

	/**
	 * Supprime une Route
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Route removeRoute(long routeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _routeLocalService.removeRoute(routeId);
	}

	/**
	 * Updates the route in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RouteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param route the route
	 * @return the route that was updated
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Route updateRoute(
		eu.strasbourg.service.gtfs.model.Route route) {

		return _routeLocalService.updateRoute(route);
	}

	/**
	 * Met à jour une Route et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Route updateRoute(
			eu.strasbourg.service.gtfs.model.Route route,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _routeLocalService.updateRoute(route, sc);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _routeLocalService.getBasePersistence();
	}

	@Override
	public RouteLocalService getWrappedService() {
		return _routeLocalService;
	}

	@Override
	public void setWrappedService(RouteLocalService routeLocalService) {
		_routeLocalService = routeLocalService;
	}

	private RouteLocalService _routeLocalService;

}