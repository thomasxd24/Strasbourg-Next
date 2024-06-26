/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.official.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.official.model.Official;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Official in entity cache.
 *
 * @author AngeliqueZUNINO
 * @generated
 */
public class OfficialCacheModel
	implements CacheModel<Official>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OfficialCacheModel)) {
			return false;
		}

		OfficialCacheModel officialCacheModel = (OfficialCacheModel)object;

		if (officialId == officialCacheModel.officialId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, officialId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", officialId=");
		sb.append(officialId);
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
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", thematicDelegation=");
		sb.append(thematicDelegation);
		sb.append(", missions=");
		sb.append(missions);
		sb.append(", wasMinister=");
		sb.append(wasMinister);
		sb.append(", contact=");
		sb.append(contact);
		sb.append(", orderDeputyMayor=");
		sb.append(orderDeputyMayor);
		sb.append(", orderVicePresident=");
		sb.append(orderVicePresident);
		sb.append(", listeContact=");
		sb.append(listeContact);
		sb.append(", resumeFonction=");
		sb.append(resumeFonction);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Official toEntityModel() {
		OfficialImpl officialImpl = new OfficialImpl();

		if (uuid == null) {
			officialImpl.setUuid("");
		}
		else {
			officialImpl.setUuid(uuid);
		}

		officialImpl.setOfficialId(officialId);
		officialImpl.setGroupId(groupId);
		officialImpl.setCompanyId(companyId);
		officialImpl.setUserId(userId);

		if (userName == null) {
			officialImpl.setUserName("");
		}
		else {
			officialImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			officialImpl.setCreateDate(null);
		}
		else {
			officialImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			officialImpl.setModifiedDate(null);
		}
		else {
			officialImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			officialImpl.setLastPublishDate(null);
		}
		else {
			officialImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		officialImpl.setStatus(status);
		officialImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			officialImpl.setStatusByUserName("");
		}
		else {
			officialImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			officialImpl.setStatusDate(null);
		}
		else {
			officialImpl.setStatusDate(new Date(statusDate));
		}

		officialImpl.setGender(gender);

		if (lastName == null) {
			officialImpl.setLastName("");
		}
		else {
			officialImpl.setLastName(lastName);
		}

		if (firstName == null) {
			officialImpl.setFirstName("");
		}
		else {
			officialImpl.setFirstName(firstName);
		}

		if (thematicDelegation == null) {
			officialImpl.setThematicDelegation("");
		}
		else {
			officialImpl.setThematicDelegation(thematicDelegation);
		}

		if (missions == null) {
			officialImpl.setMissions("");
		}
		else {
			officialImpl.setMissions(missions);
		}

		officialImpl.setWasMinister(wasMinister);

		if (contact == null) {
			officialImpl.setContact("");
		}
		else {
			officialImpl.setContact(contact);
		}

		officialImpl.setOrderDeputyMayor(orderDeputyMayor);
		officialImpl.setOrderVicePresident(orderVicePresident);

		if (listeContact == null) {
			officialImpl.setListeContact("");
		}
		else {
			officialImpl.setListeContact(listeContact);
		}

		if (resumeFonction == null) {
			officialImpl.setResumeFonction("");
		}
		else {
			officialImpl.setResumeFonction(resumeFonction);
		}

		officialImpl.setImageId(imageId);

		officialImpl.resetOriginalValues();

		return officialImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		officialId = objectInput.readLong();

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

		gender = objectInput.readInt();
		lastName = objectInput.readUTF();
		firstName = objectInput.readUTF();
		thematicDelegation = (String)objectInput.readObject();
		missions = (String)objectInput.readObject();

		wasMinister = objectInput.readBoolean();
		contact = (String)objectInput.readObject();

		orderDeputyMayor = objectInput.readInt();

		orderVicePresident = objectInput.readInt();
		listeContact = objectInput.readUTF();
		resumeFonction = objectInput.readUTF();

		imageId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(officialId);

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

		objectOutput.writeInt(gender);

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (thematicDelegation == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(thematicDelegation);
		}

		if (missions == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(missions);
		}

		objectOutput.writeBoolean(wasMinister);

		if (contact == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(contact);
		}

		objectOutput.writeInt(orderDeputyMayor);

		objectOutput.writeInt(orderVicePresident);

		if (listeContact == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(listeContact);
		}

		if (resumeFonction == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(resumeFonction);
		}

		objectOutput.writeLong(imageId);
	}

	public String uuid;
	public long officialId;
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
	public int gender;
	public String lastName;
	public String firstName;
	public String thematicDelegation;
	public String missions;
	public boolean wasMinister;
	public String contact;
	public int orderDeputyMayor;
	public int orderVicePresident;
	public String listeContact;
	public String resumeFonction;
	public long imageId;

}