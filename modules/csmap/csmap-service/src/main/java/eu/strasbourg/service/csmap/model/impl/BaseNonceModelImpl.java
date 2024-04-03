/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import eu.strasbourg.service.csmap.model.BaseNonce;
import eu.strasbourg.service.csmap.model.BaseNonceModel;

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
 * The base model implementation for the BaseNonce service. Represents a row in the &quot;csmap_BaseNonce&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>BaseNonceModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BaseNonceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BaseNonceImpl
 * @generated
 */
public class BaseNonceModelImpl
	extends BaseModelImpl<BaseNonce> implements BaseNonceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a base nonce model instance should use the <code>BaseNonce</code> interface instead.
	 */
	public static final String TABLE_NAME = "csmap_BaseNonce";

	public static final Object[][] TABLE_COLUMNS = {
		{"baseNonceId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"value", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("baseNonceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("value", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table csmap_BaseNonce (baseNonceId LONG not null primary key,createDate DATE null,value VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table csmap_BaseNonce";

	public static final String ORDER_BY_JPQL =
		" ORDER BY baseNonce.createDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY csmap_BaseNonce.createDate ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long VALUE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CREATEDATE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public BaseNonceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _baseNonceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBaseNonceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _baseNonceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BaseNonce.class;
	}

	@Override
	public String getModelClassName() {
		return BaseNonce.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<BaseNonce, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<BaseNonce, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BaseNonce, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((BaseNonce)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<BaseNonce, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<BaseNonce, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(BaseNonce)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<BaseNonce, Object>>
		getAttributeGetterFunctions() {

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<BaseNonce, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<BaseNonce, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<BaseNonce, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<BaseNonce, Object>>();

			attributeGetterFunctions.put(
				"baseNonceId", BaseNonce::getBaseNonceId);
			attributeGetterFunctions.put(
				"createDate", BaseNonce::getCreateDate);
			attributeGetterFunctions.put("value", BaseNonce::getValue);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<BaseNonce, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<BaseNonce, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<BaseNonce, ?>>();

			attributeSetterBiConsumers.put(
				"baseNonceId",
				(BiConsumer<BaseNonce, Long>)BaseNonce::setBaseNonceId);
			attributeSetterBiConsumers.put(
				"createDate",
				(BiConsumer<BaseNonce, Date>)BaseNonce::setCreateDate);
			attributeSetterBiConsumers.put(
				"value", (BiConsumer<BaseNonce, String>)BaseNonce::setValue);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@Override
	public long getBaseNonceId() {
		return _baseNonceId;
	}

	@Override
	public void setBaseNonceId(long baseNonceId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_baseNonceId = baseNonceId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public String getValue() {
		if (_value == null) {
			return "";
		}
		else {
			return _value;
		}
	}

	@Override
	public void setValue(String value) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_value = value;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalValue() {
		return getColumnOriginalValue("value");
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
			0, BaseNonce.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BaseNonce toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, BaseNonce>
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
		BaseNonceImpl baseNonceImpl = new BaseNonceImpl();

		baseNonceImpl.setBaseNonceId(getBaseNonceId());
		baseNonceImpl.setCreateDate(getCreateDate());
		baseNonceImpl.setValue(getValue());

		baseNonceImpl.resetOriginalValues();

		return baseNonceImpl;
	}

	@Override
	public BaseNonce cloneWithOriginalValues() {
		BaseNonceImpl baseNonceImpl = new BaseNonceImpl();

		baseNonceImpl.setBaseNonceId(
			this.<Long>getColumnOriginalValue("baseNonceId"));
		baseNonceImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		baseNonceImpl.setValue(this.<String>getColumnOriginalValue("value"));

		return baseNonceImpl;
	}

	@Override
	public int compareTo(BaseNonce baseNonce) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), baseNonce.getCreateDate());

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

		if (!(object instanceof BaseNonce)) {
			return false;
		}

		BaseNonce baseNonce = (BaseNonce)object;

		long primaryKey = baseNonce.getPrimaryKey();

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
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<BaseNonce> toCacheModel() {
		BaseNonceCacheModel baseNonceCacheModel = new BaseNonceCacheModel();

		baseNonceCacheModel.baseNonceId = getBaseNonceId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			baseNonceCacheModel.createDate = createDate.getTime();
		}
		else {
			baseNonceCacheModel.createDate = Long.MIN_VALUE;
		}

		baseNonceCacheModel.value = getValue();

		String value = baseNonceCacheModel.value;

		if ((value != null) && (value.length() == 0)) {
			baseNonceCacheModel.value = null;
		}

		return baseNonceCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<BaseNonce, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<BaseNonce, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BaseNonce, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((BaseNonce)this);

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

		private static final Function<InvocationHandler, BaseNonce>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					BaseNonce.class, ModelWrapper.class);

	}

	private long _baseNonceId;
	private Date _createDate;
	private String _value;

	public <T> T getColumnValue(String columnName) {
		Function<BaseNonce, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((BaseNonce)this);
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

		_columnOriginalValues.put("baseNonceId", _baseNonceId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("value", _value);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("baseNonceId", 1L);

		columnBitmasks.put("createDate", 2L);

		columnBitmasks.put("value", 4L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private BaseNonce _escapedModel;

}