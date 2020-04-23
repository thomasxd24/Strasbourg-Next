/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.council.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.council.exception.NoSuchProcurationException;
import eu.strasbourg.service.council.model.Procuration;
import eu.strasbourg.service.council.model.impl.ProcurationImpl;
import eu.strasbourg.service.council.model.impl.ProcurationModelImpl;
import eu.strasbourg.service.council.service.persistence.ProcurationPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the procuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcurationPersistence
 * @see eu.strasbourg.service.council.service.persistence.ProcurationUtil
 * @generated
 */
@ProviderType
public class ProcurationPersistenceImpl extends BasePersistenceImpl<Procuration>
	implements ProcurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProcurationUtil} to access the procuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProcurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, ProcurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, ProcurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, ProcurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, ProcurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ProcurationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the procurations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procurations
	 */
	@Override
	public List<Procuration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procurations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	@Override
	public List<Procuration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procurations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByUuid(String uuid, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procurations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByUuid(String uuid, int start, int end,
		OrderByComparator<Procuration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Procuration> list = null;

		if (retrieveFromCache) {
			list = (List<Procuration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Procuration procuration : list) {
					if (!Objects.equals(uuid, procuration.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PROCURATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProcurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Procuration>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Procuration>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first procuration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByUuid_First(String uuid,
		OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {
		Procuration procuration = fetchByUuid_First(uuid, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcurationException(msg.toString());
	}

	/**
	 * Returns the first procuration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByUuid_First(String uuid,
		OrderByComparator<Procuration> orderByComparator) {
		List<Procuration> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procuration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByUuid_Last(String uuid,
		OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {
		Procuration procuration = fetchByUuid_Last(uuid, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcurationException(msg.toString());
	}

	/**
	 * Returns the last procuration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByUuid_Last(String uuid,
		OrderByComparator<Procuration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Procuration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where uuid = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration[] findByUuid_PrevAndNext(long procurationId,
		String uuid, OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {
		Procuration procuration = findByPrimaryKey(procurationId);

		Session session = null;

		try {
			session = openSession();

			Procuration[] array = new ProcurationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, procuration, uuid,
					orderByComparator, true);

			array[1] = procuration;

			array[2] = getByUuid_PrevAndNext(session, procuration, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Procuration getByUuid_PrevAndNext(Session session,
		Procuration procuration, String uuid,
		OrderByComparator<Procuration> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROCURATION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ProcurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(procuration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Procuration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procurations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Procuration procuration : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(procuration);
		}
	}

	/**
	 * Returns the number of procurations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procurations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROCURATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "procuration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "procuration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(procuration.uuid IS NULL OR procuration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, ProcurationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ProcurationModelImpl.UUID_COLUMN_BITMASK |
			ProcurationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the procuration where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchProcurationException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByUUID_G(String uuid, long groupId)
		throws NoSuchProcurationException {
		Procuration procuration = fetchByUUID_G(uuid, groupId);

		if (procuration == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProcurationException(msg.toString());
		}

		return procuration;
	}

	/**
	 * Returns the procuration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the procuration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Procuration) {
			Procuration procuration = (Procuration)result;

			if (!Objects.equals(uuid, procuration.getUuid()) ||
					(groupId != procuration.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PROCURATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Procuration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Procuration procuration = list.get(0);

					result = procuration;

					cacheResult(procuration);

					if ((procuration.getUuid() == null) ||
							!procuration.getUuid().equals(uuid) ||
							(procuration.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, procuration);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Procuration)result;
		}
	}

	/**
	 * Removes the procuration where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procuration that was removed
	 */
	@Override
	public Procuration removeByUUID_G(String uuid, long groupId)
		throws NoSuchProcurationException {
		Procuration procuration = findByUUID_G(uuid, groupId);

		return remove(procuration);
	}

	/**
	 * Returns the number of procurations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procurations
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROCURATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "procuration.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "procuration.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(procuration.uuid IS NULL OR procuration.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "procuration.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, ProcurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, ProcurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ProcurationModelImpl.UUID_COLUMN_BITMASK |
			ProcurationModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procurations
	 */
	@Override
	public List<Procuration> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	@Override
	public List<Procuration> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Procuration> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Procuration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Procuration> list = null;

		if (retrieveFromCache) {
			list = (List<Procuration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Procuration procuration : list) {
					if (!Objects.equals(uuid, procuration.getUuid()) ||
							(companyId != procuration.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PROCURATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProcurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Procuration>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Procuration>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {
		Procuration procuration = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcurationException(msg.toString());
	}

	/**
	 * Returns the first procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Procuration> orderByComparator) {
		List<Procuration> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {
		Procuration procuration = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcurationException(msg.toString());
	}

	/**
	 * Returns the last procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Procuration> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Procuration> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration[] findByUuid_C_PrevAndNext(long procurationId,
		String uuid, long companyId,
		OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {
		Procuration procuration = findByPrimaryKey(procurationId);

		Session session = null;

		try {
			session = openSession();

			Procuration[] array = new ProcurationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, procuration, uuid,
					companyId, orderByComparator, true);

			array[1] = procuration;

			array[2] = getByUuid_C_PrevAndNext(session, procuration, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Procuration getByUuid_C_PrevAndNext(Session session,
		Procuration procuration, String uuid, long companyId,
		OrderByComparator<Procuration> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PROCURATION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ProcurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(procuration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Procuration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procurations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Procuration procuration : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(procuration);
		}
	}

	/**
	 * Returns the number of procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procurations
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROCURATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "procuration.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "procuration.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(procuration.uuid IS NULL OR procuration.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "procuration.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNCILSESSIONID =
		new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, ProcurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCouncilSessionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNCILSESSIONID =
		new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, ProcurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCouncilSessionId", new String[] { Long.class.getName() },
			ProcurationModelImpl.COUNCILSESSIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNCILSESSIONID = new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCouncilSessionId", new String[] { Long.class.getName() });

	/**
	 * Returns all the procurations where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @return the matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionId(long councilSessionId) {
		return findByCouncilSessionId(councilSessionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procurations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionId(long councilSessionId,
		int start, int end) {
		return findByCouncilSessionId(councilSessionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionId(long councilSessionId,
		int start, int end, OrderByComparator<Procuration> orderByComparator) {
		return findByCouncilSessionId(councilSessionId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionId(long councilSessionId,
		int start, int end, OrderByComparator<Procuration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNCILSESSIONID;
			finderArgs = new Object[] { councilSessionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNCILSESSIONID;
			finderArgs = new Object[] {
					councilSessionId,
					
					start, end, orderByComparator
				};
		}

		List<Procuration> list = null;

		if (retrieveFromCache) {
			list = (List<Procuration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Procuration procuration : list) {
					if ((councilSessionId != procuration.getCouncilSessionId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PROCURATION_WHERE);

			query.append(_FINDER_COLUMN_COUNCILSESSIONID_COUNCILSESSIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProcurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(councilSessionId);

				if (!pagination) {
					list = (List<Procuration>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Procuration>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByCouncilSessionId_First(long councilSessionId,
		OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {
		Procuration procuration = fetchByCouncilSessionId_First(councilSessionId,
				orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("councilSessionId=");
		msg.append(councilSessionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcurationException(msg.toString());
	}

	/**
	 * Returns the first procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByCouncilSessionId_First(long councilSessionId,
		OrderByComparator<Procuration> orderByComparator) {
		List<Procuration> list = findByCouncilSessionId(councilSessionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByCouncilSessionId_Last(long councilSessionId,
		OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {
		Procuration procuration = fetchByCouncilSessionId_Last(councilSessionId,
				orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("councilSessionId=");
		msg.append(councilSessionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcurationException(msg.toString());
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByCouncilSessionId_Last(long councilSessionId,
		OrderByComparator<Procuration> orderByComparator) {
		int count = countByCouncilSessionId(councilSessionId);

		if (count == 0) {
			return null;
		}

		List<Procuration> list = findByCouncilSessionId(councilSessionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration[] findByCouncilSessionId_PrevAndNext(
		long procurationId, long councilSessionId,
		OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {
		Procuration procuration = findByPrimaryKey(procurationId);

		Session session = null;

		try {
			session = openSession();

			Procuration[] array = new ProcurationImpl[3];

			array[0] = getByCouncilSessionId_PrevAndNext(session, procuration,
					councilSessionId, orderByComparator, true);

			array[1] = procuration;

			array[2] = getByCouncilSessionId_PrevAndNext(session, procuration,
					councilSessionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Procuration getByCouncilSessionId_PrevAndNext(Session session,
		Procuration procuration, long councilSessionId,
		OrderByComparator<Procuration> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROCURATION_WHERE);

		query.append(_FINDER_COLUMN_COUNCILSESSIONID_COUNCILSESSIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ProcurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(councilSessionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(procuration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Procuration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procurations where councilSessionId = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 */
	@Override
	public void removeByCouncilSessionId(long councilSessionId) {
		for (Procuration procuration : findByCouncilSessionId(
				councilSessionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(procuration);
		}
	}

	/**
	 * Returns the number of procurations where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @return the number of matching procurations
	 */
	@Override
	public int countByCouncilSessionId(long councilSessionId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNCILSESSIONID;

		Object[] finderArgs = new Object[] { councilSessionId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROCURATION_WHERE);

			query.append(_FINDER_COLUMN_COUNCILSESSIONID_COUNCILSESSIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(councilSessionId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COUNCILSESSIONID_COUNCILSESSIONID_2 =
		"procuration.councilSessionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNCILSESSIONIDANDOFFICIALVOTERSID =
		new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, ProcurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCouncilSessionIdAndOfficialVotersId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNCILSESSIONIDANDOFFICIALVOTERSID =
		new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, ProcurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCouncilSessionIdAndOfficialVotersId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProcurationModelImpl.COUNCILSESSIONID_COLUMN_BITMASK |
			ProcurationModelImpl.OFFICIALVOTERSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNCILSESSIONIDANDOFFICIALVOTERSID =
		new FinderPath(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCouncilSessionIdAndOfficialVotersId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @return the matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId) {
		return findByCouncilSessionIdAndOfficialVotersId(councilSessionId,
			officialVotersId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId, int start, int end) {
		return findByCouncilSessionIdAndOfficialVotersId(councilSessionId,
			officialVotersId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {
		return findByCouncilSessionIdAndOfficialVotersId(councilSessionId,
			officialVotersId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId, int start, int end,
		OrderByComparator<Procuration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNCILSESSIONIDANDOFFICIALVOTERSID;
			finderArgs = new Object[] { councilSessionId, officialVotersId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNCILSESSIONIDANDOFFICIALVOTERSID;
			finderArgs = new Object[] {
					councilSessionId, officialVotersId,
					
					start, end, orderByComparator
				};
		}

		List<Procuration> list = null;

		if (retrieveFromCache) {
			list = (List<Procuration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Procuration procuration : list) {
					if ((councilSessionId != procuration.getCouncilSessionId()) ||
							(officialVotersId != procuration.getOfficialVotersId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PROCURATION_WHERE);

			query.append(_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_COUNCILSESSIONID_2);

			query.append(_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_OFFICIALVOTERSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProcurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(councilSessionId);

				qPos.add(officialVotersId);

				if (!pagination) {
					list = (List<Procuration>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Procuration>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByCouncilSessionIdAndOfficialVotersId_First(
		long councilSessionId, long officialVotersId,
		OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {
		Procuration procuration = fetchByCouncilSessionIdAndOfficialVotersId_First(councilSessionId,
				officialVotersId, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("councilSessionId=");
		msg.append(councilSessionId);

		msg.append(", officialVotersId=");
		msg.append(officialVotersId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcurationException(msg.toString());
	}

	/**
	 * Returns the first procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByCouncilSessionIdAndOfficialVotersId_First(
		long councilSessionId, long officialVotersId,
		OrderByComparator<Procuration> orderByComparator) {
		List<Procuration> list = findByCouncilSessionIdAndOfficialVotersId(councilSessionId,
				officialVotersId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByCouncilSessionIdAndOfficialVotersId_Last(
		long councilSessionId, long officialVotersId,
		OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {
		Procuration procuration = fetchByCouncilSessionIdAndOfficialVotersId_Last(councilSessionId,
				officialVotersId, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("councilSessionId=");
		msg.append(councilSessionId);

		msg.append(", officialVotersId=");
		msg.append(officialVotersId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProcurationException(msg.toString());
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByCouncilSessionIdAndOfficialVotersId_Last(
		long councilSessionId, long officialVotersId,
		OrderByComparator<Procuration> orderByComparator) {
		int count = countByCouncilSessionIdAndOfficialVotersId(councilSessionId,
				officialVotersId);

		if (count == 0) {
			return null;
		}

		List<Procuration> list = findByCouncilSessionIdAndOfficialVotersId(councilSessionId,
				officialVotersId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration[] findByCouncilSessionIdAndOfficialVotersId_PrevAndNext(
		long procurationId, long councilSessionId, long officialVotersId,
		OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {
		Procuration procuration = findByPrimaryKey(procurationId);

		Session session = null;

		try {
			session = openSession();

			Procuration[] array = new ProcurationImpl[3];

			array[0] = getByCouncilSessionIdAndOfficialVotersId_PrevAndNext(session,
					procuration, councilSessionId, officialVotersId,
					orderByComparator, true);

			array[1] = procuration;

			array[2] = getByCouncilSessionIdAndOfficialVotersId_PrevAndNext(session,
					procuration, councilSessionId, officialVotersId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Procuration getByCouncilSessionIdAndOfficialVotersId_PrevAndNext(
		Session session, Procuration procuration, long councilSessionId,
		long officialVotersId,
		OrderByComparator<Procuration> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PROCURATION_WHERE);

		query.append(_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_COUNCILSESSIONID_2);

		query.append(_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_OFFICIALVOTERSID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ProcurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(councilSessionId);

		qPos.add(officialVotersId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(procuration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Procuration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procurations where councilSessionId = &#63; and officialVotersId = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 */
	@Override
	public void removeByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId) {
		for (Procuration procuration : findByCouncilSessionIdAndOfficialVotersId(
				councilSessionId, officialVotersId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(procuration);
		}
	}

	/**
	 * Returns the number of procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @return the number of matching procurations
	 */
	@Override
	public int countByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNCILSESSIONIDANDOFFICIALVOTERSID;

		Object[] finderArgs = new Object[] { councilSessionId, officialVotersId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROCURATION_WHERE);

			query.append(_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_COUNCILSESSIONID_2);

			query.append(_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_OFFICIALVOTERSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(councilSessionId);

				qPos.add(officialVotersId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_COUNCILSESSIONID_2 =
		"procuration.councilSessionId = ? AND ";
	private static final String _FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_OFFICIALVOTERSID_2 =
		"procuration.officialVotersId = ?";

	public ProcurationPersistenceImpl() {
		setModelClass(Procuration.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the procuration in the entity cache if it is enabled.
	 *
	 * @param procuration the procuration
	 */
	@Override
	public void cacheResult(Procuration procuration) {
		entityCache.putResult(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationImpl.class, procuration.getPrimaryKey(), procuration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { procuration.getUuid(), procuration.getGroupId() },
			procuration);

		procuration.resetOriginalValues();
	}

	/**
	 * Caches the procurations in the entity cache if it is enabled.
	 *
	 * @param procurations the procurations
	 */
	@Override
	public void cacheResult(List<Procuration> procurations) {
		for (Procuration procuration : procurations) {
			if (entityCache.getResult(
						ProcurationModelImpl.ENTITY_CACHE_ENABLED,
						ProcurationImpl.class, procuration.getPrimaryKey()) == null) {
				cacheResult(procuration);
			}
			else {
				procuration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all procurations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProcurationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the procuration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Procuration procuration) {
		entityCache.removeResult(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationImpl.class, procuration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ProcurationModelImpl)procuration, true);
	}

	@Override
	public void clearCache(List<Procuration> procurations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Procuration procuration : procurations) {
			entityCache.removeResult(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
				ProcurationImpl.class, procuration.getPrimaryKey());

			clearUniqueFindersCache((ProcurationModelImpl)procuration, true);
		}
	}

	protected void cacheUniqueFindersCache(
		ProcurationModelImpl procurationModelImpl) {
		Object[] args = new Object[] {
				procurationModelImpl.getUuid(),
				procurationModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			procurationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ProcurationModelImpl procurationModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					procurationModelImpl.getUuid(),
					procurationModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((procurationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					procurationModelImpl.getOriginalUuid(),
					procurationModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new procuration with the primary key. Does not add the procuration to the database.
	 *
	 * @param procurationId the primary key for the new procuration
	 * @return the new procuration
	 */
	@Override
	public Procuration create(long procurationId) {
		Procuration procuration = new ProcurationImpl();

		procuration.setNew(true);
		procuration.setPrimaryKey(procurationId);

		String uuid = PortalUUIDUtil.generate();

		procuration.setUuid(uuid);

		procuration.setCompanyId(companyProvider.getCompanyId());

		return procuration;
	}

	/**
	 * Removes the procuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param procurationId the primary key of the procuration
	 * @return the procuration that was removed
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration remove(long procurationId)
		throws NoSuchProcurationException {
		return remove((Serializable)procurationId);
	}

	/**
	 * Removes the procuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the procuration
	 * @return the procuration that was removed
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration remove(Serializable primaryKey)
		throws NoSuchProcurationException {
		Session session = null;

		try {
			session = openSession();

			Procuration procuration = (Procuration)session.get(ProcurationImpl.class,
					primaryKey);

			if (procuration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProcurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(procuration);
		}
		catch (NoSuchProcurationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Procuration removeImpl(Procuration procuration) {
		procuration = toUnwrappedModel(procuration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(procuration)) {
				procuration = (Procuration)session.get(ProcurationImpl.class,
						procuration.getPrimaryKeyObj());
			}

			if (procuration != null) {
				session.delete(procuration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (procuration != null) {
			clearCache(procuration);
		}

		return procuration;
	}

	@Override
	public Procuration updateImpl(Procuration procuration) {
		procuration = toUnwrappedModel(procuration);

		boolean isNew = procuration.isNew();

		ProcurationModelImpl procurationModelImpl = (ProcurationModelImpl)procuration;

		if (Validator.isNull(procuration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			procuration.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (procuration.getCreateDate() == null)) {
			if (serviceContext == null) {
				procuration.setCreateDate(now);
			}
			else {
				procuration.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!procurationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				procuration.setModifiedDate(now);
			}
			else {
				procuration.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (procuration.isNew()) {
				session.save(procuration);

				procuration.setNew(false);
			}
			else {
				procuration = (Procuration)session.merge(procuration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ProcurationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { procurationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					procurationModelImpl.getUuid(),
					procurationModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { procurationModelImpl.getCouncilSessionId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COUNCILSESSIONID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNCILSESSIONID,
				args);

			args = new Object[] {
					procurationModelImpl.getCouncilSessionId(),
					procurationModelImpl.getOfficialVotersId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COUNCILSESSIONIDANDOFFICIALVOTERSID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNCILSESSIONIDANDOFFICIALVOTERSID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((procurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						procurationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { procurationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((procurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						procurationModelImpl.getOriginalUuid(),
						procurationModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						procurationModelImpl.getUuid(),
						procurationModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((procurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNCILSESSIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						procurationModelImpl.getOriginalCouncilSessionId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COUNCILSESSIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNCILSESSIONID,
					args);

				args = new Object[] { procurationModelImpl.getCouncilSessionId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COUNCILSESSIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNCILSESSIONID,
					args);
			}

			if ((procurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNCILSESSIONIDANDOFFICIALVOTERSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						procurationModelImpl.getOriginalCouncilSessionId(),
						procurationModelImpl.getOriginalOfficialVotersId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COUNCILSESSIONIDANDOFFICIALVOTERSID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNCILSESSIONIDANDOFFICIALVOTERSID,
					args);

				args = new Object[] {
						procurationModelImpl.getCouncilSessionId(),
						procurationModelImpl.getOfficialVotersId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COUNCILSESSIONIDANDOFFICIALVOTERSID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNCILSESSIONIDANDOFFICIALVOTERSID,
					args);
			}
		}

		entityCache.putResult(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
			ProcurationImpl.class, procuration.getPrimaryKey(), procuration,
			false);

		clearUniqueFindersCache(procurationModelImpl, false);
		cacheUniqueFindersCache(procurationModelImpl);

		procuration.resetOriginalValues();

		return procuration;
	}

	protected Procuration toUnwrappedModel(Procuration procuration) {
		if (procuration instanceof ProcurationImpl) {
			return procuration;
		}

		ProcurationImpl procurationImpl = new ProcurationImpl();

		procurationImpl.setNew(procuration.isNew());
		procurationImpl.setPrimaryKey(procuration.getPrimaryKey());

		procurationImpl.setUuid(procuration.getUuid());
		procurationImpl.setProcurationId(procuration.getProcurationId());
		procurationImpl.setGroupId(procuration.getGroupId());
		procurationImpl.setCompanyId(procuration.getCompanyId());
		procurationImpl.setUserId(procuration.getUserId());
		procurationImpl.setUserName(procuration.getUserName());
		procurationImpl.setCreateDate(procuration.getCreateDate());
		procurationImpl.setModifiedDate(procuration.getModifiedDate());
		procurationImpl.setStatus(procuration.getStatus());
		procurationImpl.setStatusByUserId(procuration.getStatusByUserId());
		procurationImpl.setStatusByUserName(procuration.getStatusByUserName());
		procurationImpl.setStatusDate(procuration.getStatusDate());
		procurationImpl.setOfficialVotersId(procuration.getOfficialVotersId());
		procurationImpl.setOfficialUnavailableId(procuration.getOfficialUnavailableId());
		procurationImpl.setCouncilSessionId(procuration.getCouncilSessionId());
		procurationImpl.setIsAbsent(procuration.isIsAbsent());

		return procurationImpl;
	}

	/**
	 * Returns the procuration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the procuration
	 * @return the procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProcurationException {
		Procuration procuration = fetchByPrimaryKey(primaryKey);

		if (procuration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProcurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return procuration;
	}

	/**
	 * Returns the procuration with the primary key or throws a {@link NoSuchProcurationException} if it could not be found.
	 *
	 * @param procurationId the primary key of the procuration
	 * @return the procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration findByPrimaryKey(long procurationId)
		throws NoSuchProcurationException {
		return findByPrimaryKey((Serializable)procurationId);
	}

	/**
	 * Returns the procuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the procuration
	 * @return the procuration, or <code>null</code> if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
				ProcurationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Procuration procuration = (Procuration)serializable;

		if (procuration == null) {
			Session session = null;

			try {
				session = openSession();

				procuration = (Procuration)session.get(ProcurationImpl.class,
						primaryKey);

				if (procuration != null) {
					cacheResult(procuration);
				}
				else {
					entityCache.putResult(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
						ProcurationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
					ProcurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return procuration;
	}

	/**
	 * Returns the procuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param procurationId the primary key of the procuration
	 * @return the procuration, or <code>null</code> if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration fetchByPrimaryKey(long procurationId) {
		return fetchByPrimaryKey((Serializable)procurationId);
	}

	@Override
	public Map<Serializable, Procuration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Procuration> map = new HashMap<Serializable, Procuration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Procuration procuration = fetchByPrimaryKey(primaryKey);

			if (procuration != null) {
				map.put(primaryKey, procuration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
					ProcurationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Procuration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROCURATION_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Procuration procuration : (List<Procuration>)q.list()) {
				map.put(procuration.getPrimaryKeyObj(), procuration);

				cacheResult(procuration);

				uncachedPrimaryKeys.remove(procuration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProcurationModelImpl.ENTITY_CACHE_ENABLED,
					ProcurationImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the procurations.
	 *
	 * @return the procurations
	 */
	@Override
	public List<Procuration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of procurations
	 */
	@Override
	public List<Procuration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the procurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procurations
	 */
	@Override
	public List<Procuration> findAll(int start, int end,
		OrderByComparator<Procuration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProcurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of procurations
	 */
	@Override
	public List<Procuration> findAll(int start, int end,
		OrderByComparator<Procuration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Procuration> list = null;

		if (retrieveFromCache) {
			list = (List<Procuration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROCURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROCURATION;

				if (pagination) {
					sql = sql.concat(ProcurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Procuration>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Procuration>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the procurations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Procuration procuration : findAll()) {
			remove(procuration);
		}
	}

	/**
	 * Returns the number of procurations.
	 *
	 * @return the number of procurations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROCURATION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
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
	protected Map<String, Integer> getTableColumnsMap() {
		return ProcurationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the procuration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProcurationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROCURATION = "SELECT procuration FROM Procuration procuration";
	private static final String _SQL_SELECT_PROCURATION_WHERE_PKS_IN = "SELECT procuration FROM Procuration procuration WHERE procurationId IN (";
	private static final String _SQL_SELECT_PROCURATION_WHERE = "SELECT procuration FROM Procuration procuration WHERE ";
	private static final String _SQL_COUNT_PROCURATION = "SELECT COUNT(procuration) FROM Procuration procuration";
	private static final String _SQL_COUNT_PROCURATION_WHERE = "SELECT COUNT(procuration) FROM Procuration procuration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "procuration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Procuration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Procuration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProcurationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}