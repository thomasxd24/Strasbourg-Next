/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link VoteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VoteLocalService
 * @generated
 */
public class VoteLocalServiceWrapper
	implements ServiceWrapper<VoteLocalService>, VoteLocalService {

	public VoteLocalServiceWrapper() {
		this(null);
	}

	public VoteLocalServiceWrapper(VoteLocalService voteLocalService) {
		_voteLocalService = voteLocalService;
	}

	/**
	 * Adds the vote to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vote the vote
	 * @return the vote that was added
	 */
	@Override
	public eu.strasbourg.service.council.model.Vote addVote(
		eu.strasbourg.service.council.model.Vote vote) {

		return _voteLocalService.addVote(vote);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _voteLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.council.model.Vote createVote(
		long officialId, long deliberationId,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return _voteLocalService.createVote(officialId, deliberationId, sc);
	}

	/**
	 * Creates a new vote with the primary key. Does not add the vote to the database.
	 *
	 * @param votePK the primary key for the new vote
	 * @return the new vote
	 */
	@Override
	public eu.strasbourg.service.council.model.Vote createVote(
		eu.strasbourg.service.council.service.persistence.VotePK votePK) {

		return _voteLocalService.createVote(votePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _voteLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the vote from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vote the vote
	 * @return the vote that was removed
	 */
	@Override
	public eu.strasbourg.service.council.model.Vote deleteVote(
		eu.strasbourg.service.council.model.Vote vote) {

		return _voteLocalService.deleteVote(vote);
	}

	/**
	 * Deletes the vote with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param votePK the primary key of the vote
	 * @return the vote that was removed
	 * @throws PortalException if a vote with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.council.model.Vote deleteVote(
			eu.strasbourg.service.council.service.persistence.VotePK votePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _voteLocalService.deleteVote(votePK);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _voteLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _voteLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _voteLocalService.dynamicQuery();
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

		return _voteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.VoteModelImpl</code>.
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

		return _voteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.VoteModelImpl</code>.
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

		return _voteLocalService.dynamicQuery(
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

		return _voteLocalService.dynamicQueryCount(dynamicQuery);
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

		return _voteLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.council.model.Vote fetchVote(
		eu.strasbourg.service.council.service.persistence.VotePK votePK) {

		return _voteLocalService.fetchVote(votePK);
	}

	/**
	 * Returns the vote matching the UUID and group.
	 *
	 * @param uuid the vote's UUID
	 * @param groupId the primary key of the group
	 * @return the matching vote, or <code>null</code> if a matching vote could not be found
	 */
	@Override
	public eu.strasbourg.service.council.model.Vote fetchVoteByUuidAndGroupId(
		String uuid, long groupId) {

		return _voteLocalService.fetchVoteByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Retourne la liste des votes d'une délibération
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.Vote>
		findByDeliberationId(long deliberationId) {

		return _voteLocalService.findByDeliberationId(deliberationId);
	}

	/**
	 * Retourne le vote d'un élu pour une délibération
	 */
	@Override
	public eu.strasbourg.service.council.model.Vote
		findByDeliberationIdandOfficialId(
			long deliberationId, long officialId) {

		return _voteLocalService.findByDeliberationIdandOfficialId(
			deliberationId, officialId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _voteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _voteLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _voteLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _voteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the vote with the primary key.
	 *
	 * @param votePK the primary key of the vote
	 * @return the vote
	 * @throws PortalException if a vote with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.council.model.Vote getVote(
			eu.strasbourg.service.council.service.persistence.VotePK votePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _voteLocalService.getVote(votePK);
	}

	/**
	 * Returns the vote matching the UUID and group.
	 *
	 * @param uuid the vote's UUID
	 * @param groupId the primary key of the group
	 * @return the matching vote
	 * @throws PortalException if a matching vote could not be found
	 */
	@Override
	public eu.strasbourg.service.council.model.Vote getVoteByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _voteLocalService.getVoteByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the votes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.VoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @return the range of votes
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.Vote> getVotes(
		int start, int end) {

		return _voteLocalService.getVotes(start, end);
	}

	/**
	 * Returns all the votes matching the UUID and company.
	 *
	 * @param uuid the UUID of the votes
	 * @param companyId the primary key of the company
	 * @return the matching votes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.Vote>
		getVotesByUuidAndCompanyId(String uuid, long companyId) {

		return _voteLocalService.getVotesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of votes matching the UUID and company.
	 *
	 * @param uuid the UUID of the votes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching votes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.Vote>
		getVotesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.council.model.Vote> orderByComparator) {

		return _voteLocalService.getVotesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of votes.
	 *
	 * @return the number of votes
	 */
	@Override
	public int getVotesCount() {
		return _voteLocalService.getVotesCount();
	}

	/**
	 * Supprime une entité
	 */
	@Override
	public eu.strasbourg.service.council.model.Vote removeVote(
			long officialId, long deliberationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _voteLocalService.removeVote(officialId, deliberationId);
	}

	/**
	 * Supprime les votes d'une délibération
	 */
	@Override
	public void removeVotesFromDeliberation(long deliberationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_voteLocalService.removeVotesFromDeliberation(deliberationId);
	}

	/**
	 * Updates the vote in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vote the vote
	 * @return the vote that was updated
	 */
	@Override
	public eu.strasbourg.service.council.model.Vote updateVote(
		eu.strasbourg.service.council.model.Vote vote) {

		return _voteLocalService.updateVote(vote);
	}

	/**
	 * Met à jour une entité et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.council.model.Vote updateVote(
		eu.strasbourg.service.council.model.Vote vote,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return _voteLocalService.updateVote(vote, sc);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _voteLocalService.getBasePersistence();
	}

	@Override
	public VoteLocalService getWrappedService() {
		return _voteLocalService;
	}

	@Override
	public void setWrappedService(VoteLocalService voteLocalService) {
		_voteLocalService = voteLocalService;
	}

	private VoteLocalService _voteLocalService;

}