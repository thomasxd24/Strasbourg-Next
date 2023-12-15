/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.gtfs.model.Agency;
import eu.strasbourg.service.gtfs.service.AgencyLocalService;
import eu.strasbourg.service.gtfs.service.AgencyLocalServiceUtil;
import eu.strasbourg.service.gtfs.service.persistence.AgencyPersistence;
import eu.strasbourg.service.gtfs.service.persistence.AlertPersistence;
import eu.strasbourg.service.gtfs.service.persistence.ArretPersistence;
import eu.strasbourg.service.gtfs.service.persistence.CacheAlertJSONPersistence;
import eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPersistence;
import eu.strasbourg.service.gtfs.service.persistence.CalendarDatePersistence;
import eu.strasbourg.service.gtfs.service.persistence.CalendarPersistence;
import eu.strasbourg.service.gtfs.service.persistence.DirectionPersistence;
import eu.strasbourg.service.gtfs.service.persistence.ImportHistoricPersistence;
import eu.strasbourg.service.gtfs.service.persistence.LignePersistence;
import eu.strasbourg.service.gtfs.service.persistence.RoutePersistence;
import eu.strasbourg.service.gtfs.service.persistence.StopPersistence;
import eu.strasbourg.service.gtfs.service.persistence.StopTimePersistence;
import eu.strasbourg.service.gtfs.service.persistence.TripFinder;
import eu.strasbourg.service.gtfs.service.persistence.TripPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the agency local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.gtfs.service.impl.AgencyLocalServiceImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see eu.strasbourg.service.gtfs.service.impl.AgencyLocalServiceImpl
 * @generated
 */
