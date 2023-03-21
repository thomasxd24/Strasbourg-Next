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

package eu.strasbourg.service.link.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Link service. Represents a row in the &quot;link_Link&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.link.model.impl.LinkModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.link.model.impl.LinkImpl</code>.
 * </p>
 *
 * @author BenjaminBini
 * @see Link
 * @generated
 */
@ProviderType
public interface LinkModel
	extends BaseModel<Link>, LocalizedModel, ShardedModel, StagedGroupedModel,
			WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a link model instance should use the {@link Link} interface instead.
	 */

	/**
	 * Returns the primary key of this link.
	 *
	 * @return the primary key of this link
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this link.
	 *
	 * @param primaryKey the primary key of this link
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this link.
	 *
	 * @return the uuid of this link
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this link.
	 *
	 * @param uuid the uuid of this link
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the link ID of this link.
	 *
	 * @return the link ID of this link
	 */
	public long getLinkId();

	/**
	 * Sets the link ID of this link.
	 *
	 * @param linkId the link ID of this link
	 */
	public void setLinkId(long linkId);

	/**
	 * Returns the group ID of this link.
	 *
	 * @return the group ID of this link
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this link.
	 *
	 * @param groupId the group ID of this link
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this link.
	 *
	 * @return the company ID of this link
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this link.
	 *
	 * @param companyId the company ID of this link
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this link.
	 *
	 * @return the user ID of this link
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this link.
	 *
	 * @param userId the user ID of this link
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this link.
	 *
	 * @return the user uuid of this link
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this link.
	 *
	 * @param userUuid the user uuid of this link
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this link.
	 *
	 * @return the user name of this link
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this link.
	 *
	 * @param userName the user name of this link
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this link.
	 *
	 * @return the create date of this link
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this link.
	 *
	 * @param createDate the create date of this link
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this link.
	 *
	 * @return the modified date of this link
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this link.
	 *
	 * @param modifiedDate the modified date of this link
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the last publish date of this link.
	 *
	 * @return the last publish date of this link
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this link.
	 *
	 * @param lastPublishDate the last publish date of this link
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this link.
	 *
	 * @return the status of this link
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this link.
	 *
	 * @param status the status of this link
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this link.
	 *
	 * @return the status by user ID of this link
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this link.
	 *
	 * @param statusByUserId the status by user ID of this link
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this link.
	 *
	 * @return the status by user uuid of this link
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this link.
	 *
	 * @param statusByUserUuid the status by user uuid of this link
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this link.
	 *
	 * @return the status by user name of this link
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this link.
	 *
	 * @param statusByUserName the status by user name of this link
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this link.
	 *
	 * @return the status date of this link
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this link.
	 *
	 * @param statusDate the status date of this link
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this link.
	 *
	 * @return the title of this link
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this link in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this link
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this link in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this link. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this link in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this link
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this link in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this link
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this link.
	 *
	 * @return the locales and localized titles of this link
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this link.
	 *
	 * @param title the title of this link
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this link in the language.
	 *
	 * @param title the localized title of this link
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this link in the language, and sets the default locale.
	 *
	 * @param title the localized title of this link
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this link from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this link
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this link from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this link
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the url of this link.
	 *
	 * @return the url of this link
	 */
	public String getURL();

	/**
	 * Returns the localized url of this link in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized url of this link
	 */
	@AutoEscape
	public String getURL(Locale locale);

	/**
	 * Returns the localized url of this link in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized url of this link. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getURL(Locale locale, boolean useDefault);

	/**
	 * Returns the localized url of this link in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized url of this link
	 */
	@AutoEscape
	public String getURL(String languageId);

	/**
	 * Returns the localized url of this link in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized url of this link
	 */
	@AutoEscape
	public String getURL(String languageId, boolean useDefault);

	@AutoEscape
	public String getURLCurrentLanguageId();

	@AutoEscape
	public String getURLCurrentValue();

	/**
	 * Returns a map of the locales and localized urls of this link.
	 *
	 * @return the locales and localized urls of this link
	 */
	public Map<Locale, String> getURLMap();

	/**
	 * Sets the url of this link.
	 *
	 * @param URL the url of this link
	 */
	public void setURL(String URL);

	/**
	 * Sets the localized url of this link in the language.
	 *
	 * @param URL the localized url of this link
	 * @param locale the locale of the language
	 */
	public void setURL(String URL, Locale locale);

	/**
	 * Sets the localized url of this link in the language, and sets the default locale.
	 *
	 * @param URL the localized url of this link
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setURL(String URL, Locale locale, Locale defaultLocale);

	public void setURLCurrentLanguageId(String languageId);

	/**
	 * Sets the localized urls of this link from the map of locales and localized urls.
	 *
	 * @param URLMap the locales and localized urls of this link
	 */
	public void setURLMap(Map<Locale, String> URLMap);

	/**
	 * Sets the localized urls of this link from the map of locales and localized urls, and sets the default locale.
	 *
	 * @param URLMap the locales and localized urls of this link
	 * @param defaultLocale the default locale
	 */
	public void setURLMap(Map<Locale, String> URLMap, Locale defaultLocale);

	/**
	 * Returns the hover text of this link.
	 *
	 * @return the hover text of this link
	 */
	public String getHoverText();

	/**
	 * Returns the localized hover text of this link in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized hover text of this link
	 */
	@AutoEscape
	public String getHoverText(Locale locale);

	/**
	 * Returns the localized hover text of this link in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized hover text of this link. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getHoverText(Locale locale, boolean useDefault);

	/**
	 * Returns the localized hover text of this link in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized hover text of this link
	 */
	@AutoEscape
	public String getHoverText(String languageId);

	/**
	 * Returns the localized hover text of this link in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized hover text of this link
	 */
	@AutoEscape
	public String getHoverText(String languageId, boolean useDefault);

	@AutoEscape
	public String getHoverTextCurrentLanguageId();

	@AutoEscape
	public String getHoverTextCurrentValue();

	/**
	 * Returns a map of the locales and localized hover texts of this link.
	 *
	 * @return the locales and localized hover texts of this link
	 */
	public Map<Locale, String> getHoverTextMap();

	/**
	 * Sets the hover text of this link.
	 *
	 * @param hoverText the hover text of this link
	 */
	public void setHoverText(String hoverText);

	/**
	 * Sets the localized hover text of this link in the language.
	 *
	 * @param hoverText the localized hover text of this link
	 * @param locale the locale of the language
	 */
	public void setHoverText(String hoverText, Locale locale);

	/**
	 * Sets the localized hover text of this link in the language, and sets the default locale.
	 *
	 * @param hoverText the localized hover text of this link
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setHoverText(
		String hoverText, Locale locale, Locale defaultLocale);

	public void setHoverTextCurrentLanguageId(String languageId);

	/**
	 * Sets the localized hover texts of this link from the map of locales and localized hover texts.
	 *
	 * @param hoverTextMap the locales and localized hover texts of this link
	 */
	public void setHoverTextMap(Map<Locale, String> hoverTextMap);

	/**
	 * Sets the localized hover texts of this link from the map of locales and localized hover texts, and sets the default locale.
	 *
	 * @param hoverTextMap the locales and localized hover texts of this link
	 * @param defaultLocale the default locale
	 */
	public void setHoverTextMap(
		Map<Locale, String> hoverTextMap, Locale defaultLocale);

	/**
	 * Returns <code>true</code> if this link is approved.
	 *
	 * @return <code>true</code> if this link is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this link is denied.
	 *
	 * @return <code>true</code> if this link is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this link is a draft.
	 *
	 * @return <code>true</code> if this link is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this link is expired.
	 *
	 * @return <code>true</code> if this link is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this link is inactive.
	 *
	 * @return <code>true</code> if this link is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this link is incomplete.
	 *
	 * @return <code>true</code> if this link is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this link is pending.
	 *
	 * @return <code>true</code> if this link is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this link is scheduled.
	 *
	 * @return <code>true</code> if this link is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

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
	public Link cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}