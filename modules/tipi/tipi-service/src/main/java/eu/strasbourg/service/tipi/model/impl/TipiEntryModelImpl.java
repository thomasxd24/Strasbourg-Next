/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.tipi.model.impl;

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

import eu.strasbourg.service.tipi.model.TipiEntry;
import eu.strasbourg.service.tipi.model.TipiEntryModel;

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
	public static final long DATE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 4L;

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

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TipiEntry, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<TipiEntry, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<TipiEntry, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<TipiEntry, Object>>();

			attributeGetterFunctions.put("uuid", TipiEntry::getUuid);
			attributeGetterFunctions.put("id", TipiEntry::getId);
			attributeGetterFunctions.put("date", TipiEntry::getDate);
			attributeGetterFunctions.put("total", TipiEntry::getTotal);
			attributeGetterFunctions.put("paidCount", TipiEntry::getPaidCount);
			attributeGetterFunctions.put(
				"refusedCount", TipiEntry::getRefusedCount);
			attributeGetterFunctions.put(
				"canceledCount", TipiEntry::getCanceledCount);
			attributeGetterFunctions.put("type", TipiEntry::getType);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<TipiEntry, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<TipiEntry, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<TipiEntry, ?>>();

			attributeSetterBiConsumers.put(
				"uuid", (BiConsumer<TipiEntry, String>)TipiEntry::setUuid);
			attributeSetterBiConsumers.put(
				"id", (BiConsumer<TipiEntry, Long>)TipiEntry::setId);
			attributeSetterBiConsumers.put(
				"date", (BiConsumer<TipiEntry, Date>)TipiEntry::setDate);
			attributeSetterBiConsumers.put(
				"total", (BiConsumer<TipiEntry, Integer>)TipiEntry::setTotal);
			attributeSetterBiConsumers.put(
				"paidCount",
				(BiConsumer<TipiEntry, Integer>)TipiEntry::setPaidCount);
			attributeSetterBiConsumers.put(
				"refusedCount",
				(BiConsumer<TipiEntry, Integer>)TipiEntry::setRefusedCount);
			attributeSetterBiConsumers.put(
				"canceledCount",
				(BiConsumer<TipiEntry, Integer>)TipiEntry::setCanceledCount);
			attributeSetterBiConsumers.put(
				"type", (BiConsumer<TipiEntry, String>)TipiEntry::setType);

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
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_id = id;
	}

	@JSON
	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_date = date;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Date getOriginalDate() {
		return getColumnOriginalValue("date_");
	}

	@JSON
	@Override
	public int getTotal() {
		return _total;
	}

	@Override
	public void setTotal(int total) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_total = total;
	}

	@JSON
	@Override
	public int getPaidCount() {
		return _paidCount;
	}

	@Override
	public void setPaidCount(int paidCount) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_paidCount = paidCount;
	}

	@JSON
	@Override
	public int getRefusedCount() {
		return _refusedCount;
	}

	@Override
	public void setRefusedCount(int refusedCount) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_refusedCount = refusedCount;
	}

	@JSON
	@Override
	public int getCanceledCount() {
		return _canceledCount;
	}

	@Override
	public void setCanceledCount(int canceledCount) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_type = type;
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
	public TipiEntry cloneWithOriginalValues() {
		TipiEntryImpl tipiEntryImpl = new TipiEntryImpl();

		tipiEntryImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		tipiEntryImpl.setId(this.<Long>getColumnOriginalValue("id_"));
		tipiEntryImpl.setDate(this.<Date>getColumnOriginalValue("date_"));
		tipiEntryImpl.setTotal(this.<Integer>getColumnOriginalValue("total"));
		tipiEntryImpl.setPaidCount(
			this.<Integer>getColumnOriginalValue("paidCount"));
		tipiEntryImpl.setRefusedCount(
			this.<Integer>getColumnOriginalValue("refusedCount"));
		tipiEntryImpl.setCanceledCount(
			this.<Integer>getColumnOriginalValue("canceledCount"));
		tipiEntryImpl.setType(this.<String>getColumnOriginalValue("type_"));

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
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TipiEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TipiEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((TipiEntry)this);

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

		private static final Function<InvocationHandler, TipiEntry>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					TipiEntry.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _id;
	private Date _date;
	private int _total;
	private int _paidCount;
	private int _refusedCount;
	private int _canceledCount;
	private String _type;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<TipiEntry, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((TipiEntry)this);
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
		_columnOriginalValues.put("id_", _id);
		_columnOriginalValues.put("date_", _date);
		_columnOriginalValues.put("total", _total);
		_columnOriginalValues.put("paidCount", _paidCount);
		_columnOriginalValues.put("refusedCount", _refusedCount);
		_columnOriginalValues.put("canceledCount", _canceledCount);
		_columnOriginalValues.put("type_", _type);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("id_", "id");
		attributeNames.put("date_", "date");
		attributeNames.put("type_", "type");

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

		columnBitmasks.put("id_", 2L);

		columnBitmasks.put("date_", 4L);

		columnBitmasks.put("total", 8L);

		columnBitmasks.put("paidCount", 16L);

		columnBitmasks.put("refusedCount", 32L);

		columnBitmasks.put("canceledCount", 64L);

		columnBitmasks.put("type_", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private TipiEntry _escapedModel;

}