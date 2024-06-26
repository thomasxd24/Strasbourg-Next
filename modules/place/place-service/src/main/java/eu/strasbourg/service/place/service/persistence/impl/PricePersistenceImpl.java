/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
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
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.place.exception.NoSuchPriceException;
import eu.strasbourg.service.place.model.Price;
import eu.strasbourg.service.place.model.PriceTable;
import eu.strasbourg.service.place.model.impl.PriceImpl;
import eu.strasbourg.service.place.model.impl.PriceModelImpl;
import eu.strasbourg.service.place.service.persistence.PricePersistence;
import eu.strasbourg.service.place.service.persistence.PriceUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the price service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class PricePersistenceImpl
	extends BasePersistenceImpl<Price> implements PricePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PriceUtil</code> to access the price persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PriceImpl.class.getName();

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
	 * Returns all the prices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching prices
	 */
	@Override
	public List<Price> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the prices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @return the range of matching prices
	 */
	@Override
	public List<Price> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the prices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching prices
	 */
	@Override
	public List<Price> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Price> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the prices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching prices
	 */
	@Override
	public List<Price> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Price> orderByComparator, boolean useFinderCache) {

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

		List<Price> list = null;

		if (useFinderCache) {
			list = (List<Price>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Price price : list) {
					if (!uuid.equals(price.getUuid())) {
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

			sb.append(_SQL_SELECT_PRICE_WHERE);

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
				sb.append(PriceModelImpl.ORDER_BY_JPQL);
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

				list = (List<Price>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first price in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching price
	 * @throws NoSuchPriceException if a matching price could not be found
	 */
	@Override
	public Price findByUuid_First(
			String uuid, OrderByComparator<Price> orderByComparator)
		throws NoSuchPriceException {

		Price price = fetchByUuid_First(uuid, orderByComparator);

		if (price != null) {
			return price;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPriceException(sb.toString());
	}

	/**
	 * Returns the first price in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching price, or <code>null</code> if a matching price could not be found
	 */
	@Override
	public Price fetchByUuid_First(
		String uuid, OrderByComparator<Price> orderByComparator) {

		List<Price> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last price in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching price
	 * @throws NoSuchPriceException if a matching price could not be found
	 */
	@Override
	public Price findByUuid_Last(
			String uuid, OrderByComparator<Price> orderByComparator)
		throws NoSuchPriceException {

		Price price = fetchByUuid_Last(uuid, orderByComparator);

		if (price != null) {
			return price;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPriceException(sb.toString());
	}

	/**
	 * Returns the last price in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching price, or <code>null</code> if a matching price could not be found
	 */
	@Override
	public Price fetchByUuid_Last(
		String uuid, OrderByComparator<Price> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Price> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the prices before and after the current price in the ordered set where uuid = &#63;.
	 *
	 * @param priceId the primary key of the current price
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next price
	 * @throws NoSuchPriceException if a price with the primary key could not be found
	 */
	@Override
	public Price[] findByUuid_PrevAndNext(
			long priceId, String uuid,
			OrderByComparator<Price> orderByComparator)
		throws NoSuchPriceException {

		uuid = Objects.toString(uuid, "");

		Price price = findByPrimaryKey(priceId);

		Session session = null;

		try {
			session = openSession();

			Price[] array = new PriceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, price, uuid, orderByComparator, true);

			array[1] = price;

			array[2] = getByUuid_PrevAndNext(
				session, price, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Price getByUuid_PrevAndNext(
		Session session, Price price, String uuid,
		OrderByComparator<Price> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRICE_WHERE);

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
			sb.append(PriceModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(price)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Price> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the prices where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Price price :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(price);
		}
	}

	/**
	 * Returns the number of prices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching prices
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRICE_WHERE);

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

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "price.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(price.uuid IS NULL OR price.uuid = '')";

	public PricePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Price.class);

		setModelImplClass(PriceImpl.class);
		setModelPKClass(long.class);

		setTable(PriceTable.INSTANCE);
	}

	/**
	 * Caches the price in the entity cache if it is enabled.
	 *
	 * @param price the price
	 */
	@Override
	public void cacheResult(Price price) {
		entityCache.putResult(PriceImpl.class, price.getPrimaryKey(), price);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the prices in the entity cache if it is enabled.
	 *
	 * @param prices the prices
	 */
	@Override
	public void cacheResult(List<Price> prices) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (prices.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Price price : prices) {
			if (entityCache.getResult(PriceImpl.class, price.getPrimaryKey()) ==
					null) {

				cacheResult(price);
			}
		}
	}

	/**
	 * Clears the cache for all prices.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PriceImpl.class);

		finderCache.clearCache(PriceImpl.class);
	}

	/**
	 * Clears the cache for the price.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Price price) {
		entityCache.removeResult(PriceImpl.class, price);
	}

	@Override
	public void clearCache(List<Price> prices) {
		for (Price price : prices) {
			entityCache.removeResult(PriceImpl.class, price);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PriceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PriceImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new price with the primary key. Does not add the price to the database.
	 *
	 * @param priceId the primary key for the new price
	 * @return the new price
	 */
	@Override
	public Price create(long priceId) {
		Price price = new PriceImpl();

		price.setNew(true);
		price.setPrimaryKey(priceId);

		String uuid = PortalUUIDUtil.generate();

		price.setUuid(uuid);

		return price;
	}

	/**
	 * Removes the price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param priceId the primary key of the price
	 * @return the price that was removed
	 * @throws NoSuchPriceException if a price with the primary key could not be found
	 */
	@Override
	public Price remove(long priceId) throws NoSuchPriceException {
		return remove((Serializable)priceId);
	}

	/**
	 * Removes the price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the price
	 * @return the price that was removed
	 * @throws NoSuchPriceException if a price with the primary key could not be found
	 */
	@Override
	public Price remove(Serializable primaryKey) throws NoSuchPriceException {
		Session session = null;

		try {
			session = openSession();

			Price price = (Price)session.get(PriceImpl.class, primaryKey);

			if (price == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPriceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(price);
		}
		catch (NoSuchPriceException noSuchEntityException) {
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
	protected Price removeImpl(Price price) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(price)) {
				price = (Price)session.get(
					PriceImpl.class, price.getPrimaryKeyObj());
			}

			if (price != null) {
				session.delete(price);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (price != null) {
			clearCache(price);
		}

		return price;
	}

	@Override
	public Price updateImpl(Price price) {
		boolean isNew = price.isNew();

		if (!(price instanceof PriceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(price.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(price);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in price proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Price implementation " +
					price.getClass());
		}

		PriceModelImpl priceModelImpl = (PriceModelImpl)price;

		if (Validator.isNull(price.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			price.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(price);
			}
			else {
				price = (Price)session.merge(price);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PriceImpl.class, priceModelImpl, false, true);

		if (isNew) {
			price.setNew(false);
		}

		price.resetOriginalValues();

		return price;
	}

	/**
	 * Returns the price with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the price
	 * @return the price
	 * @throws NoSuchPriceException if a price with the primary key could not be found
	 */
	@Override
	public Price findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPriceException {

		Price price = fetchByPrimaryKey(primaryKey);

		if (price == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPriceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return price;
	}

	/**
	 * Returns the price with the primary key or throws a <code>NoSuchPriceException</code> if it could not be found.
	 *
	 * @param priceId the primary key of the price
	 * @return the price
	 * @throws NoSuchPriceException if a price with the primary key could not be found
	 */
	@Override
	public Price findByPrimaryKey(long priceId) throws NoSuchPriceException {
		return findByPrimaryKey((Serializable)priceId);
	}

	/**
	 * Returns the price with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param priceId the primary key of the price
	 * @return the price, or <code>null</code> if a price with the primary key could not be found
	 */
	@Override
	public Price fetchByPrimaryKey(long priceId) {
		return fetchByPrimaryKey((Serializable)priceId);
	}

	/**
	 * Returns all the prices.
	 *
	 * @return the prices
	 */
	@Override
	public List<Price> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @return the range of prices
	 */
	@Override
	public List<Price> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of prices
	 */
	@Override
	public List<Price> findAll(
		int start, int end, OrderByComparator<Price> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of prices
	 */
	@Override
	public List<Price> findAll(
		int start, int end, OrderByComparator<Price> orderByComparator,
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

		List<Price> list = null;

		if (useFinderCache) {
			list = (List<Price>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRICE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRICE;

				sql = sql.concat(PriceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Price>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Removes all the prices from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Price price : findAll()) {
			remove(price);
		}
	}

	/**
	 * Returns the number of prices.
	 *
	 * @return the number of prices
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRICE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
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
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "priceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRICE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PriceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the price persistence.
	 */
	public void afterPropertiesSet() {
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

		PriceUtil.setPersistence(this);
	}

	public void destroy() {
		PriceUtil.setPersistence(null);

		entityCache.removeCache(PriceImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRICE =
		"SELECT price FROM Price price";

	private static final String _SQL_SELECT_PRICE_WHERE =
		"SELECT price FROM Price price WHERE ";

	private static final String _SQL_COUNT_PRICE =
		"SELECT COUNT(price) FROM Price price";

	private static final String _SQL_COUNT_PRICE_WHERE =
		"SELECT COUNT(price) FROM Price price WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "price.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Price exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Price exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PricePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}