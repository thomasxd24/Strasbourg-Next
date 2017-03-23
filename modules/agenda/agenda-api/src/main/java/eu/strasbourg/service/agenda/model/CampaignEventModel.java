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

package eu.strasbourg.service.agenda.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the CampaignEvent service. Represents a row in the &quot;agenda_CampaignEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.agenda.model.impl.CampaignEventModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.agenda.model.impl.CampaignEventImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see CampaignEvent
 * @see eu.strasbourg.service.agenda.model.impl.CampaignEventImpl
 * @see eu.strasbourg.service.agenda.model.impl.CampaignEventModelImpl
 * @generated
 */
@ProviderType
public interface CampaignEventModel extends BaseModel<CampaignEvent>,
	LocalizedModel, ShardedModel, StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a campaign event model instance should use the {@link CampaignEvent} interface instead.
	 */

	/**
	 * Returns the primary key of this campaign event.
	 *
	 * @return the primary key of this campaign event
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this campaign event.
	 *
	 * @param primaryKey the primary key of this campaign event
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this campaign event.
	 *
	 * @return the uuid of this campaign event
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this campaign event.
	 *
	 * @param uuid the uuid of this campaign event
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the campaign event ID of this campaign event.
	 *
	 * @return the campaign event ID of this campaign event
	 */
	public long getCampaignEventId();

	/**
	 * Sets the campaign event ID of this campaign event.
	 *
	 * @param campaignEventId the campaign event ID of this campaign event
	 */
	public void setCampaignEventId(long campaignEventId);

	/**
	 * Returns the group ID of this campaign event.
	 *
	 * @return the group ID of this campaign event
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this campaign event.
	 *
	 * @param groupId the group ID of this campaign event
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this campaign event.
	 *
	 * @return the company ID of this campaign event
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this campaign event.
	 *
	 * @param companyId the company ID of this campaign event
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this campaign event.
	 *
	 * @return the user ID of this campaign event
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this campaign event.
	 *
	 * @param userId the user ID of this campaign event
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this campaign event.
	 *
	 * @return the user uuid of this campaign event
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this campaign event.
	 *
	 * @param userUuid the user uuid of this campaign event
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this campaign event.
	 *
	 * @return the user name of this campaign event
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this campaign event.
	 *
	 * @param userName the user name of this campaign event
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this campaign event.
	 *
	 * @return the create date of this campaign event
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this campaign event.
	 *
	 * @param createDate the create date of this campaign event
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this campaign event.
	 *
	 * @return the modified date of this campaign event
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this campaign event.
	 *
	 * @param modifiedDate the modified date of this campaign event
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the last publish date of this campaign event.
	 *
	 * @return the last publish date of this campaign event
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this campaign event.
	 *
	 * @param lastPublishDate the last publish date of this campaign event
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this campaign event.
	 *
	 * @return the status of this campaign event
	 */
	public int getStatus();

	/**
	 * Sets the status of this campaign event.
	 *
	 * @param status the status of this campaign event
	 */
	public void setStatus(int status);

	/**
	 * Returns the first name of this campaign event.
	 *
	 * @return the first name of this campaign event
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this campaign event.
	 *
	 * @param firstName the first name of this campaign event
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this campaign event.
	 *
	 * @return the last name of this campaign event
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this campaign event.
	 *
	 * @param lastName the last name of this campaign event
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the phone of this campaign event.
	 *
	 * @return the phone of this campaign event
	 */
	@AutoEscape
	public String getPhone();

	/**
	 * Sets the phone of this campaign event.
	 *
	 * @param phone the phone of this campaign event
	 */
	public void setPhone(String phone);

	/**
	 * Returns the email of this campaign event.
	 *
	 * @return the email of this campaign event
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this campaign event.
	 *
	 * @param email the email of this campaign event
	 */
	public void setEmail(String email);

	/**
	 * Returns the service ID of this campaign event.
	 *
	 * @return the service ID of this campaign event
	 */
	public Long getServiceId();

	/**
	 * Sets the service ID of this campaign event.
	 *
	 * @param serviceId the service ID of this campaign event
	 */
	public void setServiceId(Long serviceId);

	/**
	 * Returns the service of this campaign event.
	 *
	 * @return the service of this campaign event
	 */
	@AutoEscape
	public String getService();

	/**
	 * Sets the service of this campaign event.
	 *
	 * @param service the service of this campaign event
	 */
	public void setService(String service);

	/**
	 * Returns the on site first name of this campaign event.
	 *
	 * @return the on site first name of this campaign event
	 */
	@AutoEscape
	public String getOnSiteFirstName();

	/**
	 * Sets the on site first name of this campaign event.
	 *
	 * @param onSiteFirstName the on site first name of this campaign event
	 */
	public void setOnSiteFirstName(String onSiteFirstName);

	/**
	 * Returns the on site last name of this campaign event.
	 *
	 * @return the on site last name of this campaign event
	 */
	@AutoEscape
	public String getOnSiteLastName();

	/**
	 * Sets the on site last name of this campaign event.
	 *
	 * @param onSiteLastName the on site last name of this campaign event
	 */
	public void setOnSiteLastName(String onSiteLastName);

	/**
	 * Returns the on site phone of this campaign event.
	 *
	 * @return the on site phone of this campaign event
	 */
	@AutoEscape
	public String getOnSitePhone();

	/**
	 * Sets the on site phone of this campaign event.
	 *
	 * @param onSitePhone the on site phone of this campaign event
	 */
	public void setOnSitePhone(String onSitePhone);

	/**
	 * Returns the title of this campaign event.
	 *
	 * @return the title of this campaign event
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this campaign event
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this campaign event
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this campaign event
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this campaign event.
	 *
	 * @return the locales and localized titles of this campaign event
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this campaign event.
	 *
	 * @param title the title of this campaign event
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this campaign event in the language.
	 *
	 * @param title the localized title of this campaign event
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this campaign event in the language, and sets the default locale.
	 *
	 * @param title the localized title of this campaign event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this campaign event from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this campaign event
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this campaign event from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this campaign event
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the subtitle of this campaign event.
	 *
	 * @return the subtitle of this campaign event
	 */
	public String getSubtitle();

	/**
	 * Returns the localized subtitle of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized subtitle of this campaign event
	 */
	@AutoEscape
	public String getSubtitle(Locale locale);

	/**
	 * Returns the localized subtitle of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subtitle of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getSubtitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized subtitle of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized subtitle of this campaign event
	 */
	@AutoEscape
	public String getSubtitle(String languageId);

	/**
	 * Returns the localized subtitle of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subtitle of this campaign event
	 */
	@AutoEscape
	public String getSubtitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getSubtitleCurrentLanguageId();

	@AutoEscape
	public String getSubtitleCurrentValue();

	/**
	 * Returns a map of the locales and localized subtitles of this campaign event.
	 *
	 * @return the locales and localized subtitles of this campaign event
	 */
	public Map<Locale, String> getSubtitleMap();

	/**
	 * Sets the subtitle of this campaign event.
	 *
	 * @param subtitle the subtitle of this campaign event
	 */
	public void setSubtitle(String subtitle);

	/**
	 * Sets the localized subtitle of this campaign event in the language.
	 *
	 * @param subtitle the localized subtitle of this campaign event
	 * @param locale the locale of the language
	 */
	public void setSubtitle(String subtitle, Locale locale);

	/**
	 * Sets the localized subtitle of this campaign event in the language, and sets the default locale.
	 *
	 * @param subtitle the localized subtitle of this campaign event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setSubtitle(String subtitle, Locale locale, Locale defaultLocale);

	public void setSubtitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized subtitles of this campaign event from the map of locales and localized subtitles.
	 *
	 * @param subtitleMap the locales and localized subtitles of this campaign event
	 */
	public void setSubtitleMap(Map<Locale, String> subtitleMap);

	/**
	 * Sets the localized subtitles of this campaign event from the map of locales and localized subtitles, and sets the default locale.
	 *
	 * @param subtitleMap the locales and localized subtitles of this campaign event
	 * @param defaultLocale the default locale
	 */
	public void setSubtitleMap(Map<Locale, String> subtitleMap,
		Locale defaultLocale);

	/**
	 * Returns the description of this campaign event.
	 *
	 * @return the description of this campaign event
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this campaign event
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this campaign event
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this campaign event
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this campaign event.
	 *
	 * @return the locales and localized descriptions of this campaign event
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this campaign event.
	 *
	 * @param description the description of this campaign event
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this campaign event in the language.
	 *
	 * @param description the localized description of this campaign event
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this campaign event in the language, and sets the default locale.
	 *
	 * @param description the localized description of this campaign event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this campaign event from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this campaign event
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this campaign event from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this campaign event
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the image ID of this campaign event.
	 *
	 * @return the image ID of this campaign event
	 */
	public Long getImageId();

	/**
	 * Sets the image ID of this campaign event.
	 *
	 * @param imageId the image ID of this campaign event
	 */
	public void setImageId(Long imageId);

	/**
	 * Returns the web image ID of this campaign event.
	 *
	 * @return the web image ID of this campaign event
	 */
	public Long getWebImageId();

	/**
	 * Sets the web image ID of this campaign event.
	 *
	 * @param webImageId the web image ID of this campaign event
	 */
	public void setWebImageId(Long webImageId);

	/**
	 * Returns the image owner of this campaign event.
	 *
	 * @return the image owner of this campaign event
	 */
	@AutoEscape
	public String getImageOwner();

	/**
	 * Sets the image owner of this campaign event.
	 *
	 * @param imageOwner the image owner of this campaign event
	 */
	public void setImageOwner(String imageOwner);

	/**
	 * Returns the manifestations IDs of this campaign event.
	 *
	 * @return the manifestations IDs of this campaign event
	 */
	@AutoEscape
	public String getManifestationsIds();

	/**
	 * Sets the manifestations IDs of this campaign event.
	 *
	 * @param manifestationsIds the manifestations IDs of this campaign event
	 */
	public void setManifestationsIds(String manifestationsIds);

	/**
	 * Returns the place s i g ID of this campaign event.
	 *
	 * @return the place s i g ID of this campaign event
	 */
	@AutoEscape
	public String getPlaceSIGId();

	/**
	 * Sets the place s i g ID of this campaign event.
	 *
	 * @param placeSIGId the place s i g ID of this campaign event
	 */
	public void setPlaceSIGId(String placeSIGId);

	/**
	 * Returns the place name of this campaign event.
	 *
	 * @return the place name of this campaign event
	 */
	public String getPlaceName();

	/**
	 * Returns the localized place name of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized place name of this campaign event
	 */
	@AutoEscape
	public String getPlaceName(Locale locale);

	/**
	 * Returns the localized place name of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getPlaceName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized place name of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized place name of this campaign event
	 */
	@AutoEscape
	public String getPlaceName(String languageId);

	/**
	 * Returns the localized place name of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this campaign event
	 */
	@AutoEscape
	public String getPlaceName(String languageId, boolean useDefault);

	@AutoEscape
	public String getPlaceNameCurrentLanguageId();

	@AutoEscape
	public String getPlaceNameCurrentValue();

	/**
	 * Returns a map of the locales and localized place names of this campaign event.
	 *
	 * @return the locales and localized place names of this campaign event
	 */
	public Map<Locale, String> getPlaceNameMap();

	/**
	 * Sets the place name of this campaign event.
	 *
	 * @param placeName the place name of this campaign event
	 */
	public void setPlaceName(String placeName);

	/**
	 * Sets the localized place name of this campaign event in the language.
	 *
	 * @param placeName the localized place name of this campaign event
	 * @param locale the locale of the language
	 */
	public void setPlaceName(String placeName, Locale locale);

	/**
	 * Sets the localized place name of this campaign event in the language, and sets the default locale.
	 *
	 * @param placeName the localized place name of this campaign event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setPlaceName(String placeName, Locale locale,
		Locale defaultLocale);

	public void setPlaceNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized place names of this campaign event from the map of locales and localized place names.
	 *
	 * @param placeNameMap the locales and localized place names of this campaign event
	 */
	public void setPlaceNameMap(Map<Locale, String> placeNameMap);

	/**
	 * Sets the localized place names of this campaign event from the map of locales and localized place names, and sets the default locale.
	 *
	 * @param placeNameMap the locales and localized place names of this campaign event
	 * @param defaultLocale the default locale
	 */
	public void setPlaceNameMap(Map<Locale, String> placeNameMap,
		Locale defaultLocale);

	/**
	 * Returns the place street number of this campaign event.
	 *
	 * @return the place street number of this campaign event
	 */
	@AutoEscape
	public String getPlaceStreetNumber();

	/**
	 * Sets the place street number of this campaign event.
	 *
	 * @param placeStreetNumber the place street number of this campaign event
	 */
	public void setPlaceStreetNumber(String placeStreetNumber);

	/**
	 * Returns the place street name of this campaign event.
	 *
	 * @return the place street name of this campaign event
	 */
	@AutoEscape
	public String getPlaceStreetName();

	/**
	 * Sets the place street name of this campaign event.
	 *
	 * @param placeStreetName the place street name of this campaign event
	 */
	public void setPlaceStreetName(String placeStreetName);

	/**
	 * Returns the place zip code of this campaign event.
	 *
	 * @return the place zip code of this campaign event
	 */
	@AutoEscape
	public String getPlaceZipCode();

	/**
	 * Sets the place zip code of this campaign event.
	 *
	 * @param placeZipCode the place zip code of this campaign event
	 */
	public void setPlaceZipCode(String placeZipCode);

	/**
	 * Returns the place city ID of this campaign event.
	 *
	 * @return the place city ID of this campaign event
	 */
	public Long getPlaceCityId();

	/**
	 * Sets the place city ID of this campaign event.
	 *
	 * @param placeCityId the place city ID of this campaign event
	 */
	public void setPlaceCityId(Long placeCityId);

	/**
	 * Returns the place country of this campaign event.
	 *
	 * @return the place country of this campaign event
	 */
	@AutoEscape
	public String getPlaceCountry();

	/**
	 * Sets the place country of this campaign event.
	 *
	 * @param placeCountry the place country of this campaign event
	 */
	public void setPlaceCountry(String placeCountry);

	/**
	 * Returns the promoter of this campaign event.
	 *
	 * @return the promoter of this campaign event
	 */
	@AutoEscape
	public String getPromoter();

	/**
	 * Sets the promoter of this campaign event.
	 *
	 * @param promoter the promoter of this campaign event
	 */
	public void setPromoter(String promoter);

	/**
	 * Returns the public phone of this campaign event.
	 *
	 * @return the public phone of this campaign event
	 */
	@AutoEscape
	public String getPublicPhone();

	/**
	 * Sets the public phone of this campaign event.
	 *
	 * @param publicPhone the public phone of this campaign event
	 */
	public void setPublicPhone(String publicPhone);

	/**
	 * Returns the public email of this campaign event.
	 *
	 * @return the public email of this campaign event
	 */
	@AutoEscape
	public String getPublicEmail();

	/**
	 * Sets the public email of this campaign event.
	 *
	 * @param publicEmail the public email of this campaign event
	 */
	public void setPublicEmail(String publicEmail);

	/**
	 * Returns the website u r l of this campaign event.
	 *
	 * @return the website u r l of this campaign event
	 */
	public String getWebsiteURL();

	/**
	 * Returns the localized website u r l of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized website u r l of this campaign event
	 */
	@AutoEscape
	public String getWebsiteURL(Locale locale);

	/**
	 * Returns the localized website u r l of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized website u r l of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getWebsiteURL(Locale locale, boolean useDefault);

	/**
	 * Returns the localized website u r l of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized website u r l of this campaign event
	 */
	@AutoEscape
	public String getWebsiteURL(String languageId);

	/**
	 * Returns the localized website u r l of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized website u r l of this campaign event
	 */
	@AutoEscape
	public String getWebsiteURL(String languageId, boolean useDefault);

	@AutoEscape
	public String getWebsiteURLCurrentLanguageId();

	@AutoEscape
	public String getWebsiteURLCurrentValue();

	/**
	 * Returns a map of the locales and localized website u r ls of this campaign event.
	 *
	 * @return the locales and localized website u r ls of this campaign event
	 */
	public Map<Locale, String> getWebsiteURLMap();

	/**
	 * Sets the website u r l of this campaign event.
	 *
	 * @param websiteURL the website u r l of this campaign event
	 */
	public void setWebsiteURL(String websiteURL);

	/**
	 * Sets the localized website u r l of this campaign event in the language.
	 *
	 * @param websiteURL the localized website u r l of this campaign event
	 * @param locale the locale of the language
	 */
	public void setWebsiteURL(String websiteURL, Locale locale);

	/**
	 * Sets the localized website u r l of this campaign event in the language, and sets the default locale.
	 *
	 * @param websiteURL the localized website u r l of this campaign event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setWebsiteURL(String websiteURL, Locale locale,
		Locale defaultLocale);

	public void setWebsiteURLCurrentLanguageId(String languageId);

	/**
	 * Sets the localized website u r ls of this campaign event from the map of locales and localized website u r ls.
	 *
	 * @param websiteURLMap the locales and localized website u r ls of this campaign event
	 */
	public void setWebsiteURLMap(Map<Locale, String> websiteURLMap);

	/**
	 * Sets the localized website u r ls of this campaign event from the map of locales and localized website u r ls, and sets the default locale.
	 *
	 * @param websiteURLMap the locales and localized website u r ls of this campaign event
	 * @param defaultLocale the default locale
	 */
	public void setWebsiteURLMap(Map<Locale, String> websiteURLMap,
		Locale defaultLocale);

	/**
	 * Returns the free of this campaign event.
	 *
	 * @return the free of this campaign event
	 */
	public Integer getFree();

	/**
	 * Sets the free of this campaign event.
	 *
	 * @param free the free of this campaign event
	 */
	public void setFree(Integer free);

	/**
	 * Returns the price of this campaign event.
	 *
	 * @return the price of this campaign event
	 */
	public String getPrice();

	/**
	 * Returns the localized price of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized price of this campaign event
	 */
	@AutoEscape
	public String getPrice(Locale locale);

	/**
	 * Returns the localized price of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized price of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getPrice(Locale locale, boolean useDefault);

	/**
	 * Returns the localized price of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized price of this campaign event
	 */
	@AutoEscape
	public String getPrice(String languageId);

	/**
	 * Returns the localized price of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized price of this campaign event
	 */
	@AutoEscape
	public String getPrice(String languageId, boolean useDefault);

	@AutoEscape
	public String getPriceCurrentLanguageId();

	@AutoEscape
	public String getPriceCurrentValue();

	/**
	 * Returns a map of the locales and localized prices of this campaign event.
	 *
	 * @return the locales and localized prices of this campaign event
	 */
	public Map<Locale, String> getPriceMap();

	/**
	 * Sets the price of this campaign event.
	 *
	 * @param price the price of this campaign event
	 */
	public void setPrice(String price);

	/**
	 * Sets the localized price of this campaign event in the language.
	 *
	 * @param price the localized price of this campaign event
	 * @param locale the locale of the language
	 */
	public void setPrice(String price, Locale locale);

	/**
	 * Sets the localized price of this campaign event in the language, and sets the default locale.
	 *
	 * @param price the localized price of this campaign event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setPrice(String price, Locale locale, Locale defaultLocale);

	public void setPriceCurrentLanguageId(String languageId);

	/**
	 * Sets the localized prices of this campaign event from the map of locales and localized prices.
	 *
	 * @param priceMap the locales and localized prices of this campaign event
	 */
	public void setPriceMap(Map<Locale, String> priceMap);

	/**
	 * Sets the localized prices of this campaign event from the map of locales and localized prices, and sets the default locale.
	 *
	 * @param priceMap the locales and localized prices of this campaign event
	 * @param defaultLocale the default locale
	 */
	public void setPriceMap(Map<Locale, String> priceMap, Locale defaultLocale);

	/**
	 * Returns the campaign ID of this campaign event.
	 *
	 * @return the campaign ID of this campaign event
	 */
	public Long getCampaignId();

	/**
	 * Sets the campaign ID of this campaign event.
	 *
	 * @param campaignId the campaign ID of this campaign event
	 */
	public void setCampaignId(Long campaignId);

	/**
	 * Returns the theme ID of this campaign event.
	 *
	 * @return the theme ID of this campaign event
	 */
	public Long getThemeId();

	/**
	 * Sets the theme ID of this campaign event.
	 *
	 * @param themeId the theme ID of this campaign event
	 */
	public void setThemeId(Long themeId);

	/**
	 * Returns the type ID of this campaign event.
	 *
	 * @return the type ID of this campaign event
	 */
	public Long getTypeId();

	/**
	 * Sets the type ID of this campaign event.
	 *
	 * @param typeId the type ID of this campaign event
	 */
	public void setTypeId(Long typeId);

	/**
	 * Returns the publics IDs of this campaign event.
	 *
	 * @return the publics IDs of this campaign event
	 */
	@AutoEscape
	public String getPublicsIds();

	/**
	 * Sets the publics IDs of this campaign event.
	 *
	 * @param publicsIds the publics IDs of this campaign event
	 */
	public void setPublicsIds(String publicsIds);

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
		eu.strasbourg.service.agenda.model.CampaignEvent campaignEvent);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.agenda.model.CampaignEvent> toCacheModel();

	@Override
	public eu.strasbourg.service.agenda.model.CampaignEvent toEscapedModel();

	@Override
	public eu.strasbourg.service.agenda.model.CampaignEvent toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}