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

import eu.strasbourg.service.gtfs.model.CalendarDate;
import eu.strasbourg.service.gtfs.model.CalendarDateModel;

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
 * The base model implementation for the CalendarDate service. Represents a row in the &quot;gtfs_CalendarDate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CalendarDateModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CalendarDateImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see CalendarDateImpl
 * @generated
 */
@ProviderType
public class CalendarDateModelImpl
	extends BaseModelImpl<CalendarDate> implements CalendarDateModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a calendar date model instance should use the <code>CalendarDate</code> interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_CalendarDate";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"id_", Types.BIGINT},
		{"service_id", Types.VARCHAR}, {"date_", Types.TIMESTAMP},
		{"exception_type", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("service_id", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("date_", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("exception_type", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_CalendarDate (uuid_ VARCHAR(75) null,id_ LONG not null primary key,service_id VARCHAR(75) null,date_ DATE null,exception_type INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table gtfs_CalendarDate";

	public static final String ORDER_BY_JPQL =
		" ORDER BY calendarDate.service_id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY gtfs_CalendarDate.service_id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.gtfs.model.CalendarDate"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.gtfs.model.CalendarDate"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.gtfs.model.CalendarDate"),
		true);

	public static final long DATE_COLUMN_BITMASK = 1L;

	public static final long SERVICE_ID_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.gtfs.model.CalendarDate"));

	public CalendarDateModelImpl() {
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
		return CalendarDate.class;
	}

	@Override
	public String getModelClassName() {
		return CalendarDate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CalendarDate, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CalendarDate, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CalendarDate, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CalendarDate)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CalendarDate, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CalendarDate, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CalendarDate)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CalendarDate, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CalendarDate, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CalendarDate>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CalendarDate.class.getClassLoader(), CalendarDate.class,
			ModelWrapper.class);

		try {
			Constructor<CalendarDate> constructor =
				(Constructor<CalendarDate>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CalendarDate, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CalendarDate, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CalendarDate, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CalendarDate, Object>>();
		Map<String, BiConsumer<CalendarDate, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CalendarDate, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<CalendarDate, Object>() {

				@Override
				public Object apply(CalendarDate calendarDate) {
					return calendarDate.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<CalendarDate, Object>() {

				@Override
				public void accept(CalendarDate calendarDate, Object uuid) {
					calendarDate.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"id",
			new Function<CalendarDate, Object>() {

				@Override
				public Object apply(CalendarDate calendarDate) {
					return calendarDate.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<CalendarDate, Object>() {

				@Override
				public void accept(CalendarDate calendarDate, Object id) {
					calendarDate.setId((Long)id);
				}

			});
		attributeGetterFunctions.put(
			"service_id",
			new Function<CalendarDate, Object>() {

				@Override
				public Object apply(CalendarDate calendarDate) {
					return calendarDate.getService_id();
				}

			});
		attributeSetterBiConsumers.put(
			"service_id",
			new BiConsumer<CalendarDate, Object>() {

				@Override
				public void accept(
					CalendarDate calendarDate, Object service_id) {

					calendarDate.setService_id((String)service_id);
				}

			});
		attributeGetterFunctions.put(
			"date",
			new Function<CalendarDate, Object>() {

				@Override
				public Object apply(CalendarDate calendarDate) {
					return calendarDate.getDate();
				}

			});
		attributeSetterBiConsumers.put(
			"date",
			new BiConsumer<CalendarDate, Object>() {

				@Override
				public void accept(CalendarDate calendarDate, Object date) {
					calendarDate.setDate((Date)date);
				}

			});
		attributeGetterFunctions.put(
			"exception_type",
			new Function<CalendarDate, Object>() {

				@Override
				public Object apply(CalendarDate calendarDate) {
					return calendarDate.getException_type();
				}

			});
		attributeSetterBiConsumers.put(
			"exception_type",
			new BiConsumer<CalendarDate, Object>() {

				@Override
				public void accept(
					CalendarDate calendarDate, Object exception_type) {

					calendarDate.setException_type((Integer)exception_type);
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
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public String getService_id() {
		if (_service_id == null) {
			return "";
		}
		else {
			return _service_id;
		}
	}

	@Override
	public void setService_id(String service_id) {
		_columnBitmask = -1L;

		if (_originalService_id == null) {
			_originalService_id = _service_id;
		}

		_service_id = service_id;
	}

	public String getOriginalService_id() {
		return GetterUtil.getString(_originalService_id);
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_columnBitmask |= DATE_COLUMN_BITMASK;

		if (_originalDate == null) {
			_originalDate = _date;
		}

		_date = date;
	}

	public Date getOriginalDate() {
		return _originalDate;
	}

	@Override
	public int getException_type() {
		return _exception_type;
	}

	@Override
	public void setException_type(int exception_type) {
		_exception_type = exception_type;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CalendarDate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CalendarDate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CalendarDateImpl calendarDateImpl = new CalendarDateImpl();

		calendarDateImpl.setUuid(getUuid());
		calendarDateImpl.setId(getId());
		calendarDateImpl.setService_id(getService_id());
		calendarDateImpl.setDate(getDate());
		calendarDateImpl.setException_type(getException_type());

		calendarDateImpl.resetOriginalValues();

		return calendarDateImpl;
	}

	@Override
	public int compareTo(CalendarDate calendarDate) {
		int value = 0;

		value = getService_id().compareTo(calendarDate.getService_id());

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

		if (!(obj instanceof CalendarDate)) {
			return false;
		}

		CalendarDate calendarDate = (CalendarDate)obj;

		long primaryKey = calendarDate.getPrimaryKey();

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
		CalendarDateModelImpl calendarDateModelImpl = this;

		calendarDateModelImpl._originalUuid = calendarDateModelImpl._uuid;

		calendarDateModelImpl._originalService_id =
			calendarDateModelImpl._service_id;

		calendarDateModelImpl._originalDate = calendarDateModelImpl._date;

		calendarDateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CalendarDate> toCacheModel() {
		CalendarDateCacheModel calendarDateCacheModel =
			new CalendarDateCacheModel();

		calendarDateCacheModel.uuid = getUuid();

		String uuid = calendarDateCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			calendarDateCacheModel.uuid = null;
		}

		calendarDateCacheModel.id = getId();

		calendarDateCacheModel.service_id = getService_id();

		String service_id = calendarDateCacheModel.service_id;

		if ((service_id != null) && (service_id.length() == 0)) {
			calendarDateCacheModel.service_id = null;
		}

		Date date = getDate();

		if (date != null) {
			calendarDateCacheModel.date = date.getTime();
		}
		else {
			calendarDateCacheModel.date = Long.MIN_VALUE;
		}

		calendarDateCacheModel.exception_type = getException_type();

		return calendarDateCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CalendarDate, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CalendarDate, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CalendarDate, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CalendarDate)this));
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
		Map<String, Function<CalendarDate, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CalendarDate, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CalendarDate, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CalendarDate)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, CalendarDate>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private String _uuid;
	private String _originalUuid;
	private long _id;
	private String _service_id;
	private String _originalService_id;
	private Date _date;
	private Date _originalDate;
	private int _exception_type;
	private long _columnBitmask;
	private CalendarDate _escapedModel;

}