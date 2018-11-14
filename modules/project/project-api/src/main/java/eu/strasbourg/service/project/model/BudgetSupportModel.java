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

package eu.strasbourg.service.project.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the BudgetSupport service. Represents a row in the &quot;project_BudgetSupport&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.project.model.impl.BudgetSupportModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.project.model.impl.BudgetSupportImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see BudgetSupport
 * @see eu.strasbourg.service.project.model.impl.BudgetSupportImpl
 * @see eu.strasbourg.service.project.model.impl.BudgetSupportModelImpl
 * @generated
 */
@ProviderType
public interface BudgetSupportModel extends BaseModel<BudgetSupport>,
	ShardedModel, StagedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a budget support model instance should use the {@link BudgetSupport} interface instead.
	 */

	/**
	 * Returns the primary key of this budget support.
	 *
	 * @return the primary key of this budget support
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this budget support.
	 *
	 * @param primaryKey the primary key of this budget support
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this budget support.
	 *
	 * @return the uuid of this budget support
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this budget support.
	 *
	 * @param uuid the uuid of this budget support
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the budget support ID of this budget support.
	 *
	 * @return the budget support ID of this budget support
	 */
	public long getBudgetSupportId();

	/**
	 * Sets the budget support ID of this budget support.
	 *
	 * @param budgetSupportId the budget support ID of this budget support
	 */
	public void setBudgetSupportId(long budgetSupportId);

	/**
	 * Returns the group ID of this budget support.
	 *
	 * @return the group ID of this budget support
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this budget support.
	 *
	 * @param groupId the group ID of this budget support
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this budget support.
	 *
	 * @return the company ID of this budget support
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this budget support.
	 *
	 * @param companyId the company ID of this budget support
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this budget support.
	 *
	 * @return the create date of this budget support
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this budget support.
	 *
	 * @param createDate the create date of this budget support
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this budget support.
	 *
	 * @return the modified date of this budget support
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this budget support.
	 *
	 * @param modifiedDate the modified date of this budget support
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this budget support.
	 *
	 * @return the status of this budget support
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this budget support.
	 *
	 * @param status the status of this budget support
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this budget support.
	 *
	 * @return the status by user ID of this budget support
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this budget support.
	 *
	 * @param statusByUserId the status by user ID of this budget support
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this budget support.
	 *
	 * @return the status by user uuid of this budget support
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this budget support.
	 *
	 * @param statusByUserUuid the status by user uuid of this budget support
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this budget support.
	 *
	 * @return the status by user name of this budget support
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this budget support.
	 *
	 * @param statusByUserName the status by user name of this budget support
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this budget support.
	 *
	 * @return the status date of this budget support
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this budget support.
	 *
	 * @param statusDate the status date of this budget support
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the citoyen last name of this budget support.
	 *
	 * @return the citoyen last name of this budget support
	 */
	@AutoEscape
	public String getCitoyenLastName();

	/**
	 * Sets the citoyen last name of this budget support.
	 *
	 * @param citoyenLastName the citoyen last name of this budget support
	 */
	public void setCitoyenLastName(String citoyenLastName);

	/**
	 * Returns the citoyen firstname of this budget support.
	 *
	 * @return the citoyen firstname of this budget support
	 */
	@AutoEscape
	public String getCitoyenFirstname();

	/**
	 * Sets the citoyen firstname of this budget support.
	 *
	 * @param citoyenFirstname the citoyen firstname of this budget support
	 */
	public void setCitoyenFirstname(String citoyenFirstname);

	/**
	 * Returns the citoyen birthday of this budget support.
	 *
	 * @return the citoyen birthday of this budget support
	 */
	public Date getCitoyenBirthday();

	/**
	 * Sets the citoyen birthday of this budget support.
	 *
	 * @param citoyenBirthday the citoyen birthday of this budget support
	 */
	public void setCitoyenBirthday(Date citoyenBirthday);

	/**
	 * Returns the citoyen address of this budget support.
	 *
	 * @return the citoyen address of this budget support
	 */
	@AutoEscape
	public String getCitoyenAddress();

	/**
	 * Sets the citoyen address of this budget support.
	 *
	 * @param citoyenAddress the citoyen address of this budget support
	 */
	public void setCitoyenAddress(String citoyenAddress);

	/**
	 * Returns the citoyen mail of this budget support.
	 *
	 * @return the citoyen mail of this budget support
	 */
	@AutoEscape
	public String getCitoyenMail();

	/**
	 * Sets the citoyen mail of this budget support.
	 *
	 * @param citoyenMail the citoyen mail of this budget support
	 */
	public void setCitoyenMail(String citoyenMail);

	/**
	 * Returns the citoyen postal code of this budget support.
	 *
	 * @return the citoyen postal code of this budget support
	 */
	public long getCitoyenPostalCode();

	/**
	 * Sets the citoyen postal code of this budget support.
	 *
	 * @param citoyenPostalCode the citoyen postal code of this budget support
	 */
	public void setCitoyenPostalCode(long citoyenPostalCode);

	/**
	 * Returns the citoyen mobile phone of this budget support.
	 *
	 * @return the citoyen mobile phone of this budget support
	 */
	@AutoEscape
	public String getCitoyenMobilePhone();

	/**
	 * Sets the citoyen mobile phone of this budget support.
	 *
	 * @param citoyenMobilePhone the citoyen mobile phone of this budget support
	 */
	public void setCitoyenMobilePhone(String citoyenMobilePhone);

	/**
	 * Returns the citoyen phone of this budget support.
	 *
	 * @return the citoyen phone of this budget support
	 */
	@AutoEscape
	public String getCitoyenPhone();

	/**
	 * Sets the citoyen phone of this budget support.
	 *
	 * @param citoyenPhone the citoyen phone of this budget support
	 */
	public void setCitoyenPhone(String citoyenPhone);

	/**
	 * Returns the citoyen city of this budget support.
	 *
	 * @return the citoyen city of this budget support
	 */
	@AutoEscape
	public String getCitoyenCity();

	/**
	 * Sets the citoyen city of this budget support.
	 *
	 * @param citoyenCity the citoyen city of this budget support
	 */
	public void setCitoyenCity(String citoyenCity);

	/**
	 * Returns the citoyen signature date of this budget support.
	 *
	 * @return the citoyen signature date of this budget support
	 */
	public Date getCitoyenSignatureDate();

	/**
	 * Sets the citoyen signature date of this budget support.
	 *
	 * @param citoyenSignatureDate the citoyen signature date of this budget support
	 */
	public void setCitoyenSignatureDate(Date citoyenSignatureDate);

	/**
	 * Returns the publik user ID of this budget support.
	 *
	 * @return the publik user ID of this budget support
	 */
	@AutoEscape
	public String getPublikUserId();

	/**
	 * Sets the publik user ID of this budget support.
	 *
	 * @param publikUserId the publik user ID of this budget support
	 */
	public void setPublikUserId(String publikUserId);

	/**
	 * Returns the budget participatif ID of this budget support.
	 *
	 * @return the budget participatif ID of this budget support
	 */
	public long getBudgetParticipatifId();

	/**
	 * Sets the budget participatif ID of this budget support.
	 *
	 * @param budgetParticipatifId the budget participatif ID of this budget support
	 */
	public void setBudgetParticipatifId(long budgetParticipatifId);

	/**
	 * Returns <code>true</code> if this budget support is approved.
	 *
	 * @return <code>true</code> if this budget support is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this budget support is denied.
	 *
	 * @return <code>true</code> if this budget support is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this budget support is a draft.
	 *
	 * @return <code>true</code> if this budget support is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this budget support is expired.
	 *
	 * @return <code>true</code> if this budget support is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this budget support is inactive.
	 *
	 * @return <code>true</code> if this budget support is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this budget support is incomplete.
	 *
	 * @return <code>true</code> if this budget support is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this budget support is pending.
	 *
	 * @return <code>true</code> if this budget support is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this budget support is scheduled.
	 *
	 * @return <code>true</code> if this budget support is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		eu.strasbourg.service.project.model.BudgetSupport budgetSupport);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.project.model.BudgetSupport> toCacheModel();

	@Override
	public eu.strasbourg.service.project.model.BudgetSupport toEscapedModel();

	@Override
	public eu.strasbourg.service.project.model.BudgetSupport toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}