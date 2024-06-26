/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.council.model.Deliberation;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the deliberation service. This utility wraps <code>eu.strasbourg.service.council.service.persistence.impl.DeliberationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DeliberationPersistence
 * @generated
 */
public class DeliberationUtil {

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
	public static void clearCache(Deliberation deliberation) {
		getPersistence().clearCache(deliberation);
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
	public static Map<Serializable, Deliberation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Deliberation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Deliberation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Deliberation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Deliberation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Deliberation update(Deliberation deliberation) {
		return getPersistence().update(deliberation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Deliberation update(
		Deliberation deliberation, ServiceContext serviceContext) {

		return getPersistence().update(deliberation, serviceContext);
	}

	/**
	 * Returns all the deliberations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching deliberations
	 */
	public static List<Deliberation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the deliberations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @return the range of matching deliberations
	 */
	public static List<Deliberation> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the deliberations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching deliberations
	 */
	public static List<Deliberation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Deliberation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the deliberations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching deliberations
	 */
	public static List<Deliberation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Deliberation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first deliberation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public static Deliberation findByUuid_First(
			String uuid, OrderByComparator<Deliberation> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchDeliberationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first deliberation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public static Deliberation fetchByUuid_First(
		String uuid, OrderByComparator<Deliberation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last deliberation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public static Deliberation findByUuid_Last(
			String uuid, OrderByComparator<Deliberation> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchDeliberationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last deliberation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public static Deliberation fetchByUuid_Last(
		String uuid, OrderByComparator<Deliberation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the deliberations before and after the current deliberation in the ordered set where uuid = &#63;.
	 *
	 * @param deliberationId the primary key of the current deliberation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next deliberation
	 * @throws NoSuchDeliberationException if a deliberation with the primary key could not be found
	 */
	public static Deliberation[] findByUuid_PrevAndNext(
			long deliberationId, String uuid,
			OrderByComparator<Deliberation> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchDeliberationException {

		return getPersistence().findByUuid_PrevAndNext(
			deliberationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the deliberations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of deliberations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching deliberations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the deliberation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDeliberationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public static Deliberation findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.council.exception.
			NoSuchDeliberationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the deliberation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public static Deliberation fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the deliberation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public static Deliberation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the deliberation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the deliberation that was removed
	 */
	public static Deliberation removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.council.exception.
			NoSuchDeliberationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of deliberations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching deliberations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the deliberations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching deliberations
	 */
	public static List<Deliberation> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the deliberations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @return the range of matching deliberations
	 */
	public static List<Deliberation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the deliberations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching deliberations
	 */
	public static List<Deliberation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Deliberation> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the deliberations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching deliberations
	 */
	public static List<Deliberation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Deliberation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first deliberation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public static Deliberation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Deliberation> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchDeliberationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first deliberation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public static Deliberation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Deliberation> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last deliberation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public static Deliberation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Deliberation> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchDeliberationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last deliberation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public static Deliberation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Deliberation> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the deliberations before and after the current deliberation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param deliberationId the primary key of the current deliberation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next deliberation
	 * @throws NoSuchDeliberationException if a deliberation with the primary key could not be found
	 */
	public static Deliberation[] findByUuid_C_PrevAndNext(
			long deliberationId, String uuid, long companyId,
			OrderByComparator<Deliberation> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchDeliberationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			deliberationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the deliberations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of deliberations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching deliberations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the deliberations where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @return the matching deliberations
	 */
	public static List<Deliberation> findByCouncilSessionId(
		long councilSessionId) {

		return getPersistence().findByCouncilSessionId(councilSessionId);
	}

	/**
	 * Returns a range of all the deliberations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @return the range of matching deliberations
	 */
	public static List<Deliberation> findByCouncilSessionId(
		long councilSessionId, int start, int end) {

		return getPersistence().findByCouncilSessionId(
			councilSessionId, start, end);
	}

	/**
	 * Returns an ordered range of all the deliberations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching deliberations
	 */
	public static List<Deliberation> findByCouncilSessionId(
		long councilSessionId, int start, int end,
		OrderByComparator<Deliberation> orderByComparator) {

		return getPersistence().findByCouncilSessionId(
			councilSessionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the deliberations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching deliberations
	 */
	public static List<Deliberation> findByCouncilSessionId(
		long councilSessionId, int start, int end,
		OrderByComparator<Deliberation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCouncilSessionId(
			councilSessionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first deliberation in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public static Deliberation findByCouncilSessionId_First(
			long councilSessionId,
			OrderByComparator<Deliberation> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchDeliberationException {

		return getPersistence().findByCouncilSessionId_First(
			councilSessionId, orderByComparator);
	}

	/**
	 * Returns the first deliberation in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public static Deliberation fetchByCouncilSessionId_First(
		long councilSessionId,
		OrderByComparator<Deliberation> orderByComparator) {

		return getPersistence().fetchByCouncilSessionId_First(
			councilSessionId, orderByComparator);
	}

	/**
	 * Returns the last deliberation in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public static Deliberation findByCouncilSessionId_Last(
			long councilSessionId,
			OrderByComparator<Deliberation> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchDeliberationException {

		return getPersistence().findByCouncilSessionId_Last(
			councilSessionId, orderByComparator);
	}

	/**
	 * Returns the last deliberation in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public static Deliberation fetchByCouncilSessionId_Last(
		long councilSessionId,
		OrderByComparator<Deliberation> orderByComparator) {

		return getPersistence().fetchByCouncilSessionId_Last(
			councilSessionId, orderByComparator);
	}

	/**
	 * Returns the deliberations before and after the current deliberation in the ordered set where councilSessionId = &#63;.
	 *
	 * @param deliberationId the primary key of the current deliberation
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next deliberation
	 * @throws NoSuchDeliberationException if a deliberation with the primary key could not be found
	 */
	public static Deliberation[] findByCouncilSessionId_PrevAndNext(
			long deliberationId, long councilSessionId,
			OrderByComparator<Deliberation> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchDeliberationException {

		return getPersistence().findByCouncilSessionId_PrevAndNext(
			deliberationId, councilSessionId, orderByComparator);
	}

	/**
	 * Removes all the deliberations where councilSessionId = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 */
	public static void removeByCouncilSessionId(long councilSessionId) {
		getPersistence().removeByCouncilSessionId(councilSessionId);
	}

	/**
	 * Returns the number of deliberations where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @return the number of matching deliberations
	 */
	public static int countByCouncilSessionId(long councilSessionId) {
		return getPersistence().countByCouncilSessionId(councilSessionId);
	}

	/**
	 * Caches the deliberation in the entity cache if it is enabled.
	 *
	 * @param deliberation the deliberation
	 */
	public static void cacheResult(Deliberation deliberation) {
		getPersistence().cacheResult(deliberation);
	}

	/**
	 * Caches the deliberations in the entity cache if it is enabled.
	 *
	 * @param deliberations the deliberations
	 */
	public static void cacheResult(List<Deliberation> deliberations) {
		getPersistence().cacheResult(deliberations);
	}

	/**
	 * Creates a new deliberation with the primary key. Does not add the deliberation to the database.
	 *
	 * @param deliberationId the primary key for the new deliberation
	 * @return the new deliberation
	 */
	public static Deliberation create(long deliberationId) {
		return getPersistence().create(deliberationId);
	}

	/**
	 * Removes the deliberation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deliberationId the primary key of the deliberation
	 * @return the deliberation that was removed
	 * @throws NoSuchDeliberationException if a deliberation with the primary key could not be found
	 */
	public static Deliberation remove(long deliberationId)
		throws eu.strasbourg.service.council.exception.
			NoSuchDeliberationException {

		return getPersistence().remove(deliberationId);
	}

	public static Deliberation updateImpl(Deliberation deliberation) {
		return getPersistence().updateImpl(deliberation);
	}

	/**
	 * Returns the deliberation with the primary key or throws a <code>NoSuchDeliberationException</code> if it could not be found.
	 *
	 * @param deliberationId the primary key of the deliberation
	 * @return the deliberation
	 * @throws NoSuchDeliberationException if a deliberation with the primary key could not be found
	 */
	public static Deliberation findByPrimaryKey(long deliberationId)
		throws eu.strasbourg.service.council.exception.
			NoSuchDeliberationException {

		return getPersistence().findByPrimaryKey(deliberationId);
	}

	/**
	 * Returns the deliberation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deliberationId the primary key of the deliberation
	 * @return the deliberation, or <code>null</code> if a deliberation with the primary key could not be found
	 */
	public static Deliberation fetchByPrimaryKey(long deliberationId) {
		return getPersistence().fetchByPrimaryKey(deliberationId);
	}

	/**
	 * Returns all the deliberations.
	 *
	 * @return the deliberations
	 */
	public static List<Deliberation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the deliberations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @return the range of deliberations
	 */
	public static List<Deliberation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the deliberations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of deliberations
	 */
	public static List<Deliberation> findAll(
		int start, int end, OrderByComparator<Deliberation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the deliberations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of deliberations
	 */
	public static List<Deliberation> findAll(
		int start, int end, OrderByComparator<Deliberation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the deliberations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of deliberations.
	 *
	 * @return the number of deliberations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DeliberationPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(DeliberationPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile DeliberationPersistence _persistence;

}