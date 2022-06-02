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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.place.model.CsmapCacheJson;
import eu.strasbourg.service.place.model.CsmapCacheJsonModel;

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
 * The base model implementation for the CsmapCacheJson service. Represents a row in the &quot;place_CsmapCacheJson&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CsmapCacheJsonModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CsmapCacheJsonImpl}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see CsmapCacheJsonImpl
 * @generated
 */
public class CsmapCacheJsonModelImpl
	extends BaseModelImpl<CsmapCacheJson> implements CsmapCacheJsonModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a csmap cache json model instance should use the <code>CsmapCacheJson</code> interface instead.
	 */
	public static final String TABLE_NAME = "place_CsmapCacheJson";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"sigId", Types.VARCHAR},
		{"jsonLieu", Types.CLOB}, {"jsonHoraire", Types.CLOB},
		{"createPlace", Types.TIMESTAMP}, {"modifiedPlace", Types.TIMESTAMP},
		{"isActive", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sigId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("jsonLieu", Types.CLOB);
		TABLE_COLUMNS_MAP.put("jsonHoraire", Types.CLOB);
		TABLE_COLUMNS_MAP.put("createPlace", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedPlace", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("isActive", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table place_CsmapCacheJson (uuid_ VARCHAR(75) null,sigId VARCHAR(75) not null primary key,jsonLieu TEXT null,jsonHoraire TEXT null,createPlace DATE null,modifiedPlace DATE null,isActive BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table place_CsmapCacheJson";

	public static final String ORDER_BY_JPQL =
		" ORDER BY csmapCacheJson.sigId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY place_CsmapCacheJson.sigId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.place.model.CsmapCacheJson"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.place.model.CsmapCacheJson"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.place.model.CsmapCacheJson"),
		true);

	public static final long CREATEPLACE_COLUMN_BITMASK = 1L;

	public static final long ISACTIVE_COLUMN_BITMASK = 2L;

	public static final long MODIFIEDPLACE_COLUMN_BITMASK = 4L;

	public static final long SIGID_COLUMN_BITMASK = 8L;

	public static final long UUID_COLUMN_BITMASK = 16L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.place.model.CsmapCacheJson"));

	public CsmapCacheJsonModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _sigId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setSigId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sigId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return CsmapCacheJson.class;
	}

	@Override
	public String getModelClassName() {
		return CsmapCacheJson.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CsmapCacheJson, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CsmapCacheJson, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsmapCacheJson, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CsmapCacheJson)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CsmapCacheJson, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CsmapCacheJson, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CsmapCacheJson)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CsmapCacheJson, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CsmapCacheJson, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CsmapCacheJson>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CsmapCacheJson.class.getClassLoader(), CsmapCacheJson.class,
			ModelWrapper.class);

		try {
			Constructor<CsmapCacheJson> constructor =
				(Constructor<CsmapCacheJson>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CsmapCacheJson, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CsmapCacheJson, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CsmapCacheJson, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CsmapCacheJson, Object>>();
		Map<String, BiConsumer<CsmapCacheJson, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CsmapCacheJson, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<CsmapCacheJson, Object>() {

				@Override
				public Object apply(CsmapCacheJson csmapCacheJson) {
					return csmapCacheJson.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<CsmapCacheJson, Object>() {

				@Override
				public void accept(
					CsmapCacheJson csmapCacheJson, Object uuidObject) {

					csmapCacheJson.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"sigId",
			new Function<CsmapCacheJson, Object>() {

				@Override
				public Object apply(CsmapCacheJson csmapCacheJson) {
					return csmapCacheJson.getSigId();
				}

			});
		attributeSetterBiConsumers.put(
			"sigId",
			new BiConsumer<CsmapCacheJson, Object>() {

				@Override
				public void accept(
					CsmapCacheJson csmapCacheJson, Object sigIdObject) {

					csmapCacheJson.setSigId((String)sigIdObject);
				}

			});
		attributeGetterFunctions.put(
			"jsonLieu",
			new Function<CsmapCacheJson, Object>() {

				@Override
				public Object apply(CsmapCacheJson csmapCacheJson) {
					return csmapCacheJson.getJsonLieu();
				}

			});
		attributeSetterBiConsumers.put(
			"jsonLieu",
			new BiConsumer<CsmapCacheJson, Object>() {

				@Override
				public void accept(
					CsmapCacheJson csmapCacheJson, Object jsonLieuObject) {

					csmapCacheJson.setJsonLieu((String)jsonLieuObject);
				}

			});
		attributeGetterFunctions.put(
			"jsonHoraire",
			new Function<CsmapCacheJson, Object>() {

				@Override
				public Object apply(CsmapCacheJson csmapCacheJson) {
					return csmapCacheJson.getJsonHoraire();
				}

			});
		attributeSetterBiConsumers.put(
			"jsonHoraire",
			new BiConsumer<CsmapCacheJson, Object>() {

				@Override
				public void accept(
					CsmapCacheJson csmapCacheJson, Object jsonHoraireObject) {

					csmapCacheJson.setJsonHoraire((String)jsonHoraireObject);
				}

			});
		attributeGetterFunctions.put(
			"createPlace",
			new Function<CsmapCacheJson, Object>() {

				@Override
				public Object apply(CsmapCacheJson csmapCacheJson) {
					return csmapCacheJson.getCreatePlace();
				}

			});
		attributeSetterBiConsumers.put(
			"createPlace",
			new BiConsumer<CsmapCacheJson, Object>() {

				@Override
				public void accept(
					CsmapCacheJson csmapCacheJson, Object createPlaceObject) {

					csmapCacheJson.setCreatePlace((Date)createPlaceObject);
				}

			});
		attributeGetterFunctions.put(
			"modifiedPlace",
			new Function<CsmapCacheJson, Object>() {

				@Override
				public Object apply(CsmapCacheJson csmapCacheJson) {
					return csmapCacheJson.getModifiedPlace();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedPlace",
			new BiConsumer<CsmapCacheJson, Object>() {

				@Override
				public void accept(
					CsmapCacheJson csmapCacheJson, Object modifiedPlaceObject) {

					csmapCacheJson.setModifiedPlace((Date)modifiedPlaceObject);
				}

			});
		attributeGetterFunctions.put(
			"isActive",
			new Function<CsmapCacheJson, Object>() {

				@Override
				public Object apply(CsmapCacheJson csmapCacheJson) {
					return csmapCacheJson.getIsActive();
				}

			});
		attributeSetterBiConsumers.put(
			"isActive",
			new BiConsumer<CsmapCacheJson, Object>() {

				@Override
				public void accept(
					CsmapCacheJson csmapCacheJson, Object isActiveObject) {

					csmapCacheJson.setIsActive((Boolean)isActiveObject);
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
	public String getSigId() {
		if (_sigId == null) {
			return "";
		}
		else {
			return _sigId;
		}
	}

	@Override
	public void setSigId(String sigId) {
		_columnBitmask |= SIGID_COLUMN_BITMASK;

		if (_originalSigId == null) {
			_originalSigId = _sigId;
		}

		_sigId = sigId;
	}

	public String getOriginalSigId() {
		return GetterUtil.getString(_originalSigId);
	}

	@Override
	public String getJsonLieu() {
		if (_jsonLieu == null) {
			return "";
		}
		else {
			return _jsonLieu;
		}
	}

	@Override
	public void setJsonLieu(String jsonLieu) {
		_jsonLieu = jsonLieu;
	}

	@Override
	public String getJsonHoraire() {
		if (_jsonHoraire == null) {
			return "";
		}
		else {
			return _jsonHoraire;
		}
	}

	@Override
	public void setJsonHoraire(String jsonHoraire) {
		_jsonHoraire = jsonHoraire;
	}

	@Override
	public Date getCreatePlace() {
		return _createPlace;
	}

	@Override
	public void setCreatePlace(Date createPlace) {
		_columnBitmask |= CREATEPLACE_COLUMN_BITMASK;

		if (_originalCreatePlace == null) {
			_originalCreatePlace = _createPlace;
		}

		_createPlace = createPlace;
	}

	public Date getOriginalCreatePlace() {
		return _originalCreatePlace;
	}

	@Override
	public Date getModifiedPlace() {
		return _modifiedPlace;
	}

	@Override
	public void setModifiedPlace(Date modifiedPlace) {
		_columnBitmask |= MODIFIEDPLACE_COLUMN_BITMASK;

		if (_originalModifiedPlace == null) {
			_originalModifiedPlace = _modifiedPlace;
		}

		_modifiedPlace = modifiedPlace;
	}

	public Date getOriginalModifiedPlace() {
		return _originalModifiedPlace;
	}

	@Override
	public boolean getIsActive() {
		return _isActive;
	}

	@Override
	public boolean isIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {
		_columnBitmask |= ISACTIVE_COLUMN_BITMASK;

		if (!_setOriginalIsActive) {
			_setOriginalIsActive = true;

			_originalIsActive = _isActive;
		}

		_isActive = isActive;
	}

	public boolean getOriginalIsActive() {
		return _originalIsActive;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public CsmapCacheJson toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CsmapCacheJson>
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
		CsmapCacheJsonImpl csmapCacheJsonImpl = new CsmapCacheJsonImpl();

		csmapCacheJsonImpl.setUuid(getUuid());
		csmapCacheJsonImpl.setSigId(getSigId());
		csmapCacheJsonImpl.setJsonLieu(getJsonLieu());
		csmapCacheJsonImpl.setJsonHoraire(getJsonHoraire());
		csmapCacheJsonImpl.setCreatePlace(getCreatePlace());
		csmapCacheJsonImpl.setModifiedPlace(getModifiedPlace());
		csmapCacheJsonImpl.setIsActive(isIsActive());

		csmapCacheJsonImpl.resetOriginalValues();

		return csmapCacheJsonImpl;
	}

	@Override
	public int compareTo(CsmapCacheJson csmapCacheJson) {
		String primaryKey = csmapCacheJson.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CsmapCacheJson)) {
			return false;
		}

		CsmapCacheJson csmapCacheJson = (CsmapCacheJson)object;

		String primaryKey = csmapCacheJson.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
		CsmapCacheJsonModelImpl csmapCacheJsonModelImpl = this;

		csmapCacheJsonModelImpl._originalUuid = csmapCacheJsonModelImpl._uuid;

		csmapCacheJsonModelImpl._originalSigId = csmapCacheJsonModelImpl._sigId;

		csmapCacheJsonModelImpl._originalCreatePlace =
			csmapCacheJsonModelImpl._createPlace;

		csmapCacheJsonModelImpl._originalModifiedPlace =
			csmapCacheJsonModelImpl._modifiedPlace;

		csmapCacheJsonModelImpl._originalIsActive =
			csmapCacheJsonModelImpl._isActive;

		csmapCacheJsonModelImpl._setOriginalIsActive = false;

		csmapCacheJsonModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CsmapCacheJson> toCacheModel() {
		CsmapCacheJsonCacheModel csmapCacheJsonCacheModel =
			new CsmapCacheJsonCacheModel();

		csmapCacheJsonCacheModel.uuid = getUuid();

		String uuid = csmapCacheJsonCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			csmapCacheJsonCacheModel.uuid = null;
		}

		csmapCacheJsonCacheModel.sigId = getSigId();

		String sigId = csmapCacheJsonCacheModel.sigId;

		if ((sigId != null) && (sigId.length() == 0)) {
			csmapCacheJsonCacheModel.sigId = null;
		}

		csmapCacheJsonCacheModel.jsonLieu = getJsonLieu();

		String jsonLieu = csmapCacheJsonCacheModel.jsonLieu;

		if ((jsonLieu != null) && (jsonLieu.length() == 0)) {
			csmapCacheJsonCacheModel.jsonLieu = null;
		}

		csmapCacheJsonCacheModel.jsonHoraire = getJsonHoraire();

		String jsonHoraire = csmapCacheJsonCacheModel.jsonHoraire;

		if ((jsonHoraire != null) && (jsonHoraire.length() == 0)) {
			csmapCacheJsonCacheModel.jsonHoraire = null;
		}

		Date createPlace = getCreatePlace();

		if (createPlace != null) {
			csmapCacheJsonCacheModel.createPlace = createPlace.getTime();
		}
		else {
			csmapCacheJsonCacheModel.createPlace = Long.MIN_VALUE;
		}

		Date modifiedPlace = getModifiedPlace();

		if (modifiedPlace != null) {
			csmapCacheJsonCacheModel.modifiedPlace = modifiedPlace.getTime();
		}
		else {
			csmapCacheJsonCacheModel.modifiedPlace = Long.MIN_VALUE;
		}

		csmapCacheJsonCacheModel.isActive = isIsActive();

		return csmapCacheJsonCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CsmapCacheJson, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CsmapCacheJson, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsmapCacheJson, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CsmapCacheJson)this));
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
		Map<String, Function<CsmapCacheJson, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CsmapCacheJson, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsmapCacheJson, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CsmapCacheJson)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CsmapCacheJson>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private String _sigId;
	private String _originalSigId;
	private String _jsonLieu;
	private String _jsonHoraire;
	private Date _createPlace;
	private Date _originalCreatePlace;
	private Date _modifiedPlace;
	private Date _originalModifiedPlace;
	private boolean _isActive;
	private boolean _originalIsActive;
	private boolean _setOriginalIsActive;
	private long _columnBitmask;
	private CsmapCacheJson _escapedModel;

}