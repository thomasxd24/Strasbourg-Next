/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.project.model.Petition;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the petition service. This utility wraps <code>eu.strasbourg.service.project.service.persistence.impl.PetitionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see PetitionPersistence
 * @generated
 */
public class PetitionUtil {

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
	public static void clearCache(Petition petition) {
		getPersistence().clearCache(petition);
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
	public static Map<Serializable, Petition> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Petition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Petition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Petition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Petition> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Petition update(Petition petition) {
		return getPersistence().update(petition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Petition update(
		Petition petition, ServiceContext serviceContext) {

		return getPersistence().update(petition, serviceContext);
	}

	/**
	 * Returns all the petitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching petitions
	 */
	public static List<Petition> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the petitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @return the range of matching petitions
	 */
	public static List<Petition> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the petitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching petitions
	 */
	public static List<Petition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Petition> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the petitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching petitions
	 */
	public static List<Petition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Petition> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first petition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching petition
	 * @throws NoSuchPetitionException if a matching petition could not be found
	 */
	public static Petition findByUuid_First(
			String uuid, OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first petition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching petition, or <code>null</code> if a matching petition could not be found
	 */
	public static Petition fetchByUuid_First(
		String uuid, OrderByComparator<Petition> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last petition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching petition
	 * @throws NoSuchPetitionException if a matching petition could not be found
	 */
	public static Petition findByUuid_Last(
			String uuid, OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last petition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching petition, or <code>null</code> if a matching petition could not be found
	 */
	public static Petition fetchByUuid_Last(
		String uuid, OrderByComparator<Petition> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the petitions before and after the current petition in the ordered set where uuid = &#63;.
	 *
	 * @param petitionId the primary key of the current petition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next petition
	 * @throws NoSuchPetitionException if a petition with the primary key could not be found
	 */
	public static Petition[] findByUuid_PrevAndNext(
			long petitionId, String uuid,
			OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByUuid_PrevAndNext(
			petitionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the petitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of petitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching petitions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the petition where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPetitionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching petition
	 * @throws NoSuchPetitionException if a matching petition could not be found
	 */
	public static Petition findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the petition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching petition, or <code>null</code> if a matching petition could not be found
	 */
	public static Petition fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the petition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching petition, or <code>null</code> if a matching petition could not be found
	 */
	public static Petition fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the petition where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the petition that was removed
	 */
	public static Petition removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of petitions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching petitions
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the petitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching petitions
	 */
	public static List<Petition> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the petitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @return the range of matching petitions
	 */
	public static List<Petition> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the petitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching petitions
	 */
	public static List<Petition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Petition> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the petitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching petitions
	 */
	public static List<Petition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Petition> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first petition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching petition
	 * @throws NoSuchPetitionException if a matching petition could not be found
	 */
	public static Petition findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first petition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching petition, or <code>null</code> if a matching petition could not be found
	 */
	public static Petition fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Petition> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last petition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching petition
	 * @throws NoSuchPetitionException if a matching petition could not be found
	 */
	public static Petition findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last petition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching petition, or <code>null</code> if a matching petition could not be found
	 */
	public static Petition fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Petition> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the petitions before and after the current petition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param petitionId the primary key of the current petition
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next petition
	 * @throws NoSuchPetitionException if a petition with the primary key could not be found
	 */
	public static Petition[] findByUuid_C_PrevAndNext(
			long petitionId, String uuid, long companyId,
			OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByUuid_C_PrevAndNext(
			petitionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the petitions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of petitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching petitions
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the petitions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching petitions
	 */
	public static List<Petition> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the petitions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @return the range of matching petitions
	 */
	public static List<Petition> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the petitions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching petitions
	 */
	public static List<Petition> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Petition> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the petitions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching petitions
	 */
	public static List<Petition> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Petition> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first petition in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching petition
	 * @throws NoSuchPetitionException if a matching petition could not be found
	 */
	public static Petition findByGroupId_First(
			long groupId, OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first petition in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching petition, or <code>null</code> if a matching petition could not be found
	 */
	public static Petition fetchByGroupId_First(
		long groupId, OrderByComparator<Petition> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last petition in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching petition
	 * @throws NoSuchPetitionException if a matching petition could not be found
	 */
	public static Petition findByGroupId_Last(
			long groupId, OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last petition in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching petition, or <code>null</code> if a matching petition could not be found
	 */
	public static Petition fetchByGroupId_Last(
		long groupId, OrderByComparator<Petition> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the petitions before and after the current petition in the ordered set where groupId = &#63;.
	 *
	 * @param petitionId the primary key of the current petition
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next petition
	 * @throws NoSuchPetitionException if a petition with the primary key could not be found
	 */
	public static Petition[] findByGroupId_PrevAndNext(
			long petitionId, long groupId,
			OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByGroupId_PrevAndNext(
			petitionId, groupId, orderByComparator);
	}

	/**
	 * Removes all the petitions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of petitions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching petitions
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the petitions where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching petitions
	 */
	public static List<Petition> findByStatusAndGroupId(
		int status, long groupId) {

		return getPersistence().findByStatusAndGroupId(status, groupId);
	}

	/**
	 * Returns a range of all the petitions where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @return the range of matching petitions
	 */
	public static List<Petition> findByStatusAndGroupId(
		int status, long groupId, int start, int end) {

		return getPersistence().findByStatusAndGroupId(
			status, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the petitions where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching petitions
	 */
	public static List<Petition> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		OrderByComparator<Petition> orderByComparator) {

		return getPersistence().findByStatusAndGroupId(
			status, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the petitions where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching petitions
	 */
	public static List<Petition> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		OrderByComparator<Petition> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatusAndGroupId(
			status, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first petition in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching petition
	 * @throws NoSuchPetitionException if a matching petition could not be found
	 */
	public static Petition findByStatusAndGroupId_First(
			int status, long groupId,
			OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByStatusAndGroupId_First(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the first petition in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching petition, or <code>null</code> if a matching petition could not be found
	 */
	public static Petition fetchByStatusAndGroupId_First(
		int status, long groupId,
		OrderByComparator<Petition> orderByComparator) {

		return getPersistence().fetchByStatusAndGroupId_First(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the last petition in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching petition
	 * @throws NoSuchPetitionException if a matching petition could not be found
	 */
	public static Petition findByStatusAndGroupId_Last(
			int status, long groupId,
			OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByStatusAndGroupId_Last(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the last petition in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching petition, or <code>null</code> if a matching petition could not be found
	 */
	public static Petition fetchByStatusAndGroupId_Last(
		int status, long groupId,
		OrderByComparator<Petition> orderByComparator) {

		return getPersistence().fetchByStatusAndGroupId_Last(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the petitions before and after the current petition in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param petitionId the primary key of the current petition
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next petition
	 * @throws NoSuchPetitionException if a petition with the primary key could not be found
	 */
	public static Petition[] findByStatusAndGroupId_PrevAndNext(
			long petitionId, int status, long groupId,
			OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByStatusAndGroupId_PrevAndNext(
			petitionId, status, groupId, orderByComparator);
	}

	/**
	 * Removes all the petitions where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 */
	public static void removeByStatusAndGroupId(int status, long groupId) {
		getPersistence().removeByStatusAndGroupId(status, groupId);
	}

	/**
	 * Returns the number of petitions where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching petitions
	 */
	public static int countByStatusAndGroupId(int status, long groupId) {
		return getPersistence().countByStatusAndGroupId(status, groupId);
	}

	/**
	 * Returns all the petitions where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the matching petitions
	 */
	public static List<Petition> findByPublikId(String publikId) {
		return getPersistence().findByPublikId(publikId);
	}

	/**
	 * Returns a range of all the petitions where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @return the range of matching petitions
	 */
	public static List<Petition> findByPublikId(
		String publikId, int start, int end) {

		return getPersistence().findByPublikId(publikId, start, end);
	}

	/**
	 * Returns an ordered range of all the petitions where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching petitions
	 */
	public static List<Petition> findByPublikId(
		String publikId, int start, int end,
		OrderByComparator<Petition> orderByComparator) {

		return getPersistence().findByPublikId(
			publikId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the petitions where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching petitions
	 */
	public static List<Petition> findByPublikId(
		String publikId, int start, int end,
		OrderByComparator<Petition> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByPublikId(
			publikId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first petition in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching petition
	 * @throws NoSuchPetitionException if a matching petition could not be found
	 */
	public static Petition findByPublikId_First(
			String publikId, OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByPublikId_First(
			publikId, orderByComparator);
	}

	/**
	 * Returns the first petition in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching petition, or <code>null</code> if a matching petition could not be found
	 */
	public static Petition fetchByPublikId_First(
		String publikId, OrderByComparator<Petition> orderByComparator) {

		return getPersistence().fetchByPublikId_First(
			publikId, orderByComparator);
	}

	/**
	 * Returns the last petition in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching petition
	 * @throws NoSuchPetitionException if a matching petition could not be found
	 */
	public static Petition findByPublikId_Last(
			String publikId, OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByPublikId_Last(
			publikId, orderByComparator);
	}

	/**
	 * Returns the last petition in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching petition, or <code>null</code> if a matching petition could not be found
	 */
	public static Petition fetchByPublikId_Last(
		String publikId, OrderByComparator<Petition> orderByComparator) {

		return getPersistence().fetchByPublikId_Last(
			publikId, orderByComparator);
	}

	/**
	 * Returns the petitions before and after the current petition in the ordered set where publikId = &#63;.
	 *
	 * @param petitionId the primary key of the current petition
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next petition
	 * @throws NoSuchPetitionException if a petition with the primary key could not be found
	 */
	public static Petition[] findByPublikId_PrevAndNext(
			long petitionId, String publikId,
			OrderByComparator<Petition> orderByComparator)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByPublikId_PrevAndNext(
			petitionId, publikId, orderByComparator);
	}

	/**
	 * Removes all the petitions where publikId = &#63; from the database.
	 *
	 * @param publikId the publik ID
	 */
	public static void removeByPublikId(String publikId) {
		getPersistence().removeByPublikId(publikId);
	}

	/**
	 * Returns the number of petitions where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the number of matching petitions
	 */
	public static int countByPublikId(String publikId) {
		return getPersistence().countByPublikId(publikId);
	}

	/**
	 * Caches the petition in the entity cache if it is enabled.
	 *
	 * @param petition the petition
	 */
	public static void cacheResult(Petition petition) {
		getPersistence().cacheResult(petition);
	}

	/**
	 * Caches the petitions in the entity cache if it is enabled.
	 *
	 * @param petitions the petitions
	 */
	public static void cacheResult(List<Petition> petitions) {
		getPersistence().cacheResult(petitions);
	}

	/**
	 * Creates a new petition with the primary key. Does not add the petition to the database.
	 *
	 * @param petitionId the primary key for the new petition
	 * @return the new petition
	 */
	public static Petition create(long petitionId) {
		return getPersistence().create(petitionId);
	}

	/**
	 * Removes the petition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petitionId the primary key of the petition
	 * @return the petition that was removed
	 * @throws NoSuchPetitionException if a petition with the primary key could not be found
	 */
	public static Petition remove(long petitionId)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().remove(petitionId);
	}

	public static Petition updateImpl(Petition petition) {
		return getPersistence().updateImpl(petition);
	}

	/**
	 * Returns the petition with the primary key or throws a <code>NoSuchPetitionException</code> if it could not be found.
	 *
	 * @param petitionId the primary key of the petition
	 * @return the petition
	 * @throws NoSuchPetitionException if a petition with the primary key could not be found
	 */
	public static Petition findByPrimaryKey(long petitionId)
		throws eu.strasbourg.service.project.exception.NoSuchPetitionException {

		return getPersistence().findByPrimaryKey(petitionId);
	}

	/**
	 * Returns the petition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petitionId the primary key of the petition
	 * @return the petition, or <code>null</code> if a petition with the primary key could not be found
	 */
	public static Petition fetchByPrimaryKey(long petitionId) {
		return getPersistence().fetchByPrimaryKey(petitionId);
	}

	/**
	 * Returns all the petitions.
	 *
	 * @return the petitions
	 */
	public static List<Petition> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the petitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @return the range of petitions
	 */
	public static List<Petition> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the petitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of petitions
	 */
	public static List<Petition> findAll(
		int start, int end, OrderByComparator<Petition> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the petitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of petitions
	 */
	public static List<Petition> findAll(
		int start, int end, OrderByComparator<Petition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the petitions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of petitions.
	 *
	 * @return the number of petitions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PetitionPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PetitionPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PetitionPersistence _persistence;

}