/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link DeliberationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DeliberationLocalService
 * @generated
 */
public class DeliberationLocalServiceWrapper
	implements DeliberationLocalService,
			   ServiceWrapper<DeliberationLocalService> {

	public DeliberationLocalServiceWrapper() {
		this(null);
	}

	public DeliberationLocalServiceWrapper(
		DeliberationLocalService deliberationLocalService) {

		_deliberationLocalService = deliberationLocalService;
	}

	/**
	 * Adds the deliberation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeliberationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deliberation the deliberation
	 * @return the deliberation that was added
	 */
	@Override
	public eu.strasbourg.service.council.model.Deliberation addDeliberation(
		eu.strasbourg.service.council.model.Deliberation deliberation) {

		return _deliberationLocalService.addDeliberation(deliberation);
	}

	/**
	 * Creates a new deliberation with the primary key. Does not add the deliberation to the database.
	 *
	 * @param deliberationId the primary key for the new deliberation
	 * @return the new deliberation
	 */
	@Override
	public eu.strasbourg.service.council.model.Deliberation createDeliberation(
		long deliberationId) {

		return _deliberationLocalService.createDeliberation(deliberationId);
	}

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.council.model.Deliberation createDeliberation(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliberationLocalService.createDeliberation(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliberationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the deliberation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeliberationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deliberation the deliberation
	 * @return the deliberation that was removed
	 */
	@Override
	public eu.strasbourg.service.council.model.Deliberation deleteDeliberation(
		eu.strasbourg.service.council.model.Deliberation deliberation) {

		return _deliberationLocalService.deleteDeliberation(deliberation);
	}

	/**
	 * Deletes the deliberation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeliberationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deliberationId the primary key of the deliberation
	 * @return the deliberation that was removed
	 * @throws PortalException if a deliberation with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.council.model.Deliberation deleteDeliberation(
			long deliberationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliberationLocalService.deleteDeliberation(deliberationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliberationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _deliberationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _deliberationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _deliberationLocalService.dynamicQuery();
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

		return _deliberationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.DeliberationModelImpl</code>.
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

		return _deliberationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.DeliberationModelImpl</code>.
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

		return _deliberationLocalService.dynamicQuery(
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

		return _deliberationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _deliberationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.council.model.Deliberation fetchDeliberation(
		long deliberationId) {

		return _deliberationLocalService.fetchDeliberation(deliberationId);
	}

	/**
	 * Returns the deliberation matching the UUID and group.
	 *
	 * @param uuid the deliberation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	@Override
	public eu.strasbourg.service.council.model.Deliberation
		fetchDeliberationByUuidAndGroupId(String uuid, long groupId) {

		return _deliberationLocalService.fetchDeliberationByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Recherche par ID de CouncilSession
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.Deliberation>
		findByCouncilSessionId(long councilSessionId) {

		return _deliberationLocalService.findByCouncilSessionId(
			councilSessionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _deliberationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the deliberation with the primary key.
	 *
	 * @param deliberationId the primary key of the deliberation
	 * @return the deliberation
	 * @throws PortalException if a deliberation with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.council.model.Deliberation getDeliberation(
			long deliberationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliberationLocalService.getDeliberation(deliberationId);
	}

	/**
	 * Returns the deliberation matching the UUID and group.
	 *
	 * @param uuid the deliberation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching deliberation
	 * @throws PortalException if a matching deliberation could not be found
	 */
	@Override
	public eu.strasbourg.service.council.model.Deliberation
			getDeliberationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliberationLocalService.getDeliberationByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the deliberations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @return the range of deliberations
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.Deliberation>
		getDeliberations(int start, int end) {

		return _deliberationLocalService.getDeliberations(start, end);
	}

	/**
	 * Returns all the deliberations matching the UUID and company.
	 *
	 * @param uuid the UUID of the deliberations
	 * @param companyId the primary key of the company
	 * @return the matching deliberations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.Deliberation>
		getDeliberationsByUuidAndCompanyId(String uuid, long companyId) {

		return _deliberationLocalService.getDeliberationsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of deliberations matching the UUID and company.
	 *
	 * @param uuid the UUID of the deliberations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching deliberations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.Deliberation>
		getDeliberationsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.council.model.Deliberation>
					orderByComparator) {

		return _deliberationLocalService.getDeliberationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of deliberations.
	 *
	 * @return the number of deliberations
	 */
	@Override
	public int getDeliberationsCount() {
		return _deliberationLocalService.getDeliberationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _deliberationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _deliberationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _deliberationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliberationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Import des délibérations à partir du fichier csv
	 * Création ou mise à jour ou suppression en base de données
	 */
	@Override
	public String importData(
			java.util.List<java.util.Map<String, String>> recordsMapList,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			long councilSessionId,
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliberationLocalService.importData(
			recordsMapList, serviceContext, councilSessionId, themeDisplay);
	}

	/**
	 * Supprime une entité
	 */
	@Override
	public eu.strasbourg.service.council.model.Deliberation removeDeliberation(
			long deliberationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliberationLocalService.removeDeliberation(deliberationId);
	}

	/**
	 * Updates the deliberation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DeliberationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param deliberation the deliberation
	 * @return the deliberation that was updated
	 */
	@Override
	public eu.strasbourg.service.council.model.Deliberation updateDeliberation(
		eu.strasbourg.service.council.model.Deliberation deliberation) {

		return _deliberationLocalService.updateDeliberation(deliberation);
	}

	/**
	 * Met à jour une entité et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.council.model.Deliberation updateDeliberation(
			eu.strasbourg.service.council.model.Deliberation deliberation,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliberationLocalService.updateDeliberation(deliberation, sc);
	}

	/**
	 * Met à jour le statut de l'entité "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(
			eu.strasbourg.service.council.model.Deliberation deliberation,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		_deliberationLocalService.updateStatus(deliberation, status);
	}

	/**
	 * Met à jour le statut de l'entité par le framework workflow
	 */
	@Override
	public eu.strasbourg.service.council.model.Deliberation updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _deliberationLocalService.updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _deliberationLocalService.getBasePersistence();
	}

	@Override
	public DeliberationLocalService getWrappedService() {
		return _deliberationLocalService;
	}

	@Override
	public void setWrappedService(
		DeliberationLocalService deliberationLocalService) {

		_deliberationLocalService = deliberationLocalService;
	}

	private DeliberationLocalService _deliberationLocalService;

}