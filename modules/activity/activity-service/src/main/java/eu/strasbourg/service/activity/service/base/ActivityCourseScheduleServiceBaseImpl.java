/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service.base;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.asset.kernel.service.persistence.AssetTagPersistence;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.activity.model.ActivityCourseSchedule;
import eu.strasbourg.service.activity.service.ActivityCourseScheduleService;
import eu.strasbourg.service.activity.service.ActivityCourseScheduleServiceUtil;
import eu.strasbourg.service.activity.service.persistence.ActivityCoursePersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityCoursePlacePersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityCourseSchedulePersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityOrganizerPersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityPersistence;
import eu.strasbourg.service.activity.service.persistence.AssociationPersistence;
import eu.strasbourg.service.activity.service.persistence.PracticePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the activity course schedule remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.activity.service.impl.ActivityCourseScheduleServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eu.strasbourg.service.activity.service.impl.ActivityCourseScheduleServiceImpl
 * @generated
 */
public abstract class ActivityCourseScheduleServiceBaseImpl
	extends BaseServiceImpl
	implements ActivityCourseScheduleService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ActivityCourseScheduleService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ActivityCourseScheduleServiceUtil</code>.
	 */

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
	 * Returns the activity remote service.
	 *
	 * @return the activity remote service
	 */
	public eu.strasbourg.service.activity.service.ActivityService
		getActivityService() {

		return activityService;
	}

	/**
	 * Sets the activity remote service.
	 *
	 * @param activityService the activity remote service
	 */
	public void setActivityService(
		eu.strasbourg.service.activity.service.ActivityService
			activityService) {

		this.activityService = activityService;
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
	public eu.strasbourg.service.activity.service.ActivityCourseLocalService
		getActivityCourseLocalService() {

		return activityCourseLocalService;
	}

	/**
	 * Sets the activity course local service.
	 *
	 * @param activityCourseLocalService the activity course local service
	 */
	public void setActivityCourseLocalService(
		eu.strasbourg.service.activity.service.ActivityCourseLocalService
			activityCourseLocalService) {

		this.activityCourseLocalService = activityCourseLocalService;
	}

	/**
	 * Returns the activity course remote service.
	 *
	 * @return the activity course remote service
	 */
	public eu.strasbourg.service.activity.service.ActivityCourseService
		getActivityCourseService() {

		return activityCourseService;
	}

	/**
	 * Sets the activity course remote service.
	 *
	 * @param activityCourseService the activity course remote service
	 */
	public void setActivityCourseService(
		eu.strasbourg.service.activity.service.ActivityCourseService
			activityCourseService) {

		this.activityCourseService = activityCourseService;
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
	 * Returns the activity course place remote service.
	 *
	 * @return the activity course place remote service
	 */
	public eu.strasbourg.service.activity.service.ActivityCoursePlaceService
		getActivityCoursePlaceService() {

		return activityCoursePlaceService;
	}

	/**
	 * Sets the activity course place remote service.
	 *
	 * @param activityCoursePlaceService the activity course place remote service
	 */
	public void setActivityCoursePlaceService(
		eu.strasbourg.service.activity.service.ActivityCoursePlaceService
			activityCoursePlaceService) {

		this.activityCoursePlaceService = activityCoursePlaceService;
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
	 * Returns the activity course schedule remote service.
	 *
	 * @return the activity course schedule remote service
	 */
	public ActivityCourseScheduleService getActivityCourseScheduleService() {
		return activityCourseScheduleService;
	}

	/**
	 * Sets the activity course schedule remote service.
	 *
	 * @param activityCourseScheduleService the activity course schedule remote service
	 */
	public void setActivityCourseScheduleService(
		ActivityCourseScheduleService activityCourseScheduleService) {

		this.activityCourseScheduleService = activityCourseScheduleService;
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
	 * Returns the activity organizer remote service.
	 *
	 * @return the activity organizer remote service
	 */
	public eu.strasbourg.service.activity.service.ActivityOrganizerService
		getActivityOrganizerService() {

		return activityOrganizerService;
	}

	/**
	 * Sets the activity organizer remote service.
	 *
	 * @param activityOrganizerService the activity organizer remote service
	 */
	public void setActivityOrganizerService(
		eu.strasbourg.service.activity.service.ActivityOrganizerService
			activityOrganizerService) {

		this.activityOrganizerService = activityOrganizerService;
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
	 * Returns the association remote service.
	 *
	 * @return the association remote service
	 */
	public eu.strasbourg.service.activity.service.AssociationService
		getAssociationService() {

		return associationService;
	}

	/**
	 * Sets the association remote service.
	 *
	 * @param associationService the association remote service
	 */
	public void setAssociationService(
		eu.strasbourg.service.activity.service.AssociationService
			associationService) {

		this.associationService = associationService;
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
	 * Returns the practice remote service.
	 *
	 * @return the practice remote service
	 */
	public eu.strasbourg.service.activity.service.PracticeService
		getPracticeService() {

		return practiceService;
	}

	/**
	 * Sets the practice remote service.
	 *
	 * @param practiceService the practice remote service
	 */
	public void setPracticeService(
		eu.strasbourg.service.activity.service.PracticeService
			practiceService) {

		this.practiceService = practiceService;
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
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService
		getClassNameService() {

		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {

		this.classNameService = classNameService;
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
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {

		this.userService = userService;
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
	 * Returns the asset entry remote service.
	 *
	 * @return the asset entry remote service
	 */
	public com.liferay.asset.kernel.service.AssetEntryService
		getAssetEntryService() {

		return assetEntryService;
	}

	/**
	 * Sets the asset entry remote service.
	 *
	 * @param assetEntryService the asset entry remote service
	 */
	public void setAssetEntryService(
		com.liferay.asset.kernel.service.AssetEntryService assetEntryService) {

		this.assetEntryService = assetEntryService;
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
	 * Returns the asset tag remote service.
	 *
	 * @return the asset tag remote service
	 */
	public com.liferay.asset.kernel.service.AssetTagService
		getAssetTagService() {

		return assetTagService;
	}

	/**
	 * Sets the asset tag remote service.
	 *
	 * @param assetTagService the asset tag remote service
	 */
	public void setAssetTagService(
		com.liferay.asset.kernel.service.AssetTagService assetTagService) {

		this.assetTagService = assetTagService;
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
		ActivityCourseScheduleServiceUtil.setService(
			activityCourseScheduleService);
	}

	public void destroy() {
		ActivityCourseScheduleServiceUtil.setService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ActivityCourseScheduleService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ActivityCourseSchedule.class;
	}

	protected String getModelClassName() {
		return ActivityCourseSchedule.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				activityCourseSchedulePersistence.getDataSource();

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

	@BeanReference(
		type = eu.strasbourg.service.activity.service.ActivityService.class
	)
	protected eu.strasbourg.service.activity.service.ActivityService
		activityService;

	@BeanReference(type = ActivityPersistence.class)
	protected ActivityPersistence activityPersistence;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.ActivityCourseLocalService.class
	)
	protected eu.strasbourg.service.activity.service.ActivityCourseLocalService
		activityCourseLocalService;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.ActivityCourseService.class
	)
	protected eu.strasbourg.service.activity.service.ActivityCourseService
		activityCourseService;

	@BeanReference(type = ActivityCoursePersistence.class)
	protected ActivityCoursePersistence activityCoursePersistence;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.ActivityCoursePlaceLocalService.class
	)
	protected
		eu.strasbourg.service.activity.service.ActivityCoursePlaceLocalService
			activityCoursePlaceLocalService;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.ActivityCoursePlaceService.class
	)
	protected eu.strasbourg.service.activity.service.ActivityCoursePlaceService
		activityCoursePlaceService;

	@BeanReference(type = ActivityCoursePlacePersistence.class)
	protected ActivityCoursePlacePersistence activityCoursePlacePersistence;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.ActivityCourseScheduleLocalService.class
	)
	protected
		eu.strasbourg.service.activity.service.
			ActivityCourseScheduleLocalService
				activityCourseScheduleLocalService;

	@BeanReference(type = ActivityCourseScheduleService.class)
	protected ActivityCourseScheduleService activityCourseScheduleService;

	@BeanReference(type = ActivityCourseSchedulePersistence.class)
	protected ActivityCourseSchedulePersistence
		activityCourseSchedulePersistence;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.ActivityOrganizerLocalService.class
	)
	protected
		eu.strasbourg.service.activity.service.ActivityOrganizerLocalService
			activityOrganizerLocalService;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.ActivityOrganizerService.class
	)
	protected eu.strasbourg.service.activity.service.ActivityOrganizerService
		activityOrganizerService;

	@BeanReference(type = ActivityOrganizerPersistence.class)
	protected ActivityOrganizerPersistence activityOrganizerPersistence;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.AssociationLocalService.class
	)
	protected eu.strasbourg.service.activity.service.AssociationLocalService
		associationLocalService;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.AssociationService.class
	)
	protected eu.strasbourg.service.activity.service.AssociationService
		associationService;

	@BeanReference(type = AssociationPersistence.class)
	protected AssociationPersistence associationPersistence;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.PracticeLocalService.class
	)
	protected eu.strasbourg.service.activity.service.PracticeLocalService
		practiceLocalService;

	@BeanReference(
		type = eu.strasbourg.service.activity.service.PracticeService.class
	)
	protected eu.strasbourg.service.activity.service.PracticeService
		practiceService;

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

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

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

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserService.class
	)
	protected com.liferay.portal.kernel.service.UserService userService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetEntryLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetEntryService.class
	)
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@ServiceReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetTagLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetTagService.class
	)
	protected com.liferay.asset.kernel.service.AssetTagService assetTagService;

	@ServiceReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		ActivityCourseScheduleServiceBaseImpl.class);

}