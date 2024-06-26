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

package eu.strasbourg.service.oidc.model.impl;

import org.osgi.annotation.versioning.ProviderType;

import java.util.Date;

/**
 * The extended model implementation for the PublikUser service. Represents a row in the &quot;publik_PublikUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.oidc.model.PublikUser} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class PublikUserImpl extends PublikUserBaseImpl {

	private static final long serialVersionUID = -3749806145234327527L;

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a publik user model instance should use the {@link eu.strasbourg.service.oidc.model.PublikUser} interface instead.
	 */
	public PublikUserImpl() {
	}
	
	/**
	 * L'utilisateur est-il en perdiode de bannissement ?
	 */
	@Override
	public boolean isBanned() {
		Date now = new Date();
		
		if (this.getBanishDate() != null) {
			if (this.getBanishDate().compareTo(now) > 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Retourne l'image de profil ou le substitut
	 */
	@Override
	public String getImageURLOrSurrogate() {
		if (!this.getImageURL().equals("")) {
			return this.getImageURL();
		} else {
			return "/o/plateforme-citoyenne-theme/images/medias/user_female_portrait.png";
		}
	}

}