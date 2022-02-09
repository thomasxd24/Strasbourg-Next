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

package eu.strasbourg.service.gtfs.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.gtfs.model.Stop;
import eu.strasbourg.service.gtfs.model.StopModel;

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

/**
 * The base model implementation for the Stop service. Represents a row in the &quot;gtfs_Stop&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>StopModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StopImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see StopImpl
 * @generated
 */
@ProviderType
public class StopModelImpl extends BaseModelImpl<Stop> implements StopModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a stop model instance should use the <code>Stop</code> interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_Stop";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.BIGINT}, {"stop_id", Types.VARCHAR},
		{"stop_code", Types.VARCHAR}, {"stop_lat", Types.VARCHAR},
		{"stop_lon", Types.VARCHAR}, {"stop_name", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("stop_id", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("stop_code", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("stop_lat", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("stop_lon", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("stop_name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_Stop (id_ LONG not null primary key,stop_id VARCHAR(75) null,stop_code VARCHAR(75) null,stop_lat VARCHAR(75) null,stop_lon VARCHAR(75) null,stop_name VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table gtfs_Stop";

	public static final String ORDER_BY_JPQL = " ORDER BY stop.stop_id ASC";

	public static final String ORDER_BY_SQL = " ORDER BY gtfs_Stop.stop_id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.gtfs.model.Stop"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.gtfs.model.Stop"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.gtfs.model.Stop"),
		true);

	public static final long STOP_CODE_COLUMN_BITMASK = 1L;

	public static final long STOP_ID_COLUMN_BITMASK = 2L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.gtfs.model.Stop"));

	public StopModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Stop.class;
	}

	@Override
	public String getModelClassName() {
		return Stop.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Stop, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Stop, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Stop, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Stop)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Stop, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Stop, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Stop)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Stop, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Stop, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Stop>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Stop.class.getClassLoader(), Stop.class, ModelWrapper.class);

		try {
			Constructor<Stop> constructor =
				(Constructor<Stop>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Stop, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Stop, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Stop, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Stop, Object>>();
		Map<String, BiConsumer<Stop, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Stop, ?>>();

		attributeGetterFunctions.put(
			"id",
			new Function<Stop, Object>() {

				@Override
				public Object apply(Stop stop) {
					return stop.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<Stop, Object>() {

				@Override
				public void accept(Stop stop, Object id) {
					stop.setId((Long)id);
				}

			});
		attributeGetterFunctions.put(
			"stop_id",
			new Function<Stop, Object>() {

				@Override
				public Object apply(Stop stop) {
					return stop.getStop_id();
				}

			});
		attributeSetterBiConsumers.put(
			"stop_id",
			new BiConsumer<Stop, Object>() {

				@Override
				public void accept(Stop stop, Object stop_id) {
					stop.setStop_id((String)stop_id);
				}

			});
		attributeGetterFunctions.put(
			"stop_code",
			new Function<Stop, Object>() {

				@Override
				public Object apply(Stop stop) {
					return stop.getStop_code();
				}

			});
		attributeSetterBiConsumers.put(
			"stop_code",
			new BiConsumer<Stop, Object>() {

				@Override
				public void accept(Stop stop, Object stop_code) {
					stop.setStop_code((String)stop_code);
				}

			});
		attributeGetterFunctions.put(
			"stop_lat",
			new Function<Stop, Object>() {

				@Override
				public Object apply(Stop stop) {
					return stop.getStop_lat();
				}

			});
		attributeSetterBiConsumers.put(
			"stop_lat",
			new BiConsumer<Stop, Object>() {

				@Override
				public void accept(Stop stop, Object stop_lat) {
					stop.setStop_lat((String)stop_lat);
				}

			});
		attributeGetterFunctions.put(
			"stop_lon",
			new Function<Stop, Object>() {

				@Override
				public Object apply(Stop stop) {
					return stop.getStop_lon();
				}

			});
		attributeSetterBiConsumers.put(
			"stop_lon",
			new BiConsumer<Stop, Object>() {

				@Override
				public void accept(Stop stop, Object stop_lon) {
					stop.setStop_lon((String)stop_lon);
				}

			});
		attributeGetterFunctions.put(
			"stop_name",
			new Function<Stop, Object>() {

				@Override
				public Object apply(Stop stop) {
					return stop.getStop_name();
				}

			});
		attributeSetterBiConsumers.put(
			"stop_name",
			new BiConsumer<Stop, Object>() {

				@Override
				public void accept(Stop stop, Object stop_name) {
					stop.setStop_name((String)stop_name);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public String getStop_id() {
		if (_stop_id == null) {
			return "";
		}
		else {
			return _stop_id;
		}
	}

	@Override
	public void setStop_id(String stop_id) {
		_columnBitmask = -1L;

		if (_originalStop_id == null) {
			_originalStop_id = _stop_id;
		}

		_stop_id = stop_id;
	}

	public String getOriginalStop_id() {
		return GetterUtil.getString(_originalStop_id);
	}

	@Override
	public String getStop_code() {
		if (_stop_code == null) {
			return "";
		}
		else {
			return _stop_code;
		}
	}

	@Override
	public void setStop_code(String stop_code) {
		_columnBitmask |= STOP_CODE_COLUMN_BITMASK;

		if (_originalStop_code == null) {
			_originalStop_code = _stop_code;
		}

		_stop_code = stop_code;
	}

	public String getOriginalStop_code() {
		return GetterUtil.getString(_originalStop_code);
	}

	@Override
	public String getStop_lat() {
		if (_stop_lat == null) {
			return "";
		}
		else {
			return _stop_lat;
		}
	}

	@Override
	public void setStop_lat(String stop_lat) {
		_stop_lat = stop_lat;
	}

	@Override
	public String getStop_lon() {
		if (_stop_lon == null) {
			return "";
		}
		else {
			return _stop_lon;
		}
	}

	@Override
	public void setStop_lon(String stop_lon) {
		_stop_lon = stop_lon;
	}

	@Override
	public String getStop_name() {
		if (_stop_name == null) {
			return "";
		}
		else {
			return _stop_name;
		}
	}

	@Override
	public void setStop_name(String stop_name) {
		_stop_name = stop_name;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Stop.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Stop toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StopImpl stopImpl = new StopImpl();

		stopImpl.setId(getId());
		stopImpl.setStop_id(getStop_id());
		stopImpl.setStop_code(getStop_code());
		stopImpl.setStop_lat(getStop_lat());
		stopImpl.setStop_lon(getStop_lon());
		stopImpl.setStop_name(getStop_name());

		stopImpl.resetOriginalValues();

		return stopImpl;
	}

	@Override
	public int compareTo(Stop stop) {
		int value = 0;

		value = getStop_id().compareTo(stop.getStop_id());

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

		if (!(obj instanceof Stop)) {
			return false;
		}

		Stop stop = (Stop)obj;

		long primaryKey = stop.getPrimaryKey();

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
		StopModelImpl stopModelImpl = this;

		stopModelImpl._originalStop_id = stopModelImpl._stop_id;

		stopModelImpl._originalStop_code = stopModelImpl._stop_code;

		stopModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Stop> toCacheModel() {
		StopCacheModel stopCacheModel = new StopCacheModel();

		stopCacheModel.id = getId();

		stopCacheModel.stop_id = getStop_id();

		String stop_id = stopCacheModel.stop_id;

		if ((stop_id != null) && (stop_id.length() == 0)) {
			stopCacheModel.stop_id = null;
		}

		stopCacheModel.stop_code = getStop_code();

		String stop_code = stopCacheModel.stop_code;

		if ((stop_code != null) && (stop_code.length() == 0)) {
			stopCacheModel.stop_code = null;
		}

		stopCacheModel.stop_lat = getStop_lat();

		String stop_lat = stopCacheModel.stop_lat;

		if ((stop_lat != null) && (stop_lat.length() == 0)) {
			stopCacheModel.stop_lat = null;
		}

		stopCacheModel.stop_lon = getStop_lon();

		String stop_lon = stopCacheModel.stop_lon;

		if ((stop_lon != null) && (stop_lon.length() == 0)) {
			stopCacheModel.stop_lon = null;
		}

		stopCacheModel.stop_name = getStop_name();

		String stop_name = stopCacheModel.stop_name;

		if ((stop_name != null) && (stop_name.length() == 0)) {
			stopCacheModel.stop_name = null;
		}

		return stopCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Stop, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Stop, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Stop, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Stop)this));
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
		Map<String, Function<Stop, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Stop, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Stop, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Stop)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Stop>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _id;
	private String _stop_id;
	private String _originalStop_id;
	private String _stop_code;
	private String _originalStop_code;
	private String _stop_lat;
	private String _stop_lon;
	private String _stop_name;
	private long _columnBitmask;
	private Stop _escapedModel;

}