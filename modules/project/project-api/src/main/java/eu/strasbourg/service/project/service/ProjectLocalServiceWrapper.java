/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProjectLocalService}.
 *
 * @author Cedric Henry
 * @see ProjectLocalService
 * @generated
 */
public class ProjectLocalServiceWrapper
	implements ProjectLocalService, ServiceWrapper<ProjectLocalService> {

	public ProjectLocalServiceWrapper() {
		this(null);
	}

	public ProjectLocalServiceWrapper(ProjectLocalService projectLocalService) {
		_projectLocalService = projectLocalService;
	}

	/**
	 * Adds the project to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param project the project
	 * @return the project that was added
	 */
	@Override
	public eu.strasbourg.service.project.model.Project addProject(
		eu.strasbourg.service.project.model.Project project) {

		return _projectLocalService.addProject(project);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new project with the primary key. Does not add the project to the database.
	 *
	 * @param projectId the primary key for the new project
	 * @return the new project
	 */
	@Override
	public eu.strasbourg.service.project.model.Project createProject(
		long projectId) {

		return _projectLocalService.createProject(projectId);
	}

	/**
	 * Crée un projet vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.project.model.Project createProject(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.createProject(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectId the primary key of the project
	 * @return the project that was removed
	 * @throws PortalException if a project with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.Project deleteProject(
			long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.deleteProject(projectId);
	}

	/**
	 * Deletes the project from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param project the project
	 * @return the project that was removed
	 */
	@Override
	public eu.strasbourg.service.project.model.Project deleteProject(
		eu.strasbourg.service.project.model.Project project) {

		return _projectLocalService.deleteProject(project);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _projectLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _projectLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectLocalService.dynamicQuery();
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

		return _projectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ProjectModelImpl</code>.
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

		return _projectLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ProjectModelImpl</code>.
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

		return _projectLocalService.dynamicQuery(
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

		return _projectLocalService.dynamicQueryCount(dynamicQuery);
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

		return _projectLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.project.model.Project fetchProject(
		long projectId) {

		return _projectLocalService.fetchProject(projectId);
	}

	/**
	 * Returns the project matching the UUID and group.
	 *
	 * @param uuid the project's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project, or <code>null</code> if a matching project could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.Project
		fetchProjectByUuidAndGroupId(String uuid, long groupId) {

		return _projectLocalService.fetchProjectByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par ID de catégorie
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.Project>
		findByCategoryIds(long[] categoryIds) {

		return _projectLocalService.findByCategoryIds(categoryIds);
	}

	/**
	 * Recherche par mot clés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.Project>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return _projectLocalService.findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Recherche par mot clés (compte)
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		return _projectLocalService.findByKeywordCount(keyword, groupId);
	}

	@Override
	public java.util.List<eu.strasbourg.service.project.model.Project>
		findProjectFollowedByProjectId(String publicId) {

		return _projectLocalService.findProjectFollowedByProjectId(publicId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projectLocalService.getActionableDynamicQuery();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à un projet
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return _projectLocalService.getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne tous les projets d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.Project>
		getByGroupId(long groupId) {

		return _projectLocalService.getByGroupId(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _projectLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projectLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the project with the primary key.
	 *
	 * @param projectId the primary key of the project
	 * @return the project
	 * @throws PortalException if a project with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.Project getProject(
			long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.getProject(projectId);
	}

	/**
	 * Returns the project matching the UUID and group.
	 *
	 * @param uuid the project's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project
	 * @throws PortalException if a matching project could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.Project
			getProjectByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.getProjectByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of projects
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.Project>
		getProjects(int start, int end) {

		return _projectLocalService.getProjects(start, end);
	}

	/**
	 * Returns all the projects matching the UUID and company.
	 *
	 * @param uuid the UUID of the projects
	 * @param companyId the primary key of the company
	 * @return the matching projects, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.Project>
		getProjectsByUuidAndCompanyId(String uuid, long companyId) {

		return _projectLocalService.getProjectsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of projects matching the UUID and company.
	 *
	 * @param uuid the UUID of the projects
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching projects, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.Project>
		getProjectsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.project.model.Project>
					orderByComparator) {

		return _projectLocalService.getProjectsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of projects.
	 *
	 * @return the number of projects
	 */
	@Override
	public int getProjectsCount() {
		return _projectLocalService.getProjectsCount();
	}

	/**
	 * Retourne tous les projets publiés d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.Project>
		getPublishedByGroupId(long groupId) {

		return _projectLocalService.getPublishedByGroupId(groupId);
	}

	/**
	 * Supprime un projet
	 */
	@Override
	public eu.strasbourg.service.project.model.Project removeProject(
			long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.removeProject(projectId);
	}

	/**
	 * Updates the project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param project the project
	 * @return the project that was updated
	 */
	@Override
	public eu.strasbourg.service.project.model.Project updateProject(
		eu.strasbourg.service.project.model.Project project) {

		return _projectLocalService.updateProject(project);
	}

	/**
	 * Met à jour un projet et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	@Override
	public eu.strasbourg.service.project.model.Project updateProject(
			eu.strasbourg.service.project.model.Project project,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.updateProject(project, sc);
	}

	/**
	 * Met à jour le statut du projet par le framework workflow
	 */
	@Override
	public eu.strasbourg.service.project.model.Project updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectLocalService.updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	/**
	 * Met à jour le statut du projet "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(
			eu.strasbourg.service.project.model.Project project, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		_projectLocalService.updateStatus(project, status);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _projectLocalService.getBasePersistence();
	}

	@Override
	public ProjectLocalService getWrappedService() {
		return _projectLocalService;
	}

	@Override
	public void setWrappedService(ProjectLocalService projectLocalService) {
		_projectLocalService = projectLocalService;
	}

	private ProjectLocalService _projectLocalService;

}