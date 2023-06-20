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

package eu.strasbourg.service.council.model.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import eu.strasbourg.service.council.model.Vote;
import eu.strasbourg.service.council.model.VoteModel;
import eu.strasbourg.service.council.service.persistence.VotePK;

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
 * The base model implementation for the Vote service. Represents a row in the &quot;council_Vote&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>VoteModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VoteImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VoteImpl
 * @generated
 */
public class VoteModelImpl extends BaseModelImpl<Vote> implements VoteModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vote model instance should use the <code>Vote</code> interface instead.
	 */
	public static final String TABLE_NAME = "council_Vote";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"officialId", Types.BIGINT},
		{"deliberationId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"result", Types.VARCHAR}, {"officialProcurationId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("officialId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("deliberationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("result", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("officialProcurationId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table council_Vote (uuid_ VARCHAR(75) null,officialId LONG not null,deliberationId LONG not null,groupId LONG,companyId LONG,createDate DATE null,result VARCHAR(75) null,officialProcurationId LONG,primary key (officialId, deliberationId))";

	public static final String TABLE_SQL_DROP = "drop table council_Vote";

	public static final String ORDER_BY_JPQL =
		" ORDER BY vote.id.deliberationId DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY council_Vote.deliberationId DESC";

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
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DELIBERATIONID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long OFFICIALID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 16L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.council.service.util.ServiceProps.get(
			"lock.expiration.time.eu.strasbourg.service.council.model.Vote"));

	public VoteModelImpl() {
	}

	@Override
	public VotePK getPrimaryKey() {
		return new VotePK(_officialId, _deliberationId);
	}

	@Override
	public void setPrimaryKey(VotePK primaryKey) {
		setOfficialId(primaryKey.officialId);
		setDeliberationId(primaryKey.deliberationId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new VotePK(_officialId, _deliberationId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VotePK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Vote.class;
	}

	@Override
	public String getModelClassName() {
		return Vote.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Vote, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Vote, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Vote, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Vote)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Vote, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Vote, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Vote)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Vote, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Vote, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Vote, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Vote, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Vote, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Vote, Object>>();
		Map<String, BiConsumer<Vote, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Vote, ?>>();

		attributeGetterFunctions.put("uuid", Vote::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Vote, String>)Vote::setUuid);
		attributeGetterFunctions.put("officialId", Vote::getOfficialId);
		attributeSetterBiConsumers.put(
			"officialId", (BiConsumer<Vote, Long>)Vote::setOfficialId);
		attributeGetterFunctions.put("deliberationId", Vote::getDeliberationId);
		attributeSetterBiConsumers.put(
			"deliberationId", (BiConsumer<Vote, Long>)Vote::setDeliberationId);
		attributeGetterFunctions.put("groupId", Vote::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Vote, Long>)Vote::setGroupId);
		attributeGetterFunctions.put("companyId", Vote::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Vote, Long>)Vote::setCompanyId);
		attributeGetterFunctions.put("createDate", Vote::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Vote, Date>)Vote::setCreateDate);
		attributeGetterFunctions.put("result", Vote::getResult);
		attributeSetterBiConsumers.put(
			"result", (BiConsumer<Vote, String>)Vote::setResult);
		attributeGetterFunctions.put(
			"officialProcurationId", Vote::getOfficialProcurationId);
		attributeSetterBiConsumers.put(
			"officialProcurationId",
			(BiConsumer<Vote, Long>)Vote::setOfficialProcurationId);

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

	@Override
	public long getOfficialId() {
		return _officialId;
	}

	@Override
	public void setOfficialId(long officialId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_officialId = officialId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalOfficialId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("officialId"));
	}

	@Override
	public long getDeliberationId() {
		return _deliberationId;
	}

	@Override
	public void setDeliberationId(long deliberationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_deliberationId = deliberationId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDeliberationId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("deliberationId"));
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
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
	public String getResult() {
		if (_result == null) {
			return "";
		}
		else {
			return _result;
		}
	}

	@Override
	public void setResult(String result) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_result = result;
	}

	@Override
	public long getOfficialProcurationId() {
		return _officialProcurationId;
	}

	@Override
	public void setOfficialProcurationId(long officialProcurationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_officialProcurationId = officialProcurationId;
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
	public Vote toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Vote>
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
		VoteImpl voteImpl = new VoteImpl();

		voteImpl.setUuid(getUuid());
		voteImpl.setOfficialId(getOfficialId());
		voteImpl.setDeliberationId(getDeliberationId());
		voteImpl.setGroupId(getGroupId());
		voteImpl.setCompanyId(getCompanyId());
		voteImpl.setCreateDate(getCreateDate());
		voteImpl.setResult(getResult());
		voteImpl.setOfficialProcurationId(getOfficialProcurationId());

		voteImpl.resetOriginalValues();

		return voteImpl;
	}

	@Override
	public Vote cloneWithOriginalValues() {
		VoteImpl voteImpl = new VoteImpl();

		voteImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		voteImpl.setOfficialId(this.<Long>getColumnOriginalValue("officialId"));
		voteImpl.setDeliberationId(
			this.<Long>getColumnOriginalValue("deliberationId"));
		voteImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		voteImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		voteImpl.setCreateDate(this.<Date>getColumnOriginalValue("createDate"));
		voteImpl.setResult(this.<String>getColumnOriginalValue("result"));
		voteImpl.setOfficialProcurationId(
			this.<Long>getColumnOriginalValue("officialProcurationId"));

		return voteImpl;
	}

	@Override
	public int compareTo(Vote vote) {
		int value = 0;

		if (getDeliberationId() < vote.getDeliberationId()) {
			value = -1;
		}
		else if (getDeliberationId() > vote.getDeliberationId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		if (!(object instanceof Vote)) {
			return false;
		}

		Vote vote = (Vote)object;

		VotePK primaryKey = vote.getPrimaryKey();

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
	public CacheModel<Vote> toCacheModel() {
		VoteCacheModel voteCacheModel = new VoteCacheModel();

		voteCacheModel.votePK = getPrimaryKey();

		voteCacheModel.uuid = getUuid();

		String uuid = voteCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			voteCacheModel.uuid = null;
		}

		voteCacheModel.officialId = getOfficialId();

		voteCacheModel.deliberationId = getDeliberationId();

		voteCacheModel.groupId = getGroupId();

		voteCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			voteCacheModel.createDate = createDate.getTime();
		}
		else {
			voteCacheModel.createDate = Long.MIN_VALUE;
		}

		voteCacheModel.result = getResult();

		String result = voteCacheModel.result;

		if ((result != null) && (result.length() == 0)) {
			voteCacheModel.result = null;
		}

		voteCacheModel.officialProcurationId = getOfficialProcurationId();

		return voteCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Vote, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Vote, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Vote, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Vote)this);

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

		private static final Function<InvocationHandler, Vote>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Vote.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _officialId;
	private long _deliberationId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private String _result;
	private long _officialProcurationId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Vote, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Vote)this);
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
		_columnOriginalValues.put("officialId", _officialId);
		_columnOriginalValues.put("deliberationId", _deliberationId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("result", _result);
		_columnOriginalValues.put(
			"officialProcurationId", _officialProcurationId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

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

		columnBitmasks.put("officialId", 2L);

		columnBitmasks.put("deliberationId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("result", 64L);

		columnBitmasks.put("officialProcurationId", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Vote _escapedModel;

}