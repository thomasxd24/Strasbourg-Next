/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.comment.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.comment.exception.NoSuchCommentException;
import eu.strasbourg.service.comment.model.Comment;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Romain Vergnais
 * @see CommentUtil
 * @generated
 */
@ProviderType
public interface CommentPersistence extends BasePersistence<Comment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommentUtil} to access the comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the comments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByUuid(String uuid);

	/**
	 * Returns a range of all the comments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public java.util.List<Comment> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the comments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the last comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the comments before and after the current comment in the ordered set where uuid = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment[] findByUuid_PrevAndNext(
			long commentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of comments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching comments
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the comment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCommentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByUUID_G(String uuid, long groupId)
		throws NoSuchCommentException;

	/**
	 * Returns the comment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the comment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the comment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the comment that was removed
	 */
	public Comment removeByUUID_G(String uuid, long groupId)
		throws NoSuchCommentException;

	/**
	 * Returns the number of comments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching comments
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the comments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the comments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public java.util.List<Comment> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the comments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the last comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the comments before and after the current comment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment[] findByUuid_C_PrevAndNext(
			long commentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of comments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching comments
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the comments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByGroupId(long groupId);

	/**
	 * Returns a range of all the comments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public java.util.List<Comment> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the comments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the last comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the comments before and after the current comment in the ordered set where groupId = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment[] findByGroupId_PrevAndNext(
			long commentId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of comments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching comments
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the comments where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByPublikId(String publikId);

	/**
	 * Returns a range of all the comments where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public java.util.List<Comment> findByPublikId(
		String publikId, int start, int end);

	/**
	 * Returns an ordered range of all the comments where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByPublikId(
		String publikId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comments where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByPublikId(
		String publikId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByPublikId_First(
			String publikId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByPublikId_First(
		String publikId,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the last comment in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByPublikId_Last(
			String publikId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByPublikId_Last(
		String publikId,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the comments before and after the current comment in the ordered set where publikId = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment[] findByPublikId_PrevAndNext(
			long commentId, String publikId,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where publikId = &#63; from the database.
	 *
	 * @param publikId the publik ID
	 */
	public void removeByPublikId(String publikId);

	/**
	 * Returns the number of comments where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the number of matching comments
	 */
	public int countByPublikId(String publikId);

	/**
	 * Returns all the comments where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByAssetEntryId(
		long assetEntryId, int status);

	/**
	 * Returns a range of all the comments where assetEntryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public java.util.List<Comment> findByAssetEntryId(
		long assetEntryId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the comments where assetEntryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByAssetEntryId(
		long assetEntryId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comments where assetEntryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByAssetEntryId(
		long assetEntryId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment in the ordered set where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByAssetEntryId_First(
			long assetEntryId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByAssetEntryId_First(
		long assetEntryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the last comment in the ordered set where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByAssetEntryId_Last(
			long assetEntryId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByAssetEntryId_Last(
		long assetEntryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the comments before and after the current comment in the ordered set where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment[] findByAssetEntryId_PrevAndNext(
			long commentId, long assetEntryId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where assetEntryId = &#63; and status = &#63; from the database.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 */
	public void removeByAssetEntryId(long assetEntryId, int status);

	/**
	 * Returns the number of comments where assetEntryId = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param status the status
	 * @return the number of matching comments
	 */
	public int countByAssetEntryId(long assetEntryId, int status);

	/**
	 * Returns all the comments where assetEntryId = &#63; and level = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param level the level
	 * @param status the status
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByAssetEntryIdAndLevel(
		long assetEntryId, int level, int status);

	/**
	 * Returns a range of all the comments where assetEntryId = &#63; and level = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param assetEntryId the asset entry ID
	 * @param level the level
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public java.util.List<Comment> findByAssetEntryIdAndLevel(
		long assetEntryId, int level, int status, int start, int end);

	/**
	 * Returns an ordered range of all the comments where assetEntryId = &#63; and level = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param assetEntryId the asset entry ID
	 * @param level the level
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByAssetEntryIdAndLevel(
		long assetEntryId, int level, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comments where assetEntryId = &#63; and level = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param assetEntryId the asset entry ID
	 * @param level the level
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByAssetEntryIdAndLevel(
		long assetEntryId, int level, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment in the ordered set where assetEntryId = &#63; and level = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param level the level
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByAssetEntryIdAndLevel_First(
			long assetEntryId, int level, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where assetEntryId = &#63; and level = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param level the level
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByAssetEntryIdAndLevel_First(
		long assetEntryId, int level, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the last comment in the ordered set where assetEntryId = &#63; and level = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param level the level
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByAssetEntryIdAndLevel_Last(
			long assetEntryId, int level, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where assetEntryId = &#63; and level = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param level the level
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByAssetEntryIdAndLevel_Last(
		long assetEntryId, int level, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the comments before and after the current comment in the ordered set where assetEntryId = &#63; and level = &#63; and status = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param assetEntryId the asset entry ID
	 * @param level the level
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment[] findByAssetEntryIdAndLevel_PrevAndNext(
			long commentId, long assetEntryId, int level, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where assetEntryId = &#63; and level = &#63; and status = &#63; from the database.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param level the level
	 * @param status the status
	 */
	public void removeByAssetEntryIdAndLevel(
		long assetEntryId, int level, int status);

	/**
	 * Returns the number of comments where assetEntryId = &#63; and level = &#63; and status = &#63;.
	 *
	 * @param assetEntryId the asset entry ID
	 * @param level the level
	 * @param status the status
	 * @return the number of matching comments
	 */
	public int countByAssetEntryIdAndLevel(
		long assetEntryId, int level, int status);

	/**
	 * Returns all the comments where parentCommentId = &#63; and status = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param status the status
	 * @return the matching comments
	 */
	public java.util.List<Comment> findByParentCommentId(
		long parentCommentId, int status);

	/**
	 * Returns a range of all the comments where parentCommentId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param parentCommentId the parent comment ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of matching comments
	 */
	public java.util.List<Comment> findByParentCommentId(
		long parentCommentId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the comments where parentCommentId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param parentCommentId the parent comment ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByParentCommentId(
		long parentCommentId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comments where parentCommentId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param parentCommentId the parent comment ID
	 * @param status the status
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching comments
	 */
	public java.util.List<Comment> findByParentCommentId(
		long parentCommentId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first comment in the ordered set where parentCommentId = &#63; and status = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByParentCommentId_First(
			long parentCommentId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the first comment in the ordered set where parentCommentId = &#63; and status = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByParentCommentId_First(
		long parentCommentId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the last comment in the ordered set where parentCommentId = &#63; and status = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment
	 * @throws NoSuchCommentException if a matching comment could not be found
	 */
	public Comment findByParentCommentId_Last(
			long parentCommentId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Returns the last comment in the ordered set where parentCommentId = &#63; and status = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public Comment fetchByParentCommentId_Last(
		long parentCommentId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns the comments before and after the current comment in the ordered set where parentCommentId = &#63; and status = &#63;.
	 *
	 * @param commentId the primary key of the current comment
	 * @param parentCommentId the parent comment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment[] findByParentCommentId_PrevAndNext(
			long commentId, long parentCommentId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Comment>
				orderByComparator)
		throws NoSuchCommentException;

	/**
	 * Removes all the comments where parentCommentId = &#63; and status = &#63; from the database.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param status the status
	 */
	public void removeByParentCommentId(long parentCommentId, int status);

	/**
	 * Returns the number of comments where parentCommentId = &#63; and status = &#63;.
	 *
	 * @param parentCommentId the parent comment ID
	 * @param status the status
	 * @return the number of matching comments
	 */
	public int countByParentCommentId(long parentCommentId, int status);

	/**
	 * Caches the comment in the entity cache if it is enabled.
	 *
	 * @param comment the comment
	 */
	public void cacheResult(Comment comment);

	/**
	 * Caches the comments in the entity cache if it is enabled.
	 *
	 * @param comments the comments
	 */
	public void cacheResult(java.util.List<Comment> comments);

	/**
	 * Creates a new comment with the primary key. Does not add the comment to the database.
	 *
	 * @param commentId the primary key for the new comment
	 * @return the new comment
	 */
	public Comment create(long commentId);

	/**
	 * Removes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment that was removed
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment remove(long commentId) throws NoSuchCommentException;

	public Comment updateImpl(Comment comment);

	/**
	 * Returns the comment with the primary key or throws a <code>NoSuchCommentException</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment
	 * @throws NoSuchCommentException if a comment with the primary key could not be found
	 */
	public Comment findByPrimaryKey(long commentId)
		throws NoSuchCommentException;

	/**
	 * Returns the comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment, or <code>null</code> if a comment with the primary key could not be found
	 */
	public Comment fetchByPrimaryKey(long commentId);

	/**
	 * Returns all the comments.
	 *
	 * @return the comments
	 */
	public java.util.List<Comment> findAll();

	/**
	 * Returns a range of all the comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of comments
	 */
	public java.util.List<Comment> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comments
	 */
	public java.util.List<Comment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator);

	/**
	 * Returns an ordered range of all the comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comments
	 */
	public java.util.List<Comment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Comment>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the comments from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of comments.
	 *
	 * @return the number of comments
	 */
	public int countAll();

}