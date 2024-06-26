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

import eu.strasbourg.service.csmap.exception.NoSuchAgendaException;
import eu.strasbourg.service.csmap.model.Agenda;
import eu.strasbourg.service.csmap.model.AgendaTable;
import eu.strasbourg.service.csmap.model.impl.AgendaImpl;
import eu.strasbourg.service.csmap.model.impl.AgendaModelImpl;
import eu.strasbourg.service.csmap.service.persistence.AgendaPersistence;
import eu.strasbourg.service.csmap.service.persistence.AgendaUtil;
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
 * The persistence implementation for the agenda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AgendaPersistence.class)
public class AgendaPersistenceImpl
	extends BasePersistenceImpl<Agenda> implements AgendaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AgendaUtil</code> to access the agenda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AgendaImpl.class.getName();

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
	 * Returns all the agendas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching agendas
	 */
	@Override
	public List<Agenda> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agendas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agendas
	 * @param end the upper bound of the range of agendas (not inclusive)
	 * @return the range of matching agendas
	 */
	@Override
	public List<Agenda> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agendas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agendas
	 * @param end the upper bound of the range of agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agendas
	 */
	@Override
	public List<Agenda> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Agenda> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agendas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agendas
	 * @param end the upper bound of the range of agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agendas
	 */
	@Override
	public List<Agenda> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Agenda> orderByComparator, boolean useFinderCache) {

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

		List<Agenda> list = null;

		if (useFinderCache) {
			list = (List<Agenda>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Agenda agenda : list) {
					if (!uuid.equals(agenda.getUuid())) {
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

			sb.append(_SQL_SELECT_AGENDA_WHERE);

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
				sb.append(AgendaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Agenda>)QueryUtil.list(
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
	 * Returns the first agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda
	 * @throws NoSuchAgendaException if a matching agenda could not be found
	 */
	@Override
	public Agenda findByUuid_First(
			String uuid, OrderByComparator<Agenda> orderByComparator)
		throws NoSuchAgendaException {

		Agenda agenda = fetchByUuid_First(uuid, orderByComparator);

		if (agenda != null) {
			return agenda;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAgendaException(sb.toString());
	}

	/**
	 * Returns the first agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda, or <code>null</code> if a matching agenda could not be found
	 */
	@Override
	public Agenda fetchByUuid_First(
		String uuid, OrderByComparator<Agenda> orderByComparator) {

		List<Agenda> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda
	 * @throws NoSuchAgendaException if a matching agenda could not be found
	 */
	@Override
	public Agenda findByUuid_Last(
			String uuid, OrderByComparator<Agenda> orderByComparator)
		throws NoSuchAgendaException {

		Agenda agenda = fetchByUuid_Last(uuid, orderByComparator);

		if (agenda != null) {
			return agenda;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAgendaException(sb.toString());
	}

	/**
	 * Returns the last agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda, or <code>null</code> if a matching agenda could not be found
	 */
	@Override
	public Agenda fetchByUuid_Last(
		String uuid, OrderByComparator<Agenda> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Agenda> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agendas before and after the current agenda in the ordered set where uuid = &#63;.
	 *
	 * @param agendaId the primary key of the current agenda
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda
	 * @throws NoSuchAgendaException if a agenda with the primary key could not be found
	 */
	@Override
	public Agenda[] findByUuid_PrevAndNext(
			long agendaId, String uuid,
			OrderByComparator<Agenda> orderByComparator)
		throws NoSuchAgendaException {

		uuid = Objects.toString(uuid, "");

		Agenda agenda = findByPrimaryKey(agendaId);

		Session session = null;

		try {
			session = openSession();

			Agenda[] array = new AgendaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, agenda, uuid, orderByComparator, true);

			array[1] = agenda;

			array[2] = getByUuid_PrevAndNext(
				session, agenda, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Agenda getByUuid_PrevAndNext(
		Session session, Agenda agenda, String uuid,
		OrderByComparator<Agenda> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AGENDA_WHERE);

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
			sb.append(AgendaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(agenda)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Agenda> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agendas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Agenda agenda :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agenda);
		}
	}

	/**
	 * Returns the number of agendas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching agendas
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

			sb.append(_SQL_COUNT_AGENDA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "agenda.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(agenda.uuid IS NULL OR agenda.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByIsPrincipal;
	private FinderPath _finderPathWithoutPaginationFindByIsPrincipal;
	private FinderPath _finderPathCountByIsPrincipal;

	/**
	 * Returns all the agendas where isPrincipal = &#63;.
	 *
	 * @param isPrincipal the is principal
	 * @return the matching agendas
	 */
	@Override
	public List<Agenda> findByIsPrincipal(Boolean isPrincipal) {
		return findByIsPrincipal(
			isPrincipal, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agendas where isPrincipal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaModelImpl</code>.
	 * </p>
	 *
	 * @param isPrincipal the is principal
	 * @param start the lower bound of the range of agendas
	 * @param end the upper bound of the range of agendas (not inclusive)
	 * @return the range of matching agendas
	 */
	@Override
	public List<Agenda> findByIsPrincipal(
		Boolean isPrincipal, int start, int end) {

		return findByIsPrincipal(isPrincipal, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agendas where isPrincipal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaModelImpl</code>.
	 * </p>
	 *
	 * @param isPrincipal the is principal
	 * @param start the lower bound of the range of agendas
	 * @param end the upper bound of the range of agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agendas
	 */
	@Override
	public List<Agenda> findByIsPrincipal(
		Boolean isPrincipal, int start, int end,
		OrderByComparator<Agenda> orderByComparator) {

		return findByIsPrincipal(
			isPrincipal, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agendas where isPrincipal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaModelImpl</code>.
	 * </p>
	 *
	 * @param isPrincipal the is principal
	 * @param start the lower bound of the range of agendas
	 * @param end the upper bound of the range of agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agendas
	 */
	@Override
	public List<Agenda> findByIsPrincipal(
		Boolean isPrincipal, int start, int end,
		OrderByComparator<Agenda> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIsPrincipal;
				finderArgs = new Object[] {isPrincipal};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsPrincipal;
			finderArgs = new Object[] {
				isPrincipal, start, end, orderByComparator
			};
		}

		List<Agenda> list = null;

		if (useFinderCache) {
			list = (List<Agenda>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Agenda agenda : list) {
					if (!Objects.equals(isPrincipal, agenda.getIsPrincipal())) {
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

			sb.append(_SQL_SELECT_AGENDA_WHERE);

			sb.append(_FINDER_COLUMN_ISPRINCIPAL_ISPRINCIPAL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isPrincipal.booleanValue());

				list = (List<Agenda>)QueryUtil.list(
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
	 * Returns the first agenda in the ordered set where isPrincipal = &#63;.
	 *
	 * @param isPrincipal the is principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda
	 * @throws NoSuchAgendaException if a matching agenda could not be found
	 */
	@Override
	public Agenda findByIsPrincipal_First(
			Boolean isPrincipal, OrderByComparator<Agenda> orderByComparator)
		throws NoSuchAgendaException {

		Agenda agenda = fetchByIsPrincipal_First(
			isPrincipal, orderByComparator);

		if (agenda != null) {
			return agenda;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isPrincipal=");
		sb.append(isPrincipal);

		sb.append("}");

		throw new NoSuchAgendaException(sb.toString());
	}

	/**
	 * Returns the first agenda in the ordered set where isPrincipal = &#63;.
	 *
	 * @param isPrincipal the is principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda, or <code>null</code> if a matching agenda could not be found
	 */
	@Override
	public Agenda fetchByIsPrincipal_First(
		Boolean isPrincipal, OrderByComparator<Agenda> orderByComparator) {

		List<Agenda> list = findByIsPrincipal(
			isPrincipal, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agenda in the ordered set where isPrincipal = &#63;.
	 *
	 * @param isPrincipal the is principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda
	 * @throws NoSuchAgendaException if a matching agenda could not be found
	 */
	@Override
	public Agenda findByIsPrincipal_Last(
			Boolean isPrincipal, OrderByComparator<Agenda> orderByComparator)
		throws NoSuchAgendaException {

		Agenda agenda = fetchByIsPrincipal_Last(isPrincipal, orderByComparator);

		if (agenda != null) {
			return agenda;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isPrincipal=");
		sb.append(isPrincipal);

		sb.append("}");

		throw new NoSuchAgendaException(sb.toString());
	}

	/**
	 * Returns the last agenda in the ordered set where isPrincipal = &#63;.
	 *
	 * @param isPrincipal the is principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda, or <code>null</code> if a matching agenda could not be found
	 */
	@Override
	public Agenda fetchByIsPrincipal_Last(
		Boolean isPrincipal, OrderByComparator<Agenda> orderByComparator) {

		int count = countByIsPrincipal(isPrincipal);

		if (count == 0) {
			return null;
		}

		List<Agenda> list = findByIsPrincipal(
			isPrincipal, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agendas before and after the current agenda in the ordered set where isPrincipal = &#63;.
	 *
	 * @param agendaId the primary key of the current agenda
	 * @param isPrincipal the is principal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda
	 * @throws NoSuchAgendaException if a agenda with the primary key could not be found
	 */
	@Override
	public Agenda[] findByIsPrincipal_PrevAndNext(
			long agendaId, Boolean isPrincipal,
			OrderByComparator<Agenda> orderByComparator)
		throws NoSuchAgendaException {

		Agenda agenda = findByPrimaryKey(agendaId);

		Session session = null;

		try {
			session = openSession();

			Agenda[] array = new AgendaImpl[3];

			array[0] = getByIsPrincipal_PrevAndNext(
				session, agenda, isPrincipal, orderByComparator, true);

			array[1] = agenda;

			array[2] = getByIsPrincipal_PrevAndNext(
				session, agenda, isPrincipal, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Agenda getByIsPrincipal_PrevAndNext(
		Session session, Agenda agenda, Boolean isPrincipal,
		OrderByComparator<Agenda> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AGENDA_WHERE);

		sb.append(_FINDER_COLUMN_ISPRINCIPAL_ISPRINCIPAL_2);

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
			sb.append(AgendaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isPrincipal.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(agenda)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Agenda> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agendas where isPrincipal = &#63; from the database.
	 *
	 * @param isPrincipal the is principal
	 */
	@Override
	public void removeByIsPrincipal(Boolean isPrincipal) {
		for (Agenda agenda :
				findByIsPrincipal(
					isPrincipal, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agenda);
		}
	}

	/**
	 * Returns the number of agendas where isPrincipal = &#63;.
	 *
	 * @param isPrincipal the is principal
	 * @return the number of matching agendas
	 */
	@Override
	public int countByIsPrincipal(Boolean isPrincipal) {
		FinderPath finderPath = _finderPathCountByIsPrincipal;

		Object[] finderArgs = new Object[] {isPrincipal};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENDA_WHERE);

			sb.append(_FINDER_COLUMN_ISPRINCIPAL_ISPRINCIPAL_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isPrincipal.booleanValue());

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

	private static final String _FINDER_COLUMN_ISPRINCIPAL_ISPRINCIPAL_2 =
		"agenda.isPrincipal = ?";

	private FinderPath _finderPathWithPaginationFindByIsPrincipalAndIsActive;
	private FinderPath _finderPathWithoutPaginationFindByIsPrincipalAndIsActive;
	private FinderPath _finderPathCountByIsPrincipalAndIsActive;

	/**
	 * Returns all the agendas where isPrincipal = &#63; and isActive = &#63;.
	 *
	 * @param isPrincipal the is principal
	 * @param isActive the is active
	 * @return the matching agendas
	 */
	@Override
	public List<Agenda> findByIsPrincipalAndIsActive(
		Boolean isPrincipal, Boolean isActive) {

		return findByIsPrincipalAndIsActive(
			isPrincipal, isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agendas where isPrincipal = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaModelImpl</code>.
	 * </p>
	 *
	 * @param isPrincipal the is principal
	 * @param isActive the is active
	 * @param start the lower bound of the range of agendas
	 * @param end the upper bound of the range of agendas (not inclusive)
	 * @return the range of matching agendas
	 */
	@Override
	public List<Agenda> findByIsPrincipalAndIsActive(
		Boolean isPrincipal, Boolean isActive, int start, int end) {

		return findByIsPrincipalAndIsActive(
			isPrincipal, isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agendas where isPrincipal = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaModelImpl</code>.
	 * </p>
	 *
	 * @param isPrincipal the is principal
	 * @param isActive the is active
	 * @param start the lower bound of the range of agendas
	 * @param end the upper bound of the range of agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agendas
	 */
	@Override
	public List<Agenda> findByIsPrincipalAndIsActive(
		Boolean isPrincipal, Boolean isActive, int start, int end,
		OrderByComparator<Agenda> orderByComparator) {

		return findByIsPrincipalAndIsActive(
			isPrincipal, isActive, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agendas where isPrincipal = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaModelImpl</code>.
	 * </p>
	 *
	 * @param isPrincipal the is principal
	 * @param isActive the is active
	 * @param start the lower bound of the range of agendas
	 * @param end the upper bound of the range of agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agendas
	 */
	@Override
	public List<Agenda> findByIsPrincipalAndIsActive(
		Boolean isPrincipal, Boolean isActive, int start, int end,
		OrderByComparator<Agenda> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByIsPrincipalAndIsActive;
				finderArgs = new Object[] {isPrincipal, isActive};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsPrincipalAndIsActive;
			finderArgs = new Object[] {
				isPrincipal, isActive, start, end, orderByComparator
			};
		}

		List<Agenda> list = null;

		if (useFinderCache) {
			list = (List<Agenda>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Agenda agenda : list) {
					if (!Objects.equals(isPrincipal, agenda.getIsPrincipal()) ||
						!Objects.equals(isActive, agenda.getIsActive())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_AGENDA_WHERE);

			sb.append(_FINDER_COLUMN_ISPRINCIPALANDISACTIVE_ISPRINCIPAL_2);

			sb.append(_FINDER_COLUMN_ISPRINCIPALANDISACTIVE_ISACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isPrincipal.booleanValue());

				queryPos.add(isActive.booleanValue());

				list = (List<Agenda>)QueryUtil.list(
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
	 * Returns the first agenda in the ordered set where isPrincipal = &#63; and isActive = &#63;.
	 *
	 * @param isPrincipal the is principal
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda
	 * @throws NoSuchAgendaException if a matching agenda could not be found
	 */
	@Override
	public Agenda findByIsPrincipalAndIsActive_First(
			Boolean isPrincipal, Boolean isActive,
			OrderByComparator<Agenda> orderByComparator)
		throws NoSuchAgendaException {

		Agenda agenda = fetchByIsPrincipalAndIsActive_First(
			isPrincipal, isActive, orderByComparator);

		if (agenda != null) {
			return agenda;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isPrincipal=");
		sb.append(isPrincipal);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchAgendaException(sb.toString());
	}

	/**
	 * Returns the first agenda in the ordered set where isPrincipal = &#63; and isActive = &#63;.
	 *
	 * @param isPrincipal the is principal
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda, or <code>null</code> if a matching agenda could not be found
	 */
	@Override
	public Agenda fetchByIsPrincipalAndIsActive_First(
		Boolean isPrincipal, Boolean isActive,
		OrderByComparator<Agenda> orderByComparator) {

		List<Agenda> list = findByIsPrincipalAndIsActive(
			isPrincipal, isActive, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agenda in the ordered set where isPrincipal = &#63; and isActive = &#63;.
	 *
	 * @param isPrincipal the is principal
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda
	 * @throws NoSuchAgendaException if a matching agenda could not be found
	 */
	@Override
	public Agenda findByIsPrincipalAndIsActive_Last(
			Boolean isPrincipal, Boolean isActive,
			OrderByComparator<Agenda> orderByComparator)
		throws NoSuchAgendaException {

		Agenda agenda = fetchByIsPrincipalAndIsActive_Last(
			isPrincipal, isActive, orderByComparator);

		if (agenda != null) {
			return agenda;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isPrincipal=");
		sb.append(isPrincipal);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchAgendaException(sb.toString());
	}

	/**
	 * Returns the last agenda in the ordered set where isPrincipal = &#63; and isActive = &#63;.
	 *
	 * @param isPrincipal the is principal
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda, or <code>null</code> if a matching agenda could not be found
	 */
	@Override
	public Agenda fetchByIsPrincipalAndIsActive_Last(
		Boolean isPrincipal, Boolean isActive,
		OrderByComparator<Agenda> orderByComparator) {

		int count = countByIsPrincipalAndIsActive(isPrincipal, isActive);

		if (count == 0) {
			return null;
		}

		List<Agenda> list = findByIsPrincipalAndIsActive(
			isPrincipal, isActive, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agendas before and after the current agenda in the ordered set where isPrincipal = &#63; and isActive = &#63;.
	 *
	 * @param agendaId the primary key of the current agenda
	 * @param isPrincipal the is principal
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda
	 * @throws NoSuchAgendaException if a agenda with the primary key could not be found
	 */
	@Override
	public Agenda[] findByIsPrincipalAndIsActive_PrevAndNext(
			long agendaId, Boolean isPrincipal, Boolean isActive,
			OrderByComparator<Agenda> orderByComparator)
		throws NoSuchAgendaException {

		Agenda agenda = findByPrimaryKey(agendaId);

		Session session = null;

		try {
			session = openSession();

			Agenda[] array = new AgendaImpl[3];

			array[0] = getByIsPrincipalAndIsActive_PrevAndNext(
				session, agenda, isPrincipal, isActive, orderByComparator,
				true);

			array[1] = agenda;

			array[2] = getByIsPrincipalAndIsActive_PrevAndNext(
				session, agenda, isPrincipal, isActive, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Agenda getByIsPrincipalAndIsActive_PrevAndNext(
		Session session, Agenda agenda, Boolean isPrincipal, Boolean isActive,
		OrderByComparator<Agenda> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AGENDA_WHERE);

		sb.append(_FINDER_COLUMN_ISPRINCIPALANDISACTIVE_ISPRINCIPAL_2);

		sb.append(_FINDER_COLUMN_ISPRINCIPALANDISACTIVE_ISACTIVE_2);

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
			sb.append(AgendaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isPrincipal.booleanValue());

		queryPos.add(isActive.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(agenda)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Agenda> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agendas where isPrincipal = &#63; and isActive = &#63; from the database.
	 *
	 * @param isPrincipal the is principal
	 * @param isActive the is active
	 */
	@Override
	public void removeByIsPrincipalAndIsActive(
		Boolean isPrincipal, Boolean isActive) {

		for (Agenda agenda :
				findByIsPrincipalAndIsActive(
					isPrincipal, isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(agenda);
		}
	}

	/**
	 * Returns the number of agendas where isPrincipal = &#63; and isActive = &#63;.
	 *
	 * @param isPrincipal the is principal
	 * @param isActive the is active
	 * @return the number of matching agendas
	 */
	@Override
	public int countByIsPrincipalAndIsActive(
		Boolean isPrincipal, Boolean isActive) {

		FinderPath finderPath = _finderPathCountByIsPrincipalAndIsActive;

		Object[] finderArgs = new Object[] {isPrincipal, isActive};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AGENDA_WHERE);

			sb.append(_FINDER_COLUMN_ISPRINCIPALANDISACTIVE_ISPRINCIPAL_2);

			sb.append(_FINDER_COLUMN_ISPRINCIPALANDISACTIVE_ISACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isPrincipal.booleanValue());

				queryPos.add(isActive.booleanValue());

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

	private static final String
		_FINDER_COLUMN_ISPRINCIPALANDISACTIVE_ISPRINCIPAL_2 =
			"agenda.isPrincipal = ? AND ";

	private static final String
		_FINDER_COLUMN_ISPRINCIPALANDISACTIVE_ISACTIVE_2 =
			"agenda.isActive = ?";

	public AgendaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Agenda.class);

		setModelImplClass(AgendaImpl.class);
		setModelPKClass(long.class);

		setTable(AgendaTable.INSTANCE);
	}

	/**
	 * Caches the agenda in the entity cache if it is enabled.
	 *
	 * @param agenda the agenda
	 */
	@Override
	public void cacheResult(Agenda agenda) {
		dummyEntityCache.putResult(
			AgendaImpl.class, agenda.getPrimaryKey(), agenda);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the agendas in the entity cache if it is enabled.
	 *
	 * @param agendas the agendas
	 */
	@Override
	public void cacheResult(List<Agenda> agendas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (agendas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Agenda agenda : agendas) {
			if (dummyEntityCache.getResult(
					AgendaImpl.class, agenda.getPrimaryKey()) == null) {

				cacheResult(agenda);
			}
		}
	}

	/**
	 * Clears the cache for all agendas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(AgendaImpl.class);

		dummyFinderCache.clearCache(AgendaImpl.class);
	}

	/**
	 * Clears the cache for the agenda.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Agenda agenda) {
		dummyEntityCache.removeResult(AgendaImpl.class, agenda);
	}

	@Override
	public void clearCache(List<Agenda> agendas) {
		for (Agenda agenda : agendas) {
			dummyEntityCache.removeResult(AgendaImpl.class, agenda);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(AgendaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(AgendaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new agenda with the primary key. Does not add the agenda to the database.
	 *
	 * @param agendaId the primary key for the new agenda
	 * @return the new agenda
	 */
	@Override
	public Agenda create(long agendaId) {
		Agenda agenda = new AgendaImpl();

		agenda.setNew(true);
		agenda.setPrimaryKey(agendaId);

		String uuid = PortalUUIDUtil.generate();

		agenda.setUuid(uuid);

		return agenda;
	}

	/**
	 * Removes the agenda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agendaId the primary key of the agenda
	 * @return the agenda that was removed
	 * @throws NoSuchAgendaException if a agenda with the primary key could not be found
	 */
	@Override
	public Agenda remove(long agendaId) throws NoSuchAgendaException {
		return remove((Serializable)agendaId);
	}

	/**
	 * Removes the agenda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the agenda
	 * @return the agenda that was removed
	 * @throws NoSuchAgendaException if a agenda with the primary key could not be found
	 */
	@Override
	public Agenda remove(Serializable primaryKey) throws NoSuchAgendaException {
		Session session = null;

		try {
			session = openSession();

			Agenda agenda = (Agenda)session.get(AgendaImpl.class, primaryKey);

			if (agenda == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAgendaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(agenda);
		}
		catch (NoSuchAgendaException noSuchEntityException) {
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
	protected Agenda removeImpl(Agenda agenda) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(agenda)) {
				agenda = (Agenda)session.get(
					AgendaImpl.class, agenda.getPrimaryKeyObj());
			}

			if (agenda != null) {
				session.delete(agenda);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (agenda != null) {
			clearCache(agenda);
		}

		return agenda;
	}

	@Override
	public Agenda updateImpl(Agenda agenda) {
		boolean isNew = agenda.isNew();

		if (!(agenda instanceof AgendaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(agenda.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(agenda);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in agenda proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Agenda implementation " +
					agenda.getClass());
		}

		AgendaModelImpl agendaModelImpl = (AgendaModelImpl)agenda;

		if (Validator.isNull(agenda.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			agenda.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(agenda);
			}
			else {
				agenda = (Agenda)session.merge(agenda);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			AgendaImpl.class, agendaModelImpl, false, true);

		if (isNew) {
			agenda.setNew(false);
		}

		agenda.resetOriginalValues();

		return agenda;
	}

	/**
	 * Returns the agenda with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agenda
	 * @return the agenda
	 * @throws NoSuchAgendaException if a agenda with the primary key could not be found
	 */
	@Override
	public Agenda findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAgendaException {

		Agenda agenda = fetchByPrimaryKey(primaryKey);

		if (agenda == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAgendaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return agenda;
	}

	/**
	 * Returns the agenda with the primary key or throws a <code>NoSuchAgendaException</code> if it could not be found.
	 *
	 * @param agendaId the primary key of the agenda
	 * @return the agenda
	 * @throws NoSuchAgendaException if a agenda with the primary key could not be found
	 */
	@Override
	public Agenda findByPrimaryKey(long agendaId) throws NoSuchAgendaException {
		return findByPrimaryKey((Serializable)agendaId);
	}

	/**
	 * Returns the agenda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agendaId the primary key of the agenda
	 * @return the agenda, or <code>null</code> if a agenda with the primary key could not be found
	 */
	@Override
	public Agenda fetchByPrimaryKey(long agendaId) {
		return fetchByPrimaryKey((Serializable)agendaId);
	}

	/**
	 * Returns all the agendas.
	 *
	 * @return the agendas
	 */
	@Override
	public List<Agenda> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agendas
	 * @param end the upper bound of the range of agendas (not inclusive)
	 * @return the range of agendas
	 */
	@Override
	public List<Agenda> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agendas
	 * @param end the upper bound of the range of agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agendas
	 */
	@Override
	public List<Agenda> findAll(
		int start, int end, OrderByComparator<Agenda> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agendas
	 * @param end the upper bound of the range of agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agendas
	 */
	@Override
	public List<Agenda> findAll(
		int start, int end, OrderByComparator<Agenda> orderByComparator,
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

		List<Agenda> list = null;

		if (useFinderCache) {
			list = (List<Agenda>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AGENDA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AGENDA;

				sql = sql.concat(AgendaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Agenda>)QueryUtil.list(
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
	 * Removes all the agendas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Agenda agenda : findAll()) {
			remove(agenda);
		}
	}

	/**
	 * Returns the number of agendas.
	 *
	 * @return the number of agendas
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AGENDA);

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
		return "agendaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AGENDA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AgendaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the agenda persistence.
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

		_finderPathWithPaginationFindByIsPrincipal = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsPrincipal",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isPrincipal"}, true);

		_finderPathWithoutPaginationFindByIsPrincipal = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsPrincipal",
			new String[] {Boolean.class.getName()},
			new String[] {"isPrincipal"}, true);

		_finderPathCountByIsPrincipal = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsPrincipal",
			new String[] {Boolean.class.getName()},
			new String[] {"isPrincipal"}, false);

		_finderPathWithPaginationFindByIsPrincipalAndIsActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIsPrincipalAndIsActive",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"isPrincipal", "isActive"}, true);

		_finderPathWithoutPaginationFindByIsPrincipalAndIsActive =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByIsPrincipalAndIsActive",
				new String[] {Boolean.class.getName(), Boolean.class.getName()},
				new String[] {"isPrincipal", "isActive"}, true);

		_finderPathCountByIsPrincipalAndIsActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIsPrincipalAndIsActive",
			new String[] {Boolean.class.getName(), Boolean.class.getName()},
			new String[] {"isPrincipal", "isActive"}, false);

		AgendaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AgendaUtil.setPersistence(null);

		dummyEntityCache.removeCache(AgendaImpl.class.getName());
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

	private static final String _SQL_SELECT_AGENDA =
		"SELECT agenda FROM Agenda agenda";

	private static final String _SQL_SELECT_AGENDA_WHERE =
		"SELECT agenda FROM Agenda agenda WHERE ";

	private static final String _SQL_COUNT_AGENDA =
		"SELECT COUNT(agenda) FROM Agenda agenda";

	private static final String _SQL_COUNT_AGENDA_WHERE =
		"SELECT COUNT(agenda) FROM Agenda agenda WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "agenda.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Agenda exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Agenda exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AgendaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}