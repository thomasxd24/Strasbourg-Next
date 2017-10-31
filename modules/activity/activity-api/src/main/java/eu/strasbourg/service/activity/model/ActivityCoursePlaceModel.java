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

package eu.strasbourg.service.activity.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the ActivityCoursePlace service. Represents a row in the &quot;activity_ActivityCoursePlace&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.activity.model.impl.ActivityCoursePlaceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.activity.model.impl.ActivityCoursePlaceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCoursePlace
 * @see eu.strasbourg.service.activity.model.impl.ActivityCoursePlaceImpl
 * @see eu.strasbourg.service.activity.model.impl.ActivityCoursePlaceModelImpl
 * @generated
 */
@ProviderType
public interface ActivityCoursePlaceModel extends BaseModel<ActivityCoursePlace>,
	GroupedModel, LocalizedModel, ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a activity course place model instance should use the {@link ActivityCoursePlace} interface instead.
	 */

	/**
	 * Returns the primary key of this activity course place.
	 *
	 * @return the primary key of this activity course place
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this activity course place.
	 *
	 * @param primaryKey the primary key of this activity course place
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this activity course place.
	 *
	 * @return the uuid of this activity course place
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this activity course place.
	 *
	 * @param uuid the uuid of this activity course place
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the activity course place ID of this activity course place.
	 *
	 * @return the activity course place ID of this activity course place
	 */
	public long getActivityCoursePlaceId();

	/**
	 * Sets the activity course place ID of this activity course place.
	 *
	 * @param activityCoursePlaceId the activity course place ID of this activity course place
	 */
	public void setActivityCoursePlaceId(long activityCoursePlaceId);

	/**
	 * Returns the group ID of this activity course place.
	 *
	 * @return the group ID of this activity course place
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this activity course place.
	 *
	 * @param groupId the group ID of this activity course place
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this activity course place.
	 *
	 * @return the company ID of this activity course place
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this activity course place.
	 *
	 * @param companyId the company ID of this activity course place
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this activity course place.
	 *
	 * @return the user ID of this activity course place
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this activity course place.
	 *
	 * @param userId the user ID of this activity course place
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this activity course place.
	 *
	 * @return the user uuid of this activity course place
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this activity course place.
	 *
	 * @param userUuid the user uuid of this activity course place
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this activity course place.
	 *
	 * @return the user name of this activity course place
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this activity course place.
	 *
	 * @param userName the user name of this activity course place
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this activity course place.
	 *
	 * @return the create date of this activity course place
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this activity course place.
	 *
	 * @param createDate the create date of this activity course place
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this activity course place.
	 *
	 * @return the modified date of this activity course place
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this activity course place.
	 *
	 * @param modifiedDate the modified date of this activity course place
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the activity course ID of this activity course place.
	 *
	 * @return the activity course ID of this activity course place
	 */
	public long getActivityCourseId();

	/**
	 * Sets the activity course ID of this activity course place.
	 *
	 * @param activityCourseId the activity course ID of this activity course place
	 */
	public void setActivityCourseId(long activityCourseId);

	/**
	 * Returns the place sig ID of this activity course place.
	 *
	 * @return the place sig ID of this activity course place
	 */
	@AutoEscape
	public String getPlaceSIGId();

	/**
	 * Sets the place sig ID of this activity course place.
	 *
	 * @param placeSIGId the place sig ID of this activity course place
	 */
	public void setPlaceSIGId(String placeSIGId);

	/**
	 * Returns the place name of this activity course place.
	 *
	 * @return the place name of this activity course place
	 */
	public String getPlaceName();

	/**
	 * Returns the localized place name of this activity course place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized place name of this activity course place
	 */
	@AutoEscape
	public String getPlaceName(Locale locale);

	/**
	 * Returns the localized place name of this activity course place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this activity course place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getPlaceName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized place name of this activity course place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized place name of this activity course place
	 */
	@AutoEscape
	public String getPlaceName(String languageId);

	/**
	 * Returns the localized place name of this activity course place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this activity course place
	 */
	@AutoEscape
	public String getPlaceName(String languageId, boolean useDefault);

	@AutoEscape
	public String getPlaceNameCurrentLanguageId();

	@AutoEscape
	public String getPlaceNameCurrentValue();

	/**
	 * Returns a map of the locales and localized place names of this activity course place.
	 *
	 * @return the locales and localized place names of this activity course place
	 */
	public Map<Locale, String> getPlaceNameMap();

	/**
	 * Sets the place name of this activity course place.
	 *
	 * @param placeName the place name of this activity course place
	 */
	public void setPlaceName(String placeName);

	/**
	 * Sets the localized place name of this activity course place in the language.
	 *
	 * @param placeName the localized place name of this activity course place
	 * @param locale the locale of the language
	 */
	public void setPlaceName(String placeName, Locale locale);

	/**
	 * Sets the localized place name of this activity course place in the language, and sets the default locale.
	 *
	 * @param placeName the localized place name of this activity course place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setPlaceName(String placeName, Locale locale,
		Locale defaultLocale);

	public void setPlaceNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized place names of this activity course place from the map of locales and localized place names.
	 *
	 * @param placeNameMap the locales and localized place names of this activity course place
	 */
	public void setPlaceNameMap(Map<Locale, String> placeNameMap);

	/**
	 * Sets the localized place names of this activity course place from the map of locales and localized place names, and sets the default locale.
	 *
	 * @param placeNameMap the locales and localized place names of this activity course place
	 * @param defaultLocale the default locale
	 */
	public void setPlaceNameMap(Map<Locale, String> placeNameMap,
		Locale defaultLocale);

	/**
	 * Returns the place street number of this activity course place.
	 *
	 * @return the place street number of this activity course place
	 */
	@AutoEscape
	public String getPlaceStreetNumber();

	/**
	 * Sets the place street number of this activity course place.
	 *
	 * @param placeStreetNumber the place street number of this activity course place
	 */
	public void setPlaceStreetNumber(String placeStreetNumber);

	/**
	 * Returns the place street name of this activity course place.
	 *
	 * @return the place street name of this activity course place
	 */
	@AutoEscape
	public String getPlaceStreetName();

	/**
	 * Sets the place street name of this activity course place.
	 *
	 * @param placeStreetName the place street name of this activity course place
	 */
	public void setPlaceStreetName(String placeStreetName);

	/**
	 * Returns the place zip code of this activity course place.
	 *
	 * @return the place zip code of this activity course place
	 */
	@AutoEscape
	public String getPlaceZipCode();

	/**
	 * Sets the place zip code of this activity course place.
	 *
	 * @param placeZipCode the place zip code of this activity course place
	 */
	public void setPlaceZipCode(String placeZipCode);

	/**
	 * Returns the place city ID of this activity course place.
	 *
	 * @return the place city ID of this activity course place
	 */
	public long getPlaceCityId();

	/**
	 * Sets the place city ID of this activity course place.
	 *
	 * @param placeCityId the place city ID of this activity course place
	 */
	public void setPlaceCityId(long placeCityId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(
		eu.strasbourg.service.activity.model.ActivityCoursePlace activityCoursePlace);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.activity.model.ActivityCoursePlace> toCacheModel();

	@Override
	public eu.strasbourg.service.activity.model.ActivityCoursePlace toEscapedModel();

	@Override
	public eu.strasbourg.service.activity.model.ActivityCoursePlace toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}