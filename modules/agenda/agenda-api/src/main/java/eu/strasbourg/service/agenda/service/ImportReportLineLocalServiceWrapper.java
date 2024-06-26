/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ImportReportLineLocalService}.
 *
 * @author BenjaminBini
 * @see ImportReportLineLocalService
 * @generated
 */
public class ImportReportLineLocalServiceWrapper
	implements ImportReportLineLocalService,
			   ServiceWrapper<ImportReportLineLocalService> {

	public ImportReportLineLocalServiceWrapper() {
		this(null);
	}

	public ImportReportLineLocalServiceWrapper(
		ImportReportLineLocalService importReportLineLocalService) {

		_importReportLineLocalService = importReportLineLocalService;
	}

	/**
	 * Adds the import report line to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportReportLineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importReportLine the import report line
	 * @return the import report line that was added
	 */
	@Override
	public eu.strasbourg.service.agenda.model.ImportReportLine
		addImportReportLine(
			eu.strasbourg.service.agenda.model.ImportReportLine
				importReportLine) {

		return _importReportLineLocalService.addImportReportLine(
			importReportLine);
	}

	/**
	 * Crée une ligne de rapport d'import avec une PK, non ajouté à la base de
	 * donnée
	 */
	@Override
	public eu.strasbourg.service.agenda.model.ImportReportLine
			createImportReportLine()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importReportLineLocalService.createImportReportLine();
	}

	/**
	 * Creates a new import report line with the primary key. Does not add the import report line to the database.
	 *
	 * @param lineId the primary key for the new import report line
	 * @return the new import report line
	 */
	@Override
	public eu.strasbourg.service.agenda.model.ImportReportLine
		createImportReportLine(long lineId) {

		return _importReportLineLocalService.createImportReportLine(lineId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importReportLineLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the import report line from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportReportLineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importReportLine the import report line
	 * @return the import report line that was removed
	 */
	@Override
	public eu.strasbourg.service.agenda.model.ImportReportLine
		deleteImportReportLine(
			eu.strasbourg.service.agenda.model.ImportReportLine
				importReportLine) {

		return _importReportLineLocalService.deleteImportReportLine(
			importReportLine);
	}

	/**
	 * Deletes the import report line with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportReportLineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lineId the primary key of the import report line
	 * @return the import report line that was removed
	 * @throws PortalException if a import report line with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.agenda.model.ImportReportLine
			deleteImportReportLine(long lineId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importReportLineLocalService.deleteImportReportLine(lineId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importReportLineLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _importReportLineLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _importReportLineLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _importReportLineLocalService.dynamicQuery();
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

		return _importReportLineLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.ImportReportLineModelImpl</code>.
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

		return _importReportLineLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.ImportReportLineModelImpl</code>.
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

		return _importReportLineLocalService.dynamicQuery(
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

		return _importReportLineLocalService.dynamicQueryCount(dynamicQuery);
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

		return _importReportLineLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.agenda.model.ImportReportLine
		fetchImportReportLine(long lineId) {

		return _importReportLineLocalService.fetchImportReportLine(lineId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _importReportLineLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the import report line with the primary key.
	 *
	 * @param lineId the primary key of the import report line
	 * @return the import report line
	 * @throws PortalException if a import report line with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.agenda.model.ImportReportLine
			getImportReportLine(long lineId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importReportLineLocalService.getImportReportLine(lineId);
	}

	/**
	 * Returns a range of all the import report lines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.ImportReportLineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import report lines
	 * @param end the upper bound of the range of import report lines (not inclusive)
	 * @return the range of import report lines
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.ImportReportLine>
		getImportReportLines(int start, int end) {

		return _importReportLineLocalService.getImportReportLines(start, end);
	}

	/**
	 * Returns the number of import report lines.
	 *
	 * @return the number of import report lines
	 */
	@Override
	public int getImportReportLinesCount() {
		return _importReportLineLocalService.getImportReportLinesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _importReportLineLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _importReportLineLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importReportLineLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the import report line in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportReportLineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importReportLine the import report line
	 * @return the import report line that was updated
	 */
	@Override
	public eu.strasbourg.service.agenda.model.ImportReportLine
		updateImportReportLine(
			eu.strasbourg.service.agenda.model.ImportReportLine
				importReportLine) {

		return _importReportLineLocalService.updateImportReportLine(
			importReportLine);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _importReportLineLocalService.getBasePersistence();
	}

	@Override
	public ImportReportLineLocalService getWrappedService() {
		return _importReportLineLocalService;
	}

	@Override
	public void setWrappedService(
		ImportReportLineLocalService importReportLineLocalService) {

		_importReportLineLocalService = importReportLineLocalService;
	}

	private ImportReportLineLocalService _importReportLineLocalService;

}