public abstract class AgencyLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AgencyLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AgencyLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AgencyLocalServiceUtil</code>.
	 */

	/**
	 * Adds the agency to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agency the agency
	 * @return the agency that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Agency addAgency(Agency agency) {
		agency.setNew(true);

		return agencyPersistence.update(agency);
	}

	/**
	 * Creates a new agency with the primary key. Does not add the agency to the database.
	 *
	 * @param id the primary key for the new agency
	 * @return the new agency
	 */
	@Override
	@Transactional(enabled = false)
	public Agency createAgency(long id) {
		return agencyPersistence.create(id);
	}

	/**
	 * Deletes the agency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the agency
	 * @return the agency that was removed
	 * @throws PortalException if a agency with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Agency deleteAgency(long id) throws PortalException {
		return agencyPersistence.remove(id);
	}

	/**
	 * Deletes the agency from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agency the agency
	 * @return the agency that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Agency deleteAgency(Agency agency) {
		return agencyPersistence.remove(agency);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return agencyPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Agency.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return agencyPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AgencyModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return agencyPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AgencyModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return agencyPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return agencyPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return agencyPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Agency fetchAgency(long id) {
		return agencyPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the agency with the primary key.
	 *
	 * @param id the primary key of the agency
	 * @return the agency
	 * @throws PortalException if a agency with the primary key could not be found
	 */
	@Override
	public Agency getAgency(long id) throws PortalException {
		return agencyPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(agencyLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Agency.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(agencyLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Agency.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(agencyLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Agency.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return agencyPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement AgencyLocalServiceImpl#deleteAgency(Agency) to avoid orphaned data");
		}

		return agencyLocalService.deleteAgency((Agency)persistedModel);
	}

	@Override
	public BasePersistence<Agency> getBasePersistence() {
		return agencyPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return agencyPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the agencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AgencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agencies
	 * @param end the upper bound of the range of agencies (not inclusive)
	 * @return the range of agencies
	 */
	@Override
	public List<Agency> getAgencies(int start, int end) {
		return agencyPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of agencies.
	 *
	 * @return the number of agencies
	 */
	@Override
	public int getAgenciesCount() {
		return agencyPersistence.countAll();
	}

	/**
	 * Updates the agency in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agency the agency
	 * @return the agency that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Agency updateAgency(Agency agency) {
		return agencyPersistence.update(agency);
	}

	/**
	 * Returns the agency local service.
	 *
	 * @return the agency local service
	 */
	public AgencyLocalService getAgencyLocalService() {
		return agencyLocalService;
	}

	/**
	 * Sets the agency local service.
	 *
	 * @param agencyLocalService the agency local service
	 */
	public void setAgencyLocalService(AgencyLocalService agencyLocalService) {
		this.agencyLocalService = agencyLocalService;
	}

	/**
	 * Returns the agency persistence.
	 *
	 * @return the agency persistence
	 */
	public AgencyPersistence getAgencyPersistence() {
		return agencyPersistence;
	}

	/**
	 * Sets the agency persistence.
	 *
	 * @param agencyPersistence the agency persistence
	 */
	public void setAgencyPersistence(AgencyPersistence agencyPersistence) {
		this.agencyPersistence = agencyPersistence;
	}

	/**
	 * Returns the alert local service.
	 *
	 * @return the alert local service
	 */
	public eu.strasbourg.service.gtfs.service.AlertLocalService
		getAlertLocalService() {

		return alertLocalService;
	}

	/**
	 * Sets the alert local service.
	 *
	 * @param alertLocalService the alert local service
	 */
	public void setAlertLocalService(
		eu.strasbourg.service.gtfs.service.AlertLocalService
			alertLocalService) {

		this.alertLocalService = alertLocalService;
	}

	/**
	 * Returns the alert persistence.
	 *
	 * @return the alert persistence
	 */
	public AlertPersistence getAlertPersistence() {
		return alertPersistence;
	}

	/**
	 * Sets the alert persistence.
	 *
	 * @param alertPersistence the alert persistence
	 */
	public void setAlertPersistence(AlertPersistence alertPersistence) {
		this.alertPersistence = alertPersistence;
	}

	/**
	 * Returns the arret local service.
	 *
	 * @return the arret local service
	 */
	public eu.strasbourg.service.gtfs.service.ArretLocalService
		getArretLocalService() {

		return arretLocalService;
	}

	/**
	 * Sets the arret local service.
	 *
	 * @param arretLocalService the arret local service
	 */
	public void setArretLocalService(
		eu.strasbourg.service.gtfs.service.ArretLocalService
			arretLocalService) {

		this.arretLocalService = arretLocalService;
	}

	/**
	 * Returns the arret persistence.
	 *
	 * @return the arret persistence
	 */
	public ArretPersistence getArretPersistence() {
		return arretPersistence;
	}

	/**
	 * Sets the arret persistence.
	 *
	 * @param arretPersistence the arret persistence
	 */
	public void setArretPersistence(ArretPersistence arretPersistence) {
		this.arretPersistence = arretPersistence;
	}

	/**
	 * Returns the cache alert json local service.
	 *
	 * @return the cache alert json local service
	 */
	public eu.strasbourg.service.gtfs.service.CacheAlertJSONLocalService
		getCacheAlertJSONLocalService() {

		return cacheAlertJSONLocalService;
	}

	/**
	 * Sets the cache alert json local service.
	 *
	 * @param cacheAlertJSONLocalService the cache alert json local service
	 */
	public void setCacheAlertJSONLocalService(
		eu.strasbourg.service.gtfs.service.CacheAlertJSONLocalService
			cacheAlertJSONLocalService) {

		this.cacheAlertJSONLocalService = cacheAlertJSONLocalService;
	}

	/**
	 * Returns the cache alert json persistence.
	 *
	 * @return the cache alert json persistence
	 */
	public CacheAlertJSONPersistence getCacheAlertJSONPersistence() {
		return cacheAlertJSONPersistence;
	}

	/**
	 * Sets the cache alert json persistence.
	 *
	 * @param cacheAlertJSONPersistence the cache alert json persistence
	 */
	public void setCacheAlertJSONPersistence(
		CacheAlertJSONPersistence cacheAlertJSONPersistence) {

		this.cacheAlertJSONPersistence = cacheAlertJSONPersistence;
	}

	/**
	 * Returns the cache hours json local service.
	 *
	 * @return the cache hours json local service
	 */
	public eu.strasbourg.service.gtfs.service.CacheHoursJSONLocalService
		getCacheHoursJSONLocalService() {

		return cacheHoursJSONLocalService;
	}

	/**
	 * Sets the cache hours json local service.
	 *
	 * @param cacheHoursJSONLocalService the cache hours json local service
	 */
	public void setCacheHoursJSONLocalService(
		eu.strasbourg.service.gtfs.service.CacheHoursJSONLocalService
			cacheHoursJSONLocalService) {

		this.cacheHoursJSONLocalService = cacheHoursJSONLocalService;
	}

	/**
	 * Returns the cache hours json persistence.
	 *
	 * @return the cache hours json persistence
	 */
	public CacheHoursJSONPersistence getCacheHoursJSONPersistence() {
		return cacheHoursJSONPersistence;
	}

	/**
	 * Sets the cache hours json persistence.
	 *
	 * @param cacheHoursJSONPersistence the cache hours json persistence
	 */
	public void setCacheHoursJSONPersistence(
		CacheHoursJSONPersistence cacheHoursJSONPersistence) {

		this.cacheHoursJSONPersistence = cacheHoursJSONPersistence;
	}

	/**
	 * Returns the calendar local service.
	 *
	 * @return the calendar local service
	 */
	public eu.strasbourg.service.gtfs.service.CalendarLocalService
		getCalendarLocalService() {

		return calendarLocalService;
	}

	/**
	 * Sets the calendar local service.
	 *
	 * @param calendarLocalService the calendar local service
	 */
	public void setCalendarLocalService(
		eu.strasbourg.service.gtfs.service.CalendarLocalService
			calendarLocalService) {

		this.calendarLocalService = calendarLocalService;
	}

	/**
	 * Returns the calendar persistence.
	 *
	 * @return the calendar persistence
	 */
	public CalendarPersistence getCalendarPersistence() {
		return calendarPersistence;
	}

	/**
	 * Sets the calendar persistence.
	 *
	 * @param calendarPersistence the calendar persistence
	 */
	public void setCalendarPersistence(
		CalendarPersistence calendarPersistence) {

		this.calendarPersistence = calendarPersistence;
	}

	/**
	 * Returns the calendar date local service.
	 *
	 * @return the calendar date local service
	 */
	public eu.strasbourg.service.gtfs.service.CalendarDateLocalService
		getCalendarDateLocalService() {

		return calendarDateLocalService;
	}

	/**
	 * Sets the calendar date local service.
	 *
	 * @param calendarDateLocalService the calendar date local service
	 */
	public void setCalendarDateLocalService(
		eu.strasbourg.service.gtfs.service.CalendarDateLocalService
			calendarDateLocalService) {

		this.calendarDateLocalService = calendarDateLocalService;
	}

	/**
	 * Returns the calendar date persistence.
	 *
	 * @return the calendar date persistence
	 */
	public CalendarDatePersistence getCalendarDatePersistence() {
		return calendarDatePersistence;
	}

	/**
	 * Sets the calendar date persistence.
	 *
	 * @param calendarDatePersistence the calendar date persistence
	 */
	public void setCalendarDatePersistence(
		CalendarDatePersistence calendarDatePersistence) {

		this.calendarDatePersistence = calendarDatePersistence;
	}

	/**
	 * Returns the direction local service.
	 *
	 * @return the direction local service
	 */
	public eu.strasbourg.service.gtfs.service.DirectionLocalService
		getDirectionLocalService() {

		return directionLocalService;
	}

	/**
	 * Sets the direction local service.
	 *
	 * @param directionLocalService the direction local service
	 */
	public void setDirectionLocalService(
		eu.strasbourg.service.gtfs.service.DirectionLocalService
			directionLocalService) {

		this.directionLocalService = directionLocalService;
	}

	/**
	 * Returns the direction persistence.
	 *
	 * @return the direction persistence
	 */
	public DirectionPersistence getDirectionPersistence() {
		return directionPersistence;
	}

	/**
	 * Sets the direction persistence.
	 *
	 * @param directionPersistence the direction persistence
	 */
	public void setDirectionPersistence(
		DirectionPersistence directionPersistence) {

		this.directionPersistence = directionPersistence;
	}

	/**
	 * Returns the import historic local service.
	 *
	 * @return the import historic local service
	 */
	public eu.strasbourg.service.gtfs.service.ImportHistoricLocalService
		getImportHistoricLocalService() {

		return importHistoricLocalService;
	}

	/**
	 * Sets the import historic local service.
	 *
	 * @param importHistoricLocalService the import historic local service
	 */
	public void setImportHistoricLocalService(
		eu.strasbourg.service.gtfs.service.ImportHistoricLocalService
			importHistoricLocalService) {

		this.importHistoricLocalService = importHistoricLocalService;
	}

	/**
	 * Returns the import historic persistence.
	 *
	 * @return the import historic persistence
	 */
	public ImportHistoricPersistence getImportHistoricPersistence() {
		return importHistoricPersistence;
	}

	/**
	 * Sets the import historic persistence.
	 *
	 * @param importHistoricPersistence the import historic persistence
	 */
	public void setImportHistoricPersistence(
		ImportHistoricPersistence importHistoricPersistence) {

		this.importHistoricPersistence = importHistoricPersistence;
	}

	/**
	 * Returns the ligne local service.
	 *
	 * @return the ligne local service
	 */
	public eu.strasbourg.service.gtfs.service.LigneLocalService
		getLigneLocalService() {

		return ligneLocalService;
	}

	/**
	 * Sets the ligne local service.
	 *
	 * @param ligneLocalService the ligne local service
	 */
	public void setLigneLocalService(
		eu.strasbourg.service.gtfs.service.LigneLocalService
			ligneLocalService) {

		this.ligneLocalService = ligneLocalService;
	}

	/**
	 * Returns the ligne persistence.
	 *
	 * @return the ligne persistence
	 */
	public LignePersistence getLignePersistence() {
		return lignePersistence;
	}

	/**
	 * Sets the ligne persistence.
	 *
	 * @param lignePersistence the ligne persistence
	 */
	public void setLignePersistence(LignePersistence lignePersistence) {
		this.lignePersistence = lignePersistence;
	}

	/**
	 * Returns the route local service.
	 *
	 * @return the route local service
	 */
	public eu.strasbourg.service.gtfs.service.RouteLocalService
		getRouteLocalService() {

		return routeLocalService;
	}

	/**
	 * Sets the route local service.
	 *
	 * @param routeLocalService the route local service
	 */
	public void setRouteLocalService(
		eu.strasbourg.service.gtfs.service.RouteLocalService
			routeLocalService) {

		this.routeLocalService = routeLocalService;
	}

	/**
	 * Returns the route persistence.
	 *
	 * @return the route persistence
	 */
	public RoutePersistence getRoutePersistence() {
		return routePersistence;
	}

	/**
	 * Sets the route persistence.
	 *
	 * @param routePersistence the route persistence
	 */
	public void setRoutePersistence(RoutePersistence routePersistence) {
		this.routePersistence = routePersistence;
	}

	/**
	 * Returns the stop local service.
	 *
	 * @return the stop local service
	 */
	public eu.strasbourg.service.gtfs.service.StopLocalService
		getStopLocalService() {

		return stopLocalService;
	}

	/**
	 * Sets the stop local service.
	 *
	 * @param stopLocalService the stop local service
	 */
	public void setStopLocalService(
		eu.strasbourg.service.gtfs.service.StopLocalService stopLocalService) {

		this.stopLocalService = stopLocalService;
	}

	/**
	 * Returns the stop persistence.
	 *
	 * @return the stop persistence
	 */
	public StopPersistence getStopPersistence() {
		return stopPersistence;
	}

	/**
	 * Sets the stop persistence.
	 *
	 * @param stopPersistence the stop persistence
	 */
	public void setStopPersistence(StopPersistence stopPersistence) {
		this.stopPersistence = stopPersistence;
	}

	/**
	 * Returns the stop time local service.
	 *
	 * @return the stop time local service
	 */
	public eu.strasbourg.service.gtfs.service.StopTimeLocalService
		getStopTimeLocalService() {

		return stopTimeLocalService;
	}

	/**
	 * Sets the stop time local service.
	 *
	 * @param stopTimeLocalService the stop time local service
	 */
	public void setStopTimeLocalService(
		eu.strasbourg.service.gtfs.service.StopTimeLocalService
			stopTimeLocalService) {

		this.stopTimeLocalService = stopTimeLocalService;
	}

	/**
	 * Returns the stop time persistence.
	 *
	 * @return the stop time persistence
	 */
	public StopTimePersistence getStopTimePersistence() {
		return stopTimePersistence;
	}

	/**
	 * Sets the stop time persistence.
	 *
	 * @param stopTimePersistence the stop time persistence
	 */
	public void setStopTimePersistence(
		StopTimePersistence stopTimePersistence) {

		this.stopTimePersistence = stopTimePersistence;
	}

	/**
	 * Returns the trip local service.
	 *
	 * @return the trip local service
	 */
	public eu.strasbourg.service.gtfs.service.TripLocalService
		getTripLocalService() {

		return tripLocalService;
	}

	/**
	 * Sets the trip local service.
	 *
	 * @param tripLocalService the trip local service
	 */
	public void setTripLocalService(
		eu.strasbourg.service.gtfs.service.TripLocalService tripLocalService) {

		this.tripLocalService = tripLocalService;
	}

	/**
	 * Returns the trip persistence.
	 *
	 * @return the trip persistence
	 */
	public TripPersistence getTripPersistence() {
		return tripPersistence;
	}

	/**
	 * Sets the trip persistence.
	 *
	 * @param tripPersistence the trip persistence
	 */
	public void setTripPersistence(TripPersistence tripPersistence) {
		this.tripPersistence = tripPersistence;
	}

	/**
	 * Returns the trip finder.
	 *
	 * @return the trip finder
	 */
	public TripFinder getTripFinder() {
		return tripFinder;
	}

	/**
	 * Sets the trip finder.
	 *
	 * @param tripFinder the trip finder
	 */
	public void setTripFinder(TripFinder tripFinder) {
		this.tripFinder = tripFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		AgencyLocalServiceUtil.setService(agencyLocalService);
	}

	public void destroy() {
		AgencyLocalServiceUtil.setService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AgencyLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Agency.class;
	}

	protected String getModelClassName() {
		return Agency.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = agencyPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@BeanReference(type = AgencyLocalService.class)
	protected AgencyLocalService agencyLocalService;

	@BeanReference(type = AgencyPersistence.class)
	protected AgencyPersistence agencyPersistence;

	@BeanReference(
		type = eu.strasbourg.service.gtfs.service.AlertLocalService.class
	)
	protected eu.strasbourg.service.gtfs.service.AlertLocalService
		alertLocalService;

	@BeanReference(type = AlertPersistence.class)
	protected AlertPersistence alertPersistence;

	@BeanReference(
		type = eu.strasbourg.service.gtfs.service.ArretLocalService.class
	)
	protected eu.strasbourg.service.gtfs.service.ArretLocalService
		arretLocalService;

	@BeanReference(type = ArretPersistence.class)
	protected ArretPersistence arretPersistence;

	@BeanReference(
		type = eu.strasbourg.service.gtfs.service.CacheAlertJSONLocalService.class
	)
	protected eu.strasbourg.service.gtfs.service.CacheAlertJSONLocalService
		cacheAlertJSONLocalService;

	@BeanReference(type = CacheAlertJSONPersistence.class)
	protected CacheAlertJSONPersistence cacheAlertJSONPersistence;

	@BeanReference(
		type = eu.strasbourg.service.gtfs.service.CacheHoursJSONLocalService.class
	)
	protected eu.strasbourg.service.gtfs.service.CacheHoursJSONLocalService
		cacheHoursJSONLocalService;

	@BeanReference(type = CacheHoursJSONPersistence.class)
	protected CacheHoursJSONPersistence cacheHoursJSONPersistence;

	@BeanReference(
		type = eu.strasbourg.service.gtfs.service.CalendarLocalService.class
	)
	protected eu.strasbourg.service.gtfs.service.CalendarLocalService
		calendarLocalService;

	@BeanReference(type = CalendarPersistence.class)
	protected CalendarPersistence calendarPersistence;

	@BeanReference(
		type = eu.strasbourg.service.gtfs.service.CalendarDateLocalService.class
	)
	protected eu.strasbourg.service.gtfs.service.CalendarDateLocalService
		calendarDateLocalService;

	@BeanReference(type = CalendarDatePersistence.class)
	protected CalendarDatePersistence calendarDatePersistence;

	@BeanReference(
		type = eu.strasbourg.service.gtfs.service.DirectionLocalService.class
	)
	protected eu.strasbourg.service.gtfs.service.DirectionLocalService
		directionLocalService;

	@BeanReference(type = DirectionPersistence.class)
	protected DirectionPersistence directionPersistence;

	@BeanReference(
		type = eu.strasbourg.service.gtfs.service.ImportHistoricLocalService.class
	)
	protected eu.strasbourg.service.gtfs.service.ImportHistoricLocalService
		importHistoricLocalService;

	@BeanReference(type = ImportHistoricPersistence.class)
	protected ImportHistoricPersistence importHistoricPersistence;

	@BeanReference(
		type = eu.strasbourg.service.gtfs.service.LigneLocalService.class
	)
	protected eu.strasbourg.service.gtfs.service.LigneLocalService
		ligneLocalService;

	@BeanReference(type = LignePersistence.class)
	protected LignePersistence lignePersistence;

	@BeanReference(
		type = eu.strasbourg.service.gtfs.service.RouteLocalService.class
	)
	protected eu.strasbourg.service.gtfs.service.RouteLocalService
		routeLocalService;

	@BeanReference(type = RoutePersistence.class)
	protected RoutePersistence routePersistence;

	@BeanReference(
		type = eu.strasbourg.service.gtfs.service.StopLocalService.class
	)
	protected eu.strasbourg.service.gtfs.service.StopLocalService
		stopLocalService;

	@BeanReference(type = StopPersistence.class)
	protected StopPersistence stopPersistence;

	@BeanReference(
		type = eu.strasbourg.service.gtfs.service.StopTimeLocalService.class
	)
	protected eu.strasbourg.service.gtfs.service.StopTimeLocalService
		stopTimeLocalService;

	@BeanReference(type = StopTimePersistence.class)
	protected StopTimePersistence stopTimePersistence;

	@BeanReference(
		type = eu.strasbourg.service.gtfs.service.TripLocalService.class
	)
	protected eu.strasbourg.service.gtfs.service.TripLocalService
		tripLocalService;

	@BeanReference(type = TripPersistence.class)
	protected TripPersistence tripPersistence;

	@BeanReference(type = TripFinder.class)
	protected TripFinder tripFinder;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		AgencyLocalServiceBaseImpl.class);

}