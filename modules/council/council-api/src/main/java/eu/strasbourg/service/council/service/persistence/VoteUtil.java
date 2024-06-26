/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.council.model.Vote;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the vote service. This utility wraps <code>eu.strasbourg.service.council.service.persistence.impl.VotePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VotePersistence
 * @generated
 */
public class VoteUtil {

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
	public static void clearCache(Vote vote) {
		getPersistence().clearCache(vote);
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
	public static Map<Serializable, Vote> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Vote> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Vote> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Vote> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Vote> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Vote update(Vote vote) {
		return getPersistence().update(vote);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Vote update(Vote vote, ServiceContext serviceContext) {
		return getPersistence().update(vote, serviceContext);
	}

	/**
	 * Returns all the votes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching votes
	 */
	public static List<Vote> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the votes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @return the range of matching votes
	 */
	public static List<Vote> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the votes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching votes
	 */
	public static List<Vote> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Vote> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the votes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching votes
	 */
	public static List<Vote> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Vote> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first vote in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	public static Vote findByUuid_First(
			String uuid, OrderByComparator<Vote> orderByComparator)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first vote in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vote, or <code>null</code> if a matching vote could not be found
	 */
	public static Vote fetchByUuid_First(
		String uuid, OrderByComparator<Vote> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last vote in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	public static Vote findByUuid_Last(
			String uuid, OrderByComparator<Vote> orderByComparator)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last vote in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vote, or <code>null</code> if a matching vote could not be found
	 */
	public static Vote fetchByUuid_Last(
		String uuid, OrderByComparator<Vote> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the votes before and after the current vote in the ordered set where uuid = &#63;.
	 *
	 * @param votePK the primary key of the current vote
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vote
	 * @throws NoSuchVoteException if a vote with the primary key could not be found
	 */
	public static Vote[] findByUuid_PrevAndNext(
			eu.strasbourg.service.council.service.persistence.VotePK votePK,
			String uuid, OrderByComparator<Vote> orderByComparator)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().findByUuid_PrevAndNext(
			votePK, uuid, orderByComparator);
	}

	/**
	 * Removes all the votes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of votes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching votes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the vote where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVoteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	public static Vote findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the vote where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching vote, or <code>null</code> if a matching vote could not be found
	 */
	public static Vote fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the vote where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching vote, or <code>null</code> if a matching vote could not be found
	 */
	public static Vote fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the vote where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the vote that was removed
	 */
	public static Vote removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of votes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching votes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the votes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching votes
	 */
	public static List<Vote> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the votes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @return the range of matching votes
	 */
	public static List<Vote> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the votes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching votes
	 */
	public static List<Vote> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Vote> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the votes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching votes
	 */
	public static List<Vote> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Vote> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first vote in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	public static Vote findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Vote> orderByComparator)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first vote in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vote, or <code>null</code> if a matching vote could not be found
	 */
	public static Vote fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Vote> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last vote in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	public static Vote findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Vote> orderByComparator)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last vote in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vote, or <code>null</code> if a matching vote could not be found
	 */
	public static Vote fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Vote> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the votes before and after the current vote in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param votePK the primary key of the current vote
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vote
	 * @throws NoSuchVoteException if a vote with the primary key could not be found
	 */
	public static Vote[] findByUuid_C_PrevAndNext(
			eu.strasbourg.service.council.service.persistence.VotePK votePK,
			String uuid, long companyId,
			OrderByComparator<Vote> orderByComparator)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().findByUuid_C_PrevAndNext(
			votePK, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the votes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of votes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching votes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the votes where deliberationId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @return the matching votes
	 */
	public static List<Vote> findByDeliberationId(long deliberationId) {
		return getPersistence().findByDeliberationId(deliberationId);
	}

	/**
	 * Returns a range of all the votes where deliberationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param deliberationId the deliberation ID
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @return the range of matching votes
	 */
	public static List<Vote> findByDeliberationId(
		long deliberationId, int start, int end) {

		return getPersistence().findByDeliberationId(
			deliberationId, start, end);
	}

	/**
	 * Returns an ordered range of all the votes where deliberationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param deliberationId the deliberation ID
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching votes
	 */
	public static List<Vote> findByDeliberationId(
		long deliberationId, int start, int end,
		OrderByComparator<Vote> orderByComparator) {

		return getPersistence().findByDeliberationId(
			deliberationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the votes where deliberationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param deliberationId the deliberation ID
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching votes
	 */
	public static List<Vote> findByDeliberationId(
		long deliberationId, int start, int end,
		OrderByComparator<Vote> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDeliberationId(
			deliberationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first vote in the ordered set where deliberationId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	public static Vote findByDeliberationId_First(
			long deliberationId, OrderByComparator<Vote> orderByComparator)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().findByDeliberationId_First(
			deliberationId, orderByComparator);
	}

	/**
	 * Returns the first vote in the ordered set where deliberationId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vote, or <code>null</code> if a matching vote could not be found
	 */
	public static Vote fetchByDeliberationId_First(
		long deliberationId, OrderByComparator<Vote> orderByComparator) {

		return getPersistence().fetchByDeliberationId_First(
			deliberationId, orderByComparator);
	}

	/**
	 * Returns the last vote in the ordered set where deliberationId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	public static Vote findByDeliberationId_Last(
			long deliberationId, OrderByComparator<Vote> orderByComparator)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().findByDeliberationId_Last(
			deliberationId, orderByComparator);
	}

	/**
	 * Returns the last vote in the ordered set where deliberationId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vote, or <code>null</code> if a matching vote could not be found
	 */
	public static Vote fetchByDeliberationId_Last(
		long deliberationId, OrderByComparator<Vote> orderByComparator) {

		return getPersistence().fetchByDeliberationId_Last(
			deliberationId, orderByComparator);
	}

	/**
	 * Returns the votes before and after the current vote in the ordered set where deliberationId = &#63;.
	 *
	 * @param votePK the primary key of the current vote
	 * @param deliberationId the deliberation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vote
	 * @throws NoSuchVoteException if a vote with the primary key could not be found
	 */
	public static Vote[] findByDeliberationId_PrevAndNext(
			eu.strasbourg.service.council.service.persistence.VotePK votePK,
			long deliberationId, OrderByComparator<Vote> orderByComparator)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().findByDeliberationId_PrevAndNext(
			votePK, deliberationId, orderByComparator);
	}

	/**
	 * Removes all the votes where deliberationId = &#63; from the database.
	 *
	 * @param deliberationId the deliberation ID
	 */
	public static void removeByDeliberationId(long deliberationId) {
		getPersistence().removeByDeliberationId(deliberationId);
	}

	/**
	 * Returns the number of votes where deliberationId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @return the number of matching votes
	 */
	public static int countByDeliberationId(long deliberationId) {
		return getPersistence().countByDeliberationId(deliberationId);
	}

	/**
	 * Returns the vote where deliberationId = &#63; and officialId = &#63; or throws a <code>NoSuchVoteException</code> if it could not be found.
	 *
	 * @param deliberationId the deliberation ID
	 * @param officialId the official ID
	 * @return the matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	public static Vote findByDeliberationIdAndOfficialId(
			long deliberationId, long officialId)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().findByDeliberationIdAndOfficialId(
			deliberationId, officialId);
	}

	/**
	 * Returns the vote where deliberationId = &#63; and officialId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param deliberationId the deliberation ID
	 * @param officialId the official ID
	 * @return the matching vote, or <code>null</code> if a matching vote could not be found
	 */
	public static Vote fetchByDeliberationIdAndOfficialId(
		long deliberationId, long officialId) {

		return getPersistence().fetchByDeliberationIdAndOfficialId(
			deliberationId, officialId);
	}

	/**
	 * Returns the vote where deliberationId = &#63; and officialId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param deliberationId the deliberation ID
	 * @param officialId the official ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching vote, or <code>null</code> if a matching vote could not be found
	 */
	public static Vote fetchByDeliberationIdAndOfficialId(
		long deliberationId, long officialId, boolean useFinderCache) {

		return getPersistence().fetchByDeliberationIdAndOfficialId(
			deliberationId, officialId, useFinderCache);
	}

	/**
	 * Removes the vote where deliberationId = &#63; and officialId = &#63; from the database.
	 *
	 * @param deliberationId the deliberation ID
	 * @param officialId the official ID
	 * @return the vote that was removed
	 */
	public static Vote removeByDeliberationIdAndOfficialId(
			long deliberationId, long officialId)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().removeByDeliberationIdAndOfficialId(
			deliberationId, officialId);
	}

	/**
	 * Returns the number of votes where deliberationId = &#63; and officialId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @param officialId the official ID
	 * @return the number of matching votes
	 */
	public static int countByDeliberationIdAndOfficialId(
		long deliberationId, long officialId) {

		return getPersistence().countByDeliberationIdAndOfficialId(
			deliberationId, officialId);
	}

	/**
	 * Caches the vote in the entity cache if it is enabled.
	 *
	 * @param vote the vote
	 */
	public static void cacheResult(Vote vote) {
		getPersistence().cacheResult(vote);
	}

	/**
	 * Caches the votes in the entity cache if it is enabled.
	 *
	 * @param votes the votes
	 */
	public static void cacheResult(List<Vote> votes) {
		getPersistence().cacheResult(votes);
	}

	/**
	 * Creates a new vote with the primary key. Does not add the vote to the database.
	 *
	 * @param votePK the primary key for the new vote
	 * @return the new vote
	 */
	public static Vote create(
		eu.strasbourg.service.council.service.persistence.VotePK votePK) {

		return getPersistence().create(votePK);
	}

	/**
	 * Removes the vote with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param votePK the primary key of the vote
	 * @return the vote that was removed
	 * @throws NoSuchVoteException if a vote with the primary key could not be found
	 */
	public static Vote remove(
			eu.strasbourg.service.council.service.persistence.VotePK votePK)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().remove(votePK);
	}

	public static Vote updateImpl(Vote vote) {
		return getPersistence().updateImpl(vote);
	}

	/**
	 * Returns the vote with the primary key or throws a <code>NoSuchVoteException</code> if it could not be found.
	 *
	 * @param votePK the primary key of the vote
	 * @return the vote
	 * @throws NoSuchVoteException if a vote with the primary key could not be found
	 */
	public static Vote findByPrimaryKey(
			eu.strasbourg.service.council.service.persistence.VotePK votePK)
		throws eu.strasbourg.service.council.exception.NoSuchVoteException {

		return getPersistence().findByPrimaryKey(votePK);
	}

	/**
	 * Returns the vote with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param votePK the primary key of the vote
	 * @return the vote, or <code>null</code> if a vote with the primary key could not be found
	 */
	public static Vote fetchByPrimaryKey(
		eu.strasbourg.service.council.service.persistence.VotePK votePK) {

		return getPersistence().fetchByPrimaryKey(votePK);
	}

	/**
	 * Returns all the votes.
	 *
	 * @return the votes
	 */
	public static List<Vote> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the votes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @return the range of votes
	 */
	public static List<Vote> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the votes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of votes
	 */
	public static List<Vote> findAll(
		int start, int end, OrderByComparator<Vote> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the votes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of votes
	 */
	public static List<Vote> findAll(
		int start, int end, OrderByComparator<Vote> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the votes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of votes.
	 *
	 * @return the number of votes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static VotePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(VotePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile VotePersistence _persistence;

}