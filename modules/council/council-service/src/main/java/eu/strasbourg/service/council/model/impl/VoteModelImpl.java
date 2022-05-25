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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.council.model.Vote;
import eu.strasbourg.service.council.model.VoteModel;
import eu.strasbourg.service.council.service.persistence.VotePK;

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

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.council.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.council.model.Vote"),
		false);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.council.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.council.model.Vote"),
		false);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.council.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.council.model.Vote"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long DELIBERATIONID_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long OFFICIALID_COLUMN_BITMASK = 8L;

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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	private static Function<InvocationHandler, Vote>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Vote.class.getClassLoader(), Vote.class, ModelWrapper.class);

		try {
			Constructor<Vote> constructor =
				(Constructor<Vote>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Vote, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Vote, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Vote, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Vote, Object>>();
		Map<String, BiConsumer<Vote, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Vote, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<Vote, Object>() {

				@Override
				public Object apply(Vote vote) {
					return vote.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<Vote, Object>() {

				@Override
				public void accept(Vote vote, Object uuidObject) {
					vote.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"officialId",
			new Function<Vote, Object>() {

				@Override
				public Object apply(Vote vote) {
					return vote.getOfficialId();
				}

			});
		attributeSetterBiConsumers.put(
			"officialId",
			new BiConsumer<Vote, Object>() {

				@Override
				public void accept(Vote vote, Object officialIdObject) {
					vote.setOfficialId((Long)officialIdObject);
				}

			});
		attributeGetterFunctions.put(
			"deliberationId",
			new Function<Vote, Object>() {

				@Override
				public Object apply(Vote vote) {
					return vote.getDeliberationId();
				}

			});
		attributeSetterBiConsumers.put(
			"deliberationId",
			new BiConsumer<Vote, Object>() {

				@Override
				public void accept(Vote vote, Object deliberationIdObject) {
					vote.setDeliberationId((Long)deliberationIdObject);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<Vote, Object>() {

				@Override
				public Object apply(Vote vote) {
					return vote.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<Vote, Object>() {

				@Override
				public void accept(Vote vote, Object groupIdObject) {
					vote.setGroupId((Long)groupIdObject);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<Vote, Object>() {

				@Override
				public Object apply(Vote vote) {
					return vote.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<Vote, Object>() {

				@Override
				public void accept(Vote vote, Object companyIdObject) {
					vote.setCompanyId((Long)companyIdObject);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<Vote, Object>() {

				@Override
				public Object apply(Vote vote) {
					return vote.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<Vote, Object>() {

				@Override
				public void accept(Vote vote, Object createDateObject) {
					vote.setCreateDate((Date)createDateObject);
				}

			});
		attributeGetterFunctions.put(
			"result",
			new Function<Vote, Object>() {

				@Override
				public Object apply(Vote vote) {
					return vote.getResult();
				}

			});
		attributeSetterBiConsumers.put(
			"result",
			new BiConsumer<Vote, Object>() {

				@Override
				public void accept(Vote vote, Object resultObject) {
					vote.setResult((String)resultObject);
				}

			});
		attributeGetterFunctions.put(
			"officialProcurationId",
			new Function<Vote, Object>() {

				@Override
				public Object apply(Vote vote) {
					return vote.getOfficialProcurationId();
				}

			});
		attributeSetterBiConsumers.put(
			"officialProcurationId",
			new BiConsumer<Vote, Object>() {

				@Override
				public void accept(
					Vote vote, Object officialProcurationIdObject) {

					vote.setOfficialProcurationId(
						(Long)officialProcurationIdObject);
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
	public long getOfficialId() {
		return _officialId;
	}

	@Override
	public void setOfficialId(long officialId) {
		_columnBitmask |= OFFICIALID_COLUMN_BITMASK;

		if (!_setOriginalOfficialId) {
			_setOriginalOfficialId = true;

			_originalOfficialId = _officialId;
		}

		_officialId = officialId;
	}

	public long getOriginalOfficialId() {
		return _originalOfficialId;
	}

	@Override
	public long getDeliberationId() {
		return _deliberationId;
	}

	@Override
	public void setDeliberationId(long deliberationId) {
		_columnBitmask = -1L;

		if (!_setOriginalDeliberationId) {
			_setOriginalDeliberationId = true;

			_originalDeliberationId = _deliberationId;
		}

		_deliberationId = deliberationId;
	}

	public long getOriginalDeliberationId() {
		return _originalDeliberationId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
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
		_result = result;
	}

	@Override
	public long getOfficialProcurationId() {
		return _officialProcurationId;
	}

	@Override
	public void setOfficialProcurationId(long officialProcurationId) {
		_officialProcurationId = officialProcurationId;
	}

	public long getColumnBitmask() {
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
		VoteModelImpl voteModelImpl = this;

		voteModelImpl._originalUuid = voteModelImpl._uuid;

		voteModelImpl._originalOfficialId = voteModelImpl._officialId;

		voteModelImpl._setOriginalOfficialId = false;

		voteModelImpl._originalDeliberationId = voteModelImpl._deliberationId;

		voteModelImpl._setOriginalDeliberationId = false;

		voteModelImpl._originalGroupId = voteModelImpl._groupId;

		voteModelImpl._setOriginalGroupId = false;

		voteModelImpl._originalCompanyId = voteModelImpl._companyId;

		voteModelImpl._setOriginalCompanyId = false;

		voteModelImpl._columnBitmask = 0;
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
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Vote, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Vote, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Vote)this));
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
		Map<String, Function<Vote, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Vote, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Vote, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Vote)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Vote>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _officialId;
	private long _originalOfficialId;
	private boolean _setOriginalOfficialId;
	private long _deliberationId;
	private long _originalDeliberationId;
	private boolean _setOriginalDeliberationId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private Date _createDate;
	private String _result;
	private long _officialProcurationId;
	private long _columnBitmask;
	private Vote _escapedModel;

}