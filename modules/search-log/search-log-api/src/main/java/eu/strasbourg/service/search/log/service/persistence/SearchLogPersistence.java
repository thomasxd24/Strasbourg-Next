/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.search.log.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.search.log.exception.NoSuchSearchLogException;
import eu.strasbourg.service.search.log.model.SearchLog;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the search log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see SearchLogUtil
 * @generated
 */
@ProviderType
public interface SearchLogPersistence extends BasePersistence<SearchLog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SearchLogUtil} to access the search log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the search log in the entity cache if it is enabled.
	 *
	 * @param searchLog the search log
	 */
	public void cacheResult(SearchLog searchLog);

	/**
	 * Caches the search logs in the entity cache if it is enabled.
	 *
	 * @param searchLogs the search logs
	 */
	public void cacheResult(java.util.List<SearchLog> searchLogs);

	/**
	 * Creates a new search log with the primary key. Does not add the search log to the database.
	 *
	 * @param searchLogId the primary key for the new search log
	 * @return the new search log
	 */
	public SearchLog create(long searchLogId);

	/**
	 * Removes the search log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchLogId the primary key of the search log
	 * @return the search log that was removed
	 * @throws NoSuchSearchLogException if a search log with the primary key could not be found
	 */
	public SearchLog remove(long searchLogId) throws NoSuchSearchLogException;

	public SearchLog updateImpl(SearchLog searchLog);

	/**
	 * Returns the search log with the primary key or throws a <code>NoSuchSearchLogException</code> if it could not be found.
	 *
	 * @param searchLogId the primary key of the search log
	 * @return the search log
	 * @throws NoSuchSearchLogException if a search log with the primary key could not be found
	 */
	public SearchLog findByPrimaryKey(long searchLogId)
		throws NoSuchSearchLogException;

	/**
	 * Returns the search log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param searchLogId the primary key of the search log
	 * @return the search log, or <code>null</code> if a search log with the primary key could not be found
	 */
	public SearchLog fetchByPrimaryKey(long searchLogId);

	/**
	 * Returns all the search logs.
	 *
	 * @return the search logs
	 */
	public java.util.List<SearchLog> findAll();

	/**
	 * Returns a range of all the search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of search logs
	 * @param end the upper bound of the range of search logs (not inclusive)
	 * @return the range of search logs
	 */
	public java.util.List<SearchLog> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of search logs
	 * @param end the upper bound of the range of search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of search logs
	 */
	public java.util.List<SearchLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SearchLog>
			orderByComparator);

	/**
	 * Returns an ordered range of all the search logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SearchLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of search logs
	 * @param end the upper bound of the range of search logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of search logs
	 */
	public java.util.List<SearchLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SearchLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the search logs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of search logs.
	 *
	 * @return the number of search logs
	 */
	public int countAll();

}