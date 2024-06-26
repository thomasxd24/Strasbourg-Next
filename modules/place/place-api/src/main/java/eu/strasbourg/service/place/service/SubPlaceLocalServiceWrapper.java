/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SubPlaceLocalService}.
 *
 * @author Angelique Zunino Champougny
 * @see SubPlaceLocalService
 * @generated
 */
public class SubPlaceLocalServiceWrapper
	implements ServiceWrapper<SubPlaceLocalService>, SubPlaceLocalService {

	public SubPlaceLocalServiceWrapper() {
		this(null);
	}

	public SubPlaceLocalServiceWrapper(
		SubPlaceLocalService subPlaceLocalService) {

		_subPlaceLocalService = subPlaceLocalService;
	}

	/**
	 * Adds the sub place to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subPlace the sub place
	 * @return the sub place that was added
	 */
	@Override
	public eu.strasbourg.service.place.model.SubPlace addSubPlace(
		eu.strasbourg.service.place.model.SubPlace subPlace) {

		return _subPlaceLocalService.addSubPlace(subPlace);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subPlaceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sub place with the primary key. Does not add the sub place to the database.
	 *
	 * @param subPlaceId the primary key for the new sub place
	 * @return the new sub place
	 */
	@Override
	public eu.strasbourg.service.place.model.SubPlace createSubPlace(
		long subPlaceId) {

		return _subPlaceLocalService.createSubPlace(subPlaceId);
	}

	/**
	 * Crée un sous-lieu vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.place.model.SubPlace createSubPlace(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subPlaceLocalService.createSubPlace(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subPlaceLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sub place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subPlaceId the primary key of the sub place
	 * @return the sub place that was removed
	 * @throws PortalException if a sub place with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.place.model.SubPlace deleteSubPlace(
			long subPlaceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subPlaceLocalService.deleteSubPlace(subPlaceId);
	}

	/**
	 * Deletes the sub place from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subPlace the sub place
	 * @return the sub place that was removed
	 */
	@Override
	public eu.strasbourg.service.place.model.SubPlace deleteSubPlace(
		eu.strasbourg.service.place.model.SubPlace subPlace) {

		return _subPlaceLocalService.deleteSubPlace(subPlace);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _subPlaceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _subPlaceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subPlaceLocalService.dynamicQuery();
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

		return _subPlaceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.SubPlaceModelImpl</code>.
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

		return _subPlaceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.SubPlaceModelImpl</code>.
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

		return _subPlaceLocalService.dynamicQuery(
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

		return _subPlaceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _subPlaceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.place.model.SubPlace fetchSubPlace(
		long subPlaceId) {

		return _subPlaceLocalService.fetchSubPlace(subPlaceId);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.SubPlace>
		findByKeyword(String keyword, int start, int end) {

		return _subPlaceLocalService.findByKeyword(keyword, start, end);
	}

	/**
	 * Compte de la recherche par mots-clés
	 */
	@Override
	public long findByKeywordCount(String keyword) {
		return _subPlaceLocalService.findByKeywordCount(keyword);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _subPlaceLocalService.getActionableDynamicQuery();
	}

	/**
	 * Retourne les SubPlace rattachés à un lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.SubPlace>
		getByPlaceId(long placeId) {

		return _subPlaceLocalService.getByPlaceId(placeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _subPlaceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subPlaceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subPlaceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sub place with the primary key.
	 *
	 * @param subPlaceId the primary key of the sub place
	 * @return the sub place
	 * @throws PortalException if a sub place with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.place.model.SubPlace getSubPlace(
			long subPlaceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subPlaceLocalService.getSubPlace(subPlaceId);
	}

	/**
	 * Returns a range of all the sub places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.SubPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub places
	 * @param end the upper bound of the range of sub places (not inclusive)
	 * @return the range of sub places
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.SubPlace>
		getSubPlaces(int start, int end) {

		return _subPlaceLocalService.getSubPlaces(start, end);
	}

	/**
	 * Returns the number of sub places.
	 *
	 * @return the number of sub places
	 */
	@Override
	public int getSubPlacesCount() {
		return _subPlaceLocalService.getSubPlacesCount();
	}

	/**
	 * Supprime un sous-lieu
	 */
	@Override
	public eu.strasbourg.service.place.model.SubPlace removeSubPlace(
			long subPlaceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subPlaceLocalService.removeSubPlace(subPlaceId);
	}

	/**
	 * Met à jour le statut du sous-lieu par le framework workflow
	 */
	@Override
	public eu.strasbourg.service.place.model.SubPlace updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subPlaceLocalService.updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	/**
	 * Met à jour le statut du sous-lieu "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(
			long userId, eu.strasbourg.service.place.model.SubPlace subPlace,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		_subPlaceLocalService.updateStatus(userId, subPlace, status);
	}

	/**
	 * Updates the sub place in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subPlace the sub place
	 * @return the sub place that was updated
	 */
	@Override
	public eu.strasbourg.service.place.model.SubPlace updateSubPlace(
		eu.strasbourg.service.place.model.SubPlace subPlace) {

		return _subPlaceLocalService.updateSubPlace(subPlace);
	}

	/**
	 * Met à jour un sous-lieu et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.place.model.SubPlace updateSubPlace(
			eu.strasbourg.service.place.model.SubPlace subPlace,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subPlaceLocalService.updateSubPlace(subPlace, sc);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _subPlaceLocalService.getBasePersistence();
	}

	@Override
	public SubPlaceLocalService getWrappedService() {
		return _subPlaceLocalService;
	}

	@Override
	public void setWrappedService(SubPlaceLocalService subPlaceLocalService) {
		_subPlaceLocalService = subPlaceLocalService;
	}

	private SubPlaceLocalService _subPlaceLocalService;

}