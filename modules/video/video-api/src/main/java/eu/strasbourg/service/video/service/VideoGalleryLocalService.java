/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.video.service;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.video.model.VideoGallery;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for VideoGallery. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author BenjaminBini
 * @see VideoGalleryLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"model.class.name=eu.strasbourg.service.video.model.VideoGallery"
	}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface VideoGalleryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.video.service.impl.VideoGalleryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the video gallery local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link VideoGalleryLocalServiceUtil} if injection and service tracking are not available.
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
	public VideoGallery addVideoGallery(VideoGallery videoGallery);

	public boolean addVideoVideoGalleries(
		long videoId, List<VideoGallery> videoGalleries);

	public boolean addVideoVideoGalleries(long videoId, long[] galleryIds);

	public boolean addVideoVideoGallery(long videoId, long galleryId);

	public boolean addVideoVideoGallery(
		long videoId, VideoGallery videoGallery);

	/**
	 * Modifie le statut de toutes les vidéos au statut "SCHEDULED" qui ont une
	 * date de publication dans le futur
	 */
	public void checkGalleries() throws PortalException;

	public void clearVideoVideoGalleries(long videoId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new video gallery with the primary key. Does not add the video gallery to the database.
	 *
	 * @param galleryId the primary key for the new video gallery
	 * @return the new video gallery
	 */
	@Transactional(enabled = false)
	public VideoGallery createVideoGallery(long galleryId);

	/**
	 * Crée un lien vide avec une PK, non ajouté à la base de donnée
	 */
	public VideoGallery createVideoGallery(ServiceContext sc)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	public VideoGallery deleteVideoGallery(long galleryId)
		throws PortalException;

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
	public VideoGallery deleteVideoGallery(VideoGallery videoGallery);

	public void deleteVideoVideoGalleries(
		long videoId, List<VideoGallery> videoGalleries);

	public void deleteVideoVideoGalleries(long videoId, long[] galleryIds);

	public void deleteVideoVideoGallery(long videoId, long galleryId);

	public void deleteVideoVideoGallery(
		long videoId, VideoGallery videoGallery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public VideoGallery fetchVideoGallery(long galleryId);

	/**
	 * Returns the video gallery matching the UUID and group.
	 *
	 * @param uuid the video gallery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching video gallery, or <code>null</code> if a matching video gallery could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public VideoGallery fetchVideoGalleryByUuidAndGroupId(
		String uuid, long groupId);

	/**
	 * Recherche par mots clés
	 */
	public List<VideoGallery> findByKeyword(
		String keyword, long groupId, int start, int end);

	/**
	 * Compte de la recherche par mots-clés
	 */
	public long findByKeywordCount(String keyword, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Retourne la liste des vocabulaires rattachés à l'entité
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AssetVocabulary> getAttachedVocabularies(long groupId);

	/**
	 * Retourne toutes les galeries éditions d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<VideoGallery> getByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<VideoGallery> getVideoGalleries(int start, int end);

	/**
	 * Returns all the video galleries matching the UUID and company.
	 *
	 * @param uuid the UUID of the video galleries
	 * @param companyId the primary key of the company
	 * @return the matching video galleries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<VideoGallery> getVideoGalleriesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<VideoGallery> getVideoGalleriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VideoGallery> orderByComparator);

	/**
	 * Returns the number of video galleries.
	 *
	 * @return the number of video galleries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVideoGalleriesCount();

	/**
	 * Returns the video gallery with the primary key.
	 *
	 * @param galleryId the primary key of the video gallery
	 * @return the video gallery
	 * @throws PortalException if a video gallery with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public VideoGallery getVideoGallery(long galleryId) throws PortalException;

	/**
	 * Returns the video gallery matching the UUID and group.
	 *
	 * @param uuid the video gallery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching video gallery
	 * @throws PortalException if a matching video gallery could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public VideoGallery getVideoGalleryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns the videoIds of the videos associated with the video gallery.
	 *
	 * @param galleryId the galleryId of the video gallery
	 * @return long[] the videoIds of videos associated with the video gallery
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getVideoPrimaryKeys(long galleryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<VideoGallery> getVideoVideoGalleries(long videoId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<VideoGallery> getVideoVideoGalleries(
		long videoId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<VideoGallery> getVideoVideoGalleries(
		long videoId, int start, int end,
		OrderByComparator<VideoGallery> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVideoVideoGalleriesCount(long videoId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasVideoVideoGalleries(long videoId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasVideoVideoGallery(long videoId, long galleryId);

	/**
	 * Delete an Video Gallery
	 *
	 * @param galleryId
	 The ID of the video gallery to delete
	 * @return The deleted VideoGallery
	 * @throws PortalException
	 */
	public VideoGallery removeGallery(long galleryId) throws PortalException;

	/**
	 * Recherche par le moteur de recherche
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hits search(SearchContext searchContext) throws SearchException;

	public void setVideoVideoGalleries(long videoId, long[] galleryIds);

	/**
	 * Met à jour le statut de la galerie par le framework workflow
	 */
	public VideoGallery updateStatus(
			long userId, long entryId, int status, ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException;

	/**
	 * Met à jour le statut de la galerie "manuellement" (pas via le workflow)
	 */
	public void updateStatus(VideoGallery gallery, int status)
		throws PortalException;

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
	public VideoGallery updateVideoGallery(VideoGallery videoGallery);

	/**
	 * Met à jour un lien et l'enregistre en base de données
	 */
	public VideoGallery updateVideoGallery(
			VideoGallery gallery, ServiceContext sc)
		throws PortalException;

}