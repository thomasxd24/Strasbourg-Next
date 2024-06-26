/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

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
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.gtfs.model.ImportHistoric;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ImportHistoric. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Cedric Henry
 * @see ImportHistoricLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"model.class.name=eu.strasbourg.service.gtfs.model.ImportHistoric"
	}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ImportHistoricLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.ImportHistoricLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the import historic local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ImportHistoricLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the import historic to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importHistoric the import historic
	 * @return the import historic that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ImportHistoric addImportHistoric(ImportHistoric importHistoric);

	/**
	 * Creates a new import historic with the primary key. Does not add the import historic to the database.
	 *
	 * @param importHistoricId the primary key for the new import historic
	 * @return the new import historic
	 */
	@Transactional(enabled = false)
	public ImportHistoric createImportHistoric(long importHistoricId);

	/**
	 * Crée une entree d'import vide avec une PK, non ajouté à la base de donnée
	 */
	public ImportHistoric createImportHistoric(ServiceContext sc)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the import historic from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importHistoric the import historic
	 * @return the import historic that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ImportHistoric deleteImportHistoric(ImportHistoric importHistoric);

	/**
	 * Deletes the import historic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importHistoricId the primary key of the import historic
	 * @return the import historic that was removed
	 * @throws PortalException if a import historic with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ImportHistoric deleteImportHistoric(long importHistoricId)
		throws PortalException;

	/**
	 * Suppression des anciens imports d'historiques
	 */
	public int deleteOldImportHistorics();

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Effectue l'import des donnees issues des fichiers GTFS
	 */
	public void doImportGTFS(ServiceContext sc, ImportHistoric importHistoric);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.ImportHistoricModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.ImportHistoricModelImpl</code>.
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
	public ImportHistoric fetchImportHistoric(long importHistoricId);

	/**
	 * Returns the import historic matching the UUID and group.
	 *
	 * @param uuid the import historic's UUID
	 * @param groupId the primary key of the group
	 * @return the matching import historic, or <code>null</code> if a matching import historic could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ImportHistoric fetchImportHistoricByUuidAndGroupId(
		String uuid, long groupId);

	/**
	 * Recherche par mot clés
	 */
	public List<ImportHistoric> findByKeyword(
		String keyword, long groupId, int start, int end);

	/**
	 * Recherche par mot clés (compte)
	 */
	public long findByKeywordCount(String keyword, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Renvoie la liste des vocabulaires rattachés à un projet
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AssetVocabulary> getAttachedVocabularies(long groupId);

	/**
	 * Retourne tous les projets d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportHistoric> getByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	/**
	 * Returns the import historic with the primary key.
	 *
	 * @param importHistoricId the primary key of the import historic
	 * @return the import historic
	 * @throws PortalException if a import historic with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ImportHistoric getImportHistoric(long importHistoricId)
		throws PortalException;

	/**
	 * Returns the import historic matching the UUID and group.
	 *
	 * @param uuid the import historic's UUID
	 * @param groupId the primary key of the group
	 * @return the matching import historic
	 * @throws PortalException if a matching import historic could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ImportHistoric getImportHistoricByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the import historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @return the range of import historics
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportHistoric> getImportHistorics(int start, int end);

	/**
	 * Returns all the import historics matching the UUID and company.
	 *
	 * @param uuid the UUID of the import historics
	 * @param companyId the primary key of the company
	 * @return the matching import historics, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportHistoric> getImportHistoricsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of import historics matching the UUID and company.
	 *
	 * @param uuid the UUID of the import historics
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching import historics, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportHistoric> getImportHistoricsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ImportHistoric> orderByComparator);

	/**
	 * Returns the number of import historics.
	 *
	 * @return the number of import historics
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getImportHistoricsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Retourne le dernier historique d'import
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ImportHistoric getLatestImportHistoric(ImportHistoric notCurrent);

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
	 * Supprime l'entree d'import
	 */
	public ImportHistoric removeImportHistoric(long importHistoricId)
		throws PortalException;

	/**
	 * Updates the import historic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImportHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param importHistoric the import historic
	 * @return the import historic that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ImportHistoric updateImportHistoric(ImportHistoric importHistoric);

	/**
	 * Met à jour une entree d'import et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public ImportHistoric updateImportHistoric(
			ImportHistoric importHistoric, ServiceContext sc)
		throws PortalException;

	/**
	 * Met à jour le statut de l'entree d'import "manuellement" (pas via le workflow)
	 */
	public void updateStatus(ImportHistoric importHistoric, int status)
		throws PortalException;

	/**
	 * Met à jour le statut de l'entree d'import par le framework workflow
	 */
	public ImportHistoric updateStatus(
			long userId, long entryId, int status, ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException;

}