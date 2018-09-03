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
 * @author Cedric Henry
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
		attributes.put("description", getDescription());
		attributes.put("placeTextArea", getPlaceTextArea());
		attributes.put("filesDownload", getFilesDownload());
		attributes.put("petitionStatus", getPetitionStatus());
		attributes.put("publicationDate", getPublicationDate());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("quotaSignature", getQuotaSignature());
		attributes.put("nombreSignature", getNombreSignature());
		attributes.put("videoUrl", getVideoUrl());
		attributes.put("externalImageURL", getExternalImageURL());
		attributes.put("externalImageCopyright", getExternalImageCopyright());
		attributes.put("mediaChoice", getMediaChoice());
		attributes.put("consultationPlacesBody", getConsultationPlacesBody());
		attributes.put("assetEntryId", getAssetEntryId());
		attributes.put("publikId", getPublikId());
		attributes.put("imageId", getImageId());
		attributes.put("filesIds", getFilesIds());

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

		String petitionStatus = (String)attributes.get("petitionStatus");

		if (petitionStatus != null) {
			setPetitionStatus(petitionStatus);
		}

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		Long quotaSignature = (Long)attributes.get("quotaSignature");

		if (quotaSignature != null) {
			setQuotaSignature(quotaSignature);
		}

		Long nombreSignature = (Long)attributes.get("nombreSignature");

		if (nombreSignature != null) {
			setNombreSignature(nombreSignature);
		}

		String videoUrl = (String)attributes.get("videoUrl");

		if (videoUrl != null) {
			setVideoUrl(videoUrl);
		}

		String externalImageURL = (String)attributes.get("externalImageURL");

		if (externalImageURL != null) {
			setExternalImageURL(externalImageURL);
		}

		String externalImageCopyright = (String)attributes.get(
				"externalImageCopyright");

		if (externalImageCopyright != null) {
			setExternalImageCopyright(externalImageCopyright);
		}

		Boolean mediaChoice = (Boolean)attributes.get("mediaChoice");

		if (mediaChoice != null) {
			setMediaChoice(mediaChoice);
		}

		String consultationPlacesBody = (String)attributes.get(
				"consultationPlacesBody");

		if (consultationPlacesBody != null) {
			setConsultationPlacesBody(consultationPlacesBody);
		}

		Long assetEntryId = (Long)attributes.get("assetEntryId");

		if (assetEntryId != null) {
			setAssetEntryId(assetEntryId);
		}

		String publikId = (String)attributes.get("publikId");

		if (publikId != null) {
			setPublikId(publikId);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String filesIds = (String)attributes.get("filesIds");

		if (filesIds != null) {
			setFilesIds(filesIds);
		}
	}

	/**
	* Returns the media choice of this petition.
	*
	* @return the media choice of this petition
	*/
	@Override
	public boolean getMediaChoice() {
		return _petition.getMediaChoice();
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
	* Returns <code>true</code> if this petition is media choice.
	*
	* @return <code>true</code> if this petition is media choice; <code>false</code> otherwise
	*/
	@Override
	public boolean isMediaChoice() {
		return _petition.isMediaChoice();
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

	/**
	* Retourne le status de la petition
	*/
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getPetitionStatusCategory() {
		return _petition.getPetitionStatusCategory();
	}

	/**
	* Retourne l'AssetEntry rattaché cet item
	*/
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return _petition.getAssetEntry();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _petition.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<eu.strasbourg.service.project.model.Petition> toCacheModel() {
		return _petition.toCacheModel();
	}

	@Override
	public eu.strasbourg.service.project.model.Petition toEscapedModel() {
		return new PetitionWrapper(_petition.toEscapedModel());
	}

	@Override
	public eu.strasbourg.service.project.model.Petition toUnescapedModel() {
		return new PetitionWrapper(_petition.toUnescapedModel());
	}

	@Override
	public int compareTo(eu.strasbourg.service.project.model.Petition petition) {
		return _petition.compareTo(petition);
	}

	/**
	* Retourne le nombre de commentaires de l'entité
	*/
	@Override
	public int getNbApprovedComments() {
		return _petition.getNbApprovedComments();
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

	@Override
	public java.lang.String getAssetEntryTitle() {
		return _petition.getAssetEntryTitle();
	}

	/**
	* Returns the consultation places body of this petition.
	*
	* @return the consultation places body of this petition
	*/
	@Override
	public java.lang.String getConsultationPlacesBody() {
		return _petition.getConsultationPlacesBody();
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
	* Returns the external image copyright of this petition.
	*
	* @return the external image copyright of this petition
	*/
	@Override
	public java.lang.String getExternalImageCopyright() {
		return _petition.getExternalImageCopyright();
	}

	/**
	* Returns the external image url of this petition.
	*
	* @return the external image url of this petition
	*/
	@Override
	public java.lang.String getExternalImageURL() {
		return _petition.getExternalImageURL();
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
	* Returns the files IDs of this petition.
	*
	* @return the files IDs of this petition
	*/
	@Override
	public java.lang.String getFilesIds() {
		return _petition.getFilesIds();
	}

	/**
	* Retourne le label de 5 digits du nombre de commentaires de l'entité
	*/
	@Override
	public java.lang.String getNbApprovedCommentsLabel() {
		return _petition.getNbApprovedCommentsLabel();
	}

	/**
	* Returns the petition status of this petition.
	*
	* @return the petition status of this petition
	*/
	@Override
	public java.lang.String getPetitionStatus() {
		return _petition.getPetitionStatus();
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
	* Returns the publik ID of this petition.
	*
	* @return the publik ID of this petition
	*/
	@Override
	public java.lang.String getPublikId() {
		return _petition.getPublikId();
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
	public java.lang.String getVideoUrl() {
		return _petition.getVideoUrl();
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
	* Retourne les commentaires de l'entité
	*/
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment> getApprovedComments() {
		return _petition.getApprovedComments();
	}

	/**
	* Renvoie la liste des AssetCategory rattachées à cet item (via
	* l'assetEntry)
	*/
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getCategories() {
		return _petition.getCategories();
	}

	/**
	* Retourne la liste des lieux placit liés à la participation
	*/
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace> getPlacitPlaces() {
		return _petition.getPlacitPlaces();
	}

	/**
	* Returns the asset entry ID of this petition.
	*
	* @return the asset entry ID of this petition
	*/
	@Override
	public long getAssetEntryId() {
		return _petition.getAssetEntryId();
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
	* Returns the image ID of this petition.
	*
	* @return the image ID of this petition
	*/
	@Override
	public long getImageId() {
		return _petition.getImageId();
	}

	/**
	* Returns the nombre signature of this petition.
	*
	* @return the nombre signature of this petition
	*/
	@Override
	public long getNombreSignature() {
		return _petition.getNombreSignature();
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
	* Returns the quota signature of this petition.
	*
	* @return the quota signature of this petition
	*/
	@Override
	public long getQuotaSignature() {
		return _petition.getQuotaSignature();
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

	/**
	* Sets the asset entry ID of this petition.
	*
	* @param assetEntryId the asset entry ID of this petition
	*/
	@Override
	public void setAssetEntryId(long assetEntryId) {
		_petition.setAssetEntryId(assetEntryId);
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
	* Sets the consultation places body of this petition.
	*
	* @param consultationPlacesBody the consultation places body of this petition
	*/
	@Override
	public void setConsultationPlacesBody(
		java.lang.String consultationPlacesBody) {
		_petition.setConsultationPlacesBody(consultationPlacesBody);
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
	* Sets the external image copyright of this petition.
	*
	* @param externalImageCopyright the external image copyright of this petition
	*/
	@Override
	public void setExternalImageCopyright(
		java.lang.String externalImageCopyright) {
		_petition.setExternalImageCopyright(externalImageCopyright);
	}

	/**
	* Sets the external image url of this petition.
	*
	* @param externalImageURL the external image url of this petition
	*/
	@Override
	public void setExternalImageURL(java.lang.String externalImageURL) {
		_petition.setExternalImageURL(externalImageURL);
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
	* Sets the files IDs of this petition.
	*
	* @param filesIds the files IDs of this petition
	*/
	@Override
	public void setFilesIds(java.lang.String filesIds) {
		_petition.setFilesIds(filesIds);
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
	* Sets the image ID of this petition.
	*
	* @param imageId the image ID of this petition
	*/
	@Override
	public void setImageId(long imageId) {
		_petition.setImageId(imageId);
	}

	/**
	* Sets whether this petition is media choice.
	*
	* @param mediaChoice the media choice of this petition
	*/
	@Override
	public void setMediaChoice(boolean mediaChoice) {
		_petition.setMediaChoice(mediaChoice);
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
	* Sets the nombre signature of this petition.
	*
	* @param nombreSignature the nombre signature of this petition
	*/
	@Override
	public void setNombreSignature(long nombreSignature) {
		_petition.setNombreSignature(nombreSignature);
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
	* Sets the petition status of this petition.
	*
	* @param petitionStatus the petition status of this petition
	*/
	@Override
	public void setPetitionStatus(java.lang.String petitionStatus) {
		_petition.setPetitionStatus(petitionStatus);
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
	* Sets the publik ID of this petition.
	*
	* @param publikId the publik ID of this petition
	*/
	@Override
	public void setPublikId(java.lang.String publikId) {
		_petition.setPublikId(publikId);
	}

	/**
	* Sets the quota signature of this petition.
	*
	* @param quotaSignature the quota signature of this petition
	*/
	@Override
	public void setQuotaSignature(long quotaSignature) {
		_petition.setQuotaSignature(quotaSignature);
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
	* @param videoUrl the video url of this petition
	*/
	@Override
	public void setVideoUrl(java.lang.String videoUrl) {
		_petition.setVideoUrl(videoUrl);
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