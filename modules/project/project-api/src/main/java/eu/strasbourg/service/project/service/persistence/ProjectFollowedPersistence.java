/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.project.exception.NoSuchProjectFollowedException;
import eu.strasbourg.service.project.model.ProjectFollowed;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the project followed service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see ProjectFollowedUtil
 * @generated
 */
@ProviderType
public interface ProjectFollowedPersistence
	extends BasePersistence<ProjectFollowed> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectFollowedUtil} to access the project followed persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the project followeds where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the matching project followeds
	 */
	public java.util.List<ProjectFollowed> findByPublikUserId(
		String publikUserId);

	/**
	 * Returns a range of all the project followeds where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectFollowedModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of project followeds
	 * @param end the upper bound of the range of project followeds (not inclusive)
	 * @return the range of matching project followeds
	 */
	public java.util.List<ProjectFollowed> findByPublikUserId(
		String publikUserId, int start, int end);

	/**
	 * Returns an ordered range of all the project followeds where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectFollowedModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of project followeds
	 * @param end the upper bound of the range of project followeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project followeds
	 */
	public java.util.List<ProjectFollowed> findByPublikUserId(
		String publikUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project followeds where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectFollowedModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of project followeds
	 * @param end the upper bound of the range of project followeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project followeds
	 */
	public java.util.List<ProjectFollowed> findByPublikUserId(
		String publikUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project followed in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project followed
	 * @throws NoSuchProjectFollowedException if a matching project followed could not be found
	 */
	public ProjectFollowed findByPublikUserId_First(
			String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
				orderByComparator)
		throws NoSuchProjectFollowedException;

	/**
	 * Returns the first project followed in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project followed, or <code>null</code> if a matching project followed could not be found
	 */
	public ProjectFollowed fetchByPublikUserId_First(
		String publikUserId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
			orderByComparator);

	/**
	 * Returns the last project followed in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project followed
	 * @throws NoSuchProjectFollowedException if a matching project followed could not be found
	 */
	public ProjectFollowed findByPublikUserId_Last(
			String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
				orderByComparator)
		throws NoSuchProjectFollowedException;

	/**
	 * Returns the last project followed in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project followed, or <code>null</code> if a matching project followed could not be found
	 */
	public ProjectFollowed fetchByPublikUserId_Last(
		String publikUserId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
			orderByComparator);

	/**
	 * Returns the project followeds before and after the current project followed in the ordered set where publikUserId = &#63;.
	 *
	 * @param projectFollowedId the primary key of the current project followed
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project followed
	 * @throws NoSuchProjectFollowedException if a project followed with the primary key could not be found
	 */
	public ProjectFollowed[] findByPublikUserId_PrevAndNext(
			long projectFollowedId, String publikUserId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
				orderByComparator)
		throws NoSuchProjectFollowedException;

	/**
	 * Removes all the project followeds where publikUserId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 */
	public void removeByPublikUserId(String publikUserId);

	/**
	 * Returns the number of project followeds where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the number of matching project followeds
	 */
	public int countByPublikUserId(String publikUserId);

	/**
	 * Returns all the project followeds where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching project followeds
	 */
	public java.util.List<ProjectFollowed> findByProjectId(long projectId);

	/**
	 * Returns a range of all the project followeds where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectFollowedModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project followeds
	 * @param end the upper bound of the range of project followeds (not inclusive)
	 * @return the range of matching project followeds
	 */
	public java.util.List<ProjectFollowed> findByProjectId(
		long projectId, int start, int end);

	/**
	 * Returns an ordered range of all the project followeds where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectFollowedModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project followeds
	 * @param end the upper bound of the range of project followeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project followeds
	 */
	public java.util.List<ProjectFollowed> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project followeds where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectFollowedModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of project followeds
	 * @param end the upper bound of the range of project followeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project followeds
	 */
	public java.util.List<ProjectFollowed> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project followed in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project followed
	 * @throws NoSuchProjectFollowedException if a matching project followed could not be found
	 */
	public ProjectFollowed findByProjectId_First(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
				orderByComparator)
		throws NoSuchProjectFollowedException;

	/**
	 * Returns the first project followed in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project followed, or <code>null</code> if a matching project followed could not be found
	 */
	public ProjectFollowed fetchByProjectId_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
			orderByComparator);

	/**
	 * Returns the last project followed in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project followed
	 * @throws NoSuchProjectFollowedException if a matching project followed could not be found
	 */
	public ProjectFollowed findByProjectId_Last(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
				orderByComparator)
		throws NoSuchProjectFollowedException;

	/**
	 * Returns the last project followed in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project followed, or <code>null</code> if a matching project followed could not be found
	 */
	public ProjectFollowed fetchByProjectId_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
			orderByComparator);

	/**
	 * Returns the project followeds before and after the current project followed in the ordered set where projectId = &#63;.
	 *
	 * @param projectFollowedId the primary key of the current project followed
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project followed
	 * @throws NoSuchProjectFollowedException if a project followed with the primary key could not be found
	 */
	public ProjectFollowed[] findByProjectId_PrevAndNext(
			long projectFollowedId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
				orderByComparator)
		throws NoSuchProjectFollowedException;

	/**
	 * Removes all the project followeds where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public void removeByProjectId(long projectId);

	/**
	 * Returns the number of project followeds where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching project followeds
	 */
	public int countByProjectId(long projectId);

	/**
	 * Returns the project followed where publikUserId = &#63; and projectId = &#63; or throws a <code>NoSuchProjectFollowedException</code> if it could not be found.
	 *
	 * @param publikUserId the publik user ID
	 * @param projectId the project ID
	 * @return the matching project followed
	 * @throws NoSuchProjectFollowedException if a matching project followed could not be found
	 */
	public ProjectFollowed findByPublikUserIdAndProjectId(
			String publikUserId, long projectId)
		throws NoSuchProjectFollowedException;

	/**
	 * Returns the project followed where publikUserId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publikUserId the publik user ID
	 * @param projectId the project ID
	 * @return the matching project followed, or <code>null</code> if a matching project followed could not be found
	 */
	public ProjectFollowed fetchByPublikUserIdAndProjectId(
		String publikUserId, long projectId);

	/**
	 * Returns the project followed where publikUserId = &#63; and projectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publikUserId the publik user ID
	 * @param projectId the project ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project followed, or <code>null</code> if a matching project followed could not be found
	 */
	public ProjectFollowed fetchByPublikUserIdAndProjectId(
		String publikUserId, long projectId, boolean useFinderCache);

	/**
	 * Removes the project followed where publikUserId = &#63; and projectId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 * @param projectId the project ID
	 * @return the project followed that was removed
	 */
	public ProjectFollowed removeByPublikUserIdAndProjectId(
			String publikUserId, long projectId)
		throws NoSuchProjectFollowedException;

	/**
	 * Returns the number of project followeds where publikUserId = &#63; and projectId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param projectId the project ID
	 * @return the number of matching project followeds
	 */
	public int countByPublikUserIdAndProjectId(
		String publikUserId, long projectId);

	/**
	 * Caches the project followed in the entity cache if it is enabled.
	 *
	 * @param projectFollowed the project followed
	 */
	public void cacheResult(ProjectFollowed projectFollowed);

	/**
	 * Caches the project followeds in the entity cache if it is enabled.
	 *
	 * @param projectFolloweds the project followeds
	 */
	public void cacheResult(java.util.List<ProjectFollowed> projectFolloweds);

	/**
	 * Creates a new project followed with the primary key. Does not add the project followed to the database.
	 *
	 * @param projectFollowedId the primary key for the new project followed
	 * @return the new project followed
	 */
	public ProjectFollowed create(long projectFollowedId);

	/**
	 * Removes the project followed with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectFollowedId the primary key of the project followed
	 * @return the project followed that was removed
	 * @throws NoSuchProjectFollowedException if a project followed with the primary key could not be found
	 */
	public ProjectFollowed remove(long projectFollowedId)
		throws NoSuchProjectFollowedException;

	public ProjectFollowed updateImpl(ProjectFollowed projectFollowed);

	/**
	 * Returns the project followed with the primary key or throws a <code>NoSuchProjectFollowedException</code> if it could not be found.
	 *
	 * @param projectFollowedId the primary key of the project followed
	 * @return the project followed
	 * @throws NoSuchProjectFollowedException if a project followed with the primary key could not be found
	 */
	public ProjectFollowed findByPrimaryKey(long projectFollowedId)
		throws NoSuchProjectFollowedException;

	/**
	 * Returns the project followed with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectFollowedId the primary key of the project followed
	 * @return the project followed, or <code>null</code> if a project followed with the primary key could not be found
	 */
	public ProjectFollowed fetchByPrimaryKey(long projectFollowedId);

	/**
	 * Returns all the project followeds.
	 *
	 * @return the project followeds
	 */
	public java.util.List<ProjectFollowed> findAll();

	/**
	 * Returns a range of all the project followeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectFollowedModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project followeds
	 * @param end the upper bound of the range of project followeds (not inclusive)
	 * @return the range of project followeds
	 */
	public java.util.List<ProjectFollowed> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the project followeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectFollowedModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project followeds
	 * @param end the upper bound of the range of project followeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project followeds
	 */
	public java.util.List<ProjectFollowed> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project followeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectFollowedModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project followeds
	 * @param end the upper bound of the range of project followeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project followeds
	 */
	public java.util.List<ProjectFollowed> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowed>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the project followeds from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of project followeds.
	 *
	 * @return the number of project followeds
	 */
	public int countAll();

}