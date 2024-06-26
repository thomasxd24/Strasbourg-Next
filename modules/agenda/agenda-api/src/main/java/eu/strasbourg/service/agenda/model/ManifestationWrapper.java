/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Manifestation}.
 * </p>
 *
 * @author BenjaminBini
 * @see Manifestation
 * @generated
 */
public class ManifestationWrapper
	extends BaseModelWrapper<Manifestation>
	implements Manifestation, ModelWrapper<Manifestation> {

	public ManifestationWrapper(Manifestation manifestation) {
		super(manifestation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("manifestationId", getManifestationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("lastPublishDate", getLastPublishDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("imageId", getImageId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("externalImageURL", getExternalImageURL());
		attributes.put("externalImageCopyright", getExternalImageCopyright());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("source", getSource());
		attributes.put("idSource", getIdSource());
		attributes.put("publicationDate", getPublicationDate());
		attributes.put("createDateSource", getCreateDateSource());
		attributes.put("modifiedDateSource", getModifiedDateSource());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long manifestationId = (Long)attributes.get("manifestationId");

		if (manifestationId != null) {
			setManifestationId(manifestationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String externalImageURL = (String)attributes.get("externalImageURL");

		if (externalImageURL != null) {
			setExternalImageURL(externalImageURL);
		}

		String externalImageCopyright = (String)attributes.get(
			"externalImageCopyright");

		if (externalImageCopyright != null) {
			setExternalImageCopyright(externalImageCopyright);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		String idSource = (String)attributes.get("idSource");

		if (idSource != null) {
			setIdSource(idSource);
		}

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}

		Date createDateSource = (Date)attributes.get("createDateSource");

		if (createDateSource != null) {
			setCreateDateSource(createDateSource);
		}

		Date modifiedDateSource = (Date)attributes.get("modifiedDateSource");

		if (modifiedDateSource != null) {
			setModifiedDateSource(modifiedDateSource);
		}
	}

	@Override
	public Manifestation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne l'AssetEntry rattachée cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the company ID of this manifestation.
	 *
	 * @return the company ID of this manifestation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this manifestation.
	 *
	 * @return the create date of this manifestation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the create date source of this manifestation.
	 *
	 * @return the create date source of this manifestation
	 */
	@Override
	public Date getCreateDateSource() {
		return model.getCreateDateSource();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this manifestation.
	 *
	 * @return the description of this manifestation
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this manifestation in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this manifestation
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this manifestation in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this manifestation. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this manifestation in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this manifestation
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this manifestation in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this manifestation
	 */
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return model.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return model.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return model.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this manifestation.
	 *
	 * @return the locales and localized descriptions of this manifestation
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the end date of this manifestation.
	 *
	 * @return the end date of this manifestation
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Renvoie la liste des éditions de la galerie
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.Event>
		getEvents() {

		return model.getEvents();
	}

	/**
	 * Renvoie la liste des ids des éditions de la galerie sous forme de String
	 */
	@Override
	public String getEventsIds() {
		return model.getEventsIds();
	}

	/**
	 * Returns the external image copyright of this manifestation.
	 *
	 * @return the external image copyright of this manifestation
	 */
	@Override
	public String getExternalImageCopyright() {
		return model.getExternalImageCopyright();
	}

	/**
	 * Returns the external image url of this manifestation.
	 *
	 * @return the external image url of this manifestation
	 */
	@Override
	public String getExternalImageURL() {
		return model.getExternalImageURL();
	}

	/**
	 * Returns the group ID of this manifestation.
	 *
	 * @return the group ID of this manifestation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the id source of this manifestation.
	 *
	 * @return the id source of this manifestation
	 */
	@Override
	public String getIdSource() {
		return model.getIdSource();
	}

	/**
	 * Retourne le copyright de l'image principale
	 */
	@Override
	public String getImageCopyright(java.util.Locale locale) {
		return model.getImageCopyright(locale);
	}

	/**
	 * Returns the image ID of this manifestation.
	 *
	 * @return the image ID of this manifestation
	 */
	@Override
	public Long getImageId() {
		return model.getImageId();
	}

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Returns the last publish date of this manifestation.
	 *
	 * @return the last publish date of this manifestation
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Renvoie la version live de la manifestation, si elle existe
	 */
	@Override
	public eu.strasbourg.service.agenda.model.Manifestation getLiveVersion() {
		return model.getLiveVersion();
	}

	/**
	 * Returns the manifestation ID of this manifestation.
	 *
	 * @return the manifestation ID of this manifestation
	 */
	@Override
	public long getManifestationId() {
		return model.getManifestationId();
	}

	/**
	 * Retourne la période principale de la manifestation sous forme de String
	 * dans la locale passée en paramètre
	 */
	@Override
	public String getManifestationScheduleDisplay(java.util.Locale locale) {
		return model.getManifestationScheduleDisplay(locale);
	}

	/**
	 * Returns the modified date of this manifestation.
	 *
	 * @return the modified date of this manifestation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the modified date source of this manifestation.
	 *
	 * @return the modified date source of this manifestation
	 */
	@Override
	public Date getModifiedDateSource() {
		return model.getModifiedDateSource();
	}

	/**
	 * Returns the primary key of this manifestation.
	 *
	 * @return the primary key of this manifestation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publication date of this manifestation.
	 *
	 * @return the publication date of this manifestation
	 */
	@Override
	public Date getPublicationDate() {
		return model.getPublicationDate();
	}

	/**
	 * Retourne le label des publics de l'événement
	 */
	@Override
	public String getPublicLabel(java.util.Locale locale) {
		return model.getPublicLabel(locale);
	}

	/**
	 * Retourne les publics de la manifestation
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getPublics() {

		return model.getPublics();
	}

	/**
	 * Renvoie la liste des éditions publiées de la galerie
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.Event>
		getPublishedEvents() {

		return model.getPublishedEvents();
	}

	/**
	 * Retourne les territoires de la manifestation
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getServices() {

		return model.getServices();
	}

	/**
	 * Returns the source of this manifestation.
	 *
	 * @return the source of this manifestation
	 */
	@Override
	public String getSource() {
		return model.getSource();
	}

	/**
	 * Returns the start date of this manifestation.
	 *
	 * @return the start date of this manifestation
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this manifestation.
	 *
	 * @return the status of this manifestation
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this manifestation.
	 *
	 * @return the status by user ID of this manifestation
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this manifestation.
	 *
	 * @return the status by user name of this manifestation
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this manifestation.
	 *
	 * @return the status by user uuid of this manifestation
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this manifestation.
	 *
	 * @return the status date of this manifestation
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Retourne le label des themes de l'événement
	 */
	@Override
	public String getThemeLabel(java.util.Locale locale) {
		return model.getThemeLabel(locale);
	}

	/**
	 * Retourne les themes de la manifestation
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThemes() {

		return model.getThemes();
	}

	/**
	 * Returns the title of this manifestation.
	 *
	 * @return the title of this manifestation
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this manifestation in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this manifestation
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this manifestation in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this manifestation. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this manifestation in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this manifestation
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this manifestation in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this manifestation
	 */
	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return model.getTitle(languageId, useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return model.getTitleCurrentLanguageId();
	}

	@Override
	public String getTitleCurrentValue() {
		return model.getTitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized titles of this manifestation.
	 *
	 * @return the locales and localized titles of this manifestation
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Retourne le label des types de l'événement
	 */
	@Override
	public String getTypeLabel(java.util.Locale locale) {
		return model.getTypeLabel(locale);
	}

	/**
	 * Retourne les types de la manifestation
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes() {

		return model.getTypes();
	}

	/**
	 * Returns the user ID of this manifestation.
	 *
	 * @return the user ID of this manifestation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this manifestation.
	 *
	 * @return the user name of this manifestation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this manifestation.
	 *
	 * @return the user uuid of this manifestation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this manifestation.
	 *
	 * @return the uuid of this manifestation
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this manifestation is approved.
	 *
	 * @return <code>true</code> if this manifestation is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this manifestation is denied.
	 *
	 * @return <code>true</code> if this manifestation is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this manifestation is a draft.
	 *
	 * @return <code>true</code> if this manifestation is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this manifestation is expired.
	 *
	 * @return <code>true</code> if this manifestation is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this manifestation is inactive.
	 *
	 * @return <code>true</code> if this manifestation is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this manifestation is incomplete.
	 *
	 * @return <code>true</code> if this manifestation is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this manifestation is pending.
	 *
	 * @return <code>true</code> if this manifestation is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this manifestation is scheduled.
	 *
	 * @return <code>true</code> if this manifestation is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the company ID of this manifestation.
	 *
	 * @param companyId the company ID of this manifestation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this manifestation.
	 *
	 * @param createDate the create date of this manifestation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the create date source of this manifestation.
	 *
	 * @param createDateSource the create date source of this manifestation
	 */
	@Override
	public void setCreateDateSource(Date createDateSource) {
		model.setCreateDateSource(createDateSource);
	}

	/**
	 * Sets the description of this manifestation.
	 *
	 * @param description the description of this manifestation
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this manifestation in the language.
	 *
	 * @param description the localized description of this manifestation
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this manifestation in the language, and sets the default locale.
	 *
	 * @param description the localized description of this manifestation
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescription(
		String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		model.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this manifestation from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this manifestation
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this manifestation from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this manifestation
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the end date of this manifestation.
	 *
	 * @param endDate the end date of this manifestation
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the external image copyright of this manifestation.
	 *
	 * @param externalImageCopyright the external image copyright of this manifestation
	 */
	@Override
	public void setExternalImageCopyright(String externalImageCopyright) {
		model.setExternalImageCopyright(externalImageCopyright);
	}

	/**
	 * Sets the external image url of this manifestation.
	 *
	 * @param externalImageURL the external image url of this manifestation
	 */
	@Override
	public void setExternalImageURL(String externalImageURL) {
		model.setExternalImageURL(externalImageURL);
	}

	/**
	 * Sets the group ID of this manifestation.
	 *
	 * @param groupId the group ID of this manifestation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the id source of this manifestation.
	 *
	 * @param idSource the id source of this manifestation
	 */
	@Override
	public void setIdSource(String idSource) {
		model.setIdSource(idSource);
	}

	/**
	 * Sets the image ID of this manifestation.
	 *
	 * @param imageId the image ID of this manifestation
	 */
	@Override
	public void setImageId(Long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the last publish date of this manifestation.
	 *
	 * @param lastPublishDate the last publish date of this manifestation
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the manifestation ID of this manifestation.
	 *
	 * @param manifestationId the manifestation ID of this manifestation
	 */
	@Override
	public void setManifestationId(long manifestationId) {
		model.setManifestationId(manifestationId);
	}

	/**
	 * Sets the modified date of this manifestation.
	 *
	 * @param modifiedDate the modified date of this manifestation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified date source of this manifestation.
	 *
	 * @param modifiedDateSource the modified date source of this manifestation
	 */
	@Override
	public void setModifiedDateSource(Date modifiedDateSource) {
		model.setModifiedDateSource(modifiedDateSource);
	}

	/**
	 * Sets the primary key of this manifestation.
	 *
	 * @param primaryKey the primary key of this manifestation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publication date of this manifestation.
	 *
	 * @param publicationDate the publication date of this manifestation
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		model.setPublicationDate(publicationDate);
	}

	/**
	 * Sets the source of this manifestation.
	 *
	 * @param source the source of this manifestation
	 */
	@Override
	public void setSource(String source) {
		model.setSource(source);
	}

	/**
	 * Sets the start date of this manifestation.
	 *
	 * @param startDate the start date of this manifestation
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this manifestation.
	 *
	 * @param status the status of this manifestation
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this manifestation.
	 *
	 * @param statusByUserId the status by user ID of this manifestation
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this manifestation.
	 *
	 * @param statusByUserName the status by user name of this manifestation
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this manifestation.
	 *
	 * @param statusByUserUuid the status by user uuid of this manifestation
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this manifestation.
	 *
	 * @param statusDate the status date of this manifestation
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this manifestation.
	 *
	 * @param title the title of this manifestation
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this manifestation in the language.
	 *
	 * @param title the localized title of this manifestation
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this manifestation in the language, and sets the default locale.
	 *
	 * @param title the localized title of this manifestation
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitle(
		String title, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		model.setTitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized titles of this manifestation from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this manifestation
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this manifestation from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this manifestation
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this manifestation.
	 *
	 * @param userId the user ID of this manifestation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this manifestation.
	 *
	 * @param userName the user name of this manifestation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this manifestation.
	 *
	 * @param userUuid the user uuid of this manifestation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this manifestation.
	 *
	 * @param uuid the uuid of this manifestation
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Renvoie la version JSON de la manifestation
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		return model.toJSON();
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ManifestationWrapper wrap(Manifestation manifestation) {
		return new ManifestationWrapper(manifestation);
	}

}