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

package eu.strasbourg.service.gtfs.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Stop service. Represents a row in the &quot;gtfs_Stop&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.gtfs.model.impl.StopModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.gtfs.model.impl.StopImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see Stop
 * @see eu.strasbourg.service.gtfs.model.impl.StopImpl
 * @see eu.strasbourg.service.gtfs.model.impl.StopModelImpl
 * @generated
 */
@ProviderType
public interface StopModel extends BaseModel<Stop> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a stop model instance should use the {@link Stop} interface instead.
	 */

	/**
	 * Returns the primary key of this stop.
	 *
	 * @return the primary key of this stop
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this stop.
	 *
	 * @param primaryKey the primary key of this stop
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this stop.
	 *
	 * @return the uuid of this stop
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this stop.
	 *
	 * @param uuid the uuid of this stop
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this stop.
	 *
	 * @return the ID of this stop
	 */
	public long getId();

	/**
	 * Sets the ID of this stop.
	 *
	 * @param id the ID of this stop
	 */
	public void setId(long id);

	/**
	 * Returns the stop_id of this stop.
	 *
	 * @return the stop_id of this stop
	 */
	@AutoEscape
	public String getStop_id();

	/**
	 * Sets the stop_id of this stop.
	 *
	 * @param stop_id the stop_id of this stop
	 */
	public void setStop_id(String stop_id);

	/**
	 * Returns the stop_code of this stop.
	 *
	 * @return the stop_code of this stop
	 */
	@AutoEscape
	public String getStop_code();

	/**
	 * Sets the stop_code of this stop.
	 *
	 * @param stop_code the stop_code of this stop
	 */
	public void setStop_code(String stop_code);

	/**
	 * Returns the stop_lat of this stop.
	 *
	 * @return the stop_lat of this stop
	 */
	public long getStop_lat();

	/**
	 * Sets the stop_lat of this stop.
	 *
	 * @param stop_lat the stop_lat of this stop
	 */
	public void setStop_lat(long stop_lat);

	/**
	 * Returns the stop_lon of this stop.
	 *
	 * @return the stop_lon of this stop
	 */
	public long getStop_lon();

	/**
	 * Sets the stop_lon of this stop.
	 *
	 * @param stop_lon the stop_lon of this stop
	 */
	public void setStop_lon(long stop_lon);

	/**
	 * Returns the stop_name of this stop.
	 *
	 * @return the stop_name of this stop
	 */
	@AutoEscape
	public String getStop_name();

	/**
	 * Sets the stop_name of this stop.
	 *
	 * @param stop_name the stop_name of this stop
	 */
	public void setStop_name(String stop_name);

	/**
	 * Returns the stop_url of this stop.
	 *
	 * @return the stop_url of this stop
	 */
	@AutoEscape
	public String getStop_url();

	/**
	 * Sets the stop_url of this stop.
	 *
	 * @param stop_url the stop_url of this stop
	 */
	public void setStop_url(String stop_url);

	/**
	 * Returns the stop_desc of this stop.
	 *
	 * @return the stop_desc of this stop
	 */
	@AutoEscape
	public String getStop_desc();

	/**
	 * Sets the stop_desc of this stop.
	 *
	 * @param stop_desc the stop_desc of this stop
	 */
	public void setStop_desc(String stop_desc);

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
	public Object clone();

	@Override
	public int compareTo(eu.strasbourg.service.gtfs.model.Stop stop);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.gtfs.model.Stop> toCacheModel();

	@Override
	public eu.strasbourg.service.gtfs.model.Stop toEscapedModel();

	@Override
	public eu.strasbourg.service.gtfs.model.Stop toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}