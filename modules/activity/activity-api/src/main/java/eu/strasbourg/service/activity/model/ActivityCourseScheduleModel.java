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

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ActivityCourseSchedule service. Represents a row in the &quot;activity_ActivityCourseSchedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourseSchedule
 * @generated
 */
@ProviderType
public interface ActivityCourseScheduleModel
	extends BaseModel<ActivityCourseSchedule>, GroupedModel, LocalizedModel,
			ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a activity course schedule model instance should use the {@link ActivityCourseSchedule} interface instead.
	 */

	/**
	 * Returns the primary key of this activity course schedule.
	 *
	 * @return the primary key of this activity course schedule
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this activity course schedule.
	 *
	 * @param primaryKey the primary key of this activity course schedule
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this activity course schedule.
	 *
	 * @return the uuid of this activity course schedule
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this activity course schedule.
	 *
	 * @param uuid the uuid of this activity course schedule
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the activity course schedule ID of this activity course schedule.
	 *
	 * @return the activity course schedule ID of this activity course schedule
	 */
	public long getActivityCourseScheduleId();

	/**
	 * Sets the activity course schedule ID of this activity course schedule.
	 *
	 * @param activityCourseScheduleId the activity course schedule ID of this activity course schedule
	 */
	public void setActivityCourseScheduleId(long activityCourseScheduleId);

	/**
	 * Returns the group ID of this activity course schedule.
	 *
	 * @return the group ID of this activity course schedule
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this activity course schedule.
	 *
	 * @param groupId the group ID of this activity course schedule
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this activity course schedule.
	 *
	 * @return the company ID of this activity course schedule
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this activity course schedule.
	 *
	 * @param companyId the company ID of this activity course schedule
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this activity course schedule.
	 *
	 * @return the user ID of this activity course schedule
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this activity course schedule.
	 *
	 * @param userId the user ID of this activity course schedule
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this activity course schedule.
	 *
	 * @return the user uuid of this activity course schedule
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this activity course schedule.
	 *
	 * @param userUuid the user uuid of this activity course schedule
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this activity course schedule.
	 *
	 * @return the user name of this activity course schedule
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this activity course schedule.
	 *
	 * @param userName the user name of this activity course schedule
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this activity course schedule.
	 *
	 * @return the create date of this activity course schedule
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this activity course schedule.
	 *
	 * @param createDate the create date of this activity course schedule
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this activity course schedule.
	 *
	 * @return the modified date of this activity course schedule
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this activity course schedule.
	 *
	 * @param modifiedDate the modified date of this activity course schedule
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the activity course place ID of this activity course schedule.
	 *
	 * @return the activity course place ID of this activity course schedule
	 */
	public long getActivityCoursePlaceId();

	/**
	 * Sets the activity course place ID of this activity course schedule.
	 *
	 * @param activityCoursePlaceId the activity course place ID of this activity course schedule
	 */
	public void setActivityCoursePlaceId(long activityCoursePlaceId);

	/**
	 * Returns the start time of this activity course schedule.
	 *
	 * @return the start time of this activity course schedule
	 */
	@AutoEscape
	public String getStartTime();

	/**
	 * Sets the start time of this activity course schedule.
	 *
	 * @param startTime the start time of this activity course schedule
	 */
	public void setStartTime(String startTime);

	/**
	 * Returns the end time of this activity course schedule.
	 *
	 * @return the end time of this activity course schedule
	 */
	@AutoEscape
	public String getEndTime();

	/**
	 * Sets the end time of this activity course schedule.
	 *
	 * @param endTime the end time of this activity course schedule
	 */
	public void setEndTime(String endTime);

	/**
	 * Returns the monday of this activity course schedule.
	 *
	 * @return the monday of this activity course schedule
	 */
	public boolean getMonday();

	/**
	 * Returns <code>true</code> if this activity course schedule is monday.
	 *
	 * @return <code>true</code> if this activity course schedule is monday; <code>false</code> otherwise
	 */
	public boolean isMonday();

	/**
	 * Sets whether this activity course schedule is monday.
	 *
	 * @param monday the monday of this activity course schedule
	 */
	public void setMonday(boolean monday);

	/**
	 * Returns the tuesday of this activity course schedule.
	 *
	 * @return the tuesday of this activity course schedule
	 */
	public boolean getTuesday();

	/**
	 * Returns <code>true</code> if this activity course schedule is tuesday.
	 *
	 * @return <code>true</code> if this activity course schedule is tuesday; <code>false</code> otherwise
	 */
	public boolean isTuesday();

	/**
	 * Sets whether this activity course schedule is tuesday.
	 *
	 * @param tuesday the tuesday of this activity course schedule
	 */
	public void setTuesday(boolean tuesday);

	/**
	 * Returns the wednesday of this activity course schedule.
	 *
	 * @return the wednesday of this activity course schedule
	 */
	public boolean getWednesday();

	/**
	 * Returns <code>true</code> if this activity course schedule is wednesday.
	 *
	 * @return <code>true</code> if this activity course schedule is wednesday; <code>false</code> otherwise
	 */
	public boolean isWednesday();

	/**
	 * Sets whether this activity course schedule is wednesday.
	 *
	 * @param wednesday the wednesday of this activity course schedule
	 */
	public void setWednesday(boolean wednesday);

	/**
	 * Returns the thursday of this activity course schedule.
	 *
	 * @return the thursday of this activity course schedule
	 */
	public boolean getThursday();

	/**
	 * Returns <code>true</code> if this activity course schedule is thursday.
	 *
	 * @return <code>true</code> if this activity course schedule is thursday; <code>false</code> otherwise
	 */
	public boolean isThursday();

	/**
	 * Sets whether this activity course schedule is thursday.
	 *
	 * @param thursday the thursday of this activity course schedule
	 */
	public void setThursday(boolean thursday);

	/**
	 * Returns the friday of this activity course schedule.
	 *
	 * @return the friday of this activity course schedule
	 */
	public boolean getFriday();

	/**
	 * Returns <code>true</code> if this activity course schedule is friday.
	 *
	 * @return <code>true</code> if this activity course schedule is friday; <code>false</code> otherwise
	 */
	public boolean isFriday();

	/**
	 * Sets whether this activity course schedule is friday.
	 *
	 * @param friday the friday of this activity course schedule
	 */
	public void setFriday(boolean friday);

	/**
	 * Returns the saturday of this activity course schedule.
	 *
	 * @return the saturday of this activity course schedule
	 */
	public boolean getSaturday();

	/**
	 * Returns <code>true</code> if this activity course schedule is saturday.
	 *
	 * @return <code>true</code> if this activity course schedule is saturday; <code>false</code> otherwise
	 */
	public boolean isSaturday();

	/**
	 * Sets whether this activity course schedule is saturday.
	 *
	 * @param saturday the saturday of this activity course schedule
	 */
	public void setSaturday(boolean saturday);

	/**
	 * Returns the sunday of this activity course schedule.
	 *
	 * @return the sunday of this activity course schedule
	 */
	public boolean getSunday();

	/**
	 * Returns <code>true</code> if this activity course schedule is sunday.
	 *
	 * @return <code>true</code> if this activity course schedule is sunday; <code>false</code> otherwise
	 */
	public boolean isSunday();

	/**
	 * Sets whether this activity course schedule is sunday.
	 *
	 * @param sunday the sunday of this activity course schedule
	 */
	public void setSunday(boolean sunday);

	/**
	 * Returns the comments of this activity course schedule.
	 *
	 * @return the comments of this activity course schedule
	 */
	public String getComments();

	/**
	 * Returns the localized comments of this activity course schedule in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized comments of this activity course schedule
	 */
	@AutoEscape
	public String getComments(Locale locale);

	/**
	 * Returns the localized comments of this activity course schedule in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comments of this activity course schedule. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getComments(Locale locale, boolean useDefault);

	/**
	 * Returns the localized comments of this activity course schedule in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized comments of this activity course schedule
	 */
	@AutoEscape
	public String getComments(String languageId);

	/**
	 * Returns the localized comments of this activity course schedule in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comments of this activity course schedule
	 */
	@AutoEscape
	public String getComments(String languageId, boolean useDefault);

	@AutoEscape
	public String getCommentsCurrentLanguageId();

	@AutoEscape
	public String getCommentsCurrentValue();

	/**
	 * Returns a map of the locales and localized commentses of this activity course schedule.
	 *
	 * @return the locales and localized commentses of this activity course schedule
	 */
	public Map<Locale, String> getCommentsMap();

	/**
	 * Sets the comments of this activity course schedule.
	 *
	 * @param comments the comments of this activity course schedule
	 */
	public void setComments(String comments);

	/**
	 * Sets the localized comments of this activity course schedule in the language.
	 *
	 * @param comments the localized comments of this activity course schedule
	 * @param locale the locale of the language
	 */
	public void setComments(String comments, Locale locale);

	/**
	 * Sets the localized comments of this activity course schedule in the language, and sets the default locale.
	 *
	 * @param comments the localized comments of this activity course schedule
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setComments(
		String comments, Locale locale, Locale defaultLocale);

	public void setCommentsCurrentLanguageId(String languageId);

	/**
	 * Sets the localized commentses of this activity course schedule from the map of locales and localized commentses.
	 *
	 * @param commentsMap the locales and localized commentses of this activity course schedule
	 */
	public void setCommentsMap(Map<Locale, String> commentsMap);

	/**
	 * Sets the localized commentses of this activity course schedule from the map of locales and localized commentses, and sets the default locale.
	 *
	 * @param commentsMap the locales and localized commentses of this activity course schedule
	 * @param defaultLocale the default locale
	 */
	public void setCommentsMap(
		Map<Locale, String> commentsMap, Locale defaultLocale);

	/**
	 * Returns the periods IDs of this activity course schedule.
	 *
	 * @return the periods IDs of this activity course schedule
	 */
	@AutoEscape
	public String getPeriodsIds();

	/**
	 * Sets the periods IDs of this activity course schedule.
	 *
	 * @param periodsIds the periods IDs of this activity course schedule
	 */
	public void setPeriodsIds(String periodsIds);

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
	public ActivityCourseSchedule cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}