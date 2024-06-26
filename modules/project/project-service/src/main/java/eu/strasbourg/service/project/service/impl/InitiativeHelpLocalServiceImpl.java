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

package eu.strasbourg.service.project.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import eu.strasbourg.service.project.exception.NoSuchInitiativeHelpException;
import eu.strasbourg.service.project.model.InitiativeHelp;
import eu.strasbourg.service.project.service.base.InitiativeHelpLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the initiative help local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.project.service.InitiativeHelpLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Cedric Henry
 * @see InitiativeHelpLocalServiceBaseImpl
 * @see eu.strasbourg.service.project.service.InitiativeHelpLocalServiceUtil
 */
public class InitiativeHelpLocalServiceImpl extends InitiativeHelpLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link eu.strasbourg.service.project.service.InitiativeHelpLocalServiceUtil} to access the initiative help local service.
	 */
	
	public final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
	
	/**
     * Methode de creation d'une initiative
     * @param sc Le contexte de la requete.
     * @return L'aide cree.
     */
    @Override
	public InitiativeHelp createInitiativeHelp(ServiceContext sc){
		long pk = this.counterLocalService.increment();
		
		InitiativeHelp result = this.initiativeHelpLocalService.createInitiativeHelp(pk);
		
		result.setGroupId(sc.getScopeGroupId());
		result.setCreateDate(new Date());
		
		return result;
	}
    
    /**
     * Supprimer un soutien donne
     * @param initiativeHelpId Id de l'aide inititative
     */
    @Override
    public InitiativeHelp removeInitiativeHelp(long initiativeHelpId){
		try {
			InitiativeHelp result = this.initiativeHelpPersistence.remove(initiativeHelpId);
			return result;
		} catch (NoSuchInitiativeHelpException e) {
			_log.error("Pas d'aide initiative : ", e);
		}
		
		return null;
	}
	
	/**
	 * Retourne la liste des aides d'une initiative
	 */
	@Override
	public List<InitiativeHelp> getByInitiativeId(long initiativeId) {
		return this.initiativeHelpPersistence.findByinitiativeId(initiativeId);
	}
	
	/**
	 * Retourne l'aide proposee par un utilisateur pour une initiative donnee
	 */
	@Override
	public InitiativeHelp getByPublikUserIdAndInitiativeId(String publikUserId, long initiativeId) {
		return this.initiativeHelpPersistence.fetchByPublikUserIdAndInitiativeId(publikUserId, initiativeId);
	}
	
	/**
	 * Retourne les aides proposees par un utilisateur
	 */
	@Override
	public List<InitiativeHelp> getByPublikUserId(String publikUserId) {
		return this.initiativeHelpPersistence.findByPublikUserId(publikUserId);
	}
	
}