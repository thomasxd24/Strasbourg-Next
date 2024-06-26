/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.place.model.GoogleMyBusinessHistoric;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GoogleMyBusinessHistoric in entity cache.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class GoogleMyBusinessHistoricCacheModel
	implements CacheModel<GoogleMyBusinessHistoric>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GoogleMyBusinessHistoricCacheModel)) {
			return false;
		}

		GoogleMyBusinessHistoricCacheModel googleMyBusinessHistoricCacheModel =
			(GoogleMyBusinessHistoricCacheModel)object;

		if (googleMyBusinessHistoricId ==
				googleMyBusinessHistoricCacheModel.googleMyBusinessHistoricId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, googleMyBusinessHistoricId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", googleMyBusinessHistoricId=");
		sb.append(googleMyBusinessHistoricId);
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
		sb.append(", lastPublishDate=");
		sb.append(lastPublishDate);
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
	public GoogleMyBusinessHistoric toEntityModel() {
		GoogleMyBusinessHistoricImpl googleMyBusinessHistoricImpl =
			new GoogleMyBusinessHistoricImpl();

		if (uuid == null) {
			googleMyBusinessHistoricImpl.setUuid("");
		}
		else {
			googleMyBusinessHistoricImpl.setUuid(uuid);
		}

		googleMyBusinessHistoricImpl.setGoogleMyBusinessHistoricId(
			googleMyBusinessHistoricId);
		googleMyBusinessHistoricImpl.setGroupId(groupId);
		googleMyBusinessHistoricImpl.setCompanyId(companyId);
		googleMyBusinessHistoricImpl.setUserId(userId);

		if (userName == null) {
			googleMyBusinessHistoricImpl.setUserName("");
		}
		else {
			googleMyBusinessHistoricImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			googleMyBusinessHistoricImpl.setCreateDate(null);
		}
		else {
			googleMyBusinessHistoricImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			googleMyBusinessHistoricImpl.setModifiedDate(null);
		}
		else {
			googleMyBusinessHistoricImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			googleMyBusinessHistoricImpl.setLastPublishDate(null);
		}
		else {
			googleMyBusinessHistoricImpl.setLastPublishDate(
				new Date(lastPublishDate));
		}

		googleMyBusinessHistoricImpl.setStatus(status);
		googleMyBusinessHistoricImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			googleMyBusinessHistoricImpl.setStatusByUserName("");
		}
		else {
			googleMyBusinessHistoricImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			googleMyBusinessHistoricImpl.setStatusDate(null);
		}
		else {
			googleMyBusinessHistoricImpl.setStatusDate(new Date(statusDate));
		}

		googleMyBusinessHistoricImpl.setResult(result);

		if (operations == null) {
			googleMyBusinessHistoricImpl.setOperations("");
		}
		else {
			googleMyBusinessHistoricImpl.setOperations(operations);
		}

		if (errorDescription == null) {
			googleMyBusinessHistoricImpl.setErrorDescription("");
		}
		else {
			googleMyBusinessHistoricImpl.setErrorDescription(errorDescription);
		}

		if (errorStackTrace == null) {
			googleMyBusinessHistoricImpl.setErrorStackTrace("");
		}
		else {
			googleMyBusinessHistoricImpl.setErrorStackTrace(errorStackTrace);
		}

		if (startDate == Long.MIN_VALUE) {
			googleMyBusinessHistoricImpl.setStartDate(null);
		}
		else {
			googleMyBusinessHistoricImpl.setStartDate(new Date(startDate));
		}

		if (finishDate == Long.MIN_VALUE) {
			googleMyBusinessHistoricImpl.setFinishDate(null);
		}
		else {
			googleMyBusinessHistoricImpl.setFinishDate(new Date(finishDate));
		}

		googleMyBusinessHistoricImpl.resetOriginalValues();

		return googleMyBusinessHistoricImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		googleMyBusinessHistoricId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		lastPublishDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		result = objectInput.readInt();
		operations = (String)objectInput.readObject();
		errorDescription = (String)objectInput.readObject();
		errorStackTrace = (String)objectInput.readObject();
		startDate = objectInput.readLong();
		finishDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(googleMyBusinessHistoricId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(lastPublishDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeInt(result);

		if (operations == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(operations);
		}

		if (errorDescription == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(errorDescription);
		}

		if (errorStackTrace == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(errorStackTrace);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(finishDate);
	}

	public String uuid;
	public long googleMyBusinessHistoricId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long lastPublishDate;
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