/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
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

import eu.strasbourg.service.gtfs.model.Alert;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Alert. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Cedric Henry
 * @see AlertLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {"model.class.name=eu.strasbourg.service.gtfs.model.Alert"}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AlertLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.AlertLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the alert local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AlertLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the alert to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AlertLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param alert the alert
	 * @return the alert that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Alert addAlert(Alert alert);

	/**
	 * Creates a new alert with the primary key. Does not add the alert to the database.
	 *
	 * @param alertId the primary key for the new alert
	 * @return the new alert
	 */
	@Transactional(enabled = false)
	public Alert createAlert(long alertId);

	/**
	 * Crée une entree avec une PK, non ajouté à la base de donnée
	 */
	public Alert createAlert(ServiceContext sc) throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the alert from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AlertLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param alert the alert
	 * @return the alert that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Alert deleteAlert(Alert alert);

	/**
	 * Deletes the alert with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AlertLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param alertId the primary key of the alert
	 * @return the alert that was removed
	 * @throws PortalException if a alert with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Alert deleteAlert(long alertId) throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AlertModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AlertModelImpl</code>.
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
	public Alert fetchAlert(long alertId);

	/**
	 * Returns the alert matching the UUID and group.
	 *
	 * @param uuid the alert's UUID
	 * @param groupId the primary key of the group
	 * @return the matching alert, or <code>null</code> if a matching alert could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Alert fetchAlertByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the alert with the primary key.
	 *
	 * @param alertId the primary key of the alert
	 * @return the alert
	 * @throws PortalException if a alert with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Alert getAlert(long alertId) throws PortalException;

	/**
	 * Returns the alert matching the UUID and group.
	 *
	 * @param uuid the alert's UUID
	 * @param groupId the primary key of the group
	 * @return the matching alert
	 * @throws PortalException if a matching alert could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Alert getAlertByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the alerts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AlertModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of alerts
	 * @param end the upper bound of the range of alerts (not inclusive)
	 * @return the range of alerts
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Alert> getAlerts(int start, int end);

	/**
	 * Returns all the alerts matching the UUID and company.
	 *
	 * @param uuid the UUID of the alerts
	 * @param companyId the primary key of the company
	 * @return the matching alerts, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Alert> getAlertsByUuidAndCompanyId(String uuid, long companyId);

	/**
	 * Returns a range of alerts matching the UUID and company.
	 *
	 * @param uuid the UUID of the alerts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of alerts
	 * @param end the upper bound of the range of alerts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching alerts, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Alert> getAlertsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Alert> orderByComparator);

	/**
	 * Returns the number of alerts.
	 *
	 * @return the number of alerts
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAlertsCount();

	/**
	 * Retourne la liste de toutes les alertes
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Alert> getAll();

	/**
	 * Retourne toutes les alertes d'un arret
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Alert> getByArretId(long arretId);

	/**
	 * Retourne toutes les entrees d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Alert> getByGroupId(long groupId);

	/**
	 * Renvoie le nombre des alertes en cours ou à venir de cet arret
	 *
	 * @param arretId : identifiant arret
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getCountAlertsActives(long arretId);

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
	public Alert removeAlert(long alertId) throws PortalException;

	/**
	 * Supprime les entrees
	 */
	public void removeAlerts(List<Alert> alerts) throws PortalException;

	/**
	 * Supprime les entree correspondants au arretId donnee
	 */
	public List<Alert> removeByArretId(long arretId) throws PortalException;

	/**
	 * Updates the alert in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AlertLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param alert the alert
	 * @return the alert that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Alert updateAlert(Alert alert);

	/**
	 * Met à jour une entree et l'enregistre en base de données
	 *
	 * @throws PortalException
	 * @throws IOException
	 */
	public Alert updateAlert(Alert alert, ServiceContext sc)
		throws PortalException;

	/**
	 * Met à jour les entree donnees
	 *
	 * @throws IOException
	 */
	public void updateAlerts(List<Alert> alerts, ServiceContext sc)
		throws PortalException;

}