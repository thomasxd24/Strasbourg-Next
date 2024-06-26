/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.activity.model.ActivityOrganizer;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ActivityOrganizer. This utility wraps
 * <code>eu.strasbourg.service.activity.service.impl.ActivityOrganizerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityOrganizerLocalService
 * @generated
 */
public class ActivityOrganizerLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.activity.service.impl.ActivityOrganizerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the activity organizer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityOrganizerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityOrganizer the activity organizer
	 * @return the activity organizer that was added
	 */
	public static ActivityOrganizer addActivityOrganizer(
		ActivityOrganizer activityOrganizer) {

		return getService().addActivityOrganizer(activityOrganizer);
	}

	/**
	 * Creates a new activity organizer with the primary key. Does not add the activity organizer to the database.
	 *
	 * @param activityOrganizerId the primary key for the new activity organizer
	 * @return the new activity organizer
	 */
	public static ActivityOrganizer createActivityOrganizer(
		long activityOrganizerId) {

		return getService().createActivityOrganizer(activityOrganizerId);
	}

	/**
	 * Crée une activité vide avec une PK, non ajouté à la base de donnée
	 */
	public static ActivityOrganizer createActivityOrganizer(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createActivityOrganizer(sc);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the activity organizer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityOrganizerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityOrganizer the activity organizer
	 * @return the activity organizer that was removed
	 */
	public static ActivityOrganizer deleteActivityOrganizer(
		ActivityOrganizer activityOrganizer) {

		return getService().deleteActivityOrganizer(activityOrganizer);
	}

	/**
	 * Deletes the activity organizer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityOrganizerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityOrganizerId the primary key of the activity organizer
	 * @return the activity organizer that was removed
	 * @throws PortalException if a activity organizer with the primary key could not be found
	 */
	public static ActivityOrganizer deleteActivityOrganizer(
			long activityOrganizerId)
		throws PortalException {

		return getService().deleteActivityOrganizer(activityOrganizerId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ActivityOrganizer fetchActivityOrganizer(
		long activityOrganizerId) {

		return getService().fetchActivityOrganizer(activityOrganizerId);
	}

	/**
	 * Returns the activity organizer matching the UUID and group.
	 *
	 * @param uuid the activity organizer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity organizer, or <code>null</code> if a matching activity organizer could not be found
	 */
	public static ActivityOrganizer fetchActivityOrganizerByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchActivityOrganizerByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	public static List<ActivityOrganizer> findByKeyword(
		String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Compte de la recherche par mots-clés
	 */
	public static long findByKeywordCount(String keyword, long groupId) {
		return getService().findByKeywordCount(keyword, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the activity organizer with the primary key.
	 *
	 * @param activityOrganizerId the primary key of the activity organizer
	 * @return the activity organizer
	 * @throws PortalException if a activity organizer with the primary key could not be found
	 */
	public static ActivityOrganizer getActivityOrganizer(
			long activityOrganizerId)
		throws PortalException {

		return getService().getActivityOrganizer(activityOrganizerId);
	}

	/**
	 * Returns the activity organizer matching the UUID and group.
	 *
	 * @param uuid the activity organizer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity organizer
	 * @throws PortalException if a matching activity organizer could not be found
	 */
	public static ActivityOrganizer getActivityOrganizerByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getActivityOrganizerByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the activity organizers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @return the range of activity organizers
	 */
	public static List<ActivityOrganizer> getActivityOrganizers(
		int start, int end) {

		return getService().getActivityOrganizers(start, end);
	}

	/**
	 * Returns all the activity organizers matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity organizers
	 * @param companyId the primary key of the company
	 * @return the matching activity organizers, or an empty list if no matches were found
	 */
	public static List<ActivityOrganizer>
		getActivityOrganizersByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getActivityOrganizersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of activity organizers matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity organizers
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching activity organizers, or an empty list if no matches were found
	 */
	public static List<ActivityOrganizer>
		getActivityOrganizersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ActivityOrganizer> orderByComparator) {

		return getService().getActivityOrganizersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of activity organizers.
	 *
	 * @return the number of activity organizers
	 */
	public static int getActivityOrganizersCount() {
		return getService().getActivityOrganizersCount();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les éditions d'un groupe
	 */
	public static List<ActivityOrganizer> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime une entité
	 */
	public static ActivityOrganizer removeActivityOrganizer(
			long activityOrganizerId)
		throws PortalException {

		return getService().removeActivityOrganizer(activityOrganizerId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	public static com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return getService().search(searchContext);
	}

	/**
	 * Updates the activity organizer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityOrganizerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityOrganizer the activity organizer
	 * @return the activity organizer that was updated
	 */
	public static ActivityOrganizer updateActivityOrganizer(
		ActivityOrganizer activityOrganizer) {

		return getService().updateActivityOrganizer(activityOrganizer);
	}

	/**
	 * Met à jour une activité et l'enregistre en base de données
	 */
	public static ActivityOrganizer updateActivityOrganizer(
			ActivityOrganizer activityOrganizer,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateActivityOrganizer(activityOrganizer, sc);
	}

	/**
	 * Met à jour le statut de l'édition par le framework workflow
	 */
	public static ActivityOrganizer updateStatus(
			long userId, long entryId, int status)
		throws PortalException {

		return getService().updateStatus(userId, entryId, status);
	}

	public static ActivityOrganizerLocalService getService() {
		return _service;
	}

	public static void setService(ActivityOrganizerLocalService service) {
		_service = service;
	}

	private static volatile ActivityOrganizerLocalService _service;

}