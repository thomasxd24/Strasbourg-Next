/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Agency service. Represents a row in the &quot;gtfs_Agency&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.gtfs.model.impl.AgencyModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.gtfs.model.impl.AgencyImpl</code>.
 * </p>
 *
 * @author Cedric Henry
 * @see Agency
 * @generated
 */
@ProviderType
public interface AgencyModel extends BaseModel<Agency> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a agency model instance should use the {@link Agency} interface instead.
	 */

	/**
	 * Returns the primary key of this agency.
	 *
	 * @return the primary key of this agency
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this agency.
	 *
	 * @param primaryKey the primary key of this agency
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this agency.
	 *
	 * @return the uuid of this agency
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this agency.
	 *
	 * @param uuid the uuid of this agency
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this agency.
	 *
	 * @return the ID of this agency
	 */
	public long getId();

	/**
	 * Sets the ID of this agency.
	 *
	 * @param id the ID of this agency
	 */
	public void setId(long id);

	/**
	 * Returns the agency_name of this agency.
	 *
	 * @return the agency_name of this agency
	 */
	@AutoEscape
	public String getAgency_name();

	/**
	 * Sets the agency_name of this agency.
	 *
	 * @param agency_name the agency_name of this agency
	 */
	public void setAgency_name(String agency_name);

	/**
	 * Returns the agency_url of this agency.
	 *
	 * @return the agency_url of this agency
	 */
	@AutoEscape
	public String getAgency_url();

	/**
	 * Sets the agency_url of this agency.
	 *
	 * @param agency_url the agency_url of this agency
	 */
	public void setAgency_url(String agency_url);

	/**
	 * Returns the agency_timezone of this agency.
	 *
	 * @return the agency_timezone of this agency
	 */
	@AutoEscape
	public String getAgency_timezone();

	/**
	 * Sets the agency_timezone of this agency.
	 *
	 * @param agency_timezone the agency_timezone of this agency
	 */
	public void setAgency_timezone(String agency_timezone);

	/**
	 * Returns the agency_phone of this agency.
	 *
	 * @return the agency_phone of this agency
	 */
	@AutoEscape
	public String getAgency_phone();

	/**
	 * Sets the agency_phone of this agency.
	 *
	 * @param agency_phone the agency_phone of this agency
	 */
	public void setAgency_phone(String agency_phone);

	/**
	 * Returns the agency_fare_url of this agency.
	 *
	 * @return the agency_fare_url of this agency
	 */
	@AutoEscape
	public String getAgency_fare_url();

	/**
	 * Sets the agency_fare_url of this agency.
	 *
	 * @param agency_fare_url the agency_fare_url of this agency
	 */
	public void setAgency_fare_url(String agency_fare_url);

	/**
	 * Returns the agency_lang of this agency.
	 *
	 * @return the agency_lang of this agency
	 */
	@AutoEscape
	public String getAgency_lang();

	/**
	 * Sets the agency_lang of this agency.
	 *
	 * @param agency_lang the agency_lang of this agency
	 */
	public void setAgency_lang(String agency_lang);

	@Override
	public Agency cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}