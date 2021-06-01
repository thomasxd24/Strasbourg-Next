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

package eu.strasbourg.service.favorite.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.favorite.model.Favorite;
import eu.strasbourg.service.favorite.model.FavoriteModel;
import eu.strasbourg.service.favorite.model.FavoriteSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Favorite service. Represents a row in the &quot;favorite_Favorite&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>FavoriteModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FavoriteImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see FavoriteImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class FavoriteModelImpl
	extends BaseModelImpl<Favorite> implements FavoriteModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a favorite model instance should use the <code>Favorite</code> interface instead.
	 */
	public static final String TABLE_NAME = "favorite_Favorite";

	public static final Object[][] TABLE_COLUMNS = {
		{"favoriteId", Types.BIGINT}, {"publikUserId", Types.VARCHAR},
		{"title", Types.VARCHAR}, {"url", Types.VARCHAR},
		{"typeId", Types.BIGINT}, {"entityId", Types.BIGINT},
		{"entityGroupId", Types.BIGINT}, {"onDashboardDate", Types.TIMESTAMP},
		{"order_", Types.INTEGER}, {"content", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("favoriteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("publikUserId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("url", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("typeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("entityId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("entityGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("onDashboardDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("order_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table favorite_Favorite (favoriteId LONG not null primary key,publikUserId VARCHAR(75) null,title VARCHAR(255) null,url VARCHAR(255) null,typeId LONG,entityId LONG,entityGroupId LONG,onDashboardDate DATE null,order_ INTEGER,content VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table favorite_Favorite";

	public static final String ORDER_BY_JPQL =
		" ORDER BY favorite.favoriteId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY favorite_Favorite.favoriteId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.favorite.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.favorite.model.Favorite"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.favorite.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.favorite.model.Favorite"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.favorite.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.favorite.model.Favorite"),
		true);

	public static final long ENTITYID_COLUMN_BITMASK = 1L;

	public static final long PUBLIKUSERID_COLUMN_BITMASK = 2L;

	public static final long TITLE_COLUMN_BITMASK = 4L;

	public static final long TYPEID_COLUMN_BITMASK = 8L;

	public static final long FAVORITEID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Favorite toModel(FavoriteSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Favorite model = new FavoriteImpl();

		model.setFavoriteId(soapModel.getFavoriteId());
		model.setPublikUserId(soapModel.getPublikUserId());
		model.setTitle(soapModel.getTitle());
		model.setUrl(soapModel.getUrl());
		model.setTypeId(soapModel.getTypeId());
		model.setEntityId(soapModel.getEntityId());
		model.setEntityGroupId(soapModel.getEntityGroupId());
		model.setOnDashboardDate(soapModel.getOnDashboardDate());
		model.setOrder(soapModel.getOrder());
		model.setContent(soapModel.getContent());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Favorite> toModels(FavoriteSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Favorite> models = new ArrayList<Favorite>(soapModels.length);

		for (FavoriteSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.favorite.service.util.ServiceProps.get(
			"lock.expiration.time.eu.strasbourg.service.favorite.model.Favorite"));

	public FavoriteModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _favoriteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFavoriteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _favoriteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Favorite.class;
	}

	@Override
	public String getModelClassName() {
		return Favorite.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Favorite, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Favorite, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Favorite, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Favorite)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Favorite, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Favorite, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Favorite)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Favorite, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Favorite, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Favorite>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Favorite.class.getClassLoader(), Favorite.class,
			ModelWrapper.class);

		try {
			Constructor<Favorite> constructor =
				(Constructor<Favorite>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Favorite, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Favorite, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Favorite, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Favorite, Object>>();
		Map<String, BiConsumer<Favorite, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Favorite, ?>>();

		attributeGetterFunctions.put(
			"favoriteId",
			new Function<Favorite, Object>() {

				@Override
				public Object apply(Favorite favorite) {
					return favorite.getFavoriteId();
				}

			});
		attributeSetterBiConsumers.put(
			"favoriteId",
			new BiConsumer<Favorite, Object>() {

				@Override
				public void accept(Favorite favorite, Object favoriteId) {
					favorite.setFavoriteId((Long)favoriteId);
				}

			});
		attributeGetterFunctions.put(
			"publikUserId",
			new Function<Favorite, Object>() {

				@Override
				public Object apply(Favorite favorite) {
					return favorite.getPublikUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"publikUserId",
			new BiConsumer<Favorite, Object>() {

				@Override
				public void accept(Favorite favorite, Object publikUserId) {
					favorite.setPublikUserId((String)publikUserId);
				}

			});
		attributeGetterFunctions.put(
			"title",
			new Function<Favorite, Object>() {

				@Override
				public Object apply(Favorite favorite) {
					return favorite.getTitle();
				}

			});
		attributeSetterBiConsumers.put(
			"title",
			new BiConsumer<Favorite, Object>() {

				@Override
				public void accept(Favorite favorite, Object title) {
					favorite.setTitle((String)title);
				}

			});
		attributeGetterFunctions.put(
			"url",
			new Function<Favorite, Object>() {

				@Override
				public Object apply(Favorite favorite) {
					return favorite.getUrl();
				}

			});
		attributeSetterBiConsumers.put(
			"url",
			new BiConsumer<Favorite, Object>() {

				@Override
				public void accept(Favorite favorite, Object url) {
					favorite.setUrl((String)url);
				}

			});
		attributeGetterFunctions.put(
			"typeId",
			new Function<Favorite, Object>() {

				@Override
				public Object apply(Favorite favorite) {
					return favorite.getTypeId();
				}

			});
		attributeSetterBiConsumers.put(
			"typeId",
			new BiConsumer<Favorite, Object>() {

				@Override
				public void accept(Favorite favorite, Object typeId) {
					favorite.setTypeId((Long)typeId);
				}

			});
		attributeGetterFunctions.put(
			"entityId",
			new Function<Favorite, Object>() {

				@Override
				public Object apply(Favorite favorite) {
					return favorite.getEntityId();
				}

			});
		attributeSetterBiConsumers.put(
			"entityId",
			new BiConsumer<Favorite, Object>() {

				@Override
				public void accept(Favorite favorite, Object entityId) {
					favorite.setEntityId((Long)entityId);
				}

			});
		attributeGetterFunctions.put(
			"entityGroupId",
			new Function<Favorite, Object>() {

				@Override
				public Object apply(Favorite favorite) {
					return favorite.getEntityGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"entityGroupId",
			new BiConsumer<Favorite, Object>() {

				@Override
				public void accept(Favorite favorite, Object entityGroupId) {
					favorite.setEntityGroupId((Long)entityGroupId);
				}

			});
		attributeGetterFunctions.put(
			"onDashboardDate",
			new Function<Favorite, Object>() {

				@Override
				public Object apply(Favorite favorite) {
					return favorite.getOnDashboardDate();
				}

			});
		attributeSetterBiConsumers.put(
			"onDashboardDate",
			new BiConsumer<Favorite, Object>() {

				@Override
				public void accept(Favorite favorite, Object onDashboardDate) {
					favorite.setOnDashboardDate((Date)onDashboardDate);
				}

			});
		attributeGetterFunctions.put(
			"order",
			new Function<Favorite, Object>() {

				@Override
				public Object apply(Favorite favorite) {
					return favorite.getOrder();
				}

			});
		attributeSetterBiConsumers.put(
			"order",
			new BiConsumer<Favorite, Object>() {

				@Override
				public void accept(Favorite favorite, Object order) {
					favorite.setOrder((Integer)order);
				}

			});
		attributeGetterFunctions.put(
			"content",
			new Function<Favorite, Object>() {

				@Override
				public Object apply(Favorite favorite) {
					return favorite.getContent();
				}

			});
		attributeSetterBiConsumers.put(
			"content",
			new BiConsumer<Favorite, Object>() {

				@Override
				public void accept(Favorite favorite, Object content) {
					favorite.setContent((String)content);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<Favorite, Object>() {

				@Override
				public Object apply(Favorite favorite) {
					return favorite.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<Favorite, Object>() {

				@Override
				public void accept(Favorite favorite, Object createDate) {
					favorite.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<Favorite, Object>() {

				@Override
				public Object apply(Favorite favorite) {
					return favorite.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<Favorite, Object>() {

				@Override
				public void accept(Favorite favorite, Object modifiedDate) {
					favorite.setModifiedDate((Date)modifiedDate);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getFavoriteId() {
		return _favoriteId;
	}

	@Override
	public void setFavoriteId(long favoriteId) {
		_favoriteId = favoriteId;
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
		_columnBitmask |= PUBLIKUSERID_COLUMN_BITMASK;

		if (_originalPublikUserId == null) {
			_originalPublikUserId = _publikUserId;
		}

		_publikUserId = publikUserId;
	}

	public String getOriginalPublikUserId() {
		return GetterUtil.getString(_originalPublikUserId);
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
		_columnBitmask |= TITLE_COLUMN_BITMASK;

		if (_originalTitle == null) {
			_originalTitle = _title;
		}

		_title = title;
	}

	public String getOriginalTitle() {
		return GetterUtil.getString(_originalTitle);
	}

	@JSON
	@Override
	public String getUrl() {
		if (_url == null) {
			return "";
		}
		else {
			return _url;
		}
	}

	@Override
	public void setUrl(String url) {
		_url = url;
	}

	@JSON
	@Override
	public long getTypeId() {
		return _typeId;
	}

	@Override
	public void setTypeId(long typeId) {
		_columnBitmask |= TYPEID_COLUMN_BITMASK;

		if (!_setOriginalTypeId) {
			_setOriginalTypeId = true;

			_originalTypeId = _typeId;
		}

		_typeId = typeId;
	}

	public long getOriginalTypeId() {
		return _originalTypeId;
	}

	@JSON
	@Override
	public long getEntityId() {
		return _entityId;
	}

	@Override
	public void setEntityId(long entityId) {
		_columnBitmask |= ENTITYID_COLUMN_BITMASK;

		if (!_setOriginalEntityId) {
			_setOriginalEntityId = true;

			_originalEntityId = _entityId;
		}

		_entityId = entityId;
	}

	public long getOriginalEntityId() {
		return _originalEntityId;
	}

	@JSON
	@Override
	public long getEntityGroupId() {
		return _entityGroupId;
	}

	@Override
	public void setEntityGroupId(long entityGroupId) {
		_entityGroupId = entityGroupId;
	}

	@JSON
	@Override
	public Date getOnDashboardDate() {
		return _onDashboardDate;
	}

	@Override
	public void setOnDashboardDate(Date onDashboardDate) {
		_onDashboardDate = onDashboardDate;
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
	public String getContent() {
		if (_content == null) {
			return "";
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Favorite.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Favorite toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FavoriteImpl favoriteImpl = new FavoriteImpl();

		favoriteImpl.setFavoriteId(getFavoriteId());
		favoriteImpl.setPublikUserId(getPublikUserId());
		favoriteImpl.setTitle(getTitle());
		favoriteImpl.setUrl(getUrl());
		favoriteImpl.setTypeId(getTypeId());
		favoriteImpl.setEntityId(getEntityId());
		favoriteImpl.setEntityGroupId(getEntityGroupId());
		favoriteImpl.setOnDashboardDate(getOnDashboardDate());
		favoriteImpl.setOrder(getOrder());
		favoriteImpl.setContent(getContent());
		favoriteImpl.setCreateDate(getCreateDate());
		favoriteImpl.setModifiedDate(getModifiedDate());

		favoriteImpl.resetOriginalValues();

		return favoriteImpl;
	}

	@Override
	public int compareTo(Favorite favorite) {
		long primaryKey = favorite.getPrimaryKey();

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

		if (!(obj instanceof Favorite)) {
			return false;
		}

		Favorite favorite = (Favorite)obj;

		long primaryKey = favorite.getPrimaryKey();

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
		FavoriteModelImpl favoriteModelImpl = this;

		favoriteModelImpl._originalPublikUserId =
			favoriteModelImpl._publikUserId;

		favoriteModelImpl._originalTitle = favoriteModelImpl._title;

		favoriteModelImpl._originalTypeId = favoriteModelImpl._typeId;

		favoriteModelImpl._setOriginalTypeId = false;

		favoriteModelImpl._originalEntityId = favoriteModelImpl._entityId;

		favoriteModelImpl._setOriginalEntityId = false;

		favoriteModelImpl._setModifiedDate = false;

		favoriteModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Favorite> toCacheModel() {
		FavoriteCacheModel favoriteCacheModel = new FavoriteCacheModel();

		favoriteCacheModel.favoriteId = getFavoriteId();

		favoriteCacheModel.publikUserId = getPublikUserId();

		String publikUserId = favoriteCacheModel.publikUserId;

		if ((publikUserId != null) && (publikUserId.length() == 0)) {
			favoriteCacheModel.publikUserId = null;
		}

		favoriteCacheModel.title = getTitle();

		String title = favoriteCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			favoriteCacheModel.title = null;
		}

		favoriteCacheModel.url = getUrl();

		String url = favoriteCacheModel.url;

		if ((url != null) && (url.length() == 0)) {
			favoriteCacheModel.url = null;
		}

		favoriteCacheModel.typeId = getTypeId();

		favoriteCacheModel.entityId = getEntityId();

		favoriteCacheModel.entityGroupId = getEntityGroupId();

		Date onDashboardDate = getOnDashboardDate();

		if (onDashboardDate != null) {
			favoriteCacheModel.onDashboardDate = onDashboardDate.getTime();
		}
		else {
			favoriteCacheModel.onDashboardDate = Long.MIN_VALUE;
		}

		favoriteCacheModel.order = getOrder();

		favoriteCacheModel.content = getContent();

		String content = favoriteCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			favoriteCacheModel.content = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			favoriteCacheModel.createDate = createDate.getTime();
		}
		else {
			favoriteCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			favoriteCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			favoriteCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return favoriteCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Favorite, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Favorite, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Favorite, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Favorite)this));
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
		Map<String, Function<Favorite, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Favorite, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Favorite, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Favorite)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Favorite>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _favoriteId;
	private String _publikUserId;
	private String _originalPublikUserId;
	private String _title;
	private String _originalTitle;
	private String _url;
	private long _typeId;
	private long _originalTypeId;
	private boolean _setOriginalTypeId;
	private long _entityId;
	private long _originalEntityId;
	private boolean _setOriginalEntityId;
	private long _entityGroupId;
	private Date _onDashboardDate;
	private int _order;
	private String _content;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _columnBitmask;
	private Favorite _escapedModel;

}