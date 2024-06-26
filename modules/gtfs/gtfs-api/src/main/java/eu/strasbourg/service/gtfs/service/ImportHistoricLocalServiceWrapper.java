/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ImportHistoricLocalService}.
 *
 * @author Cedric Henry
 * @see ImportHistoricLocalService
 * @generated
 */
public class ImportHistoricLocalServiceWrapper
	implements ImportHistoricLocalService,
			   ServiceWrapper<ImportHistoricLocalService> {

	public ImportHistoricLocalServiceWrapper() {
		this(null);
	}

	public ImportHistoricLocalServiceWrapper(
		ImportHistoricLocalService importHistoricLocalService) {

		_importHistoricLocalService = importHistoricLocalService;
	}

	/**
	 * Adds the import historic to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importHistoric the import historic
	 * @return the import historic that was added
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric addImportHistoric(
		eu.strasbourg.service.gtfs.model.ImportHistoric importHistoric) {

		return _importHistoricLocalService.addImportHistoric(importHistoric);
	}

	/**
	 * Creates a new import historic with the primary key. Does not add the import historic to the database.
	 *
	 * @param importHistoricId the primary key for the new import historic
	 * @return the new import historic
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric createImportHistoric(
		long importHistoricId) {

		return _importHistoricLocalService.createImportHistoric(
			importHistoricId);
	}

	/**
	 * Crée une entree d'import vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric createImportHistoric(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importHistoricLocalService.createImportHistoric(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importHistoricLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the import historic from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importHistoric the import historic
	 * @return the import historic that was removed
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric deleteImportHistoric(
		eu.strasbourg.service.gtfs.model.ImportHistoric importHistoric) {

		return _importHistoricLocalService.deleteImportHistoric(importHistoric);
	}

	/**
	 * Deletes the import historic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importHistoricId the primary key of the import historic
	 * @return the import historic that was removed
	 * @throws PortalException if a import historic with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric deleteImportHistoric(
			long importHistoricId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importHistoricLocalService.deleteImportHistoric(
			importHistoricId);
	}

	/**
	 * Suppression des anciens imports d'historiques
	 */
	@Override
	public int deleteOldImportHistorics() {
		return _importHistoricLocalService.deleteOldImportHistorics();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importHistoricLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Effectue l'import des donnees issues des fichiers GTFS
	 */
	@Override
	public void doImportGTFS(
		com.liferay.portal.kernel.service.ServiceContext sc,
		eu.strasbourg.service.gtfs.model.ImportHistoric importHistoric) {

		_importHistoricLocalService.doImportGTFS(sc, importHistoric);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _importHistoricLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _importHistoricLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _importHistoricLocalService.dynamicQuery();
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

		return _importHistoricLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.ImportHistoricModelImpl</code>.
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

		return _importHistoricLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.ImportHistoricModelImpl</code>.
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

		return _importHistoricLocalService.dynamicQuery(
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

		return _importHistoricLocalService.dynamicQueryCount(dynamicQuery);
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

		return _importHistoricLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric fetchImportHistoric(
		long importHistoricId) {

		return _importHistoricLocalService.fetchImportHistoric(
			importHistoricId);
	}

	/**
	 * Returns the import historic matching the UUID and group.
	 *
	 * @param uuid the import historic's UUID
	 * @param groupId the primary key of the group
	 * @return the matching import historic, or <code>null</code> if a matching import historic could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric
		fetchImportHistoricByUuidAndGroupId(String uuid, long groupId) {

		return _importHistoricLocalService.fetchImportHistoricByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.ImportHistoric>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return _importHistoricLocalService.findByKeyword(
			keyword, groupId, start, end);
	}

	/**
	 * Recherche par mot clés (compte)
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		return _importHistoricLocalService.findByKeywordCount(keyword, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _importHistoricLocalService.getActionableDynamicQuery();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à un projet
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return _importHistoricLocalService.getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne tous les projets d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.ImportHistoric>
		getByGroupId(long groupId) {

		return _importHistoricLocalService.getByGroupId(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _importHistoricLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the import historic with the primary key.
	 *
	 * @param importHistoricId the primary key of the import historic
	 * @return the import historic
	 * @throws PortalException if a import historic with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric getImportHistoric(
			long importHistoricId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importHistoricLocalService.getImportHistoric(importHistoricId);
	}

	/**
	 * Returns the import historic matching the UUID and group.
	 *
	 * @param uuid the import historic's UUID
	 * @param groupId the primary key of the group
	 * @return the matching import historic
	 * @throws PortalException if a matching import historic could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric
			getImportHistoricByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importHistoricLocalService.getImportHistoricByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the import historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @return the range of import historics
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.ImportHistoric>
		getImportHistorics(int start, int end) {

		return _importHistoricLocalService.getImportHistorics(start, end);
	}

	/**
	 * Returns all the import historics matching the UUID and company.
	 *
	 * @param uuid the UUID of the import historics
	 * @param companyId the primary key of the company
	 * @return the matching import historics, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.ImportHistoric>
		getImportHistoricsByUuidAndCompanyId(String uuid, long companyId) {

		return _importHistoricLocalService.getImportHistoricsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of import historics matching the UUID and company.
	 *
	 * @param uuid the UUID of the import historics
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching import historics, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.ImportHistoric>
		getImportHistoricsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.gtfs.model.ImportHistoric>
					orderByComparator) {

		return _importHistoricLocalService.getImportHistoricsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of import historics.
	 *
	 * @return the number of import historics
	 */
	@Override
	public int getImportHistoricsCount() {
		return _importHistoricLocalService.getImportHistoricsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _importHistoricLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Retourne le dernier historique d'import
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric
		getLatestImportHistoric(
			eu.strasbourg.service.gtfs.model.ImportHistoric notCurrent) {

		return _importHistoricLocalService.getLatestImportHistoric(notCurrent);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _importHistoricLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importHistoricLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime l'entree d'import
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric removeImportHistoric(
			long importHistoricId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importHistoricLocalService.removeImportHistoric(
			importHistoricId);
	}

	/**
	 * Updates the import historic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importHistoric the import historic
	 * @return the import historic that was updated
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric updateImportHistoric(
		eu.strasbourg.service.gtfs.model.ImportHistoric importHistoric) {

		return _importHistoricLocalService.updateImportHistoric(importHistoric);
	}

	/**
	 * Met à jour une entree d'import et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric updateImportHistoric(
			eu.strasbourg.service.gtfs.model.ImportHistoric importHistoric,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importHistoricLocalService.updateImportHistoric(
			importHistoric, sc);
	}

	/**
	 * Met à jour le statut de l'entree d'import "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(
			eu.strasbourg.service.gtfs.model.ImportHistoric importHistoric,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		_importHistoricLocalService.updateStatus(importHistoric, status);
	}

	/**
	 * Met à jour le statut de l'entree d'import par le framework workflow
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.ImportHistoric updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _importHistoricLocalService.updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _importHistoricLocalService.getBasePersistence();
	}

	@Override
	public ImportHistoricLocalService getWrappedService() {
		return _importHistoricLocalService;
	}

	@Override
	public void setWrappedService(
		ImportHistoricLocalService importHistoricLocalService) {

		_importHistoricLocalService = importHistoricLocalService;
	}

	private ImportHistoricLocalService _importHistoricLocalService;

}