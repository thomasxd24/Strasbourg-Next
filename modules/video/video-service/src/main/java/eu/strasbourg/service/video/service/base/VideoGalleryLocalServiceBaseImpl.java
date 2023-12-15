/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.video.service.base;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.asset.link.service.persistence.AssetLinkPersistence;
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

import eu.strasbourg.service.video.model.VideoGallery;
import eu.strasbourg.service.video.service.VideoGalleryLocalService;
import eu.strasbourg.service.video.service.VideoGalleryLocalServiceUtil;
import eu.strasbourg.service.video.service.persistence.VideoGalleryPersistence;
import eu.strasbourg.service.video.service.persistence.VideoPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the video gallery local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.video.service.impl.VideoGalleryLocalServiceImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see eu.strasbourg.service.video.service.impl.VideoGalleryLocalServiceImpl
 * @generated
 */
public abstract class VideoGalleryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements IdentifiableOSGiService, VideoGalleryLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>VideoGalleryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>VideoGalleryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the video gallery to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param videoGallery the video gallery
	 * @return the video gallery that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public VideoGallery addVideoGallery(VideoGallery videoGallery) {
		videoGallery.setNew(true);

		return videoGalleryPersistence.update(videoGallery);
	}

	/**
	 * Creates a new video gallery with the primary key. Does not add the video gallery to the database.
	 *
	 * @param galleryId the primary key for the new video gallery
	 * @return the new video gallery
	 */
	@Override
	@Transactional(enabled = false)
	public VideoGallery createVideoGallery(long galleryId) {
		return videoGalleryPersistence.create(galleryId);
	}

	/**
	 * Deletes the video gallery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param galleryId the primary key of the video gallery
	 * @return the video gallery that was removed
	 * @throws PortalException if a video gallery with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public VideoGallery deleteVideoGallery(long galleryId)
		throws PortalException {

		return videoGalleryPersistence.remove(galleryId);
	}

	/**
	 * Deletes the video gallery from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param videoGallery the video gallery
	 * @return the video gallery that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public VideoGallery deleteVideoGallery(VideoGallery videoGallery) {
		return videoGalleryPersistence.remove(videoGallery);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return videoGalleryPersistence.dslQuery(dslQuery);
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
			VideoGallery.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return videoGalleryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoGalleryModelImpl</code>.
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

		return videoGalleryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoGalleryModelImpl</code>.
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

		return videoGalleryPersistence.findWithDynamicQuery(
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
		return videoGalleryPersistence.countWithDynamicQuery(dynamicQuery);
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

		return videoGalleryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public VideoGallery fetchVideoGallery(long galleryId) {
		return videoGalleryPersistence.fetchByPrimaryKey(galleryId);
	}

	/**
	 * Returns the video gallery matching the UUID and group.
	 *
	 * @param uuid the video gallery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching video gallery, or <code>null</code> if a matching video gallery could not be found
	 */
	@Override
	public VideoGallery fetchVideoGalleryByUuidAndGroupId(
		String uuid, long groupId) {

		return videoGalleryPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the video gallery with the primary key.
	 *
	 * @param galleryId the primary key of the video gallery
	 * @return the video gallery
	 * @throws PortalException if a video gallery with the primary key could not be found
	 */
	@Override
	public VideoGallery getVideoGallery(long galleryId) throws PortalException {
		return videoGalleryPersistence.findByPrimaryKey(galleryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(videoGalleryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(VideoGallery.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("galleryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			videoGalleryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(VideoGallery.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("galleryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(videoGalleryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(VideoGallery.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("galleryId");
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
									VideoGallery.class.getName());

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
			new ActionableDynamicQuery.PerformActionMethod<VideoGallery>() {

				@Override
				public void performAction(VideoGallery videoGallery)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, videoGallery);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(VideoGallery.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return videoGalleryPersistence.create(
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
				"Implement VideoGalleryLocalServiceImpl#deleteVideoGallery(VideoGallery) to avoid orphaned data");
		}

		return videoGalleryLocalService.deleteVideoGallery(
			(VideoGallery)persistedModel);
	}

	@Override
	public BasePersistence<VideoGallery> getBasePersistence() {
		return videoGalleryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return videoGalleryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the video galleries matching the UUID and company.
	 *
	 * @param uuid the UUID of the video galleries
	 * @param companyId the primary key of the company
	 * @return the matching video galleries, or an empty list if no matches were found
	 */
	@Override
	public List<VideoGallery> getVideoGalleriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return videoGalleryPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of video galleries matching the UUID and company.
	 *
	 * @param uuid the UUID of the video galleries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of video galleries
	 * @param end the upper bound of the range of video galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching video galleries, or an empty list if no matches were found
	 */
	@Override
	public List<VideoGallery> getVideoGalleriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VideoGallery> orderByComparator) {

		return videoGalleryPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the video gallery matching the UUID and group.
	 *
	 * @param uuid the video gallery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching video gallery
	 * @throws PortalException if a matching video gallery could not be found
	 */
	@Override
	public VideoGallery getVideoGalleryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return videoGalleryPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the video galleries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video galleries
	 * @param end the upper bound of the range of video galleries (not inclusive)
	 * @return the range of video galleries
	 */
	@Override
	public List<VideoGallery> getVideoGalleries(int start, int end) {
		return videoGalleryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of video galleries.
	 *
	 * @return the number of video galleries
	 */
	@Override
	public int getVideoGalleriesCount() {
		return videoGalleryPersistence.countAll();
	}

	/**
	 * Updates the video gallery in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param videoGallery the video gallery
	 * @return the video gallery that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public VideoGallery updateVideoGallery(VideoGallery videoGallery) {
		return videoGalleryPersistence.update(videoGallery);
	}

	/**
	 */
	@Override
	public boolean addVideoVideoGallery(long videoId, long galleryId) {
		return videoPersistence.addVideoGallery(videoId, galleryId);
	}

	/**
	 */
	@Override
	public boolean addVideoVideoGallery(
		long videoId, VideoGallery videoGallery) {

		return videoPersistence.addVideoGallery(videoId, videoGallery);
	}

	/**
	 */
	@Override
	public boolean addVideoVideoGalleries(long videoId, long[] galleryIds) {
		return videoPersistence.addVideoGalleries(videoId, galleryIds);
	}

	/**
	 */
	@Override
	public boolean addVideoVideoGalleries(
		long videoId, List<VideoGallery> videoGalleries) {

		return videoPersistence.addVideoGalleries(videoId, videoGalleries);
	}

	/**
	 */
	@Override
	public void clearVideoVideoGalleries(long videoId) {
		videoPersistence.clearVideoGalleries(videoId);
	}

	/**
	 */
	@Override
	public void deleteVideoVideoGallery(long videoId, long galleryId) {
		videoPersistence.removeVideoGallery(videoId, galleryId);
	}

	/**
	 */
	@Override
	public void deleteVideoVideoGallery(
		long videoId, VideoGallery videoGallery) {

		videoPersistence.removeVideoGallery(videoId, videoGallery);
	}

	/**
	 */
	@Override
	public void deleteVideoVideoGalleries(long videoId, long[] galleryIds) {
		videoPersistence.removeVideoGalleries(videoId, galleryIds);
	}

	/**
	 */
	@Override
	public void deleteVideoVideoGalleries(
		long videoId, List<VideoGallery> videoGalleries) {

		videoPersistence.removeVideoGalleries(videoId, videoGalleries);
	}

	/**
	 * Returns the videoIds of the videos associated with the video gallery.
	 *
	 * @param galleryId the galleryId of the video gallery
	 * @return long[] the videoIds of videos associated with the video gallery
	 */
	@Override
	public long[] getVideoPrimaryKeys(long galleryId) {
		return videoGalleryPersistence.getVideoPrimaryKeys(galleryId);
	}

	/**
	 */
	@Override
	public List<VideoGallery> getVideoVideoGalleries(long videoId) {
		return videoPersistence.getVideoGalleries(videoId);
	}

	/**
	 */
	@Override
	public List<VideoGallery> getVideoVideoGalleries(
		long videoId, int start, int end) {

		return videoPersistence.getVideoGalleries(videoId, start, end);
	}

	/**
	 */
	@Override
	public List<VideoGallery> getVideoVideoGalleries(
		long videoId, int start, int end,
		OrderByComparator<VideoGallery> orderByComparator) {

		return videoPersistence.getVideoGalleries(
			videoId, start, end, orderByComparator);
	}

	/**
	 */
	@Override
	public int getVideoVideoGalleriesCount(long videoId) {
		return videoPersistence.getVideoGalleriesSize(videoId);
	}

	/**
	 */
	@Override
	public boolean hasVideoVideoGallery(long videoId, long galleryId) {
		return videoPersistence.containsVideoGallery(videoId, galleryId);
	}

	/**
	 */
	@Override
	public boolean hasVideoVideoGalleries(long videoId) {
		return videoPersistence.containsVideoGalleries(videoId);
	}

	/**
	 */
	@Override
	public void setVideoVideoGalleries(long videoId, long[] galleryIds) {
		videoPersistence.setVideoGalleries(videoId, galleryIds);
	}

	/**
	 * Returns the video local service.
	 *
	 * @return the video local service
	 */
	public eu.strasbourg.service.video.service.VideoLocalService
		getVideoLocalService() {

		return videoLocalService;
	}

	/**
	 * Sets the video local service.
	 *
	 * @param videoLocalService the video local service
	 */
	public void setVideoLocalService(
		eu.strasbourg.service.video.service.VideoLocalService
			videoLocalService) {

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
	public VideoGalleryLocalService getVideoGalleryLocalService() {
		return videoGalleryLocalService;
	}

	/**
	 * Sets the video gallery local service.
	 *
	 * @param videoGalleryLocalService the video gallery local service
	 */
	public void setVideoGalleryLocalService(
		VideoGalleryLocalService videoGalleryLocalService) {

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
	 * Returns the asset link local service.
	 *
	 * @return the asset link local service
	 */
	public com.liferay.asset.link.service.AssetLinkLocalService
		getAssetLinkLocalService() {

		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.asset.link.service.AssetLinkLocalService
			assetLinkLocalService) {

		this.assetLinkLocalService = assetLinkLocalService;
	}

	/**
	 * Returns the asset link persistence.
	 *
	 * @return the asset link persistence
	 */
	public AssetLinkPersistence getAssetLinkPersistence() {
		return assetLinkPersistence;
	}

	/**
	 * Sets the asset link persistence.
	 *
	 * @param assetLinkPersistence the asset link persistence
	 */
	public void setAssetLinkPersistence(
		AssetLinkPersistence assetLinkPersistence) {

		this.assetLinkPersistence = assetLinkPersistence;
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
		VideoGalleryLocalServiceUtil.setService(videoGalleryLocalService);
	}

	public void destroy() {
		VideoGalleryLocalServiceUtil.setService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return VideoGalleryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return VideoGallery.class;
	}

	protected String getModelClassName() {
		return VideoGallery.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = videoGalleryPersistence.getDataSource();

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
		type = eu.strasbourg.service.video.service.VideoLocalService.class
	)
	protected eu.strasbourg.service.video.service.VideoLocalService
		videoLocalService;

	@BeanReference(type = VideoPersistence.class)
	protected VideoPersistence videoPersistence;

	@BeanReference(type = VideoGalleryLocalService.class)
	protected VideoGalleryLocalService videoGalleryLocalService;

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
		type = com.liferay.asset.link.service.AssetLinkLocalService.class
	)
	protected com.liferay.asset.link.service.AssetLinkLocalService
		assetLinkLocalService;

	@ServiceReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetTagLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@ServiceReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		VideoGalleryLocalServiceBaseImpl.class);

}