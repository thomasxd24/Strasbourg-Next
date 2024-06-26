/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PlacitPlaceLocalService}.
 *
 * @author Cedric Henry
 * @see PlacitPlaceLocalService
 * @generated
 */
public class PlacitPlaceLocalServiceWrapper
	implements PlacitPlaceLocalService,
			   ServiceWrapper<PlacitPlaceLocalService> {

	public PlacitPlaceLocalServiceWrapper() {
		this(null);
	}

	public PlacitPlaceLocalServiceWrapper(
		PlacitPlaceLocalService placitPlaceLocalService) {

		_placitPlaceLocalService = placitPlaceLocalService;
	}

	/**
	 * Adds the placit place to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlacitPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placitPlace the placit place
	 * @return the placit place that was added
	 */
	@Override
	public eu.strasbourg.service.project.model.PlacitPlace addPlacitPlace(
		eu.strasbourg.service.project.model.PlacitPlace placitPlace) {

		return _placitPlaceLocalService.addPlacitPlace(placitPlace);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placitPlaceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new placit place with the primary key. Does not add the placit place to the database.
	 *
	 * @param placitPlaceId the primary key for the new placit place
	 * @return the new placit place
	 */
	@Override
	public eu.strasbourg.service.project.model.PlacitPlace createPlacitPlace(
		long placitPlaceId) {

		return _placitPlaceLocalService.createPlacitPlace(placitPlaceId);
	}

	/**
	 * Crée un lieu Placit vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.project.model.PlacitPlace createPlacitPlace(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placitPlaceLocalService.createPlacitPlace(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placitPlaceLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the placit place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlacitPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placitPlaceId the primary key of the placit place
	 * @return the placit place that was removed
	 * @throws PortalException if a placit place with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.PlacitPlace deletePlacitPlace(
			long placitPlaceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placitPlaceLocalService.deletePlacitPlace(placitPlaceId);
	}

	/**
	 * Deletes the placit place from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlacitPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placitPlace the placit place
	 * @return the placit place that was removed
	 */
	@Override
	public eu.strasbourg.service.project.model.PlacitPlace deletePlacitPlace(
		eu.strasbourg.service.project.model.PlacitPlace placitPlace) {

		return _placitPlaceLocalService.deletePlacitPlace(placitPlace);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _placitPlaceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _placitPlaceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _placitPlaceLocalService.dynamicQuery();
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

		return _placitPlaceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.PlacitPlaceModelImpl</code>.
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

		return _placitPlaceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.PlacitPlaceModelImpl</code>.
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

		return _placitPlaceLocalService.dynamicQuery(
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

		return _placitPlaceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _placitPlaceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.project.model.PlacitPlace fetchPlacitPlace(
		long placitPlaceId) {

		return _placitPlaceLocalService.fetchPlacitPlace(placitPlaceId);
	}

	/**
	 * Returns the placit place matching the UUID and group.
	 *
	 * @param uuid the placit place's UUID
	 * @param groupId the primary key of the group
	 * @return the matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.PlacitPlace
		fetchPlacitPlaceByUuidAndGroupId(String uuid, long groupId) {

		return _placitPlaceLocalService.fetchPlacitPlaceByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Lance une recherche par liste d'ids
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		findByIds(java.util.List<Long> placitPlaceIds) {

		return _placitPlaceLocalService.findByIds(placitPlaceIds);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return _placitPlaceLocalService.findByKeyword(
			keyword, groupId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _placitPlaceLocalService.getActionableDynamicQuery();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return _placitPlaceLocalService.getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne les lieux d'une participation
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getByBudgetParticipatif(long budgetParticipatifId) {

		return _placitPlaceLocalService.getByBudgetParticipatif(
			budgetParticipatifId);
	}

	/**
	 * Retourne tous les lieux Placit d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getByGroupId(long groupId) {

		return _placitPlaceLocalService.getByGroupId(groupId);
	}

	/**
	 * Retourne les lieux d'une initiative
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getByInitiative(long initiativeId) {

		return _placitPlaceLocalService.getByInitiative(initiativeId);
	}

	/**
	 * Retourne les lieux d'une participation
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getByParticipation(long participationId) {

		return _placitPlaceLocalService.getByParticipation(participationId);
	}

	/**
	 * Retourne les lieux d'une participation
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getByPetition(long petitionId) {

		return _placitPlaceLocalService.getByPetition(petitionId);
	}

	/**
	 * Retourne les lieux d'un projet
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getByProject(long projectId) {

		return _placitPlaceLocalService.getByProject(projectId);
	}

	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getBySaisineObservatoire(long saisineObservatoireId) {

		return _placitPlaceLocalService.getBySaisineObservatoire(
			saisineObservatoireId);
	}

	/**
	 * Retourne toutes les lieux de cours d'un lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getBySigId(String sigId) {

		return _placitPlaceLocalService.getBySigId(sigId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _placitPlaceLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _placitPlaceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _placitPlaceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placitPlaceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the placit place with the primary key.
	 *
	 * @param placitPlaceId the primary key of the placit place
	 * @return the placit place
	 * @throws PortalException if a placit place with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.PlacitPlace getPlacitPlace(
			long placitPlaceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placitPlaceLocalService.getPlacitPlace(placitPlaceId);
	}

	/**
	 * Returns the placit place matching the UUID and group.
	 *
	 * @param uuid the placit place's UUID
	 * @param groupId the primary key of the group
	 * @return the matching placit place
	 * @throws PortalException if a matching placit place could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.PlacitPlace
			getPlacitPlaceByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placitPlaceLocalService.getPlacitPlaceByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the placit places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of placit places
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlaces(int start, int end) {

		return _placitPlaceLocalService.getPlacitPlaces(start, end);
	}

	/**
	 * Returns all the placit places matching the UUID and company.
	 *
	 * @param uuid the UUID of the placit places
	 * @param companyId the primary key of the company
	 * @return the matching placit places, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlacesByUuidAndCompanyId(String uuid, long companyId) {

		return _placitPlaceLocalService.getPlacitPlacesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of placit places matching the UUID and company.
	 *
	 * @param uuid the UUID of the placit places
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching placit places, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlacesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.project.model.PlacitPlace>
					orderByComparator) {

		return _placitPlaceLocalService.getPlacitPlacesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of placit places.
	 *
	 * @return the number of placit places
	 */
	@Override
	public int getPlacitPlacesCount() {
		return _placitPlaceLocalService.getPlacitPlacesCount();
	}

	/**
	 * Supprime une entité
	 */
	@Override
	public eu.strasbourg.service.project.model.PlacitPlace removePlacitPlace(
			long placitPlaceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placitPlaceLocalService.removePlacitPlace(placitPlaceId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	@Override
	public com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return _placitPlaceLocalService.search(searchContext);
	}

	/**
	 * Updates the placit place in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlacitPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placitPlace the placit place
	 * @return the placit place that was updated
	 */
	@Override
	public eu.strasbourg.service.project.model.PlacitPlace updatePlacitPlace(
		eu.strasbourg.service.project.model.PlacitPlace placitPlace) {

		return _placitPlaceLocalService.updatePlacitPlace(placitPlace);
	}

	/**
	 * Met à jour un lieu Placit et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.project.model.PlacitPlace updatePlacitPlace(
			eu.strasbourg.service.project.model.PlacitPlace placitPlace,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placitPlaceLocalService.updatePlacitPlace(placitPlace, sc);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _placitPlaceLocalService.getBasePersistence();
	}

	@Override
	public PlacitPlaceLocalService getWrappedService() {
		return _placitPlaceLocalService;
	}

	@Override
	public void setWrappedService(
		PlacitPlaceLocalService placitPlaceLocalService) {

		_placitPlaceLocalService = placitPlaceLocalService;
	}

	private PlacitPlaceLocalService _placitPlaceLocalService;

}