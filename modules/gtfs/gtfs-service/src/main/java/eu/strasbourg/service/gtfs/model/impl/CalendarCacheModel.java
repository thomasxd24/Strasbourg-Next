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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.gtfs.model.Calendar;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Calendar in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
@ProviderType
public class CalendarCacheModel
	implements CacheModel<Calendar>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CalendarCacheModel)) {
			return false;
		}

		CalendarCacheModel calendarCacheModel = (CalendarCacheModel)obj;

		if (id == calendarCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", service_id=");
		sb.append(service_id);
		sb.append(", start_date=");
		sb.append(start_date);
		sb.append(", end_date=");
		sb.append(end_date);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Calendar toEntityModel() {
		CalendarImpl calendarImpl = new CalendarImpl();

		calendarImpl.setId(id);

		if (service_id == null) {
			calendarImpl.setService_id("");
		}
		else {
			calendarImpl.setService_id(service_id);
		}

		if (start_date == Long.MIN_VALUE) {
			calendarImpl.setStart_date(null);
		}
		else {
			calendarImpl.setStart_date(new Date(start_date));
		}

		if (end_date == Long.MIN_VALUE) {
			calendarImpl.setEnd_date(null);
		}
		else {
			calendarImpl.setEnd_date(new Date(end_date));
		}

		calendarImpl.resetOriginalValues();

		return calendarImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		service_id = objectInput.readUTF();
		start_date = objectInput.readLong();
		end_date = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (service_id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(service_id);
		}

		objectOutput.writeLong(start_date);
		objectOutput.writeLong(end_date);
	}

	public long id;
	public String service_id;
	public long start_date;
	public long end_date;

}