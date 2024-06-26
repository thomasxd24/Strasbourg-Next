/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProjectFollowedLocalService}.
 *
 * @author Cedric Henry
 * @see ProjectFollowedLocalService
 * @generated
 */
public class ProjectFollowedLocalServiceWrapper
	implements ProjectFollowedLocalService,
			   ServiceWrapper<ProjectFollowedLocalService> {

	public ProjectFollowedLocalServiceWrapper() {
		this(null);
	}

	public ProjectFollowedLocalServiceWrapper(
		ProjectFollowedLocalService projectFollowedLocalService) {

		_projectFollowedLocalService = projectFollowedLocalService;
	}

	/**
	 * Adds the project followed to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectFollowedLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectFollowed the project followed
	 * @return the project followed that was added
	 */
	@Override
	public eu.strasbourg.service.project.model.ProjectFollowed
		addProjectFollowed(
			eu.strasbourg.service.project.model.ProjectFollowed
				projectFollowed) {

		return _projectFollowedLocalService.addProjectFollowed(projectFollowed);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectFollowedLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Cree un nouveau follower a un projet
	 */
	@Override
	public eu.strasbourg.service.project.model.ProjectFollowed
		createProjectFollowed() {

		return _projectFollowedLocalService.createProjectFollowed();
	}

	/**
	 * Creates a new project followed with the primary key. Does not add the project followed to the database.
	 *
	 * @param projectFollowedId the primary key for the new project followed
	 * @return the new project followed
	 */
	@Override
	public eu.strasbourg.service.project.model.ProjectFollowed
		createProjectFollowed(long projectFollowedId) {

		return _projectFollowedLocalService.createProjectFollowed(
			projectFollowedId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectFollowedLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the project followed with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectFollowedLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectFollowedId the primary key of the project followed
	 * @return the project followed that was removed
	 * @throws PortalException if a project followed with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.ProjectFollowed
			deleteProjectFollowed(long projectFollowedId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectFollowedLocalService.deleteProjectFollowed(
			projectFollowedId);
	}

	/**
	 * Deletes the project followed from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectFollowedLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectFollowed the project followed
	 * @return the project followed that was removed
	 */
	@Override
	public eu.strasbourg.service.project.model.ProjectFollowed
		deleteProjectFollowed(
			eu.strasbourg.service.project.model.ProjectFollowed
				projectFollowed) {

		return _projectFollowedLocalService.deleteProjectFollowed(
			projectFollowed);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _projectFollowedLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _projectFollowedLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectFollowedLocalService.dynamicQuery();
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

		return _projectFollowedLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ProjectFollowedModelImpl</code>.
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

		return _projectFollowedLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ProjectFollowedModelImpl</code>.
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

		return _projectFollowedLocalService.dynamicQuery(
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

		return _projectFollowedLocalService.dynamicQueryCount(dynamicQuery);
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

		return _projectFollowedLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.project.model.ProjectFollowed
		fetchProjectFollowed(long projectFollowedId) {

		return _projectFollowedLocalService.fetchProjectFollowed(
			projectFollowedId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projectFollowedLocalService.getActionableDynamicQuery();
	}

	/**
	 * Retourne la liste des likes/dislikes d'un evenement
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.ProjectFollowed>
		getByProjectId(long projectId) {

		return _projectFollowedLocalService.getByProjectId(projectId);
	}

	/**
	 * Retourne tous les projets suivis par un utilisateur
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.ProjectFollowed>
		getByPublikId(String publikId) {

		return _projectFollowedLocalService.getByPublikId(publikId);
	}

	/**
	 * Retourne le suivi d'un utilisateur et d'un projet donné
	 */
	@Override
	public eu.strasbourg.service.project.model.ProjectFollowed
		getByPublikUserIdAndProjectId(String publikUserId, long projectId) {

		return _projectFollowedLocalService.getByPublikUserIdAndProjectId(
			publikUserId, projectId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projectFollowedLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectFollowedLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectFollowedLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the project followed with the primary key.
	 *
	 * @param projectFollowedId the primary key of the project followed
	 * @return the project followed
	 * @throws PortalException if a project followed with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.ProjectFollowed
			getProjectFollowed(long projectFollowedId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectFollowedLocalService.getProjectFollowed(
			projectFollowedId);
	}

	/**
	 * Returns a range of all the project followeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ProjectFollowedModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project followeds
	 * @param end the upper bound of the range of project followeds (not inclusive)
	 * @return the range of project followeds
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.ProjectFollowed>
		getProjectFolloweds(int start, int end) {

		return _projectFollowedLocalService.getProjectFolloweds(start, end);
	}

	/**
	 * Returns the number of project followeds.
	 *
	 * @return the number of project followeds
	 */
	@Override
	public int getProjectFollowedsCount() {
		return _projectFollowedLocalService.getProjectFollowedsCount();
	}

	/**
	 * Updates the project followed in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectFollowedLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectFollowed the project followed
	 * @return the project followed that was updated
	 */
	@Override
	public eu.strasbourg.service.project.model.ProjectFollowed
		updateProjectFollowed(
			eu.strasbourg.service.project.model.ProjectFollowed
				projectFollowed) {

		return _projectFollowedLocalService.updateProjectFollowed(
			projectFollowed);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _projectFollowedLocalService.getBasePersistence();
	}

	@Override
	public ProjectFollowedLocalService getWrappedService() {
		return _projectFollowedLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectFollowedLocalService projectFollowedLocalService) {

		_projectFollowedLocalService = projectFollowedLocalService;
	}

	private ProjectFollowedLocalService _projectFollowedLocalService;

}