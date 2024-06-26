/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model;

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
 * The base model interface for the Association service. Represents a row in the &quot;activity_Association&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.activity.model.impl.AssociationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.activity.model.impl.AssociationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Association
 * @generated
 */
@ProviderType
public interface AssociationModel
	extends BaseModel<Association>, GroupedModel, LocalizedModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a association model instance should use the {@link Association} interface instead.
	 */

	/**
	 * Returns the primary key of this association.
	 *
	 * @return the primary key of this association
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this association.
	 *
	 * @param primaryKey the primary key of this association
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this association.
	 *
	 * @return the uuid of this association
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this association.
	 *
	 * @param uuid the uuid of this association
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the association ID of this association.
	 *
	 * @return the association ID of this association
	 */
	public long getAssociationId();

	/**
	 * Sets the association ID of this association.
	 *
	 * @param associationId the association ID of this association
	 */
	public void setAssociationId(long associationId);

	/**
	 * Returns the group ID of this association.
	 *
	 * @return the group ID of this association
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this association.
	 *
	 * @param groupId the group ID of this association
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this association.
	 *
	 * @return the company ID of this association
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this association.
	 *
	 * @param companyId the company ID of this association
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this association.
	 *
	 * @return the user ID of this association
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this association.
	 *
	 * @param userId the user ID of this association
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this association.
	 *
	 * @return the user uuid of this association
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this association.
	 *
	 * @param userUuid the user uuid of this association
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this association.
	 *
	 * @return the user name of this association
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this association.
	 *
	 * @param userName the user name of this association
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this association.
	 *
	 * @return the create date of this association
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this association.
	 *
	 * @param createDate the create date of this association
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this association.
	 *
	 * @return the modified date of this association
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this association.
	 *
	 * @param modifiedDate the modified date of this association
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this association.
	 *
	 * @return the name of this association
	 */
	public String getName();

	/**
	 * Returns the localized name of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this association
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this association. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this association
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this association
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this association.
	 *
	 * @return the locales and localized names of this association
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this association.
	 *
	 * @param name the name of this association
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this association in the language.
	 *
	 * @param name the localized name of this association
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this association in the language, and sets the default locale.
	 *
	 * @param name the localized name of this association
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this association from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this association
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this association from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this association
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the presentation of this association.
	 *
	 * @return the presentation of this association
	 */
	public String getPresentation();

	/**
	 * Returns the localized presentation of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized presentation of this association
	 */
	@AutoEscape
	public String getPresentation(Locale locale);

	/**
	 * Returns the localized presentation of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized presentation of this association. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getPresentation(Locale locale, boolean useDefault);

	/**
	 * Returns the localized presentation of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized presentation of this association
	 */
	@AutoEscape
	public String getPresentation(String languageId);

	/**
	 * Returns the localized presentation of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized presentation of this association
	 */
	@AutoEscape
	public String getPresentation(String languageId, boolean useDefault);

	@AutoEscape
	public String getPresentationCurrentLanguageId();

	@AutoEscape
	public String getPresentationCurrentValue();

	/**
	 * Returns a map of the locales and localized presentations of this association.
	 *
	 * @return the locales and localized presentations of this association
	 */
	public Map<Locale, String> getPresentationMap();

	/**
	 * Sets the presentation of this association.
	 *
	 * @param presentation the presentation of this association
	 */
	public void setPresentation(String presentation);

	/**
	 * Sets the localized presentation of this association in the language.
	 *
	 * @param presentation the localized presentation of this association
	 * @param locale the locale of the language
	 */
	public void setPresentation(String presentation, Locale locale);

	/**
	 * Sets the localized presentation of this association in the language, and sets the default locale.
	 *
	 * @param presentation the localized presentation of this association
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setPresentation(
		String presentation, Locale locale, Locale defaultLocale);

	public void setPresentationCurrentLanguageId(String languageId);

	/**
	 * Sets the localized presentations of this association from the map of locales and localized presentations.
	 *
	 * @param presentationMap the locales and localized presentations of this association
	 */
	public void setPresentationMap(Map<Locale, String> presentationMap);

	/**
	 * Sets the localized presentations of this association from the map of locales and localized presentations, and sets the default locale.
	 *
	 * @param presentationMap the locales and localized presentations of this association
	 * @param defaultLocale the default locale
	 */
	public void setPresentationMap(
		Map<Locale, String> presentationMap, Locale defaultLocale);

	/**
	 * Returns the phone of this association.
	 *
	 * @return the phone of this association
	 */
	@AutoEscape
	public String getPhone();

	/**
	 * Sets the phone of this association.
	 *
	 * @param phone the phone of this association
	 */
	public void setPhone(String phone);

	/**
	 * Returns the site url of this association.
	 *
	 * @return the site url of this association
	 */
	public String getSiteURL();

	/**
	 * Returns the localized site url of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized site url of this association
	 */
	@AutoEscape
	public String getSiteURL(Locale locale);

	/**
	 * Returns the localized site url of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized site url of this association. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getSiteURL(Locale locale, boolean useDefault);

	/**
	 * Returns the localized site url of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized site url of this association
	 */
	@AutoEscape
	public String getSiteURL(String languageId);

	/**
	 * Returns the localized site url of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized site url of this association
	 */
	@AutoEscape
	public String getSiteURL(String languageId, boolean useDefault);

	@AutoEscape
	public String getSiteURLCurrentLanguageId();

	@AutoEscape
	public String getSiteURLCurrentValue();

	/**
	 * Returns a map of the locales and localized site urls of this association.
	 *
	 * @return the locales and localized site urls of this association
	 */
	public Map<Locale, String> getSiteURLMap();

	/**
	 * Sets the site url of this association.
	 *
	 * @param siteURL the site url of this association
	 */
	public void setSiteURL(String siteURL);

	/**
	 * Sets the localized site url of this association in the language.
	 *
	 * @param siteURL the localized site url of this association
	 * @param locale the locale of the language
	 */
	public void setSiteURL(String siteURL, Locale locale);

	/**
	 * Sets the localized site url of this association in the language, and sets the default locale.
	 *
	 * @param siteURL the localized site url of this association
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setSiteURL(String siteURL, Locale locale, Locale defaultLocale);

	public void setSiteURLCurrentLanguageId(String languageId);

	/**
	 * Sets the localized site urls of this association from the map of locales and localized site urls.
	 *
	 * @param siteURLMap the locales and localized site urls of this association
	 */
	public void setSiteURLMap(Map<Locale, String> siteURLMap);

	/**
	 * Sets the localized site urls of this association from the map of locales and localized site urls, and sets the default locale.
	 *
	 * @param siteURLMap the locales and localized site urls of this association
	 * @param defaultLocale the default locale
	 */
	public void setSiteURLMap(
		Map<Locale, String> siteURLMap, Locale defaultLocale);

	/**
	 * Returns the mail of this association.
	 *
	 * @return the mail of this association
	 */
	@AutoEscape
	public String getMail();

	/**
	 * Sets the mail of this association.
	 *
	 * @param mail the mail of this association
	 */
	public void setMail(String mail);

	/**
	 * Returns the facebook url of this association.
	 *
	 * @return the facebook url of this association
	 */
	public String getFacebookURL();

	/**
	 * Returns the localized facebook url of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized facebook url of this association
	 */
	@AutoEscape
	public String getFacebookURL(Locale locale);

	/**
	 * Returns the localized facebook url of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized facebook url of this association. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getFacebookURL(Locale locale, boolean useDefault);

	/**
	 * Returns the localized facebook url of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized facebook url of this association
	 */
	@AutoEscape
	public String getFacebookURL(String languageId);

	/**
	 * Returns the localized facebook url of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized facebook url of this association
	 */
	@AutoEscape
	public String getFacebookURL(String languageId, boolean useDefault);

	@AutoEscape
	public String getFacebookURLCurrentLanguageId();

	@AutoEscape
	public String getFacebookURLCurrentValue();

	/**
	 * Returns a map of the locales and localized facebook urls of this association.
	 *
	 * @return the locales and localized facebook urls of this association
	 */
	public Map<Locale, String> getFacebookURLMap();

	/**
	 * Sets the facebook url of this association.
	 *
	 * @param facebookURL the facebook url of this association
	 */
	public void setFacebookURL(String facebookURL);

	/**
	 * Sets the localized facebook url of this association in the language.
	 *
	 * @param facebookURL the localized facebook url of this association
	 * @param locale the locale of the language
	 */
	public void setFacebookURL(String facebookURL, Locale locale);

	/**
	 * Sets the localized facebook url of this association in the language, and sets the default locale.
	 *
	 * @param facebookURL the localized facebook url of this association
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setFacebookURL(
		String facebookURL, Locale locale, Locale defaultLocale);

	public void setFacebookURLCurrentLanguageId(String languageId);

	/**
	 * Sets the localized facebook urls of this association from the map of locales and localized facebook urls.
	 *
	 * @param facebookURLMap the locales and localized facebook urls of this association
	 */
	public void setFacebookURLMap(Map<Locale, String> facebookURLMap);

	/**
	 * Sets the localized facebook urls of this association from the map of locales and localized facebook urls, and sets the default locale.
	 *
	 * @param facebookURLMap the locales and localized facebook urls of this association
	 * @param defaultLocale the default locale
	 */
	public void setFacebookURLMap(
		Map<Locale, String> facebookURLMap, Locale defaultLocale);

	/**
	 * Returns the others informations of this association.
	 *
	 * @return the others informations of this association
	 */
	public String getOthersInformations();

	/**
	 * Returns the localized others informations of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized others informations of this association
	 */
	@AutoEscape
	public String getOthersInformations(Locale locale);

	/**
	 * Returns the localized others informations of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized others informations of this association. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getOthersInformations(Locale locale, boolean useDefault);

	/**
	 * Returns the localized others informations of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized others informations of this association
	 */
	@AutoEscape
	public String getOthersInformations(String languageId);

	/**
	 * Returns the localized others informations of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized others informations of this association
	 */
	@AutoEscape
	public String getOthersInformations(String languageId, boolean useDefault);

	@AutoEscape
	public String getOthersInformationsCurrentLanguageId();

	@AutoEscape
	public String getOthersInformationsCurrentValue();

	/**
	 * Returns a map of the locales and localized others informationses of this association.
	 *
	 * @return the locales and localized others informationses of this association
	 */
	public Map<Locale, String> getOthersInformationsMap();

	/**
	 * Sets the others informations of this association.
	 *
	 * @param othersInformations the others informations of this association
	 */
	public void setOthersInformations(String othersInformations);

	/**
	 * Sets the localized others informations of this association in the language.
	 *
	 * @param othersInformations the localized others informations of this association
	 * @param locale the locale of the language
	 */
	public void setOthersInformations(String othersInformations, Locale locale);

	/**
	 * Sets the localized others informations of this association in the language, and sets the default locale.
	 *
	 * @param othersInformations the localized others informations of this association
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setOthersInformations(
		String othersInformations, Locale locale, Locale defaultLocale);

	public void setOthersInformationsCurrentLanguageId(String languageId);

	/**
	 * Sets the localized others informationses of this association from the map of locales and localized others informationses.
	 *
	 * @param othersInformationsMap the locales and localized others informationses of this association
	 */
	public void setOthersInformationsMap(
		Map<Locale, String> othersInformationsMap);

	/**
	 * Sets the localized others informationses of this association from the map of locales and localized others informationses, and sets the default locale.
	 *
	 * @param othersInformationsMap the locales and localized others informationses of this association
	 * @param defaultLocale the default locale
	 */
	public void setOthersInformationsMap(
		Map<Locale, String> othersInformationsMap, Locale defaultLocale);

	/**
	 * Returns the status of this association.
	 *
	 * @return the status of this association
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this association.
	 *
	 * @param status the status of this association
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this association.
	 *
	 * @return the status by user ID of this association
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this association.
	 *
	 * @param statusByUserId the status by user ID of this association
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this association.
	 *
	 * @return the status by user uuid of this association
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this association.
	 *
	 * @param statusByUserUuid the status by user uuid of this association
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this association.
	 *
	 * @return the status by user name of this association
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this association.
	 *
	 * @param statusByUserName the status by user name of this association
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this association.
	 *
	 * @return the status date of this association
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this association.
	 *
	 * @param statusDate the status date of this association
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this association is approved.
	 *
	 * @return <code>true</code> if this association is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this association is denied.
	 *
	 * @return <code>true</code> if this association is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this association is a draft.
	 *
	 * @return <code>true</code> if this association is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this association is expired.
	 *
	 * @return <code>true</code> if this association is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this association is inactive.
	 *
	 * @return <code>true</code> if this association is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this association is incomplete.
	 *
	 * @return <code>true</code> if this association is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this association is pending.
	 *
	 * @return <code>true</code> if this association is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this association is scheduled.
	 *
	 * @return <code>true</code> if this association is scheduled; <code>false</code> otherwise
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
	public Association cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}