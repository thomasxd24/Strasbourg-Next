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

package eu.strasbourg.service.notif.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.notif.model.ServiceNotif;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ServiceNotif in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ServiceNotifCacheModel
	implements CacheModel<ServiceNotif>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceNotifCacheModel)) {
			return false;
		}

		ServiceNotifCacheModel serviceNotifCacheModel =
			(ServiceNotifCacheModel)obj;

		if (serviceId == serviceNotifCacheModel.serviceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, serviceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{serviceId=");
		sb.append(serviceId);
		sb.append(", organisationId=");
		sb.append(organisationId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", pictoId=");
		sb.append(pictoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceNotif toEntityModel() {
		ServiceNotifImpl serviceNotifImpl = new ServiceNotifImpl();

		serviceNotifImpl.setServiceId(serviceId);
		serviceNotifImpl.setOrganisationId(organisationId);

		if (name == null) {
			serviceNotifImpl.setName("");
		}
		else {
			serviceNotifImpl.setName(name);
		}

		serviceNotifImpl.setPictoId(pictoId);

		serviceNotifImpl.resetOriginalValues();

		return serviceNotifImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		serviceId = objectInput.readLong();

		organisationId = objectInput.readLong();
		name = objectInput.readUTF();

		pictoId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(serviceId);

		objectOutput.writeLong(organisationId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(pictoId);
	}

	public long serviceId;
	public long organisationId;
	public String name;
	public long pictoId;

}