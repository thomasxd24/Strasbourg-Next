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

package eu.strasbourg.service.gtfs.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.gtfs.model.Trip;
import eu.strasbourg.service.gtfs.model.TripModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Trip service. Represents a row in the &quot;gtfs_Trip&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TripModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TripImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see TripImpl
 * @generated
 */
@ProviderType
public class TripModelImpl extends BaseModelImpl<Trip> implements TripModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a trip model instance should use the <code>Trip</code> interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_Trip";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.BIGINT}, {"route_id", Types.VARCHAR},
		{"service_id", Types.VARCHAR}, {"trip_id", Types.VARCHAR},
		{"trip_headsign", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("route_id", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("service_id", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("trip_id", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("trip_headsign", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_Trip (id_ LONG not null primary key,route_id VARCHAR(75) null,service_id VARCHAR(75) null,trip_id VARCHAR(75) null,trip_headsign VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table gtfs_Trip";

	public static final String ORDER_BY_JPQL = " ORDER BY trip.trip_id ASC";

	public static final String ORDER_BY_SQL = " ORDER BY gtfs_Trip.trip_id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.gtfs.model.Trip"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.gtfs.model.Trip"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.gtfs.model.Trip"),
		true);

	public static final long ROUTE_ID_COLUMN_BITMASK = 1L;

	public static final long SERVICE_ID_COLUMN_BITMASK = 2L;

	public static final long TRIP_ID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.gtfs.model.Trip"));

	public TripModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Trip.class;
	}

	@Override
	public String getModelClassName() {
		return Trip.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Trip, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Trip, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Trip, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Trip)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Trip, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Trip, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Trip)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Trip, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Trip, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Trip>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Trip.class.getClassLoader(), Trip.class, ModelWrapper.class);

		try {
			Constructor<Trip> constructor =
				(Constructor<Trip>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Trip, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Trip, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Trip, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Trip, Object>>();
		Map<String, BiConsumer<Trip, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Trip, ?>>();

		attributeGetterFunctions.put(
			"id",
			new Function<Trip, Object>() {

				@Override
				public Object apply(Trip trip) {
					return trip.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<Trip, Object>() {

				@Override
				public void accept(Trip trip, Object id) {
					trip.setId((Long)id);
				}

			});
		attributeGetterFunctions.put(
			"route_id",
			new Function<Trip, Object>() {

				@Override
				public Object apply(Trip trip) {
					return trip.getRoute_id();
				}

			});
		attributeSetterBiConsumers.put(
			"route_id",
			new BiConsumer<Trip, Object>() {

				@Override
				public void accept(Trip trip, Object route_id) {
					trip.setRoute_id((String)route_id);
				}

			});
		attributeGetterFunctions.put(
			"service_id",
			new Function<Trip, Object>() {

				@Override
				public Object apply(Trip trip) {
					return trip.getService_id();
				}

			});
		attributeSetterBiConsumers.put(
			"service_id",
			new BiConsumer<Trip, Object>() {

				@Override
				public void accept(Trip trip, Object service_id) {
					trip.setService_id((String)service_id);
				}

			});
		attributeGetterFunctions.put(
			"trip_id",
			new Function<Trip, Object>() {

				@Override
				public Object apply(Trip trip) {
					return trip.getTrip_id();
				}

			});
		attributeSetterBiConsumers.put(
			"trip_id",
			new BiConsumer<Trip, Object>() {

				@Override
				public void accept(Trip trip, Object trip_id) {
					trip.setTrip_id((String)trip_id);
				}

			});
		attributeGetterFunctions.put(
			"trip_headsign",
			new Function<Trip, Object>() {

				@Override
				public Object apply(Trip trip) {
					return trip.getTrip_headsign();
				}

			});
		attributeSetterBiConsumers.put(
			"trip_headsign",
			new BiConsumer<Trip, Object>() {

				@Override
				public void accept(Trip trip, Object trip_headsign) {
					trip.setTrip_headsign((String)trip_headsign);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public String getRoute_id() {
		if (_route_id == null) {
			return "";
		}
		else {
			return _route_id;
		}
	}

	@Override
	public void setRoute_id(String route_id) {
		_columnBitmask |= ROUTE_ID_COLUMN_BITMASK;

		if (_originalRoute_id == null) {
			_originalRoute_id = _route_id;
		}

		_route_id = route_id;
	}

	public String getOriginalRoute_id() {
		return GetterUtil.getString(_originalRoute_id);
	}

	@Override
	public String getService_id() {
		if (_service_id == null) {
			return "";
		}
		else {
			return _service_id;
		}
	}

	@Override
	public void setService_id(String service_id) {
		_columnBitmask |= SERVICE_ID_COLUMN_BITMASK;

		if (_originalService_id == null) {
			_originalService_id = _service_id;
		}

		_service_id = service_id;
	}

	public String getOriginalService_id() {
		return GetterUtil.getString(_originalService_id);
	}

	@Override
	public String getTrip_id() {
		if (_trip_id == null) {
			return "";
		}
		else {
			return _trip_id;
		}
	}

	@Override
	public void setTrip_id(String trip_id) {
		_columnBitmask = -1L;

		if (_originalTrip_id == null) {
			_originalTrip_id = _trip_id;
		}

		_trip_id = trip_id;
	}

	public String getOriginalTrip_id() {
		return GetterUtil.getString(_originalTrip_id);
	}

	@Override
	public String getTrip_headsign() {
		if (_trip_headsign == null) {
			return "";
		}
		else {
			return _trip_headsign;
		}
	}

	@Override
	public void setTrip_headsign(String trip_headsign) {
		_trip_headsign = trip_headsign;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Trip.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Trip toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TripImpl tripImpl = new TripImpl();

		tripImpl.setId(getId());
		tripImpl.setRoute_id(getRoute_id());
		tripImpl.setService_id(getService_id());
		tripImpl.setTrip_id(getTrip_id());
		tripImpl.setTrip_headsign(getTrip_headsign());

		tripImpl.resetOriginalValues();

		return tripImpl;
	}

	@Override
	public int compareTo(Trip trip) {
		int value = 0;

		value = getTrip_id().compareTo(trip.getTrip_id());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Trip)) {
			return false;
		}

		Trip trip = (Trip)obj;

		long primaryKey = trip.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TripModelImpl tripModelImpl = this;

		tripModelImpl._originalRoute_id = tripModelImpl._route_id;

		tripModelImpl._originalService_id = tripModelImpl._service_id;

		tripModelImpl._originalTrip_id = tripModelImpl._trip_id;

		tripModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Trip> toCacheModel() {
		TripCacheModel tripCacheModel = new TripCacheModel();

		tripCacheModel.id = getId();

		tripCacheModel.route_id = getRoute_id();

		String route_id = tripCacheModel.route_id;

		if ((route_id != null) && (route_id.length() == 0)) {
			tripCacheModel.route_id = null;
		}

		tripCacheModel.service_id = getService_id();

		String service_id = tripCacheModel.service_id;

		if ((service_id != null) && (service_id.length() == 0)) {
			tripCacheModel.service_id = null;
		}

		tripCacheModel.trip_id = getTrip_id();

		String trip_id = tripCacheModel.trip_id;

		if ((trip_id != null) && (trip_id.length() == 0)) {
			tripCacheModel.trip_id = null;
		}

		tripCacheModel.trip_headsign = getTrip_headsign();

		String trip_headsign = tripCacheModel.trip_headsign;

		if ((trip_headsign != null) && (trip_headsign.length() == 0)) {
			tripCacheModel.trip_headsign = null;
		}

		return tripCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Trip, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Trip, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Trip, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Trip)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Trip, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Trip, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Trip, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Trip)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Trip>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _id;
	private String _route_id;
	private String _originalRoute_id;
	private String _service_id;
	private String _originalService_id;
	private String _trip_id;
	private String _originalTrip_id;
	private String _trip_headsign;
	private long _columnBitmask;
	private Trip _escapedModel;

}