/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.place.model.Place;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Place. This utility wraps
 * <code>eu.strasbourg.service.place.service.impl.PlaceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Angelique Zunino Champougny
 * @see PlaceLocalService
 * @generated
 */
public class PlaceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.place.service.impl.PlaceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the place to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param place the place
	 * @return the place that was added
	 */
	public static Place addPlace(Place place) {
		return getService().addPlace(place);
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
	 * Creates a new place with the primary key. Does not add the place to the database.
	 *
	 * @param placeId the primary key for the new place
	 * @return the new place
	 */
	public static Place createPlace(long placeId) {
		return getService().createPlace(placeId);
	}

	/**
	 * Crée un lieu vide avec une PK, non ajouté à la base de donnée
	 */
	public static Place createPlace(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createPlace(sc);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placeId the primary key of the place
	 * @return the place that was removed
	 * @throws PortalException if a place with the primary key could not be found
	 */
	public static Place deletePlace(long placeId) throws PortalException {
		return getService().deletePlace(placeId);
	}

	/**
	 * Deletes the place from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param place the place
	 * @return the place that was removed
	 */
	public static Place deletePlace(Place place) {
		return getService().deletePlace(place);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.PlaceModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.PlaceModelImpl</code>.
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

	public static Place fetchPlace(long placeId) {
		return getService().fetchPlace(placeId);
	}

	/**
	 * Returns the place matching the UUID and group.
	 *
	 * @param uuid the place's UUID
	 * @param groupId the primary key of the group
	 * @return the matching place, or <code>null</code> if a matching place could not be found
	 */
	public static Place fetchPlaceByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchPlaceByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche des places par identifiants
	 *
	 * @param idsPlace : liste ids places
	 * @return
	 */
	public static List<Place> findByIds(List<Long> idsPlace) {
		return getService().findByIds(idsPlace);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	public static List<Place> findByKeyword(
		String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Compte de la recherche par mots-clés
	 */
	public static long findByKeywordCount(String keyword, long groupId) {
		return getService().findByKeywordCount(keyword, groupId);
	}

	/**
	 * Lance une recherche par nom
	 *
	 * @throws NoSuchPlaceException
	 */
	public static List<Place> findByName(String name)
		throws eu.strasbourg.service.place.exception.NoSuchPlaceException {

		return getService().findByName(name);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne les vocabulaires rattrachés à ce type d'entité pour un groupe
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne les lieux d'un groupe
	 */
	public static List<Place> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne les lieux rattachés à un tarif
	 */
	public static List<Place> getByPriceId(long priceId) {
		return getService().getByPriceId(priceId);
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
	 * Returns the place with the primary key.
	 *
	 * @param placeId the primary key of the place
	 * @return the place
	 * @throws PortalException if a place with the primary key could not be found
	 */
	public static Place getPlace(long placeId) throws PortalException {
		return getService().getPlace(placeId);
	}

	public static Place getPlaceBySIGId(String idSIG) {
		return getService().getPlaceBySIGId(idSIG);
	}

	/**
	 * Returns the place matching the UUID and group.
	 *
	 * @param uuid the place's UUID
	 * @param groupId the primary key of the group
	 * @return the matching place
	 * @throws PortalException if a matching place could not be found
	 */
	public static Place getPlaceByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getPlaceByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Récupère le nombre d'emplacements approuvés associés à une catégorie d'actifs spécifique
	 * au sein d'un groupe d'entreprise donné.
	 *
	 * @param assetCategory La catégorie d'actifs pour laquelle compter les emplacements.
	 * @param companyGroupId L'identifiant du groupe d'entreprise dans lequel effectuer la recherche.
	 * @return Le nombre d'emplacements approuvés associés à la catégorie d'actifs donnée.
	 * @throws PortalException En cas d'erreur lors de la récupération des données.
	 */
	public static Integer getPlaceCountByAssetCategory(
			com.liferay.asset.kernel.model.AssetCategory assetCategory,
			long companyGroupId)
		throws PortalException {

		return getService().getPlaceCountByAssetCategory(
			assetCategory, companyGroupId);
	}

	/**
	 * Returns a range of all the places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @return the range of places
	 */
	public static List<Place> getPlaces(int start, int end) {
		return getService().getPlaces(start, end);
	}

	/**
	 * Returns all the places matching the UUID and company.
	 *
	 * @param uuid the UUID of the places
	 * @param companyId the primary key of the company
	 * @return the matching places, or an empty list if no matches were found
	 */
	public static List<Place> getPlacesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPlacesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of places matching the UUID and company.
	 *
	 * @param uuid the UUID of the places
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching places, or an empty list if no matches were found
	 */
	public static List<Place> getPlacesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Place> orderByComparator) {

		return getService().getPlacesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of places.
	 *
	 * @return the number of places
	 */
	public static int getPlacesCount() {
		return getService().getPlacesCount();
	}

	/**
	 * Supprime un lieu
	 */
	public static Place removePlace(long placeId) throws PortalException {
		return getService().removePlace(placeId);
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
	 * Met à jour le jsonHoraire d'un lieu
	 */
	public static Place updateJsonHoraire(Place place) throws PortalException {
		return getService().updateJsonHoraire(place);
	}

	/**
	 * Updates the place in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param place the place
	 * @return the place that was updated
	 */
	public static Place updatePlace(Place place) {
		return getService().updatePlace(place);
	}

	/**
	 * Met à jour un lieu et l'enregistre en base de données
	 */
	public static Place updatePlace(
			Place place, com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updatePlace(place, sc);
	}

	public static void updateRealTime()
		throws com.liferay.portal.kernel.search.SearchException {

		getService().updateRealTime();
	}

	public static void updateRealTime(
			com.liferay.portal.kernel.json.JSONArray parkingJsonArray)
		throws com.liferay.portal.kernel.search.SearchException {

		getService().updateRealTime(parkingJsonArray);
	}

	public static void updateRealTime(
		Place place, String type, long occupation, long available,
		long capacity, String status, java.util.Date rtLastUpdate) {

		getService().updateRealTime(
			place, type, occupation, available, capacity, status, rtLastUpdate);
	}

	/**
	 * Met à jour le statut du lieu par le framework workflow
	 */
	public static Place updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	/**
	 * Met à jour le statut du lieu "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(Place place, int status)
		throws PortalException {

		getService().updateStatus(place, status);
	}

	public static PlaceLocalService getService() {
		return _service;
	}

	public static void setService(PlaceLocalService service) {
		_service = service;
	}

	private static volatile PlaceLocalService _service;

}