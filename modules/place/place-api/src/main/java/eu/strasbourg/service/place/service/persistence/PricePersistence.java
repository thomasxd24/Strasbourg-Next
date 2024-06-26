/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.place.exception.NoSuchPriceException;
import eu.strasbourg.service.place.model.Price;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the price service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see PriceUtil
 * @generated
 */
@ProviderType
public interface PricePersistence extends BasePersistence<Price> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PriceUtil} to access the price persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the prices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching prices
	 */
	public java.util.List<Price> findByUuid(String uuid);

	/**
	 * Returns a range of all the prices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @return the range of matching prices
	 */
	public java.util.List<Price> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the prices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching prices
	 */
	public java.util.List<Price> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Price>
			orderByComparator);

	/**
	 * Returns an ordered range of all the prices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching prices
	 */
	public java.util.List<Price> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Price>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first price in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching price
	 * @throws NoSuchPriceException if a matching price could not be found
	 */
	public Price findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Price>
				orderByComparator)
		throws NoSuchPriceException;

	/**
	 * Returns the first price in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching price, or <code>null</code> if a matching price could not be found
	 */
	public Price fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Price>
			orderByComparator);

	/**
	 * Returns the last price in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching price
	 * @throws NoSuchPriceException if a matching price could not be found
	 */
	public Price findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Price>
				orderByComparator)
		throws NoSuchPriceException;

	/**
	 * Returns the last price in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching price, or <code>null</code> if a matching price could not be found
	 */
	public Price fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Price>
			orderByComparator);

	/**
	 * Returns the prices before and after the current price in the ordered set where uuid = &#63;.
	 *
	 * @param priceId the primary key of the current price
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next price
	 * @throws NoSuchPriceException if a price with the primary key could not be found
	 */
	public Price[] findByUuid_PrevAndNext(
			long priceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Price>
				orderByComparator)
		throws NoSuchPriceException;

	/**
	 * Removes all the prices where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of prices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching prices
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the price in the entity cache if it is enabled.
	 *
	 * @param price the price
	 */
	public void cacheResult(Price price);

	/**
	 * Caches the prices in the entity cache if it is enabled.
	 *
	 * @param prices the prices
	 */
	public void cacheResult(java.util.List<Price> prices);

	/**
	 * Creates a new price with the primary key. Does not add the price to the database.
	 *
	 * @param priceId the primary key for the new price
	 * @return the new price
	 */
	public Price create(long priceId);

	/**
	 * Removes the price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param priceId the primary key of the price
	 * @return the price that was removed
	 * @throws NoSuchPriceException if a price with the primary key could not be found
	 */
	public Price remove(long priceId) throws NoSuchPriceException;

	public Price updateImpl(Price price);

	/**
	 * Returns the price with the primary key or throws a <code>NoSuchPriceException</code> if it could not be found.
	 *
	 * @param priceId the primary key of the price
	 * @return the price
	 * @throws NoSuchPriceException if a price with the primary key could not be found
	 */
	public Price findByPrimaryKey(long priceId) throws NoSuchPriceException;

	/**
	 * Returns the price with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param priceId the primary key of the price
	 * @return the price, or <code>null</code> if a price with the primary key could not be found
	 */
	public Price fetchByPrimaryKey(long priceId);

	/**
	 * Returns all the prices.
	 *
	 * @return the prices
	 */
	public java.util.List<Price> findAll();

	/**
	 * Returns a range of all the prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @return the range of prices
	 */
	public java.util.List<Price> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of prices
	 */
	public java.util.List<Price> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Price>
			orderByComparator);

	/**
	 * Returns an ordered range of all the prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prices
	 * @param end the upper bound of the range of prices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of prices
	 */
	public java.util.List<Price> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Price>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the prices from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of prices.
	 *
	 * @return the number of prices
	 */
	public int countAll();

}