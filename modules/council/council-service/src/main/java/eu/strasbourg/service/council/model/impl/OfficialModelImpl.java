/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
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

import eu.strasbourg.service.council.model.Official;
import eu.strasbourg.service.council.model.OfficialModel;

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
 * The base model implementation for the Official service. Represents a row in the &quot;council_Official&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>OfficialModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OfficialImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OfficialImpl
 * @generated
 */
@JSON(strict = true)
public class OfficialModelImpl
	extends BaseModelImpl<Official> implements OfficialModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a official model instance should use the <code>Official</code> interface instead.
	 */
	public static final String TABLE_NAME = "council_Official";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"officialId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP},
		{"email", Types.VARCHAR}, {"firstname", Types.VARCHAR},
		{"lastname", Types.VARCHAR}, {"isActive", Types.BOOLEAN},
		{"lastActivity", Types.TIMESTAMP},
		{"lastSignInDeviceInfo", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("officialId", Types.BIGINT);
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
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("firstname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isActive", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("lastActivity", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("lastSignInDeviceInfo", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table council_Official (uuid_ VARCHAR(75) null,officialId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,email VARCHAR(75) null,firstname VARCHAR(75) null,lastname VARCHAR(75) null,isActive BOOLEAN,lastActivity DATE null,lastSignInDeviceInfo VARCHAR(300) null)";

	public static final String TABLE_SQL_DROP = "drop table council_Official";

	public static final String ORDER_BY_JPQL =
		" ORDER BY official.lastname ASC, official.firstname ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY council_Official.lastname ASC, council_Official.firstname ASC";

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
	public static final long EMAIL_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ISACTIVE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long LASTNAME_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FIRSTNAME_COLUMN_BITMASK = 64L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.council.service.util.ServiceProps.get(
			"lock.expiration.time.eu.strasbourg.service.council.model.Official"));

	public OfficialModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _officialId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOfficialId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _officialId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Official.class;
	}

	@Override
	public String getModelClassName() {
		return Official.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Official, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Official, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Official, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Official)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Official, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Official, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Official)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Official, Object>>
		getAttributeGetterFunctions() {

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Official, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<Official, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<Official, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<Official, Object>>();

			attributeGetterFunctions.put("uuid", Official::getUuid);
			attributeGetterFunctions.put("officialId", Official::getOfficialId);
			attributeGetterFunctions.put("groupId", Official::getGroupId);
			attributeGetterFunctions.put("companyId", Official::getCompanyId);
			attributeGetterFunctions.put("userId", Official::getUserId);
			attributeGetterFunctions.put("userName", Official::getUserName);
			attributeGetterFunctions.put("createDate", Official::getCreateDate);
			attributeGetterFunctions.put(
				"modifiedDate", Official::getModifiedDate);
			attributeGetterFunctions.put("status", Official::getStatus);
			attributeGetterFunctions.put(
				"statusByUserId", Official::getStatusByUserId);
			attributeGetterFunctions.put(
				"statusByUserName", Official::getStatusByUserName);
			attributeGetterFunctions.put("statusDate", Official::getStatusDate);
			attributeGetterFunctions.put("email", Official::getEmail);
			attributeGetterFunctions.put("firstname", Official::getFirstname);
			attributeGetterFunctions.put("lastname", Official::getLastname);
			attributeGetterFunctions.put("isActive", Official::getIsActive);
			attributeGetterFunctions.put(
				"lastActivity", Official::getLastActivity);
			attributeGetterFunctions.put(
				"lastSignInDeviceInfo", Official::getLastSignInDeviceInfo);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<Official, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<Official, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<Official, ?>>();

			attributeSetterBiConsumers.put(
				"uuid", (BiConsumer<Official, String>)Official::setUuid);
			attributeSetterBiConsumers.put(
				"officialId",
				(BiConsumer<Official, Long>)Official::setOfficialId);
			attributeSetterBiConsumers.put(
				"groupId", (BiConsumer<Official, Long>)Official::setGroupId);
			attributeSetterBiConsumers.put(
				"companyId",
				(BiConsumer<Official, Long>)Official::setCompanyId);
			attributeSetterBiConsumers.put(
				"userId", (BiConsumer<Official, Long>)Official::setUserId);
			attributeSetterBiConsumers.put(
				"userName",
				(BiConsumer<Official, String>)Official::setUserName);
			attributeSetterBiConsumers.put(
				"createDate",
				(BiConsumer<Official, Date>)Official::setCreateDate);
			attributeSetterBiConsumers.put(
				"modifiedDate",
				(BiConsumer<Official, Date>)Official::setModifiedDate);
			attributeSetterBiConsumers.put(
				"status", (BiConsumer<Official, Integer>)Official::setStatus);
			attributeSetterBiConsumers.put(
				"statusByUserId",
				(BiConsumer<Official, Long>)Official::setStatusByUserId);
			attributeSetterBiConsumers.put(
				"statusByUserName",
				(BiConsumer<Official, String>)Official::setStatusByUserName);
			attributeSetterBiConsumers.put(
				"statusDate",
				(BiConsumer<Official, Date>)Official::setStatusDate);
			attributeSetterBiConsumers.put(
				"email", (BiConsumer<Official, String>)Official::setEmail);
			attributeSetterBiConsumers.put(
				"firstname",
				(BiConsumer<Official, String>)Official::setFirstname);
			attributeSetterBiConsumers.put(
				"lastname",
				(BiConsumer<Official, String>)Official::setLastname);
			attributeSetterBiConsumers.put(
				"isActive",
				(BiConsumer<Official, Boolean>)Official::setIsActive);
			attributeSetterBiConsumers.put(
				"lastActivity",
				(BiConsumer<Official, Date>)Official::setLastActivity);
			attributeSetterBiConsumers.put(
				"lastSignInDeviceInfo",
				(BiConsumer<Official, String>)
					Official::setLastSignInDeviceInfo);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@JSON
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

	@JSON
	@Override
	public long getOfficialId() {
		return _officialId;
	}

	@Override
	public void setOfficialId(long officialId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_officialId = officialId;
	}

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
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

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_email = email;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalEmail() {
		return getColumnOriginalValue("email");
	}

	@JSON
	@Override
	public String getFirstname() {
		if (_firstname == null) {
			return "";
		}
		else {
			return _firstname;
		}
	}

	@Override
	public void setFirstname(String firstname) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_firstname = firstname;
	}

	@JSON
	@Override
	public String getLastname() {
		if (_lastname == null) {
			return "";
		}
		else {
			return _lastname;
		}
	}

	@Override
	public void setLastname(String lastname) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastname = lastname;
	}

	@JSON
	@Override
	public boolean getIsActive() {
		return _isActive;
	}

	@JSON
	@Override
	public boolean isIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isActive = isActive;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalIsActive() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("isActive"));
	}

	@JSON
	@Override
	public Date getLastActivity() {
		return _lastActivity;
	}

	@Override
	public void setLastActivity(Date lastActivity) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastActivity = lastActivity;
	}

	@JSON
	@Override
	public String getLastSignInDeviceInfo() {
		if (_lastSignInDeviceInfo == null) {
			return "";
		}
		else {
			return _lastSignInDeviceInfo;
		}
	}

	@Override
	public void setLastSignInDeviceInfo(String lastSignInDeviceInfo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastSignInDeviceInfo = lastSignInDeviceInfo;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Official.class.getName()));
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
			getCompanyId(), Official.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Official toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Official>
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
		OfficialImpl officialImpl = new OfficialImpl();

		officialImpl.setUuid(getUuid());
		officialImpl.setOfficialId(getOfficialId());
		officialImpl.setGroupId(getGroupId());
		officialImpl.setCompanyId(getCompanyId());
		officialImpl.setUserId(getUserId());
		officialImpl.setUserName(getUserName());
		officialImpl.setCreateDate(getCreateDate());
		officialImpl.setModifiedDate(getModifiedDate());
		officialImpl.setStatus(getStatus());
		officialImpl.setStatusByUserId(getStatusByUserId());
		officialImpl.setStatusByUserName(getStatusByUserName());
		officialImpl.setStatusDate(getStatusDate());
		officialImpl.setEmail(getEmail());
		officialImpl.setFirstname(getFirstname());
		officialImpl.setLastname(getLastname());
		officialImpl.setIsActive(isIsActive());
		officialImpl.setLastActivity(getLastActivity());
		officialImpl.setLastSignInDeviceInfo(getLastSignInDeviceInfo());

		officialImpl.resetOriginalValues();

		return officialImpl;
	}

	@Override
	public Official cloneWithOriginalValues() {
		OfficialImpl officialImpl = new OfficialImpl();

		officialImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		officialImpl.setOfficialId(
			this.<Long>getColumnOriginalValue("officialId"));
		officialImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		officialImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		officialImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		officialImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		officialImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		officialImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		officialImpl.setStatus(this.<Integer>getColumnOriginalValue("status"));
		officialImpl.setStatusByUserId(
			this.<Long>getColumnOriginalValue("statusByUserId"));
		officialImpl.setStatusByUserName(
			this.<String>getColumnOriginalValue("statusByUserName"));
		officialImpl.setStatusDate(
			this.<Date>getColumnOriginalValue("statusDate"));
		officialImpl.setEmail(this.<String>getColumnOriginalValue("email"));
		officialImpl.setFirstname(
			this.<String>getColumnOriginalValue("firstname"));
		officialImpl.setLastname(
			this.<String>getColumnOriginalValue("lastname"));
		officialImpl.setIsActive(
			this.<Boolean>getColumnOriginalValue("isActive"));
		officialImpl.setLastActivity(
			this.<Date>getColumnOriginalValue("lastActivity"));
		officialImpl.setLastSignInDeviceInfo(
			this.<String>getColumnOriginalValue("lastSignInDeviceInfo"));

		return officialImpl;
	}

	@Override
	public int compareTo(Official official) {
		int value = 0;

		value = getLastname().compareToIgnoreCase(official.getLastname());

		if (value != 0) {
			return value;
		}

		value = getFirstname().compareToIgnoreCase(official.getFirstname());

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

		if (!(object instanceof Official)) {
			return false;
		}

		Official official = (Official)object;

		long primaryKey = official.getPrimaryKey();

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
	public CacheModel<Official> toCacheModel() {
		OfficialCacheModel officialCacheModel = new OfficialCacheModel();

		officialCacheModel.uuid = getUuid();

		String uuid = officialCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			officialCacheModel.uuid = null;
		}

		officialCacheModel.officialId = getOfficialId();

		officialCacheModel.groupId = getGroupId();

		officialCacheModel.companyId = getCompanyId();

		officialCacheModel.userId = getUserId();

		officialCacheModel.userName = getUserName();

		String userName = officialCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			officialCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			officialCacheModel.createDate = createDate.getTime();
		}
		else {
			officialCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			officialCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			officialCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		officialCacheModel.status = getStatus();

		officialCacheModel.statusByUserId = getStatusByUserId();

		officialCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = officialCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			officialCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			officialCacheModel.statusDate = statusDate.getTime();
		}
		else {
			officialCacheModel.statusDate = Long.MIN_VALUE;
		}

		officialCacheModel.email = getEmail();

		String email = officialCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			officialCacheModel.email = null;
		}

		officialCacheModel.firstname = getFirstname();

		String firstname = officialCacheModel.firstname;

		if ((firstname != null) && (firstname.length() == 0)) {
			officialCacheModel.firstname = null;
		}

		officialCacheModel.lastname = getLastname();

		String lastname = officialCacheModel.lastname;

		if ((lastname != null) && (lastname.length() == 0)) {
			officialCacheModel.lastname = null;
		}

		officialCacheModel.isActive = isIsActive();

		Date lastActivity = getLastActivity();

		if (lastActivity != null) {
			officialCacheModel.lastActivity = lastActivity.getTime();
		}
		else {
			officialCacheModel.lastActivity = Long.MIN_VALUE;
		}

		officialCacheModel.lastSignInDeviceInfo = getLastSignInDeviceInfo();

		String lastSignInDeviceInfo = officialCacheModel.lastSignInDeviceInfo;

		if ((lastSignInDeviceInfo != null) &&
			(lastSignInDeviceInfo.length() == 0)) {

			officialCacheModel.lastSignInDeviceInfo = null;
		}

		return officialCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Official, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Official, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Official, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Official)this);

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

		private static final Function<InvocationHandler, Official>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Official.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _officialId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _email;
	private String _firstname;
	private String _lastname;
	private boolean _isActive;
	private Date _lastActivity;
	private String _lastSignInDeviceInfo;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Official, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Official)this);
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
		_columnOriginalValues.put("officialId", _officialId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("statusByUserId", _statusByUserId);
		_columnOriginalValues.put("statusByUserName", _statusByUserName);
		_columnOriginalValues.put("statusDate", _statusDate);
		_columnOriginalValues.put("email", _email);
		_columnOriginalValues.put("firstname", _firstname);
		_columnOriginalValues.put("lastname", _lastname);
		_columnOriginalValues.put("isActive", _isActive);
		_columnOriginalValues.put("lastActivity", _lastActivity);
		_columnOriginalValues.put(
			"lastSignInDeviceInfo", _lastSignInDeviceInfo);
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

		columnBitmasks.put("officialId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("status", 256L);

		columnBitmasks.put("statusByUserId", 512L);

		columnBitmasks.put("statusByUserName", 1024L);

		columnBitmasks.put("statusDate", 2048L);

		columnBitmasks.put("email", 4096L);

		columnBitmasks.put("firstname", 8192L);

		columnBitmasks.put("lastname", 16384L);

		columnBitmasks.put("isActive", 32768L);

		columnBitmasks.put("lastActivity", 65536L);

		columnBitmasks.put("lastSignInDeviceInfo", 131072L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Official _escapedModel;

}