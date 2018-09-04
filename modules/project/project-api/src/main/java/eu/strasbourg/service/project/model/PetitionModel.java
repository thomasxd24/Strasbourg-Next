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
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;
import java.util.Date;

/**
 * The base model interface for the Petition service. Represents a row in the &quot;project_Petition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.project.model.impl.PetitionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.project.model.impl.PetitionImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see Petition
 * @see eu.strasbourg.service.project.model.impl.PetitionImpl
 * @see eu.strasbourg.service.project.model.impl.PetitionModelImpl
 * @generated
 */
@ProviderType
public interface PetitionModel extends BaseModel<Petition>, GroupedModel,
	ShardedModel, StagedAuditedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a petition model instance should use the {@link Petition} interface instead.
	 */

	/**
	 * Returns the primary key of this petition.
	 *
	 * @return the primary key of this petition
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this petition.
	 *
	 * @param primaryKey the primary key of this petition
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this petition.
	 *
	 * @return the uuid of this petition
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this petition.
	 *
	 * @param uuid the uuid of this petition
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the petition ID of this petition.
	 *
	 * @return the petition ID of this petition
	 */
	public long getPetitionId();

	/**
	 * Sets the petition ID of this petition.
	 *
	 * @param petitionId the petition ID of this petition
	 */
	public void setPetitionId(long petitionId);

	/**
	 * Returns the group ID of this petition.
	 *
	 * @return the group ID of this petition
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this petition.
	 *
	 * @param groupId the group ID of this petition
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this petition.
	 *
	 * @return the company ID of this petition
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this petition.
	 *
	 * @param companyId the company ID of this petition
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this petition.
	 *
	 * @return the user ID of this petition
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this petition.
	 *
	 * @param userId the user ID of this petition
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this petition.
	 *
	 * @return the user uuid of this petition
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this petition.
	 *
	 * @param userUuid the user uuid of this petition
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this petition.
	 *
	 * @return the user name of this petition
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this petition.
	 *
	 * @param userName the user name of this petition
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this petition.
	 *
	 * @return the create date of this petition
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this petition.
	 *
	 * @param createDate the create date of this petition
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this petition.
	 *
	 * @return the modified date of this petition
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this petition.
	 *
	 * @param modifiedDate the modified date of this petition
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this petition.
	 *
	 * @return the status of this petition
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this petition.
	 *
	 * @param status the status of this petition
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this petition.
	 *
	 * @return the status by user ID of this petition
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this petition.
	 *
	 * @param statusByUserId the status by user ID of this petition
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this petition.
	 *
	 * @return the status by user uuid of this petition
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this petition.
	 *
	 * @param statusByUserUuid the status by user uuid of this petition
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this petition.
	 *
	 * @return the status by user name of this petition
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this petition.
	 *
	 * @param statusByUserName the status by user name of this petition
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this petition.
	 *
	 * @return the status date of this petition
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this petition.
	 *
	 * @param statusDate the status date of this petition
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this petition.
	 *
	 * @return the title of this petition
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this petition.
	 *
	 * @param title the title of this petition
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this petition.
	 *
	 * @return the description of this petition
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this petition.
	 *
	 * @param description the description of this petition
	 */
	public void setDescription(String description);

	/**
	 * Returns the place text area of this petition.
	 *
	 * @return the place text area of this petition
	 */
	@AutoEscape
	public String getPlaceTextArea();

	/**
	 * Sets the place text area of this petition.
	 *
	 * @param placeTextArea the place text area of this petition
	 */
	public void setPlaceTextArea(String placeTextArea);

	/**
	 * Returns the files download of this petition.
	 *
	 * @return the files download of this petition
	 */
	@AutoEscape
	public String getFilesDownload();

	/**
	 * Sets the files download of this petition.
	 *
	 * @param filesDownload the files download of this petition
	 */
	public void setFilesDownload(String filesDownload);

	/**
	 * Returns the publication date of this petition.
	 *
	 * @return the publication date of this petition
	 */
	public Date getPublicationDate();

	/**
	 * Sets the publication date of this petition.
	 *
	 * @param publicationDate the publication date of this petition
	 */
	public void setPublicationDate(Date publicationDate);

	/**
	 * Returns the expiration date of this petition.
	 *
	 * @return the expiration date of this petition
	 */
	public Date getExpirationDate();

	/**
	 * Sets the expiration date of this petition.
	 *
	 * @param expirationDate the expiration date of this petition
	 */
	public void setExpirationDate(Date expirationDate);

	/**
	 * Returns the quota signature of this petition.
	 *
	 * @return the quota signature of this petition
	 */
	public long getQuotaSignature();

	/**
	 * Sets the quota signature of this petition.
	 *
	 * @param quotaSignature the quota signature of this petition
	 */
	public void setQuotaSignature(long quotaSignature);

	/**
	 * Returns the video url of this petition.
	 *
	 * @return the video url of this petition
	 */
	@AutoEscape
	public String getVideoUrl();

	/**
	 * Sets the video url of this petition.
	 *
	 * @param videoUrl the video url of this petition
	 */
	public void setVideoUrl(String videoUrl);

	/**
	 * Returns the external image url of this petition.
	 *
	 * @return the external image url of this petition
	 */
	@AutoEscape
	public String getExternalImageURL();

	/**
	 * Sets the external image url of this petition.
	 *
	 * @param externalImageURL the external image url of this petition
	 */
	public void setExternalImageURL(String externalImageURL);

	/**
	 * Returns the external image copyright of this petition.
	 *
	 * @return the external image copyright of this petition
	 */
	@AutoEscape
	public String getExternalImageCopyright();

	/**
	 * Sets the external image copyright of this petition.
	 *
	 * @param externalImageCopyright the external image copyright of this petition
	 */
	public void setExternalImageCopyright(String externalImageCopyright);

	/**
	 * Returns the media choice of this petition.
	 *
	 * @return the media choice of this petition
	 */
	public boolean getMediaChoice();

	/**
	 * Returns <code>true</code> if this petition is media choice.
	 *
	 * @return <code>true</code> if this petition is media choice; <code>false</code> otherwise
	 */
	public boolean isMediaChoice();

	/**
	 * Sets whether this petition is media choice.
	 *
	 * @param mediaChoice the media choice of this petition
	 */
	public void setMediaChoice(boolean mediaChoice);

	/**
	 * Returns the consultation places body of this petition.
	 *
	 * @return the consultation places body of this petition
	 */
	@AutoEscape
	public String getConsultationPlacesBody();

	/**
	 * Sets the consultation places body of this petition.
	 *
	 * @param consultationPlacesBody the consultation places body of this petition
	 */
	public void setConsultationPlacesBody(String consultationPlacesBody);

	/**
	 * Returns the publik ID of this petition.
	 *
	 * @return the publik ID of this petition
	 */
	@AutoEscape
	public String getPublikId();

	/**
	 * Sets the publik ID of this petition.
	 *
	 * @param publikId the publik ID of this petition
	 */
	public void setPublikId(String publikId);

	/**
	 * Returns the image ID of this petition.
	 *
	 * @return the image ID of this petition
	 */
	public long getImageId();

	/**
	 * Sets the image ID of this petition.
	 *
	 * @param imageId the image ID of this petition
	 */
	public void setImageId(long imageId);

	/**
	 * Returns the files IDs of this petition.
	 *
	 * @return the files IDs of this petition
	 */
	@AutoEscape
	public String getFilesIds();

	/**
	 * Sets the files IDs of this petition.
	 *
	 * @param filesIds the files IDs of this petition
	 */
	public void setFilesIds(String filesIds);

	/**
	 * Returns <code>true</code> if this petition is approved.
	 *
	 * @return <code>true</code> if this petition is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this petition is denied.
	 *
	 * @return <code>true</code> if this petition is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this petition is a draft.
	 *
	 * @return <code>true</code> if this petition is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this petition is expired.
	 *
	 * @return <code>true</code> if this petition is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this petition is inactive.
	 *
	 * @return <code>true</code> if this petition is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this petition is incomplete.
	 *
	 * @return <code>true</code> if this petition is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this petition is pending.
	 *
	 * @return <code>true</code> if this petition is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this petition is scheduled.
	 *
	 * @return <code>true</code> if this petition is scheduled; <code>false</code> otherwise
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
	public int compareTo(eu.strasbourg.service.project.model.Petition petition);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.project.model.Petition> toCacheModel();

	@Override
	public eu.strasbourg.service.project.model.Petition toEscapedModel();

	@Override
	public eu.strasbourg.service.project.model.Petition toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}