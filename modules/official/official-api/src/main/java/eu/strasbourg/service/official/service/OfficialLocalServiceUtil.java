/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.official.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.official.model.Official;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Official. This utility wraps
 * <code>eu.strasbourg.service.official.service.impl.OfficialLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author AngeliqueZUNINO
 * @see OfficialLocalService
 * @generated
 */
public class OfficialLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.official.service.impl.OfficialLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the official to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfficialLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param official the official
	 * @return the official that was added
	 */
	public static Official addOfficial(Official official) {
		return getService().addOfficial(official);
	}

	/**
	 * Creates a new official with the primary key. Does not add the official to the database.
	 *
	 * @param officialId the primary key for the new official
	 * @return the new official
	 */
	public static Official createOfficial(long officialId) {
		return getService().createOfficial(officialId);
	}

	/**
	 * Crée un un élu vide avec une PK, non ajouté à la base de donnée
	 */
	public static Official createOfficial(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createOfficial(sc);
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
	 * Deletes the official with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfficialLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param officialId the primary key of the official
	 * @return the official that was removed
	 * @throws PortalException if a official with the primary key could not be found
	 */
	public static Official deleteOfficial(long officialId)
		throws PortalException {

		return getService().deleteOfficial(officialId);
	}

	/**
	 * Deletes the official from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfficialLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param official the official
	 * @return the official that was removed
	 */
	public static Official deleteOfficial(Official official) {
		return getService().deleteOfficial(official);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.official.model.impl.OfficialModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.official.model.impl.OfficialModelImpl</code>.
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

	public static Official fetchOfficial(long officialId) {
		return getService().fetchOfficial(officialId);
	}

	/**
	 * Returns the official matching the UUID and group.
	 *
	 * @param uuid the official's UUID
	 * @param groupId the primary key of the group
	 * @return the matching official, or <code>null</code> if a matching official could not be found
	 */
	public static Official fetchOfficialByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchOfficialByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	public static List<Official> findByKeyword(
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
	 * Retourne les vocabulaires rattrachés à ce type d'entité pour un groupe
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne tous les élus d'un groupe
	 */
	public static List<Official> getByGroupId(long groupId) {
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
	 * Returns the official with the primary key.
	 *
	 * @param officialId the primary key of the official
	 * @return the official
	 * @throws PortalException if a official with the primary key could not be found
	 */
	public static Official getOfficial(long officialId) throws PortalException {
		return getService().getOfficial(officialId);
	}

	/**
	 * Returns the official matching the UUID and group.
	 *
	 * @param uuid the official's UUID
	 * @param groupId the primary key of the group
	 * @return the matching official
	 * @throws PortalException if a matching official could not be found
	 */
	public static Official getOfficialByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getOfficialByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the officials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.official.model.impl.OfficialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @return the range of officials
	 */
	public static List<Official> getOfficials(int start, int end) {
		return getService().getOfficials(start, end);
	}

	/**
	 * Returns all the officials matching the UUID and company.
	 *
	 * @param uuid the UUID of the officials
	 * @param companyId the primary key of the company
	 * @return the matching officials, or an empty list if no matches were found
	 */
	public static List<Official> getOfficialsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getOfficialsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of officials matching the UUID and company.
	 *
	 * @param uuid the UUID of the officials
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching officials, or an empty list if no matches were found
	 */
	public static List<Official> getOfficialsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Official> orderByComparator) {

		return getService().getOfficialsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of officials.
	 *
	 * @return the number of officials
	 */
	public static int getOfficialsCount() {
		return getService().getOfficialsCount();
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
	 * Supprime un élu
	 */
	public static Official removeOfficial(long officialId)
		throws PortalException {

		return getService().removeOfficial(officialId);
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
	 * Updates the official in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfficialLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param official the official
	 * @return the official that was updated
	 */
	public static Official updateOfficial(Official official) {
		return getService().updateOfficial(official);
	}

	/**
	 * Met à jour un élu et l'enregistre en base de données
	 */
	public static Official updateOfficial(
			Official official,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateOfficial(official, sc);
	}

	/**
	 * Met à jour le statut de l'élu par le framework workflow
	 */
	public static Official updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	/**
	 * Met à jour le statut de l'élu "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(Official official, int status)
		throws PortalException {

		getService().updateStatus(official, status);
	}

	public static OfficialLocalService getService() {
		return _service;
	}

	public static void setService(OfficialLocalService service) {
		_service = service;
	}

	private static volatile OfficialLocalService _service;

}