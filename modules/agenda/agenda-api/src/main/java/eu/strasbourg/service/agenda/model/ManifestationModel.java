/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

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
 * The base model interface for the Manifestation service. Represents a row in the &quot;agenda_Manifestation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.agenda.model.impl.ManifestationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.agenda.model.impl.ManifestationImpl</code>.
 * </p>
 *
 * @author BenjaminBini
 * @see Manifestation
 * @generated
 */
@ProviderType
public interface ManifestationModel
	extends BaseModel<Manifestation>, LocalizedModel, ShardedModel,
			StagedGroupedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a manifestation model instance should use the {@link Manifestation} interface instead.
	 */

	/**
	 * Returns the primary key of this manifestation.
	 *
	 * @return the primary key of this manifestation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this manifestation.
	 *
	 * @param primaryKey the primary key of this manifestation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this manifestation.
	 *
	 * @return the uuid of this manifestation
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this manifestation.
	 *
	 * @param uuid the uuid of this manifestation
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the manifestation ID of this manifestation.
	 *
	 * @return the manifestation ID of this manifestation
	 */
	public long getManifestationId();

	/**
	 * Sets the manifestation ID of this manifestation.
	 *
	 * @param manifestationId the manifestation ID of this manifestation
	 */
	public void setManifestationId(long manifestationId);

	/**
	 * Returns the group ID of this manifestation.
	 *
	 * @return the group ID of this manifestation
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this manifestation.
	 *
	 * @param groupId the group ID of this manifestation
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this manifestation.
	 *
	 * @return the company ID of this manifestation
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this manifestation.
	 *
	 * @param companyId the company ID of this manifestation
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this manifestation.
	 *
	 * @return the user ID of this manifestation
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this manifestation.
	 *
	 * @param userId the user ID of this manifestation
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this manifestation.
	 *
	 * @return the user uuid of this manifestation
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this manifestation.
	 *
	 * @param userUuid the user uuid of this manifestation
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this manifestation.
	 *
	 * @return the user name of this manifestation
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this manifestation.
	 *
	 * @param userName the user name of this manifestation
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this manifestation.
	 *
	 * @return the create date of this manifestation
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this manifestation.
	 *
	 * @param createDate the create date of this manifestation
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this manifestation.
	 *
	 * @return the modified date of this manifestation
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this manifestation.
	 *
	 * @param modifiedDate the modified date of this manifestation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the last publish date of this manifestation.
	 *
	 * @return the last publish date of this manifestation
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this manifestation.
	 *
	 * @param lastPublishDate the last publish date of this manifestation
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this manifestation.
	 *
	 * @return the status of this manifestation
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this manifestation.
	 *
	 * @param status the status of this manifestation
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this manifestation.
	 *
	 * @return the status by user ID of this manifestation
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this manifestation.
	 *
	 * @param statusByUserId the status by user ID of this manifestation
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this manifestation.
	 *
	 * @return the status by user uuid of this manifestation
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this manifestation.
	 *
	 * @param statusByUserUuid the status by user uuid of this manifestation
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this manifestation.
	 *
	 * @return the status by user name of this manifestation
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this manifestation.
	 *
	 * @param statusByUserName the status by user name of this manifestation
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this manifestation.
	 *
	 * @return the status date of this manifestation
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this manifestation.
	 *
	 * @param statusDate the status date of this manifestation
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the image ID of this manifestation.
	 *
	 * @return the image ID of this manifestation
	 */
	public Long getImageId();

	/**
	 * Sets the image ID of this manifestation.
	 *
	 * @param imageId the image ID of this manifestation
	 */
	public void setImageId(Long imageId);

	/**
	 * Returns the title of this manifestation.
	 *
	 * @return the title of this manifestation
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this manifestation in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this manifestation
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this manifestation in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this manifestation. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this manifestation in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this manifestation
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this manifestation in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this manifestation
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this manifestation.
	 *
	 * @return the locales and localized titles of this manifestation
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this manifestation.
	 *
	 * @param title the title of this manifestation
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this manifestation in the language.
	 *
	 * @param title the localized title of this manifestation
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this manifestation in the language, and sets the default locale.
	 *
	 * @param title the localized title of this manifestation
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this manifestation from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this manifestation
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this manifestation from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this manifestation
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the description of this manifestation.
	 *
	 * @return the description of this manifestation
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this manifestation in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this manifestation
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this manifestation in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this manifestation. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this manifestation in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this manifestation
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this manifestation in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this manifestation
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this manifestation.
	 *
	 * @return the locales and localized descriptions of this manifestation
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this manifestation.
	 *
	 * @param description the description of this manifestation
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this manifestation in the language.
	 *
	 * @param description the localized description of this manifestation
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this manifestation in the language, and sets the default locale.
	 *
	 * @param description the localized description of this manifestation
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(
		String description, Locale locale, Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this manifestation from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this manifestation
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this manifestation from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this manifestation
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale);

	/**
	 * Returns the external image url of this manifestation.
	 *
	 * @return the external image url of this manifestation
	 */
	@AutoEscape
	public String getExternalImageURL();

	/**
	 * Sets the external image url of this manifestation.
	 *
	 * @param externalImageURL the external image url of this manifestation
	 */
	public void setExternalImageURL(String externalImageURL);

	/**
	 * Returns the external image copyright of this manifestation.
	 *
	 * @return the external image copyright of this manifestation
	 */
	@AutoEscape
	public String getExternalImageCopyright();

	/**
	 * Sets the external image copyright of this manifestation.
	 *
	 * @param externalImageCopyright the external image copyright of this manifestation
	 */
	public void setExternalImageCopyright(String externalImageCopyright);

	/**
	 * Returns the start date of this manifestation.
	 *
	 * @return the start date of this manifestation
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this manifestation.
	 *
	 * @param startDate the start date of this manifestation
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this manifestation.
	 *
	 * @return the end date of this manifestation
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this manifestation.
	 *
	 * @param endDate the end date of this manifestation
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the source of this manifestation.
	 *
	 * @return the source of this manifestation
	 */
	@AutoEscape
	public String getSource();

	/**
	 * Sets the source of this manifestation.
	 *
	 * @param source the source of this manifestation
	 */
	public void setSource(String source);

	/**
	 * Returns the id source of this manifestation.
	 *
	 * @return the id source of this manifestation
	 */
	@AutoEscape
	public String getIdSource();

	/**
	 * Sets the id source of this manifestation.
	 *
	 * @param idSource the id source of this manifestation
	 */
	public void setIdSource(String idSource);

	/**
	 * Returns the publication date of this manifestation.
	 *
	 * @return the publication date of this manifestation
	 */
	public Date getPublicationDate();

	/**
	 * Sets the publication date of this manifestation.
	 *
	 * @param publicationDate the publication date of this manifestation
	 */
	public void setPublicationDate(Date publicationDate);

	/**
	 * Returns the create date source of this manifestation.
	 *
	 * @return the create date source of this manifestation
	 */
	public Date getCreateDateSource();

	/**
	 * Sets the create date source of this manifestation.
	 *
	 * @param createDateSource the create date source of this manifestation
	 */
	public void setCreateDateSource(Date createDateSource);

	/**
	 * Returns the modified date source of this manifestation.
	 *
	 * @return the modified date source of this manifestation
	 */
	public Date getModifiedDateSource();

	/**
	 * Sets the modified date source of this manifestation.
	 *
	 * @param modifiedDateSource the modified date source of this manifestation
	 */
	public void setModifiedDateSource(Date modifiedDateSource);

	/**
	 * Returns <code>true</code> if this manifestation is approved.
	 *
	 * @return <code>true</code> if this manifestation is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this manifestation is denied.
	 *
	 * @return <code>true</code> if this manifestation is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this manifestation is a draft.
	 *
	 * @return <code>true</code> if this manifestation is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this manifestation is expired.
	 *
	 * @return <code>true</code> if this manifestation is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this manifestation is inactive.
	 *
	 * @return <code>true</code> if this manifestation is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this manifestation is incomplete.
	 *
	 * @return <code>true</code> if this manifestation is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this manifestation is pending.
	 *
	 * @return <code>true</code> if this manifestation is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this manifestation is scheduled.
	 *
	 * @return <code>true</code> if this manifestation is scheduled; <code>false</code> otherwise
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
	public Manifestation cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}