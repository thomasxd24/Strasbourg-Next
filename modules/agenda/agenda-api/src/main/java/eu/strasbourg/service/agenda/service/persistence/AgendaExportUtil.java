/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.agenda.model.AgendaExport;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the agenda export service. This utility wraps <code>eu.strasbourg.service.agenda.service.persistence.impl.AgendaExportPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see AgendaExportPersistence
 * @generated
 */
public class AgendaExportUtil {

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
	public static void clearCache(AgendaExport agendaExport) {
		getPersistence().clearCache(agendaExport);
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
	public static Map<Serializable, AgendaExport> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AgendaExport> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AgendaExport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AgendaExport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AgendaExport update(AgendaExport agendaExport) {
		return getPersistence().update(agendaExport);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AgendaExport update(
		AgendaExport agendaExport, ServiceContext serviceContext) {

		return getPersistence().update(agendaExport, serviceContext);
	}

	/**
	 * Returns all the agenda exports where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching agenda exports
	 */
	public static List<AgendaExport> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the agenda exports where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @return the range of matching agenda exports
	 */
	public static List<AgendaExport> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the agenda exports where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agenda exports
	 */
	public static List<AgendaExport> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the agenda exports where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agenda exports
	 */
	public static List<AgendaExport> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agenda export in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	public static AgendaExport findByUuid_First(
			String uuid, OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first agenda export in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	public static AgendaExport fetchByUuid_First(
		String uuid, OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last agenda export in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	public static AgendaExport findByUuid_Last(
			String uuid, OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last agenda export in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	public static AgendaExport fetchByUuid_Last(
		String uuid, OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the agenda exports before and after the current agenda export in the ordered set where uuid = &#63;.
	 *
	 * @param agendaExportId the primary key of the current agenda export
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda export
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	public static AgendaExport[] findByUuid_PrevAndNext(
			long agendaExportId, String uuid,
			OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByUuid_PrevAndNext(
			agendaExportId, uuid, orderByComparator);
	}

	/**
	 * Removes all the agenda exports where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of agenda exports where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching agenda exports
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the agenda export where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAgendaExportException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	public static AgendaExport findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the agenda export where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	public static AgendaExport fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the agenda export where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	public static AgendaExport fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the agenda export where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the agenda export that was removed
	 */
	public static AgendaExport removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of agenda exports where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching agenda exports
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the agenda exports where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching agenda exports
	 */
	public static List<AgendaExport> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the agenda exports where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @return the range of matching agenda exports
	 */
	public static List<AgendaExport> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the agenda exports where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agenda exports
	 */
	public static List<AgendaExport> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the agenda exports where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agenda exports
	 */
	public static List<AgendaExport> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agenda export in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	public static AgendaExport findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first agenda export in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	public static AgendaExport fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last agenda export in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	public static AgendaExport findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last agenda export in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	public static AgendaExport fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the agenda exports before and after the current agenda export in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param agendaExportId the primary key of the current agenda export
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda export
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	public static AgendaExport[] findByUuid_C_PrevAndNext(
			long agendaExportId, String uuid, long companyId,
			OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByUuid_C_PrevAndNext(
			agendaExportId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the agenda exports where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of agenda exports where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching agenda exports
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the agenda exports where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching agenda exports
	 */
	public static List<AgendaExport> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the agenda exports where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @return the range of matching agenda exports
	 */
	public static List<AgendaExport> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the agenda exports where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agenda exports
	 */
	public static List<AgendaExport> findByStatus(
		int status, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the agenda exports where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agenda exports
	 */
	public static List<AgendaExport> findByStatus(
		int status, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agenda export in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	public static AgendaExport findByStatus_First(
			int status, OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first agenda export in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	public static AgendaExport fetchByStatus_First(
		int status, OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last agenda export in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	public static AgendaExport findByStatus_Last(
			int status, OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last agenda export in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	public static AgendaExport fetchByStatus_Last(
		int status, OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the agenda exports before and after the current agenda export in the ordered set where status = &#63;.
	 *
	 * @param agendaExportId the primary key of the current agenda export
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda export
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	public static AgendaExport[] findByStatus_PrevAndNext(
			long agendaExportId, int status,
			OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByStatus_PrevAndNext(
			agendaExportId, status, orderByComparator);
	}

	/**
	 * Removes all the agenda exports where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of agenda exports where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching agenda exports
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the agenda exports where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching agenda exports
	 */
	public static List<AgendaExport> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the agenda exports where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @return the range of matching agenda exports
	 */
	public static List<AgendaExport> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the agenda exports where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agenda exports
	 */
	public static List<AgendaExport> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the agenda exports where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agenda exports
	 */
	public static List<AgendaExport> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agenda export in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	public static AgendaExport findByGroupId_First(
			long groupId, OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first agenda export in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	public static AgendaExport fetchByGroupId_First(
		long groupId, OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last agenda export in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	public static AgendaExport findByGroupId_Last(
			long groupId, OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last agenda export in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	public static AgendaExport fetchByGroupId_Last(
		long groupId, OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the agenda exports before and after the current agenda export in the ordered set where groupId = &#63;.
	 *
	 * @param agendaExportId the primary key of the current agenda export
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda export
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	public static AgendaExport[] findByGroupId_PrevAndNext(
			long agendaExportId, long groupId,
			OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByGroupId_PrevAndNext(
			agendaExportId, groupId, orderByComparator);
	}

	/**
	 * Removes all the agenda exports where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of agenda exports where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching agenda exports
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the agenda exports where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching agenda exports
	 */
	public static List<AgendaExport> findByGroupIdAndStatus(
		long groupId, int status) {

		return getPersistence().findByGroupIdAndStatus(groupId, status);
	}

	/**
	 * Returns a range of all the agenda exports where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @return the range of matching agenda exports
	 */
	public static List<AgendaExport> findByGroupIdAndStatus(
		long groupId, int status, int start, int end) {

		return getPersistence().findByGroupIdAndStatus(
			groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the agenda exports where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agenda exports
	 */
	public static List<AgendaExport> findByGroupIdAndStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().findByGroupIdAndStatus(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the agenda exports where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agenda exports
	 */
	public static List<AgendaExport> findByGroupIdAndStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupIdAndStatus(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first agenda export in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	public static AgendaExport findByGroupIdAndStatus_First(
			long groupId, int status,
			OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByGroupIdAndStatus_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first agenda export in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	public static AgendaExport fetchByGroupIdAndStatus_First(
		long groupId, int status,
		OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().fetchByGroupIdAndStatus_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last agenda export in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	public static AgendaExport findByGroupIdAndStatus_Last(
			long groupId, int status,
			OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByGroupIdAndStatus_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last agenda export in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	public static AgendaExport fetchByGroupIdAndStatus_Last(
		long groupId, int status,
		OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().fetchByGroupIdAndStatus_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the agenda exports before and after the current agenda export in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param agendaExportId the primary key of the current agenda export
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda export
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	public static AgendaExport[] findByGroupIdAndStatus_PrevAndNext(
			long agendaExportId, long groupId, int status,
			OrderByComparator<AgendaExport> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByGroupIdAndStatus_PrevAndNext(
			agendaExportId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the agenda exports where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByGroupIdAndStatus(long groupId, int status) {
		getPersistence().removeByGroupIdAndStatus(groupId, status);
	}

	/**
	 * Returns the number of agenda exports where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching agenda exports
	 */
	public static int countByGroupIdAndStatus(long groupId, int status) {
		return getPersistence().countByGroupIdAndStatus(groupId, status);
	}

	/**
	 * Caches the agenda export in the entity cache if it is enabled.
	 *
	 * @param agendaExport the agenda export
	 */
	public static void cacheResult(AgendaExport agendaExport) {
		getPersistence().cacheResult(agendaExport);
	}

	/**
	 * Caches the agenda exports in the entity cache if it is enabled.
	 *
	 * @param agendaExports the agenda exports
	 */
	public static void cacheResult(List<AgendaExport> agendaExports) {
		getPersistence().cacheResult(agendaExports);
	}

	/**
	 * Creates a new agenda export with the primary key. Does not add the agenda export to the database.
	 *
	 * @param agendaExportId the primary key for the new agenda export
	 * @return the new agenda export
	 */
	public static AgendaExport create(long agendaExportId) {
		return getPersistence().create(agendaExportId);
	}

	/**
	 * Removes the agenda export with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agendaExportId the primary key of the agenda export
	 * @return the agenda export that was removed
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	public static AgendaExport remove(long agendaExportId)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().remove(agendaExportId);
	}

	public static AgendaExport updateImpl(AgendaExport agendaExport) {
		return getPersistence().updateImpl(agendaExport);
	}

	/**
	 * Returns the agenda export with the primary key or throws a <code>NoSuchAgendaExportException</code> if it could not be found.
	 *
	 * @param agendaExportId the primary key of the agenda export
	 * @return the agenda export
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	public static AgendaExport findByPrimaryKey(long agendaExportId)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchAgendaExportException {

		return getPersistence().findByPrimaryKey(agendaExportId);
	}

	/**
	 * Returns the agenda export with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agendaExportId the primary key of the agenda export
	 * @return the agenda export, or <code>null</code> if a agenda export with the primary key could not be found
	 */
	public static AgendaExport fetchByPrimaryKey(long agendaExportId) {
		return getPersistence().fetchByPrimaryKey(agendaExportId);
	}

	/**
	 * Returns all the agenda exports.
	 *
	 * @return the agenda exports
	 */
	public static List<AgendaExport> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the agenda exports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @return the range of agenda exports
	 */
	public static List<AgendaExport> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the agenda exports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agenda exports
	 */
	public static List<AgendaExport> findAll(
		int start, int end, OrderByComparator<AgendaExport> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the agenda exports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agenda exports
	 */
	public static List<AgendaExport> findAll(
		int start, int end, OrderByComparator<AgendaExport> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the agenda exports from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of agenda exports.
	 *
	 * @return the number of agenda exports
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AgendaExportPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AgendaExportPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AgendaExportPersistence _persistence;

}