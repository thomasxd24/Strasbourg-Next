/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.project.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.asset.kernel.service.persistence.AssetLinkPersistence;
import com.liferay.asset.kernel.service.persistence.AssetTagPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.project.model.InitiativeHelp;
import eu.strasbourg.service.project.service.InitiativeHelpLocalService;
import eu.strasbourg.service.project.service.persistence.BudgetParticipatifPersistence;
import eu.strasbourg.service.project.service.persistence.BudgetPhasePersistence;
import eu.strasbourg.service.project.service.persistence.InitiativeHelpPersistence;
import eu.strasbourg.service.project.service.persistence.InitiativePersistence;
import eu.strasbourg.service.project.service.persistence.ParticipationPersistence;
import eu.strasbourg.service.project.service.persistence.PetitionPersistence;
import eu.strasbourg.service.project.service.persistence.PlacitPlacePersistence;
import eu.strasbourg.service.project.service.persistence.ProjectFollowedPersistence;
import eu.strasbourg.service.project.service.persistence.ProjectPersistence;
import eu.strasbourg.service.project.service.persistence.ProjectTimelinePersistence;
import eu.strasbourg.service.project.service.persistence.SignatairePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the initiative help local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.project.service.impl.InitiativeHelpLocalServiceImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see eu.strasbourg.service.project.service.impl.InitiativeHelpLocalServiceImpl
 * @see eu.strasbourg.service.project.service.InitiativeHelpLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class InitiativeHelpLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements InitiativeHelpLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link eu.strasbourg.service.project.service.InitiativeHelpLocalServiceUtil} to access the initiative help local service.
	 */

	/**
	 * Adds the initiative help to the database. Also notifies the appropriate model listeners.
	 *
	 * @param initiativeHelp the initiative help
	 * @return the initiative help that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public InitiativeHelp addInitiativeHelp(InitiativeHelp initiativeHelp) {
		initiativeHelp.setNew(true);

		return initiativeHelpPersistence.update(initiativeHelp);
	}

	/**
	 * Creates a new initiative help with the primary key. Does not add the initiative help to the database.
	 *
	 * @param initiativeHelpId the primary key for the new initiative help
	 * @return the new initiative help
	 */
	@Override
	public InitiativeHelp createInitiativeHelp(long initiativeHelpId) {
		return initiativeHelpPersistence.create(initiativeHelpId);
	}

	/**
	 * Deletes the initiative help with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param initiativeHelpId the primary key of the initiative help
	 * @return the initiative help that was removed
	 * @throws PortalException if a initiative help with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public InitiativeHelp deleteInitiativeHelp(long initiativeHelpId)
		throws PortalException {
		return initiativeHelpPersistence.remove(initiativeHelpId);
	}

	/**
	 * Deletes the initiative help from the database. Also notifies the appropriate model listeners.
	 *
	 * @param initiativeHelp the initiative help
	 * @return the initiative help that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public InitiativeHelp deleteInitiativeHelp(InitiativeHelp initiativeHelp) {
		return initiativeHelpPersistence.remove(initiativeHelp);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(InitiativeHelp.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return initiativeHelpPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link eu.strasbourg.service.project.model.impl.InitiativeHelpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return initiativeHelpPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link eu.strasbourg.service.project.model.impl.InitiativeHelpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return initiativeHelpPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return initiativeHelpPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return initiativeHelpPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public InitiativeHelp fetchInitiativeHelp(long initiativeHelpId) {
		return initiativeHelpPersistence.fetchByPrimaryKey(initiativeHelpId);
	}

	/**
	 * Returns the initiative help with the primary key.
	 *
	 * @param initiativeHelpId the primary key of the initiative help
	 * @return the initiative help
	 * @throws PortalException if a initiative help with the primary key could not be found
	 */
	@Override
	public InitiativeHelp getInitiativeHelp(long initiativeHelpId)
		throws PortalException {
		return initiativeHelpPersistence.findByPrimaryKey(initiativeHelpId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(initiativeHelpLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(InitiativeHelp.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("initiativeHelpId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(initiativeHelpLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(InitiativeHelp.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"initiativeHelpId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(initiativeHelpLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(InitiativeHelp.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("initiativeHelpId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return initiativeHelpLocalService.deleteInitiativeHelp((InitiativeHelp)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return initiativeHelpPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the initiative helps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link eu.strasbourg.service.project.model.impl.InitiativeHelpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @return the range of initiative helps
	 */
	@Override
	public List<InitiativeHelp> getInitiativeHelps(int start, int end) {
		return initiativeHelpPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of initiative helps.
	 *
	 * @return the number of initiative helps
	 */
	@Override
	public int getInitiativeHelpsCount() {
		return initiativeHelpPersistence.countAll();
	}

	/**
	 * Updates the initiative help in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param initiativeHelp the initiative help
	 * @return the initiative help that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public InitiativeHelp updateInitiativeHelp(InitiativeHelp initiativeHelp) {
		return initiativeHelpPersistence.update(initiativeHelp);
	}

	/**
	 * Returns the budget participatif local service.
	 *
	 * @return the budget participatif local service
	 */
	public eu.strasbourg.service.project.service.BudgetParticipatifLocalService getBudgetParticipatifLocalService() {
		return budgetParticipatifLocalService;
	}

	/**
	 * Sets the budget participatif local service.
	 *
	 * @param budgetParticipatifLocalService the budget participatif local service
	 */
	public void setBudgetParticipatifLocalService(
		eu.strasbourg.service.project.service.BudgetParticipatifLocalService budgetParticipatifLocalService) {
		this.budgetParticipatifLocalService = budgetParticipatifLocalService;
	}

	/**
	 * Returns the budget participatif persistence.
	 *
	 * @return the budget participatif persistence
	 */
	public BudgetParticipatifPersistence getBudgetParticipatifPersistence() {
		return budgetParticipatifPersistence;
	}

	/**
	 * Sets the budget participatif persistence.
	 *
	 * @param budgetParticipatifPersistence the budget participatif persistence
	 */
	public void setBudgetParticipatifPersistence(
		BudgetParticipatifPersistence budgetParticipatifPersistence) {
		this.budgetParticipatifPersistence = budgetParticipatifPersistence;
	}

	/**
	 * Returns the budget phase local service.
	 *
	 * @return the budget phase local service
	 */
	public eu.strasbourg.service.project.service.BudgetPhaseLocalService getBudgetPhaseLocalService() {
		return budgetPhaseLocalService;
	}

	/**
	 * Sets the budget phase local service.
	 *
	 * @param budgetPhaseLocalService the budget phase local service
	 */
	public void setBudgetPhaseLocalService(
		eu.strasbourg.service.project.service.BudgetPhaseLocalService budgetPhaseLocalService) {
		this.budgetPhaseLocalService = budgetPhaseLocalService;
	}

	/**
	 * Returns the budget phase persistence.
	 *
	 * @return the budget phase persistence
	 */
	public BudgetPhasePersistence getBudgetPhasePersistence() {
		return budgetPhasePersistence;
	}

	/**
	 * Sets the budget phase persistence.
	 *
	 * @param budgetPhasePersistence the budget phase persistence
	 */
	public void setBudgetPhasePersistence(
		BudgetPhasePersistence budgetPhasePersistence) {
		this.budgetPhasePersistence = budgetPhasePersistence;
	}

	/**
	 * Returns the initiative local service.
	 *
	 * @return the initiative local service
	 */
	public eu.strasbourg.service.project.service.InitiativeLocalService getInitiativeLocalService() {
		return initiativeLocalService;
	}

	/**
	 * Sets the initiative local service.
	 *
	 * @param initiativeLocalService the initiative local service
	 */
	public void setInitiativeLocalService(
		eu.strasbourg.service.project.service.InitiativeLocalService initiativeLocalService) {
		this.initiativeLocalService = initiativeLocalService;
	}

	/**
	 * Returns the initiative persistence.
	 *
	 * @return the initiative persistence
	 */
	public InitiativePersistence getInitiativePersistence() {
		return initiativePersistence;
	}

	/**
	 * Sets the initiative persistence.
	 *
	 * @param initiativePersistence the initiative persistence
	 */
	public void setInitiativePersistence(
		InitiativePersistence initiativePersistence) {
		this.initiativePersistence = initiativePersistence;
	}

	/**
	 * Returns the initiative help local service.
	 *
	 * @return the initiative help local service
	 */
	public InitiativeHelpLocalService getInitiativeHelpLocalService() {
		return initiativeHelpLocalService;
	}

	/**
	 * Sets the initiative help local service.
	 *
	 * @param initiativeHelpLocalService the initiative help local service
	 */
	public void setInitiativeHelpLocalService(
		InitiativeHelpLocalService initiativeHelpLocalService) {
		this.initiativeHelpLocalService = initiativeHelpLocalService;
	}

	/**
	 * Returns the initiative help persistence.
	 *
	 * @return the initiative help persistence
	 */
	public InitiativeHelpPersistence getInitiativeHelpPersistence() {
		return initiativeHelpPersistence;
	}

	/**
	 * Sets the initiative help persistence.
	 *
	 * @param initiativeHelpPersistence the initiative help persistence
	 */
	public void setInitiativeHelpPersistence(
		InitiativeHelpPersistence initiativeHelpPersistence) {
		this.initiativeHelpPersistence = initiativeHelpPersistence;
	}

	/**
	 * Returns the participation local service.
	 *
	 * @return the participation local service
	 */
	public eu.strasbourg.service.project.service.ParticipationLocalService getParticipationLocalService() {
		return participationLocalService;
	}

	/**
	 * Sets the participation local service.
	 *
	 * @param participationLocalService the participation local service
	 */
	public void setParticipationLocalService(
		eu.strasbourg.service.project.service.ParticipationLocalService participationLocalService) {
		this.participationLocalService = participationLocalService;
	}

	/**
	 * Returns the participation persistence.
	 *
	 * @return the participation persistence
	 */
	public ParticipationPersistence getParticipationPersistence() {
		return participationPersistence;
	}

	/**
	 * Sets the participation persistence.
	 *
	 * @param participationPersistence the participation persistence
	 */
	public void setParticipationPersistence(
		ParticipationPersistence participationPersistence) {
		this.participationPersistence = participationPersistence;
	}

	/**
	 * Returns the petition local service.
	 *
	 * @return the petition local service
	 */
	public eu.strasbourg.service.project.service.PetitionLocalService getPetitionLocalService() {
		return petitionLocalService;
	}

	/**
	 * Sets the petition local service.
	 *
	 * @param petitionLocalService the petition local service
	 */
	public void setPetitionLocalService(
		eu.strasbourg.service.project.service.PetitionLocalService petitionLocalService) {
		this.petitionLocalService = petitionLocalService;
	}

	/**
	 * Returns the petition persistence.
	 *
	 * @return the petition persistence
	 */
	public PetitionPersistence getPetitionPersistence() {
		return petitionPersistence;
	}

	/**
	 * Sets the petition persistence.
	 *
	 * @param petitionPersistence the petition persistence
	 */
	public void setPetitionPersistence(PetitionPersistence petitionPersistence) {
		this.petitionPersistence = petitionPersistence;
	}

	/**
	 * Returns the placit place local service.
	 *
	 * @return the placit place local service
	 */
	public eu.strasbourg.service.project.service.PlacitPlaceLocalService getPlacitPlaceLocalService() {
		return placitPlaceLocalService;
	}

	/**
	 * Sets the placit place local service.
	 *
	 * @param placitPlaceLocalService the placit place local service
	 */
	public void setPlacitPlaceLocalService(
		eu.strasbourg.service.project.service.PlacitPlaceLocalService placitPlaceLocalService) {
		this.placitPlaceLocalService = placitPlaceLocalService;
	}

	/**
	 * Returns the placit place persistence.
	 *
	 * @return the placit place persistence
	 */
	public PlacitPlacePersistence getPlacitPlacePersistence() {
		return placitPlacePersistence;
	}

	/**
	 * Sets the placit place persistence.
	 *
	 * @param placitPlacePersistence the placit place persistence
	 */
	public void setPlacitPlacePersistence(
		PlacitPlacePersistence placitPlacePersistence) {
		this.placitPlacePersistence = placitPlacePersistence;
	}

	/**
	 * Returns the project local service.
	 *
	 * @return the project local service
	 */
	public eu.strasbourg.service.project.service.ProjectLocalService getProjectLocalService() {
		return projectLocalService;
	}

	/**
	 * Sets the project local service.
	 *
	 * @param projectLocalService the project local service
	 */
	public void setProjectLocalService(
		eu.strasbourg.service.project.service.ProjectLocalService projectLocalService) {
		this.projectLocalService = projectLocalService;
	}

	/**
	 * Returns the project persistence.
	 *
	 * @return the project persistence
	 */
	public ProjectPersistence getProjectPersistence() {
		return projectPersistence;
	}

	/**
	 * Sets the project persistence.
	 *
	 * @param projectPersistence the project persistence
	 */
	public void setProjectPersistence(ProjectPersistence projectPersistence) {
		this.projectPersistence = projectPersistence;
	}

	/**
	 * Returns the project followed local service.
	 *
	 * @return the project followed local service
	 */
	public eu.strasbourg.service.project.service.ProjectFollowedLocalService getProjectFollowedLocalService() {
		return projectFollowedLocalService;
	}

	/**
	 * Sets the project followed local service.
	 *
	 * @param projectFollowedLocalService the project followed local service
	 */
	public void setProjectFollowedLocalService(
		eu.strasbourg.service.project.service.ProjectFollowedLocalService projectFollowedLocalService) {
		this.projectFollowedLocalService = projectFollowedLocalService;
	}

	/**
	 * Returns the project followed persistence.
	 *
	 * @return the project followed persistence
	 */
	public ProjectFollowedPersistence getProjectFollowedPersistence() {
		return projectFollowedPersistence;
	}

	/**
	 * Sets the project followed persistence.
	 *
	 * @param projectFollowedPersistence the project followed persistence
	 */
	public void setProjectFollowedPersistence(
		ProjectFollowedPersistence projectFollowedPersistence) {
		this.projectFollowedPersistence = projectFollowedPersistence;
	}

	/**
	 * Returns the project timeline local service.
	 *
	 * @return the project timeline local service
	 */
	public eu.strasbourg.service.project.service.ProjectTimelineLocalService getProjectTimelineLocalService() {
		return projectTimelineLocalService;
	}

	/**
	 * Sets the project timeline local service.
	 *
	 * @param projectTimelineLocalService the project timeline local service
	 */
	public void setProjectTimelineLocalService(
		eu.strasbourg.service.project.service.ProjectTimelineLocalService projectTimelineLocalService) {
		this.projectTimelineLocalService = projectTimelineLocalService;
	}

	/**
	 * Returns the project timeline persistence.
	 *
	 * @return the project timeline persistence
	 */
	public ProjectTimelinePersistence getProjectTimelinePersistence() {
		return projectTimelinePersistence;
	}

	/**
	 * Sets the project timeline persistence.
	 *
	 * @param projectTimelinePersistence the project timeline persistence
	 */
	public void setProjectTimelinePersistence(
		ProjectTimelinePersistence projectTimelinePersistence) {
		this.projectTimelinePersistence = projectTimelinePersistence;
	}

	/**
	 * Returns the signataire local service.
	 *
	 * @return the signataire local service
	 */
	public eu.strasbourg.service.project.service.SignataireLocalService getSignataireLocalService() {
		return signataireLocalService;
	}

	/**
	 * Sets the signataire local service.
	 *
	 * @param signataireLocalService the signataire local service
	 */
	public void setSignataireLocalService(
		eu.strasbourg.service.project.service.SignataireLocalService signataireLocalService) {
		this.signataireLocalService = signataireLocalService;
	}

	/**
	 * Returns the signataire persistence.
	 *
	 * @return the signataire persistence
	 */
	public SignatairePersistence getSignatairePersistence() {
		return signatairePersistence;
	}

	/**
	 * Sets the signataire persistence.
	 *
	 * @param signatairePersistence the signataire persistence
	 */
	public void setSignatairePersistence(
		SignatairePersistence signatairePersistence) {
		this.signatairePersistence = signatairePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.asset.kernel.service.AssetEntryLocalService getAssetEntryLocalService() {
		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.asset.kernel.service.AssetEntryLocalService assetEntryLocalService) {
		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {
		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the asset link local service.
	 *
	 * @return the asset link local service
	 */
	public com.liferay.asset.kernel.service.AssetLinkLocalService getAssetLinkLocalService() {
		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.asset.kernel.service.AssetLinkLocalService assetLinkLocalService) {
		this.assetLinkLocalService = assetLinkLocalService;
	}

	/**
	 * Returns the asset link persistence.
	 *
	 * @return the asset link persistence
	 */
	public AssetLinkPersistence getAssetLinkPersistence() {
		return assetLinkPersistence;
	}

	/**
	 * Sets the asset link persistence.
	 *
	 * @param assetLinkPersistence the asset link persistence
	 */
	public void setAssetLinkPersistence(
		AssetLinkPersistence assetLinkPersistence) {
		this.assetLinkPersistence = assetLinkPersistence;
	}

	/**
	 * Returns the asset tag local service.
	 *
	 * @return the asset tag local service
	 */
	public com.liferay.asset.kernel.service.AssetTagLocalService getAssetTagLocalService() {
		return assetTagLocalService;
	}

	/**
	 * Sets the asset tag local service.
	 *
	 * @param assetTagLocalService the asset tag local service
	 */
	public void setAssetTagLocalService(
		com.liferay.asset.kernel.service.AssetTagLocalService assetTagLocalService) {
		this.assetTagLocalService = assetTagLocalService;
	}

	/**
	 * Returns the asset tag persistence.
	 *
	 * @return the asset tag persistence
	 */
	public AssetTagPersistence getAssetTagPersistence() {
		return assetTagPersistence;
	}

	/**
	 * Sets the asset tag persistence.
	 *
	 * @param assetTagPersistence the asset tag persistence
	 */
	public void setAssetTagPersistence(AssetTagPersistence assetTagPersistence) {
		this.assetTagPersistence = assetTagPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("eu.strasbourg.service.project.model.InitiativeHelp",
			initiativeHelpLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"eu.strasbourg.service.project.model.InitiativeHelp");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return InitiativeHelpLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return InitiativeHelp.class;
	}

	protected String getModelClassName() {
		return InitiativeHelp.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = initiativeHelpPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = eu.strasbourg.service.project.service.BudgetParticipatifLocalService.class)
	protected eu.strasbourg.service.project.service.BudgetParticipatifLocalService budgetParticipatifLocalService;
	@BeanReference(type = BudgetParticipatifPersistence.class)
	protected BudgetParticipatifPersistence budgetParticipatifPersistence;
	@BeanReference(type = eu.strasbourg.service.project.service.BudgetPhaseLocalService.class)
	protected eu.strasbourg.service.project.service.BudgetPhaseLocalService budgetPhaseLocalService;
	@BeanReference(type = BudgetPhasePersistence.class)
	protected BudgetPhasePersistence budgetPhasePersistence;
	@BeanReference(type = eu.strasbourg.service.project.service.InitiativeLocalService.class)
	protected eu.strasbourg.service.project.service.InitiativeLocalService initiativeLocalService;
	@BeanReference(type = InitiativePersistence.class)
	protected InitiativePersistence initiativePersistence;
	@BeanReference(type = InitiativeHelpLocalService.class)
	protected InitiativeHelpLocalService initiativeHelpLocalService;
	@BeanReference(type = InitiativeHelpPersistence.class)
	protected InitiativeHelpPersistence initiativeHelpPersistence;
	@BeanReference(type = eu.strasbourg.service.project.service.ParticipationLocalService.class)
	protected eu.strasbourg.service.project.service.ParticipationLocalService participationLocalService;
	@BeanReference(type = ParticipationPersistence.class)
	protected ParticipationPersistence participationPersistence;
	@BeanReference(type = eu.strasbourg.service.project.service.PetitionLocalService.class)
	protected eu.strasbourg.service.project.service.PetitionLocalService petitionLocalService;
	@BeanReference(type = PetitionPersistence.class)
	protected PetitionPersistence petitionPersistence;
	@BeanReference(type = eu.strasbourg.service.project.service.PlacitPlaceLocalService.class)
	protected eu.strasbourg.service.project.service.PlacitPlaceLocalService placitPlaceLocalService;
	@BeanReference(type = PlacitPlacePersistence.class)
	protected PlacitPlacePersistence placitPlacePersistence;
	@BeanReference(type = eu.strasbourg.service.project.service.ProjectLocalService.class)
	protected eu.strasbourg.service.project.service.ProjectLocalService projectLocalService;
	@BeanReference(type = ProjectPersistence.class)
	protected ProjectPersistence projectPersistence;
	@BeanReference(type = eu.strasbourg.service.project.service.ProjectFollowedLocalService.class)
	protected eu.strasbourg.service.project.service.ProjectFollowedLocalService projectFollowedLocalService;
	@BeanReference(type = ProjectFollowedPersistence.class)
	protected ProjectFollowedPersistence projectFollowedPersistence;
	@BeanReference(type = eu.strasbourg.service.project.service.ProjectTimelineLocalService.class)
	protected eu.strasbourg.service.project.service.ProjectTimelineLocalService projectTimelineLocalService;
	@BeanReference(type = ProjectTimelinePersistence.class)
	protected ProjectTimelinePersistence projectTimelinePersistence;
	@BeanReference(type = eu.strasbourg.service.project.service.SignataireLocalService.class)
	protected eu.strasbourg.service.project.service.SignataireLocalService signataireLocalService;
	@BeanReference(type = SignatairePersistence.class)
	protected SignatairePersistence signatairePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetEntryLocalService.class)
	protected com.liferay.asset.kernel.service.AssetEntryLocalService assetEntryLocalService;
	@ServiceReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetLinkLocalService.class)
	protected com.liferay.asset.kernel.service.AssetLinkLocalService assetLinkLocalService;
	@ServiceReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetTagLocalService.class)
	protected com.liferay.asset.kernel.service.AssetTagLocalService assetTagLocalService;
	@ServiceReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}