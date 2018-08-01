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

package eu.strasbourg.service.petition.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Petition}.
 * </p>
 *
 * @author Alexandre QUERE
 * @see Petition
 * @generated
 */
@ProviderType
public class PetitionWrapper implements Petition, ModelWrapper<Petition> {
	public PetitionWrapper(Petition petition) {
		_petition = petition;
	}

	@Override
	public Class<?> getModelClass() {
		return Petition.class;
	}

	@Override
	public String getModelClassName() {
		return Petition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("petitionId", getPetitionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("title", getTitle());
		attributes.put("videoURL", getVideoURL());
		attributes.put("pictureURL", getPictureURL());
		attributes.put("isVideo", getIsVideo());
		attributes.put("description", getDescription());
		attributes.put("placeTextArea", getPlaceTextArea());
		attributes.put("filesDownload", getFilesDownload());
		attributes.put("publicationDate", getPublicationDate());
		attributes.put("expirationDate", getExpirationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long petitionId = (Long)attributes.get("petitionId");

		if (petitionId != null) {
			setPetitionId(petitionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String videoURL = (String)attributes.get("videoURL");

		if (videoURL != null) {
			setVideoURL(videoURL);
		}

		String pictureURL = (String)attributes.get("pictureURL");

		if (pictureURL != null) {
			setPictureURL(pictureURL);
		}

		Boolean isVideo = (Boolean)attributes.get("isVideo");

		if (isVideo != null) {
			setIsVideo(isVideo);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String placeTextArea = (String)attributes.get("placeTextArea");

		if (placeTextArea != null) {
			setPlaceTextArea(placeTextArea);
		}

		String filesDownload = (String)attributes.get("filesDownload");

		if (filesDownload != null) {
			setFilesDownload(filesDownload);
		}

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}
	}

	/**
	* Returns the is video of this petition.
	*
	* @return the is video of this petition
	*/
	@Override
	public boolean getIsVideo() {
		return _petition.getIsVideo();
	}

	/**
	* Returns <code>true</code> if this petition is approved.
	*
	* @return <code>true</code> if this petition is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _petition.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _petition.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this petition is denied.
	*
	* @return <code>true</code> if this petition is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _petition.isDenied();
	}

	/**
	* Returns <code>true</code> if this petition is a draft.
	*
	* @return <code>true</code> if this petition is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _petition.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _petition.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this petition is expired.
	*
	* @return <code>true</code> if this petition is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _petition.isExpired();
	}

	/**
	* Returns <code>true</code> if this petition is inactive.
	*
	* @return <code>true</code> if this petition is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _petition.isInactive();
	}

	/**
	* Returns <code>true</code> if this petition is incomplete.
	*
	* @return <code>true</code> if this petition is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _petition.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this petition is is video.
	*
	* @return <code>true</code> if this petition is is video; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsVideo() {
		return _petition.isIsVideo();
	}

	@Override
	public boolean isNew() {
		return _petition.isNew();
	}

	/**
	* Returns <code>true</code> if this petition is pending.
	*
	* @return <code>true</code> if this petition is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _petition.isPending();
	}

	/**
	* Returns <code>true</code> if this petition is scheduled.
	*
	* @return <code>true</code> if this petition is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _petition.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _petition.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<eu.strasbourg.service.petition.model.Petition> toCacheModel() {
		return _petition.toCacheModel();
	}

	@Override
	public eu.strasbourg.service.petition.model.Petition toEscapedModel() {
		return new PetitionWrapper(_petition.toEscapedModel());
	}

	@Override
	public eu.strasbourg.service.petition.model.Petition toUnescapedModel() {
		return new PetitionWrapper(_petition.toUnescapedModel());
	}

	@Override
	public int compareTo(eu.strasbourg.service.petition.model.Petition petition) {
		return _petition.compareTo(petition);
	}

	/**
	* Returns the status of this petition.
	*
	* @return the status of this petition
	*/
	@Override
	public int getStatus() {
		return _petition.getStatus();
	}

	@Override
	public int hashCode() {
		return _petition.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _petition.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PetitionWrapper((Petition)_petition.clone());
	}

	/**
	* Returns the description of this petition.
	*
	* @return the description of this petition
	*/
	@Override
	public java.lang.String getDescription() {
		return _petition.getDescription();
	}

	/**
	* Returns the files download of this petition.
	*
	* @return the files download of this petition
	*/
	@Override
	public java.lang.String getFilesDownload() {
		return _petition.getFilesDownload();
	}

	/**
	* Returns the picture url of this petition.
	*
	* @return the picture url of this petition
	*/
	@Override
	public java.lang.String getPictureURL() {
		return _petition.getPictureURL();
	}

	/**
	* Returns the place text area of this petition.
	*
	* @return the place text area of this petition
	*/
	@Override
	public java.lang.String getPlaceTextArea() {
		return _petition.getPlaceTextArea();
	}

	/**
	* Returns the status by user name of this petition.
	*
	* @return the status by user name of this petition
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _petition.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this petition.
	*
	* @return the status by user uuid of this petition
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _petition.getStatusByUserUuid();
	}

	/**
	* Returns the title of this petition.
	*
	* @return the title of this petition
	*/
	@Override
	public java.lang.String getTitle() {
		return _petition.getTitle();
	}

	/**
	* Returns the user name of this petition.
	*
	* @return the user name of this petition
	*/
	@Override
	public java.lang.String getUserName() {
		return _petition.getUserName();
	}

	/**
	* Returns the user uuid of this petition.
	*
	* @return the user uuid of this petition
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _petition.getUserUuid();
	}

	/**
	* Returns the uuid of this petition.
	*
	* @return the uuid of this petition
	*/
	@Override
	public java.lang.String getUuid() {
		return _petition.getUuid();
	}

	/**
	* Returns the video url of this petition.
	*
	* @return the video url of this petition
	*/
	@Override
	public java.lang.String getVideoURL() {
		return _petition.getVideoURL();
	}

	@Override
	public java.lang.String toString() {
		return _petition.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _petition.toXmlString();
	}

	/**
	* Returns the create date of this petition.
	*
	* @return the create date of this petition
	*/
	@Override
	public Date getCreateDate() {
		return _petition.getCreateDate();
	}

	/**
	* Returns the expiration date of this petition.
	*
	* @return the expiration date of this petition
	*/
	@Override
	public Date getExpirationDate() {
		return _petition.getExpirationDate();
	}

	/**
	* Returns the modified date of this petition.
	*
	* @return the modified date of this petition
	*/
	@Override
	public Date getModifiedDate() {
		return _petition.getModifiedDate();
	}

	/**
	* Returns the publication date of this petition.
	*
	* @return the publication date of this petition
	*/
	@Override
	public Date getPublicationDate() {
		return _petition.getPublicationDate();
	}

	/**
	* Returns the status date of this petition.
	*
	* @return the status date of this petition
	*/
	@Override
	public Date getStatusDate() {
		return _petition.getStatusDate();
	}

	/**
	* Returns the company ID of this petition.
	*
	* @return the company ID of this petition
	*/
	@Override
	public long getCompanyId() {
		return _petition.getCompanyId();
	}

	/**
	* Returns the group ID of this petition.
	*
	* @return the group ID of this petition
	*/
	@Override
	public long getGroupId() {
		return _petition.getGroupId();
	}

	/**
	* Returns the petition ID of this petition.
	*
	* @return the petition ID of this petition
	*/
	@Override
	public long getPetitionId() {
		return _petition.getPetitionId();
	}

	/**
	* Returns the primary key of this petition.
	*
	* @return the primary key of this petition
	*/
	@Override
	public long getPrimaryKey() {
		return _petition.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this petition.
	*
	* @return the status by user ID of this petition
	*/
	@Override
	public long getStatusByUserId() {
		return _petition.getStatusByUserId();
	}

	/**
	* Returns the user ID of this petition.
	*
	* @return the user ID of this petition
	*/
	@Override
	public long getUserId() {
		return _petition.getUserId();
	}

	@Override
	public void persist() {
		_petition.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_petition.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this petition.
	*
	* @param companyId the company ID of this petition
	*/
	@Override
	public void setCompanyId(long companyId) {
		_petition.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this petition.
	*
	* @param createDate the create date of this petition
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_petition.setCreateDate(createDate);
	}

	/**
	* Sets the description of this petition.
	*
	* @param description the description of this petition
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_petition.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_petition.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_petition.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_petition.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the expiration date of this petition.
	*
	* @param expirationDate the expiration date of this petition
	*/
	@Override
	public void setExpirationDate(Date expirationDate) {
		_petition.setExpirationDate(expirationDate);
	}

	/**
	* Sets the files download of this petition.
	*
	* @param filesDownload the files download of this petition
	*/
	@Override
	public void setFilesDownload(java.lang.String filesDownload) {
		_petition.setFilesDownload(filesDownload);
	}

	/**
	* Sets the group ID of this petition.
	*
	* @param groupId the group ID of this petition
	*/
	@Override
	public void setGroupId(long groupId) {
		_petition.setGroupId(groupId);
	}

	/**
	* Sets whether this petition is is video.
	*
	* @param isVideo the is video of this petition
	*/
	@Override
	public void setIsVideo(boolean isVideo) {
		_petition.setIsVideo(isVideo);
	}

	/**
	* Sets the modified date of this petition.
	*
	* @param modifiedDate the modified date of this petition
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_petition.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_petition.setNew(n);
	}

	/**
	* Sets the petition ID of this petition.
	*
	* @param petitionId the petition ID of this petition
	*/
	@Override
	public void setPetitionId(long petitionId) {
		_petition.setPetitionId(petitionId);
	}

	/**
	* Sets the picture url of this petition.
	*
	* @param pictureURL the picture url of this petition
	*/
	@Override
	public void setPictureURL(java.lang.String pictureURL) {
		_petition.setPictureURL(pictureURL);
	}

	/**
	* Sets the place text area of this petition.
	*
	* @param placeTextArea the place text area of this petition
	*/
	@Override
	public void setPlaceTextArea(java.lang.String placeTextArea) {
		_petition.setPlaceTextArea(placeTextArea);
	}

	/**
	* Sets the primary key of this petition.
	*
	* @param primaryKey the primary key of this petition
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_petition.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_petition.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the publication date of this petition.
	*
	* @param publicationDate the publication date of this petition
	*/
	@Override
	public void setPublicationDate(Date publicationDate) {
		_petition.setPublicationDate(publicationDate);
	}

	/**
	* Sets the status of this petition.
	*
	* @param status the status of this petition
	*/
	@Override
	public void setStatus(int status) {
		_petition.setStatus(status);
	}

	/**
	* Sets the status by user ID of this petition.
	*
	* @param statusByUserId the status by user ID of this petition
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_petition.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this petition.
	*
	* @param statusByUserName the status by user name of this petition
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_petition.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this petition.
	*
	* @param statusByUserUuid the status by user uuid of this petition
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_petition.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this petition.
	*
	* @param statusDate the status date of this petition
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_petition.setStatusDate(statusDate);
	}

	/**
	* Sets the title of this petition.
	*
	* @param title the title of this petition
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_petition.setTitle(title);
	}

	/**
	* Sets the user ID of this petition.
	*
	* @param userId the user ID of this petition
	*/
	@Override
	public void setUserId(long userId) {
		_petition.setUserId(userId);
	}

	/**
	* Sets the user name of this petition.
	*
	* @param userName the user name of this petition
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_petition.setUserName(userName);
	}

	/**
	* Sets the user uuid of this petition.
	*
	* @param userUuid the user uuid of this petition
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_petition.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this petition.
	*
	* @param uuid the uuid of this petition
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_petition.setUuid(uuid);
	}

	/**
	* Sets the video url of this petition.
	*
	* @param videoURL the video url of this petition
	*/
	@Override
	public void setVideoURL(java.lang.String videoURL) {
		_petition.setVideoURL(videoURL);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PetitionWrapper)) {
			return false;
		}

		PetitionWrapper petitionWrapper = (PetitionWrapper)obj;

		if (Objects.equals(_petition, petitionWrapper._petition)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _petition.getStagedModelType();
	}

	@Override
	public Petition getWrappedModel() {
		return _petition;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _petition.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _petition.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_petition.resetOriginalValues();
	}

	private final Petition _petition;
}