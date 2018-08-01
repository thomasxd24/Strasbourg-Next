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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link eu.strasbourg.service.petition.service.http.PetitionServiceSoap}.
 *
 * @author Alexandre QUERE
 * @see eu.strasbourg.service.petition.service.http.PetitionServiceSoap
 * @generated
 */
@ProviderType
public class PetitionSoap implements Serializable {
	public static PetitionSoap toSoapModel(Petition model) {
		PetitionSoap soapModel = new PetitionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPetitionId(model.getPetitionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setVideoURL(model.getVideoURL());
		soapModel.setPictureURL(model.getPictureURL());
		soapModel.setIsVideo(model.getIsVideo());
		soapModel.setDescription(model.getDescription());
		soapModel.setPlaceTextArea(model.getPlaceTextArea());
		soapModel.setFilesDownload(model.getFilesDownload());
		soapModel.setPublicationDate(model.getPublicationDate());
		soapModel.setExpirationDate(model.getExpirationDate());

		return soapModel;
	}

	public static PetitionSoap[] toSoapModels(Petition[] models) {
		PetitionSoap[] soapModels = new PetitionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PetitionSoap[][] toSoapModels(Petition[][] models) {
		PetitionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PetitionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PetitionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PetitionSoap[] toSoapModels(List<Petition> models) {
		List<PetitionSoap> soapModels = new ArrayList<PetitionSoap>(models.size());

		for (Petition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PetitionSoap[soapModels.size()]);
	}

	public PetitionSoap() {
	}

	public long getPrimaryKey() {
		return _petitionId;
	}

	public void setPrimaryKey(long pk) {
		setPetitionId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPetitionId() {
		return _petitionId;
	}

	public void setPetitionId(long petitionId) {
		_petitionId = petitionId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getVideoURL() {
		return _videoURL;
	}

	public void setVideoURL(String videoURL) {
		_videoURL = videoURL;
	}

	public String getPictureURL() {
		return _pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		_pictureURL = pictureURL;
	}

	public boolean getIsVideo() {
		return _isVideo;
	}

	public boolean isIsVideo() {
		return _isVideo;
	}

	public void setIsVideo(boolean isVideo) {
		_isVideo = isVideo;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getPlaceTextArea() {
		return _placeTextArea;
	}

	public void setPlaceTextArea(String placeTextArea) {
		_placeTextArea = placeTextArea;
	}

	public String getFilesDownload() {
		return _filesDownload;
	}

	public void setFilesDownload(String filesDownload) {
		_filesDownload = filesDownload;
	}

	public Date getPublicationDate() {
		return _publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		_publicationDate = publicationDate;
	}

	public Date getExpirationDate() {
		return _expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	private String _uuid;
	private long _petitionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _title;
	private String _videoURL;
	private String _pictureURL;
	private boolean _isVideo;
	private String _description;
	private String _placeTextArea;
	private String _filesDownload;
	private Date _publicationDate;
	private Date _expirationDate;
}