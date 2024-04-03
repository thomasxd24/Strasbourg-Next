/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ScheduleException service. Represents a row in the &quot;place_ScheduleException&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.place.model.impl.ScheduleExceptionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.place.model.impl.ScheduleExceptionImpl</code>.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see ScheduleException
 * @generated
 */
@ProviderType
public interface ScheduleExceptionModel
	extends BaseModel<ScheduleException>, LocalizedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a schedule exception model instance should use the {@link ScheduleException} interface instead.
	 */

	/**
	 * Returns the primary key of this schedule exception.
	 *
	 * @return the primary key of this schedule exception
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this schedule exception.
	 *
	 * @param primaryKey the primary key of this schedule exception
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this schedule exception.
	 *
	 * @return the uuid of this schedule exception
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this schedule exception.
	 *
	 * @param uuid the uuid of this schedule exception
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the exception ID of this schedule exception.
	 *
	 * @return the exception ID of this schedule exception
	 */
	public long getExceptionId();

	/**
	 * Sets the exception ID of this schedule exception.
	 *
	 * @param exceptionId the exception ID of this schedule exception
	 */
	public void setExceptionId(long exceptionId);

	/**
	 * Returns the start date of this schedule exception.
	 *
	 * @return the start date of this schedule exception
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this schedule exception.
	 *
	 * @param startDate the start date of this schedule exception
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this schedule exception.
	 *
	 * @return the end date of this schedule exception
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this schedule exception.
	 *
	 * @param endDate the end date of this schedule exception
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the opening times of this schedule exception.
	 *
	 * @return the opening times of this schedule exception
	 */
	@AutoEscape
	public String getOpeningTimes();

	/**
	 * Sets the opening times of this schedule exception.
	 *
	 * @param openingTimes the opening times of this schedule exception
	 */
	public void setOpeningTimes(String openingTimes);

	/**
	 * Returns the first comment of this schedule exception.
	 *
	 * @return the first comment of this schedule exception
	 */
	public String getFirstComment();

	/**
	 * Returns the localized first comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized first comment of this schedule exception
	 */
	@AutoEscape
	public String getFirstComment(Locale locale);

	/**
	 * Returns the localized first comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized first comment of this schedule exception. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getFirstComment(Locale locale, boolean useDefault);

	/**
	 * Returns the localized first comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized first comment of this schedule exception
	 */
	@AutoEscape
	public String getFirstComment(String languageId);

	/**
	 * Returns the localized first comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized first comment of this schedule exception
	 */
	@AutoEscape
	public String getFirstComment(String languageId, boolean useDefault);

	@AutoEscape
	public String getFirstCommentCurrentLanguageId();

	@AutoEscape
	public String getFirstCommentCurrentValue();

	/**
	 * Returns a map of the locales and localized first comments of this schedule exception.
	 *
	 * @return the locales and localized first comments of this schedule exception
	 */
	public Map<Locale, String> getFirstCommentMap();

	/**
	 * Sets the first comment of this schedule exception.
	 *
	 * @param firstComment the first comment of this schedule exception
	 */
	public void setFirstComment(String firstComment);

	/**
	 * Sets the localized first comment of this schedule exception in the language.
	 *
	 * @param firstComment the localized first comment of this schedule exception
	 * @param locale the locale of the language
	 */
	public void setFirstComment(String firstComment, Locale locale);

	/**
	 * Sets the localized first comment of this schedule exception in the language, and sets the default locale.
	 *
	 * @param firstComment the localized first comment of this schedule exception
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setFirstComment(
		String firstComment, Locale locale, Locale defaultLocale);

	public void setFirstCommentCurrentLanguageId(String languageId);

	/**
	 * Sets the localized first comments of this schedule exception from the map of locales and localized first comments.
	 *
	 * @param firstCommentMap the locales and localized first comments of this schedule exception
	 */
	public void setFirstCommentMap(Map<Locale, String> firstCommentMap);

	/**
	 * Sets the localized first comments of this schedule exception from the map of locales and localized first comments, and sets the default locale.
	 *
	 * @param firstCommentMap the locales and localized first comments of this schedule exception
	 * @param defaultLocale the default locale
	 */
	public void setFirstCommentMap(
		Map<Locale, String> firstCommentMap, Locale defaultLocale);

	/**
	 * Returns the second comment of this schedule exception.
	 *
	 * @return the second comment of this schedule exception
	 */
	public String getSecondComment();

	/**
	 * Returns the localized second comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized second comment of this schedule exception
	 */
	@AutoEscape
	public String getSecondComment(Locale locale);

	/**
	 * Returns the localized second comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized second comment of this schedule exception. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getSecondComment(Locale locale, boolean useDefault);

	/**
	 * Returns the localized second comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized second comment of this schedule exception
	 */
	@AutoEscape
	public String getSecondComment(String languageId);

	/**
	 * Returns the localized second comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized second comment of this schedule exception
	 */
	@AutoEscape
	public String getSecondComment(String languageId, boolean useDefault);

	@AutoEscape
	public String getSecondCommentCurrentLanguageId();

	@AutoEscape
	public String getSecondCommentCurrentValue();

	/**
	 * Returns a map of the locales and localized second comments of this schedule exception.
	 *
	 * @return the locales and localized second comments of this schedule exception
	 */
	public Map<Locale, String> getSecondCommentMap();

	/**
	 * Sets the second comment of this schedule exception.
	 *
	 * @param secondComment the second comment of this schedule exception
	 */
	public void setSecondComment(String secondComment);

	/**
	 * Sets the localized second comment of this schedule exception in the language.
	 *
	 * @param secondComment the localized second comment of this schedule exception
	 * @param locale the locale of the language
	 */
	public void setSecondComment(String secondComment, Locale locale);

	/**
	 * Sets the localized second comment of this schedule exception in the language, and sets the default locale.
	 *
	 * @param secondComment the localized second comment of this schedule exception
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setSecondComment(
		String secondComment, Locale locale, Locale defaultLocale);

	public void setSecondCommentCurrentLanguageId(String languageId);

	/**
	 * Sets the localized second comments of this schedule exception from the map of locales and localized second comments.
	 *
	 * @param secondCommentMap the locales and localized second comments of this schedule exception
	 */
	public void setSecondCommentMap(Map<Locale, String> secondCommentMap);

	/**
	 * Sets the localized second comments of this schedule exception from the map of locales and localized second comments, and sets the default locale.
	 *
	 * @param secondCommentMap the locales and localized second comments of this schedule exception
	 * @param defaultLocale the default locale
	 */
	public void setSecondCommentMap(
		Map<Locale, String> secondCommentMap, Locale defaultLocale);

	/**
	 * Returns the third comment of this schedule exception.
	 *
	 * @return the third comment of this schedule exception
	 */
	public String getThirdComment();

	/**
	 * Returns the localized third comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized third comment of this schedule exception
	 */
	@AutoEscape
	public String getThirdComment(Locale locale);

	/**
	 * Returns the localized third comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized third comment of this schedule exception. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getThirdComment(Locale locale, boolean useDefault);

	/**
	 * Returns the localized third comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized third comment of this schedule exception
	 */
	@AutoEscape
	public String getThirdComment(String languageId);

	/**
	 * Returns the localized third comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized third comment of this schedule exception
	 */
	@AutoEscape
	public String getThirdComment(String languageId, boolean useDefault);

	@AutoEscape
	public String getThirdCommentCurrentLanguageId();

	@AutoEscape
	public String getThirdCommentCurrentValue();

	/**
	 * Returns a map of the locales and localized third comments of this schedule exception.
	 *
	 * @return the locales and localized third comments of this schedule exception
	 */
	public Map<Locale, String> getThirdCommentMap();

	/**
	 * Sets the third comment of this schedule exception.
	 *
	 * @param thirdComment the third comment of this schedule exception
	 */
	public void setThirdComment(String thirdComment);

	/**
	 * Sets the localized third comment of this schedule exception in the language.
	 *
	 * @param thirdComment the localized third comment of this schedule exception
	 * @param locale the locale of the language
	 */
	public void setThirdComment(String thirdComment, Locale locale);

	/**
	 * Sets the localized third comment of this schedule exception in the language, and sets the default locale.
	 *
	 * @param thirdComment the localized third comment of this schedule exception
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setThirdComment(
		String thirdComment, Locale locale, Locale defaultLocale);

	public void setThirdCommentCurrentLanguageId(String languageId);

	/**
	 * Sets the localized third comments of this schedule exception from the map of locales and localized third comments.
	 *
	 * @param thirdCommentMap the locales and localized third comments of this schedule exception
	 */
	public void setThirdCommentMap(Map<Locale, String> thirdCommentMap);

	/**
	 * Sets the localized third comments of this schedule exception from the map of locales and localized third comments, and sets the default locale.
	 *
	 * @param thirdCommentMap the locales and localized third comments of this schedule exception
	 * @param defaultLocale the default locale
	 */
	public void setThirdCommentMap(
		Map<Locale, String> thirdCommentMap, Locale defaultLocale);

	/**
	 * Returns the fourth comment of this schedule exception.
	 *
	 * @return the fourth comment of this schedule exception
	 */
	public String getFourthComment();

	/**
	 * Returns the localized fourth comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized fourth comment of this schedule exception
	 */
	@AutoEscape
	public String getFourthComment(Locale locale);

	/**
	 * Returns the localized fourth comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized fourth comment of this schedule exception. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getFourthComment(Locale locale, boolean useDefault);

	/**
	 * Returns the localized fourth comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized fourth comment of this schedule exception
	 */
	@AutoEscape
	public String getFourthComment(String languageId);

	/**
	 * Returns the localized fourth comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized fourth comment of this schedule exception
	 */
	@AutoEscape
	public String getFourthComment(String languageId, boolean useDefault);

	@AutoEscape
	public String getFourthCommentCurrentLanguageId();

	@AutoEscape
	public String getFourthCommentCurrentValue();

	/**
	 * Returns a map of the locales and localized fourth comments of this schedule exception.
	 *
	 * @return the locales and localized fourth comments of this schedule exception
	 */
	public Map<Locale, String> getFourthCommentMap();

	/**
	 * Sets the fourth comment of this schedule exception.
	 *
	 * @param fourthComment the fourth comment of this schedule exception
	 */
	public void setFourthComment(String fourthComment);

	/**
	 * Sets the localized fourth comment of this schedule exception in the language.
	 *
	 * @param fourthComment the localized fourth comment of this schedule exception
	 * @param locale the locale of the language
	 */
	public void setFourthComment(String fourthComment, Locale locale);

	/**
	 * Sets the localized fourth comment of this schedule exception in the language, and sets the default locale.
	 *
	 * @param fourthComment the localized fourth comment of this schedule exception
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setFourthComment(
		String fourthComment, Locale locale, Locale defaultLocale);

	public void setFourthCommentCurrentLanguageId(String languageId);

	/**
	 * Sets the localized fourth comments of this schedule exception from the map of locales and localized fourth comments.
	 *
	 * @param fourthCommentMap the locales and localized fourth comments of this schedule exception
	 */
	public void setFourthCommentMap(Map<Locale, String> fourthCommentMap);

	/**
	 * Sets the localized fourth comments of this schedule exception from the map of locales and localized fourth comments, and sets the default locale.
	 *
	 * @param fourthCommentMap the locales and localized fourth comments of this schedule exception
	 * @param defaultLocale the default locale
	 */
	public void setFourthCommentMap(
		Map<Locale, String> fourthCommentMap, Locale defaultLocale);

	/**
	 * Returns the fifth comment of this schedule exception.
	 *
	 * @return the fifth comment of this schedule exception
	 */
	public String getFifthComment();

	/**
	 * Returns the localized fifth comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized fifth comment of this schedule exception
	 */
	@AutoEscape
	public String getFifthComment(Locale locale);

	/**
	 * Returns the localized fifth comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized fifth comment of this schedule exception. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getFifthComment(Locale locale, boolean useDefault);

	/**
	 * Returns the localized fifth comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized fifth comment of this schedule exception
	 */
	@AutoEscape
	public String getFifthComment(String languageId);

	/**
	 * Returns the localized fifth comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized fifth comment of this schedule exception
	 */
	@AutoEscape
	public String getFifthComment(String languageId, boolean useDefault);

	@AutoEscape
	public String getFifthCommentCurrentLanguageId();

	@AutoEscape
	public String getFifthCommentCurrentValue();

	/**
	 * Returns a map of the locales and localized fifth comments of this schedule exception.
	 *
	 * @return the locales and localized fifth comments of this schedule exception
	 */
	public Map<Locale, String> getFifthCommentMap();

	/**
	 * Sets the fifth comment of this schedule exception.
	 *
	 * @param fifthComment the fifth comment of this schedule exception
	 */
	public void setFifthComment(String fifthComment);

	/**
	 * Sets the localized fifth comment of this schedule exception in the language.
	 *
	 * @param fifthComment the localized fifth comment of this schedule exception
	 * @param locale the locale of the language
	 */
	public void setFifthComment(String fifthComment, Locale locale);

	/**
	 * Sets the localized fifth comment of this schedule exception in the language, and sets the default locale.
	 *
	 * @param fifthComment the localized fifth comment of this schedule exception
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setFifthComment(
		String fifthComment, Locale locale, Locale defaultLocale);

	public void setFifthCommentCurrentLanguageId(String languageId);

	/**
	 * Sets the localized fifth comments of this schedule exception from the map of locales and localized fifth comments.
	 *
	 * @param fifthCommentMap the locales and localized fifth comments of this schedule exception
	 */
	public void setFifthCommentMap(Map<Locale, String> fifthCommentMap);

	/**
	 * Sets the localized fifth comments of this schedule exception from the map of locales and localized fifth comments, and sets the default locale.
	 *
	 * @param fifthCommentMap the locales and localized fifth comments of this schedule exception
	 * @param defaultLocale the default locale
	 */
	public void setFifthCommentMap(
		Map<Locale, String> fifthCommentMap, Locale defaultLocale);

	/**
	 * Returns the comment of this schedule exception.
	 *
	 * @return the comment of this schedule exception
	 */
	public String getComment();

	/**
	 * Returns the localized comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized comment of this schedule exception
	 */
	@AutoEscape
	public String getComment(Locale locale);

	/**
	 * Returns the localized comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this schedule exception. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getComment(Locale locale, boolean useDefault);

	/**
	 * Returns the localized comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized comment of this schedule exception
	 */
	@AutoEscape
	public String getComment(String languageId);

	/**
	 * Returns the localized comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this schedule exception
	 */
	@AutoEscape
	public String getComment(String languageId, boolean useDefault);

	@AutoEscape
	public String getCommentCurrentLanguageId();

	@AutoEscape
	public String getCommentCurrentValue();

	/**
	 * Returns a map of the locales and localized comments of this schedule exception.
	 *
	 * @return the locales and localized comments of this schedule exception
	 */
	public Map<Locale, String> getCommentMap();

	/**
	 * Sets the comment of this schedule exception.
	 *
	 * @param comment the comment of this schedule exception
	 */
	public void setComment(String comment);

	/**
	 * Sets the localized comment of this schedule exception in the language.
	 *
	 * @param comment the localized comment of this schedule exception
	 * @param locale the locale of the language
	 */
	public void setComment(String comment, Locale locale);

	/**
	 * Sets the localized comment of this schedule exception in the language, and sets the default locale.
	 *
	 * @param comment the localized comment of this schedule exception
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setComment(String comment, Locale locale, Locale defaultLocale);

	public void setCommentCurrentLanguageId(String languageId);

	/**
	 * Sets the localized comments of this schedule exception from the map of locales and localized comments.
	 *
	 * @param commentMap the locales and localized comments of this schedule exception
	 */
	public void setCommentMap(Map<Locale, String> commentMap);

	/**
	 * Sets the localized comments of this schedule exception from the map of locales and localized comments, and sets the default locale.
	 *
	 * @param commentMap the locales and localized comments of this schedule exception
	 * @param defaultLocale the default locale
	 */
	public void setCommentMap(
		Map<Locale, String> commentMap, Locale defaultLocale);

	/**
	 * Returns the closed of this schedule exception.
	 *
	 * @return the closed of this schedule exception
	 */
	public boolean getClosed();

	/**
	 * Returns <code>true</code> if this schedule exception is closed.
	 *
	 * @return <code>true</code> if this schedule exception is closed; <code>false</code> otherwise
	 */
	public boolean isClosed();

	/**
	 * Sets whether this schedule exception is closed.
	 *
	 * @param closed the closed of this schedule exception
	 */
	public void setClosed(boolean closed);

	/**
	 * Returns the place ID of this schedule exception.
	 *
	 * @return the place ID of this schedule exception
	 */
	public long getPlaceId();

	/**
	 * Sets the place ID of this schedule exception.
	 *
	 * @param placeId the place ID of this schedule exception
	 */
	public void setPlaceId(long placeId);

	/**
	 * Returns the sub place ID of this schedule exception.
	 *
	 * @return the sub place ID of this schedule exception
	 */
	public long getSubPlaceId();

	/**
	 * Sets the sub place ID of this schedule exception.
	 *
	 * @param subPlaceId the sub place ID of this schedule exception
	 */
	public void setSubPlaceId(long subPlaceId);

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
	public ScheduleException cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}