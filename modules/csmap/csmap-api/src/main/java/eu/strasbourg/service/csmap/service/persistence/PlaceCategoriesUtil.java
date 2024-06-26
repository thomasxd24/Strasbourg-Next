/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.csmap.model.PlaceCategories;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the place categories service. This utility wraps <code>eu.strasbourg.service.csmap.service.persistence.impl.PlaceCategoriesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlaceCategoriesPersistence
 * @generated
 */
public class PlaceCategoriesUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(PlaceCategories placeCategories) {
		getPersistence().clearCache(placeCategories);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, PlaceCategories> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PlaceCategories> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PlaceCategories> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PlaceCategories> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PlaceCategories> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PlaceCategories update(PlaceCategories placeCategories) {
		return getPersistence().update(placeCategories);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PlaceCategories update(
		PlaceCategories placeCategories, ServiceContext serviceContext) {

		return getPersistence().update(placeCategories, serviceContext);
	}

	/**
	 * Returns all the place categorieses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching place categorieses
	 */
	public static List<PlaceCategories> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the place categorieses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceCategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of place categorieses
	 * @param end the upper bound of the range of place categorieses (not inclusive)
	 * @return the range of matching place categorieses
	 */
	public static List<PlaceCategories> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the place categorieses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceCategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of place categorieses
	 * @param end the upper bound of the range of place categorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching place categorieses
	 */
	public static List<PlaceCategories> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PlaceCategories> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the place categorieses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceCategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of place categorieses
	 * @param end the upper bound of the range of place categorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching place categorieses
	 */
	public static List<PlaceCategories> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PlaceCategories> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first place categories in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place categories
	 * @throws NoSuchPlaceCategoriesException if a matching place categories could not be found
	 */
	public static PlaceCategories findByUuid_First(
			String uuid, OrderByComparator<PlaceCategories> orderByComparator)
		throws eu.strasbourg.service.csmap.exception.
			NoSuchPlaceCategoriesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first place categories in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place categories, or <code>null</code> if a matching place categories could not be found
	 */
	public static PlaceCategories fetchByUuid_First(
		String uuid, OrderByComparator<PlaceCategories> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last place categories in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place categories
	 * @throws NoSuchPlaceCategoriesException if a matching place categories could not be found
	 */
	public static PlaceCategories findByUuid_Last(
			String uuid, OrderByComparator<PlaceCategories> orderByComparator)
		throws eu.strasbourg.service.csmap.exception.
			NoSuchPlaceCategoriesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last place categories in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place categories, or <code>null</code> if a matching place categories could not be found
	 */
	public static PlaceCategories fetchByUuid_Last(
		String uuid, OrderByComparator<PlaceCategories> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the place categorieses before and after the current place categories in the ordered set where uuid = &#63;.
	 *
	 * @param placeCategoriesId the primary key of the current place categories
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next place categories
	 * @throws NoSuchPlaceCategoriesException if a place categories with the primary key could not be found
	 */
	public static PlaceCategories[] findByUuid_PrevAndNext(
			long placeCategoriesId, String uuid,
			OrderByComparator<PlaceCategories> orderByComparator)
		throws eu.strasbourg.service.csmap.exception.
			NoSuchPlaceCategoriesException {

		return getPersistence().findByUuid_PrevAndNext(
			placeCategoriesId, uuid, orderByComparator);
	}

	/**
	 * Removes all the place categorieses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of place categorieses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching place categorieses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the place categories in the entity cache if it is enabled.
	 *
	 * @param placeCategories the place categories
	 */
	public static void cacheResult(PlaceCategories placeCategories) {
		getPersistence().cacheResult(placeCategories);
	}

	/**
	 * Caches the place categorieses in the entity cache if it is enabled.
	 *
	 * @param placeCategorieses the place categorieses
	 */
	public static void cacheResult(List<PlaceCategories> placeCategorieses) {
		getPersistence().cacheResult(placeCategorieses);
	}

	/**
	 * Creates a new place categories with the primary key. Does not add the place categories to the database.
	 *
	 * @param placeCategoriesId the primary key for the new place categories
	 * @return the new place categories
	 */
	public static PlaceCategories create(long placeCategoriesId) {
		return getPersistence().create(placeCategoriesId);
	}

	/**
	 * Removes the place categories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param placeCategoriesId the primary key of the place categories
	 * @return the place categories that was removed
	 * @throws NoSuchPlaceCategoriesException if a place categories with the primary key could not be found
	 */
	public static PlaceCategories remove(long placeCategoriesId)
		throws eu.strasbourg.service.csmap.exception.
			NoSuchPlaceCategoriesException {

		return getPersistence().remove(placeCategoriesId);
	}

	public static PlaceCategories updateImpl(PlaceCategories placeCategories) {
		return getPersistence().updateImpl(placeCategories);
	}

	/**
	 * Returns the place categories with the primary key or throws a <code>NoSuchPlaceCategoriesException</code> if it could not be found.
	 *
	 * @param placeCategoriesId the primary key of the place categories
	 * @return the place categories
	 * @throws NoSuchPlaceCategoriesException if a place categories with the primary key could not be found
	 */
	public static PlaceCategories findByPrimaryKey(long placeCategoriesId)
		throws eu.strasbourg.service.csmap.exception.
			NoSuchPlaceCategoriesException {

		return getPersistence().findByPrimaryKey(placeCategoriesId);
	}

	/**
	 * Returns the place categories with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param placeCategoriesId the primary key of the place categories
	 * @return the place categories, or <code>null</code> if a place categories with the primary key could not be found
	 */
	public static PlaceCategories fetchByPrimaryKey(long placeCategoriesId) {
		return getPersistence().fetchByPrimaryKey(placeCategoriesId);
	}

	/**
	 * Returns all the place categorieses.
	 *
	 * @return the place categorieses
	 */
	public static List<PlaceCategories> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the place categorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceCategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of place categorieses
	 * @param end the upper bound of the range of place categorieses (not inclusive)
	 * @return the range of place categorieses
	 */
	public static List<PlaceCategories> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the place categorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceCategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of place categorieses
	 * @param end the upper bound of the range of place categorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of place categorieses
	 */
	public static List<PlaceCategories> findAll(
		int start, int end,
		OrderByComparator<PlaceCategories> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the place categorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceCategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of place categorieses
	 * @param end the upper bound of the range of place categorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of place categorieses
	 */
	public static List<PlaceCategories> findAll(
		int start, int end,
		OrderByComparator<PlaceCategories> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the place categorieses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of place categorieses.
	 *
	 * @return the number of place categorieses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PlaceCategoriesPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PlaceCategoriesPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PlaceCategoriesPersistence _persistence;

}