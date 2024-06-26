/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.interest.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.interest.model.Interest;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the interest service. This utility wraps <code>eu.strasbourg.service.interest.service.persistence.impl.InterestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see InterestPersistence
 * @generated
 */
public class InterestUtil {

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
	public static void clearCache(Interest interest) {
		getPersistence().clearCache(interest);
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
	public static Map<Serializable, Interest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Interest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Interest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Interest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Interest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Interest update(Interest interest) {
		return getPersistence().update(interest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Interest update(
		Interest interest, ServiceContext serviceContext) {

		return getPersistence().update(interest, serviceContext);
	}

	/**
	 * Returns all the interests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching interests
	 */
	public static List<Interest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the interests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @return the range of matching interests
	 */
	public static List<Interest> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the interests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching interests
	 */
	public static List<Interest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Interest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the interests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching interests
	 */
	public static List<Interest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Interest> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first interest in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interest
	 * @throws NoSuchInterestException if a matching interest could not be found
	 */
	public static Interest findByUuid_First(
			String uuid, OrderByComparator<Interest> orderByComparator)
		throws eu.strasbourg.service.interest.exception.
			NoSuchInterestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first interest in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interest, or <code>null</code> if a matching interest could not be found
	 */
	public static Interest fetchByUuid_First(
		String uuid, OrderByComparator<Interest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last interest in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interest
	 * @throws NoSuchInterestException if a matching interest could not be found
	 */
	public static Interest findByUuid_Last(
			String uuid, OrderByComparator<Interest> orderByComparator)
		throws eu.strasbourg.service.interest.exception.
			NoSuchInterestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last interest in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interest, or <code>null</code> if a matching interest could not be found
	 */
	public static Interest fetchByUuid_Last(
		String uuid, OrderByComparator<Interest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the interests before and after the current interest in the ordered set where uuid = &#63;.
	 *
	 * @param interestId the primary key of the current interest
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interest
	 * @throws NoSuchInterestException if a interest with the primary key could not be found
	 */
	public static Interest[] findByUuid_PrevAndNext(
			long interestId, String uuid,
			OrderByComparator<Interest> orderByComparator)
		throws eu.strasbourg.service.interest.exception.
			NoSuchInterestException {

		return getPersistence().findByUuid_PrevAndNext(
			interestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the interests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of interests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching interests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the interest where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchInterestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching interest
	 * @throws NoSuchInterestException if a matching interest could not be found
	 */
	public static Interest findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.interest.exception.
			NoSuchInterestException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the interest where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching interest, or <code>null</code> if a matching interest could not be found
	 */
	public static Interest fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the interest where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching interest, or <code>null</code> if a matching interest could not be found
	 */
	public static Interest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the interest where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the interest that was removed
	 */
	public static Interest removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.interest.exception.
			NoSuchInterestException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of interests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching interests
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the interests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching interests
	 */
	public static List<Interest> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the interests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @return the range of matching interests
	 */
	public static List<Interest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the interests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching interests
	 */
	public static List<Interest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Interest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the interests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching interests
	 */
	public static List<Interest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Interest> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first interest in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interest
	 * @throws NoSuchInterestException if a matching interest could not be found
	 */
	public static Interest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Interest> orderByComparator)
		throws eu.strasbourg.service.interest.exception.
			NoSuchInterestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first interest in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interest, or <code>null</code> if a matching interest could not be found
	 */
	public static Interest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Interest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last interest in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interest
	 * @throws NoSuchInterestException if a matching interest could not be found
	 */
	public static Interest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Interest> orderByComparator)
		throws eu.strasbourg.service.interest.exception.
			NoSuchInterestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last interest in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interest, or <code>null</code> if a matching interest could not be found
	 */
	public static Interest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Interest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the interests before and after the current interest in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param interestId the primary key of the current interest
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interest
	 * @throws NoSuchInterestException if a interest with the primary key could not be found
	 */
	public static Interest[] findByUuid_C_PrevAndNext(
			long interestId, String uuid, long companyId,
			OrderByComparator<Interest> orderByComparator)
		throws eu.strasbourg.service.interest.exception.
			NoSuchInterestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			interestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the interests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of interests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching interests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the interests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching interests
	 */
	public static List<Interest> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the interests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @return the range of matching interests
	 */
	public static List<Interest> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the interests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching interests
	 */
	public static List<Interest> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Interest> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the interests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching interests
	 */
	public static List<Interest> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Interest> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first interest in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interest
	 * @throws NoSuchInterestException if a matching interest could not be found
	 */
	public static Interest findByGroupId_First(
			long groupId, OrderByComparator<Interest> orderByComparator)
		throws eu.strasbourg.service.interest.exception.
			NoSuchInterestException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first interest in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interest, or <code>null</code> if a matching interest could not be found
	 */
	public static Interest fetchByGroupId_First(
		long groupId, OrderByComparator<Interest> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last interest in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interest
	 * @throws NoSuchInterestException if a matching interest could not be found
	 */
	public static Interest findByGroupId_Last(
			long groupId, OrderByComparator<Interest> orderByComparator)
		throws eu.strasbourg.service.interest.exception.
			NoSuchInterestException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last interest in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interest, or <code>null</code> if a matching interest could not be found
	 */
	public static Interest fetchByGroupId_Last(
		long groupId, OrderByComparator<Interest> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the interests before and after the current interest in the ordered set where groupId = &#63;.
	 *
	 * @param interestId the primary key of the current interest
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interest
	 * @throws NoSuchInterestException if a interest with the primary key could not be found
	 */
	public static Interest[] findByGroupId_PrevAndNext(
			long interestId, long groupId,
			OrderByComparator<Interest> orderByComparator)
		throws eu.strasbourg.service.interest.exception.
			NoSuchInterestException {

		return getPersistence().findByGroupId_PrevAndNext(
			interestId, groupId, orderByComparator);
	}

	/**
	 * Removes all the interests where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of interests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching interests
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the interest in the entity cache if it is enabled.
	 *
	 * @param interest the interest
	 */
	public static void cacheResult(Interest interest) {
		getPersistence().cacheResult(interest);
	}

	/**
	 * Caches the interests in the entity cache if it is enabled.
	 *
	 * @param interests the interests
	 */
	public static void cacheResult(List<Interest> interests) {
		getPersistence().cacheResult(interests);
	}

	/**
	 * Creates a new interest with the primary key. Does not add the interest to the database.
	 *
	 * @param interestId the primary key for the new interest
	 * @return the new interest
	 */
	public static Interest create(long interestId) {
		return getPersistence().create(interestId);
	}

	/**
	 * Removes the interest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interestId the primary key of the interest
	 * @return the interest that was removed
	 * @throws NoSuchInterestException if a interest with the primary key could not be found
	 */
	public static Interest remove(long interestId)
		throws eu.strasbourg.service.interest.exception.
			NoSuchInterestException {

		return getPersistence().remove(interestId);
	}

	public static Interest updateImpl(Interest interest) {
		return getPersistence().updateImpl(interest);
	}

	/**
	 * Returns the interest with the primary key or throws a <code>NoSuchInterestException</code> if it could not be found.
	 *
	 * @param interestId the primary key of the interest
	 * @return the interest
	 * @throws NoSuchInterestException if a interest with the primary key could not be found
	 */
	public static Interest findByPrimaryKey(long interestId)
		throws eu.strasbourg.service.interest.exception.
			NoSuchInterestException {

		return getPersistence().findByPrimaryKey(interestId);
	}

	/**
	 * Returns the interest with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param interestId the primary key of the interest
	 * @return the interest, or <code>null</code> if a interest with the primary key could not be found
	 */
	public static Interest fetchByPrimaryKey(long interestId) {
		return getPersistence().fetchByPrimaryKey(interestId);
	}

	/**
	 * Returns all the interests.
	 *
	 * @return the interests
	 */
	public static List<Interest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the interests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @return the range of interests
	 */
	public static List<Interest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the interests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of interests
	 */
	public static List<Interest> findAll(
		int start, int end, OrderByComparator<Interest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the interests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of interests
	 */
	public static List<Interest> findAll(
		int start, int end, OrderByComparator<Interest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the interests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of interests.
	 *
	 * @return the number of interests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InterestPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(InterestPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile InterestPersistence _persistence;

}