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

package eu.strasbourg.service.council.model.impl;

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

import eu.strasbourg.service.council.model.Deliberation;
import eu.strasbourg.service.council.model.DeliberationModel;
import eu.strasbourg.service.council.model.DeliberationSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Deliberation service. Represents a row in the &quot;council_Deliberation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DeliberationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DeliberationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DeliberationImpl
 * @see Deliberation
 * @see DeliberationModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DeliberationModelImpl extends BaseModelImpl<Deliberation>
	implements DeliberationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a deliberation model instance should use the {@link Deliberation} interface instead.
	 */
	public static final String TABLE_NAME = "council_Deliberation";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "deliberationId", Types.BIGINT },
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
			{ "order_", Types.INTEGER },
			{ "stage", Types.VARCHAR },
			{ "countOfficialsVoting", Types.INTEGER },
			{ "countOfficialsActive", Types.INTEGER },
			{ "councilSessionId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deliberationId", Types.BIGINT);
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
		TABLE_COLUMNS_MAP.put("order_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("stage", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("countOfficialsVoting", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("countOfficialsActive", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("councilSessionId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table council_Deliberation (uuid_ VARCHAR(75) null,deliberationId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,title VARCHAR(500) null,order_ INTEGER,stage VARCHAR(75) null,countOfficialsVoting INTEGER,countOfficialsActive INTEGER,councilSessionId LONG)";
	public static final String TABLE_SQL_DROP = "drop table council_Deliberation";
	public static final String ORDER_BY_JPQL = " ORDER BY deliberation.title ASC";
	public static final String ORDER_BY_SQL = " ORDER BY council_Deliberation.title ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.council.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.eu.strasbourg.service.council.model.Deliberation"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.council.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.eu.strasbourg.service.council.model.Deliberation"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.council.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.eu.strasbourg.service.council.model.Deliberation"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long COUNCILSESSIONID_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long TITLE_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Deliberation toModel(DeliberationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Deliberation model = new DeliberationImpl();

		model.setUuid(soapModel.getUuid());
		model.setDeliberationId(soapModel.getDeliberationId());
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
		model.setOrder(soapModel.getOrder());
		model.setStage(soapModel.getStage());
		model.setCountOfficialsVoting(soapModel.getCountOfficialsVoting());
		model.setCountOfficialsActive(soapModel.getCountOfficialsActive());
		model.setCouncilSessionId(soapModel.getCouncilSessionId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Deliberation> toModels(DeliberationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Deliberation> models = new ArrayList<Deliberation>(soapModels.length);

		for (DeliberationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(eu.strasbourg.service.council.service.util.ServiceProps.get(
				"lock.expiration.time.eu.strasbourg.service.council.model.Deliberation"));

	public DeliberationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _deliberationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDeliberationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _deliberationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Deliberation.class;
	}

	@Override
	public String getModelClassName() {
		return Deliberation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("deliberationId", getDeliberationId());
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
		attributes.put("order", getOrder());
		attributes.put("stage", getStage());
		attributes.put("countOfficialsVoting", getCountOfficialsVoting());
		attributes.put("countOfficialsActive", getCountOfficialsActive());
		attributes.put("councilSessionId", getCouncilSessionId());

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

		Long deliberationId = (Long)attributes.get("deliberationId");

		if (deliberationId != null) {
			setDeliberationId(deliberationId);
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

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String stage = (String)attributes.get("stage");

		if (stage != null) {
			setStage(stage);
		}

		Integer countOfficialsVoting = (Integer)attributes.get(
				"countOfficialsVoting");

		if (countOfficialsVoting != null) {
			setCountOfficialsVoting(countOfficialsVoting);
		}

		Integer countOfficialsActive = (Integer)attributes.get(
				"countOfficialsActive");

		if (countOfficialsActive != null) {
			setCountOfficialsActive(countOfficialsActive);
		}

		Long councilSessionId = (Long)attributes.get("councilSessionId");

		if (councilSessionId != null) {
			setCouncilSessionId(councilSessionId);
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
	public long getDeliberationId() {
		return _deliberationId;
	}

	@Override
	public void setDeliberationId(long deliberationId) {
		_deliberationId = deliberationId;
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
		_status = status;
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
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		_order = order;
	}

	@JSON
	@Override
	public String getStage() {
		if (_stage == null) {
			return StringPool.BLANK;
		}
		else {
			return _stage;
		}
	}

	@Override
	public void setStage(String stage) {
		_stage = stage;
	}

	@JSON
	@Override
	public int getCountOfficialsVoting() {
		return _countOfficialsVoting;
	}

	@Override
	public void setCountOfficialsVoting(int countOfficialsVoting) {
		_countOfficialsVoting = countOfficialsVoting;
	}

	@JSON
	@Override
	public int getCountOfficialsActive() {
		return _countOfficialsActive;
	}

	@Override
	public void setCountOfficialsActive(int countOfficialsActive) {
		_countOfficialsActive = countOfficialsActive;
	}

	@JSON
	@Override
	public long getCouncilSessionId() {
		return _councilSessionId;
	}

	@Override
	public void setCouncilSessionId(long councilSessionId) {
		_columnBitmask |= COUNCILSESSIONID_COLUMN_BITMASK;

		if (!_setOriginalCouncilSessionId) {
			_setOriginalCouncilSessionId = true;

			_originalCouncilSessionId = _councilSessionId;
		}

		_councilSessionId = councilSessionId;
	}

	public long getOriginalCouncilSessionId() {
		return _originalCouncilSessionId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Deliberation.class.getName()));
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
			Deliberation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Deliberation toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Deliberation)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DeliberationImpl deliberationImpl = new DeliberationImpl();

		deliberationImpl.setUuid(getUuid());
		deliberationImpl.setDeliberationId(getDeliberationId());
		deliberationImpl.setGroupId(getGroupId());
		deliberationImpl.setCompanyId(getCompanyId());
		deliberationImpl.setUserId(getUserId());
		deliberationImpl.setUserName(getUserName());
		deliberationImpl.setCreateDate(getCreateDate());
		deliberationImpl.setModifiedDate(getModifiedDate());
		deliberationImpl.setStatus(getStatus());
		deliberationImpl.setStatusByUserId(getStatusByUserId());
		deliberationImpl.setStatusByUserName(getStatusByUserName());
		deliberationImpl.setStatusDate(getStatusDate());
		deliberationImpl.setTitle(getTitle());
		deliberationImpl.setOrder(getOrder());
		deliberationImpl.setStage(getStage());
		deliberationImpl.setCountOfficialsVoting(getCountOfficialsVoting());
		deliberationImpl.setCountOfficialsActive(getCountOfficialsActive());
		deliberationImpl.setCouncilSessionId(getCouncilSessionId());

		deliberationImpl.resetOriginalValues();

		return deliberationImpl;
	}

	@Override
	public int compareTo(Deliberation deliberation) {
		int value = 0;

		value = getTitle().compareTo(deliberation.getTitle());

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

		if (!(obj instanceof Deliberation)) {
			return false;
		}

		Deliberation deliberation = (Deliberation)obj;

		long primaryKey = deliberation.getPrimaryKey();

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
		DeliberationModelImpl deliberationModelImpl = this;

		deliberationModelImpl._originalUuid = deliberationModelImpl._uuid;

		deliberationModelImpl._originalGroupId = deliberationModelImpl._groupId;

		deliberationModelImpl._setOriginalGroupId = false;

		deliberationModelImpl._originalCompanyId = deliberationModelImpl._companyId;

		deliberationModelImpl._setOriginalCompanyId = false;

		deliberationModelImpl._setModifiedDate = false;

		deliberationModelImpl._originalCouncilSessionId = deliberationModelImpl._councilSessionId;

		deliberationModelImpl._setOriginalCouncilSessionId = false;

		deliberationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Deliberation> toCacheModel() {
		DeliberationCacheModel deliberationCacheModel = new DeliberationCacheModel();

		deliberationCacheModel.uuid = getUuid();

		String uuid = deliberationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			deliberationCacheModel.uuid = null;
		}

		deliberationCacheModel.deliberationId = getDeliberationId();

		deliberationCacheModel.groupId = getGroupId();

		deliberationCacheModel.companyId = getCompanyId();

		deliberationCacheModel.userId = getUserId();

		deliberationCacheModel.userName = getUserName();

		String userName = deliberationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			deliberationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			deliberationCacheModel.createDate = createDate.getTime();
		}
		else {
			deliberationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			deliberationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			deliberationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		deliberationCacheModel.status = getStatus();

		deliberationCacheModel.statusByUserId = getStatusByUserId();

		deliberationCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = deliberationCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			deliberationCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			deliberationCacheModel.statusDate = statusDate.getTime();
		}
		else {
			deliberationCacheModel.statusDate = Long.MIN_VALUE;
		}

		deliberationCacheModel.title = getTitle();

		String title = deliberationCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			deliberationCacheModel.title = null;
		}

		deliberationCacheModel.order = getOrder();

		deliberationCacheModel.stage = getStage();

		String stage = deliberationCacheModel.stage;

		if ((stage != null) && (stage.length() == 0)) {
			deliberationCacheModel.stage = null;
		}

		deliberationCacheModel.countOfficialsVoting = getCountOfficialsVoting();

		deliberationCacheModel.countOfficialsActive = getCountOfficialsActive();

		deliberationCacheModel.councilSessionId = getCouncilSessionId();

		return deliberationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", deliberationId=");
		sb.append(getDeliberationId());
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
		sb.append(", order=");
		sb.append(getOrder());
		sb.append(", stage=");
		sb.append(getStage());
		sb.append(", countOfficialsVoting=");
		sb.append(getCountOfficialsVoting());
		sb.append(", countOfficialsActive=");
		sb.append(getCountOfficialsActive());
		sb.append(", councilSessionId=");
		sb.append(getCouncilSessionId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("eu.strasbourg.service.council.model.Deliberation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliberationId</column-name><column-value><![CDATA[");
		sb.append(getDeliberationId());
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
			"<column><column-name>order</column-name><column-value><![CDATA[");
		sb.append(getOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stage</column-name><column-value><![CDATA[");
		sb.append(getStage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countOfficialsVoting</column-name><column-value><![CDATA[");
		sb.append(getCountOfficialsVoting());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countOfficialsActive</column-name><column-value><![CDATA[");
		sb.append(getCountOfficialsActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>councilSessionId</column-name><column-value><![CDATA[");
		sb.append(getCouncilSessionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Deliberation.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Deliberation.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _deliberationId;
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
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _title;
	private int _order;
	private String _stage;
	private int _countOfficialsVoting;
	private int _countOfficialsActive;
	private long _councilSessionId;
	private long _originalCouncilSessionId;
	private boolean _setOriginalCouncilSessionId;
	private long _columnBitmask;
	private Deliberation _escapedModel;
}