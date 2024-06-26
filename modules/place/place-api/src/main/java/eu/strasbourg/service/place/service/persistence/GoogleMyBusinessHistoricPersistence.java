/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.place.exception.NoSuchGoogleMyBusinessHistoricException;
import eu.strasbourg.service.place.model.GoogleMyBusinessHistoric;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the google my business historic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see GoogleMyBusinessHistoricUtil
 * @generated
 */
@ProviderType
public interface GoogleMyBusinessHistoricPersistence
	extends BasePersistence<GoogleMyBusinessHistoric> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GoogleMyBusinessHistoricUtil} to access the google my business historic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the google my business historics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findByUuid(String uuid);

	/**
	 * Returns a range of all the google my business historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @return the range of matching google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the google my business historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator);

	/**
	 * Returns an ordered range of all the google my business historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first google my business historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching google my business historic
	 * @throws NoSuchGoogleMyBusinessHistoricException if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<GoogleMyBusinessHistoric> orderByComparator)
		throws NoSuchGoogleMyBusinessHistoricException;

	/**
	 * Returns the first google my business historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching google my business historic, or <code>null</code> if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator);

	/**
	 * Returns the last google my business historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching google my business historic
	 * @throws NoSuchGoogleMyBusinessHistoricException if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<GoogleMyBusinessHistoric> orderByComparator)
		throws NoSuchGoogleMyBusinessHistoricException;

	/**
	 * Returns the last google my business historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching google my business historic, or <code>null</code> if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator);

	/**
	 * Returns the google my business historics before and after the current google my business historic in the ordered set where uuid = &#63;.
	 *
	 * @param googleMyBusinessHistoricId the primary key of the current google my business historic
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next google my business historic
	 * @throws NoSuchGoogleMyBusinessHistoricException if a google my business historic with the primary key could not be found
	 */
	public GoogleMyBusinessHistoric[] findByUuid_PrevAndNext(
			long googleMyBusinessHistoricId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<GoogleMyBusinessHistoric> orderByComparator)
		throws NoSuchGoogleMyBusinessHistoricException;

	/**
	 * Removes all the google my business historics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of google my business historics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching google my business historics
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the google my business historic where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchGoogleMyBusinessHistoricException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching google my business historic
	 * @throws NoSuchGoogleMyBusinessHistoricException if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric findByUUID_G(String uuid, long groupId)
		throws NoSuchGoogleMyBusinessHistoricException;

	/**
	 * Returns the google my business historic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching google my business historic, or <code>null</code> if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the google my business historic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching google my business historic, or <code>null</code> if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the google my business historic where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the google my business historic that was removed
	 */
	public GoogleMyBusinessHistoric removeByUUID_G(String uuid, long groupId)
		throws NoSuchGoogleMyBusinessHistoricException;

	/**
	 * Returns the number of google my business historics where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching google my business historics
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the google my business historics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the google my business historics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @return the range of matching google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the google my business historics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator);

	/**
	 * Returns an ordered range of all the google my business historics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first google my business historic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching google my business historic
	 * @throws NoSuchGoogleMyBusinessHistoricException if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GoogleMyBusinessHistoric> orderByComparator)
		throws NoSuchGoogleMyBusinessHistoricException;

	/**
	 * Returns the first google my business historic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching google my business historic, or <code>null</code> if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator);

	/**
	 * Returns the last google my business historic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching google my business historic
	 * @throws NoSuchGoogleMyBusinessHistoricException if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GoogleMyBusinessHistoric> orderByComparator)
		throws NoSuchGoogleMyBusinessHistoricException;

	/**
	 * Returns the last google my business historic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching google my business historic, or <code>null</code> if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator);

	/**
	 * Returns the google my business historics before and after the current google my business historic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param googleMyBusinessHistoricId the primary key of the current google my business historic
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next google my business historic
	 * @throws NoSuchGoogleMyBusinessHistoricException if a google my business historic with the primary key could not be found
	 */
	public GoogleMyBusinessHistoric[] findByUuid_C_PrevAndNext(
			long googleMyBusinessHistoricId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GoogleMyBusinessHistoric> orderByComparator)
		throws NoSuchGoogleMyBusinessHistoricException;

	/**
	 * Removes all the google my business historics where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of google my business historics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching google my business historics
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the google my business historics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findByGroupId(long groupId);

	/**
	 * Returns a range of all the google my business historics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @return the range of matching google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the google my business historics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator);

	/**
	 * Returns an ordered range of all the google my business historics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first google my business historic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching google my business historic
	 * @throws NoSuchGoogleMyBusinessHistoricException if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GoogleMyBusinessHistoric> orderByComparator)
		throws NoSuchGoogleMyBusinessHistoricException;

	/**
	 * Returns the first google my business historic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching google my business historic, or <code>null</code> if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator);

	/**
	 * Returns the last google my business historic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching google my business historic
	 * @throws NoSuchGoogleMyBusinessHistoricException if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GoogleMyBusinessHistoric> orderByComparator)
		throws NoSuchGoogleMyBusinessHistoricException;

	/**
	 * Returns the last google my business historic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching google my business historic, or <code>null</code> if a matching google my business historic could not be found
	 */
	public GoogleMyBusinessHistoric fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator);

	/**
	 * Returns the google my business historics before and after the current google my business historic in the ordered set where groupId = &#63;.
	 *
	 * @param googleMyBusinessHistoricId the primary key of the current google my business historic
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next google my business historic
	 * @throws NoSuchGoogleMyBusinessHistoricException if a google my business historic with the primary key could not be found
	 */
	public GoogleMyBusinessHistoric[] findByGroupId_PrevAndNext(
			long googleMyBusinessHistoricId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GoogleMyBusinessHistoric> orderByComparator)
		throws NoSuchGoogleMyBusinessHistoricException;

	/**
	 * Removes all the google my business historics where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of google my business historics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching google my business historics
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the google my business historic in the entity cache if it is enabled.
	 *
	 * @param googleMyBusinessHistoric the google my business historic
	 */
	public void cacheResult(GoogleMyBusinessHistoric googleMyBusinessHistoric);

	/**
	 * Caches the google my business historics in the entity cache if it is enabled.
	 *
	 * @param googleMyBusinessHistorics the google my business historics
	 */
	public void cacheResult(
		java.util.List<GoogleMyBusinessHistoric> googleMyBusinessHistorics);

	/**
	 * Creates a new google my business historic with the primary key. Does not add the google my business historic to the database.
	 *
	 * @param googleMyBusinessHistoricId the primary key for the new google my business historic
	 * @return the new google my business historic
	 */
	public GoogleMyBusinessHistoric create(long googleMyBusinessHistoricId);

	/**
	 * Removes the google my business historic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param googleMyBusinessHistoricId the primary key of the google my business historic
	 * @return the google my business historic that was removed
	 * @throws NoSuchGoogleMyBusinessHistoricException if a google my business historic with the primary key could not be found
	 */
	public GoogleMyBusinessHistoric remove(long googleMyBusinessHistoricId)
		throws NoSuchGoogleMyBusinessHistoricException;

	public GoogleMyBusinessHistoric updateImpl(
		GoogleMyBusinessHistoric googleMyBusinessHistoric);

	/**
	 * Returns the google my business historic with the primary key or throws a <code>NoSuchGoogleMyBusinessHistoricException</code> if it could not be found.
	 *
	 * @param googleMyBusinessHistoricId the primary key of the google my business historic
	 * @return the google my business historic
	 * @throws NoSuchGoogleMyBusinessHistoricException if a google my business historic with the primary key could not be found
	 */
	public GoogleMyBusinessHistoric findByPrimaryKey(
			long googleMyBusinessHistoricId)
		throws NoSuchGoogleMyBusinessHistoricException;

	/**
	 * Returns the google my business historic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param googleMyBusinessHistoricId the primary key of the google my business historic
	 * @return the google my business historic, or <code>null</code> if a google my business historic with the primary key could not be found
	 */
	public GoogleMyBusinessHistoric fetchByPrimaryKey(
		long googleMyBusinessHistoricId);

	/**
	 * Returns all the google my business historics.
	 *
	 * @return the google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findAll();

	/**
	 * Returns a range of all the google my business historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @return the range of google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the google my business historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator);

	/**
	 * Returns an ordered range of all the google my business historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of google my business historics
	 */
	public java.util.List<GoogleMyBusinessHistoric> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<GoogleMyBusinessHistoric> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the google my business historics from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of google my business historics.
	 *
	 * @return the number of google my business historics
	 */
	public int countAll();

}