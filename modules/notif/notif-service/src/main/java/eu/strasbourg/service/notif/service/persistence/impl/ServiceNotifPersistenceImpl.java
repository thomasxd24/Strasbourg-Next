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

package eu.strasbourg.service.notif.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.notif.exception.NoSuchServiceNotifException;
import eu.strasbourg.service.notif.model.ServiceNotif;
import eu.strasbourg.service.notif.model.impl.ServiceNotifImpl;
import eu.strasbourg.service.notif.model.impl.ServiceNotifModelImpl;
import eu.strasbourg.service.notif.service.persistence.ServiceNotifPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the service notif service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ServiceNotifPersistenceImpl
	extends BasePersistenceImpl<ServiceNotif>
	implements ServiceNotifPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ServiceNotifUtil</code> to access the service notif persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ServiceNotifImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByOrganisationIds;
	private FinderPath _finderPathWithoutPaginationFindByOrganisationIds;
	private FinderPath _finderPathCountByOrganisationIds;
	private FinderPath _finderPathWithPaginationCountByOrganisationIds;

	/**
	 * Returns all the service notifs where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @return the matching service notifs
	 */
	@Override
	public List<ServiceNotif> findByOrganisationIds(long organisationId) {
		return findByOrganisationIds(
			organisationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service notifs where organisationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ServiceNotifModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organisationId the organisation ID
	 * @param start the lower bound of the range of service notifs
	 * @param end the upper bound of the range of service notifs (not inclusive)
	 * @return the range of matching service notifs
	 */
	@Override
	public List<ServiceNotif> findByOrganisationIds(
		long organisationId, int start, int end) {

		return findByOrganisationIds(organisationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service notifs where organisationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ServiceNotifModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organisationId the organisation ID
	 * @param start the lower bound of the range of service notifs
	 * @param end the upper bound of the range of service notifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service notifs
	 */
	@Override
	public List<ServiceNotif> findByOrganisationIds(
		long organisationId, int start, int end,
		OrderByComparator<ServiceNotif> orderByComparator) {

		return findByOrganisationIds(
			organisationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service notifs where organisationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ServiceNotifModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organisationId the organisation ID
	 * @param start the lower bound of the range of service notifs
	 * @param end the upper bound of the range of service notifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching service notifs
	 */
	@Override
	public List<ServiceNotif> findByOrganisationIds(
		long organisationId, int start, int end,
		OrderByComparator<ServiceNotif> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByOrganisationIds;
			finderArgs = new Object[] {organisationId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByOrganisationIds;
			finderArgs = new Object[] {
				organisationId, start, end, orderByComparator
			};
		}

		List<ServiceNotif> list = null;

		if (retrieveFromCache) {
			list = (List<ServiceNotif>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceNotif serviceNotif : list) {
					if ((organisationId != serviceNotif.getOrganisationId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SERVICENOTIF_WHERE);

			query.append(_FINDER_COLUMN_ORGANISATIONIDS_ORGANISATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ServiceNotifModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organisationId);

				if (!pagination) {
					list = (List<ServiceNotif>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ServiceNotif>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Returns the first service notif in the ordered set where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service notif
	 * @throws NoSuchServiceNotifException if a matching service notif could not be found
	 */
	@Override
	public ServiceNotif findByOrganisationIds_First(
			long organisationId,
			OrderByComparator<ServiceNotif> orderByComparator)
		throws NoSuchServiceNotifException {

		ServiceNotif serviceNotif = fetchByOrganisationIds_First(
			organisationId, orderByComparator);

		if (serviceNotif != null) {
			return serviceNotif;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organisationId=");
		msg.append(organisationId);

		msg.append("}");

		throw new NoSuchServiceNotifException(msg.toString());
	}

	/**
	 * Returns the first service notif in the ordered set where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service notif, or <code>null</code> if a matching service notif could not be found
	 */
	@Override
	public ServiceNotif fetchByOrganisationIds_First(
		long organisationId,
		OrderByComparator<ServiceNotif> orderByComparator) {

		List<ServiceNotif> list = findByOrganisationIds(
			organisationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service notif in the ordered set where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service notif
	 * @throws NoSuchServiceNotifException if a matching service notif could not be found
	 */
	@Override
	public ServiceNotif findByOrganisationIds_Last(
			long organisationId,
			OrderByComparator<ServiceNotif> orderByComparator)
		throws NoSuchServiceNotifException {

		ServiceNotif serviceNotif = fetchByOrganisationIds_Last(
			organisationId, orderByComparator);

		if (serviceNotif != null) {
			return serviceNotif;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organisationId=");
		msg.append(organisationId);

		msg.append("}");

		throw new NoSuchServiceNotifException(msg.toString());
	}

	/**
	 * Returns the last service notif in the ordered set where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service notif, or <code>null</code> if a matching service notif could not be found
	 */
	@Override
	public ServiceNotif fetchByOrganisationIds_Last(
		long organisationId,
		OrderByComparator<ServiceNotif> orderByComparator) {

		int count = countByOrganisationIds(organisationId);

		if (count == 0) {
			return null;
		}

		List<ServiceNotif> list = findByOrganisationIds(
			organisationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service notifs before and after the current service notif in the ordered set where organisationId = &#63;.
	 *
	 * @param serviceId the primary key of the current service notif
	 * @param organisationId the organisation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service notif
	 * @throws NoSuchServiceNotifException if a service notif with the primary key could not be found
	 */
	@Override
	public ServiceNotif[] findByOrganisationIds_PrevAndNext(
			long serviceId, long organisationId,
			OrderByComparator<ServiceNotif> orderByComparator)
		throws NoSuchServiceNotifException {

		ServiceNotif serviceNotif = findByPrimaryKey(serviceId);

		Session session = null;

		try {
			session = openSession();

			ServiceNotif[] array = new ServiceNotifImpl[3];

			array[0] = getByOrganisationIds_PrevAndNext(
				session, serviceNotif, organisationId, orderByComparator, true);

			array[1] = serviceNotif;

			array[2] = getByOrganisationIds_PrevAndNext(
				session, serviceNotif, organisationId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceNotif getByOrganisationIds_PrevAndNext(
		Session session, ServiceNotif serviceNotif, long organisationId,
		OrderByComparator<ServiceNotif> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICENOTIF_WHERE);

		query.append(_FINDER_COLUMN_ORGANISATIONIDS_ORGANISATIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

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
			query.append(ServiceNotifModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organisationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(serviceNotif)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ServiceNotif> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service notifs where organisationId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ServiceNotifModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organisationIds the organisation IDs
	 * @return the matching service notifs
	 */
	@Override
	public List<ServiceNotif> findByOrganisationIds(long[] organisationIds) {
		return findByOrganisationIds(
			organisationIds, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service notifs where organisationId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ServiceNotifModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organisationIds the organisation IDs
	 * @param start the lower bound of the range of service notifs
	 * @param end the upper bound of the range of service notifs (not inclusive)
	 * @return the range of matching service notifs
	 */
	@Override
	public List<ServiceNotif> findByOrganisationIds(
		long[] organisationIds, int start, int end) {

		return findByOrganisationIds(organisationIds, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service notifs where organisationId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ServiceNotifModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organisationIds the organisation IDs
	 * @param start the lower bound of the range of service notifs
	 * @param end the upper bound of the range of service notifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service notifs
	 */
	@Override
	public List<ServiceNotif> findByOrganisationIds(
		long[] organisationIds, int start, int end,
		OrderByComparator<ServiceNotif> orderByComparator) {

		return findByOrganisationIds(
			organisationIds, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service notifs where organisationId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ServiceNotifModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organisationId the organisation ID
	 * @param start the lower bound of the range of service notifs
	 * @param end the upper bound of the range of service notifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching service notifs
	 */
	@Override
	public List<ServiceNotif> findByOrganisationIds(
		long[] organisationIds, int start, int end,
		OrderByComparator<ServiceNotif> orderByComparator,
		boolean retrieveFromCache) {

		if (organisationIds == null) {
			organisationIds = new long[0];
		}
		else if (organisationIds.length > 1) {
			organisationIds = ArrayUtil.unique(organisationIds);

			Arrays.sort(organisationIds);
		}

		if (organisationIds.length == 1) {
			return findByOrganisationIds(
				organisationIds[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderArgs = new Object[] {StringUtil.merge(organisationIds)};
		}
		else {
			finderArgs = new Object[] {
				StringUtil.merge(organisationIds), start, end, orderByComparator
			};
		}

		List<ServiceNotif> list = null;

		if (retrieveFromCache) {
			list = (List<ServiceNotif>)finderCache.getResult(
				_finderPathWithPaginationFindByOrganisationIds, finderArgs,
				this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceNotif serviceNotif : list) {
					if (!ArrayUtil.contains(
							organisationIds,
							serviceNotif.getOrganisationId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_SERVICENOTIF_WHERE);

			if (organisationIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_ORGANISATIONIDS_ORGANISATIONID_7);

				query.append(StringUtil.merge(organisationIds));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ServiceNotifModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ServiceNotif>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ServiceNotif>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(
					_finderPathWithPaginationFindByOrganisationIds, finderArgs,
					list);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationFindByOrganisationIds, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the service notifs where organisationId = &#63; from the database.
	 *
	 * @param organisationId the organisation ID
	 */
	@Override
	public void removeByOrganisationIds(long organisationId) {
		for (ServiceNotif serviceNotif :
				findByOrganisationIds(
					organisationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(serviceNotif);
		}
	}

	/**
	 * Returns the number of service notifs where organisationId = &#63;.
	 *
	 * @param organisationId the organisation ID
	 * @return the number of matching service notifs
	 */
	@Override
	public int countByOrganisationIds(long organisationId) {
		FinderPath finderPath = _finderPathCountByOrganisationIds;

		Object[] finderArgs = new Object[] {organisationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICENOTIF_WHERE);

			query.append(_FINDER_COLUMN_ORGANISATIONIDS_ORGANISATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organisationId);

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

	/**
	 * Returns the number of service notifs where organisationId = any &#63;.
	 *
	 * @param organisationIds the organisation IDs
	 * @return the number of matching service notifs
	 */
	@Override
	public int countByOrganisationIds(long[] organisationIds) {
		if (organisationIds == null) {
			organisationIds = new long[0];
		}
		else if (organisationIds.length > 1) {
			organisationIds = ArrayUtil.unique(organisationIds);

			Arrays.sort(organisationIds);
		}

		Object[] finderArgs = new Object[] {StringUtil.merge(organisationIds)};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByOrganisationIds, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_SERVICENOTIF_WHERE);

			if (organisationIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_ORGANISATIONIDS_ORGANISATIONID_7);

				query.append(StringUtil.merge(organisationIds));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByOrganisationIds, finderArgs,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByOrganisationIds,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_ORGANISATIONIDS_ORGANISATIONID_2 =
			"serviceNotif.organisationId = ?";

	private static final String
		_FINDER_COLUMN_ORGANISATIONIDS_ORGANISATIONID_7 =
			"serviceNotif.organisationId IN (";

	public ServiceNotifPersistenceImpl() {
		setModelClass(ServiceNotif.class);
	}

	/**
	 * Caches the service notif in the entity cache if it is enabled.
	 *
	 * @param serviceNotif the service notif
	 */
	@Override
	public void cacheResult(ServiceNotif serviceNotif) {
		entityCache.putResult(
			ServiceNotifModelImpl.ENTITY_CACHE_ENABLED, ServiceNotifImpl.class,
			serviceNotif.getPrimaryKey(), serviceNotif);

		serviceNotif.resetOriginalValues();
	}

	/**
	 * Caches the service notifs in the entity cache if it is enabled.
	 *
	 * @param serviceNotifs the service notifs
	 */
	@Override
	public void cacheResult(List<ServiceNotif> serviceNotifs) {
		for (ServiceNotif serviceNotif : serviceNotifs) {
			if (entityCache.getResult(
					ServiceNotifModelImpl.ENTITY_CACHE_ENABLED,
					ServiceNotifImpl.class, serviceNotif.getPrimaryKey()) ==
						null) {

				cacheResult(serviceNotif);
			}
			else {
				serviceNotif.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all service notifs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ServiceNotifImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service notif.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceNotif serviceNotif) {
		entityCache.removeResult(
			ServiceNotifModelImpl.ENTITY_CACHE_ENABLED, ServiceNotifImpl.class,
			serviceNotif.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ServiceNotif> serviceNotifs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServiceNotif serviceNotif : serviceNotifs) {
			entityCache.removeResult(
				ServiceNotifModelImpl.ENTITY_CACHE_ENABLED,
				ServiceNotifImpl.class, serviceNotif.getPrimaryKey());
		}
	}

	/**
	 * Creates a new service notif with the primary key. Does not add the service notif to the database.
	 *
	 * @param serviceId the primary key for the new service notif
	 * @return the new service notif
	 */
	@Override
	public ServiceNotif create(long serviceId) {
		ServiceNotif serviceNotif = new ServiceNotifImpl();

		serviceNotif.setNew(true);
		serviceNotif.setPrimaryKey(serviceId);

		return serviceNotif;
	}

	/**
	 * Removes the service notif with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceId the primary key of the service notif
	 * @return the service notif that was removed
	 * @throws NoSuchServiceNotifException if a service notif with the primary key could not be found
	 */
	@Override
	public ServiceNotif remove(long serviceId)
		throws NoSuchServiceNotifException {

		return remove((Serializable)serviceId);
	}

	/**
	 * Removes the service notif with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service notif
	 * @return the service notif that was removed
	 * @throws NoSuchServiceNotifException if a service notif with the primary key could not be found
	 */
	@Override
	public ServiceNotif remove(Serializable primaryKey)
		throws NoSuchServiceNotifException {

		Session session = null;

		try {
			session = openSession();

			ServiceNotif serviceNotif = (ServiceNotif)session.get(
				ServiceNotifImpl.class, primaryKey);

			if (serviceNotif == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceNotifException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(serviceNotif);
		}
		catch (NoSuchServiceNotifException nsee) {
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
	protected ServiceNotif removeImpl(ServiceNotif serviceNotif) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceNotif)) {
				serviceNotif = (ServiceNotif)session.get(
					ServiceNotifImpl.class, serviceNotif.getPrimaryKeyObj());
			}

			if (serviceNotif != null) {
				session.delete(serviceNotif);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (serviceNotif != null) {
			clearCache(serviceNotif);
		}

		return serviceNotif;
	}

	@Override
	public ServiceNotif updateImpl(ServiceNotif serviceNotif) {
		boolean isNew = serviceNotif.isNew();

		if (!(serviceNotif instanceof ServiceNotifModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(serviceNotif.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					serviceNotif);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in serviceNotif proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ServiceNotif implementation " +
					serviceNotif.getClass());
		}

		ServiceNotifModelImpl serviceNotifModelImpl =
			(ServiceNotifModelImpl)serviceNotif;

		Session session = null;

		try {
			session = openSession();

			if (serviceNotif.isNew()) {
				session.save(serviceNotif);

				serviceNotif.setNew(false);
			}
			else {
				serviceNotif = (ServiceNotif)session.merge(serviceNotif);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ServiceNotifModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				serviceNotifModelImpl.getOrganisationId()
			};

			finderCache.removeResult(_finderPathCountByOrganisationIds, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByOrganisationIds, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((serviceNotifModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByOrganisationIds.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					serviceNotifModelImpl.getOriginalOrganisationId()
				};

				finderCache.removeResult(
					_finderPathCountByOrganisationIds, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOrganisationIds, args);

				args = new Object[] {serviceNotifModelImpl.getOrganisationId()};

				finderCache.removeResult(
					_finderPathCountByOrganisationIds, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOrganisationIds, args);
			}
		}

		entityCache.putResult(
			ServiceNotifModelImpl.ENTITY_CACHE_ENABLED, ServiceNotifImpl.class,
			serviceNotif.getPrimaryKey(), serviceNotif, false);

		serviceNotif.resetOriginalValues();

		return serviceNotif;
	}

	/**
	 * Returns the service notif with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service notif
	 * @return the service notif
	 * @throws NoSuchServiceNotifException if a service notif with the primary key could not be found
	 */
	@Override
	public ServiceNotif findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceNotifException {

		ServiceNotif serviceNotif = fetchByPrimaryKey(primaryKey);

		if (serviceNotif == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceNotifException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return serviceNotif;
	}

	/**
	 * Returns the service notif with the primary key or throws a <code>NoSuchServiceNotifException</code> if it could not be found.
	 *
	 * @param serviceId the primary key of the service notif
	 * @return the service notif
	 * @throws NoSuchServiceNotifException if a service notif with the primary key could not be found
	 */
	@Override
	public ServiceNotif findByPrimaryKey(long serviceId)
		throws NoSuchServiceNotifException {

		return findByPrimaryKey((Serializable)serviceId);
	}

	/**
	 * Returns the service notif with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service notif
	 * @return the service notif, or <code>null</code> if a service notif with the primary key could not be found
	 */
	@Override
	public ServiceNotif fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ServiceNotifModelImpl.ENTITY_CACHE_ENABLED, ServiceNotifImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ServiceNotif serviceNotif = (ServiceNotif)serializable;

		if (serviceNotif == null) {
			Session session = null;

			try {
				session = openSession();

				serviceNotif = (ServiceNotif)session.get(
					ServiceNotifImpl.class, primaryKey);

				if (serviceNotif != null) {
					cacheResult(serviceNotif);
				}
				else {
					entityCache.putResult(
						ServiceNotifModelImpl.ENTITY_CACHE_ENABLED,
						ServiceNotifImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					ServiceNotifModelImpl.ENTITY_CACHE_ENABLED,
					ServiceNotifImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return serviceNotif;
	}

	/**
	 * Returns the service notif with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceId the primary key of the service notif
	 * @return the service notif, or <code>null</code> if a service notif with the primary key could not be found
	 */
	@Override
	public ServiceNotif fetchByPrimaryKey(long serviceId) {
		return fetchByPrimaryKey((Serializable)serviceId);
	}

	@Override
	public Map<Serializable, ServiceNotif> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ServiceNotif> map =
			new HashMap<Serializable, ServiceNotif>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ServiceNotif serviceNotif = fetchByPrimaryKey(primaryKey);

			if (serviceNotif != null) {
				map.put(primaryKey, serviceNotif);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ServiceNotifModelImpl.ENTITY_CACHE_ENABLED,
				ServiceNotifImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ServiceNotif)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_SERVICENOTIF_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (ServiceNotif serviceNotif : (List<ServiceNotif>)q.list()) {
				map.put(serviceNotif.getPrimaryKeyObj(), serviceNotif);

				cacheResult(serviceNotif);

				uncachedPrimaryKeys.remove(serviceNotif.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ServiceNotifModelImpl.ENTITY_CACHE_ENABLED,
					ServiceNotifImpl.class, primaryKey, nullModel);
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
	 * Returns all the service notifs.
	 *
	 * @return the service notifs
	 */
	@Override
	public List<ServiceNotif> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service notifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ServiceNotifModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service notifs
	 * @param end the upper bound of the range of service notifs (not inclusive)
	 * @return the range of service notifs
	 */
	@Override
	public List<ServiceNotif> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service notifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ServiceNotifModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service notifs
	 * @param end the upper bound of the range of service notifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service notifs
	 */
	@Override
	public List<ServiceNotif> findAll(
		int start, int end, OrderByComparator<ServiceNotif> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service notifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ServiceNotifModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service notifs
	 * @param end the upper bound of the range of service notifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of service notifs
	 */
	@Override
	public List<ServiceNotif> findAll(
		int start, int end, OrderByComparator<ServiceNotif> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ServiceNotif> list = null;

		if (retrieveFromCache) {
			list = (List<ServiceNotif>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SERVICENOTIF);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICENOTIF;

				if (pagination) {
					sql = sql.concat(ServiceNotifModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ServiceNotif>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ServiceNotif>)QueryUtil.list(
						q, getDialect(), start, end);
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
	 * Removes all the service notifs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ServiceNotif serviceNotif : findAll()) {
			remove(serviceNotif);
		}
	}

	/**
	 * Returns the number of service notifs.
	 *
	 * @return the number of service notifs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SERVICENOTIF);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ServiceNotifModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the service notif persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ServiceNotifModelImpl.ENTITY_CACHE_ENABLED,
			ServiceNotifModelImpl.FINDER_CACHE_ENABLED, ServiceNotifImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ServiceNotifModelImpl.ENTITY_CACHE_ENABLED,
			ServiceNotifModelImpl.FINDER_CACHE_ENABLED, ServiceNotifImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			ServiceNotifModelImpl.ENTITY_CACHE_ENABLED,
			ServiceNotifModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByOrganisationIds = new FinderPath(
			ServiceNotifModelImpl.ENTITY_CACHE_ENABLED,
			ServiceNotifModelImpl.FINDER_CACHE_ENABLED, ServiceNotifImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganisationIds",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByOrganisationIds = new FinderPath(
			ServiceNotifModelImpl.ENTITY_CACHE_ENABLED,
			ServiceNotifModelImpl.FINDER_CACHE_ENABLED, ServiceNotifImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganisationIds",
			new String[] {Long.class.getName()},
			ServiceNotifModelImpl.ORGANISATIONID_COLUMN_BITMASK |
			ServiceNotifModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByOrganisationIds = new FinderPath(
			ServiceNotifModelImpl.ENTITY_CACHE_ENABLED,
			ServiceNotifModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganisationIds",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationCountByOrganisationIds = new FinderPath(
			ServiceNotifModelImpl.ENTITY_CACHE_ENABLED,
			ServiceNotifModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByOrganisationIds",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(ServiceNotifImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SERVICENOTIF =
		"SELECT serviceNotif FROM ServiceNotif serviceNotif";

	private static final String _SQL_SELECT_SERVICENOTIF_WHERE_PKS_IN =
		"SELECT serviceNotif FROM ServiceNotif serviceNotif WHERE serviceId IN (";

	private static final String _SQL_SELECT_SERVICENOTIF_WHERE =
		"SELECT serviceNotif FROM ServiceNotif serviceNotif WHERE ";

	private static final String _SQL_COUNT_SERVICENOTIF =
		"SELECT COUNT(serviceNotif) FROM ServiceNotif serviceNotif";

	private static final String _SQL_COUNT_SERVICENOTIF_WHERE =
		"SELECT COUNT(serviceNotif) FROM ServiceNotif serviceNotif WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "serviceNotif.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ServiceNotif exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ServiceNotif exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ServiceNotifPersistenceImpl.class);

}