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

package eu.strasbourg.service.like.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import eu.strasbourg.service.like.model.Like;
import eu.strasbourg.service.like.model.LikeModel;

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
 * The base model implementation for the Like service. Represents a row in the &quot;like_Like&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>LikeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LikeImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see LikeImpl
 * @generated
 */
@JSON(strict = true)
public class LikeModelImpl extends BaseModelImpl<Like> implements LikeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a like model instance should use the <code>Like</code> interface instead.
	 */
	public static final String TABLE_NAME = "like_Like";

	public static final Object[][] TABLE_COLUMNS = {
		{"likeId", Types.BIGINT}, {"publikUserId", Types.VARCHAR},
		{"title", Types.VARCHAR}, {"isDislike", Types.BOOLEAN},
		{"typeId", Types.BIGINT}, {"entityId", Types.BIGINT},
		{"entityGroupId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("likeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("publikUserId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isDislike", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("typeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("entityId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("entityGroupId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table like_Like (likeId LONG not null primary key,publikUserId VARCHAR(75) null,title VARCHAR(255) null,isDislike BOOLEAN,typeId LONG,entityId LONG,entityGroupId LONG)";

	public static final String TABLE_SQL_DROP = "drop table like_Like";

	public static final String ORDER_BY_JPQL = " ORDER BY like_.likeId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY like_Like.likeId ASC";

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
	public static final long ENTITYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ISDISLIKE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PUBLIKUSERID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TITLE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TYPEID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long LIKEID_COLUMN_BITMASK = 32L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.like.service.util.ServiceProps.get(
			"lock.expiration.time.eu.strasbourg.service.like.model.Like"));

	public LikeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _likeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLikeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _likeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Like.class;
	}

	@Override
	public String getModelClassName() {
		return Like.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Like, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Like, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Like, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Like)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Like, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Like, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Like)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Like, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Like, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Like, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Like, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Like, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Like, Object>>();
		Map<String, BiConsumer<Like, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Like, ?>>();

		attributeGetterFunctions.put("likeId", Like::getLikeId);
		attributeSetterBiConsumers.put(
			"likeId", (BiConsumer<Like, Long>)Like::setLikeId);
		attributeGetterFunctions.put("publikUserId", Like::getPublikUserId);
		attributeSetterBiConsumers.put(
			"publikUserId", (BiConsumer<Like, String>)Like::setPublikUserId);
		attributeGetterFunctions.put("title", Like::getTitle);
		attributeSetterBiConsumers.put(
			"title", (BiConsumer<Like, String>)Like::setTitle);
		attributeGetterFunctions.put("isDislike", Like::getIsDislike);
		attributeSetterBiConsumers.put(
			"isDislike", (BiConsumer<Like, Boolean>)Like::setIsDislike);
		attributeGetterFunctions.put("typeId", Like::getTypeId);
		attributeSetterBiConsumers.put(
			"typeId", (BiConsumer<Like, Long>)Like::setTypeId);
		attributeGetterFunctions.put("entityId", Like::getEntityId);
		attributeSetterBiConsumers.put(
			"entityId", (BiConsumer<Like, Long>)Like::setEntityId);
		attributeGetterFunctions.put("entityGroupId", Like::getEntityGroupId);
		attributeSetterBiConsumers.put(
			"entityGroupId", (BiConsumer<Like, Long>)Like::setEntityGroupId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getLikeId() {
		return _likeId;
	}

	@Override
	public void setLikeId(long likeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_likeId = likeId;
	}

	@JSON
	@Override
	public String getPublikUserId() {
		if (_publikUserId == null) {
			return "";
		}
		else {
			return _publikUserId;
		}
	}

	@Override
	public void setPublikUserId(String publikUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_publikUserId = publikUserId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalPublikUserId() {
		return getColumnOriginalValue("publikUserId");
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalTitle() {
		return getColumnOriginalValue("title");
	}

	@JSON
	@Override
	public boolean getIsDislike() {
		return _isDislike;
	}

	@JSON
	@Override
	public boolean isIsDislike() {
		return _isDislike;
	}

	@Override
	public void setIsDislike(boolean isDislike) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isDislike = isDislike;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalIsDislike() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("isDislike"));
	}

	@JSON
	@Override
	public long getTypeId() {
		return _typeId;
	}

	@Override
	public void setTypeId(long typeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_typeId = typeId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalTypeId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("typeId"));
	}

	@JSON
	@Override
	public long getEntityId() {
		return _entityId;
	}

	@Override
	public void setEntityId(long entityId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_entityId = entityId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalEntityId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("entityId"));
	}

	@JSON
	@Override
	public long getEntityGroupId() {
		return _entityGroupId;
	}

	@Override
	public void setEntityGroupId(long entityGroupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_entityGroupId = entityGroupId;
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
			0, Like.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Like toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Like>
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
		LikeImpl likeImpl = new LikeImpl();

		likeImpl.setLikeId(getLikeId());
		likeImpl.setPublikUserId(getPublikUserId());
		likeImpl.setTitle(getTitle());
		likeImpl.setIsDislike(isIsDislike());
		likeImpl.setTypeId(getTypeId());
		likeImpl.setEntityId(getEntityId());
		likeImpl.setEntityGroupId(getEntityGroupId());

		likeImpl.resetOriginalValues();

		return likeImpl;
	}

	@Override
	public Like cloneWithOriginalValues() {
		LikeImpl likeImpl = new LikeImpl();

		likeImpl.setLikeId(this.<Long>getColumnOriginalValue("likeId"));
		likeImpl.setPublikUserId(
			this.<String>getColumnOriginalValue("publikUserId"));
		likeImpl.setTitle(this.<String>getColumnOriginalValue("title"));
		likeImpl.setIsDislike(
			this.<Boolean>getColumnOriginalValue("isDislike"));
		likeImpl.setTypeId(this.<Long>getColumnOriginalValue("typeId"));
		likeImpl.setEntityId(this.<Long>getColumnOriginalValue("entityId"));
		likeImpl.setEntityGroupId(
			this.<Long>getColumnOriginalValue("entityGroupId"));

		return likeImpl;
	}

	@Override
	public int compareTo(Like like) {
		long primaryKey = like.getPrimaryKey();

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
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Like)) {
			return false;
		}

		Like like = (Like)object;

		long primaryKey = like.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Like> toCacheModel() {
		LikeCacheModel likeCacheModel = new LikeCacheModel();

		likeCacheModel.likeId = getLikeId();

		likeCacheModel.publikUserId = getPublikUserId();

		String publikUserId = likeCacheModel.publikUserId;

		if ((publikUserId != null) && (publikUserId.length() == 0)) {
			likeCacheModel.publikUserId = null;
		}

		likeCacheModel.title = getTitle();

		String title = likeCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			likeCacheModel.title = null;
		}

		likeCacheModel.isDislike = isIsDislike();

		likeCacheModel.typeId = getTypeId();

		likeCacheModel.entityId = getEntityId();

		likeCacheModel.entityGroupId = getEntityGroupId();

		return likeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Like, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Like, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Like, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Like)this);

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

		private static final Function<InvocationHandler, Like>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Like.class, ModelWrapper.class);

	}

	private long _likeId;
	private String _publikUserId;
	private String _title;
	private boolean _isDislike;
	private long _typeId;
	private long _entityId;
	private long _entityGroupId;

	public <T> T getColumnValue(String columnName) {
		Function<Like, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Like)this);
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

		_columnOriginalValues.put("likeId", _likeId);
		_columnOriginalValues.put("publikUserId", _publikUserId);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("isDislike", _isDislike);
		_columnOriginalValues.put("typeId", _typeId);
		_columnOriginalValues.put("entityId", _entityId);
		_columnOriginalValues.put("entityGroupId", _entityGroupId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("likeId", 1L);

		columnBitmasks.put("publikUserId", 2L);

		columnBitmasks.put("title", 4L);

		columnBitmasks.put("isDislike", 8L);

		columnBitmasks.put("typeId", 16L);

		columnBitmasks.put("entityId", 32L);

		columnBitmasks.put("entityGroupId", 64L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Like _escapedModel;

}