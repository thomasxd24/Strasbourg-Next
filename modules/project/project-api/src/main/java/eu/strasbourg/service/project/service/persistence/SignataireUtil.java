/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.project.model.Signataire;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the signataire service. This utility wraps <code>eu.strasbourg.service.project.service.persistence.impl.SignatairePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see SignatairePersistence
 * @generated
 */
public class SignataireUtil {

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
	public static void clearCache(Signataire signataire) {
		getPersistence().clearCache(signataire);
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
	public static Map<Serializable, Signataire> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Signataire> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Signataire> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Signataire> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Signataire update(Signataire signataire) {
		return getPersistence().update(signataire);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Signataire update(
		Signataire signataire, ServiceContext serviceContext) {

		return getPersistence().update(signataire, serviceContext);
	}

	/**
	 * Returns all the signataires where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching signataires
	 */
	public static List<Signataire> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the signataires where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @return the range of matching signataires
	 */
	public static List<Signataire> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the signataires where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the signataires where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Signataire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first signataire in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByUuid_First(
			String uuid, OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first signataire in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByUuid_First(
		String uuid, OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByUuid_Last(
			String uuid, OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByUuid_Last(
		String uuid, OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the signataires before and after the current signataire in the ordered set where uuid = &#63;.
	 *
	 * @param signataireId the primary key of the current signataire
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signataire
	 * @throws NoSuchSignataireException if a signataire with the primary key could not be found
	 */
	public static Signataire[] findByUuid_PrevAndNext(
			long signataireId, String uuid,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByUuid_PrevAndNext(
			signataireId, uuid, orderByComparator);
	}

	/**
	 * Removes all the signataires where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of signataires where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching signataires
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the signataire where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSignataireException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the signataire where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the signataire where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the signataire where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the signataire that was removed
	 */
	public static Signataire removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of signataires where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching signataires
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the signataires where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching signataires
	 */
	public static List<Signataire> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the signataires where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @return the range of matching signataires
	 */
	public static List<Signataire> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the signataires where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the signataires where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Signataire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first signataire in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first signataire in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the signataires before and after the current signataire in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param signataireId the primary key of the current signataire
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signataire
	 * @throws NoSuchSignataireException if a signataire with the primary key could not be found
	 */
	public static Signataire[] findByUuid_C_PrevAndNext(
			long signataireId, String uuid, long companyId,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByUuid_C_PrevAndNext(
			signataireId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the signataires where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of signataires where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching signataires
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the signataires where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching signataires
	 */
	public static List<Signataire> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the signataires where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @return the range of matching signataires
	 */
	public static List<Signataire> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the signataires where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the signataires where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Signataire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first signataire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByGroupId_First(
			long groupId, OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first signataire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByGroupId_First(
		long groupId, OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByGroupId_Last(
			long groupId, OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByGroupId_Last(
		long groupId, OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the signataires before and after the current signataire in the ordered set where groupId = &#63;.
	 *
	 * @param signataireId the primary key of the current signataire
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signataire
	 * @throws NoSuchSignataireException if a signataire with the primary key could not be found
	 */
	public static Signataire[] findByGroupId_PrevAndNext(
			long signataireId, long groupId,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByGroupId_PrevAndNext(
			signataireId, groupId, orderByComparator);
	}

	/**
	 * Removes all the signataires where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of signataires where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching signataires
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the signataires where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @return the matching signataires
	 */
	public static List<Signataire> findByPetition(long petitionId) {
		return getPersistence().findByPetition(petitionId);
	}

	/**
	 * Returns a range of all the signataires where petitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @return the range of matching signataires
	 */
	public static List<Signataire> findByPetition(
		long petitionId, int start, int end) {

		return getPersistence().findByPetition(petitionId, start, end);
	}

	/**
	 * Returns an ordered range of all the signataires where petitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByPetition(
		long petitionId, int start, int end,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().findByPetition(
			petitionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the signataires where petitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByPetition(
		long petitionId, int start, int end,
		OrderByComparator<Signataire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPetition(
			petitionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first signataire in the ordered set where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByPetition_First(
			long petitionId, OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByPetition_First(
			petitionId, orderByComparator);
	}

	/**
	 * Returns the first signataire in the ordered set where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByPetition_First(
		long petitionId, OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByPetition_First(
			petitionId, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByPetition_Last(
			long petitionId, OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByPetition_Last(
			petitionId, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByPetition_Last(
		long petitionId, OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByPetition_Last(
			petitionId, orderByComparator);
	}

	/**
	 * Returns the signataires before and after the current signataire in the ordered set where petitionId = &#63;.
	 *
	 * @param signataireId the primary key of the current signataire
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signataire
	 * @throws NoSuchSignataireException if a signataire with the primary key could not be found
	 */
	public static Signataire[] findByPetition_PrevAndNext(
			long signataireId, long petitionId,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByPetition_PrevAndNext(
			signataireId, petitionId, orderByComparator);
	}

	/**
	 * Removes all the signataires where petitionId = &#63; from the database.
	 *
	 * @param petitionId the petition ID
	 */
	public static void removeByPetition(long petitionId) {
		getPersistence().removeByPetition(petitionId);
	}

	/**
	 * Returns the number of signataires where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @return the number of matching signataires
	 */
	public static int countByPetition(long petitionId) {
		return getPersistence().countByPetition(petitionId);
	}

	/**
	 * Returns all the signataires where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the matching signataires
	 */
	public static List<Signataire> findByPublikUserId(String publikUserId) {
		return getPersistence().findByPublikUserId(publikUserId);
	}

	/**
	 * Returns a range of all the signataires where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @return the range of matching signataires
	 */
	public static List<Signataire> findByPublikUserId(
		String publikUserId, int start, int end) {

		return getPersistence().findByPublikUserId(publikUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the signataires where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByPublikUserId(
		String publikUserId, int start, int end,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().findByPublikUserId(
			publikUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the signataires where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByPublikUserId(
		String publikUserId, int start, int end,
		OrderByComparator<Signataire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPublikUserId(
			publikUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first signataire in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByPublikUserId_First(
			String publikUserId,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByPublikUserId_First(
			publikUserId, orderByComparator);
	}

	/**
	 * Returns the first signataire in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByPublikUserId_First(
		String publikUserId, OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByPublikUserId_First(
			publikUserId, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByPublikUserId_Last(
			String publikUserId,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByPublikUserId_Last(
			publikUserId, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByPublikUserId_Last(
		String publikUserId, OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByPublikUserId_Last(
			publikUserId, orderByComparator);
	}

	/**
	 * Returns the signataires before and after the current signataire in the ordered set where publikUserId = &#63;.
	 *
	 * @param signataireId the primary key of the current signataire
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signataire
	 * @throws NoSuchSignataireException if a signataire with the primary key could not be found
	 */
	public static Signataire[] findByPublikUserId_PrevAndNext(
			long signataireId, String publikUserId,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByPublikUserId_PrevAndNext(
			signataireId, publikUserId, orderByComparator);
	}

	/**
	 * Removes all the signataires where publikUserId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 */
	public static void removeByPublikUserId(String publikUserId) {
		getPersistence().removeByPublikUserId(publikUserId);
	}

	/**
	 * Returns the number of signataires where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the number of matching signataires
	 */
	public static int countByPublikUserId(String publikUserId) {
		return getPersistence().countByPublikUserId(publikUserId);
	}

	/**
	 * Returns all the signataires where petitionId = &#63; and signataireName = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param signataireName the signataire name
	 * @return the matching signataires
	 */
	public static List<Signataire> findByPetitionIdAndSignataireName(
		long petitionId, String signataireName) {

		return getPersistence().findByPetitionIdAndSignataireName(
			petitionId, signataireName);
	}

	/**
	 * Returns a range of all the signataires where petitionId = &#63; and signataireName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param signataireName the signataire name
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @return the range of matching signataires
	 */
	public static List<Signataire> findByPetitionIdAndSignataireName(
		long petitionId, String signataireName, int start, int end) {

		return getPersistence().findByPetitionIdAndSignataireName(
			petitionId, signataireName, start, end);
	}

	/**
	 * Returns an ordered range of all the signataires where petitionId = &#63; and signataireName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param signataireName the signataire name
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByPetitionIdAndSignataireName(
		long petitionId, String signataireName, int start, int end,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().findByPetitionIdAndSignataireName(
			petitionId, signataireName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the signataires where petitionId = &#63; and signataireName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param signataireName the signataire name
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByPetitionIdAndSignataireName(
		long petitionId, String signataireName, int start, int end,
		OrderByComparator<Signataire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPetitionIdAndSignataireName(
			petitionId, signataireName, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first signataire in the ordered set where petitionId = &#63; and signataireName = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param signataireName the signataire name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByPetitionIdAndSignataireName_First(
			long petitionId, String signataireName,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByPetitionIdAndSignataireName_First(
			petitionId, signataireName, orderByComparator);
	}

	/**
	 * Returns the first signataire in the ordered set where petitionId = &#63; and signataireName = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param signataireName the signataire name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByPetitionIdAndSignataireName_First(
		long petitionId, String signataireName,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByPetitionIdAndSignataireName_First(
			petitionId, signataireName, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where petitionId = &#63; and signataireName = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param signataireName the signataire name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByPetitionIdAndSignataireName_Last(
			long petitionId, String signataireName,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByPetitionIdAndSignataireName_Last(
			petitionId, signataireName, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where petitionId = &#63; and signataireName = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param signataireName the signataire name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByPetitionIdAndSignataireName_Last(
		long petitionId, String signataireName,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByPetitionIdAndSignataireName_Last(
			petitionId, signataireName, orderByComparator);
	}

	/**
	 * Returns the signataires before and after the current signataire in the ordered set where petitionId = &#63; and signataireName = &#63;.
	 *
	 * @param signataireId the primary key of the current signataire
	 * @param petitionId the petition ID
	 * @param signataireName the signataire name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signataire
	 * @throws NoSuchSignataireException if a signataire with the primary key could not be found
	 */
	public static Signataire[] findByPetitionIdAndSignataireName_PrevAndNext(
			long signataireId, long petitionId, String signataireName,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByPetitionIdAndSignataireName_PrevAndNext(
			signataireId, petitionId, signataireName, orderByComparator);
	}

	/**
	 * Removes all the signataires where petitionId = &#63; and signataireName = &#63; from the database.
	 *
	 * @param petitionId the petition ID
	 * @param signataireName the signataire name
	 */
	public static void removeByPetitionIdAndSignataireName(
		long petitionId, String signataireName) {

		getPersistence().removeByPetitionIdAndSignataireName(
			petitionId, signataireName);
	}

	/**
	 * Returns the number of signataires where petitionId = &#63; and signataireName = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param signataireName the signataire name
	 * @return the number of matching signataires
	 */
	public static int countByPetitionIdAndSignataireName(
		long petitionId, String signataireName) {

		return getPersistence().countByPetitionIdAndSignataireName(
			petitionId, signataireName);
	}

	/**
	 * Returns all the signataires where petitionId = &#63; and publikUserId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param publikUserId the publik user ID
	 * @return the matching signataires
	 */
	public static List<Signataire> findByPetitionIdAndPublikUserId(
		long petitionId, String publikUserId) {

		return getPersistence().findByPetitionIdAndPublikUserId(
			petitionId, publikUserId);
	}

	/**
	 * Returns a range of all the signataires where petitionId = &#63; and publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @return the range of matching signataires
	 */
	public static List<Signataire> findByPetitionIdAndPublikUserId(
		long petitionId, String publikUserId, int start, int end) {

		return getPersistence().findByPetitionIdAndPublikUserId(
			petitionId, publikUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the signataires where petitionId = &#63; and publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByPetitionIdAndPublikUserId(
		long petitionId, String publikUserId, int start, int end,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().findByPetitionIdAndPublikUserId(
			petitionId, publikUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the signataires where petitionId = &#63; and publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signataires
	 */
	public static List<Signataire> findByPetitionIdAndPublikUserId(
		long petitionId, String publikUserId, int start, int end,
		OrderByComparator<Signataire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPetitionIdAndPublikUserId(
			petitionId, publikUserId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first signataire in the ordered set where petitionId = &#63; and publikUserId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByPetitionIdAndPublikUserId_First(
			long petitionId, String publikUserId,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByPetitionIdAndPublikUserId_First(
			petitionId, publikUserId, orderByComparator);
	}

	/**
	 * Returns the first signataire in the ordered set where petitionId = &#63; and publikUserId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByPetitionIdAndPublikUserId_First(
		long petitionId, String publikUserId,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByPetitionIdAndPublikUserId_First(
			petitionId, publikUserId, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where petitionId = &#63; and publikUserId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire
	 * @throws NoSuchSignataireException if a matching signataire could not be found
	 */
	public static Signataire findByPetitionIdAndPublikUserId_Last(
			long petitionId, String publikUserId,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByPetitionIdAndPublikUserId_Last(
			petitionId, publikUserId, orderByComparator);
	}

	/**
	 * Returns the last signataire in the ordered set where petitionId = &#63; and publikUserId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchByPetitionIdAndPublikUserId_Last(
		long petitionId, String publikUserId,
		OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().fetchByPetitionIdAndPublikUserId_Last(
			petitionId, publikUserId, orderByComparator);
	}

	/**
	 * Returns the signataires before and after the current signataire in the ordered set where petitionId = &#63; and publikUserId = &#63;.
	 *
	 * @param signataireId the primary key of the current signataire
	 * @param petitionId the petition ID
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signataire
	 * @throws NoSuchSignataireException if a signataire with the primary key could not be found
	 */
	public static Signataire[] findByPetitionIdAndPublikUserId_PrevAndNext(
			long signataireId, long petitionId, String publikUserId,
			OrderByComparator<Signataire> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByPetitionIdAndPublikUserId_PrevAndNext(
			signataireId, petitionId, publikUserId, orderByComparator);
	}

	/**
	 * Removes all the signataires where petitionId = &#63; and publikUserId = &#63; from the database.
	 *
	 * @param petitionId the petition ID
	 * @param publikUserId the publik user ID
	 */
	public static void removeByPetitionIdAndPublikUserId(
		long petitionId, String publikUserId) {

		getPersistence().removeByPetitionIdAndPublikUserId(
			petitionId, publikUserId);
	}

	/**
	 * Returns the number of signataires where petitionId = &#63; and publikUserId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param publikUserId the publik user ID
	 * @return the number of matching signataires
	 */
	public static int countByPetitionIdAndPublikUserId(
		long petitionId, String publikUserId) {

		return getPersistence().countByPetitionIdAndPublikUserId(
			petitionId, publikUserId);
	}

	/**
	 * Caches the signataire in the entity cache if it is enabled.
	 *
	 * @param signataire the signataire
	 */
	public static void cacheResult(Signataire signataire) {
		getPersistence().cacheResult(signataire);
	}

	/**
	 * Caches the signataires in the entity cache if it is enabled.
	 *
	 * @param signataires the signataires
	 */
	public static void cacheResult(List<Signataire> signataires) {
		getPersistence().cacheResult(signataires);
	}

	/**
	 * Creates a new signataire with the primary key. Does not add the signataire to the database.
	 *
	 * @param signataireId the primary key for the new signataire
	 * @return the new signataire
	 */
	public static Signataire create(long signataireId) {
		return getPersistence().create(signataireId);
	}

	/**
	 * Removes the signataire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param signataireId the primary key of the signataire
	 * @return the signataire that was removed
	 * @throws NoSuchSignataireException if a signataire with the primary key could not be found
	 */
	public static Signataire remove(long signataireId)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().remove(signataireId);
	}

	public static Signataire updateImpl(Signataire signataire) {
		return getPersistence().updateImpl(signataire);
	}

	/**
	 * Returns the signataire with the primary key or throws a <code>NoSuchSignataireException</code> if it could not be found.
	 *
	 * @param signataireId the primary key of the signataire
	 * @return the signataire
	 * @throws NoSuchSignataireException if a signataire with the primary key could not be found
	 */
	public static Signataire findByPrimaryKey(long signataireId)
		throws eu.strasbourg.service.project.exception.
			NoSuchSignataireException {

		return getPersistence().findByPrimaryKey(signataireId);
	}

	/**
	 * Returns the signataire with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param signataireId the primary key of the signataire
	 * @return the signataire, or <code>null</code> if a signataire with the primary key could not be found
	 */
	public static Signataire fetchByPrimaryKey(long signataireId) {
		return getPersistence().fetchByPrimaryKey(signataireId);
	}

	/**
	 * Returns all the signataires.
	 *
	 * @return the signataires
	 */
	public static List<Signataire> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the signataires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @return the range of signataires
	 */
	public static List<Signataire> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the signataires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of signataires
	 */
	public static List<Signataire> findAll(
		int start, int end, OrderByComparator<Signataire> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the signataires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of signataires
	 */
	public static List<Signataire> findAll(
		int start, int end, OrderByComparator<Signataire> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the signataires from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of signataires.
	 *
	 * @return the number of signataires
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SignatairePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SignatairePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SignatairePersistence _persistence;

}