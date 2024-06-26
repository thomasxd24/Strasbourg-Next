/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.agenda.model.Manifestation;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the manifestation service. This utility wraps <code>eu.strasbourg.service.agenda.service.persistence.impl.ManifestationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see ManifestationPersistence
 * @generated
 */
public class ManifestationUtil {

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
	public static void clearCache(Manifestation manifestation) {
		getPersistence().clearCache(manifestation);
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
	public static Map<Serializable, Manifestation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Manifestation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Manifestation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Manifestation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Manifestation update(Manifestation manifestation) {
		return getPersistence().update(manifestation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Manifestation update(
		Manifestation manifestation, ServiceContext serviceContext) {

		return getPersistence().update(manifestation, serviceContext);
	}

	/**
	 * Returns all the manifestations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching manifestations
	 */
	public static List<Manifestation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the manifestations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public static List<Manifestation> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the manifestations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the manifestations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByUuid_First(
			String uuid, OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByUuid_First(
		String uuid, OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByUuid_Last(
			String uuid, OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByUuid_Last(
		String uuid, OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public static Manifestation[] findByUuid_PrevAndNext(
			long manifestationId, String uuid,
			OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByUuid_PrevAndNext(
			manifestationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the manifestations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of manifestations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching manifestations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the manifestation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchManifestationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the manifestation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the manifestation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the manifestation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the manifestation that was removed
	 */
	public static Manifestation removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of manifestations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching manifestations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching manifestations
	 */
	public static List<Manifestation> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public static List<Manifestation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public static Manifestation[] findByUuid_C_PrevAndNext(
			long manifestationId, String uuid, long companyId,
			OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			manifestationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the manifestations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching manifestations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the manifestations where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching manifestations
	 */
	public static List<Manifestation> findBytitle(String title) {
		return getPersistence().findBytitle(title);
	}

	/**
	 * Returns a range of all the manifestations where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public static List<Manifestation> findBytitle(
		String title, int start, int end) {

		return getPersistence().findBytitle(title, start, end);
	}

	/**
	 * Returns an ordered range of all the manifestations where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findBytitle(
		String title, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().findBytitle(
			title, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the manifestations where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findBytitle(
		String title, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBytitle(
			title, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first manifestation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findBytitle_First(
			String title, OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findBytitle_First(title, orderByComparator);
	}

	/**
	 * Returns the first manifestation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchBytitle_First(
		String title, OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchBytitle_First(title, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findBytitle_Last(
			String title, OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findBytitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchBytitle_Last(
		String title, OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchBytitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where title = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public static Manifestation[] findBytitle_PrevAndNext(
			long manifestationId, String title,
			OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findBytitle_PrevAndNext(
			manifestationId, title, orderByComparator);
	}

	/**
	 * Removes all the manifestations where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public static void removeBytitle(String title) {
		getPersistence().removeBytitle(title);
	}

	/**
	 * Returns the number of manifestations where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching manifestations
	 */
	public static int countBytitle(String title) {
		return getPersistence().countBytitle(title);
	}

	/**
	 * Returns all the manifestations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching manifestations
	 */
	public static List<Manifestation> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the manifestations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public static List<Manifestation> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the manifestations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the manifestations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByGroupId_First(
			long groupId, OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByGroupId_First(
		long groupId, OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByGroupId_Last(
			long groupId, OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByGroupId_Last(
		long groupId, OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public static Manifestation[] findByGroupId_PrevAndNext(
			long manifestationId, long groupId,
			OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByGroupId_PrevAndNext(
			manifestationId, groupId, orderByComparator);
	}

	/**
	 * Removes all the manifestations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of manifestations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching manifestations
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the matching manifestations
	 */
	public static List<Manifestation> findByPublicationDateAndStatus(
		Date publicationDate, int status) {

		return getPersistence().findByPublicationDateAndStatus(
			publicationDate, status);
	}

	/**
	 * Returns a range of all the manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public static List<Manifestation> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end) {

		return getPersistence().findByPublicationDateAndStatus(
			publicationDate, status, start, end);
	}

	/**
	 * Returns an ordered range of all the manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().findByPublicationDateAndStatus(
			publicationDate, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPublicationDateAndStatus(
			publicationDate, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByPublicationDateAndStatus_First(
			Date publicationDate, int status,
			OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByPublicationDateAndStatus_First(
			publicationDate, status, orderByComparator);
	}

	/**
	 * Returns the first manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByPublicationDateAndStatus_First(
		Date publicationDate, int status,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchByPublicationDateAndStatus_First(
			publicationDate, status, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByPublicationDateAndStatus_Last(
			Date publicationDate, int status,
			OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByPublicationDateAndStatus_Last(
			publicationDate, status, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByPublicationDateAndStatus_Last(
		Date publicationDate, int status,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchByPublicationDateAndStatus_Last(
			publicationDate, status, orderByComparator);
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public static Manifestation[] findByPublicationDateAndStatus_PrevAndNext(
			long manifestationId, Date publicationDate, int status,
			OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByPublicationDateAndStatus_PrevAndNext(
			manifestationId, publicationDate, status, orderByComparator);
	}

	/**
	 * Removes all the manifestations where publicationDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 */
	public static void removeByPublicationDateAndStatus(
		Date publicationDate, int status) {

		getPersistence().removeByPublicationDateAndStatus(
			publicationDate, status);
	}

	/**
	 * Returns the number of manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the number of matching manifestations
	 */
	public static int countByPublicationDateAndStatus(
		Date publicationDate, int status) {

		return getPersistence().countByPublicationDateAndStatus(
			publicationDate, status);
	}

	/**
	 * Returns all the manifestations where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @return the matching manifestations
	 */
	public static List<Manifestation> findByEndDate(Date endDate) {
		return getPersistence().findByEndDate(endDate);
	}

	/**
	 * Returns a range of all the manifestations where endDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public static List<Manifestation> findByEndDate(
		Date endDate, int start, int end) {

		return getPersistence().findByEndDate(endDate, start, end);
	}

	/**
	 * Returns an ordered range of all the manifestations where endDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findByEndDate(
		Date endDate, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().findByEndDate(
			endDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the manifestations where endDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findByEndDate(
		Date endDate, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEndDate(
			endDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByEndDate_First(
			Date endDate, OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByEndDate_First(endDate, orderByComparator);
	}

	/**
	 * Returns the first manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByEndDate_First(
		Date endDate, OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchByEndDate_First(
			endDate, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByEndDate_Last(
			Date endDate, OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByEndDate_Last(endDate, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByEndDate_Last(
		Date endDate, OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchByEndDate_Last(endDate, orderByComparator);
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public static Manifestation[] findByEndDate_PrevAndNext(
			long manifestationId, Date endDate,
			OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByEndDate_PrevAndNext(
			manifestationId, endDate, orderByComparator);
	}

	/**
	 * Removes all the manifestations where endDate &lt; &#63; from the database.
	 *
	 * @param endDate the end date
	 */
	public static void removeByEndDate(Date endDate) {
		getPersistence().removeByEndDate(endDate);
	}

	/**
	 * Returns the number of manifestations where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @return the number of matching manifestations
	 */
	public static int countByEndDate(Date endDate) {
		return getPersistence().countByEndDate(endDate);
	}

	/**
	 * Returns all the manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @return the matching manifestations
	 */
	public static List<Manifestation> findByStatusDateAndStatus(
		Date statusDate, int status) {

		return getPersistence().findByStatusDateAndStatus(statusDate, status);
	}

	/**
	 * Returns a range of all the manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public static List<Manifestation> findByStatusDateAndStatus(
		Date statusDate, int status, int start, int end) {

		return getPersistence().findByStatusDateAndStatus(
			statusDate, status, start, end);
	}

	/**
	 * Returns an ordered range of all the manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findByStatusDateAndStatus(
		Date statusDate, int status, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().findByStatusDateAndStatus(
			statusDate, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public static List<Manifestation> findByStatusDateAndStatus(
		Date statusDate, int status, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatusDateAndStatus(
			statusDate, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByStatusDateAndStatus_First(
			Date statusDate, int status,
			OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByStatusDateAndStatus_First(
			statusDate, status, orderByComparator);
	}

	/**
	 * Returns the first manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByStatusDateAndStatus_First(
		Date statusDate, int status,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchByStatusDateAndStatus_First(
			statusDate, status, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByStatusDateAndStatus_Last(
			Date statusDate, int status,
			OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByStatusDateAndStatus_Last(
			statusDate, status, orderByComparator);
	}

	/**
	 * Returns the last manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByStatusDateAndStatus_Last(
		Date statusDate, int status,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().fetchByStatusDateAndStatus_Last(
			statusDate, status, orderByComparator);
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public static Manifestation[] findByStatusDateAndStatus_PrevAndNext(
			long manifestationId, Date statusDate, int status,
			OrderByComparator<Manifestation> orderByComparator)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByStatusDateAndStatus_PrevAndNext(
			manifestationId, statusDate, status, orderByComparator);
	}

	/**
	 * Removes all the manifestations where statusDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 */
	public static void removeByStatusDateAndStatus(
		Date statusDate, int status) {

		getPersistence().removeByStatusDateAndStatus(statusDate, status);
	}

	/**
	 * Returns the number of manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @return the number of matching manifestations
	 */
	public static int countByStatusDateAndStatus(Date statusDate, int status) {
		return getPersistence().countByStatusDateAndStatus(statusDate, status);
	}

	/**
	 * Returns the manifestation where source = &#63; and idSource = &#63; or throws a <code>NoSuchManifestationException</code> if it could not be found.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @return the matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findBySourceAndIdSource(
			String source, String idSource)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findBySourceAndIdSource(source, idSource);
	}

	/**
	 * Returns the manifestation where source = &#63; and idSource = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchBySourceAndIdSource(
		String source, String idSource) {

		return getPersistence().fetchBySourceAndIdSource(source, idSource);
	}

	/**
	 * Returns the manifestation where source = &#63; and idSource = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchBySourceAndIdSource(
		String source, String idSource, boolean useFinderCache) {

		return getPersistence().fetchBySourceAndIdSource(
			source, idSource, useFinderCache);
	}

	/**
	 * Removes the manifestation where source = &#63; and idSource = &#63; from the database.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @return the manifestation that was removed
	 */
	public static Manifestation removeBySourceAndIdSource(
			String source, String idSource)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().removeBySourceAndIdSource(source, idSource);
	}

	/**
	 * Returns the number of manifestations where source = &#63; and idSource = &#63;.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @return the number of matching manifestations
	 */
	public static int countBySourceAndIdSource(String source, String idSource) {
		return getPersistence().countBySourceAndIdSource(source, idSource);
	}

	/**
	 * Returns the manifestation where idSource = &#63; or throws a <code>NoSuchManifestationException</code> if it could not be found.
	 *
	 * @param idSource the id source
	 * @return the matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public static Manifestation findByIdSource(String idSource)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByIdSource(idSource);
	}

	/**
	 * Returns the manifestation where idSource = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idSource the id source
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByIdSource(String idSource) {
		return getPersistence().fetchByIdSource(idSource);
	}

	/**
	 * Returns the manifestation where idSource = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idSource the id source
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchByIdSource(
		String idSource, boolean useFinderCache) {

		return getPersistence().fetchByIdSource(idSource, useFinderCache);
	}

	/**
	 * Removes the manifestation where idSource = &#63; from the database.
	 *
	 * @param idSource the id source
	 * @return the manifestation that was removed
	 */
	public static Manifestation removeByIdSource(String idSource)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().removeByIdSource(idSource);
	}

	/**
	 * Returns the number of manifestations where idSource = &#63;.
	 *
	 * @param idSource the id source
	 * @return the number of matching manifestations
	 */
	public static int countByIdSource(String idSource) {
		return getPersistence().countByIdSource(idSource);
	}

	/**
	 * Caches the manifestation in the entity cache if it is enabled.
	 *
	 * @param manifestation the manifestation
	 */
	public static void cacheResult(Manifestation manifestation) {
		getPersistence().cacheResult(manifestation);
	}

	/**
	 * Caches the manifestations in the entity cache if it is enabled.
	 *
	 * @param manifestations the manifestations
	 */
	public static void cacheResult(List<Manifestation> manifestations) {
		getPersistence().cacheResult(manifestations);
	}

	/**
	 * Creates a new manifestation with the primary key. Does not add the manifestation to the database.
	 *
	 * @param manifestationId the primary key for the new manifestation
	 * @return the new manifestation
	 */
	public static Manifestation create(long manifestationId) {
		return getPersistence().create(manifestationId);
	}

	/**
	 * Removes the manifestation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param manifestationId the primary key of the manifestation
	 * @return the manifestation that was removed
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public static Manifestation remove(long manifestationId)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().remove(manifestationId);
	}

	public static Manifestation updateImpl(Manifestation manifestation) {
		return getPersistence().updateImpl(manifestation);
	}

	/**
	 * Returns the manifestation with the primary key or throws a <code>NoSuchManifestationException</code> if it could not be found.
	 *
	 * @param manifestationId the primary key of the manifestation
	 * @return the manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public static Manifestation findByPrimaryKey(long manifestationId)
		throws eu.strasbourg.service.agenda.exception.
			NoSuchManifestationException {

		return getPersistence().findByPrimaryKey(manifestationId);
	}

	/**
	 * Returns the manifestation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param manifestationId the primary key of the manifestation
	 * @return the manifestation, or <code>null</code> if a manifestation with the primary key could not be found
	 */
	public static Manifestation fetchByPrimaryKey(long manifestationId) {
		return getPersistence().fetchByPrimaryKey(manifestationId);
	}

	/**
	 * Returns all the manifestations.
	 *
	 * @return the manifestations
	 */
	public static List<Manifestation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the manifestations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of manifestations
	 */
	public static List<Manifestation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the manifestations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of manifestations
	 */
	public static List<Manifestation> findAll(
		int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the manifestations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of manifestations
	 */
	public static List<Manifestation> findAll(
		int start, int end, OrderByComparator<Manifestation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the manifestations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of manifestations.
	 *
	 * @return the number of manifestations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of events associated with the manifestation.
	 *
	 * @param pk the primary key of the manifestation
	 * @return long[] of the primaryKeys of events associated with the manifestation
	 */
	public static long[] getEventPrimaryKeys(long pk) {
		return getPersistence().getEventPrimaryKeys(pk);
	}

	/**
	 * Returns all the events associated with the manifestation.
	 *
	 * @param pk the primary key of the manifestation
	 * @return the events associated with the manifestation
	 */
	public static List<eu.strasbourg.service.agenda.model.Event> getEvents(
		long pk) {

		return getPersistence().getEvents(pk);
	}

	/**
	 * Returns a range of all the events associated with the manifestation.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the manifestation
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of events associated with the manifestation
	 */
	public static List<eu.strasbourg.service.agenda.model.Event> getEvents(
		long pk, int start, int end) {

		return getPersistence().getEvents(pk, start, end);
	}

	/**
	 * Returns an ordered range of all the events associated with the manifestation.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the manifestation
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of events associated with the manifestation
	 */
	public static List<eu.strasbourg.service.agenda.model.Event> getEvents(
		long pk, int start, int end,
		OrderByComparator<eu.strasbourg.service.agenda.model.Event>
			orderByComparator) {

		return getPersistence().getEvents(pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of events associated with the manifestation.
	 *
	 * @param pk the primary key of the manifestation
	 * @return the number of events associated with the manifestation
	 */
	public static int getEventsSize(long pk) {
		return getPersistence().getEventsSize(pk);
	}

	/**
	 * Returns <code>true</code> if the event is associated with the manifestation.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPK the primary key of the event
	 * @return <code>true</code> if the event is associated with the manifestation; <code>false</code> otherwise
	 */
	public static boolean containsEvent(long pk, long eventPK) {
		return getPersistence().containsEvent(pk, eventPK);
	}

	/**
	 * Returns <code>true</code> if the manifestation has any events associated with it.
	 *
	 * @param pk the primary key of the manifestation to check for associations with events
	 * @return <code>true</code> if the manifestation has any events associated with it; <code>false</code> otherwise
	 */
	public static boolean containsEvents(long pk) {
		return getPersistence().containsEvents(pk);
	}

	/**
	 * Adds an association between the manifestation and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPK the primary key of the event
	 * @return <code>true</code> if an association between the manifestation and the event was added; <code>false</code> if they were already associated
	 */
	public static boolean addEvent(long pk, long eventPK) {
		return getPersistence().addEvent(pk, eventPK);
	}

	/**
	 * Adds an association between the manifestation and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param event the event
	 * @return <code>true</code> if an association between the manifestation and the event was added; <code>false</code> if they were already associated
	 */
	public static boolean addEvent(
		long pk, eu.strasbourg.service.agenda.model.Event event) {

		return getPersistence().addEvent(pk, event);
	}

	/**
	 * Adds an association between the manifestation and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPKs the primary keys of the events
	 * @return <code>true</code> if at least one association between the manifestation and the events was added; <code>false</code> if they were all already associated
	 */
	public static boolean addEvents(long pk, long[] eventPKs) {
		return getPersistence().addEvents(pk, eventPKs);
	}

	/**
	 * Adds an association between the manifestation and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param events the events
	 * @return <code>true</code> if at least one association between the manifestation and the events was added; <code>false</code> if they were all already associated
	 */
	public static boolean addEvents(
		long pk, List<eu.strasbourg.service.agenda.model.Event> events) {

		return getPersistence().addEvents(pk, events);
	}

	/**
	 * Clears all associations between the manifestation and its events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation to clear the associated events from
	 */
	public static void clearEvents(long pk) {
		getPersistence().clearEvents(pk);
	}

	/**
	 * Removes the association between the manifestation and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPK the primary key of the event
	 */
	public static void removeEvent(long pk, long eventPK) {
		getPersistence().removeEvent(pk, eventPK);
	}

	/**
	 * Removes the association between the manifestation and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param event the event
	 */
	public static void removeEvent(
		long pk, eu.strasbourg.service.agenda.model.Event event) {

		getPersistence().removeEvent(pk, event);
	}

	/**
	 * Removes the association between the manifestation and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPKs the primary keys of the events
	 */
	public static void removeEvents(long pk, long[] eventPKs) {
		getPersistence().removeEvents(pk, eventPKs);
	}

	/**
	 * Removes the association between the manifestation and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param events the events
	 */
	public static void removeEvents(
		long pk, List<eu.strasbourg.service.agenda.model.Event> events) {

		getPersistence().removeEvents(pk, events);
	}

	/**
	 * Sets the events associated with the manifestation, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPKs the primary keys of the events to be associated with the manifestation
	 */
	public static void setEvents(long pk, long[] eventPKs) {
		getPersistence().setEvents(pk, eventPKs);
	}

	/**
	 * Sets the events associated with the manifestation, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param events the events to be associated with the manifestation
	 */
	public static void setEvents(
		long pk, List<eu.strasbourg.service.agenda.model.Event> events) {

		getPersistence().setEvents(pk, events);
	}

	public static ManifestationPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ManifestationPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ManifestationPersistence _persistence;

}