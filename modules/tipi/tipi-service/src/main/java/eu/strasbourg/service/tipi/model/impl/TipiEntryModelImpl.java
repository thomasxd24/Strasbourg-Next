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

package eu.strasbourg.service.tipi.model.impl;

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

import eu.strasbourg.service.tipi.model.TipiEntry;
import eu.strasbourg.service.tipi.model.TipiEntryModel;
import eu.strasbourg.service.tipi.model.TipiEntrySoap;

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
 * The base model implementation for the TipiEntry service. Represents a row in the &quot;tipi_TipiEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TipiEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TipiEntryImpl}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see TipiEntryImpl
 * @generated
 */
@JSON(strict = true)
public class TipiEntryModelImpl
	extends BaseModelImpl<TipiEntry> implements TipiEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tipi entry model instance should use the <code>TipiEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "tipi_TipiEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"id_", Types.BIGINT},
		{"date_", Types.TIMESTAMP}, {"total", Types.INTEGER},
		{"paidCount", Types.INTEGER}, {"refusedCount", Types.INTEGER},
		{"canceledCount", Types.INTEGER}, {"type_", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("date_", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("total", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("paidCount", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("refusedCount", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("canceledCount", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table tipi_TipiEntry (uuid_ VARCHAR(75) null,id_ LONG not null primary key,date_ DATE null,total INTEGER,paidCount INTEGER,refusedCount INTEGER,canceledCount INTEGER,type_ VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table tipi_TipiEntry";

	public static final String ORDER_BY_JPQL = " ORDER BY tipiEntry.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY tipi_TipiEntry.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.tipi.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.tipi.model.TipiEntry"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.tipi.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.tipi.model.TipiEntry"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.tipi.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.tipi.model.TipiEntry"),
		true);

	public static final long DATE_COLUMN_BITMASK = 1L;

	public static final long UUID_COLUMN_BITMASK = 2L;

	public static final long ID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TipiEntry toModel(TipiEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TipiEntry model = new TipiEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setDate(soapModel.getDate());
		model.setTotal(soapModel.getTotal());
		model.setPaidCount(soapModel.getPaidCount());
		model.setRefusedCount(soapModel.getRefusedCount());
		model.setCanceledCount(soapModel.getCanceledCount());
		model.setType(soapModel.getType());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TipiEntry> toModels(TipiEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TipiEntry> models = new ArrayList<TipiEntry>(soapModels.length);

		for (TipiEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.tipi.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.tipi.model.TipiEntry"));

	public TipiEntryModelImpl() {
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
		return TipiEntry.class;
	}

	@Override
	public String getModelClassName() {
		return TipiEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TipiEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TipiEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TipiEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((TipiEntry)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TipiEntry, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TipiEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TipiEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TipiEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TipiEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, TipiEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			TipiEntry.class.getClassLoader(), TipiEntry.class,
			ModelWrapper.class);

		try {
			Constructor<TipiEntry> constructor =
				(Constructor<TipiEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<TipiEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TipiEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TipiEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TipiEntry, Object>>();
		Map<String, BiConsumer<TipiEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TipiEntry, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<TipiEntry, Object>() {

				@Override
				public Object apply(TipiEntry tipiEntry) {
					return tipiEntry.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<TipiEntry, Object>() {

				@Override
				public void accept(TipiEntry tipiEntry, Object uuidObject) {
					tipiEntry.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"id",
			new Function<TipiEntry, Object>() {

				@Override
				public Object apply(TipiEntry tipiEntry) {
					return tipiEntry.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<TipiEntry, Object>() {

				@Override
				public void accept(TipiEntry tipiEntry, Object idObject) {
					tipiEntry.setId((Long)idObject);
				}

			});
		attributeGetterFunctions.put(
			"date",
			new Function<TipiEntry, Object>() {

				@Override
				public Object apply(TipiEntry tipiEntry) {
					return tipiEntry.getDate();
				}

			});
		attributeSetterBiConsumers.put(
			"date",
			new BiConsumer<TipiEntry, Object>() {

				@Override
				public void accept(TipiEntry tipiEntry, Object dateObject) {
					tipiEntry.setDate((Date)dateObject);
				}

			});
		attributeGetterFunctions.put(
			"total",
			new Function<TipiEntry, Object>() {

				@Override
				public Object apply(TipiEntry tipiEntry) {
					return tipiEntry.getTotal();
				}

			});
		attributeSetterBiConsumers.put(
			"total",
			new BiConsumer<TipiEntry, Object>() {

				@Override
				public void accept(TipiEntry tipiEntry, Object totalObject) {
					tipiEntry.setTotal((Integer)totalObject);
				}

			});
		attributeGetterFunctions.put(
			"paidCount",
			new Function<TipiEntry, Object>() {

				@Override
				public Object apply(TipiEntry tipiEntry) {
					return tipiEntry.getPaidCount();
				}

			});
		attributeSetterBiConsumers.put(
			"paidCount",
			new BiConsumer<TipiEntry, Object>() {

				@Override
				public void accept(
					TipiEntry tipiEntry, Object paidCountObject) {

					tipiEntry.setPaidCount((Integer)paidCountObject);
				}

			});
		attributeGetterFunctions.put(
			"refusedCount",
			new Function<TipiEntry, Object>() {

				@Override
				public Object apply(TipiEntry tipiEntry) {
					return tipiEntry.getRefusedCount();
				}

			});
		attributeSetterBiConsumers.put(
			"refusedCount",
			new BiConsumer<TipiEntry, Object>() {

				@Override
				public void accept(
					TipiEntry tipiEntry, Object refusedCountObject) {

					tipiEntry.setRefusedCount((Integer)refusedCountObject);
				}

			});
		attributeGetterFunctions.put(
			"canceledCount",
			new Function<TipiEntry, Object>() {

				@Override
				public Object apply(TipiEntry tipiEntry) {
					return tipiEntry.getCanceledCount();
				}

			});
		attributeSetterBiConsumers.put(
			"canceledCount",
			new BiConsumer<TipiEntry, Object>() {

				@Override
				public void accept(
					TipiEntry tipiEntry, Object canceledCountObject) {

					tipiEntry.setCanceledCount((Integer)canceledCountObject);
				}

			});
		attributeGetterFunctions.put(
			"type",
			new Function<TipiEntry, Object>() {

				@Override
				public Object apply(TipiEntry tipiEntry) {
					return tipiEntry.getType();
				}

			});
		attributeSetterBiConsumers.put(
			"type",
			new BiConsumer<TipiEntry, Object>() {

				@Override
				public void accept(TipiEntry tipiEntry, Object typeObject) {
					tipiEntry.setType((String)typeObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@JSON
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

	@JSON
	@Override
	public int getTotal() {
		return _total;
	}

	@Override
	public void setTotal(int total) {
		_total = total;
	}

	@JSON
	@Override
	public int getPaidCount() {
		return _paidCount;
	}

	@Override
	public void setPaidCount(int paidCount) {
		_paidCount = paidCount;
	}

	@JSON
	@Override
	public int getRefusedCount() {
		return _refusedCount;
	}

	@Override
	public void setRefusedCount(int refusedCount) {
		_refusedCount = refusedCount;
	}

	@JSON
	@Override
	public int getCanceledCount() {
		return _canceledCount;
	}

	@Override
	public void setCanceledCount(int canceledCount) {
		_canceledCount = canceledCount;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, TipiEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TipiEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TipiEntry>
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
		TipiEntryImpl tipiEntryImpl = new TipiEntryImpl();

		tipiEntryImpl.setUuid(getUuid());
		tipiEntryImpl.setId(getId());
		tipiEntryImpl.setDate(getDate());
		tipiEntryImpl.setTotal(getTotal());
		tipiEntryImpl.setPaidCount(getPaidCount());
		tipiEntryImpl.setRefusedCount(getRefusedCount());
		tipiEntryImpl.setCanceledCount(getCanceledCount());
		tipiEntryImpl.setType(getType());

		tipiEntryImpl.resetOriginalValues();

		return tipiEntryImpl;
	}

	@Override
	public int compareTo(TipiEntry tipiEntry) {
		long primaryKey = tipiEntry.getPrimaryKey();

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

		if (!(object instanceof TipiEntry)) {
			return false;
		}

		TipiEntry tipiEntry = (TipiEntry)object;

		long primaryKey = tipiEntry.getPrimaryKey();

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
		TipiEntryModelImpl tipiEntryModelImpl = this;

		tipiEntryModelImpl._originalUuid = tipiEntryModelImpl._uuid;

		tipiEntryModelImpl._originalDate = tipiEntryModelImpl._date;

		tipiEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TipiEntry> toCacheModel() {
		TipiEntryCacheModel tipiEntryCacheModel = new TipiEntryCacheModel();

		tipiEntryCacheModel.uuid = getUuid();

		String uuid = tipiEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			tipiEntryCacheModel.uuid = null;
		}

		tipiEntryCacheModel.id = getId();

		Date date = getDate();

		if (date != null) {
			tipiEntryCacheModel.date = date.getTime();
		}
		else {
			tipiEntryCacheModel.date = Long.MIN_VALUE;
		}

		tipiEntryCacheModel.total = getTotal();

		tipiEntryCacheModel.paidCount = getPaidCount();

		tipiEntryCacheModel.refusedCount = getRefusedCount();

		tipiEntryCacheModel.canceledCount = getCanceledCount();

		tipiEntryCacheModel.type = getType();

		String type = tipiEntryCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			tipiEntryCacheModel.type = null;
		}

		return tipiEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TipiEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TipiEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TipiEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TipiEntry)this));
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
		Map<String, Function<TipiEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TipiEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TipiEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TipiEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TipiEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _id;
	private Date _date;
	private Date _originalDate;
	private int _total;
	private int _paidCount;
	private int _refusedCount;
	private int _canceledCount;
	private String _type;
	private long _columnBitmask;
	private TipiEntry _escapedModel;

}