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

package eu.strasbourg.service.like.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.like.exception.NoSuchLikeException;
import eu.strasbourg.service.like.model.Like;
import eu.strasbourg.service.like.model.LikeType;
import eu.strasbourg.service.like.service.base.LikeServiceBaseImpl;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * The implementation of the like remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.like.service.LikeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Cedric Henry
 * @see LikeServiceBaseImpl
 * @see eu.strasbourg.service.like.service.LikeServiceUtil
 */
public class LikeServiceImpl extends LikeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link eu.strasbourg.service.like.service.LikeServiceUtil} to access the like remote service.
	 */

	/**
	 * Retourne la liste des types de likes/dislikes
	 */
	@Override
	public JSONObject getTypes() {
		if (!isAuthorized()) {
			return error("not authorized");
		}
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		JSONArray jsonTypes = JSONFactoryUtil.createJSONArray();
		
		for (LikeType type : LikeType.values()) {
			JSONObject jsonType = JSONFactoryUtil.createJSONObject();
			jsonType.put("id", type.getId());
			jsonType.put("name", type.getName());
			jsonTypes.put(jsonType);
		}
		result.put("types", jsonTypes);
		return result;
	}
	
	/**
	 * Retourne les likes d'un utilisateur
	 */
	@Override
	public JSONObject getUserLikes(String userId) {
		if (!isAuthorized()) {
			return error("not authorized");
		}
		
		JSONObject result = JSONFactoryUtil.createJSONObject();
		JSONArray jsonLikes = JSONFactoryUtil.createJSONArray();
		
		List<Like> likes = this.likeLocalService.getByPublikUser(userId);
		for (Like like : likes) {
			jsonLikes.put(like.toJSON());
		}
		
		result.put("likes", jsonLikes);
		return result;
	}
	
	/**
	 * Ajoute un like/dislike d'un utilisateur a une entite
	 */
	@Override
	public JSONObject addLike(String userId, String title, boolean isDislike, long typeId, long entityId) {
		if (!isAuthorized()) {
			return error("not authorized");
		}
		
		// Vérification du type
		LikeType type = LikeType.get(typeId);
		if (type == null) {
			return error("type does not exist");
		}
		
		// Validations d'autres champs
		if (Validator.isNull(title)) {
			return error("title is empty");
		}
		if (Validator.isNotNull(isDislike)) {
			return error("like type is not valid");
		}

		// Création de l'objet
		Like like = this.likeLocalService.createLike();
		like.setTitle(title);
		like.setIsDislike(isDislike);
		like.setTypeId(typeId);
		like.setPublikUserId(userId);
		like.setEntityId(entityId);
		
		this.likeLocalService.updateLike(like);
		
		return success("like added");
	}
	
	/**
	 * Ajoute un like à un utilisateur
	 */
	@Override
	public JSONObject addLikeLink(String title, boolean isDislike, long typeId, long entityId, long entityGroupId) {		
		HttpServletRequest  request = ServiceContextThreadLocal.getServiceContext().getRequest();
		boolean isLoggedIn = SessionParamUtil.getBoolean(request, "publik_logged_in");
		boolean isNotBanish = SessionParamUtil.getBoolean(request, "is_banish");
		
		if (isLoggedIn && !isNotBanish) {
		    String id = SessionParamUtil.getString(request, "publik_internal_id");
		    
		    Like likeExist = null;
		    boolean mindChanged = false;
		    
		    try {
		    	likeExist = this.likePersistence.findByAllAttributesExceptIsDislike(id, title, typeId, entityId);
			} catch (NoSuchLikeException e) {
				// C'est ce qu'on espere
			}
		    // Si il n'est pas nul, on le supprime
		    if(likeExist != null) {
		    	this.likeLocalService.deleteLike(likeExist);
		    	
		    	// Si le type du like est le même, c'est une suppression de like
			    if (isDislike == likeExist.getIsDislike()) {
			    	return isDislike ? success("dislike deleted") : success("like deleted");
			    }
			    // Sinon c'est un changement d'avis
			    else {
			    	mindChanged = true;
			    }
		    }
		    
			// Création de l'objet
			Like like = this.likeLocalService.createLike();
			like.setTitle(title);
			like.setIsDislike(isDislike);
			like.setTypeId(typeId);
			like.setPublikUserId(id);
			like.setEntityId(entityId);
			like.setEntityGroupId(entityGroupId);
			
			this.likeLocalService.updateLike(like);
			
			if (mindChanged) {
				return isDislike ? success("dislike mind changed added") : success("like mind changed added");
			} else {
				return isDislike ? success("dislike added") : success("like added");
			}
			
		} else {
			return isLoggedIn ? error("isBanned") : error("notConnected") ;
		}
	}
	
	/**
	 * Supprime un like d'un utilisateur
	 */
	public JSONObject deleteLike(String userId, long likeId) {
		if (!isAuthorized()) {
			return error("not authorized");
		}
		
		Like like = this.likeLocalService.fetchLike(likeId);
		if (like == null) {
			return error("like does not exist");
		}
		if (!like.getPublikUserId().equals(userId)) {
			return error("like does not belong to user");
		}
		try {
			this.likeLocalService.deleteLike(likeId);
			return success("like deleted");
		} catch (PortalException e) {
			return error("unknown error");
		}
		
	}
	
	
	/**
	 * Supprime un like d'un utilisateur
	 */
	@Override
	public JSONObject deleteLikeLink(String title, String url, boolean isDislike, long typeId, long entityId) {		
		HttpServletRequest  request = ServiceContextThreadLocal.getServiceContext().getRequest();
		boolean isLoggedIn = SessionParamUtil.getBoolean(request, "publik_logged_in");
		boolean isNotBanish = SessionParamUtil.getBoolean(request, "is_banish");
		if (isLoggedIn && !isNotBanish) {
		    String id = SessionParamUtil.getString(request, "publik_internal_id");
		    
		    Like like = null;
		    
			try {
				like = this.likePersistence.findByAllAttributes(id, title, isDislike, typeId, entityId);
			} catch (NoSuchLikeException e) {
				// Possiblement plusieurs onglets d'ouvert et déjà supprimé sur l'un d'eux
				return success("like deleted");
			}
			
			try {
				this.likeLocalService.deleteLike(like.getLikeId());
			} catch (PortalException e) {
				return error("unknown error");
			}
			
			return success("like deleted");
		} else {
			return isLoggedIn ? error("isBanned") : error("notConnected") ;
		}
	}
	
	private boolean isAuthorized() {
		try {
			Company defaultCompany = CompanyLocalServiceUtil.getCompanyByWebId("liferay.com");
			long globalGroupId = defaultCompany.getGroup().getGroupId();
			return this.getPermissionChecker().hasPermission(globalGroupId, StrasbourgPortletKeys.NOTIFICATION_BO,
					StrasbourgPortletKeys.NOTIFICATION_BO, "CONTRIBUTE");
		} catch (PortalException e) {
			return false;
		}
	}
	
	private JSONObject success(String message) {
		return JSONFactoryUtil.createJSONObject().put("success", message);
	}

	private JSONObject error(String message) {
		return JSONFactoryUtil.createJSONObject().put("error", message);
	}
	
}