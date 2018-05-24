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

package eu.strasbourg.service.place.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Period service. Represents a row in the &quot;place_Period&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.place.model.impl.PeriodModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.place.model.impl.PeriodImpl}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see Period
 * @see eu.strasbourg.service.place.model.impl.PeriodImpl
 * @see eu.strasbourg.service.place.model.impl.PeriodModelImpl
 * @generated
 */
@ProviderType
public interface PeriodModel extends BaseModel<Period>, LocalizedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a period model instance should use the {@link Period} interface instead.
	 */

	/**
	 * Returns the primary key of this period.
	 *
	 * @return the primary key of this period
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this period.
	 *
	 * @param primaryKey the primary key of this period
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this period.
	 *
	 * @return the uuid of this period
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this period.
	 *
	 * @param uuid the uuid of this period
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the period ID of this period.
	 *
	 * @return the period ID of this period
	 */
	public long getPeriodId();

	/**
	 * Sets the period ID of this period.
	 *
	 * @param periodId the period ID of this period
	 */
	public void setPeriodId(long periodId);

	/**
	 * Returns the name of this period.
	 *
	 * @return the name of this period
	 */
	public String getName();

	/**
	 * Returns the localized name of this period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this period
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this period in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this period. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this period
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this period in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this period
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this period.
	 *
	 * @return the locales and localized names of this period
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this period.
	 *
	 * @param name the name of this period
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this period in the language.
	 *
	 * @param name the localized name of this period
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this period in the language, and sets the default locale.
	 *
	 * @param name the localized name of this period
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this period from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this period
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this period from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this period
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the default period of this period.
	 *
	 * @return the default period of this period
	 */
	public Boolean getDefaultPeriod();

	/**
	 * Sets the default period of this period.
	 *
	 * @param defaultPeriod the default period of this period
	 */
	public void setDefaultPeriod(Boolean defaultPeriod);

	/**
	 * Returns the start date of this period.
	 *
	 * @return the start date of this period
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this period.
	 *
	 * @param startDate the start date of this period
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this period.
	 *
	 * @return the end date of this period
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this period.
	 *
	 * @param endDate the end date of this period
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the link label of this period.
	 *
	 * @return the link label of this period
	 */
	public String getLinkLabel();

	/**
	 * Returns the localized link label of this period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized link label of this period
	 */
	@AutoEscape
	public String getLinkLabel(Locale locale);

	/**
	 * Returns the localized link label of this period in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized link label of this period. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getLinkLabel(Locale locale, boolean useDefault);

	/**
	 * Returns the localized link label of this period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized link label of this period
	 */
	@AutoEscape
	public String getLinkLabel(String languageId);

	/**
	 * Returns the localized link label of this period in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized link label of this period
	 */
	@AutoEscape
	public String getLinkLabel(String languageId, boolean useDefault);

	@AutoEscape
	public String getLinkLabelCurrentLanguageId();

	@AutoEscape
	public String getLinkLabelCurrentValue();

	/**
	 * Returns a map of the locales and localized link labels of this period.
	 *
	 * @return the locales and localized link labels of this period
	 */
	public Map<Locale, String> getLinkLabelMap();

	/**
	 * Sets the link label of this period.
	 *
	 * @param linkLabel the link label of this period
	 */
	public void setLinkLabel(String linkLabel);

	/**
	 * Sets the localized link label of this period in the language.
	 *
	 * @param linkLabel the localized link label of this period
	 * @param locale the locale of the language
	 */
	public void setLinkLabel(String linkLabel, Locale locale);

	/**
	 * Sets the localized link label of this period in the language, and sets the default locale.
	 *
	 * @param linkLabel the localized link label of this period
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setLinkLabel(String linkLabel, Locale locale,
		Locale defaultLocale);

	public void setLinkLabelCurrentLanguageId(String languageId);

	/**
	 * Sets the localized link labels of this period from the map of locales and localized link labels.
	 *
	 * @param linkLabelMap the locales and localized link labels of this period
	 */
	public void setLinkLabelMap(Map<Locale, String> linkLabelMap);

	/**
	 * Sets the localized link labels of this period from the map of locales and localized link labels, and sets the default locale.
	 *
	 * @param linkLabelMap the locales and localized link labels of this period
	 * @param defaultLocale the default locale
	 */
	public void setLinkLabelMap(Map<Locale, String> linkLabelMap,
		Locale defaultLocale);

	/**
	 * Returns the link url of this period.
	 *
	 * @return the link url of this period
	 */
	public String getLinkURL();

	/**
	 * Returns the localized link url of this period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized link url of this period
	 */
	@AutoEscape
	public String getLinkURL(Locale locale);

	/**
	 * Returns the localized link url of this period in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized link url of this period. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getLinkURL(Locale locale, boolean useDefault);

	/**
	 * Returns the localized link url of this period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized link url of this period
	 */
	@AutoEscape
	public String getLinkURL(String languageId);

	/**
	 * Returns the localized link url of this period in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized link url of this period
	 */
	@AutoEscape
	public String getLinkURL(String languageId, boolean useDefault);

	@AutoEscape
	public String getLinkURLCurrentLanguageId();

	@AutoEscape
	public String getLinkURLCurrentValue();

	/**
	 * Returns a map of the locales and localized link urls of this period.
	 *
	 * @return the locales and localized link urls of this period
	 */
	public Map<Locale, String> getLinkURLMap();

	/**
	 * Sets the link url of this period.
	 *
	 * @param linkURL the link url of this period
	 */
	public void setLinkURL(String linkURL);

	/**
	 * Sets the localized link url of this period in the language.
	 *
	 * @param linkURL the localized link url of this period
	 * @param locale the locale of the language
	 */
	public void setLinkURL(String linkURL, Locale locale);

	/**
	 * Sets the localized link url of this period in the language, and sets the default locale.
	 *
	 * @param linkURL the localized link url of this period
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setLinkURL(String linkURL, Locale locale, Locale defaultLocale);

	public void setLinkURLCurrentLanguageId(String languageId);

	/**
	 * Sets the localized link urls of this period from the map of locales and localized link urls.
	 *
	 * @param linkURLMap the locales and localized link urls of this period
	 */
	public void setLinkURLMap(Map<Locale, String> linkURLMap);

	/**
	 * Sets the localized link urls of this period from the map of locales and localized link urls, and sets the default locale.
	 *
	 * @param linkURLMap the locales and localized link urls of this period
	 * @param defaultLocale the default locale
	 */
	public void setLinkURLMap(Map<Locale, String> linkURLMap,
		Locale defaultLocale);

	/**
	 * Returns the always open of this period.
	 *
	 * @return the always open of this period
	 */
	public Boolean getAlwaysOpen();

	/**
	 * Sets the always open of this period.
	 *
	 * @param alwaysOpen the always open of this period
	 */
	public void setAlwaysOpen(Boolean alwaysOpen);

	/**
	 * Returns the rt green threshold of this period.
	 *
	 * @return the rt green threshold of this period
	 */
	public long getRTGreenThreshold();

	/**
	 * Sets the rt green threshold of this period.
	 *
	 * @param RTGreenThreshold the rt green threshold of this period
	 */
	public void setRTGreenThreshold(long RTGreenThreshold);

	/**
	 * Returns the rt orange threshold of this period.
	 *
	 * @return the rt orange threshold of this period
	 */
	public long getRTOrangeThreshold();

	/**
	 * Sets the rt orange threshold of this period.
	 *
	 * @param RTOrangeThreshold the rt orange threshold of this period
	 */
	public void setRTOrangeThreshold(long RTOrangeThreshold);

	/**
	 * Returns the rt red threshold of this period.
	 *
	 * @return the rt red threshold of this period
	 */
	public long getRTRedThreshold();

	/**
	 * Sets the rt red threshold of this period.
	 *
	 * @param RTRedThreshold the rt red threshold of this period
	 */
	public void setRTRedThreshold(long RTRedThreshold);

	/**
	 * Returns the rt max threshold of this period.
	 *
	 * @return the rt max threshold of this period
	 */
	public long getRTMaxThreshold();

	/**
	 * Sets the rt max threshold of this period.
	 *
	 * @param RTMaxThreshold the rt max threshold of this period
	 */
	public void setRTMaxThreshold(long RTMaxThreshold);

	/**
	 * Returns the place ID of this period.
	 *
	 * @return the place ID of this period
	 */
	public long getPlaceId();

	/**
	 * Sets the place ID of this period.
	 *
	 * @param placeId the place ID of this period
	 */
	public void setPlaceId(long placeId);

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
	public int compareTo(eu.strasbourg.service.place.model.Period period);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.place.model.Period> toCacheModel();

	@Override
	public eu.strasbourg.service.place.model.Period toEscapedModel();

	@Override
	public eu.strasbourg.service.place.model.Period toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}