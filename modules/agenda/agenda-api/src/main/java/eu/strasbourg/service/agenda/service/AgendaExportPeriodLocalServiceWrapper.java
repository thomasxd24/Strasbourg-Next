/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AgendaExportPeriodLocalService}.
 *
 * @author BenjaminBini
 * @see AgendaExportPeriodLocalService
 * @generated
 */
public class AgendaExportPeriodLocalServiceWrapper
	implements AgendaExportPeriodLocalService,
			   ServiceWrapper<AgendaExportPeriodLocalService> {

	public AgendaExportPeriodLocalServiceWrapper() {
		this(null);
	}

	public AgendaExportPeriodLocalServiceWrapper(
		AgendaExportPeriodLocalService agendaExportPeriodLocalService) {

		_agendaExportPeriodLocalService = agendaExportPeriodLocalService;
	}

	/**
	 * Adds the agenda export period to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgendaExportPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agendaExportPeriod the agenda export period
	 * @return the agenda export period that was added
	 */
	@Override
	public eu.strasbourg.service.agenda.model.AgendaExportPeriod
		addAgendaExportPeriod(
			eu.strasbourg.service.agenda.model.AgendaExportPeriod
				agendaExportPeriod) {

		return _agendaExportPeriodLocalService.addAgendaExportPeriod(
			agendaExportPeriod);
	}

	/**
	 * Créé un nouvel object AgendaExportPeriod, non ajoutée à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.agenda.model.AgendaExportPeriod
			createAgendaExportPeriod()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agendaExportPeriodLocalService.createAgendaExportPeriod();
	}

	/**
	 * Creates a new agenda export period with the primary key. Does not add the agenda export period to the database.
	 *
	 * @param agendaExportPeriodId the primary key for the new agenda export period
	 * @return the new agenda export period
	 */
	@Override
	public eu.strasbourg.service.agenda.model.AgendaExportPeriod
		createAgendaExportPeriod(long agendaExportPeriodId) {

		return _agendaExportPeriodLocalService.createAgendaExportPeriod(
			agendaExportPeriodId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agendaExportPeriodLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the agenda export period from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgendaExportPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agendaExportPeriod the agenda export period
	 * @return the agenda export period that was removed
	 */
	@Override
	public eu.strasbourg.service.agenda.model.AgendaExportPeriod
		deleteAgendaExportPeriod(
			eu.strasbourg.service.agenda.model.AgendaExportPeriod
				agendaExportPeriod) {

		return _agendaExportPeriodLocalService.deleteAgendaExportPeriod(
			agendaExportPeriod);
	}

	/**
	 * Deletes the agenda export period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgendaExportPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agendaExportPeriodId the primary key of the agenda export period
	 * @return the agenda export period that was removed
	 * @throws PortalException if a agenda export period with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.agenda.model.AgendaExportPeriod
			deleteAgendaExportPeriod(long agendaExportPeriodId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agendaExportPeriodLocalService.deleteAgendaExportPeriod(
			agendaExportPeriodId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agendaExportPeriodLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _agendaExportPeriodLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _agendaExportPeriodLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _agendaExportPeriodLocalService.dynamicQuery();
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

		return _agendaExportPeriodLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.AgendaExportPeriodModelImpl</code>.
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

		return _agendaExportPeriodLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.AgendaExportPeriodModelImpl</code>.
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

		return _agendaExportPeriodLocalService.dynamicQuery(
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

		return _agendaExportPeriodLocalService.dynamicQueryCount(dynamicQuery);
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

		return _agendaExportPeriodLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.agenda.model.AgendaExportPeriod
		fetchAgendaExportPeriod(long agendaExportPeriodId) {

		return _agendaExportPeriodLocalService.fetchAgendaExportPeriod(
			agendaExportPeriodId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _agendaExportPeriodLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the agenda export period with the primary key.
	 *
	 * @param agendaExportPeriodId the primary key of the agenda export period
	 * @return the agenda export period
	 * @throws PortalException if a agenda export period with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.agenda.model.AgendaExportPeriod
			getAgendaExportPeriod(long agendaExportPeriodId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agendaExportPeriodLocalService.getAgendaExportPeriod(
			agendaExportPeriodId);
	}

	/**
	 * Returns a range of all the agenda export periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.AgendaExportPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agenda export periods
	 * @param end the upper bound of the range of agenda export periods (not inclusive)
	 * @return the range of agenda export periods
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.AgendaExportPeriod>
		getAgendaExportPeriods(int start, int end) {

		return _agendaExportPeriodLocalService.getAgendaExportPeriods(
			start, end);
	}

	/**
	 * Returns the number of agenda export periods.
	 *
	 * @return the number of agenda export periods
	 */
	@Override
	public int getAgendaExportPeriodsCount() {
		return _agendaExportPeriodLocalService.getAgendaExportPeriodsCount();
	}

	/**
	 * Retourne les périodes d'un événement
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.AgendaExportPeriod>
		getByAgendaExportId(long eventId) {

		return _agendaExportPeriodLocalService.getByAgendaExportId(eventId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _agendaExportPeriodLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agendaExportPeriodLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agendaExportPeriodLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the agenda export period in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgendaExportPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agendaExportPeriod the agenda export period
	 * @return the agenda export period that was updated
	 */
	@Override
	public eu.strasbourg.service.agenda.model.AgendaExportPeriod
		updateAgendaExportPeriod(
			eu.strasbourg.service.agenda.model.AgendaExportPeriod
				agendaExportPeriod) {

		return _agendaExportPeriodLocalService.updateAgendaExportPeriod(
			agendaExportPeriod);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _agendaExportPeriodLocalService.getBasePersistence();
	}

	@Override
	public AgendaExportPeriodLocalService getWrappedService() {
		return _agendaExportPeriodLocalService;
	}

	@Override
	public void setWrappedService(
		AgendaExportPeriodLocalService agendaExportPeriodLocalService) {

		_agendaExportPeriodLocalService = agendaExportPeriodLocalService;
	}

	private AgendaExportPeriodLocalService _agendaExportPeriodLocalService;

}