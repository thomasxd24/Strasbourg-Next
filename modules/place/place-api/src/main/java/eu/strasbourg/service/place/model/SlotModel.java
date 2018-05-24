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

package eu.strasbourg.service.place.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Slot service. Represents a row in the &quot;place_Slot&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.place.model.impl.SlotModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.place.model.impl.SlotImpl}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see Slot
 * @see eu.strasbourg.service.place.model.impl.SlotImpl
 * @see eu.strasbourg.service.place.model.impl.SlotModelImpl
 * @generated
 */
@ProviderType
public interface SlotModel extends BaseModel<Slot>, LocalizedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a slot model instance should use the {@link Slot} interface instead.
	 */

	/**
	 * Returns the primary key of this slot.
	 *
	 * @return the primary key of this slot
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this slot.
	 *
	 * @param primaryKey the primary key of this slot
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this slot.
	 *
	 * @return the uuid of this slot
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this slot.
	 *
	 * @param uuid the uuid of this slot
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the slot ID of this slot.
	 *
	 * @return the slot ID of this slot
	 */
	public long getSlotId();

	/**
	 * Sets the slot ID of this slot.
	 *
	 * @param slotId the slot ID of this slot
	 */
	public void setSlotId(long slotId);

	/**
	 * Returns the day of week of this slot.
	 *
	 * @return the day of week of this slot
	 */
	public long getDayOfWeek();

	/**
	 * Sets the day of week of this slot.
	 *
	 * @param dayOfWeek the day of week of this slot
	 */
	public void setDayOfWeek(long dayOfWeek);

	/**
	 * Returns the start hour of this slot.
	 *
	 * @return the start hour of this slot
	 */
	@AutoEscape
	public String getStartHour();

	/**
	 * Sets the start hour of this slot.
	 *
	 * @param startHour the start hour of this slot
	 */
	public void setStartHour(String startHour);

	/**
	 * Returns the end hour of this slot.
	 *
	 * @return the end hour of this slot
	 */
	@AutoEscape
	public String getEndHour();

	/**
	 * Sets the end hour of this slot.
	 *
	 * @param endHour the end hour of this slot
	 */
	public void setEndHour(String endHour);

	/**
	 * Returns the comment of this slot.
	 *
	 * @return the comment of this slot
	 */
	public String getComment();

	/**
	 * Returns the localized comment of this slot in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized comment of this slot
	 */
	@AutoEscape
	public String getComment(Locale locale);

	/**
	 * Returns the localized comment of this slot in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this slot. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getComment(Locale locale, boolean useDefault);

	/**
	 * Returns the localized comment of this slot in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized comment of this slot
	 */
	@AutoEscape
	public String getComment(String languageId);

	/**
	 * Returns the localized comment of this slot in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this slot
	 */
	@AutoEscape
	public String getComment(String languageId, boolean useDefault);

	@AutoEscape
	public String getCommentCurrentLanguageId();

	@AutoEscape
	public String getCommentCurrentValue();

	/**
	 * Returns a map of the locales and localized comments of this slot.
	 *
	 * @return the locales and localized comments of this slot
	 */
	public Map<Locale, String> getCommentMap();

	/**
	 * Sets the comment of this slot.
	 *
	 * @param comment the comment of this slot
	 */
	public void setComment(String comment);

	/**
	 * Sets the localized comment of this slot in the language.
	 *
	 * @param comment the localized comment of this slot
	 * @param locale the locale of the language
	 */
	public void setComment(String comment, Locale locale);

	/**
	 * Sets the localized comment of this slot in the language, and sets the default locale.
	 *
	 * @param comment the localized comment of this slot
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setComment(String comment, Locale locale, Locale defaultLocale);

	public void setCommentCurrentLanguageId(String languageId);

	/**
	 * Sets the localized comments of this slot from the map of locales and localized comments.
	 *
	 * @param commentMap the locales and localized comments of this slot
	 */
	public void setCommentMap(Map<Locale, String> commentMap);

	/**
	 * Sets the localized comments of this slot from the map of locales and localized comments, and sets the default locale.
	 *
	 * @param commentMap the locales and localized comments of this slot
	 * @param defaultLocale the default locale
	 */
	public void setCommentMap(Map<Locale, String> commentMap,
		Locale defaultLocale);

	/**
	 * Returns the period ID of this slot.
	 *
	 * @return the period ID of this slot
	 */
	public long getPeriodId();

	/**
	 * Sets the period ID of this slot.
	 *
	 * @param periodId the period ID of this slot
	 */
	public void setPeriodId(long periodId);

	/**
	 * Returns the sub place ID of this slot.
	 *
	 * @return the sub place ID of this slot
	 */
	public long getSubPlaceId();

	/**
	 * Sets the sub place ID of this slot.
	 *
	 * @param subPlaceId the sub place ID of this slot
	 */
	public void setSubPlaceId(long subPlaceId);

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
	public int compareTo(eu.strasbourg.service.place.model.Slot slot);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.place.model.Slot> toCacheModel();

	@Override
	public eu.strasbourg.service.place.model.Slot toEscapedModel();

	@Override
	public eu.strasbourg.service.place.model.Slot toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}