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

package eu.strasbourg.service.oidc.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import eu.strasbourg.service.oidc.model.AnonymisationHistoric;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AnonymisationHistoric in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymisationHistoric
 * @generated
 */
@ProviderType
public class AnonymisationHistoricCacheModel implements CacheModel<AnonymisationHistoric>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnonymisationHistoricCacheModel)) {
			return false;
		}

		AnonymisationHistoricCacheModel anonymisationHistoricCacheModel = (AnonymisationHistoricCacheModel)obj;

		if (anonymisationHistoricId == anonymisationHistoricCacheModel.anonymisationHistoricId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, anonymisationHistoricId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", anonymisationHistoricId=");
		sb.append(anonymisationHistoricId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", result=");
		sb.append(result);
		sb.append(", operations=");
		sb.append(operations);
		sb.append(", errorDescription=");
		sb.append(errorDescription);
		sb.append(", errorStackTrace=");
		sb.append(errorStackTrace);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", finishDate=");
		sb.append(finishDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnonymisationHistoric toEntityModel() {
		AnonymisationHistoricImpl anonymisationHistoricImpl = new AnonymisationHistoricImpl();

		if (uuid == null) {
			anonymisationHistoricImpl.setUuid(StringPool.BLANK);
		}
		else {
			anonymisationHistoricImpl.setUuid(uuid);
		}

		anonymisationHistoricImpl.setAnonymisationHistoricId(anonymisationHistoricId);
		anonymisationHistoricImpl.setGroupId(groupId);
		anonymisationHistoricImpl.setCompanyId(companyId);
		anonymisationHistoricImpl.setUserId(userId);

		if (userName == null) {
			anonymisationHistoricImpl.setUserName(StringPool.BLANK);
		}
		else {
			anonymisationHistoricImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			anonymisationHistoricImpl.setCreateDate(null);
		}
		else {
			anonymisationHistoricImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			anonymisationHistoricImpl.setModifiedDate(null);
		}
		else {
			anonymisationHistoricImpl.setModifiedDate(new Date(modifiedDate));
		}

		anonymisationHistoricImpl.setStatus(status);
		anonymisationHistoricImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			anonymisationHistoricImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			anonymisationHistoricImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			anonymisationHistoricImpl.setStatusDate(null);
		}
		else {
			anonymisationHistoricImpl.setStatusDate(new Date(statusDate));
		}

		anonymisationHistoricImpl.setResult(result);

		if (operations == null) {
			anonymisationHistoricImpl.setOperations(StringPool.BLANK);
		}
		else {
			anonymisationHistoricImpl.setOperations(operations);
		}

		if (errorDescription == null) {
			anonymisationHistoricImpl.setErrorDescription(StringPool.BLANK);
		}
		else {
			anonymisationHistoricImpl.setErrorDescription(errorDescription);
		}

		if (errorStackTrace == null) {
			anonymisationHistoricImpl.setErrorStackTrace(StringPool.BLANK);
		}
		else {
			anonymisationHistoricImpl.setErrorStackTrace(errorStackTrace);
		}

		if (startDate == Long.MIN_VALUE) {
			anonymisationHistoricImpl.setStartDate(null);
		}
		else {
			anonymisationHistoricImpl.setStartDate(new Date(startDate));
		}

		if (finishDate == Long.MIN_VALUE) {
			anonymisationHistoricImpl.setFinishDate(null);
		}
		else {
			anonymisationHistoricImpl.setFinishDate(new Date(finishDate));
		}

		anonymisationHistoricImpl.resetOriginalValues();

		return anonymisationHistoricImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		anonymisationHistoricId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		result = objectInput.readInt();
		operations = objectInput.readUTF();
		errorDescription = objectInput.readUTF();
		errorStackTrace = objectInput.readUTF();
		startDate = objectInput.readLong();
		finishDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(anonymisationHistoricId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeInt(result);

		if (operations == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(operations);
		}

		if (errorDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(errorDescription);
		}

		if (errorStackTrace == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(errorStackTrace);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(finishDate);
	}

	public String uuid;
	public long anonymisationHistoricId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public int result;
	public String operations;
	public String errorDescription;
	public String errorStackTrace;
	public long startDate;
	public long finishDate;
}