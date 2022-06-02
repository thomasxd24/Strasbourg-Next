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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import eu.strasbourg.service.place.model.SubPlace;
import eu.strasbourg.service.place.model.SubPlaceModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the SubPlace service. Represents a row in the &quot;place_SubPlace&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SubPlaceModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SubPlaceImpl}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see SubPlaceImpl
 * @generated
 */
public class SubPlaceModelImpl
	extends BaseModelImpl<SubPlace> implements SubPlaceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sub place model instance should use the <code>SubPlace</code> interface instead.
	 */
	public static final String TABLE_NAME = "place_SubPlace";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"subPlaceId", Types.BIGINT},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"description", Types.CLOB},
		{"placeId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("subPlaceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.CLOB);
		TABLE_COLUMNS_MAP.put("placeId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table place_SubPlace (uuid_ VARCHAR(75) null,subPlaceId LONG not null primary key,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,name STRING null,description TEXT null,placeId LONG)";

	public static final String TABLE_SQL_DROP = "drop table place_SubPlace";

	public static final String ORDER_BY_JPQL =
		" ORDER BY subPlace.subPlaceId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY place_SubPlace.subPlaceId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.place.model.SubPlace"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.place.model.SubPlace"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.place.model.SubPlace"),
		true);

	public static final long PLACEID_COLUMN_BITMASK = 1L;

	public static final long UUID_COLUMN_BITMASK = 2L;

	public static final long SUBPLACEID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.place.model.SubPlace"));

	public SubPlaceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _subPlaceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSubPlaceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _subPlaceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SubPlace.class;
	}

	@Override
	public String getModelClassName() {
		return SubPlace.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SubPlace, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SubPlace, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SubPlace, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((SubPlace)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SubPlace, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SubPlace, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SubPlace)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SubPlace, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SubPlace, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, SubPlace>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			SubPlace.class.getClassLoader(), SubPlace.class,
			ModelWrapper.class);

		try {
			Constructor<SubPlace> constructor =
				(Constructor<SubPlace>)proxyClass.getConstructor(
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

	private static final Map<String, Function<SubPlace, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SubPlace, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SubPlace, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<SubPlace, Object>>();
		Map<String, BiConsumer<SubPlace, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<SubPlace, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<SubPlace, Object>() {

				@Override
				public Object apply(SubPlace subPlace) {
					return subPlace.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<SubPlace, Object>() {

				@Override
				public void accept(SubPlace subPlace, Object uuidObject) {
					subPlace.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"subPlaceId",
			new Function<SubPlace, Object>() {

				@Override
				public Object apply(SubPlace subPlace) {
					return subPlace.getSubPlaceId();
				}

			});
		attributeSetterBiConsumers.put(
			"subPlaceId",
			new BiConsumer<SubPlace, Object>() {

				@Override
				public void accept(SubPlace subPlace, Object subPlaceIdObject) {
					subPlace.setSubPlaceId((Long)subPlaceIdObject);
				}

			});
		attributeGetterFunctions.put(
			"status",
			new Function<SubPlace, Object>() {

				@Override
				public Object apply(SubPlace subPlace) {
					return subPlace.getStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"status",
			new BiConsumer<SubPlace, Object>() {

				@Override
				public void accept(SubPlace subPlace, Object statusObject) {
					subPlace.setStatus((Integer)statusObject);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserId",
			new Function<SubPlace, Object>() {

				@Override
				public Object apply(SubPlace subPlace) {
					return subPlace.getStatusByUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserId",
			new BiConsumer<SubPlace, Object>() {

				@Override
				public void accept(
					SubPlace subPlace, Object statusByUserIdObject) {

					subPlace.setStatusByUserId((Long)statusByUserIdObject);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserName",
			new Function<SubPlace, Object>() {

				@Override
				public Object apply(SubPlace subPlace) {
					return subPlace.getStatusByUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserName",
			new BiConsumer<SubPlace, Object>() {

				@Override
				public void accept(
					SubPlace subPlace, Object statusByUserNameObject) {

					subPlace.setStatusByUserName(
						(String)statusByUserNameObject);
				}

			});
		attributeGetterFunctions.put(
			"statusDate",
			new Function<SubPlace, Object>() {

				@Override
				public Object apply(SubPlace subPlace) {
					return subPlace.getStatusDate();
				}

			});
		attributeSetterBiConsumers.put(
			"statusDate",
			new BiConsumer<SubPlace, Object>() {

				@Override
				public void accept(SubPlace subPlace, Object statusDateObject) {
					subPlace.setStatusDate((Date)statusDateObject);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<SubPlace, Object>() {

				@Override
				public Object apply(SubPlace subPlace) {
					return subPlace.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<SubPlace, Object>() {

				@Override
				public void accept(SubPlace subPlace, Object nameObject) {
					subPlace.setName((String)nameObject);
				}

			});
		attributeGetterFunctions.put(
			"description",
			new Function<SubPlace, Object>() {

				@Override
				public Object apply(SubPlace subPlace) {
					return subPlace.getDescription();
				}

			});
		attributeSetterBiConsumers.put(
			"description",
			new BiConsumer<SubPlace, Object>() {

				@Override
				public void accept(
					SubPlace subPlace, Object descriptionObject) {

					subPlace.setDescription((String)descriptionObject);
				}

			});
		attributeGetterFunctions.put(
			"placeId",
			new Function<SubPlace, Object>() {

				@Override
				public Object apply(SubPlace subPlace) {
					return subPlace.getPlaceId();
				}

			});
		attributeSetterBiConsumers.put(
			"placeId",
			new BiConsumer<SubPlace, Object>() {

				@Override
				public void accept(SubPlace subPlace, Object placeIdObject) {
					subPlace.setPlaceId((Long)placeIdObject);
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
	public long getSubPlaceId() {
		return _subPlaceId;
	}

	@Override
	public void setSubPlaceId(long subPlaceId) {
		_subPlaceId = subPlaceId;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getName(), languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(
				LocalizationUtil.updateLocalization(
					getName(), "Name", name, languageId, defaultLanguageId));
		}
		else {
			setName(
				LocalizationUtil.removeLocalization(
					getName(), "Name", languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(
			LocalizationUtil.updateLocalization(
				nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getDescription(), languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDescription(
		String description, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(
				LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(
				LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale) {

		if (descriptionMap == null) {
			return;
		}

		setDescription(
			LocalizationUtil.updateLocalization(
				descriptionMap, getDescription(), "Description",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public long getPlaceId() {
		return _placeId;
	}

	@Override
	public void setPlaceId(long placeId) {
		_columnBitmask |= PLACEID_COLUMN_BITMASK;

		if (!_setOriginalPlaceId) {
			_setOriginalPlaceId = true;

			_originalPlaceId = _placeId;
		}

		_placeId = placeId;
	}

	public long getOriginalPlaceId() {
		return _originalPlaceId;
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, SubPlace.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getName();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			SubPlace.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(
				getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(
				getDescription(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public SubPlace toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SubPlace>
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
		SubPlaceImpl subPlaceImpl = new SubPlaceImpl();

		subPlaceImpl.setUuid(getUuid());
		subPlaceImpl.setSubPlaceId(getSubPlaceId());
		subPlaceImpl.setStatus(getStatus());
		subPlaceImpl.setStatusByUserId(getStatusByUserId());
		subPlaceImpl.setStatusByUserName(getStatusByUserName());
		subPlaceImpl.setStatusDate(getStatusDate());
		subPlaceImpl.setName(getName());
		subPlaceImpl.setDescription(getDescription());
		subPlaceImpl.setPlaceId(getPlaceId());

		subPlaceImpl.resetOriginalValues();

		return subPlaceImpl;
	}

	@Override
	public int compareTo(SubPlace subPlace) {
		long primaryKey = subPlace.getPrimaryKey();

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

		if (!(object instanceof SubPlace)) {
			return false;
		}

		SubPlace subPlace = (SubPlace)object;

		long primaryKey = subPlace.getPrimaryKey();

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
		SubPlaceModelImpl subPlaceModelImpl = this;

		subPlaceModelImpl._originalUuid = subPlaceModelImpl._uuid;

		subPlaceModelImpl._originalPlaceId = subPlaceModelImpl._placeId;

		subPlaceModelImpl._setOriginalPlaceId = false;

		subPlaceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SubPlace> toCacheModel() {
		SubPlaceCacheModel subPlaceCacheModel = new SubPlaceCacheModel();

		subPlaceCacheModel.uuid = getUuid();

		String uuid = subPlaceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			subPlaceCacheModel.uuid = null;
		}

		subPlaceCacheModel.subPlaceId = getSubPlaceId();

		subPlaceCacheModel.status = getStatus();

		subPlaceCacheModel.statusByUserId = getStatusByUserId();

		subPlaceCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = subPlaceCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			subPlaceCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			subPlaceCacheModel.statusDate = statusDate.getTime();
		}
		else {
			subPlaceCacheModel.statusDate = Long.MIN_VALUE;
		}

		subPlaceCacheModel.name = getName();

		String name = subPlaceCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			subPlaceCacheModel.name = null;
		}

		subPlaceCacheModel.description = getDescription();

		String description = subPlaceCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			subPlaceCacheModel.description = null;
		}

		subPlaceCacheModel.placeId = getPlaceId();

		return subPlaceCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SubPlace, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SubPlace, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SubPlace, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((SubPlace)this));
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
		Map<String, Function<SubPlace, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SubPlace, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SubPlace, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((SubPlace)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, SubPlace>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _subPlaceId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private long _placeId;
	private long _originalPlaceId;
	private boolean _setOriginalPlaceId;
	private long _columnBitmask;
	private SubPlace _escapedModel;

}