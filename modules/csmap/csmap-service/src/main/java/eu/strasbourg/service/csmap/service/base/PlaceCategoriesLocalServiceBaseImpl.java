/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
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
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import eu.strasbourg.service.csmap.model.PlaceCategories;
import eu.strasbourg.service.csmap.service.PlaceCategoriesLocalService;
import eu.strasbourg.service.csmap.service.PlaceCategoriesLocalServiceUtil;
import eu.strasbourg.service.csmap.service.persistence.AgendaPersistence;
import eu.strasbourg.service.csmap.service.persistence.BaseNoncePersistence;
import eu.strasbourg.service.csmap.service.persistence.CsmapCachePersistence;
import eu.strasbourg.service.csmap.service.persistence.PlaceCategoriesPersistence;
import eu.strasbourg.service.csmap.service.persistence.RefreshTokenPersistence;
import eu.strasbourg.service.csmap.service.persistence.ThematicPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the place categories local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.csmap.service.impl.PlaceCategoriesLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eu.strasbourg.service.csmap.service.impl.PlaceCategoriesLocalServiceImpl
 * @generated
 */
public abstract class PlaceCategoriesLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   PlaceCategoriesLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>PlaceCategoriesLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>PlaceCategoriesLocalServiceUtil</code>.
	 */

	/**
	 * Adds the place categories to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlaceCategoriesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placeCategories the place categories
	 * @return the place categories that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PlaceCategories addPlaceCategories(PlaceCategories placeCategories) {
		placeCategories.setNew(true);

		return placeCategoriesPersistence.update(placeCategories);
	}

	/**
	 * Creates a new place categories with the primary key. Does not add the place categories to the database.
	 *
	 * @param placeCategoriesId the primary key for the new place categories
	 * @return the new place categories
	 */
	@Override
	@Transactional(enabled = false)
	public PlaceCategories createPlaceCategories(long placeCategoriesId) {
		return placeCategoriesPersistence.create(placeCategoriesId);
	}

	/**
	 * Deletes the place categories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlaceCategoriesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placeCategoriesId the primary key of the place categories
	 * @return the place categories that was removed
	 * @throws PortalException if a place categories with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PlaceCategories deletePlaceCategories(long placeCategoriesId)
		throws PortalException {

		return placeCategoriesPersistence.remove(placeCategoriesId);
	}

	/**
	 * Deletes the place categories from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlaceCategoriesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placeCategories the place categories
	 * @return the place categories that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PlaceCategories deletePlaceCategories(
		PlaceCategories placeCategories) {

		return placeCategoriesPersistence.remove(placeCategories);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return placeCategoriesPersistence.dslQuery(dslQuery);
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
			PlaceCategories.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return placeCategoriesPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.csmap.model.impl.PlaceCategoriesModelImpl</code>.
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

		return placeCategoriesPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.csmap.model.impl.PlaceCategoriesModelImpl</code>.
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

		return placeCategoriesPersistence.findWithDynamicQuery(
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
		return placeCategoriesPersistence.countWithDynamicQuery(dynamicQuery);
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

		return placeCategoriesPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public PlaceCategories fetchPlaceCategories(long placeCategoriesId) {
		return placeCategoriesPersistence.fetchByPrimaryKey(placeCategoriesId);
	}

	/**
	 * Returns the place categories with the primary key.
	 *
	 * @param placeCategoriesId the primary key of the place categories
	 * @return the place categories
	 * @throws PortalException if a place categories with the primary key could not be found
	 */
	@Override
	public PlaceCategories getPlaceCategories(long placeCategoriesId)
		throws PortalException {

		return placeCategoriesPersistence.findByPrimaryKey(placeCategoriesId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(placeCategoriesLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(PlaceCategories.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("placeCategoriesId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			placeCategoriesLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(PlaceCategories.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"placeCategoriesId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(placeCategoriesLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(PlaceCategories.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("placeCategoriesId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return placeCategoriesPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement PlaceCategoriesLocalServiceImpl#deletePlaceCategories(PlaceCategories) to avoid orphaned data");
		}

		return placeCategoriesLocalService.deletePlaceCategories(
			(PlaceCategories)persistedModel);
	}

	@Override
	public BasePersistence<PlaceCategories> getBasePersistence() {
		return placeCategoriesPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return placeCategoriesPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the place categorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.csmap.model.impl.PlaceCategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of place categorieses
	 * @param end the upper bound of the range of place categorieses (not inclusive)
	 * @return the range of place categorieses
	 */
	@Override
	public List<PlaceCategories> getPlaceCategorieses(int start, int end) {
		return placeCategoriesPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of place categorieses.
	 *
	 * @return the number of place categorieses
	 */
	@Override
	public int getPlaceCategoriesesCount() {
		return placeCategoriesPersistence.countAll();
	}

	/**
	 * Updates the place categories in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlaceCategoriesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placeCategories the place categories
	 * @return the place categories that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PlaceCategories updatePlaceCategories(
		PlaceCategories placeCategories) {

		return placeCategoriesPersistence.update(placeCategories);
	}

	@Deactivate
	protected void deactivate() {
		PlaceCategoriesLocalServiceUtil.setService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			PlaceCategoriesLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		placeCategoriesLocalService = (PlaceCategoriesLocalService)aopProxy;

		PlaceCategoriesLocalServiceUtil.setService(placeCategoriesLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PlaceCategoriesLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return PlaceCategories.class;
	}

	protected String getModelClassName() {
		return PlaceCategories.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = placeCategoriesPersistence.getDataSource();

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

	@Reference
	protected AgendaPersistence agendaPersistence;

	@Reference
	protected BaseNoncePersistence baseNoncePersistence;

	@Reference
	protected CsmapCachePersistence csmapCachePersistence;

	protected PlaceCategoriesLocalService placeCategoriesLocalService;

	@Reference
	protected PlaceCategoriesPersistence placeCategoriesPersistence;

	@Reference
	protected RefreshTokenPersistence refreshTokenPersistence;

	@Reference
	protected ThematicPersistence thematicPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		PlaceCategoriesLocalServiceBaseImpl.class);

}