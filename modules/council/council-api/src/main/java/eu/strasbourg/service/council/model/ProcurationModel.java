/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Procuration service. Represents a row in the &quot;council_Procuration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.council.model.impl.ProcurationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.council.model.impl.ProcurationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Procuration
 * @generated
 */
@ProviderType
public interface ProcurationModel
	extends BaseModel<Procuration>, GroupedModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a procuration model instance should use the {@link Procuration} interface instead.
	 */

	/**
	 * Returns the primary key of this procuration.
	 *
	 * @return the primary key of this procuration
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this procuration.
	 *
	 * @param primaryKey the primary key of this procuration
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this procuration.
	 *
	 * @return the uuid of this procuration
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this procuration.
	 *
	 * @param uuid the uuid of this procuration
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the procuration ID of this procuration.
	 *
	 * @return the procuration ID of this procuration
	 */
	public long getProcurationId();

	/**
	 * Sets the procuration ID of this procuration.
	 *
	 * @param procurationId the procuration ID of this procuration
	 */
	public void setProcurationId(long procurationId);

	/**
	 * Returns the group ID of this procuration.
	 *
	 * @return the group ID of this procuration
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this procuration.
	 *
	 * @param groupId the group ID of this procuration
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this procuration.
	 *
	 * @return the company ID of this procuration
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this procuration.
	 *
	 * @param companyId the company ID of this procuration
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this procuration.
	 *
	 * @return the user ID of this procuration
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this procuration.
	 *
	 * @param userId the user ID of this procuration
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this procuration.
	 *
	 * @return the user uuid of this procuration
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this procuration.
	 *
	 * @param userUuid the user uuid of this procuration
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this procuration.
	 *
	 * @return the user name of this procuration
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this procuration.
	 *
	 * @param userName the user name of this procuration
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this procuration.
	 *
	 * @return the create date of this procuration
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this procuration.
	 *
	 * @param createDate the create date of this procuration
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this procuration.
	 *
	 * @return the modified date of this procuration
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this procuration.
	 *
	 * @param modifiedDate the modified date of this procuration
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this procuration.
	 *
	 * @return the status of this procuration
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this procuration.
	 *
	 * @param status the status of this procuration
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this procuration.
	 *
	 * @return the status by user ID of this procuration
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this procuration.
	 *
	 * @param statusByUserId the status by user ID of this procuration
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this procuration.
	 *
	 * @return the status by user uuid of this procuration
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this procuration.
	 *
	 * @param statusByUserUuid the status by user uuid of this procuration
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this procuration.
	 *
	 * @return the status by user name of this procuration
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this procuration.
	 *
	 * @param statusByUserName the status by user name of this procuration
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this procuration.
	 *
	 * @return the status date of this procuration
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this procuration.
	 *
	 * @param statusDate the status date of this procuration
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the official voters ID of this procuration.
	 *
	 * @return the official voters ID of this procuration
	 */
	public long getOfficialVotersId();

	/**
	 * Sets the official voters ID of this procuration.
	 *
	 * @param officialVotersId the official voters ID of this procuration
	 */
	public void setOfficialVotersId(long officialVotersId);

	/**
	 * Returns the official unavailable ID of this procuration.
	 *
	 * @return the official unavailable ID of this procuration
	 */
	public long getOfficialUnavailableId();

	/**
	 * Sets the official unavailable ID of this procuration.
	 *
	 * @param officialUnavailableId the official unavailable ID of this procuration
	 */
	public void setOfficialUnavailableId(long officialUnavailableId);

	/**
	 * Returns the council session ID of this procuration.
	 *
	 * @return the council session ID of this procuration
	 */
	public long getCouncilSessionId();

	/**
	 * Sets the council session ID of this procuration.
	 *
	 * @param councilSessionId the council session ID of this procuration
	 */
	public void setCouncilSessionId(long councilSessionId);

	/**
	 * Returns the is absent of this procuration.
	 *
	 * @return the is absent of this procuration
	 */
	public boolean getIsAbsent();

	/**
	 * Returns <code>true</code> if this procuration is is absent.
	 *
	 * @return <code>true</code> if this procuration is is absent; <code>false</code> otherwise
	 */
	public boolean isIsAbsent();

	/**
	 * Sets whether this procuration is is absent.
	 *
	 * @param isAbsent the is absent of this procuration
	 */
	public void setIsAbsent(boolean isAbsent);

	/**
	 * Returns the procuration mode of this procuration.
	 *
	 * @return the procuration mode of this procuration
	 */
	public int getProcurationMode();

	/**
	 * Sets the procuration mode of this procuration.
	 *
	 * @param procurationMode the procuration mode of this procuration
	 */
	public void setProcurationMode(int procurationMode);

	/**
	 * Returns the presential of this procuration.
	 *
	 * @return the presential of this procuration
	 */
	public int getPresential();

	/**
	 * Sets the presential of this procuration.
	 *
	 * @param presential the presential of this procuration
	 */
	public void setPresential(int presential);

	/**
	 * Returns the is after vote of this procuration.
	 *
	 * @return the is after vote of this procuration
	 */
	public boolean getIsAfterVote();

	/**
	 * Returns <code>true</code> if this procuration is is after vote.
	 *
	 * @return <code>true</code> if this procuration is is after vote; <code>false</code> otherwise
	 */
	public boolean isIsAfterVote();

	/**
	 * Sets whether this procuration is is after vote.
	 *
	 * @param isAfterVote the is after vote of this procuration
	 */
	public void setIsAfterVote(boolean isAfterVote);

	/**
	 * Returns the start hour of this procuration.
	 *
	 * @return the start hour of this procuration
	 */
	public Date getStartHour();

	/**
	 * Sets the start hour of this procuration.
	 *
	 * @param startHour the start hour of this procuration
	 */
	public void setStartHour(Date startHour);

	/**
	 * Returns the end hour of this procuration.
	 *
	 * @return the end hour of this procuration
	 */
	public Date getEndHour();

	/**
	 * Sets the end hour of this procuration.
	 *
	 * @param endHour the end hour of this procuration
	 */
	public void setEndHour(Date endHour);

	/**
	 * Returns the start delib of this procuration.
	 *
	 * @return the start delib of this procuration
	 */
	public long getStartDelib();

	/**
	 * Sets the start delib of this procuration.
	 *
	 * @param startDelib the start delib of this procuration
	 */
	public void setStartDelib(long startDelib);

	/**
	 * Returns the end delib of this procuration.
	 *
	 * @return the end delib of this procuration
	 */
	public long getEndDelib();

	/**
	 * Sets the end delib of this procuration.
	 *
	 * @param endDelib the end delib of this procuration
	 */
	public void setEndDelib(long endDelib);

	/**
	 * Returns the other procuration mode of this procuration.
	 *
	 * @return the other procuration mode of this procuration
	 */
	@AutoEscape
	public String getOtherProcurationMode();

	/**
	 * Sets the other procuration mode of this procuration.
	 *
	 * @param otherProcurationMode the other procuration mode of this procuration
	 */
	public void setOtherProcurationMode(String otherProcurationMode);

	/**
	 * Returns <code>true</code> if this procuration is approved.
	 *
	 * @return <code>true</code> if this procuration is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this procuration is denied.
	 *
	 * @return <code>true</code> if this procuration is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this procuration is a draft.
	 *
	 * @return <code>true</code> if this procuration is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this procuration is expired.
	 *
	 * @return <code>true</code> if this procuration is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this procuration is inactive.
	 *
	 * @return <code>true</code> if this procuration is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this procuration is incomplete.
	 *
	 * @return <code>true</code> if this procuration is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this procuration is pending.
	 *
	 * @return <code>true</code> if this procuration is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this procuration is scheduled.
	 *
	 * @return <code>true</code> if this procuration is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public Procuration cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}