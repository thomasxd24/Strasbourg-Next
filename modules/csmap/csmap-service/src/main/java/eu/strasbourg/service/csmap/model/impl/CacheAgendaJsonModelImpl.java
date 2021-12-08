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

package eu.strasbourg.service.csmap.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import eu.strasbourg.service.csmap.model.CacheAgendaJson;
import eu.strasbourg.service.csmap.model.CacheAgendaJsonModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the CacheAgendaJson service. Represents a row in the &quot;csmap_CacheAgendaJson&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CacheAgendaJsonModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CacheAgendaJsonImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CacheAgendaJsonImpl
 * @generated
 */
@ProviderType
public class CacheAgendaJsonModelImpl
	extends BaseModelImpl<CacheAgendaJson> implements CacheAgendaJsonModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cache agenda json model instance should use the <code>CacheAgendaJson</code> interface instead.
	 */
	public static final String TABLE_NAME = "csmap_CacheAgendaJson";

	public static final Object[][] TABLE_COLUMNS = {
		{"cacheId", Types.BIGINT}, {"json", Types.CLOB}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("cacheId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("json", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE =
		"create table csmap_CacheAgendaJson (cacheId LONG not null primary key,json TEXT null)";

	public static final String TABLE_SQL_DROP =
		"drop table csmap_CacheAgendaJson";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cacheAgendaJson.cacheId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY csmap_CacheAgendaJson.cacheId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public CacheAgendaJsonModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cacheId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCacheId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cacheId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CacheAgendaJson.class;
	}

	@Override
	public String getModelClassName() {
		return CacheAgendaJson.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CacheAgendaJson, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CacheAgendaJson, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CacheAgendaJson, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CacheAgendaJson)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CacheAgendaJson, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CacheAgendaJson, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CacheAgendaJson)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CacheAgendaJson, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CacheAgendaJson, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CacheAgendaJson>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CacheAgendaJson.class.getClassLoader(), CacheAgendaJson.class,
			ModelWrapper.class);

		try {
			Constructor<CacheAgendaJson> constructor =
				(Constructor<CacheAgendaJson>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CacheAgendaJson, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CacheAgendaJson, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CacheAgendaJson, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<CacheAgendaJson, Object>>();
		Map<String, BiConsumer<CacheAgendaJson, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CacheAgendaJson, ?>>();

		attributeGetterFunctions.put("cacheId", CacheAgendaJson::getCacheId);
		attributeSetterBiConsumers.put(
			"cacheId",
			(BiConsumer<CacheAgendaJson, Long>)CacheAgendaJson::setCacheId);
		attributeGetterFunctions.put("json", CacheAgendaJson::getJson);
		attributeSetterBiConsumers.put(
			"json",
			(BiConsumer<CacheAgendaJson, String>)CacheAgendaJson::setJson);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getCacheId() {
		return _cacheId;
	}

	@Override
	public void setCacheId(long cacheId) {
		_cacheId = cacheId;
	}

	@Override
	public String getJson() {
		if (_json == null) {
			return "";
		}
		else {
			return _json;
		}
	}

	@Override
	public void setJson(String json) {
		_json = json;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CacheAgendaJson.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CacheAgendaJson toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CacheAgendaJsonImpl cacheAgendaJsonImpl = new CacheAgendaJsonImpl();

		cacheAgendaJsonImpl.setCacheId(getCacheId());
		cacheAgendaJsonImpl.setJson(getJson());

		cacheAgendaJsonImpl.resetOriginalValues();

		return cacheAgendaJsonImpl;
	}

	@Override
	public int compareTo(CacheAgendaJson cacheAgendaJson) {
		long primaryKey = cacheAgendaJson.getPrimaryKey();

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

		if (!(obj instanceof CacheAgendaJson)) {
			return false;
		}

		CacheAgendaJson cacheAgendaJson = (CacheAgendaJson)obj;

		long primaryKey = cacheAgendaJson.getPrimaryKey();

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
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<CacheAgendaJson> toCacheModel() {
		CacheAgendaJsonCacheModel cacheAgendaJsonCacheModel =
			new CacheAgendaJsonCacheModel();

		cacheAgendaJsonCacheModel.cacheId = getCacheId();

		cacheAgendaJsonCacheModel.json = getJson();

		String json = cacheAgendaJsonCacheModel.json;

		if ((json != null) && (json.length() == 0)) {
			cacheAgendaJsonCacheModel.json = null;
		}

		return cacheAgendaJsonCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CacheAgendaJson, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CacheAgendaJson, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CacheAgendaJson, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CacheAgendaJson)this));
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
		Map<String, Function<CacheAgendaJson, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CacheAgendaJson, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CacheAgendaJson, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CacheAgendaJson)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, CacheAgendaJson>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _cacheId;
	private String _json;
	private CacheAgendaJson _escapedModel;

}