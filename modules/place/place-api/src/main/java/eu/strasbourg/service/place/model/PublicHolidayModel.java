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
 * The base model interface for the PublicHoliday service. Represents a row in the &quot;place_PublicHoliday&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.place.model.impl.PublicHolidayModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.place.model.impl.PublicHolidayImpl</code>.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see PublicHoliday
 * @generated
 */
@ProviderType
public interface PublicHolidayModel
	extends BaseModel<PublicHoliday>, LocalizedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a public holiday model instance should use the {@link PublicHoliday} interface instead.
	 */

	/**
	 * Returns the primary key of this public holiday.
	 *
	 * @return the primary key of this public holiday
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this public holiday.
	 *
	 * @param primaryKey the primary key of this public holiday
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this public holiday.
	 *
	 * @return the uuid of this public holiday
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this public holiday.
	 *
	 * @param uuid the uuid of this public holiday
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the public holiday ID of this public holiday.
	 *
	 * @return the public holiday ID of this public holiday
	 */
	public long getPublicHolidayId();

	/**
	 * Sets the public holiday ID of this public holiday.
	 *
	 * @param publicHolidayId the public holiday ID of this public holiday
	 */
	public void setPublicHolidayId(long publicHolidayId);

	/**
	 * Returns the name of this public holiday.
	 *
	 * @return the name of this public holiday
	 */
	public String getName();

	/**
	 * Returns the localized name of this public holiday in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this public holiday
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this public holiday in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this public holiday. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this public holiday in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this public holiday
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this public holiday in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this public holiday
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this public holiday.
	 *
	 * @return the locales and localized names of this public holiday
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this public holiday.
	 *
	 * @param name the name of this public holiday
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this public holiday in the language.
	 *
	 * @param name the localized name of this public holiday
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this public holiday in the language, and sets the default locale.
	 *
	 * @param name the localized name of this public holiday
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this public holiday from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this public holiday
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this public holiday from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this public holiday
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the date of this public holiday.
	 *
	 * @return the date of this public holiday
	 */
	public Date getDate();

	/**
	 * Sets the date of this public holiday.
	 *
	 * @param date the date of this public holiday
	 */
	public void setDate(Date date);

	/**
	 * Returns the recurrent of this public holiday.
	 *
	 * @return the recurrent of this public holiday
	 */
	public boolean getRecurrent();

	/**
	 * Returns <code>true</code> if this public holiday is recurrent.
	 *
	 * @return <code>true</code> if this public holiday is recurrent; <code>false</code> otherwise
	 */
	public boolean isRecurrent();

	/**
	 * Sets whether this public holiday is recurrent.
	 *
	 * @param recurrent the recurrent of this public holiday
	 */
	public void setRecurrent(boolean recurrent);

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
	public PublicHoliday cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}