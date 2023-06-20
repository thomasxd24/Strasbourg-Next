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

package eu.strasbourg.service.interest.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import eu.strasbourg.service.interest.service.persistence.UserInterestPK;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the UserInterest service. Represents a row in the &quot;interest_UserInterest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.interest.model.impl.UserInterestModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.interest.model.impl.UserInterestImpl</code>.
 * </p>
 *
 * @author BenjaminBini
 * @see UserInterest
 * @generated
 */
@ProviderType
public interface UserInterestModel extends BaseModel<UserInterest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user interest model instance should use the {@link UserInterest} interface instead.
	 */

	/**
	 * Returns the primary key of this user interest.
	 *
	 * @return the primary key of this user interest
	 */
	public UserInterestPK getPrimaryKey();

	/**
	 * Sets the primary key of this user interest.
	 *
	 * @param primaryKey the primary key of this user interest
	 */
	public void setPrimaryKey(UserInterestPK primaryKey);

	/**
	 * Returns the interest ID of this user interest.
	 *
	 * @return the interest ID of this user interest
	 */
	public long getInterestId();

	/**
	 * Sets the interest ID of this user interest.
	 *
	 * @param interestId the interest ID of this user interest
	 */
	public void setInterestId(long interestId);

	/**
	 * Returns the publik user ID of this user interest.
	 *
	 * @return the publik user ID of this user interest
	 */
	@AutoEscape
	public String getPublikUserId();

	/**
	 * Sets the publik user ID of this user interest.
	 *
	 * @param publikUserId the publik user ID of this user interest
	 */
	public void setPublikUserId(String publikUserId);

	@Override
	public UserInterest cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}