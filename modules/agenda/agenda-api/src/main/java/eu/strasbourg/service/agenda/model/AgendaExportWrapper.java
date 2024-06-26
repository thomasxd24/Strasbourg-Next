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
 * This class is a wrapper for {@link AgendaExport}.
 * </p>
 *
 * @author BenjaminBini
 * @see AgendaExport
 * @generated
 */
public class AgendaExportWrapper
	extends BaseModelWrapper<AgendaExport>
	implements AgendaExport, ModelWrapper<AgendaExport> {

	public AgendaExportWrapper(AgendaExport agendaExport) {
		super(agendaExport);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("agendaExportId", getAgendaExportId());
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
		attributes.put("title", getTitle());
		attributes.put("language", getLanguage());
		attributes.put("exportFormat", getExportFormat());
		attributes.put("templateId", getTemplateId());
		attributes.put("eventCategories", getEventCategories());
		attributes.put("aggregations", getAggregations());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long agendaExportId = (Long)attributes.get("agendaExportId");

		if (agendaExportId != null) {
			setAgendaExportId(agendaExportId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String exportFormat = (String)attributes.get("exportFormat");

		if (exportFormat != null) {
			setExportFormat(exportFormat);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		String eventCategories = (String)attributes.get("eventCategories");

		if (eventCategories != null) {
			setEventCategories(eventCategories);
		}

		String aggregations = (String)attributes.get("aggregations");

		if (aggregations != null) {
			setAggregations(aggregations);
		}
	}

	@Override
	public AgendaExport cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the agenda export ID of this agenda export.
	 *
	 * @return the agenda export ID of this agenda export
	 */
	@Override
	public long getAgendaExportId() {
		return model.getAgendaExportId();
	}

	/**
	 * Retourne la liste des périodes auxquelles l'événement à lieu (classées par
	 * date de début croissante)
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.AgendaExportPeriod>
		getAgendaExportPeriods() {

		return model.getAgendaExportPeriods();
	}

	/**
	 * Returns the aggregations of this agenda export.
	 *
	 * @return the aggregations of this agenda export
	 */
	@Override
	public String getAggregations() {
		return model.getAggregations();
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
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
	 * Returns the company ID of this agenda export.
	 *
	 * @return the company ID of this agenda export
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this agenda export.
	 *
	 * @return the create date of this agenda export
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the event categories of this agenda export.
	 *
	 * @return the event categories of this agenda export
	 */
	@Override
	public String getEventCategories() {
		return model.getEventCategories();
	}

	/**
	 * Returns the export format of this agenda export.
	 *
	 * @return the export format of this agenda export
	 */
	@Override
	public String getExportFormat() {
		return model.getExportFormat();
	}

	/**
	 * Returns the group ID of this agenda export.
	 *
	 * @return the group ID of this agenda export
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the language of this agenda export.
	 *
	 * @return the language of this agenda export
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the last publish date of this agenda export.
	 *
	 * @return the last publish date of this agenda export
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Returns the modified date of this agenda export.
	 *
	 * @return the modified date of this agenda export
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this agenda export.
	 *
	 * @return the primary key of this agenda export
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this agenda export.
	 *
	 * @return the status of this agenda export
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this agenda export.
	 *
	 * @return the status by user ID of this agenda export
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this agenda export.
	 *
	 * @return the status by user name of this agenda export
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this agenda export.
	 *
	 * @return the status by user uuid of this agenda export
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this agenda export.
	 *
	 * @return the status date of this agenda export
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the template ID of this agenda export.
	 *
	 * @return the template ID of this agenda export
	 */
	@Override
	public long getTemplateId() {
		return model.getTemplateId();
	}

	/**
	 * Returns the title of this agenda export.
	 *
	 * @return the title of this agenda export
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this agenda export in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this agenda export
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this agenda export in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this agenda export. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this agenda export in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this agenda export
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this agenda export in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this agenda export
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
	 * Returns a map of the locales and localized titles of this agenda export.
	 *
	 * @return the locales and localized titles of this agenda export
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Returns the user ID of this agenda export.
	 *
	 * @return the user ID of this agenda export
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this agenda export.
	 *
	 * @return the user name of this agenda export
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this agenda export.
	 *
	 * @return the user uuid of this agenda export
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this agenda export.
	 *
	 * @return the uuid of this agenda export
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this agenda export is approved.
	 *
	 * @return <code>true</code> if this agenda export is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this agenda export is denied.
	 *
	 * @return <code>true</code> if this agenda export is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this agenda export is a draft.
	 *
	 * @return <code>true</code> if this agenda export is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this agenda export is expired.
	 *
	 * @return <code>true</code> if this agenda export is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this agenda export is inactive.
	 *
	 * @return <code>true</code> if this agenda export is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this agenda export is incomplete.
	 *
	 * @return <code>true</code> if this agenda export is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this agenda export is pending.
	 *
	 * @return <code>true</code> if this agenda export is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this agenda export is scheduled.
	 *
	 * @return <code>true</code> if this agenda export is scheduled; <code>false</code> otherwise
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
	 * Sets the agenda export ID of this agenda export.
	 *
	 * @param agendaExportId the agenda export ID of this agenda export
	 */
	@Override
	public void setAgendaExportId(long agendaExportId) {
		model.setAgendaExportId(agendaExportId);
	}

	/**
	 * Sets the aggregations of this agenda export.
	 *
	 * @param aggregations the aggregations of this agenda export
	 */
	@Override
	public void setAggregations(String aggregations) {
		model.setAggregations(aggregations);
	}

	/**
	 * Sets the company ID of this agenda export.
	 *
	 * @param companyId the company ID of this agenda export
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this agenda export.
	 *
	 * @param createDate the create date of this agenda export
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the event categories of this agenda export.
	 *
	 * @param eventCategories the event categories of this agenda export
	 */
	@Override
	public void setEventCategories(String eventCategories) {
		model.setEventCategories(eventCategories);
	}

	/**
	 * Sets the export format of this agenda export.
	 *
	 * @param exportFormat the export format of this agenda export
	 */
	@Override
	public void setExportFormat(String exportFormat) {
		model.setExportFormat(exportFormat);
	}

	/**
	 * Sets the group ID of this agenda export.
	 *
	 * @param groupId the group ID of this agenda export
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the language of this agenda export.
	 *
	 * @param language the language of this agenda export
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the last publish date of this agenda export.
	 *
	 * @param lastPublishDate the last publish date of this agenda export
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the modified date of this agenda export.
	 *
	 * @param modifiedDate the modified date of this agenda export
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this agenda export.
	 *
	 * @param primaryKey the primary key of this agenda export
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this agenda export.
	 *
	 * @param status the status of this agenda export
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this agenda export.
	 *
	 * @param statusByUserId the status by user ID of this agenda export
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this agenda export.
	 *
	 * @param statusByUserName the status by user name of this agenda export
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this agenda export.
	 *
	 * @param statusByUserUuid the status by user uuid of this agenda export
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this agenda export.
	 *
	 * @param statusDate the status date of this agenda export
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the template ID of this agenda export.
	 *
	 * @param templateId the template ID of this agenda export
	 */
	@Override
	public void setTemplateId(long templateId) {
		model.setTemplateId(templateId);
	}

	/**
	 * Sets the title of this agenda export.
	 *
	 * @param title the title of this agenda export
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this agenda export in the language.
	 *
	 * @param title the localized title of this agenda export
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this agenda export in the language, and sets the default locale.
	 *
	 * @param title the localized title of this agenda export
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
	 * Sets the localized titles of this agenda export from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this agenda export
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this agenda export from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this agenda export
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this agenda export.
	 *
	 * @param userId the user ID of this agenda export
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this agenda export.
	 *
	 * @param userName the user name of this agenda export
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this agenda export.
	 *
	 * @param userUuid the user uuid of this agenda export
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this agenda export.
	 *
	 * @param uuid the uuid of this agenda export
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
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
	protected AgendaExportWrapper wrap(AgendaExport agendaExport) {
		return new AgendaExportWrapper(agendaExport);
	}

}