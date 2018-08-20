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

package eu.strasbourg.service.project.model.impl;

import aQute.bnd.annotation.ProviderType;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.project.model.Petition;
import eu.strasbourg.service.project.model.PetitionModel;
import eu.strasbourg.service.project.model.PetitionSoap;

import java.io.Serializable;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Petition service. Represents a row in the &quot;project_Petition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PetitionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PetitionImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see PetitionImpl
 * @see Petition
 * @see PetitionModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class PetitionModelImpl extends BaseModelImpl<Petition>
	implements PetitionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a petition model instance should use the {@link Petition} interface instead.
	 */
	public static final String TABLE_NAME = "project_Petition";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "petitionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "placeTextArea", Types.VARCHAR },
			{ "filesDownload", Types.VARCHAR },
			{ "publicationDate", Types.TIMESTAMP },
			{ "expirationDate", Types.TIMESTAMP },
			{ "videoUrl", Types.VARCHAR },
			{ "externalImageURL", Types.VARCHAR },
			{ "externalImageCopyright", Types.VARCHAR },
			{ "mediaChoice", Types.BOOLEAN },
			{ "imageId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("petitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("placeTextArea", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("filesDownload", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("publicationDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("expirationDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("videoUrl", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalImageURL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalImageCopyright", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mediaChoice", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("imageId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table project_Petition (uuid_ VARCHAR(75) null,petitionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,title VARCHAR(75) null,description VARCHAR(75) null,placeTextArea VARCHAR(75) null,filesDownload VARCHAR(75) null,publicationDate DATE null,expirationDate DATE null,videoUrl VARCHAR(75) null,externalImageURL VARCHAR(75) null,externalImageCopyright VARCHAR(75) null,mediaChoice BOOLEAN,imageId LONG)";
	public static final String TABLE_SQL_DROP = "drop table project_Petition";
	public static final String ORDER_BY_JPQL = " ORDER BY petition.title ASC";
	public static final String ORDER_BY_SQL = " ORDER BY project_Petition.title ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.project.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.eu.strasbourg.service.project.model.Petition"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.project.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.eu.strasbourg.service.project.model.Petition"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.project.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.eu.strasbourg.service.project.model.Petition"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long STATUS_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long TITLE_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Petition toModel(PetitionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Petition model = new PetitionImpl();

		model.setUuid(soapModel.getUuid());
		model.setPetitionId(soapModel.getPetitionId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setTitle(soapModel.getTitle());
		model.setDescription(soapModel.getDescription());
		model.setPlaceTextArea(soapModel.getPlaceTextArea());
		model.setFilesDownload(soapModel.getFilesDownload());
		model.setPublicationDate(soapModel.getPublicationDate());
		model.setExpirationDate(soapModel.getExpirationDate());
		model.setVideoUrl(soapModel.getVideoUrl());
		model.setExternalImageURL(soapModel.getExternalImageURL());
		model.setExternalImageCopyright(soapModel.getExternalImageCopyright());
		model.setMediaChoice(soapModel.getMediaChoice());
		model.setImageId(soapModel.getImageId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Petition> toModels(PetitionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Petition> models = new ArrayList<Petition>(soapModels.length);

		for (PetitionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(eu.strasbourg.service.project.service.util.PropsUtil.get(
				"lock.expiration.time.eu.strasbourg.service.project.model.Petition"));

	public PetitionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _petitionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPetitionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _petitionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("publicationDate", getPublicationDate());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("videoUrl", getVideoUrl());
		attributes.put("externalImageURL", getExternalImageURL());
		attributes.put("externalImageCopyright", getExternalImageCopyright());
		attributes.put("mediaChoice", getMediaChoice());
		attributes.put("imageId", getImageId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
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

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getPetitionId() {
		return _petitionId;
	}

	@Override
	public void setPetitionId(long petitionId) {
		_petitionId = petitionId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_columnBitmask = -1L;

		_title = title;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public String getPlaceTextArea() {
		if (_placeTextArea == null) {
			return StringPool.BLANK;
		}
		else {
			return _placeTextArea;
		}
	}

	@Override
	public void setPlaceTextArea(String placeTextArea) {
		_placeTextArea = placeTextArea;
	}

	@JSON
	@Override
	public String getFilesDownload() {
		if (_filesDownload == null) {
			return StringPool.BLANK;
		}
		else {
			return _filesDownload;
		}
	}

	@Override
	public void setFilesDownload(String filesDownload) {
		_filesDownload = filesDownload;
	}

	@JSON
	@Override
	public Date getPublicationDate() {
		return _publicationDate;
	}

	@Override
	public void setPublicationDate(Date publicationDate) {
		_publicationDate = publicationDate;
	}

	@JSON
	@Override
	public Date getExpirationDate() {
		return _expirationDate;
	}

	@Override
	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	@JSON
	@Override
	public String getVideoUrl() {
		if (_videoUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _videoUrl;
		}
	}

	@Override
	public void setVideoUrl(String videoUrl) {
		_videoUrl = videoUrl;
	}

	@JSON
	@Override
	public String getExternalImageURL() {
		if (_externalImageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _externalImageURL;
		}
	}

	@Override
	public void setExternalImageURL(String externalImageURL) {
		_externalImageURL = externalImageURL;
	}

	@JSON
	@Override
	public String getExternalImageCopyright() {
		if (_externalImageCopyright == null) {
			return StringPool.BLANK;
		}
		else {
			return _externalImageCopyright;
		}
	}

	@Override
	public void setExternalImageCopyright(String externalImageCopyright) {
		_externalImageCopyright = externalImageCopyright;
	}

	@JSON
	@Override
	public boolean getMediaChoice() {
		return _mediaChoice;
	}

	@JSON
	@Override
	public boolean isMediaChoice() {
		return _mediaChoice;
	}

	@Override
	public void setMediaChoice(boolean mediaChoice) {
		_mediaChoice = mediaChoice;
	}

	@JSON
	@Override
	public long getImageId() {
		return _imageId;
	}

	@Override
	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Petition.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Petition.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Petition toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Petition)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PetitionImpl petitionImpl = new PetitionImpl();

		petitionImpl.setUuid(getUuid());
		petitionImpl.setPetitionId(getPetitionId());
		petitionImpl.setGroupId(getGroupId());
		petitionImpl.setCompanyId(getCompanyId());
		petitionImpl.setUserId(getUserId());
		petitionImpl.setUserName(getUserName());
		petitionImpl.setCreateDate(getCreateDate());
		petitionImpl.setModifiedDate(getModifiedDate());
		petitionImpl.setStatus(getStatus());
		petitionImpl.setStatusByUserId(getStatusByUserId());
		petitionImpl.setStatusByUserName(getStatusByUserName());
		petitionImpl.setStatusDate(getStatusDate());
		petitionImpl.setTitle(getTitle());
		petitionImpl.setDescription(getDescription());
		petitionImpl.setPlaceTextArea(getPlaceTextArea());
		petitionImpl.setFilesDownload(getFilesDownload());
		petitionImpl.setPublicationDate(getPublicationDate());
		petitionImpl.setExpirationDate(getExpirationDate());
		petitionImpl.setVideoUrl(getVideoUrl());
		petitionImpl.setExternalImageURL(getExternalImageURL());
		petitionImpl.setExternalImageCopyright(getExternalImageCopyright());
		petitionImpl.setMediaChoice(getMediaChoice());
		petitionImpl.setImageId(getImageId());

		petitionImpl.resetOriginalValues();

		return petitionImpl;
	}

	@Override
	public int compareTo(Petition petition) {
		int value = 0;

		value = getTitle().compareTo(petition.getTitle());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Petition)) {
			return false;
		}

		Petition petition = (Petition)obj;

		long primaryKey = petition.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		PetitionModelImpl petitionModelImpl = this;

		petitionModelImpl._originalUuid = petitionModelImpl._uuid;

		petitionModelImpl._originalGroupId = petitionModelImpl._groupId;

		petitionModelImpl._setOriginalGroupId = false;

		petitionModelImpl._originalCompanyId = petitionModelImpl._companyId;

		petitionModelImpl._setOriginalCompanyId = false;

		petitionModelImpl._setModifiedDate = false;

		petitionModelImpl._originalStatus = petitionModelImpl._status;

		petitionModelImpl._setOriginalStatus = false;

		petitionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Petition> toCacheModel() {
		PetitionCacheModel petitionCacheModel = new PetitionCacheModel();

		petitionCacheModel.uuid = getUuid();

		String uuid = petitionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			petitionCacheModel.uuid = null;
		}

		petitionCacheModel.petitionId = getPetitionId();

		petitionCacheModel.groupId = getGroupId();

		petitionCacheModel.companyId = getCompanyId();

		petitionCacheModel.userId = getUserId();

		petitionCacheModel.userName = getUserName();

		String userName = petitionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			petitionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			petitionCacheModel.createDate = createDate.getTime();
		}
		else {
			petitionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			petitionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			petitionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		petitionCacheModel.status = getStatus();

		petitionCacheModel.statusByUserId = getStatusByUserId();

		petitionCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = petitionCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			petitionCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			petitionCacheModel.statusDate = statusDate.getTime();
		}
		else {
			petitionCacheModel.statusDate = Long.MIN_VALUE;
		}

		petitionCacheModel.title = getTitle();

		String title = petitionCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			petitionCacheModel.title = null;
		}

		petitionCacheModel.description = getDescription();

		String description = petitionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			petitionCacheModel.description = null;
		}

		petitionCacheModel.placeTextArea = getPlaceTextArea();

		String placeTextArea = petitionCacheModel.placeTextArea;

		if ((placeTextArea != null) && (placeTextArea.length() == 0)) {
			petitionCacheModel.placeTextArea = null;
		}

		petitionCacheModel.filesDownload = getFilesDownload();

		String filesDownload = petitionCacheModel.filesDownload;

		if ((filesDownload != null) && (filesDownload.length() == 0)) {
			petitionCacheModel.filesDownload = null;
		}

		Date publicationDate = getPublicationDate();

		if (publicationDate != null) {
			petitionCacheModel.publicationDate = publicationDate.getTime();
		}
		else {
			petitionCacheModel.publicationDate = Long.MIN_VALUE;
		}

		Date expirationDate = getExpirationDate();

		if (expirationDate != null) {
			petitionCacheModel.expirationDate = expirationDate.getTime();
		}
		else {
			petitionCacheModel.expirationDate = Long.MIN_VALUE;
		}

		petitionCacheModel.videoUrl = getVideoUrl();

		String videoUrl = petitionCacheModel.videoUrl;

		if ((videoUrl != null) && (videoUrl.length() == 0)) {
			petitionCacheModel.videoUrl = null;
		}

		petitionCacheModel.externalImageURL = getExternalImageURL();

		String externalImageURL = petitionCacheModel.externalImageURL;

		if ((externalImageURL != null) && (externalImageURL.length() == 0)) {
			petitionCacheModel.externalImageURL = null;
		}

		petitionCacheModel.externalImageCopyright = getExternalImageCopyright();

		String externalImageCopyright = petitionCacheModel.externalImageCopyright;

		if ((externalImageCopyright != null) &&
				(externalImageCopyright.length() == 0)) {
			petitionCacheModel.externalImageCopyright = null;
		}

		petitionCacheModel.mediaChoice = getMediaChoice();

		petitionCacheModel.imageId = getImageId();

		return petitionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", petitionId=");
		sb.append(getPetitionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", placeTextArea=");
		sb.append(getPlaceTextArea());
		sb.append(", filesDownload=");
		sb.append(getFilesDownload());
		sb.append(", publicationDate=");
		sb.append(getPublicationDate());
		sb.append(", expirationDate=");
		sb.append(getExpirationDate());
		sb.append(", videoUrl=");
		sb.append(getVideoUrl());
		sb.append(", externalImageURL=");
		sb.append(getExternalImageURL());
		sb.append(", externalImageCopyright=");
		sb.append(getExternalImageCopyright());
		sb.append(", mediaChoice=");
		sb.append(getMediaChoice());
		sb.append(", imageId=");
		sb.append(getImageId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("eu.strasbourg.service.project.model.Petition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>petitionId</column-name><column-value><![CDATA[");
		sb.append(getPetitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>placeTextArea</column-name><column-value><![CDATA[");
		sb.append(getPlaceTextArea());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filesDownload</column-name><column-value><![CDATA[");
		sb.append(getFilesDownload());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publicationDate</column-name><column-value><![CDATA[");
		sb.append(getPublicationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expirationDate</column-name><column-value><![CDATA[");
		sb.append(getExpirationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoUrl</column-name><column-value><![CDATA[");
		sb.append(getVideoUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalImageURL</column-name><column-value><![CDATA[");
		sb.append(getExternalImageURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalImageCopyright</column-name><column-value><![CDATA[");
		sb.append(getExternalImageCopyright());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mediaChoice</column-name><column-value><![CDATA[");
		sb.append(getMediaChoice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageId</column-name><column-value><![CDATA[");
		sb.append(getImageId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Petition.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Petition.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _petitionId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _title;
	private String _description;
	private String _placeTextArea;
	private String _filesDownload;
	private Date _publicationDate;
	private Date _expirationDate;
	private String _videoUrl;
	private String _externalImageURL;
	private String _externalImageCopyright;
	private boolean _mediaChoice;
	private long _imageId;
	private long _columnBitmask;
	private Petition _escapedModel;
}