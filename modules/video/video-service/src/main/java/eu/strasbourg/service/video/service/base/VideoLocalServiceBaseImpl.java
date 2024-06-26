/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.video.service.base;

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
import com.liferay.portal.kernel.dao.orm.Conjunction;
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

import eu.strasbourg.service.video.model.Video;
import eu.strasbourg.service.video.service.VideoLocalService;
import eu.strasbourg.service.video.service.VideoLocalServiceUtil;
import eu.strasbourg.service.video.service.persistence.VideoGalleryPersistence;
import eu.strasbourg.service.video.service.persistence.VideoPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the video local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.video.service.impl.VideoLocalServiceImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see eu.strasbourg.service.video.service.impl.VideoLocalServiceImpl
 * @generated
 */
public abstract class VideoLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements IdentifiableOSGiService, VideoLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>VideoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>VideoLocalServiceUtil</code>.
	 */

	/**
	 * Adds the video to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param video the video
	 * @return the video that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Video addVideo(Video video) {
		video.setNew(true);

		return videoPersistence.update(video);
	}

	/**
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param videoId the primary key for the new video
	 * @return the new video
	 */
	@Override
	@Transactional(enabled = false)
	public Video createVideo(long videoId) {
		return videoPersistence.create(videoId);
	}

	/**
	 * Deletes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param videoId the primary key of the video
	 * @return the video that was removed
	 * @throws PortalException if a video with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Video deleteVideo(long videoId) throws PortalException {
		return videoPersistence.remove(videoId);
	}

	/**
	 * Deletes the video from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param video the video
	 * @return the video that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Video deleteVideo(Video video) {
		return videoPersistence.remove(video);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return videoPersistence.dslQuery(dslQuery);
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
			Video.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return videoPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoModelImpl</code>.
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

		return videoPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoModelImpl</code>.
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

		return videoPersistence.findWithDynamicQuery(
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
		return videoPersistence.countWithDynamicQuery(dynamicQuery);
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

		return videoPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Video fetchVideo(long videoId) {
		return videoPersistence.fetchByPrimaryKey(videoId);
	}

	/**
	 * Returns the video matching the UUID and group.
	 *
	 * @param uuid the video's UUID
	 * @param groupId the primary key of the group
	 * @return the matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchVideoByUuidAndGroupId(String uuid, long groupId) {
		return videoPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the video with the primary key.
	 *
	 * @param videoId the primary key of the video
	 * @return the video
	 * @throws PortalException if a video with the primary key could not be found
	 */
	@Override
	public Video getVideo(long videoId) throws PortalException {
		return videoPersistence.findByPrimaryKey(videoId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(videoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Video.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("videoId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(videoLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Video.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("videoId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(videoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Video.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("videoId");
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

					if (modifiedDateCriterion != null) {
						Conjunction conjunction =
							RestrictionsFactoryUtil.conjunction();

						conjunction.add(modifiedDateCriterion);

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(
							RestrictionsFactoryUtil.gtProperty(
								"modifiedDate", "lastPublishDate"));

						Property lastPublishDateProperty =
							PropertyFactoryUtil.forName("lastPublishDate");

						disjunction.add(lastPublishDateProperty.isNull());

						conjunction.add(disjunction);

						modifiedDateCriterion = conjunction;
					}

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
									Video.class.getName());

						dynamicQuery.add(
							workflowStatusProperty.in(
								stagedModelDataHandler.
									getExportableStatuses()));
					}
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setGroupId(
			portletDataContext.getScopeGroupId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Video>() {

				@Override
				public void performAction(Video video) throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, video);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(Video.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return videoPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement VideoLocalServiceImpl#deleteVideo(Video) to avoid orphaned data");
		}

		return videoLocalService.deleteVideo((Video)persistedModel);
	}

	@Override
	public BasePersistence<Video> getBasePersistence() {
		return videoPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return videoPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the videos matching the UUID and company.
	 *
	 * @param uuid the UUID of the videos
	 * @param companyId the primary key of the company
	 * @return the matching videos, or an empty list if no matches were found
	 */
	@Override
	public List<Video> getVideosByUuidAndCompanyId(
		String uuid, long companyId) {

		return videoPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of videos matching the UUID and company.
	 *
	 * @param uuid the UUID of the videos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching videos, or an empty list if no matches were found
	 */
	@Override
	public List<Video> getVideosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return videoPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the video matching the UUID and group.
	 *
	 * @param uuid the video's UUID
	 * @param groupId the primary key of the group
	 * @return the matching video
	 * @throws PortalException if a matching video could not be found
	 */
	@Override
	public Video getVideoByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return videoPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of videos
	 */
	@Override
	public List<Video> getVideos(int start, int end) {
		return videoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of videos.
	 *
	 * @return the number of videos
	 */
	@Override
	public int getVideosCount() {
		return videoPersistence.countAll();
	}

	/**
	 * Updates the video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param video the video
	 * @return the video that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Video updateVideo(Video video) {
		return videoPersistence.update(video);
	}

	/**
	 */
	@Override
	public boolean addVideoGalleryVideo(long galleryId, long videoId) {
		return videoGalleryPersistence.addVideo(galleryId, videoId);
	}

	/**
	 */
	@Override
	public boolean addVideoGalleryVideo(long galleryId, Video video) {
		return videoGalleryPersistence.addVideo(galleryId, video);
	}

	/**
	 */
	@Override
	public boolean addVideoGalleryVideos(long galleryId, long[] videoIds) {
		return videoGalleryPersistence.addVideos(galleryId, videoIds);
	}

	/**
	 */
	@Override
	public boolean addVideoGalleryVideos(long galleryId, List<Video> videos) {
		return videoGalleryPersistence.addVideos(galleryId, videos);
	}

	/**
	 */
	@Override
	public void clearVideoGalleryVideos(long galleryId) {
		videoGalleryPersistence.clearVideos(galleryId);
	}

	/**
	 */
	@Override
	public void deleteVideoGalleryVideo(long galleryId, long videoId) {
		videoGalleryPersistence.removeVideo(galleryId, videoId);
	}

	/**
	 */
	@Override
	public void deleteVideoGalleryVideo(long galleryId, Video video) {
		videoGalleryPersistence.removeVideo(galleryId, video);
	}

	/**
	 */
	@Override
	public void deleteVideoGalleryVideos(long galleryId, long[] videoIds) {
		videoGalleryPersistence.removeVideos(galleryId, videoIds);
	}

	/**
	 */
	@Override
	public void deleteVideoGalleryVideos(long galleryId, List<Video> videos) {
		videoGalleryPersistence.removeVideos(galleryId, videos);
	}

	/**
	 * Returns the galleryIds of the video galleries associated with the video.
	 *
	 * @param videoId the videoId of the video
	 * @return long[] the galleryIds of video galleries associated with the video
	 */
	@Override
	public long[] getVideoGalleryPrimaryKeys(long videoId) {
		return videoPersistence.getVideoGalleryPrimaryKeys(videoId);
	}

	/**
	 */
	@Override
	public List<Video> getVideoGalleryVideos(long galleryId) {
		return videoGalleryPersistence.getVideos(galleryId);
	}

	/**
	 */
	@Override
	public List<Video> getVideoGalleryVideos(
		long galleryId, int start, int end) {

		return videoGalleryPersistence.getVideos(galleryId, start, end);
	}

	/**
	 */
	@Override
	public List<Video> getVideoGalleryVideos(
		long galleryId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return videoGalleryPersistence.getVideos(
			galleryId, start, end, orderByComparator);
	}

	/**
	 */
	@Override
	public int getVideoGalleryVideosCount(long galleryId) {
		return videoGalleryPersistence.getVideosSize(galleryId);
	}

	/**
	 */
	@Override
	public boolean hasVideoGalleryVideo(long galleryId, long videoId) {
		return videoGalleryPersistence.containsVideo(galleryId, videoId);
	}

	/**
	 */
	@Override
	public boolean hasVideoGalleryVideos(long galleryId) {
		return videoGalleryPersistence.containsVideos(galleryId);
	}

	/**
	 */
	@Override
	public void setVideoGalleryVideos(long galleryId, long[] videoIds) {
		videoGalleryPersistence.setVideos(galleryId, videoIds);
	}

	/**
	 * Returns the video local service.
	 *
	 * @return the video local service
	 */
	public VideoLocalService getVideoLocalService() {
		return videoLocalService;
	}

	/**
	 * Sets the video local service.
	 *
	 * @param videoLocalService the video local service
	 */
	public void setVideoLocalService(VideoLocalService videoLocalService) {
		this.videoLocalService = videoLocalService;
	}

	/**
	 * Returns the video persistence.
	 *
	 * @return the video persistence
	 */
	public VideoPersistence getVideoPersistence() {
		return videoPersistence;
	}

	/**
	 * Sets the video persistence.
	 *
	 * @param videoPersistence the video persistence
	 */
	public void setVideoPersistence(VideoPersistence videoPersistence) {
		this.videoPersistence = videoPersistence;
	}

	/**
	 * Returns the video gallery local service.
	 *
	 * @return the video gallery local service
	 */
	public eu.strasbourg.service.video.service.VideoGalleryLocalService
		getVideoGalleryLocalService() {

		return videoGalleryLocalService;
	}

	/**
	 * Sets the video gallery local service.
	 *
	 * @param videoGalleryLocalService the video gallery local service
	 */
	public void setVideoGalleryLocalService(
		eu.strasbourg.service.video.service.VideoGalleryLocalService
			videoGalleryLocalService) {

		this.videoGalleryLocalService = videoGalleryLocalService;
	}

	/**
	 * Returns the video gallery persistence.
	 *
	 * @return the video gallery persistence
	 */
	public VideoGalleryPersistence getVideoGalleryPersistence() {
		return videoGalleryPersistence;
	}

	/**
	 * Sets the video gallery persistence.
	 *
	 * @param videoGalleryPersistence the video gallery persistence
	 */
	public void setVideoGalleryPersistence(
		VideoGalleryPersistence videoGalleryPersistence) {

		this.videoGalleryPersistence = videoGalleryPersistence;
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
		VideoLocalServiceUtil.setService(videoLocalService);
	}

	public void destroy() {
		VideoLocalServiceUtil.setService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return VideoLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Video.class;
	}

	protected String getModelClassName() {
		return Video.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = videoPersistence.getDataSource();

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

	@BeanReference(type = VideoLocalService.class)
	protected VideoLocalService videoLocalService;

	@BeanReference(type = VideoPersistence.class)
	protected VideoPersistence videoPersistence;

	@BeanReference(
		type = eu.strasbourg.service.video.service.VideoGalleryLocalService.class
	)
	protected eu.strasbourg.service.video.service.VideoGalleryLocalService
		videoGalleryLocalService;

	@BeanReference(type = VideoGalleryPersistence.class)
	protected VideoGalleryPersistence videoGalleryPersistence;

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
		VideoLocalServiceBaseImpl.class);

}