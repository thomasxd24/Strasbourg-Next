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

package eu.strasbourg.service.oidc.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.model.PublikUserModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the PublikUser service. Represents a row in the &quot;publik_PublikUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PublikUserModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PublikUserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PublikUserImpl
 * @see PublikUser
 * @see PublikUserModel
 * @generated
 */
@ProviderType
public class PublikUserModelImpl extends BaseModelImpl<PublikUser>
	implements PublikUserModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a publik user model instance should use the {@link PublikUser} interface instead.
	 */
	public static final String TABLE_NAME = "publik_PublikUser";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "publikUserLiferayId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "publikId", Types.VARCHAR },
			{ "accessToken", Types.VARCHAR },
			{ "firstName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "mapConfig", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("publikUserLiferayId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("publikId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("accessToken", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mapConfig", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table publik_PublikUser (uuid_ VARCHAR(75) null,publikUserLiferayId LONG not null primary key,createDate DATE null,modifiedDate DATE null,publikId VARCHAR(200) null,accessToken VARCHAR(200) null,firstName VARCHAR(200) null,lastName VARCHAR(200) null,email VARCHAR(75) null,mapConfig VARCHAR(1000) null)";
	public static final String TABLE_SQL_DROP = "drop table publik_PublikUser";
	public static final String ORDER_BY_JPQL = " ORDER BY publikUser.publikUserLiferayId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY publik_PublikUser.publikUserLiferayId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.oidc.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.eu.strasbourg.service.oidc.model.PublikUser"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.oidc.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.eu.strasbourg.service.oidc.model.PublikUser"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.oidc.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.eu.strasbourg.service.oidc.model.PublikUser"),
			true);
	public static final long PUBLIKID_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;
	public static final long PUBLIKUSERLIFERAYID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(eu.strasbourg.service.oidc.service.util.ServiceProps.get(
				"lock.expiration.time.eu.strasbourg.service.oidc.model.PublikUser"));

	public PublikUserModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _publikUserLiferayId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPublikUserLiferayId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _publikUserLiferayId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PublikUser.class;
	}

	@Override
	public String getModelClassName() {
		return PublikUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("publikUserLiferayId", getPublikUserLiferayId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("publikId", getPublikId());
		attributes.put("accessToken", getAccessToken());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("email", getEmail());
		attributes.put("mapConfig", getMapConfig());

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

		Long publikUserLiferayId = (Long)attributes.get("publikUserLiferayId");

		if (publikUserLiferayId != null) {
			setPublikUserLiferayId(publikUserLiferayId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String publikId = (String)attributes.get("publikId");

		if (publikId != null) {
			setPublikId(publikId);
		}

		String accessToken = (String)attributes.get("accessToken");

		if (accessToken != null) {
			setAccessToken(accessToken);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String mapConfig = (String)attributes.get("mapConfig");

		if (mapConfig != null) {
			setMapConfig(mapConfig);
		}
	}

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

	@Override
	public long getPublikUserLiferayId() {
		return _publikUserLiferayId;
	}

	@Override
	public void setPublikUserLiferayId(long publikUserLiferayId) {
		_publikUserLiferayId = publikUserLiferayId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
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

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getPublikId() {
		if (_publikId == null) {
			return StringPool.BLANK;
		}
		else {
			return _publikId;
		}
	}

	@Override
	public void setPublikId(String publikId) {
		_columnBitmask |= PUBLIKID_COLUMN_BITMASK;

		if (_originalPublikId == null) {
			_originalPublikId = _publikId;
		}

		_publikId = publikId;
	}

	public String getOriginalPublikId() {
		return GetterUtil.getString(_originalPublikId);
	}

	@Override
	public String getAccessToken() {
		if (_accessToken == null) {
			return StringPool.BLANK;
		}
		else {
			return _accessToken;
		}
	}

	@Override
	public void setAccessToken(String accessToken) {
		_accessToken = accessToken;
	}

	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@Override
	public String getLastName() {
		if (_lastName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@Override
	public String getMapConfig() {
		if (_mapConfig == null) {
			return StringPool.BLANK;
		}
		else {
			return _mapConfig;
		}
	}

	@Override
	public void setMapConfig(String mapConfig) {
		_mapConfig = mapConfig;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			PublikUser.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PublikUser toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PublikUser)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PublikUserImpl publikUserImpl = new PublikUserImpl();

		publikUserImpl.setUuid(getUuid());
		publikUserImpl.setPublikUserLiferayId(getPublikUserLiferayId());
		publikUserImpl.setCreateDate(getCreateDate());
		publikUserImpl.setModifiedDate(getModifiedDate());
		publikUserImpl.setPublikId(getPublikId());
		publikUserImpl.setAccessToken(getAccessToken());
		publikUserImpl.setFirstName(getFirstName());
		publikUserImpl.setLastName(getLastName());
		publikUserImpl.setEmail(getEmail());
		publikUserImpl.setMapConfig(getMapConfig());

		publikUserImpl.resetOriginalValues();

		return publikUserImpl;
	}

	@Override
	public int compareTo(PublikUser publikUser) {
		long primaryKey = publikUser.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublikUser)) {
			return false;
		}

		PublikUser publikUser = (PublikUser)obj;

		long primaryKey = publikUser.getPrimaryKey();

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
		PublikUserModelImpl publikUserModelImpl = this;

		publikUserModelImpl._originalUuid = publikUserModelImpl._uuid;

		publikUserModelImpl._setModifiedDate = false;

		publikUserModelImpl._originalPublikId = publikUserModelImpl._publikId;

		publikUserModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PublikUser> toCacheModel() {
		PublikUserCacheModel publikUserCacheModel = new PublikUserCacheModel();

		publikUserCacheModel.uuid = getUuid();

		String uuid = publikUserCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			publikUserCacheModel.uuid = null;
		}

		publikUserCacheModel.publikUserLiferayId = getPublikUserLiferayId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			publikUserCacheModel.createDate = createDate.getTime();
		}
		else {
			publikUserCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			publikUserCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			publikUserCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		publikUserCacheModel.publikId = getPublikId();

		String publikId = publikUserCacheModel.publikId;

		if ((publikId != null) && (publikId.length() == 0)) {
			publikUserCacheModel.publikId = null;
		}

		publikUserCacheModel.accessToken = getAccessToken();

		String accessToken = publikUserCacheModel.accessToken;

		if ((accessToken != null) && (accessToken.length() == 0)) {
			publikUserCacheModel.accessToken = null;
		}

		publikUserCacheModel.firstName = getFirstName();

		String firstName = publikUserCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			publikUserCacheModel.firstName = null;
		}

		publikUserCacheModel.lastName = getLastName();

		String lastName = publikUserCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			publikUserCacheModel.lastName = null;
		}

		publikUserCacheModel.email = getEmail();

		String email = publikUserCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			publikUserCacheModel.email = null;
		}

		publikUserCacheModel.mapConfig = getMapConfig();

		String mapConfig = publikUserCacheModel.mapConfig;

		if ((mapConfig != null) && (mapConfig.length() == 0)) {
			publikUserCacheModel.mapConfig = null;
		}

		return publikUserCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", publikUserLiferayId=");
		sb.append(getPublikUserLiferayId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", publikId=");
		sb.append(getPublikId());
		sb.append(", accessToken=");
		sb.append(getAccessToken());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", mapConfig=");
		sb.append(getMapConfig());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("eu.strasbourg.service.oidc.model.PublikUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publikUserLiferayId</column-name><column-value><![CDATA[");
		sb.append(getPublikUserLiferayId());
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
			"<column><column-name>publikId</column-name><column-value><![CDATA[");
		sb.append(getPublikId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessToken</column-name><column-value><![CDATA[");
		sb.append(getAccessToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mapConfig</column-name><column-value><![CDATA[");
		sb.append(getMapConfig());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = PublikUser.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			PublikUser.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _publikUserLiferayId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _publikId;
	private String _originalPublikId;
	private String _accessToken;
	private String _firstName;
	private String _lastName;
	private String _email;
	private String _mapConfig;
	private long _columnBitmask;
	private PublikUser _escapedModel;
}