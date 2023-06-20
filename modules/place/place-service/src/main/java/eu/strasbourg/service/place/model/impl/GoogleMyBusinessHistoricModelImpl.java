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

package eu.strasbourg.service.place.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import eu.strasbourg.service.place.model.GoogleMyBusinessHistoric;
import eu.strasbourg.service.place.model.GoogleMyBusinessHistoricModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the GoogleMyBusinessHistoric service. Represents a row in the &quot;place_GoogleMyBusinessHistoric&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>GoogleMyBusinessHistoricModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GoogleMyBusinessHistoricImpl}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see GoogleMyBusinessHistoricImpl
 * @generated
 */
public class GoogleMyBusinessHistoricModelImpl
	extends BaseModelImpl<GoogleMyBusinessHistoric>
	implements GoogleMyBusinessHistoricModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a google my business historic model instance should use the <code>GoogleMyBusinessHistoric</code> interface instead.
	 */
	public static final String TABLE_NAME = "place_GoogleMyBusinessHistoric";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"googleMyBusinessHistoricId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"lastPublishDate", Types.TIMESTAMP}, {"status", Types.INTEGER},
		{"statusByUserId", Types.BIGINT}, {"statusByUserName", Types.VARCHAR},
		{"statusDate", Types.TIMESTAMP}, {"result", Types.INTEGER},
		{"operations", Types.CLOB}, {"errorDescription", Types.CLOB},
		{"errorStackTrace", Types.CLOB}, {"startDate", Types.TIMESTAMP},
		{"finishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("googleMyBusinessHistoricId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("result", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("operations", Types.CLOB);
		TABLE_COLUMNS_MAP.put("errorDescription", Types.CLOB);
		TABLE_COLUMNS_MAP.put("errorStackTrace", Types.CLOB);
		TABLE_COLUMNS_MAP.put("startDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("finishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table place_GoogleMyBusinessHistoric (uuid_ VARCHAR(75) null,googleMyBusinessHistoricId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,lastPublishDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,result INTEGER,operations TEXT null,errorDescription TEXT null,errorStackTrace TEXT null,startDate DATE null,finishDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table place_GoogleMyBusinessHistoric";

	public static final String ORDER_BY_JPQL =
		" ORDER BY googleMyBusinessHistoric.googleMyBusinessHistoricId DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY place_GoogleMyBusinessHistoric.googleMyBusinessHistoricId DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean ENTITY_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean FINDER_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean COLUMN_BITMASK_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GOOGLEMYBUSINESSHISTORICID_COLUMN_BITMASK = 8L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.place.model.GoogleMyBusinessHistoric"));

	public GoogleMyBusinessHistoricModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _googleMyBusinessHistoricId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGoogleMyBusinessHistoricId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _googleMyBusinessHistoricId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return GoogleMyBusinessHistoric.class;
	}

	@Override
	public String getModelClassName() {
		return GoogleMyBusinessHistoric.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<GoogleMyBusinessHistoric, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<GoogleMyBusinessHistoric, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<GoogleMyBusinessHistoric, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((GoogleMyBusinessHistoric)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<GoogleMyBusinessHistoric, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<GoogleMyBusinessHistoric, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(GoogleMyBusinessHistoric)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<GoogleMyBusinessHistoric, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<GoogleMyBusinessHistoric, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<GoogleMyBusinessHistoric, Object>>
		_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<GoogleMyBusinessHistoric, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<GoogleMyBusinessHistoric, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<GoogleMyBusinessHistoric, Object>>();
		Map<String, BiConsumer<GoogleMyBusinessHistoric, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<GoogleMyBusinessHistoric, ?>>();

		attributeGetterFunctions.put("uuid", GoogleMyBusinessHistoric::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<GoogleMyBusinessHistoric, String>)
				GoogleMyBusinessHistoric::setUuid);
		attributeGetterFunctions.put(
			"googleMyBusinessHistoricId",
			GoogleMyBusinessHistoric::getGoogleMyBusinessHistoricId);
		attributeSetterBiConsumers.put(
			"googleMyBusinessHistoricId",
			(BiConsumer<GoogleMyBusinessHistoric, Long>)
				GoogleMyBusinessHistoric::setGoogleMyBusinessHistoricId);
		attributeGetterFunctions.put(
			"groupId", GoogleMyBusinessHistoric::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<GoogleMyBusinessHistoric, Long>)
				GoogleMyBusinessHistoric::setGroupId);
		attributeGetterFunctions.put(
			"companyId", GoogleMyBusinessHistoric::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<GoogleMyBusinessHistoric, Long>)
				GoogleMyBusinessHistoric::setCompanyId);
		attributeGetterFunctions.put(
			"userId", GoogleMyBusinessHistoric::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<GoogleMyBusinessHistoric, Long>)
				GoogleMyBusinessHistoric::setUserId);
		attributeGetterFunctions.put(
			"userName", GoogleMyBusinessHistoric::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<GoogleMyBusinessHistoric, String>)
				GoogleMyBusinessHistoric::setUserName);
		attributeGetterFunctions.put(
			"createDate", GoogleMyBusinessHistoric::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<GoogleMyBusinessHistoric, Date>)
				GoogleMyBusinessHistoric::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", GoogleMyBusinessHistoric::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<GoogleMyBusinessHistoric, Date>)
				GoogleMyBusinessHistoric::setModifiedDate);
		attributeGetterFunctions.put(
			"lastPublishDate", GoogleMyBusinessHistoric::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<GoogleMyBusinessHistoric, Date>)
				GoogleMyBusinessHistoric::setLastPublishDate);
		attributeGetterFunctions.put(
			"status", GoogleMyBusinessHistoric::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<GoogleMyBusinessHistoric, Integer>)
				GoogleMyBusinessHistoric::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", GoogleMyBusinessHistoric::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<GoogleMyBusinessHistoric, Long>)
				GoogleMyBusinessHistoric::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", GoogleMyBusinessHistoric::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<GoogleMyBusinessHistoric, String>)
				GoogleMyBusinessHistoric::setStatusByUserName);
		attributeGetterFunctions.put(
			"statusDate", GoogleMyBusinessHistoric::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<GoogleMyBusinessHistoric, Date>)
				GoogleMyBusinessHistoric::setStatusDate);
		attributeGetterFunctions.put(
			"result", GoogleMyBusinessHistoric::getResult);
		attributeSetterBiConsumers.put(
			"result",
			(BiConsumer<GoogleMyBusinessHistoric, Integer>)
				GoogleMyBusinessHistoric::setResult);
		attributeGetterFunctions.put(
			"operations", GoogleMyBusinessHistoric::getOperations);
		attributeSetterBiConsumers.put(
			"operations",
			(BiConsumer<GoogleMyBusinessHistoric, String>)
				GoogleMyBusinessHistoric::setOperations);
		attributeGetterFunctions.put(
			"errorDescription", GoogleMyBusinessHistoric::getErrorDescription);
		attributeSetterBiConsumers.put(
			"errorDescription",
			(BiConsumer<GoogleMyBusinessHistoric, String>)
				GoogleMyBusinessHistoric::setErrorDescription);
		attributeGetterFunctions.put(
			"errorStackTrace", GoogleMyBusinessHistoric::getErrorStackTrace);
		attributeSetterBiConsumers.put(
			"errorStackTrace",
			(BiConsumer<GoogleMyBusinessHistoric, String>)
				GoogleMyBusinessHistoric::setErrorStackTrace);
		attributeGetterFunctions.put(
			"startDate", GoogleMyBusinessHistoric::getStartDate);
		attributeSetterBiConsumers.put(
			"startDate",
			(BiConsumer<GoogleMyBusinessHistoric, Date>)
				GoogleMyBusinessHistoric::setStartDate);
		attributeGetterFunctions.put(
			"finishDate", GoogleMyBusinessHistoric::getFinishDate);
		attributeSetterBiConsumers.put(
			"finishDate",
			(BiConsumer<GoogleMyBusinessHistoric, Date>)
				GoogleMyBusinessHistoric::setFinishDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@Override
	public long getGoogleMyBusinessHistoricId() {
		return _googleMyBusinessHistoricId;
	}

	@Override
	public void setGoogleMyBusinessHistoricId(long googleMyBusinessHistoricId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_googleMyBusinessHistoricId = googleMyBusinessHistoricId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

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

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastPublishDate = lastPublishDate;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusDate = statusDate;
	}

	@Override
	public int getResult() {
		return _result;
	}

	@Override
	public void setResult(int result) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_result = result;
	}

	@Override
	public String getOperations() {
		if (_operations == null) {
			return "";
		}
		else {
			return _operations;
		}
	}

	@Override
	public void setOperations(String operations) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_operations = operations;
	}

	@Override
	public String getErrorDescription() {
		if (_errorDescription == null) {
			return "";
		}
		else {
			return _errorDescription;
		}
	}

	@Override
	public void setErrorDescription(String errorDescription) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_errorDescription = errorDescription;
	}

	@Override
	public String getErrorStackTrace() {
		if (_errorStackTrace == null) {
			return "";
		}
		else {
			return _errorStackTrace;
		}
	}

	@Override
	public void setErrorStackTrace(String errorStackTrace) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_errorStackTrace = errorStackTrace;
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_startDate = startDate;
	}

	@Override
	public Date getFinishDate() {
		return _finishDate;
	}

	@Override
	public void setFinishDate(Date finishDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_finishDate = finishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				GoogleMyBusinessHistoric.class.getName()));
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
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), GoogleMyBusinessHistoric.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public GoogleMyBusinessHistoric toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, GoogleMyBusinessHistoric>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		GoogleMyBusinessHistoricImpl googleMyBusinessHistoricImpl =
			new GoogleMyBusinessHistoricImpl();

		googleMyBusinessHistoricImpl.setUuid(getUuid());
		googleMyBusinessHistoricImpl.setGoogleMyBusinessHistoricId(
			getGoogleMyBusinessHistoricId());
		googleMyBusinessHistoricImpl.setGroupId(getGroupId());
		googleMyBusinessHistoricImpl.setCompanyId(getCompanyId());
		googleMyBusinessHistoricImpl.setUserId(getUserId());
		googleMyBusinessHistoricImpl.setUserName(getUserName());
		googleMyBusinessHistoricImpl.setCreateDate(getCreateDate());
		googleMyBusinessHistoricImpl.setModifiedDate(getModifiedDate());
		googleMyBusinessHistoricImpl.setLastPublishDate(getLastPublishDate());
		googleMyBusinessHistoricImpl.setStatus(getStatus());
		googleMyBusinessHistoricImpl.setStatusByUserId(getStatusByUserId());
		googleMyBusinessHistoricImpl.setStatusByUserName(getStatusByUserName());
		googleMyBusinessHistoricImpl.setStatusDate(getStatusDate());
		googleMyBusinessHistoricImpl.setResult(getResult());
		googleMyBusinessHistoricImpl.setOperations(getOperations());
		googleMyBusinessHistoricImpl.setErrorDescription(getErrorDescription());
		googleMyBusinessHistoricImpl.setErrorStackTrace(getErrorStackTrace());
		googleMyBusinessHistoricImpl.setStartDate(getStartDate());
		googleMyBusinessHistoricImpl.setFinishDate(getFinishDate());

		googleMyBusinessHistoricImpl.resetOriginalValues();

		return googleMyBusinessHistoricImpl;
	}

	@Override
	public GoogleMyBusinessHistoric cloneWithOriginalValues() {
		GoogleMyBusinessHistoricImpl googleMyBusinessHistoricImpl =
			new GoogleMyBusinessHistoricImpl();

		googleMyBusinessHistoricImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		googleMyBusinessHistoricImpl.setGoogleMyBusinessHistoricId(
			this.<Long>getColumnOriginalValue("googleMyBusinessHistoricId"));
		googleMyBusinessHistoricImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		googleMyBusinessHistoricImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		googleMyBusinessHistoricImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		googleMyBusinessHistoricImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		googleMyBusinessHistoricImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		googleMyBusinessHistoricImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		googleMyBusinessHistoricImpl.setLastPublishDate(
			this.<Date>getColumnOriginalValue("lastPublishDate"));
		googleMyBusinessHistoricImpl.setStatus(
			this.<Integer>getColumnOriginalValue("status"));
		googleMyBusinessHistoricImpl.setStatusByUserId(
			this.<Long>getColumnOriginalValue("statusByUserId"));
		googleMyBusinessHistoricImpl.setStatusByUserName(
			this.<String>getColumnOriginalValue("statusByUserName"));
		googleMyBusinessHistoricImpl.setStatusDate(
			this.<Date>getColumnOriginalValue("statusDate"));
		googleMyBusinessHistoricImpl.setResult(
			this.<Integer>getColumnOriginalValue("result"));
		googleMyBusinessHistoricImpl.setOperations(
			this.<String>getColumnOriginalValue("operations"));
		googleMyBusinessHistoricImpl.setErrorDescription(
			this.<String>getColumnOriginalValue("errorDescription"));
		googleMyBusinessHistoricImpl.setErrorStackTrace(
			this.<String>getColumnOriginalValue("errorStackTrace"));
		googleMyBusinessHistoricImpl.setStartDate(
			this.<Date>getColumnOriginalValue("startDate"));
		googleMyBusinessHistoricImpl.setFinishDate(
			this.<Date>getColumnOriginalValue("finishDate"));

		return googleMyBusinessHistoricImpl;
	}

	@Override
	public int compareTo(GoogleMyBusinessHistoric googleMyBusinessHistoric) {
		int value = 0;

		if (getGoogleMyBusinessHistoricId() <
				googleMyBusinessHistoric.getGoogleMyBusinessHistoricId()) {

			value = -1;
		}
		else if (getGoogleMyBusinessHistoricId() >
					googleMyBusinessHistoric.getGoogleMyBusinessHistoricId()) {

			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GoogleMyBusinessHistoric)) {
			return false;
		}

		GoogleMyBusinessHistoric googleMyBusinessHistoric =
			(GoogleMyBusinessHistoric)object;

		long primaryKey = googleMyBusinessHistoric.getPrimaryKey();

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

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<GoogleMyBusinessHistoric> toCacheModel() {
		GoogleMyBusinessHistoricCacheModel googleMyBusinessHistoricCacheModel =
			new GoogleMyBusinessHistoricCacheModel();

		googleMyBusinessHistoricCacheModel.uuid = getUuid();

		String uuid = googleMyBusinessHistoricCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			googleMyBusinessHistoricCacheModel.uuid = null;
		}

		googleMyBusinessHistoricCacheModel.googleMyBusinessHistoricId =
			getGoogleMyBusinessHistoricId();

		googleMyBusinessHistoricCacheModel.groupId = getGroupId();

		googleMyBusinessHistoricCacheModel.companyId = getCompanyId();

		googleMyBusinessHistoricCacheModel.userId = getUserId();

		googleMyBusinessHistoricCacheModel.userName = getUserName();

		String userName = googleMyBusinessHistoricCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			googleMyBusinessHistoricCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			googleMyBusinessHistoricCacheModel.createDate =
				createDate.getTime();
		}
		else {
			googleMyBusinessHistoricCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			googleMyBusinessHistoricCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			googleMyBusinessHistoricCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			googleMyBusinessHistoricCacheModel.lastPublishDate =
				lastPublishDate.getTime();
		}
		else {
			googleMyBusinessHistoricCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		googleMyBusinessHistoricCacheModel.status = getStatus();

		googleMyBusinessHistoricCacheModel.statusByUserId = getStatusByUserId();

		googleMyBusinessHistoricCacheModel.statusByUserName =
			getStatusByUserName();

		String statusByUserName =
			googleMyBusinessHistoricCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			googleMyBusinessHistoricCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			googleMyBusinessHistoricCacheModel.statusDate =
				statusDate.getTime();
		}
		else {
			googleMyBusinessHistoricCacheModel.statusDate = Long.MIN_VALUE;
		}

		googleMyBusinessHistoricCacheModel.result = getResult();

		googleMyBusinessHistoricCacheModel.operations = getOperations();

		String operations = googleMyBusinessHistoricCacheModel.operations;

		if ((operations != null) && (operations.length() == 0)) {
			googleMyBusinessHistoricCacheModel.operations = null;
		}

		googleMyBusinessHistoricCacheModel.errorDescription =
			getErrorDescription();

		String errorDescription =
			googleMyBusinessHistoricCacheModel.errorDescription;

		if ((errorDescription != null) && (errorDescription.length() == 0)) {
			googleMyBusinessHistoricCacheModel.errorDescription = null;
		}

		googleMyBusinessHistoricCacheModel.errorStackTrace =
			getErrorStackTrace();

		String errorStackTrace =
			googleMyBusinessHistoricCacheModel.errorStackTrace;

		if ((errorStackTrace != null) && (errorStackTrace.length() == 0)) {
			googleMyBusinessHistoricCacheModel.errorStackTrace = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			googleMyBusinessHistoricCacheModel.startDate = startDate.getTime();
		}
		else {
			googleMyBusinessHistoricCacheModel.startDate = Long.MIN_VALUE;
		}

		Date finishDate = getFinishDate();

		if (finishDate != null) {
			googleMyBusinessHistoricCacheModel.finishDate =
				finishDate.getTime();
		}
		else {
			googleMyBusinessHistoricCacheModel.finishDate = Long.MIN_VALUE;
		}

		return googleMyBusinessHistoricCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<GoogleMyBusinessHistoric, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<GoogleMyBusinessHistoric, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<GoogleMyBusinessHistoric, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(GoogleMyBusinessHistoric)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, GoogleMyBusinessHistoric>
				_escapedModelProxyProviderFunction =
					ProxyUtil.getProxyProviderFunction(
						GoogleMyBusinessHistoric.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _googleMyBusinessHistoricId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private Date _lastPublishDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private int _result;
	private String _operations;
	private String _errorDescription;
	private String _errorStackTrace;
	private Date _startDate;
	private Date _finishDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<GoogleMyBusinessHistoric, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((GoogleMyBusinessHistoric)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put(
			"googleMyBusinessHistoricId", _googleMyBusinessHistoricId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("lastPublishDate", _lastPublishDate);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("statusByUserId", _statusByUserId);
		_columnOriginalValues.put("statusByUserName", _statusByUserName);
		_columnOriginalValues.put("statusDate", _statusDate);
		_columnOriginalValues.put("result", _result);
		_columnOriginalValues.put("operations", _operations);
		_columnOriginalValues.put("errorDescription", _errorDescription);
		_columnOriginalValues.put("errorStackTrace", _errorStackTrace);
		_columnOriginalValues.put("startDate", _startDate);
		_columnOriginalValues.put("finishDate", _finishDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("googleMyBusinessHistoricId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("lastPublishDate", 256L);

		columnBitmasks.put("status", 512L);

		columnBitmasks.put("statusByUserId", 1024L);

		columnBitmasks.put("statusByUserName", 2048L);

		columnBitmasks.put("statusDate", 4096L);

		columnBitmasks.put("result", 8192L);

		columnBitmasks.put("operations", 16384L);

		columnBitmasks.put("errorDescription", 32768L);

		columnBitmasks.put("errorStackTrace", 65536L);

		columnBitmasks.put("startDate", 131072L);

		columnBitmasks.put("finishDate", 262144L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private GoogleMyBusinessHistoric _escapedModel;

}