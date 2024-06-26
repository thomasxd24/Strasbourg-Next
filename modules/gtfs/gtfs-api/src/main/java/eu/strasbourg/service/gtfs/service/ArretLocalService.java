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

import eu.strasbourg.service.gtfs.model.Arret;
import eu.strasbourg.service.gtfs.model.ImportHistoric;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Arret. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Cedric Henry
 * @see ArretLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {"model.class.name=eu.strasbourg.service.gtfs.model.Arret"}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ArretLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.ArretLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the arret local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ArretLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the arret to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ArretLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param arret the arret
	 * @return the arret that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Arret addArret(Arret arret);

	/**
	 * Creates a new arret with the primary key. Does not add the arret to the database.
	 *
	 * @param arretId the primary key for the new arret
	 * @return the new arret
	 */
	@Transactional(enabled = false)
	public Arret createArret(long arretId);

	/**
	 * Crée une entree avec une PK, non ajouté à la base de donnée
	 */
	public Arret createArret(ServiceContext sc) throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the arret from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ArretLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param arret the arret
	 * @return the arret that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Arret deleteArret(Arret arret);

	/**
	 * Deletes the arret with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ArretLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param arretId the primary key of the arret
	 * @return the arret that was removed
	 * @throws PortalException if a arret with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Arret deleteArret(long arretId) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.ArretModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.ArretModelImpl</code>.
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
	public Arret fetchArret(long arretId);

	/**
	 * Returns the arret matching the UUID and group.
	 *
	 * @param uuid the arret's UUID
	 * @param groupId the primary key of the group
	 * @return the matching arret, or <code>null</code> if a matching arret could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Arret fetchArretByUuidAndGroupId(String uuid, long groupId);

	/**
	 * Recherche des Arrets par identifiants
	 *
	 * @param idsArrets: list des identifiants
	 * @return
	 */
	public List<Arret> findByIds(List<Long> idsArrets);

	/**
	 * Recherche par mot clés
	 */
	public List<Arret> findByKeyword(
		String keyword, long groupId, int start, int end);

	/**
	 * Recherche par mot clés (compte)
	 */
	public long findByKeywordCount(String keyword, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Retourne la liste de tous les arrets
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Arret> getAll();

	/**
	 * Returns the arret with the primary key.
	 *
	 * @param arretId the primary key of the arret
	 * @return the arret
	 * @throws PortalException if a arret with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Arret getArret(long arretId) throws PortalException;

	/**
	 * Returns the arret matching the UUID and group.
	 *
	 * @param uuid the arret's UUID
	 * @param groupId the primary key of the group
	 * @return the matching arret
	 * @throws PortalException if a matching arret could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Arret getArretByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the arrets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.ArretModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @return the range of arrets
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Arret> getArrets(int start, int end);

	/**
	 * Returns all the arrets matching the UUID and company.
	 *
	 * @param uuid the UUID of the arrets
	 * @param companyId the primary key of the company
	 * @return the matching arrets, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Arret> getArretsByUuidAndCompanyId(String uuid, long companyId);

	/**
	 * Returns a range of arrets matching the UUID and company.
	 *
	 * @param uuid the UUID of the arrets
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching arrets, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Arret> getArretsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Arret> orderByComparator);

	/**
	 * Returns the number of arrets.
	 *
	 * @return the number of arrets
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getArretsCount();

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entree
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AssetVocabulary> getAttachedVocabularies(long groupId);

	/**
	 * Retourne toutes les entrees d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Arret> getByGroupId(long groupId);

	/**
	 * Retourne tous les arret avec un status choisi
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Arret> getByStatus(int status);

	/**
	 * Retourne les arrets via le stopCode
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Arret> getByStopCode(String stopCode);

	/**
	 * Retourne un arret via son stopId CTS
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Arret getByStopId(String stopId);

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
	 * Supprime l'entree
	 */
	public Arret removeArret(long arretId) throws PortalException;

	/**
	 * Supprime les entrees
	 */
	public void removeArrets(List<Arret> arrets, ServiceContext sc)
		throws PortalException;

	/**
	 * Met à jour le statut "manuellement" (pas via le workflow) des entrees
	 */
	public void unpublishArrets(
			List<Arret> arrets, ImportHistoric importHistoric,
			ServiceContext sc)
		throws PortalException;

	/**
	 * Updates the arret in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ArretLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param arret the arret
	 * @return the arret that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Arret updateArret(Arret arret);

	/**
	 * Met à jour une entree et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public Arret updateArret(Arret arret, ServiceContext sc)
		throws PortalException;

	/**
	 * Met à jour les entree donnees
	 *
	 * @throws IOException
	 */
	public void updateArrets(List<Arret> arrets, ServiceContext sc)
		throws PortalException;

	/**
	 * Met à jour le statut "manuellement" (pas via le workflow)
	 */
	public void updateStatus(Arret arret, int status) throws PortalException;

	/**
	 * Met à jour le statut de l'entree par le framework workflow
	 */
	public Arret updateStatus(
			long userId, long entryId, int status, ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException;

}