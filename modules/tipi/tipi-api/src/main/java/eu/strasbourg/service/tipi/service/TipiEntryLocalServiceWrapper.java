/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.tipi.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link TipiEntryLocalService}.
 *
 * @author Angelique Zunino Champougny
 * @see TipiEntryLocalService
 * @generated
 */
public class TipiEntryLocalServiceWrapper
	implements ServiceWrapper<TipiEntryLocalService>, TipiEntryLocalService {

	public TipiEntryLocalServiceWrapper() {
		this(null);
	}

	public TipiEntryLocalServiceWrapper(
		TipiEntryLocalService tipiEntryLocalService) {

		_tipiEntryLocalService = tipiEntryLocalService;
	}

	@Override
	public eu.strasbourg.service.tipi.model.TipiEntry addPayment(
		java.util.Date date, String type, String status, String price) {

		return _tipiEntryLocalService.addPayment(date, type, status, price);
	}

	/**
	 * Adds the tipi entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipiEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipiEntry the tipi entry
	 * @return the tipi entry that was added
	 */
	@Override
	public eu.strasbourg.service.tipi.model.TipiEntry addTipiEntry(
		eu.strasbourg.service.tipi.model.TipiEntry tipiEntry) {

		return _tipiEntryLocalService.addTipiEntry(tipiEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipiEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new tipi entry with the primary key. Does not add the tipi entry to the database.
	 *
	 * @param id the primary key for the new tipi entry
	 * @return the new tipi entry
	 */
	@Override
	public eu.strasbourg.service.tipi.model.TipiEntry createTipiEntry(long id) {
		return _tipiEntryLocalService.createTipiEntry(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipiEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the tipi entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipiEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the tipi entry
	 * @return the tipi entry that was removed
	 * @throws PortalException if a tipi entry with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.tipi.model.TipiEntry deleteTipiEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipiEntryLocalService.deleteTipiEntry(id);
	}

	/**
	 * Deletes the tipi entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipiEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipiEntry the tipi entry
	 * @return the tipi entry that was removed
	 */
	@Override
	public eu.strasbourg.service.tipi.model.TipiEntry deleteTipiEntry(
		eu.strasbourg.service.tipi.model.TipiEntry tipiEntry) {

		return _tipiEntryLocalService.deleteTipiEntry(tipiEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _tipiEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _tipiEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipiEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tipiEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.tipi.model.impl.TipiEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _tipiEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.tipi.model.impl.TipiEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _tipiEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tipiEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _tipiEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.tipi.model.TipiEntry fetchTipiEntry(long id) {
		return _tipiEntryLocalService.fetchTipiEntry(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tipiEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<eu.strasbourg.service.tipi.model.TipiEntry> getByDate(
		java.util.Date date) {

		return _tipiEntryLocalService.getByDate(date);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tipiEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tipiEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipiEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the tipi entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.tipi.model.impl.TipiEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipi entries
	 * @param end the upper bound of the range of tipi entries (not inclusive)
	 * @return the range of tipi entries
	 */
	@Override
	public java.util.List<eu.strasbourg.service.tipi.model.TipiEntry>
		getTipiEntries(int start, int end) {

		return _tipiEntryLocalService.getTipiEntries(start, end);
	}

	/**
	 * Returns the number of tipi entries.
	 *
	 * @return the number of tipi entries
	 */
	@Override
	public int getTipiEntriesCount() {
		return _tipiEntryLocalService.getTipiEntriesCount();
	}

	/**
	 * Returns the tipi entry with the primary key.
	 *
	 * @param id the primary key of the tipi entry
	 * @return the tipi entry
	 * @throws PortalException if a tipi entry with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.tipi.model.TipiEntry getTipiEntry(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tipiEntryLocalService.getTipiEntry(id);
	}

	/**
	 * Updates the tipi entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TipiEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tipiEntry the tipi entry
	 * @return the tipi entry that was updated
	 */
	@Override
	public eu.strasbourg.service.tipi.model.TipiEntry updateTipiEntry(
		eu.strasbourg.service.tipi.model.TipiEntry tipiEntry) {

		return _tipiEntryLocalService.updateTipiEntry(tipiEntry);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _tipiEntryLocalService.getBasePersistence();
	}

	@Override
	public TipiEntryLocalService getWrappedService() {
		return _tipiEntryLocalService;
	}

	@Override
	public void setWrappedService(TipiEntryLocalService tipiEntryLocalService) {
		_tipiEntryLocalService = tipiEntryLocalService;
	}

	private TipiEntryLocalService _tipiEntryLocalService;

}