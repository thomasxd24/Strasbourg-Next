/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.agenda.model.CampaignEventStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CampaignEventStatus in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class CampaignEventStatusCacheModel
	implements CacheModel<CampaignEventStatus>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CampaignEventStatusCacheModel)) {
			return false;
		}

		CampaignEventStatusCacheModel campaignEventStatusCacheModel =
			(CampaignEventStatusCacheModel)object;

		if (statusId == campaignEventStatusCacheModel.statusId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, statusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", statusId=");
		sb.append(statusId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", deletionDenied=");
		sb.append(deletionDenied);
		sb.append(", date=");
		sb.append(date);
		sb.append(", campaignEventId=");
		sb.append(campaignEventId);
		sb.append(", previousStatusId=");
		sb.append(previousStatusId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CampaignEventStatus toEntityModel() {
		CampaignEventStatusImpl campaignEventStatusImpl =
			new CampaignEventStatusImpl();

		if (uuid == null) {
			campaignEventStatusImpl.setUuid("");
		}
		else {
			campaignEventStatusImpl.setUuid(uuid);
		}

		campaignEventStatusImpl.setStatusId(statusId);
		campaignEventStatusImpl.setStatus(status);

		if (comment == null) {
			campaignEventStatusImpl.setComment("");
		}
		else {
			campaignEventStatusImpl.setComment(comment);
		}

		campaignEventStatusImpl.setDeletionDenied(deletionDenied);

		if (date == Long.MIN_VALUE) {
			campaignEventStatusImpl.setDate(null);
		}
		else {
			campaignEventStatusImpl.setDate(new Date(date));
		}

		campaignEventStatusImpl.setCampaignEventId(campaignEventId);
		campaignEventStatusImpl.setPreviousStatusId(previousStatusId);
		campaignEventStatusImpl.setUserId(userId);

		if (userName == null) {
			campaignEventStatusImpl.setUserName("");
		}
		else {
			campaignEventStatusImpl.setUserName(userName);
		}

		campaignEventStatusImpl.resetOriginalValues();

		return campaignEventStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		statusId = objectInput.readLong();

		status = objectInput.readInt();
		comment = (String)objectInput.readObject();

		deletionDenied = objectInput.readBoolean();
		date = objectInput.readLong();

		campaignEventId = objectInput.readLong();

		previousStatusId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(statusId);

		objectOutput.writeInt(status);

		if (comment == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(comment);
		}

		objectOutput.writeBoolean(deletionDenied);
		objectOutput.writeLong(date);

		objectOutput.writeLong(campaignEventId);

		objectOutput.writeLong(previousStatusId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}
	}

	public String uuid;
	public long statusId;
	public int status;
	public String comment;
	public boolean deletionDenied;
	public long date;
	public long campaignEventId;
	public long previousStatusId;
	public long userId;
	public String userName;

}