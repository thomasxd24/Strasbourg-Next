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

package eu.strasbourg.service.help.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the HelpProposal service. Represents a row in the &quot;help_HelpProposal&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.help.model.impl.HelpProposalModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.help.model.impl.HelpProposalImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HelpProposal
 * @generated
 */
@ProviderType
public interface HelpProposalModel
	extends BaseModel<HelpProposal>, GroupedModel, LocalizedModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a help proposal model instance should use the {@link HelpProposal} interface instead.
	 */

	/**
	 * Returns the primary key of this help proposal.
	 *
	 * @return the primary key of this help proposal
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this help proposal.
	 *
	 * @param primaryKey the primary key of this help proposal
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this help proposal.
	 *
	 * @return the uuid of this help proposal
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this help proposal.
	 *
	 * @param uuid the uuid of this help proposal
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the help proposal ID of this help proposal.
	 *
	 * @return the help proposal ID of this help proposal
	 */
	public long getHelpProposalId();

	/**
	 * Sets the help proposal ID of this help proposal.
	 *
	 * @param helpProposalId the help proposal ID of this help proposal
	 */
	public void setHelpProposalId(long helpProposalId);

	/**
	 * Returns the group ID of this help proposal.
	 *
	 * @return the group ID of this help proposal
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this help proposal.
	 *
	 * @param groupId the group ID of this help proposal
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this help proposal.
	 *
	 * @return the company ID of this help proposal
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this help proposal.
	 *
	 * @param companyId the company ID of this help proposal
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this help proposal.
	 *
	 * @return the user ID of this help proposal
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this help proposal.
	 *
	 * @param userId the user ID of this help proposal
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this help proposal.
	 *
	 * @return the user uuid of this help proposal
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this help proposal.
	 *
	 * @param userUuid the user uuid of this help proposal
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this help proposal.
	 *
	 * @return the user name of this help proposal
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this help proposal.
	 *
	 * @param userName the user name of this help proposal
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this help proposal.
	 *
	 * @return the create date of this help proposal
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this help proposal.
	 *
	 * @param createDate the create date of this help proposal
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this help proposal.
	 *
	 * @return the modified date of this help proposal
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this help proposal.
	 *
	 * @param modifiedDate the modified date of this help proposal
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this help proposal.
	 *
	 * @return the status of this help proposal
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this help proposal.
	 *
	 * @param status the status of this help proposal
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this help proposal.
	 *
	 * @return the status by user ID of this help proposal
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this help proposal.
	 *
	 * @param statusByUserId the status by user ID of this help proposal
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this help proposal.
	 *
	 * @return the status by user uuid of this help proposal
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this help proposal.
	 *
	 * @param statusByUserUuid the status by user uuid of this help proposal
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this help proposal.
	 *
	 * @return the status by user name of this help proposal
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this help proposal.
	 *
	 * @param statusByUserName the status by user name of this help proposal
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this help proposal.
	 *
	 * @return the status date of this help proposal
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this help proposal.
	 *
	 * @param statusDate the status date of this help proposal
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this help proposal.
	 *
	 * @return the title of this help proposal
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this help proposal in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this help proposal
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this help proposal in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this help proposal. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this help proposal in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this help proposal
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this help proposal in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this help proposal
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this help proposal.
	 *
	 * @return the locales and localized titles of this help proposal
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this help proposal.
	 *
	 * @param title the title of this help proposal
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this help proposal in the language.
	 *
	 * @param title the localized title of this help proposal
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this help proposal in the language, and sets the default locale.
	 *
	 * @param title the localized title of this help proposal
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this help proposal from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this help proposal
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this help proposal from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this help proposal
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the description of this help proposal.
	 *
	 * @return the description of this help proposal
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this help proposal in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this help proposal
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this help proposal in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this help proposal. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this help proposal in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this help proposal
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this help proposal in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this help proposal
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this help proposal.
	 *
	 * @return the locales and localized descriptions of this help proposal
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this help proposal.
	 *
	 * @param description the description of this help proposal
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this help proposal in the language.
	 *
	 * @param description the localized description of this help proposal
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this help proposal in the language, and sets the default locale.
	 *
	 * @param description the localized description of this help proposal
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(
		String description, Locale locale, Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this help proposal from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this help proposal
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this help proposal from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this help proposal
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale);

	/**
	 * Returns the in the name of of this help proposal.
	 *
	 * @return the in the name of of this help proposal
	 */
	@AutoEscape
	public String getInTheNameOf();

	/**
	 * Sets the in the name of of this help proposal.
	 *
	 * @param inTheNameOf the in the name of of this help proposal
	 */
	public void setInTheNameOf(String inTheNameOf);

	/**
	 * Returns the address of this help proposal.
	 *
	 * @return the address of this help proposal
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this help proposal.
	 *
	 * @param address the address of this help proposal
	 */
	public void setAddress(String address);

	/**
	 * Returns the city of this help proposal.
	 *
	 * @return the city of this help proposal
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this help proposal.
	 *
	 * @param city the city of this help proposal
	 */
	public void setCity(String city);

	/**
	 * Returns the postal code of this help proposal.
	 *
	 * @return the postal code of this help proposal
	 */
	public long getPostalCode();

	/**
	 * Sets the postal code of this help proposal.
	 *
	 * @param postalCode the postal code of this help proposal
	 */
	public void setPostalCode(long postalCode);

	/**
	 * Returns the phone number of this help proposal.
	 *
	 * @return the phone number of this help proposal
	 */
	@AutoEscape
	public String getPhoneNumber();

	/**
	 * Sets the phone number of this help proposal.
	 *
	 * @param phoneNumber the phone number of this help proposal
	 */
	public void setPhoneNumber(String phoneNumber);

	/**
	 * Returns the modified by user date of this help proposal.
	 *
	 * @return the modified by user date of this help proposal
	 */
	public Date getModifiedByUserDate();

	/**
	 * Sets the modified by user date of this help proposal.
	 *
	 * @param modifiedByUserDate the modified by user date of this help proposal
	 */
	public void setModifiedByUserDate(Date modifiedByUserDate);

	/**
	 * Returns the spoken languages of this help proposal.
	 *
	 * @return the spoken languages of this help proposal
	 */
	public String getSpokenLanguages();

	/**
	 * Returns the localized spoken languages of this help proposal in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized spoken languages of this help proposal
	 */
	@AutoEscape
	public String getSpokenLanguages(Locale locale);

	/**
	 * Returns the localized spoken languages of this help proposal in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized spoken languages of this help proposal. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getSpokenLanguages(Locale locale, boolean useDefault);

	/**
	 * Returns the localized spoken languages of this help proposal in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized spoken languages of this help proposal
	 */
	@AutoEscape
	public String getSpokenLanguages(String languageId);

	/**
	 * Returns the localized spoken languages of this help proposal in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized spoken languages of this help proposal
	 */
	@AutoEscape
	public String getSpokenLanguages(String languageId, boolean useDefault);

	@AutoEscape
	public String getSpokenLanguagesCurrentLanguageId();

	@AutoEscape
	public String getSpokenLanguagesCurrentValue();

	/**
	 * Returns a map of the locales and localized spoken languageses of this help proposal.
	 *
	 * @return the locales and localized spoken languageses of this help proposal
	 */
	public Map<Locale, String> getSpokenLanguagesMap();

	/**
	 * Sets the spoken languages of this help proposal.
	 *
	 * @param spokenLanguages the spoken languages of this help proposal
	 */
	public void setSpokenLanguages(String spokenLanguages);

	/**
	 * Sets the localized spoken languages of this help proposal in the language.
	 *
	 * @param spokenLanguages the localized spoken languages of this help proposal
	 * @param locale the locale of the language
	 */
	public void setSpokenLanguages(String spokenLanguages, Locale locale);

	/**
	 * Sets the localized spoken languages of this help proposal in the language, and sets the default locale.
	 *
	 * @param spokenLanguages the localized spoken languages of this help proposal
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setSpokenLanguages(
		String spokenLanguages, Locale locale, Locale defaultLocale);

	public void setSpokenLanguagesCurrentLanguageId(String languageId);

	/**
	 * Sets the localized spoken languageses of this help proposal from the map of locales and localized spoken languageses.
	 *
	 * @param spokenLanguagesMap the locales and localized spoken languageses of this help proposal
	 */
	public void setSpokenLanguagesMap(Map<Locale, String> spokenLanguagesMap);

	/**
	 * Sets the localized spoken languageses of this help proposal from the map of locales and localized spoken languageses, and sets the default locale.
	 *
	 * @param spokenLanguagesMap the locales and localized spoken languageses of this help proposal
	 * @param defaultLocale the default locale
	 */
	public void setSpokenLanguagesMap(
		Map<Locale, String> spokenLanguagesMap, Locale defaultLocale);

	/**
	 * Returns the image ID of this help proposal.
	 *
	 * @return the image ID of this help proposal
	 */
	public long getImageId();

	/**
	 * Sets the image ID of this help proposal.
	 *
	 * @param imageId the image ID of this help proposal
	 */
	public void setImageId(long imageId);

	/**
	 * Returns the publik ID of this help proposal.
	 *
	 * @return the publik ID of this help proposal
	 */
	@AutoEscape
	public String getPublikId();

	/**
	 * Sets the publik ID of this help proposal.
	 *
	 * @param publikId the publik ID of this help proposal
	 */
	public void setPublikId(String publikId);

	/**
	 * Returns the comment of this help proposal.
	 *
	 * @return the comment of this help proposal
	 */
	public String getComment();

	/**
	 * Returns the localized comment of this help proposal in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized comment of this help proposal
	 */
	@AutoEscape
	public String getComment(Locale locale);

	/**
	 * Returns the localized comment of this help proposal in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this help proposal. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getComment(Locale locale, boolean useDefault);

	/**
	 * Returns the localized comment of this help proposal in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized comment of this help proposal
	 */
	@AutoEscape
	public String getComment(String languageId);

	/**
	 * Returns the localized comment of this help proposal in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this help proposal
	 */
	@AutoEscape
	public String getComment(String languageId, boolean useDefault);

	@AutoEscape
	public String getCommentCurrentLanguageId();

	@AutoEscape
	public String getCommentCurrentValue();

	/**
	 * Returns a map of the locales and localized comments of this help proposal.
	 *
	 * @return the locales and localized comments of this help proposal
	 */
	public Map<Locale, String> getCommentMap();

	/**
	 * Sets the comment of this help proposal.
	 *
	 * @param comment the comment of this help proposal
	 */
	public void setComment(String comment);

	/**
	 * Sets the localized comment of this help proposal in the language.
	 *
	 * @param comment the localized comment of this help proposal
	 * @param locale the locale of the language
	 */
	public void setComment(String comment, Locale locale);

	/**
	 * Sets the localized comment of this help proposal in the language, and sets the default locale.
	 *
	 * @param comment the localized comment of this help proposal
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setComment(String comment, Locale locale, Locale defaultLocale);

	public void setCommentCurrentLanguageId(String languageId);

	/**
	 * Sets the localized comments of this help proposal from the map of locales and localized comments.
	 *
	 * @param commentMap the locales and localized comments of this help proposal
	 */
	public void setCommentMap(Map<Locale, String> commentMap);

	/**
	 * Sets the localized comments of this help proposal from the map of locales and localized comments, and sets the default locale.
	 *
	 * @param commentMap the locales and localized comments of this help proposal
	 * @param defaultLocale the default locale
	 */
	public void setCommentMap(
		Map<Locale, String> commentMap, Locale defaultLocale);

	/**
	 * Returns <code>true</code> if this help proposal is approved.
	 *
	 * @return <code>true</code> if this help proposal is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this help proposal is denied.
	 *
	 * @return <code>true</code> if this help proposal is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this help proposal is a draft.
	 *
	 * @return <code>true</code> if this help proposal is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this help proposal is expired.
	 *
	 * @return <code>true</code> if this help proposal is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this help proposal is inactive.
	 *
	 * @return <code>true</code> if this help proposal is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this help proposal is incomplete.
	 *
	 * @return <code>true</code> if this help proposal is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this help proposal is pending.
	 *
	 * @return <code>true</code> if this help proposal is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this help proposal is scheduled.
	 *
	 * @return <code>true</code> if this help proposal is scheduled; <code>false</code> otherwise
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

}