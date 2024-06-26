/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import eu.strasbourg.service.csmap.exception.NoSuchPlaceCategoriesException;
import eu.strasbourg.service.csmap.model.PlaceCategories;
import eu.strasbourg.service.csmap.model.PlaceCategoriesTable;
import eu.strasbourg.service.csmap.model.impl.PlaceCategoriesImpl;
import eu.strasbourg.service.csmap.model.impl.PlaceCategoriesModelImpl;
import eu.strasbourg.service.csmap.service.persistence.PlaceCategoriesPersistence;
import eu.strasbourg.service.csmap.service.persistence.PlaceCategoriesUtil;
import eu.strasbourg.service.csmap.service.persistence.impl.constants.csmapPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the place categories service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PlaceCategoriesPersistence.class)
public class PlaceCategoriesPersistenceImpl
	extends BasePersistenceImpl<PlaceCategories>
	implements PlaceCategoriesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PlaceCategoriesUtil</code> to access the place categories persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PlaceCategoriesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the place categorieses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching place categorieses
	 */
	@Override
	public List<PlaceCategories> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PlaceCategories> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<PlaceCategories> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PlaceCategories> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<PlaceCategories> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PlaceCategories> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<PlaceCategories> list = null;

		if (useFinderCache) {
			list = (List<PlaceCategories>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PlaceCategories placeCategories : list) {
					if (!uuid.equals(placeCategories.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PLACECATEGORIES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlaceCategoriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<PlaceCategories>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first place categories in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place categories
	 * @throws NoSuchPlaceCategoriesException if a matching place categories could not be found
	 */
	@Override
	public PlaceCategories findByUuid_First(
			String uuid, OrderByComparator<PlaceCategories> orderByComparator)
		throws NoSuchPlaceCategoriesException {

		PlaceCategories placeCategories = fetchByUuid_First(
			uuid, orderByComparator);

		if (placeCategories != null) {
			return placeCategories;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPlaceCategoriesException(sb.toString());
	}

	/**
	 * Returns the first place categories in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place categories, or <code>null</code> if a matching place categories could not be found
	 */
	@Override
	public PlaceCategories fetchByUuid_First(
		String uuid, OrderByComparator<PlaceCategories> orderByComparator) {

		List<PlaceCategories> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last place categories in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place categories
	 * @throws NoSuchPlaceCategoriesException if a matching place categories could not be found
	 */
	@Override
	public PlaceCategories findByUuid_Last(
			String uuid, OrderByComparator<PlaceCategories> orderByComparator)
		throws NoSuchPlaceCategoriesException {

		PlaceCategories placeCategories = fetchByUuid_Last(
			uuid, orderByComparator);

		if (placeCategories != null) {
			return placeCategories;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPlaceCategoriesException(sb.toString());
	}

	/**
	 * Returns the last place categories in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place categories, or <code>null</code> if a matching place categories could not be found
	 */
	@Override
	public PlaceCategories fetchByUuid_Last(
		String uuid, OrderByComparator<PlaceCategories> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PlaceCategories> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PlaceCategories[] findByUuid_PrevAndNext(
			long placeCategoriesId, String uuid,
			OrderByComparator<PlaceCategories> orderByComparator)
		throws NoSuchPlaceCategoriesException {

		uuid = Objects.toString(uuid, "");

		PlaceCategories placeCategories = findByPrimaryKey(placeCategoriesId);

		Session session = null;

		try {
			session = openSession();

			PlaceCategories[] array = new PlaceCategoriesImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, placeCategories, uuid, orderByComparator, true);

			array[1] = placeCategories;

			array[2] = getByUuid_PrevAndNext(
				session, placeCategories, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PlaceCategories getByUuid_PrevAndNext(
		Session session, PlaceCategories placeCategories, String uuid,
		OrderByComparator<PlaceCategories> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACECATEGORIES_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PlaceCategoriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						placeCategories)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PlaceCategories> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the place categorieses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PlaceCategories placeCategories :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(placeCategories);
		}
	}

	/**
	 * Returns the number of place categorieses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching place categorieses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACECATEGORIES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"placeCategories.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(placeCategories.uuid IS NULL OR placeCategories.uuid = '')";

	public PlaceCategoriesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PlaceCategories.class);

		setModelImplClass(PlaceCategoriesImpl.class);
		setModelPKClass(long.class);

		setTable(PlaceCategoriesTable.INSTANCE);
	}

	/**
	 * Caches the place categories in the entity cache if it is enabled.
	 *
	 * @param placeCategories the place categories
	 */
	@Override
	public void cacheResult(PlaceCategories placeCategories) {
		dummyEntityCache.putResult(
			PlaceCategoriesImpl.class, placeCategories.getPrimaryKey(),
			placeCategories);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the place categorieses in the entity cache if it is enabled.
	 *
	 * @param placeCategorieses the place categorieses
	 */
	@Override
	public void cacheResult(List<PlaceCategories> placeCategorieses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (placeCategorieses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PlaceCategories placeCategories : placeCategorieses) {
			if (dummyEntityCache.getResult(
					PlaceCategoriesImpl.class,
					placeCategories.getPrimaryKey()) == null) {

				cacheResult(placeCategories);
			}
		}
	}

	/**
	 * Clears the cache for all place categorieses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(PlaceCategoriesImpl.class);

		dummyFinderCache.clearCache(PlaceCategoriesImpl.class);
	}

	/**
	 * Clears the cache for the place categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PlaceCategories placeCategories) {
		dummyEntityCache.removeResult(
			PlaceCategoriesImpl.class, placeCategories);
	}

	@Override
	public void clearCache(List<PlaceCategories> placeCategorieses) {
		for (PlaceCategories placeCategories : placeCategorieses) {
			dummyEntityCache.removeResult(
				PlaceCategoriesImpl.class, placeCategories);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(PlaceCategoriesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				PlaceCategoriesImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new place categories with the primary key. Does not add the place categories to the database.
	 *
	 * @param placeCategoriesId the primary key for the new place categories
	 * @return the new place categories
	 */
	@Override
	public PlaceCategories create(long placeCategoriesId) {
		PlaceCategories placeCategories = new PlaceCategoriesImpl();

		placeCategories.setNew(true);
		placeCategories.setPrimaryKey(placeCategoriesId);

		String uuid = PortalUUIDUtil.generate();

		placeCategories.setUuid(uuid);

		return placeCategories;
	}

	/**
	 * Removes the place categories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param placeCategoriesId the primary key of the place categories
	 * @return the place categories that was removed
	 * @throws NoSuchPlaceCategoriesException if a place categories with the primary key could not be found
	 */
	@Override
	public PlaceCategories remove(long placeCategoriesId)
		throws NoSuchPlaceCategoriesException {

		return remove((Serializable)placeCategoriesId);
	}

	/**
	 * Removes the place categories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the place categories
	 * @return the place categories that was removed
	 * @throws NoSuchPlaceCategoriesException if a place categories with the primary key could not be found
	 */
	@Override
	public PlaceCategories remove(Serializable primaryKey)
		throws NoSuchPlaceCategoriesException {

		Session session = null;

		try {
			session = openSession();

			PlaceCategories placeCategories = (PlaceCategories)session.get(
				PlaceCategoriesImpl.class, primaryKey);

			if (placeCategories == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPlaceCategoriesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(placeCategories);
		}
		catch (NoSuchPlaceCategoriesException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PlaceCategories removeImpl(PlaceCategories placeCategories) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(placeCategories)) {
				placeCategories = (PlaceCategories)session.get(
					PlaceCategoriesImpl.class,
					placeCategories.getPrimaryKeyObj());
			}

			if (placeCategories != null) {
				session.delete(placeCategories);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (placeCategories != null) {
			clearCache(placeCategories);
		}

		return placeCategories;
	}

	@Override
	public PlaceCategories updateImpl(PlaceCategories placeCategories) {
		boolean isNew = placeCategories.isNew();

		if (!(placeCategories instanceof PlaceCategoriesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(placeCategories.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					placeCategories);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in placeCategories proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PlaceCategories implementation " +
					placeCategories.getClass());
		}

		PlaceCategoriesModelImpl placeCategoriesModelImpl =
			(PlaceCategoriesModelImpl)placeCategories;

		if (Validator.isNull(placeCategories.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			placeCategories.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(placeCategories);
			}
			else {
				placeCategories = (PlaceCategories)session.merge(
					placeCategories);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			PlaceCategoriesImpl.class, placeCategoriesModelImpl, false, true);

		if (isNew) {
			placeCategories.setNew(false);
		}

		placeCategories.resetOriginalValues();

		return placeCategories;
	}

	/**
	 * Returns the place categories with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the place categories
	 * @return the place categories
	 * @throws NoSuchPlaceCategoriesException if a place categories with the primary key could not be found
	 */
	@Override
	public PlaceCategories findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPlaceCategoriesException {

		PlaceCategories placeCategories = fetchByPrimaryKey(primaryKey);

		if (placeCategories == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPlaceCategoriesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return placeCategories;
	}

	/**
	 * Returns the place categories with the primary key or throws a <code>NoSuchPlaceCategoriesException</code> if it could not be found.
	 *
	 * @param placeCategoriesId the primary key of the place categories
	 * @return the place categories
	 * @throws NoSuchPlaceCategoriesException if a place categories with the primary key could not be found
	 */
	@Override
	public PlaceCategories findByPrimaryKey(long placeCategoriesId)
		throws NoSuchPlaceCategoriesException {

		return findByPrimaryKey((Serializable)placeCategoriesId);
	}

	/**
	 * Returns the place categories with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param placeCategoriesId the primary key of the place categories
	 * @return the place categories, or <code>null</code> if a place categories with the primary key could not be found
	 */
	@Override
	public PlaceCategories fetchByPrimaryKey(long placeCategoriesId) {
		return fetchByPrimaryKey((Serializable)placeCategoriesId);
	}

	/**
	 * Returns all the place categorieses.
	 *
	 * @return the place categorieses
	 */
	@Override
	public List<PlaceCategories> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PlaceCategories> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<PlaceCategories> findAll(
		int start, int end,
		OrderByComparator<PlaceCategories> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<PlaceCategories> findAll(
		int start, int end,
		OrderByComparator<PlaceCategories> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<PlaceCategories> list = null;

		if (useFinderCache) {
			list = (List<PlaceCategories>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PLACECATEGORIES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PLACECATEGORIES;

				sql = sql.concat(PlaceCategoriesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PlaceCategories>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the place categorieses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PlaceCategories placeCategories : findAll()) {
			remove(placeCategories);
		}
	}

	/**
	 * Returns the number of place categorieses.
	 *
	 * @return the number of place categorieses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PLACECATEGORIES);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "placeCategoriesId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PLACECATEGORIES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PlaceCategoriesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the place categories persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		PlaceCategoriesUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PlaceCategoriesUtil.setPersistence(null);

		dummyEntityCache.removeCache(PlaceCategoriesImpl.class.getName());
	}

	@Override
	@Reference(
		target = csmapPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = csmapPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = csmapPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private static final String _SQL_SELECT_PLACECATEGORIES =
		"SELECT placeCategories FROM PlaceCategories placeCategories";

	private static final String _SQL_SELECT_PLACECATEGORIES_WHERE =
		"SELECT placeCategories FROM PlaceCategories placeCategories WHERE ";

	private static final String _SQL_COUNT_PLACECATEGORIES =
		"SELECT COUNT(placeCategories) FROM PlaceCategories placeCategories";

	private static final String _SQL_COUNT_PLACECATEGORIES_WHERE =
		"SELECT COUNT(placeCategories) FROM PlaceCategories placeCategories WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "placeCategories.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PlaceCategories exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PlaceCategories exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PlaceCategoriesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}