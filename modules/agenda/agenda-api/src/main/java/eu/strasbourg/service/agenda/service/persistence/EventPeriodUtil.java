/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.agenda.model.EventPeriod;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the event period service. This utility wraps <code>eu.strasbourg.service.agenda.service.persistence.impl.EventPeriodPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see EventPeriodPersistence
 * @generated
 */
public class EventPeriodUtil {

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
	public static void clearCache(EventPeriod eventPeriod) {
		getPersistence().clearCache(eventPeriod);
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
	public static Map<Serializable, EventPeriod> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EventPeriod> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EventPeriod> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EventPeriod> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EventPeriod> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EventPeriod update(EventPeriod eventPeriod) {
		return getPersistence().update(eventPeriod);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EventPeriod update(
		EventPeriod eventPeriod, ServiceContext serviceContext) {

		return getPersistence().update(eventPeriod, serviceContext);
	}

	/**
	 * Returns all the event periods where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event periods
	 */
	public static List<EventPeriod> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the event periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of matching event periods
	 */
	public static List<EventPeriod> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the event periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event periods
	 */
	public static List<EventPeriod> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventPeriod> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the event periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event periods
	 */
	public static List<EventPeriod> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventPeriod> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first event period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	public static EventPeriod findByUuid_First(
			String uuid, OrderByComparator<EventPeriod> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchEventPeriodException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first event period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period, or <code>null</code> if a matching event period could not be found
	 */
	public static EventPeriod fetchByUuid_First(
		String uuid, OrderByComparator<EventPeriod> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last event period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	public static EventPeriod findByUuid_Last(
			String uuid, OrderByComparator<EventPeriod> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchEventPeriodException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last event period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period, or <code>null</code> if a matching event period could not be found
	 */
	public static EventPeriod fetchByUuid_Last(
		String uuid, OrderByComparator<EventPeriod> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the event periods before and after the current event period in the ordered set where uuid = &#63;.
	 *
	 * @param eventPeriodId the primary key of the current event period
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event period
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	public static EventPeriod[] findByUuid_PrevAndNext(
			long eventPeriodId, String uuid,
			OrderByComparator<EventPeriod> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchEventPeriodException {

		return getPersistence().findByUuid_PrevAndNext(
			eventPeriodId, uuid, orderByComparator);
	}

	/**
	 * Removes all the event periods where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of event periods where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event periods
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the event periods where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching event periods
	 */
	public static List<EventPeriod> findByEventId(long eventId) {
		return getPersistence().findByEventId(eventId);
	}

	/**
	 * Returns a range of all the event periods where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of matching event periods
	 */
	public static List<EventPeriod> findByEventId(
		long eventId, int start, int end) {

		return getPersistence().findByEventId(eventId, start, end);
	}

	/**
	 * Returns an ordered range of all the event periods where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event periods
	 */
	public static List<EventPeriod> findByEventId(
		long eventId, int start, int end,
		OrderByComparator<EventPeriod> orderByComparator) {

		return getPersistence().findByEventId(
			eventId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the event periods where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event periods
	 */
	public static List<EventPeriod> findByEventId(
		long eventId, int start, int end,
		OrderByComparator<EventPeriod> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEventId(
			eventId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	public static EventPeriod findByEventId_First(
			long eventId, OrderByComparator<EventPeriod> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchEventPeriodException {

		return getPersistence().findByEventId_First(eventId, orderByComparator);
	}

	/**
	 * Returns the first event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period, or <code>null</code> if a matching event period could not be found
	 */
	public static EventPeriod fetchByEventId_First(
		long eventId, OrderByComparator<EventPeriod> orderByComparator) {

		return getPersistence().fetchByEventId_First(
			eventId, orderByComparator);
	}

	/**
	 * Returns the last event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	public static EventPeriod findByEventId_Last(
			long eventId, OrderByComparator<EventPeriod> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchEventPeriodException {

		return getPersistence().findByEventId_Last(eventId, orderByComparator);
	}

	/**
	 * Returns the last event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period, or <code>null</code> if a matching event period could not be found
	 */
	public static EventPeriod fetchByEventId_Last(
		long eventId, OrderByComparator<EventPeriod> orderByComparator) {

		return getPersistence().fetchByEventId_Last(eventId, orderByComparator);
	}

	/**
	 * Returns the event periods before and after the current event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventPeriodId the primary key of the current event period
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event period
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	public static EventPeriod[] findByEventId_PrevAndNext(
			long eventPeriodId, long eventId,
			OrderByComparator<EventPeriod> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchEventPeriodException {

		return getPersistence().findByEventId_PrevAndNext(
			eventPeriodId, eventId, orderByComparator);
	}

	/**
	 * Removes all the event periods where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 */
	public static void removeByEventId(long eventId) {
		getPersistence().removeByEventId(eventId);
	}

	/**
	 * Returns the number of event periods where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching event periods
	 */
	public static int countByEventId(long eventId) {
		return getPersistence().countByEventId(eventId);
	}

	/**
	 * Returns all the event periods where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @return the matching event periods
	 */
	public static List<EventPeriod> findByCampaignEventId(
		long campaignEventId) {

		return getPersistence().findByCampaignEventId(campaignEventId);
	}

	/**
	 * Returns a range of all the event periods where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of matching event periods
	 */
	public static List<EventPeriod> findByCampaignEventId(
		long campaignEventId, int start, int end) {

		return getPersistence().findByCampaignEventId(
			campaignEventId, start, end);
	}

	/**
	 * Returns an ordered range of all the event periods where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event periods
	 */
	public static List<EventPeriod> findByCampaignEventId(
		long campaignEventId, int start, int end,
		OrderByComparator<EventPeriod> orderByComparator) {

		return getPersistence().findByCampaignEventId(
			campaignEventId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the event periods where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event periods
	 */
	public static List<EventPeriod> findByCampaignEventId(
		long campaignEventId, int start, int end,
		OrderByComparator<EventPeriod> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCampaignEventId(
			campaignEventId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	public static EventPeriod findByCampaignEventId_First(
			long campaignEventId,
			OrderByComparator<EventPeriod> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchEventPeriodException {

		return getPersistence().findByCampaignEventId_First(
			campaignEventId, orderByComparator);
	}

	/**
	 * Returns the first event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period, or <code>null</code> if a matching event period could not be found
	 */
	public static EventPeriod fetchByCampaignEventId_First(
		long campaignEventId,
		OrderByComparator<EventPeriod> orderByComparator) {

		return getPersistence().fetchByCampaignEventId_First(
			campaignEventId, orderByComparator);
	}

	/**
	 * Returns the last event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	public static EventPeriod findByCampaignEventId_Last(
			long campaignEventId,
			OrderByComparator<EventPeriod> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchEventPeriodException {

		return getPersistence().findByCampaignEventId_Last(
			campaignEventId, orderByComparator);
	}

	/**
	 * Returns the last event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period, or <code>null</code> if a matching event period could not be found
	 */
	public static EventPeriod fetchByCampaignEventId_Last(
		long campaignEventId,
		OrderByComparator<EventPeriod> orderByComparator) {

		return getPersistence().fetchByCampaignEventId_Last(
			campaignEventId, orderByComparator);
	}

	/**
	 * Returns the event periods before and after the current event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param eventPeriodId the primary key of the current event period
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event period
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	public static EventPeriod[] findByCampaignEventId_PrevAndNext(
			long eventPeriodId, long campaignEventId,
			OrderByComparator<EventPeriod> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchEventPeriodException {

		return getPersistence().findByCampaignEventId_PrevAndNext(
			eventPeriodId, campaignEventId, orderByComparator);
	}

	/**
	 * Removes all the event periods where campaignEventId = &#63; from the database.
	 *
	 * @param campaignEventId the campaign event ID
	 */
	public static void removeByCampaignEventId(long campaignEventId) {
		getPersistence().removeByCampaignEventId(campaignEventId);
	}

	/**
	 * Returns the number of event periods where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @return the number of matching event periods
	 */
	public static int countByCampaignEventId(long campaignEventId) {
		return getPersistence().countByCampaignEventId(campaignEventId);
	}

	/**
	 * Caches the event period in the entity cache if it is enabled.
	 *
	 * @param eventPeriod the event period
	 */
	public static void cacheResult(EventPeriod eventPeriod) {
		getPersistence().cacheResult(eventPeriod);
	}

	/**
	 * Caches the event periods in the entity cache if it is enabled.
	 *
	 * @param eventPeriods the event periods
	 */
	public static void cacheResult(List<EventPeriod> eventPeriods) {
		getPersistence().cacheResult(eventPeriods);
	}

	/**
	 * Creates a new event period with the primary key. Does not add the event period to the database.
	 *
	 * @param eventPeriodId the primary key for the new event period
	 * @return the new event period
	 */
	public static EventPeriod create(long eventPeriodId) {
		return getPersistence().create(eventPeriodId);
	}

	/**
	 * Removes the event period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventPeriodId the primary key of the event period
	 * @return the event period that was removed
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	public static EventPeriod remove(long eventPeriodId)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchEventPeriodException {

		return getPersistence().remove(eventPeriodId);
	}

	public static EventPeriod updateImpl(EventPeriod eventPeriod) {
		return getPersistence().updateImpl(eventPeriod);
	}

	/**
	 * Returns the event period with the primary key or throws a <code>NoSuchEventPeriodException</code> if it could not be found.
	 *
	 * @param eventPeriodId the primary key of the event period
	 * @return the event period
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	public static EventPeriod findByPrimaryKey(long eventPeriodId)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchEventPeriodException {

		return getPersistence().findByPrimaryKey(eventPeriodId);
	}

	/**
	 * Returns the event period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventPeriodId the primary key of the event period
	 * @return the event period, or <code>null</code> if a event period with the primary key could not be found
	 */
	public static EventPeriod fetchByPrimaryKey(long eventPeriodId) {
		return getPersistence().fetchByPrimaryKey(eventPeriodId);
	}

	/**
	 * Returns all the event periods.
	 *
	 * @return the event periods
	 */
	public static List<EventPeriod> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the event periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of event periods
	 */
	public static List<EventPeriod> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the event periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event periods
	 */
	public static List<EventPeriod> findAll(
		int start, int end, OrderByComparator<EventPeriod> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the event periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event periods
	 */
	public static List<EventPeriod> findAll(
		int start, int end, OrderByComparator<EventPeriod> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the event periods from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of event periods.
	 *
	 * @return the number of event periods
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EventPeriodPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EventPeriodPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EventPeriodPersistence _persistence;

}