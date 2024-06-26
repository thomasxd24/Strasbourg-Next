/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.edition.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.edition.model.EditionGallery;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the edition gallery service. This utility wraps <code>eu.strasbourg.service.edition.service.persistence.impl.EditionGalleryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see EditionGalleryPersistence
 * @generated
 */
public class EditionGalleryUtil {

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
	public static void clearCache(EditionGallery editionGallery) {
		getPersistence().clearCache(editionGallery);
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
	public static Map<Serializable, EditionGallery> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EditionGallery> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EditionGallery> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EditionGallery> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EditionGallery update(EditionGallery editionGallery) {
		return getPersistence().update(editionGallery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EditionGallery update(
		EditionGallery editionGallery, ServiceContext serviceContext) {

		return getPersistence().update(editionGallery, serviceContext);
	}

	/**
	 * Returns all the edition galleries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching edition galleries
	 */
	public static List<EditionGallery> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the edition galleries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of matching edition galleries
	 */
	public static List<EditionGallery> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the edition galleries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching edition galleries
	 */
	public static List<EditionGallery> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the edition galleries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching edition galleries
	 */
	public static List<EditionGallery> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EditionGallery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first edition gallery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public static EditionGallery findByUuid_First(
			String uuid, OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first edition gallery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public static EditionGallery fetchByUuid_First(
		String uuid, OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last edition gallery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public static EditionGallery findByUuid_Last(
			String uuid, OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last edition gallery in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public static EditionGallery fetchByUuid_Last(
		String uuid, OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the edition galleries before and after the current edition gallery in the ordered set where uuid = &#63;.
	 *
	 * @param galleryId the primary key of the current edition gallery
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition gallery
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public static EditionGallery[] findByUuid_PrevAndNext(
			long galleryId, String uuid,
			OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByUuid_PrevAndNext(
			galleryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the edition galleries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of edition galleries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching edition galleries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the edition gallery where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEditionGalleryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public static EditionGallery findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the edition gallery where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public static EditionGallery fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the edition gallery where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public static EditionGallery fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the edition gallery where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the edition gallery that was removed
	 */
	public static EditionGallery removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of edition galleries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching edition galleries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the edition galleries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching edition galleries
	 */
	public static List<EditionGallery> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the edition galleries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of matching edition galleries
	 */
	public static List<EditionGallery> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the edition galleries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching edition galleries
	 */
	public static List<EditionGallery> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the edition galleries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching edition galleries
	 */
	public static List<EditionGallery> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EditionGallery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first edition gallery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public static EditionGallery findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first edition gallery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public static EditionGallery fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last edition gallery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public static EditionGallery findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last edition gallery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public static EditionGallery fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the edition galleries before and after the current edition gallery in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param galleryId the primary key of the current edition gallery
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition gallery
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public static EditionGallery[] findByUuid_C_PrevAndNext(
			long galleryId, String uuid, long companyId,
			OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			galleryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the edition galleries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of edition galleries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching edition galleries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the edition galleries where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching edition galleries
	 */
	public static List<EditionGallery> findBytitle(String title) {
		return getPersistence().findBytitle(title);
	}

	/**
	 * Returns a range of all the edition galleries where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of matching edition galleries
	 */
	public static List<EditionGallery> findBytitle(
		String title, int start, int end) {

		return getPersistence().findBytitle(title, start, end);
	}

	/**
	 * Returns an ordered range of all the edition galleries where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching edition galleries
	 */
	public static List<EditionGallery> findBytitle(
		String title, int start, int end,
		OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().findBytitle(
			title, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the edition galleries where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching edition galleries
	 */
	public static List<EditionGallery> findBytitle(
		String title, int start, int end,
		OrderByComparator<EditionGallery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBytitle(
			title, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first edition gallery in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public static EditionGallery findBytitle_First(
			String title, OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findBytitle_First(title, orderByComparator);
	}

	/**
	 * Returns the first edition gallery in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public static EditionGallery fetchBytitle_First(
		String title, OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().fetchBytitle_First(title, orderByComparator);
	}

	/**
	 * Returns the last edition gallery in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public static EditionGallery findBytitle_Last(
			String title, OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findBytitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the last edition gallery in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public static EditionGallery fetchBytitle_Last(
		String title, OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().fetchBytitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the edition galleries before and after the current edition gallery in the ordered set where title = &#63;.
	 *
	 * @param galleryId the primary key of the current edition gallery
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition gallery
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public static EditionGallery[] findBytitle_PrevAndNext(
			long galleryId, String title,
			OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findBytitle_PrevAndNext(
			galleryId, title, orderByComparator);
	}

	/**
	 * Removes all the edition galleries where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public static void removeBytitle(String title) {
		getPersistence().removeBytitle(title);
	}

	/**
	 * Returns the number of edition galleries where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching edition galleries
	 */
	public static int countBytitle(String title) {
		return getPersistence().countBytitle(title);
	}

	/**
	 * Returns all the edition galleries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching edition galleries
	 */
	public static List<EditionGallery> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the edition galleries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of matching edition galleries
	 */
	public static List<EditionGallery> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the edition galleries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching edition galleries
	 */
	public static List<EditionGallery> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the edition galleries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching edition galleries
	 */
	public static List<EditionGallery> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<EditionGallery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first edition gallery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public static EditionGallery findByGroupId_First(
			long groupId, OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first edition gallery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public static EditionGallery fetchByGroupId_First(
		long groupId, OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last edition gallery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public static EditionGallery findByGroupId_Last(
			long groupId, OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last edition gallery in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public static EditionGallery fetchByGroupId_Last(
		long groupId, OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the edition galleries before and after the current edition gallery in the ordered set where groupId = &#63;.
	 *
	 * @param galleryId the primary key of the current edition gallery
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition gallery
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public static EditionGallery[] findByGroupId_PrevAndNext(
			long galleryId, long groupId,
			OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByGroupId_PrevAndNext(
			galleryId, groupId, orderByComparator);
	}

	/**
	 * Removes all the edition galleries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of edition galleries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching edition galleries
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the edition galleries where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the matching edition galleries
	 */
	public static List<EditionGallery> findByPublicationDateAndStatus(
		Date publicationDate, int status) {

		return getPersistence().findByPublicationDateAndStatus(
			publicationDate, status);
	}

	/**
	 * Returns a range of all the edition galleries where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of matching edition galleries
	 */
	public static List<EditionGallery> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end) {

		return getPersistence().findByPublicationDateAndStatus(
			publicationDate, status, start, end);
	}

	/**
	 * Returns an ordered range of all the edition galleries where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching edition galleries
	 */
	public static List<EditionGallery> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().findByPublicationDateAndStatus(
			publicationDate, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the edition galleries where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching edition galleries
	 */
	public static List<EditionGallery> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		OrderByComparator<EditionGallery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPublicationDateAndStatus(
			publicationDate, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first edition gallery in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public static EditionGallery findByPublicationDateAndStatus_First(
			Date publicationDate, int status,
			OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByPublicationDateAndStatus_First(
			publicationDate, status, orderByComparator);
	}

	/**
	 * Returns the first edition gallery in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public static EditionGallery fetchByPublicationDateAndStatus_First(
		Date publicationDate, int status,
		OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().fetchByPublicationDateAndStatus_First(
			publicationDate, status, orderByComparator);
	}

	/**
	 * Returns the last edition gallery in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery
	 * @throws NoSuchEditionGalleryException if a matching edition gallery could not be found
	 */
	public static EditionGallery findByPublicationDateAndStatus_Last(
			Date publicationDate, int status,
			OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByPublicationDateAndStatus_Last(
			publicationDate, status, orderByComparator);
	}

	/**
	 * Returns the last edition gallery in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public static EditionGallery fetchByPublicationDateAndStatus_Last(
		Date publicationDate, int status,
		OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().fetchByPublicationDateAndStatus_Last(
			publicationDate, status, orderByComparator);
	}

	/**
	 * Returns the edition galleries before and after the current edition gallery in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param galleryId the primary key of the current edition gallery
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition gallery
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public static EditionGallery[] findByPublicationDateAndStatus_PrevAndNext(
			long galleryId, Date publicationDate, int status,
			OrderByComparator<EditionGallery> orderByComparator)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByPublicationDateAndStatus_PrevAndNext(
			galleryId, publicationDate, status, orderByComparator);
	}

	/**
	 * Removes all the edition galleries where publicationDate &lt; &#63; and status = &#63; from the database.
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
	 * Returns the number of edition galleries where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the number of matching edition galleries
	 */
	public static int countByPublicationDateAndStatus(
		Date publicationDate, int status) {

		return getPersistence().countByPublicationDateAndStatus(
			publicationDate, status);
	}

	/**
	 * Caches the edition gallery in the entity cache if it is enabled.
	 *
	 * @param editionGallery the edition gallery
	 */
	public static void cacheResult(EditionGallery editionGallery) {
		getPersistence().cacheResult(editionGallery);
	}

	/**
	 * Caches the edition galleries in the entity cache if it is enabled.
	 *
	 * @param editionGalleries the edition galleries
	 */
	public static void cacheResult(List<EditionGallery> editionGalleries) {
		getPersistence().cacheResult(editionGalleries);
	}

	/**
	 * Creates a new edition gallery with the primary key. Does not add the edition gallery to the database.
	 *
	 * @param galleryId the primary key for the new edition gallery
	 * @return the new edition gallery
	 */
	public static EditionGallery create(long galleryId) {
		return getPersistence().create(galleryId);
	}

	/**
	 * Removes the edition gallery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param galleryId the primary key of the edition gallery
	 * @return the edition gallery that was removed
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public static EditionGallery remove(long galleryId)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().remove(galleryId);
	}

	public static EditionGallery updateImpl(EditionGallery editionGallery) {
		return getPersistence().updateImpl(editionGallery);
	}

	/**
	 * Returns the edition gallery with the primary key or throws a <code>NoSuchEditionGalleryException</code> if it could not be found.
	 *
	 * @param galleryId the primary key of the edition gallery
	 * @return the edition gallery
	 * @throws NoSuchEditionGalleryException if a edition gallery with the primary key could not be found
	 */
	public static EditionGallery findByPrimaryKey(long galleryId)
		throws eu.strasbourg.service.edition.exception.
			NoSuchEditionGalleryException {

		return getPersistence().findByPrimaryKey(galleryId);
	}

	/**
	 * Returns the edition gallery with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param galleryId the primary key of the edition gallery
	 * @return the edition gallery, or <code>null</code> if a edition gallery with the primary key could not be found
	 */
	public static EditionGallery fetchByPrimaryKey(long galleryId) {
		return getPersistence().fetchByPrimaryKey(galleryId);
	}

	/**
	 * Returns all the edition galleries.
	 *
	 * @return the edition galleries
	 */
	public static List<EditionGallery> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the edition galleries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of edition galleries
	 */
	public static List<EditionGallery> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the edition galleries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of edition galleries
	 */
	public static List<EditionGallery> findAll(
		int start, int end,
		OrderByComparator<EditionGallery> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the edition galleries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of edition galleries
	 */
	public static List<EditionGallery> findAll(
		int start, int end, OrderByComparator<EditionGallery> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the edition galleries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of edition galleries.
	 *
	 * @return the number of edition galleries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of editions associated with the edition gallery.
	 *
	 * @param pk the primary key of the edition gallery
	 * @return long[] of the primaryKeys of editions associated with the edition gallery
	 */
	public static long[] getEditionPrimaryKeys(long pk) {
		return getPersistence().getEditionPrimaryKeys(pk);
	}

	/**
	 * Returns all the editions associated with the edition gallery.
	 *
	 * @param pk the primary key of the edition gallery
	 * @return the editions associated with the edition gallery
	 */
	public static List<eu.strasbourg.service.edition.model.Edition> getEditions(
		long pk) {

		return getPersistence().getEditions(pk);
	}

	/**
	 * Returns a range of all the editions associated with the edition gallery.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the edition gallery
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of editions associated with the edition gallery
	 */
	public static List<eu.strasbourg.service.edition.model.Edition> getEditions(
		long pk, int start, int end) {

		return getPersistence().getEditions(pk, start, end);
	}

	/**
	 * Returns an ordered range of all the editions associated with the edition gallery.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the edition gallery
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of editions associated with the edition gallery
	 */
	public static List<eu.strasbourg.service.edition.model.Edition> getEditions(
		long pk, int start, int end,
		OrderByComparator<eu.strasbourg.service.edition.model.Edition>
			orderByComparator) {

		return getPersistence().getEditions(pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of editions associated with the edition gallery.
	 *
	 * @param pk the primary key of the edition gallery
	 * @return the number of editions associated with the edition gallery
	 */
	public static int getEditionsSize(long pk) {
		return getPersistence().getEditionsSize(pk);
	}

	/**
	 * Returns <code>true</code> if the edition is associated with the edition gallery.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editionPK the primary key of the edition
	 * @return <code>true</code> if the edition is associated with the edition gallery; <code>false</code> otherwise
	 */
	public static boolean containsEdition(long pk, long editionPK) {
		return getPersistence().containsEdition(pk, editionPK);
	}

	/**
	 * Returns <code>true</code> if the edition gallery has any editions associated with it.
	 *
	 * @param pk the primary key of the edition gallery to check for associations with editions
	 * @return <code>true</code> if the edition gallery has any editions associated with it; <code>false</code> otherwise
	 */
	public static boolean containsEditions(long pk) {
		return getPersistence().containsEditions(pk);
	}

	/**
	 * Adds an association between the edition gallery and the edition. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editionPK the primary key of the edition
	 * @return <code>true</code> if an association between the edition gallery and the edition was added; <code>false</code> if they were already associated
	 */
	public static boolean addEdition(long pk, long editionPK) {
		return getPersistence().addEdition(pk, editionPK);
	}

	/**
	 * Adds an association between the edition gallery and the edition. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param edition the edition
	 * @return <code>true</code> if an association between the edition gallery and the edition was added; <code>false</code> if they were already associated
	 */
	public static boolean addEdition(
		long pk, eu.strasbourg.service.edition.model.Edition edition) {

		return getPersistence().addEdition(pk, edition);
	}

	/**
	 * Adds an association between the edition gallery and the editions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editionPKs the primary keys of the editions
	 * @return <code>true</code> if at least one association between the edition gallery and the editions was added; <code>false</code> if they were all already associated
	 */
	public static boolean addEditions(long pk, long[] editionPKs) {
		return getPersistence().addEditions(pk, editionPKs);
	}

	/**
	 * Adds an association between the edition gallery and the editions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editions the editions
	 * @return <code>true</code> if at least one association between the edition gallery and the editions was added; <code>false</code> if they were all already associated
	 */
	public static boolean addEditions(
		long pk, List<eu.strasbourg.service.edition.model.Edition> editions) {

		return getPersistence().addEditions(pk, editions);
	}

	/**
	 * Clears all associations between the edition gallery and its editions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery to clear the associated editions from
	 */
	public static void clearEditions(long pk) {
		getPersistence().clearEditions(pk);
	}

	/**
	 * Removes the association between the edition gallery and the edition. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editionPK the primary key of the edition
	 */
	public static void removeEdition(long pk, long editionPK) {
		getPersistence().removeEdition(pk, editionPK);
	}

	/**
	 * Removes the association between the edition gallery and the edition. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param edition the edition
	 */
	public static void removeEdition(
		long pk, eu.strasbourg.service.edition.model.Edition edition) {

		getPersistence().removeEdition(pk, edition);
	}

	/**
	 * Removes the association between the edition gallery and the editions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editionPKs the primary keys of the editions
	 */
	public static void removeEditions(long pk, long[] editionPKs) {
		getPersistence().removeEditions(pk, editionPKs);
	}

	/**
	 * Removes the association between the edition gallery and the editions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editions the editions
	 */
	public static void removeEditions(
		long pk, List<eu.strasbourg.service.edition.model.Edition> editions) {

		getPersistence().removeEditions(pk, editions);
	}

	/**
	 * Sets the editions associated with the edition gallery, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editionPKs the primary keys of the editions to be associated with the edition gallery
	 */
	public static void setEditions(long pk, long[] editionPKs) {
		getPersistence().setEditions(pk, editionPKs);
	}

	/**
	 * Sets the editions associated with the edition gallery, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition gallery
	 * @param editions the editions to be associated with the edition gallery
	 */
	public static void setEditions(
		long pk, List<eu.strasbourg.service.edition.model.Edition> editions) {

		getPersistence().setEditions(pk, editions);
	}

	public static EditionGalleryPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EditionGalleryPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EditionGalleryPersistence _persistence;

}