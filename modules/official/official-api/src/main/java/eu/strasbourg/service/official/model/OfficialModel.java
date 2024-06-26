/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.official.model;

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
 * The base model interface for the Official service. Represents a row in the &quot;official_Official&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.official.model.impl.OfficialModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.official.model.impl.OfficialImpl</code>.
 * </p>
 *
 * @author AngeliqueZUNINO
 * @see Official
 * @generated
 */
@ProviderType
public interface OfficialModel
	extends BaseModel<Official>, LocalizedModel, ShardedModel,
			StagedGroupedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a official model instance should use the {@link Official} interface instead.
	 */

	/**
	 * Returns the primary key of this official.
	 *
	 * @return the primary key of this official
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this official.
	 *
	 * @param primaryKey the primary key of this official
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this official.
	 *
	 * @return the uuid of this official
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this official.
	 *
	 * @param uuid the uuid of this official
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the official ID of this official.
	 *
	 * @return the official ID of this official
	 */
	public long getOfficialId();

	/**
	 * Sets the official ID of this official.
	 *
	 * @param officialId the official ID of this official
	 */
	public void setOfficialId(long officialId);

	/**
	 * Returns the group ID of this official.
	 *
	 * @return the group ID of this official
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this official.
	 *
	 * @param groupId the group ID of this official
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this official.
	 *
	 * @return the company ID of this official
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this official.
	 *
	 * @param companyId the company ID of this official
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this official.
	 *
	 * @return the user ID of this official
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this official.
	 *
	 * @param userId the user ID of this official
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this official.
	 *
	 * @return the user uuid of this official
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this official.
	 *
	 * @param userUuid the user uuid of this official
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this official.
	 *
	 * @return the user name of this official
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this official.
	 *
	 * @param userName the user name of this official
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this official.
	 *
	 * @return the create date of this official
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this official.
	 *
	 * @param createDate the create date of this official
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this official.
	 *
	 * @return the modified date of this official
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this official.
	 *
	 * @param modifiedDate the modified date of this official
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the last publish date of this official.
	 *
	 * @return the last publish date of this official
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this official.
	 *
	 * @param lastPublishDate the last publish date of this official
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this official.
	 *
	 * @return the status of this official
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this official.
	 *
	 * @param status the status of this official
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this official.
	 *
	 * @return the status by user ID of this official
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this official.
	 *
	 * @param statusByUserId the status by user ID of this official
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this official.
	 *
	 * @return the status by user uuid of this official
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this official.
	 *
	 * @param statusByUserUuid the status by user uuid of this official
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this official.
	 *
	 * @return the status by user name of this official
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this official.
	 *
	 * @param statusByUserName the status by user name of this official
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this official.
	 *
	 * @return the status date of this official
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this official.
	 *
	 * @param statusDate the status date of this official
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the gender of this official.
	 *
	 * @return the gender of this official
	 */
	public int getGender();

	/**
	 * Sets the gender of this official.
	 *
	 * @param gender the gender of this official
	 */
	public void setGender(int gender);

	/**
	 * Returns the last name of this official.
	 *
	 * @return the last name of this official
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this official.
	 *
	 * @param lastName the last name of this official
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the first name of this official.
	 *
	 * @return the first name of this official
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this official.
	 *
	 * @param firstName the first name of this official
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the thematic delegation of this official.
	 *
	 * @return the thematic delegation of this official
	 */
	public String getThematicDelegation();

	/**
	 * Returns the localized thematic delegation of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized thematic delegation of this official
	 */
	@AutoEscape
	public String getThematicDelegation(Locale locale);

	/**
	 * Returns the localized thematic delegation of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized thematic delegation of this official. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getThematicDelegation(Locale locale, boolean useDefault);

	/**
	 * Returns the localized thematic delegation of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized thematic delegation of this official
	 */
	@AutoEscape
	public String getThematicDelegation(String languageId);

	/**
	 * Returns the localized thematic delegation of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized thematic delegation of this official
	 */
	@AutoEscape
	public String getThematicDelegation(String languageId, boolean useDefault);

	@AutoEscape
	public String getThematicDelegationCurrentLanguageId();

	@AutoEscape
	public String getThematicDelegationCurrentValue();

	/**
	 * Returns a map of the locales and localized thematic delegations of this official.
	 *
	 * @return the locales and localized thematic delegations of this official
	 */
	public Map<Locale, String> getThematicDelegationMap();

	/**
	 * Sets the thematic delegation of this official.
	 *
	 * @param thematicDelegation the thematic delegation of this official
	 */
	public void setThematicDelegation(String thematicDelegation);

	/**
	 * Sets the localized thematic delegation of this official in the language.
	 *
	 * @param thematicDelegation the localized thematic delegation of this official
	 * @param locale the locale of the language
	 */
	public void setThematicDelegation(String thematicDelegation, Locale locale);

	/**
	 * Sets the localized thematic delegation of this official in the language, and sets the default locale.
	 *
	 * @param thematicDelegation the localized thematic delegation of this official
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setThematicDelegation(
		String thematicDelegation, Locale locale, Locale defaultLocale);

	public void setThematicDelegationCurrentLanguageId(String languageId);

	/**
	 * Sets the localized thematic delegations of this official from the map of locales and localized thematic delegations.
	 *
	 * @param thematicDelegationMap the locales and localized thematic delegations of this official
	 */
	public void setThematicDelegationMap(
		Map<Locale, String> thematicDelegationMap);

	/**
	 * Sets the localized thematic delegations of this official from the map of locales and localized thematic delegations, and sets the default locale.
	 *
	 * @param thematicDelegationMap the locales and localized thematic delegations of this official
	 * @param defaultLocale the default locale
	 */
	public void setThematicDelegationMap(
		Map<Locale, String> thematicDelegationMap, Locale defaultLocale);

	/**
	 * Returns the missions of this official.
	 *
	 * @return the missions of this official
	 */
	public String getMissions();

	/**
	 * Returns the localized missions of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized missions of this official
	 */
	@AutoEscape
	public String getMissions(Locale locale);

	/**
	 * Returns the localized missions of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized missions of this official. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getMissions(Locale locale, boolean useDefault);

	/**
	 * Returns the localized missions of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized missions of this official
	 */
	@AutoEscape
	public String getMissions(String languageId);

	/**
	 * Returns the localized missions of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized missions of this official
	 */
	@AutoEscape
	public String getMissions(String languageId, boolean useDefault);

	@AutoEscape
	public String getMissionsCurrentLanguageId();

	@AutoEscape
	public String getMissionsCurrentValue();

	/**
	 * Returns a map of the locales and localized missionses of this official.
	 *
	 * @return the locales and localized missionses of this official
	 */
	public Map<Locale, String> getMissionsMap();

	/**
	 * Sets the missions of this official.
	 *
	 * @param missions the missions of this official
	 */
	public void setMissions(String missions);

	/**
	 * Sets the localized missions of this official in the language.
	 *
	 * @param missions the localized missions of this official
	 * @param locale the locale of the language
	 */
	public void setMissions(String missions, Locale locale);

	/**
	 * Sets the localized missions of this official in the language, and sets the default locale.
	 *
	 * @param missions the localized missions of this official
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setMissions(
		String missions, Locale locale, Locale defaultLocale);

	public void setMissionsCurrentLanguageId(String languageId);

	/**
	 * Sets the localized missionses of this official from the map of locales and localized missionses.
	 *
	 * @param missionsMap the locales and localized missionses of this official
	 */
	public void setMissionsMap(Map<Locale, String> missionsMap);

	/**
	 * Sets the localized missionses of this official from the map of locales and localized missionses, and sets the default locale.
	 *
	 * @param missionsMap the locales and localized missionses of this official
	 * @param defaultLocale the default locale
	 */
	public void setMissionsMap(
		Map<Locale, String> missionsMap, Locale defaultLocale);

	/**
	 * Returns the was minister of this official.
	 *
	 * @return the was minister of this official
	 */
	public boolean getWasMinister();

	/**
	 * Returns <code>true</code> if this official is was minister.
	 *
	 * @return <code>true</code> if this official is was minister; <code>false</code> otherwise
	 */
	public boolean isWasMinister();

	/**
	 * Sets whether this official is was minister.
	 *
	 * @param wasMinister the was minister of this official
	 */
	public void setWasMinister(boolean wasMinister);

	/**
	 * Returns the contact of this official.
	 *
	 * @return the contact of this official
	 */
	public String getContact();

	/**
	 * Returns the localized contact of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized contact of this official
	 */
	@AutoEscape
	public String getContact(Locale locale);

	/**
	 * Returns the localized contact of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized contact of this official. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getContact(Locale locale, boolean useDefault);

	/**
	 * Returns the localized contact of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized contact of this official
	 */
	@AutoEscape
	public String getContact(String languageId);

	/**
	 * Returns the localized contact of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized contact of this official
	 */
	@AutoEscape
	public String getContact(String languageId, boolean useDefault);

	@AutoEscape
	public String getContactCurrentLanguageId();

	@AutoEscape
	public String getContactCurrentValue();

	/**
	 * Returns a map of the locales and localized contacts of this official.
	 *
	 * @return the locales and localized contacts of this official
	 */
	public Map<Locale, String> getContactMap();

	/**
	 * Sets the contact of this official.
	 *
	 * @param contact the contact of this official
	 */
	public void setContact(String contact);

	/**
	 * Sets the localized contact of this official in the language.
	 *
	 * @param contact the localized contact of this official
	 * @param locale the locale of the language
	 */
	public void setContact(String contact, Locale locale);

	/**
	 * Sets the localized contact of this official in the language, and sets the default locale.
	 *
	 * @param contact the localized contact of this official
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setContact(String contact, Locale locale, Locale defaultLocale);

	public void setContactCurrentLanguageId(String languageId);

	/**
	 * Sets the localized contacts of this official from the map of locales and localized contacts.
	 *
	 * @param contactMap the locales and localized contacts of this official
	 */
	public void setContactMap(Map<Locale, String> contactMap);

	/**
	 * Sets the localized contacts of this official from the map of locales and localized contacts, and sets the default locale.
	 *
	 * @param contactMap the locales and localized contacts of this official
	 * @param defaultLocale the default locale
	 */
	public void setContactMap(
		Map<Locale, String> contactMap, Locale defaultLocale);

	/**
	 * Returns the order deputy mayor of this official.
	 *
	 * @return the order deputy mayor of this official
	 */
	public int getOrderDeputyMayor();

	/**
	 * Sets the order deputy mayor of this official.
	 *
	 * @param orderDeputyMayor the order deputy mayor of this official
	 */
	public void setOrderDeputyMayor(int orderDeputyMayor);

	/**
	 * Returns the order vice president of this official.
	 *
	 * @return the order vice president of this official
	 */
	public int getOrderVicePresident();

	/**
	 * Sets the order vice president of this official.
	 *
	 * @param orderVicePresident the order vice president of this official
	 */
	public void setOrderVicePresident(int orderVicePresident);

	/**
	 * Returns the liste contact of this official.
	 *
	 * @return the liste contact of this official
	 */
	@AutoEscape
	public String getListeContact();

	/**
	 * Sets the liste contact of this official.
	 *
	 * @param listeContact the liste contact of this official
	 */
	public void setListeContact(String listeContact);

	/**
	 * Returns the resume fonction of this official.
	 *
	 * @return the resume fonction of this official
	 */
	public String getResumeFonction();

	/**
	 * Returns the localized resume fonction of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized resume fonction of this official
	 */
	@AutoEscape
	public String getResumeFonction(Locale locale);

	/**
	 * Returns the localized resume fonction of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized resume fonction of this official. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getResumeFonction(Locale locale, boolean useDefault);

	/**
	 * Returns the localized resume fonction of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized resume fonction of this official
	 */
	@AutoEscape
	public String getResumeFonction(String languageId);

	/**
	 * Returns the localized resume fonction of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized resume fonction of this official
	 */
	@AutoEscape
	public String getResumeFonction(String languageId, boolean useDefault);

	@AutoEscape
	public String getResumeFonctionCurrentLanguageId();

	@AutoEscape
	public String getResumeFonctionCurrentValue();

	/**
	 * Returns a map of the locales and localized resume fonctions of this official.
	 *
	 * @return the locales and localized resume fonctions of this official
	 */
	public Map<Locale, String> getResumeFonctionMap();

	/**
	 * Sets the resume fonction of this official.
	 *
	 * @param resumeFonction the resume fonction of this official
	 */
	public void setResumeFonction(String resumeFonction);

	/**
	 * Sets the localized resume fonction of this official in the language.
	 *
	 * @param resumeFonction the localized resume fonction of this official
	 * @param locale the locale of the language
	 */
	public void setResumeFonction(String resumeFonction, Locale locale);

	/**
	 * Sets the localized resume fonction of this official in the language, and sets the default locale.
	 *
	 * @param resumeFonction the localized resume fonction of this official
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setResumeFonction(
		String resumeFonction, Locale locale, Locale defaultLocale);

	public void setResumeFonctionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized resume fonctions of this official from the map of locales and localized resume fonctions.
	 *
	 * @param resumeFonctionMap the locales and localized resume fonctions of this official
	 */
	public void setResumeFonctionMap(Map<Locale, String> resumeFonctionMap);

	/**
	 * Sets the localized resume fonctions of this official from the map of locales and localized resume fonctions, and sets the default locale.
	 *
	 * @param resumeFonctionMap the locales and localized resume fonctions of this official
	 * @param defaultLocale the default locale
	 */
	public void setResumeFonctionMap(
		Map<Locale, String> resumeFonctionMap, Locale defaultLocale);

	/**
	 * Returns the image ID of this official.
	 *
	 * @return the image ID of this official
	 */
	public Long getImageId();

	/**
	 * Sets the image ID of this official.
	 *
	 * @param imageId the image ID of this official
	 */
	public void setImageId(Long imageId);

	/**
	 * Returns <code>true</code> if this official is approved.
	 *
	 * @return <code>true</code> if this official is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this official is denied.
	 *
	 * @return <code>true</code> if this official is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this official is a draft.
	 *
	 * @return <code>true</code> if this official is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this official is expired.
	 *
	 * @return <code>true</code> if this official is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this official is inactive.
	 *
	 * @return <code>true</code> if this official is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this official is incomplete.
	 *
	 * @return <code>true</code> if this official is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this official is pending.
	 *
	 * @return <code>true</code> if this official is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this official is scheduled.
	 *
	 * @return <code>true</code> if this official is scheduled; <code>false</code> otherwise
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
	public Official cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}