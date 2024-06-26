/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ActivityCourseScheduleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourseScheduleLocalService
 * @generated
 */
public class ActivityCourseScheduleLocalServiceWrapper
	implements ActivityCourseScheduleLocalService,
			   ServiceWrapper<ActivityCourseScheduleLocalService> {

	public ActivityCourseScheduleLocalServiceWrapper() {
		this(null);
	}

	public ActivityCourseScheduleLocalServiceWrapper(
		ActivityCourseScheduleLocalService activityCourseScheduleLocalService) {

		_activityCourseScheduleLocalService =
			activityCourseScheduleLocalService;
	}

	/**
	 * Adds the activity course schedule to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourseSchedule the activity course schedule
	 * @return the activity course schedule that was added
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourseSchedule
		addActivityCourseSchedule(
			eu.strasbourg.service.activity.model.ActivityCourseSchedule
				activityCourseSchedule) {

		return _activityCourseScheduleLocalService.addActivityCourseSchedule(
			activityCourseSchedule);
	}

	/**
	 * Creates a new activity course schedule with the primary key. Does not add the activity course schedule to the database.
	 *
	 * @param activityCourseScheduleId the primary key for the new activity course schedule
	 * @return the new activity course schedule
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourseSchedule
		createActivityCourseSchedule(long activityCourseScheduleId) {

		return _activityCourseScheduleLocalService.createActivityCourseSchedule(
			activityCourseScheduleId);
	}

	/**
	 * Crée une activité vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourseSchedule
			createActivityCourseSchedule(
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityCourseScheduleLocalService.createActivityCourseSchedule(
			sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityCourseScheduleLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the activity course schedule from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourseSchedule the activity course schedule
	 * @return the activity course schedule that was removed
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourseSchedule
		deleteActivityCourseSchedule(
			eu.strasbourg.service.activity.model.ActivityCourseSchedule
				activityCourseSchedule) {

		return _activityCourseScheduleLocalService.deleteActivityCourseSchedule(
			activityCourseSchedule);
	}

	/**
	 * Deletes the activity course schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourseScheduleId the primary key of the activity course schedule
	 * @return the activity course schedule that was removed
	 * @throws PortalException if a activity course schedule with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourseSchedule
			deleteActivityCourseSchedule(long activityCourseScheduleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityCourseScheduleLocalService.deleteActivityCourseSchedule(
			activityCourseScheduleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityCourseScheduleLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _activityCourseScheduleLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _activityCourseScheduleLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _activityCourseScheduleLocalService.dynamicQuery();
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

		return _activityCourseScheduleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleModelImpl</code>.
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

		return _activityCourseScheduleLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleModelImpl</code>.
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

		return _activityCourseScheduleLocalService.dynamicQuery(
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

		return _activityCourseScheduleLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _activityCourseScheduleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.activity.model.ActivityCourseSchedule
		fetchActivityCourseSchedule(long activityCourseScheduleId) {

		return _activityCourseScheduleLocalService.fetchActivityCourseSchedule(
			activityCourseScheduleId);
	}

	/**
	 * Returns the activity course schedule matching the UUID and group.
	 *
	 * @param uuid the activity course schedule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity course schedule, or <code>null</code> if a matching activity course schedule could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourseSchedule
		fetchActivityCourseScheduleByUuidAndGroupId(String uuid, long groupId) {

		return _activityCourseScheduleLocalService.
			fetchActivityCourseScheduleByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Retourne la liste des horaires pour une liste de jours donnés sur une
	 * plage horaire donnée
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.activity.model.ActivityCourseSchedule>
			findByDaysAndTimes(
				long groupId, boolean[] days, String startTime,
				String endTime) {

		return _activityCourseScheduleLocalService.findByDaysAndTimes(
			groupId, days, startTime, endTime);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.activity.model.ActivityCourseSchedule>
			findByKeyword(String keyword, long groupId, int start, int end) {

		return _activityCourseScheduleLocalService.findByKeyword(
			keyword, groupId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _activityCourseScheduleLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the activity course schedule with the primary key.
	 *
	 * @param activityCourseScheduleId the primary key of the activity course schedule
	 * @return the activity course schedule
	 * @throws PortalException if a activity course schedule with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourseSchedule
			getActivityCourseSchedule(long activityCourseScheduleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityCourseScheduleLocalService.getActivityCourseSchedule(
			activityCourseScheduleId);
	}

	/**
	 * Returns the activity course schedule matching the UUID and group.
	 *
	 * @param uuid the activity course schedule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity course schedule
	 * @throws PortalException if a matching activity course schedule could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourseSchedule
			getActivityCourseScheduleByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityCourseScheduleLocalService.
			getActivityCourseScheduleByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the activity course schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @return the range of activity course schedules
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.activity.model.ActivityCourseSchedule>
			getActivityCourseSchedules(int start, int end) {

		return _activityCourseScheduleLocalService.getActivityCourseSchedules(
			start, end);
	}

	/**
	 * Returns all the activity course schedules matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity course schedules
	 * @param companyId the primary key of the company
	 * @return the matching activity course schedules, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.activity.model.ActivityCourseSchedule>
			getActivityCourseSchedulesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _activityCourseScheduleLocalService.
			getActivityCourseSchedulesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of activity course schedules matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity course schedules
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching activity course schedules, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.activity.model.ActivityCourseSchedule>
			getActivityCourseSchedulesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<eu.strasbourg.service.activity.model.
						ActivityCourseSchedule> orderByComparator) {

		return _activityCourseScheduleLocalService.
			getActivityCourseSchedulesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of activity course schedules.
	 *
	 * @return the number of activity course schedules
	 */
	@Override
	public int getActivityCourseSchedulesCount() {
		return _activityCourseScheduleLocalService.
			getActivityCourseSchedulesCount();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return _activityCourseScheduleLocalService.getAttachedVocabularies(
			groupId);
	}

	/**
	 * Retourne les horaires d'un cours dans un lieu
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.activity.model.ActivityCourseSchedule>
			getByActivityCoursePlace(long activityCoursePlaceId) {

		return _activityCourseScheduleLocalService.getByActivityCoursePlace(
			activityCoursePlaceId);
	}

	/**
	 * Retourne toutes les éditions d'un groupe
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.activity.model.ActivityCourseSchedule>
			getByGroupId(long groupId) {

		return _activityCourseScheduleLocalService.getByGroupId(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _activityCourseScheduleLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _activityCourseScheduleLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _activityCourseScheduleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityCourseScheduleLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Supprime une entité
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourseSchedule
			removeActivityCourseSchedule(long activityCourseScheduleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityCourseScheduleLocalService.removeActivityCourseSchedule(
			activityCourseScheduleId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	@Override
	public com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return _activityCourseScheduleLocalService.search(searchContext);
	}

	/**
	 * Updates the activity course schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourseSchedule the activity course schedule
	 * @return the activity course schedule that was updated
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourseSchedule
		updateActivityCourseSchedule(
			eu.strasbourg.service.activity.model.ActivityCourseSchedule
				activityCourseSchedule) {

		return _activityCourseScheduleLocalService.updateActivityCourseSchedule(
			activityCourseSchedule);
	}

	/**
	 * Met à jour une activité et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourseSchedule
			updateActivityCourseSchedule(
				eu.strasbourg.service.activity.model.ActivityCourseSchedule
					activityCourseSchedule,
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityCourseScheduleLocalService.updateActivityCourseSchedule(
			activityCourseSchedule, sc);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _activityCourseScheduleLocalService.getBasePersistence();
	}

	@Override
	public ActivityCourseScheduleLocalService getWrappedService() {
		return _activityCourseScheduleLocalService;
	}

	@Override
	public void setWrappedService(
		ActivityCourseScheduleLocalService activityCourseScheduleLocalService) {

		_activityCourseScheduleLocalService =
			activityCourseScheduleLocalService;
	}

	private ActivityCourseScheduleLocalService
		_activityCourseScheduleLocalService;

}