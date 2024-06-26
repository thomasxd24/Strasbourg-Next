/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.agenda.model.AgendaExport;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for AgendaExport. This utility wraps
 * <code>eu.strasbourg.service.agenda.service.impl.AgendaExportLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see AgendaExportLocalService
 * @generated
 */
public class AgendaExportLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.AgendaExportLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the agenda export to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgendaExportLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agendaExport the agenda export
	 * @return the agenda export that was added
	 */
	public static AgendaExport addAgendaExport(AgendaExport agendaExport) {
		return getService().addAgendaExport(agendaExport);
	}

	public static AgendaExport copyAgendaExport(
			com.liferay.portal.kernel.service.ServiceContext sc,
			AgendaExport agendaToCopy)
		throws PortalException {

		return getService().copyAgendaExport(sc, agendaToCopy);
	}

	/**
	 * Creates a new agenda export with the primary key. Does not add the agenda export to the database.
	 *
	 * @param agendaExportId the primary key for the new agenda export
	 * @return the new agenda export
	 */
	public static AgendaExport createAgendaExport(long agendaExportId) {
		return getService().createAgendaExport(agendaExportId);
	}

	/**
	 * Crée un Agenda Export vide avec une PK, non ajouté à la base de donnée
	 */
	public static AgendaExport createAgendaExport(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createAgendaExport(sc);
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
	 * Deletes the agenda export from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgendaExportLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agendaExport the agenda export
	 * @return the agenda export that was removed
	 */
	public static AgendaExport deleteAgendaExport(AgendaExport agendaExport) {
		return getService().deleteAgendaExport(agendaExport);
	}

	/**
	 * Deletes the agenda export with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgendaExportLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agendaExportId the primary key of the agenda export
	 * @return the agenda export that was removed
	 * @throws PortalException if a agenda export with the primary key could not be found
	 */
	public static AgendaExport deleteAgendaExport(long agendaExportId)
		throws PortalException {

		return getService().deleteAgendaExport(agendaExportId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.AgendaExportModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.AgendaExportModelImpl</code>.
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

	public static AgendaExport fetchAgendaExport(long agendaExportId) {
		return getService().fetchAgendaExport(agendaExportId);
	}

	/**
	 * Returns the agenda export matching the UUID and group.
	 *
	 * @param uuid the agenda export's UUID
	 * @param groupId the primary key of the group
	 * @return the matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	public static AgendaExport fetchAgendaExportByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAgendaExportByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	public static List<AgendaExport> findByKeyword(
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
	 * Returns the agenda export with the primary key.
	 *
	 * @param agendaExportId the primary key of the agenda export
	 * @return the agenda export
	 * @throws PortalException if a agenda export with the primary key could not be found
	 */
	public static AgendaExport getAgendaExport(long agendaExportId)
		throws PortalException {

		return getService().getAgendaExport(agendaExportId);
	}

	/**
	 * Returns the agenda export matching the UUID and group.
	 *
	 * @param uuid the agenda export's UUID
	 * @param groupId the primary key of the group
	 * @return the matching agenda export
	 * @throws PortalException if a matching agenda export could not be found
	 */
	public static AgendaExport getAgendaExportByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAgendaExportByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the agenda exports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @return the range of agenda exports
	 */
	public static List<AgendaExport> getAgendaExports(int start, int end) {
		return getService().getAgendaExports(start, end);
	}

	/**
	 * Returns all the agenda exports matching the UUID and company.
	 *
	 * @param uuid the UUID of the agenda exports
	 * @param companyId the primary key of the company
	 * @return the matching agenda exports, or an empty list if no matches were found
	 */
	public static List<AgendaExport> getAgendaExportsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAgendaExportsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of agenda exports matching the UUID and company.
	 *
	 * @param uuid the UUID of the agenda exports
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching agenda exports, or an empty list if no matches were found
	 */
	public static List<AgendaExport> getAgendaExportsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator) {

		return getService().getAgendaExportsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of agenda exports.
	 *
	 * @return the number of agenda exports
	 */
	public static int getAgendaExportsCount() {
		return getService().getAgendaExportsCount();
	}

	/**
	 * Retourne les vocabulaires rattrachés à ce type d'entité pour un groupe
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne tous les AGendaExport d'un groupe
	 */
	public static List<AgendaExport> getByGroupId(long groupId) {
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
	 * Supprime un AgendaExport
	 */
	public static AgendaExport removeAgendaExport(long agendaExportId)
		throws PortalException {

		return getService().removeAgendaExport(agendaExportId);
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
	 * Updates the agenda export in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgendaExportLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agendaExport the agenda export
	 * @return the agenda export that was updated
	 */
	public static AgendaExport updateAgendaExport(AgendaExport agendaExport) {
		return getService().updateAgendaExport(agendaExport);
	}

	/**
	 * Met à jour un Agenda Export et l'enregistre en base de données
	 */
	public static AgendaExport updateAgendaExport(
			AgendaExport agendaExport,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateAgendaExport(agendaExport, sc);
	}

	/**
	 * Met à jour le statut de l'AgendaExport "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(AgendaExport agendaExport, int status)
		throws PortalException {

		getService().updateStatus(agendaExport, status);
	}

	/**
	 * Met à jour le statut de l'AgendaExport par le framework workflow
	 */
	public static AgendaExport updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static AgendaExportLocalService getService() {
		return _service;
	}

	public static void setService(AgendaExportLocalService service) {
		_service = service;
	}

	private static volatile AgendaExportLocalService _service;

}