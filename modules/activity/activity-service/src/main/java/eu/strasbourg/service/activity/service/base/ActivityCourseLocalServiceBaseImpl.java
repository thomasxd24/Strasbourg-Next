/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service.base;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.asset.kernel.service.persistence.AssetTagPersistence;
import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.activity.model.ActivityCourse;
import eu.strasbourg.service.activity.service.ActivityCourseLocalService;
import eu.strasbourg.service.activity.service.ActivityCourseLocalServiceUtil;
import eu.strasbourg.service.activity.service.persistence.ActivityCoursePersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityCoursePlacePersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityCourseSchedulePersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityOrganizerPersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityPersistence;
import eu.strasbourg.service.activity.service.persistence.AssociationPersistence;
import eu.strasbourg.service.activity.service.persistence.PracticePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the activity course local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.activity.service.impl.ActivityCourseLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eu.strasbourg.service.activity.service.impl.ActivityCourseLocalServiceImpl
 * @generated
 */
public abstract class ActivityCourseLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements ActivityCourseLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ActivityCourseLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ActivityCourseLocalServiceUtil</code>.
	 */

	/**
	 * Adds the activity course to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourse the activity course
	 * @return the activity course that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ActivityCourse addActivityCourse(ActivityCourse activityCourse) {
		activityCourse.setNew(true);

		return activityCoursePersistence.update(activityCourse);
	}

	/**
	 * Creates a new activity course with the primary key. Does not add the activity course to the database.
	 *
	 * @param activityCourseId the primary key for the new activity course
	 * @return the new activity course
	 */
	@Override
	@Transactional(enabled = false)
	public ActivityCourse createActivityCourse(long activityCourseId) {
		return activityCoursePersistence.create(activityCourseId);
	}

	/**
	 * Deletes the activity course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourseId the primary key of the activity course
	 * @return the activity course that was removed
	 * @throws PortalException if a activity course with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ActivityCourse deleteActivityCourse(long activityCourseId)
		throws PortalException {

		return activityCoursePersistence.remove(activityCourseId);
	}

	/**
	 * Deletes the activity course from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourse the activity course
	 * @return the activity course that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ActivityCourse deleteActivityCourse(ActivityCourse activityCourse) {
		return activityCoursePersistence.remove(activityCourse);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return activityCoursePersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			ActivityCourse.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return activityCoursePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return activityCoursePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return activityCoursePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return activityCoursePersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return activityCoursePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ActivityCourse fetchActivityCourse(long activityCourseId) {
		return activityCoursePersistence.fetchByPrimaryKey(activityCourseId);
	}

	/**
	 * Returns the activity course matching the UUID and group.
	 *
	 * @param uuid the activity course's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse fetchActivityCourseByUuidAndGroupId(
		String uuid, long groupId) {

		return activityCoursePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the activity course with the primary key.
	 *
	 * @param activityCourseId the primary key of the activity course
	 * @return the activity course
	 * @throws PortalException if a activity course with the primary key could not be found
	 */
	@Override
	public ActivityCourse getActivityCourse(long activityCourseId)
		throws PortalException {

		return activityCoursePersistence.findByPrimaryKey(activityCourseId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(activityCourseLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ActivityCourse.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("activityCourseId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			activityCourseLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ActivityCourse.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"activityCourseId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(activityCourseLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ActivityCourse.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("activityCourseId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					Criterion modifiedDateCriterion =
						portletDataContext.getDateRangeCriteria("modifiedDate");

					Criterion statusDateCriterion =
						portletDataContext.getDateRangeCriteria("statusDate");

					if ((modifiedDateCriterion != null) &&
						(statusDateCriterion != null)) {

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty =
						PropertyFactoryUtil.forName("status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(
							workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler =
							StagedModelDataHandlerRegistryUtil.
								getStagedModelDataHandler(
									ActivityCourse.class.getName());

						dynamicQuery.add(
							workflowStatusProperty.in(
								stagedModelDataHandler.
									getExportableStatuses()));
					}
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ActivityCourse>() {

				@Override
				public void performAction(ActivityCourse activityCourse)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, activityCourse);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(ActivityCourse.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return activityCoursePersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement ActivityCourseLocalServiceImpl#deleteActivityCourse(ActivityCourse) to avoid orphaned data");
		}

		return activityCourseLocalService.deleteActivityCourse(
			(ActivityCourse)persistedModel);
	}

	@Override
	public BasePersistence<ActivityCourse> getBasePersistence() {
		return activityCoursePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return activityCoursePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the activity courses matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity courses
	 * @param companyId the primary key of the company
	 * @return the matching activity courses, or an empty list if no matches were found
	 */
	@Override
	public List<ActivityCourse> getActivityCoursesByUuidAndCompanyId(
		String uuid, long companyId) {

		return activityCoursePersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of activity courses matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity courses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching activity courses, or an empty list if no matches were found
	 */
	@Override
	public List<ActivityCourse> getActivityCoursesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return activityCoursePersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the activity course matching the UUID and group.
	 *
	 * @param uuid the activity course's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity course
	 * @throws PortalException if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse getActivityCourseByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return activityCoursePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the activity courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @return the range of activity courses
	 */
	@Override
	public List<ActivityCourse> getActivityCourses(int start, int end) {
		return activityCoursePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of activity courses.
	 *
	 * @return the number of activity courses
	 */
	@Override
	public int getActivityCoursesCount() {
		return activityCoursePersistence.countAll();
	}

	/**
	 * Updates the activity course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourse the activity course
	 * @return the activity course that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ActivityCourse updateActivityCourse(ActivityCourse activityCourse) {
		return activityCoursePersistence.update(activityCourse);
	}

	/**
	 * Returns the activity local service.
	 *
	 * @return the activity local service
	 */
	public eu.strasbourg.service.activity.service.ActivityLocalService
		getActivityLocalService() {

		return activityLocalService;
	}

	/**
	 * Sets the activity local service.
	 *
	 * @param activityLocalService the activity local service
	 */
	public void setActivityLocalService(
		eu.strasbourg.service.activity.service.ActivityLocalService
			activityLocalService) {

		this.activityLocalService = activityLocalService;
	}

	/**
	 * Returns the activity persistence.
	 *
	 * @return the activity persistence
	 */
	public ActivityPersistence getActivityPersistence() {
		return activityPersistence;
	}

	/**
	 * Sets the activity persistence.
	 *
	 * @param activityPersistence the activity persistence
	 */
	public void setActivityPersistence(
		ActivityPersistence activityPersistence) {

		this.activityPersistence = activityPersistence;
	}

	/**
	 * Returns the activity course local service.
	 *
	 * @return the activity course local service
	 */
	public ActivityCourseLocalService getActivityCourseLocalService() {
		return activityCourseLocalService;
	}

	/**
	 * Sets the activity course local service.
	 *
	 * @param activityCourseLocalService the activity course local service
	 */
	public void setActivityCourseLocalService(
		ActivityCourseLocalService activityCourseLocalService) {

		this.activityCourseLocalService = activityCourseLocalService;
	}

	/**
	 * Returns the activity course persistence.
	 *
	 * @return the activity course persistence
	 */
	public ActivityCoursePersistence getActivityCoursePersistence() {
		return activityCoursePersistence;
	}

	/**
	 * Sets the activity course persistence.
	 *
	 * @param activityCoursePersistence the activity course persistence
	 */
	public void setActivityCoursePersistence(
		ActivityCoursePersistence activityCoursePersistence) {

		this.activityCoursePersistence = activityCoursePersistence;
	}

	/**
	 * Returns the activity course place local service.
	 *
	 * @return the activity course place local service
	 */
	public
		eu.strasbourg.service.activity.service.ActivityCoursePlaceLocalService
			getActivityCoursePlaceLocalService() {

		return activityCoursePlaceLocalService;
	}

	/**
	 * Sets the activity course place local service.
	 *
	 * @param activityCoursePlaceLocalService the activity course place local service
	 */
	public void setActivityCoursePlaceLocalService(
		eu.strasbourg.service.activity.service.ActivityCoursePlaceLocalService
			activityCoursePlaceLocalService) {

		this.activityCoursePlaceLocalService = activityCoursePlaceLocalService;
	}

	/**
	 * Returns the activity course place persistence.
	 *
	 * @return the activity course place persistence
	 */
	public ActivityCoursePlacePersistence getActivityCoursePlacePersistence() {
		return activityCoursePlacePersistence;
	}

	/**
	 * Sets the activity course place persistence.
	 *
	 * @param activityCoursePlacePersistence the activity course place persistence
	 */
	public void setActivityCoursePlacePersistence(
		ActivityCoursePlacePersistence activityCoursePlacePersistence) {

		this.activityCoursePlacePersistence = activityCoursePlacePersistence;
	}

	/**
	 * Returns the activity course schedule local service.
	 *
	 * @return the activity course schedule local service
	 */
	public
		eu.strasbourg.service.activity.service.
			ActivityCourseScheduleLocalService
				getActivityCourseScheduleLocalService() {

		return activityCourseScheduleLocalService;
	}

	/**
	 * Sets the activity course schedule local service.
	 *
	 * @param activityCourseScheduleLocalService the activity course schedule local service
	 */
	public void setActivityCourseScheduleLocalService(
		eu.strasbourg.service.activity.service.
			ActivityCourseScheduleLocalService
				activityCourseScheduleLocalService) {

		this.activityCourseScheduleLocalService =
			activityCourseScheduleLocalService;
	}

	/**
	 * Returns the activity course schedule persistence.
	 *
	 * @return the activity course schedule persistence
	 */
	public ActivityCourseSchedulePersistence
		getActivityCourseSchedulePersistence() {

		return activityCourseSchedulePersistence;
	}

	/**
	 * Sets the activity course schedule persistence.
	 *
	 * @param activityCourseSchedulePersistence the activity course schedule persistence
	 */
	public void setActivityCourseSchedulePersistence(
		ActivityCourseSchedulePersistence activityCourseSchedulePersistence) {

		this.activityCourseSchedulePersistence =
			activityCourseSchedulePersistence;
	}

	/**
	 * Returns the activity organizer local service.
	 *
	 * @return the activity organizer local service
	 */
	public eu.strasbourg.service.activity.service.ActivityOrganizerLocalService
		getActivityOrganizerLocalService() {

		return activityOrganizerLocalService;
	}

	/**
	 * Sets the activity organizer local service.
	 *
	 * @param activityOrganizerLocalService the activity organizer local service
	 */
	public void setActivityOrganizerLocalService(
		eu.strasbourg.service.activity.service.ActivityOrganizerLocalService
			activityOrganizerLocalService) {

		this.activityOrganizerLocalService = activityOrganizerLocalService;
	}

	/**
	 * Returns the activity organizer persistence.
	 *
	 * @return the activity organizer persistence
	 */
	public ActivityOrganizerPersistence getActivityOrganizerPersistence() {
		return activityOrganizerPersistence;
	}

	/**
	 * Sets the activity organizer persistence.
	 *
	 * @param activityOrganizerPersistence the activity organizer persistence
	 */
	public void setActivityOrganizerPersistence(
		ActivityOrganizerPersistence activityOrganizerPersistence) {

		this.activityOrganizerPersistence = activityOrganizerPersistence;
	}

	/**
	 * Returns the association local service.
	 *
	 * @return the association local service
	 */
	public eu.strasbourg.service.activity.service.AssociationLocalService
		getAssociationLocalService() {

		return associationLocalService;
	}

	/**
	 * Sets the association local service.
	 *
	 * @param associationLocalService the association local service
	 */
	public void setAssociationLocalService(
		eu.strasbourg.service.activity.service.AssociationLocalService
			associationLocalService) {

		this.associationLocalService = associationLocalService;
	}

	/**
	 * Returns the association persistence.
	 *
	 * @return the association persistence
	 */
	public AssociationPersistence getAssociationPersistence() {
		return associationPersistence;
	}

	/**
	 * Sets the association persistence.
	 *
	 * @param associationPersistence the association persistence
	 */
	public void setAssociationPersistence(
		AssociationPersistence associationPersistence) {

		this.associationPersistence = associationPersistence;
	}

	/**
	 * Returns the practice local service.
	 *
	 * @return the practice local service
	 */
	public eu.strasbourg.service.activity.service.PracticeLocalService
		getPracticeLocalService() {

		return practiceLocalService;
	}

	/**
	 * Sets the practice local service.
	 *
	 * @param practiceLocalService the practice local service
	 */
	public void setPracticeLocalService(
		eu.strasbourg.service.activity.service.PracticeLocalService
			practiceLocalService) {

		this.practiceLocalService = practiceLocalService;
	}

	/**
	 * Returns the practice persistence.
	 *
	 * @return the practice persistence
	 */
	public PracticePersistence getPracticePersistence() {
		return practicePersistence;
	}

	/**
	 * Sets the practice persistence.
	 *
	 * @param practicePersistence the practice persistence
	 */
	public void setPracticePersistence(
		PracticePersistence practicePersistence) {

		this.practicePersistence = practicePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.asset.kernel.service.AssetEntryLocalService
		getAssetEntryLocalService() {

		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.asset.kernel.service.AssetEntryLocalService
			assetEntryLocalService) {

		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {

		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the asset tag local service.
	 *
	 * @return the asset tag local service
	 */
	public com.liferay.asset.kernel.service.AssetTagLocalService
		getAssetTagLocalService() {

		return assetTagLocalService;
	}

	/**
	 * Sets the asset tag local service.
	 *
	 * @param assetTagLocalService the asset tag local service
	 */
	public void setAssetTagLocalService(
		com.liferay.asset.kernel.service.AssetTagLocalService
			assetTagLocalService) {

		this.assetTagLocalService = assetTagLocalService;
	}

	/**
	 * Returns the asset tag persistence.
	 *
	 * @return the asset tag persistence
	 */
	public AssetTagPersistence getAssetTagPersistence() {
		return assetTagPersistence;
	}

	/**
	 * Sets the asset tag persistence.
	 *
	 * @param assetTagPersistence the asset tag persistence
	 */
	public void setAssetTagPersistence(
		AssetTagPersistence assetTagPersistence) {

		this.assetTagPersistence = assetTagPersistence;
	}

	public void afterPropertiesSet() {
		ActivityCourseLocalServiceUtil.setService(activityCourseLocalService);
	}

	public void destroy() {
		ActivityCourseLocalServiceUtil.setService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ActivityCourseLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ActivityCourse.class;
	}

	protected String getModelClassName() {
		return ActivityCourse.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = activityCoursePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@BeanReference(
		type = eu.strasbourg.service.activity.service.ActivityLocalService.class
	)
	protected eu.strasbourg.service.activity.service.ActivityLocalService
		activityLocalService;

	@BeanReference(type = ActivityPersistence.class)
	protected ActivityPersistence activityPersistence;

	@BeanReference(type = ActivityCourseLocalService.class)
	protected ActivityCourseLocalService activityCourseLocalService;

	@BeanReference(type = ActivityCoursePersistence.class)
	protected ActivityCoursePersistence activityCoursePersistence;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.ActivityCoursePlaceLocalService.class
	)
	protected
		eu.strasbourg.service.activity.service.ActivityCoursePlaceLocalService
			activityCoursePlaceLocalService;

	@BeanReference(type = ActivityCoursePlacePersistence.class)
	protected ActivityCoursePlacePersistence activityCoursePlacePersistence;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.ActivityCourseScheduleLocalService.class
	)
	protected
		eu.strasbourg.service.activity.service.
			ActivityCourseScheduleLocalService
				activityCourseScheduleLocalService;

	@BeanReference(type = ActivityCourseSchedulePersistence.class)
	protected ActivityCourseSchedulePersistence
		activityCourseSchedulePersistence;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.ActivityOrganizerLocalService.class
	)
	protected
		eu.strasbourg.service.activity.service.ActivityOrganizerLocalService
			activityOrganizerLocalService;

	@BeanReference(type = ActivityOrganizerPersistence.class)
	protected ActivityOrganizerPersistence activityOrganizerPersistence;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.AssociationLocalService.class
	)
	protected eu.strasbourg.service.activity.service.AssociationLocalService
		associationLocalService;

	@BeanReference(type = AssociationPersistence.class)
	protected AssociationPersistence associationPersistence;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.PracticeLocalService.class
	)
	protected eu.strasbourg.service.activity.service.PracticeLocalService
		practiceLocalService;

	@BeanReference(type = PracticePersistence.class)
	protected PracticePersistence practicePersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetEntryLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@ServiceReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetTagLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@ServiceReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		ActivityCourseLocalServiceBaseImpl.class);

}