/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.oidc.service;

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

import eu.strasbourg.service.oidc.model.PublikUser;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for PublikUser. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PublikUserLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {"model.class.name=eu.strasbourg.service.oidc.model.PublikUser"}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PublikUserLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.oidc.service.impl.PublikUserLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the publik user local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PublikUserLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the publik user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublikUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publikUser the publik user
	 * @return the publik user that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PublikUser addPublikUser(PublikUser publikUser);

	/**
	 * Anonymise l'utilisateur pour placit
	 * suppression de la signature du pacte,
	 * anonymisation de ProjectFollowed, EventParticipation, Petition, Signataire, BudgetParticipatif,
	 *     BudgetSupport, Initiative, InitiativeHelp, Comment et Like
	 */
	public void anonymisedUserPlacit(
		PublikUser anonymUser, PublikUser publikUser);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public PublikUser createPublikUser();

	/**
	 * Creates a new publik user with the primary key. Does not add the publik user to the database.
	 *
	 * @param publikUserLiferayId the primary key for the new publik user
	 * @return the new publik user
	 */
	@Transactional(enabled = false)
	public PublikUser createPublikUser(long publikUserLiferayId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the publik user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublikUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publikUserLiferayId the primary key of the publik user
	 * @return the publik user that was removed
	 * @throws PortalException if a publik user with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public PublikUser deletePublikUser(long publikUserLiferayId)
		throws PortalException;

	/**
	 * Deletes the publik user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublikUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publikUser the publik user
	 * @return the publik user that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public PublikUser deletePublikUser(PublikUser publikUser);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.oidc.model.impl.PublikUserModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.oidc.model.impl.PublikUserModelImpl</code>.
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
	public PublikUser fetchPublikUser(long publikUserLiferayId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Rechercher tous les utilisateurs Publik directement via l'outil de persistance
	 * sans critere
	 *
	 * @return Liste de tous les utilisateurs Publik
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PublikUser> getAllPublikUsers();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PublikUser> getByPactSignatureAndPactDisplay();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PublikUser getByPublikUserId(String publikUserId);

	/**
	 * méthode permettant de récupererer le nombre de signataire.
	 *
	 * @return le nombre de signataire.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getCountUserHasSignedPacte();

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
	 * Returns the publik user with the primary key.
	 *
	 * @param publikUserLiferayId the primary key of the publik user
	 * @return the publik user
	 * @throws PortalException if a publik user with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PublikUser getPublikUser(long publikUserLiferayId)
		throws PortalException;

	/**
	 * Returns a range of all the publik users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.oidc.model.impl.PublikUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of publik users
	 * @param end the upper bound of the range of publik users (not inclusive)
	 * @return the range of publik users
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PublikUser> getPublikUsers(int start, int end);

	/**
	 * Rechercher des utilisateurs Publik directement via l'outil de persistance
	 * avec pagination
	 *
	 * @param start Debut de l'index de recherche pour la pagination
	 * @param end Fin de l'index de recherche pour la pagination
	 * @param sortField Champ de tri utilisé
	 * @param isSortDesc La liste est-elle triée par ordre decroissant ?
	 * @return Liste des utilisateurs trouvés
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PublikUser> getPublikUsers(
		int start, int end, String sortField, boolean isSortDesc);

	/**
	 * Rechercher des utilisateurs Publik directement via l'outil de persistance
	 * avec recherche et pagination
	 *
	 * @param start Debut de l'index de recherche pour la pagination
	 * @param end Fin de l'index de recherche pour la pagination
	 * @param keywords Mots-clefs pour la recherche sur le nom, prenom, email
	 * @param sortField Champ de tri utilisé
	 * @param isSortDesc La liste est-elle triée par ordre decroissant ?
	 * @return Liste des utilisateurs trouvés
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PublikUser> getPublikUsers(
		int start, int end, String keywords, String sortField,
		boolean isSortDesc);

	/**
	 * Rechercher des utilisateurs Publik directement via l'outil de persistance
	 * sans pagination
	 *
	 * @param sortField Champ de tri utilisé
	 * @param isSortDesc La liste est-elle triée par ordre decroissant ?
	 * @return Liste des utilisateurs trouvés
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PublikUser> getPublikUsers(
		String sortField, boolean isSortDesc);

	/**
	 * Rechercher tous les utilisateurs Publik directement via l'outil de persistance
	 * avec recherche mais sans pagination
	 *
	 * @param keywords Mots-clefs pour la recherche sur le nom, prenom, email
	 * @param sortField Champ de tri utilisé
	 * @param isSortDesc La liste est-elle triée par ordre decroissant ?
	 * @return Liste des utilisateurs trouvés
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PublikUser> getPublikUsers(
		String keywords, String sortField, boolean isSortDesc);

	/**
	 * Returns the number of publik users.
	 *
	 * @return the number of publik users
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPublikUsersCount();

	/**
	 * Supprime une entité
	 */
	public PublikUser removePublikUser(String publikUserId);

	/**
	 * Updates the publik user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublikUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publikUser the publik user
	 * @return the publik user that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PublikUser updatePublikUser(PublikUser publikUser);

	/**
	 * Met à jour un utilisateur Publik et l'enregistre en base
	 *
	 * @return L'utilisateur Publik modifié
	 */
	public PublikUser updatePublikUser(PublikUser publikUser, ServiceContext sc)
		throws PortalException;

	/**
	 * Enregistre ou update l'utilisateur en base
	 */
	public void updateUserInfoInDatabase(
		String internalId, String accessToken, String givenName,
		String familyName, String email, String photo, String accordPlacit,
		String listingPlacit);

}