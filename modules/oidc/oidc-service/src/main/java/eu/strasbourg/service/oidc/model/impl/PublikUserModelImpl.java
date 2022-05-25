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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.model.PublikUserModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the PublikUser service. Represents a row in the &quot;publik_PublikUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PublikUserModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PublikUserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PublikUserImpl
 * @generated
 */
public class PublikUserModelImpl
	extends BaseModelImpl<PublikUser> implements PublikUserModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a publik user model instance should use the <code>PublikUser</code> interface instead.
	 */
	public static final String TABLE_NAME = "publik_PublikUser";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"publikUserLiferayId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"publikId", Types.VARCHAR}, {"accessToken", Types.VARCHAR},
		{"firstName", Types.VARCHAR}, {"lastName", Types.VARCHAR},
		{"email", Types.VARCHAR}, {"mapConfig", Types.VARCHAR},
		{"displayConfig", Types.VARCHAR}, {"pactSignature", Types.TIMESTAMP},
		{"banishDate", Types.TIMESTAMP}, {"banishDescription", Types.CLOB},
		{"imageURL", Types.VARCHAR}, {"pactDisplay", Types.BOOLEAN},
		{"csmapJSON", Types.VARCHAR}, {"modifiedDateJSON", Types.TIMESTAMP},
		{"topicsFCM", Types.VARCHAR}, {"lastUpdateTimeTopics", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("publikUserLiferayId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("publikId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("accessToken", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mapConfig", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("displayConfig", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("pactSignature", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("banishDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("banishDescription", Types.CLOB);
		TABLE_COLUMNS_MAP.put("imageURL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("pactDisplay", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("csmapJSON", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifiedDateJSON", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("topicsFCM", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastUpdateTimeTopics", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table publik_PublikUser (uuid_ VARCHAR(75) null,publikUserLiferayId LONG not null primary key,createDate DATE null,modifiedDate DATE null,userId LONG,userName VARCHAR(75) null,publikId VARCHAR(200) null,accessToken VARCHAR(200) null,firstName VARCHAR(200) null,lastName VARCHAR(200) null,email VARCHAR(75) null,mapConfig VARCHAR(1000) null,displayConfig TEXT null,pactSignature DATE null,banishDate DATE null,banishDescription TEXT null,imageURL VARCHAR(400) null,pactDisplay BOOLEAN,csmapJSON STRING null,modifiedDateJSON DATE null,topicsFCM VARCHAR(400) null,lastUpdateTimeTopics LONG)";

	public static final String TABLE_SQL_DROP = "drop table publik_PublikUser";

	public static final String ORDER_BY_JPQL =
		" ORDER BY publikUser.lastName ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY publik_PublikUser.lastName ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.oidc.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.oidc.model.PublikUser"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.oidc.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.oidc.model.PublikUser"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.oidc.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.oidc.model.PublikUser"),
		true);

	public static final long PUBLIKID_COLUMN_BITMASK = 1L;

	public static final long UUID_COLUMN_BITMASK = 2L;

	public static final long LASTNAME_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.oidc.service.util.ServiceProps.get(
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

		Map<String, Function<PublikUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PublikUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PublikUser, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((PublikUser)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PublikUser, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PublikUser, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PublikUser)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PublikUser, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PublikUser, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, PublikUser>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			PublikUser.class.getClassLoader(), PublikUser.class,
			ModelWrapper.class);

		try {
			Constructor<PublikUser> constructor =
				(Constructor<PublikUser>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<PublikUser, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PublikUser, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PublikUser, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<PublikUser, Object>>();
		Map<String, BiConsumer<PublikUser, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<PublikUser, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(PublikUser publikUser, Object uuidObject) {
					publikUser.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"publikUserLiferayId",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getPublikUserLiferayId();
				}

			});
		attributeSetterBiConsumers.put(
			"publikUserLiferayId",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object publikUserLiferayIdObject) {

					publikUser.setPublikUserLiferayId(
						(Long)publikUserLiferayIdObject);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object createDateObject) {

					publikUser.setCreateDate((Date)createDateObject);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object modifiedDateObject) {

					publikUser.setModifiedDate((Date)modifiedDateObject);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(PublikUser publikUser, Object userIdObject) {
					publikUser.setUserId((Long)userIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object userNameObject) {

					publikUser.setUserName((String)userNameObject);
				}

			});
		attributeGetterFunctions.put(
			"publikId",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getPublikId();
				}

			});
		attributeSetterBiConsumers.put(
			"publikId",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object publikIdObject) {

					publikUser.setPublikId((String)publikIdObject);
				}

			});
		attributeGetterFunctions.put(
			"accessToken",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getAccessToken();
				}

			});
		attributeSetterBiConsumers.put(
			"accessToken",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object accessTokenObject) {

					publikUser.setAccessToken((String)accessTokenObject);
				}

			});
		attributeGetterFunctions.put(
			"firstName",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getFirstName();
				}

			});
		attributeSetterBiConsumers.put(
			"firstName",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object firstNameObject) {

					publikUser.setFirstName((String)firstNameObject);
				}

			});
		attributeGetterFunctions.put(
			"lastName",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getLastName();
				}

			});
		attributeSetterBiConsumers.put(
			"lastName",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object lastNameObject) {

					publikUser.setLastName((String)lastNameObject);
				}

			});
		attributeGetterFunctions.put(
			"email",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getEmail();
				}

			});
		attributeSetterBiConsumers.put(
			"email",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(PublikUser publikUser, Object emailObject) {
					publikUser.setEmail((String)emailObject);
				}

			});
		attributeGetterFunctions.put(
			"mapConfig",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getMapConfig();
				}

			});
		attributeSetterBiConsumers.put(
			"mapConfig",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object mapConfigObject) {

					publikUser.setMapConfig((String)mapConfigObject);
				}

			});
		attributeGetterFunctions.put(
			"displayConfig",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getDisplayConfig();
				}

			});
		attributeSetterBiConsumers.put(
			"displayConfig",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object displayConfigObject) {

					publikUser.setDisplayConfig((String)displayConfigObject);
				}

			});
		attributeGetterFunctions.put(
			"pactSignature",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getPactSignature();
				}

			});
		attributeSetterBiConsumers.put(
			"pactSignature",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object pactSignatureObject) {

					publikUser.setPactSignature((Date)pactSignatureObject);
				}

			});
		attributeGetterFunctions.put(
			"banishDate",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getBanishDate();
				}

			});
		attributeSetterBiConsumers.put(
			"banishDate",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object banishDateObject) {

					publikUser.setBanishDate((Date)banishDateObject);
				}

			});
		attributeGetterFunctions.put(
			"banishDescription",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getBanishDescription();
				}

			});
		attributeSetterBiConsumers.put(
			"banishDescription",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object banishDescriptionObject) {

					publikUser.setBanishDescription(
						(String)banishDescriptionObject);
				}

			});
		attributeGetterFunctions.put(
			"imageURL",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getImageURL();
				}

			});
		attributeSetterBiConsumers.put(
			"imageURL",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object imageURLObject) {

					publikUser.setImageURL((String)imageURLObject);
				}

			});
		attributeGetterFunctions.put(
			"pactDisplay",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getPactDisplay();
				}

			});
		attributeSetterBiConsumers.put(
			"pactDisplay",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object pactDisplayObject) {

					publikUser.setPactDisplay((Boolean)pactDisplayObject);
				}

			});
		attributeGetterFunctions.put(
			"csmapJSON",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getCsmapJSON();
				}

			});
		attributeSetterBiConsumers.put(
			"csmapJSON",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object csmapJSONObject) {

					publikUser.setCsmapJSON((String)csmapJSONObject);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDateJSON",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getModifiedDateJSON();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDateJSON",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object modifiedDateJSONObject) {

					publikUser.setModifiedDateJSON(
						(Date)modifiedDateJSONObject);
				}

			});
		attributeGetterFunctions.put(
			"topicsFCM",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getTopicsFCM();
				}

			});
		attributeSetterBiConsumers.put(
			"topicsFCM",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object topicsFCMObject) {

					publikUser.setTopicsFCM((String)topicsFCMObject);
				}

			});
		attributeGetterFunctions.put(
			"lastUpdateTimeTopics",
			new Function<PublikUser, Object>() {

				@Override
				public Object apply(PublikUser publikUser) {
					return publikUser.getLastUpdateTimeTopics();
				}

			});
		attributeSetterBiConsumers.put(
			"lastUpdateTimeTopics",
			new BiConsumer<PublikUser, Object>() {

				@Override
				public void accept(
					PublikUser publikUser, Object lastUpdateTimeTopicsObject) {

					publikUser.setLastUpdateTimeTopics(
						(Long)lastUpdateTimeTopicsObject);
				}

			});

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
		_columnBitmask |= UUID_COLUMN_BITMASK;

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
		_userName = userName;
	}

	@Override
	public String getPublikId() {
		if (_publikId == null) {
			return "";
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
			return "";
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
			return "";
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
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_columnBitmask = -1L;

		_lastName = lastName;
	}

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
		_email = email;
	}

	@Override
	public String getMapConfig() {
		if (_mapConfig == null) {
			return "";
		}
		else {
			return _mapConfig;
		}
	}

	@Override
	public void setMapConfig(String mapConfig) {
		_mapConfig = mapConfig;
	}

	@Override
	public String getDisplayConfig() {
		if (_displayConfig == null) {
			return "";
		}
		else {
			return _displayConfig;
		}
	}

	@Override
	public void setDisplayConfig(String displayConfig) {
		_displayConfig = displayConfig;
	}

	@Override
	public Date getPactSignature() {
		return _pactSignature;
	}

	@Override
	public void setPactSignature(Date pactSignature) {
		_pactSignature = pactSignature;
	}

	@Override
	public Date getBanishDate() {
		return _banishDate;
	}

	@Override
	public void setBanishDate(Date banishDate) {
		_banishDate = banishDate;
	}

	@Override
	public String getBanishDescription() {
		if (_banishDescription == null) {
			return "";
		}
		else {
			return _banishDescription;
		}
	}

	@Override
	public void setBanishDescription(String banishDescription) {
		_banishDescription = banishDescription;
	}

	@Override
	public String getImageURL() {
		if (_imageURL == null) {
			return "";
		}
		else {
			return _imageURL;
		}
	}

	@Override
	public void setImageURL(String imageURL) {
		_imageURL = imageURL;
	}

	@Override
	public boolean getPactDisplay() {
		return _pactDisplay;
	}

	@Override
	public boolean isPactDisplay() {
		return _pactDisplay;
	}

	@Override
	public void setPactDisplay(boolean pactDisplay) {
		_pactDisplay = pactDisplay;
	}

	@Override
	public String getCsmapJSON() {
		if (_csmapJSON == null) {
			return "";
		}
		else {
			return _csmapJSON;
		}
	}

	@Override
	public void setCsmapJSON(String csmapJSON) {
		_csmapJSON = csmapJSON;
	}

	@Override
	public Date getModifiedDateJSON() {
		return _modifiedDateJSON;
	}

	@Override
	public void setModifiedDateJSON(Date modifiedDateJSON) {
		_modifiedDateJSON = modifiedDateJSON;
	}

	@Override
	public String getTopicsFCM() {
		if (_topicsFCM == null) {
			return "";
		}
		else {
			return _topicsFCM;
		}
	}

	@Override
	public void setTopicsFCM(String topicsFCM) {
		_topicsFCM = topicsFCM;
	}

	@Override
	public long getLastUpdateTimeTopics() {
		return _lastUpdateTimeTopics;
	}

	@Override
	public void setLastUpdateTimeTopics(long lastUpdateTimeTopics) {
		_lastUpdateTimeTopics = lastUpdateTimeTopics;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, PublikUser.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PublikUser toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PublikUser>
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
		PublikUserImpl publikUserImpl = new PublikUserImpl();

		publikUserImpl.setUuid(getUuid());
		publikUserImpl.setPublikUserLiferayId(getPublikUserLiferayId());
		publikUserImpl.setCreateDate(getCreateDate());
		publikUserImpl.setModifiedDate(getModifiedDate());
		publikUserImpl.setUserId(getUserId());
		publikUserImpl.setUserName(getUserName());
		publikUserImpl.setPublikId(getPublikId());
		publikUserImpl.setAccessToken(getAccessToken());
		publikUserImpl.setFirstName(getFirstName());
		publikUserImpl.setLastName(getLastName());
		publikUserImpl.setEmail(getEmail());
		publikUserImpl.setMapConfig(getMapConfig());
		publikUserImpl.setDisplayConfig(getDisplayConfig());
		publikUserImpl.setPactSignature(getPactSignature());
		publikUserImpl.setBanishDate(getBanishDate());
		publikUserImpl.setBanishDescription(getBanishDescription());
		publikUserImpl.setImageURL(getImageURL());
		publikUserImpl.setPactDisplay(isPactDisplay());
		publikUserImpl.setCsmapJSON(getCsmapJSON());
		publikUserImpl.setModifiedDateJSON(getModifiedDateJSON());
		publikUserImpl.setTopicsFCM(getTopicsFCM());
		publikUserImpl.setLastUpdateTimeTopics(getLastUpdateTimeTopics());

		publikUserImpl.resetOriginalValues();

		return publikUserImpl;
	}

	@Override
	public int compareTo(PublikUser publikUser) {
		int value = 0;

		value = getLastName().compareTo(publikUser.getLastName());

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

		if (!(object instanceof PublikUser)) {
			return false;
		}

		PublikUser publikUser = (PublikUser)object;

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

		publikUserCacheModel.userId = getUserId();

		publikUserCacheModel.userName = getUserName();

		String userName = publikUserCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			publikUserCacheModel.userName = null;
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

		publikUserCacheModel.displayConfig = getDisplayConfig();

		String displayConfig = publikUserCacheModel.displayConfig;

		if ((displayConfig != null) && (displayConfig.length() == 0)) {
			publikUserCacheModel.displayConfig = null;
		}

		Date pactSignature = getPactSignature();

		if (pactSignature != null) {
			publikUserCacheModel.pactSignature = pactSignature.getTime();
		}
		else {
			publikUserCacheModel.pactSignature = Long.MIN_VALUE;
		}

		Date banishDate = getBanishDate();

		if (banishDate != null) {
			publikUserCacheModel.banishDate = banishDate.getTime();
		}
		else {
			publikUserCacheModel.banishDate = Long.MIN_VALUE;
		}

		publikUserCacheModel.banishDescription = getBanishDescription();

		String banishDescription = publikUserCacheModel.banishDescription;

		if ((banishDescription != null) && (banishDescription.length() == 0)) {
			publikUserCacheModel.banishDescription = null;
		}

		publikUserCacheModel.imageURL = getImageURL();

		String imageURL = publikUserCacheModel.imageURL;

		if ((imageURL != null) && (imageURL.length() == 0)) {
			publikUserCacheModel.imageURL = null;
		}

		publikUserCacheModel.pactDisplay = isPactDisplay();

		publikUserCacheModel.csmapJSON = getCsmapJSON();

		String csmapJSON = publikUserCacheModel.csmapJSON;

		if ((csmapJSON != null) && (csmapJSON.length() == 0)) {
			publikUserCacheModel.csmapJSON = null;
		}

		Date modifiedDateJSON = getModifiedDateJSON();

		if (modifiedDateJSON != null) {
			publikUserCacheModel.modifiedDateJSON = modifiedDateJSON.getTime();
		}
		else {
			publikUserCacheModel.modifiedDateJSON = Long.MIN_VALUE;
		}

		publikUserCacheModel.topicsFCM = getTopicsFCM();

		String topicsFCM = publikUserCacheModel.topicsFCM;

		if ((topicsFCM != null) && (topicsFCM.length() == 0)) {
			publikUserCacheModel.topicsFCM = null;
		}

		publikUserCacheModel.lastUpdateTimeTopics = getLastUpdateTimeTopics();

		return publikUserCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PublikUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PublikUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PublikUser, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PublikUser)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<PublikUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PublikUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PublikUser, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PublikUser)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PublikUser>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _publikUserLiferayId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _userId;
	private String _userName;
	private String _publikId;
	private String _originalPublikId;
	private String _accessToken;
	private String _firstName;
	private String _lastName;
	private String _email;
	private String _mapConfig;
	private String _displayConfig;
	private Date _pactSignature;
	private Date _banishDate;
	private String _banishDescription;
	private String _imageURL;
	private boolean _pactDisplay;
	private String _csmapJSON;
	private Date _modifiedDateJSON;
	private String _topicsFCM;
	private long _lastUpdateTimeTopics;
	private long _columnBitmask;
	private PublikUser _escapedModel;

}