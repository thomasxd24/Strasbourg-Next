/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.project.model.Initiative;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Initiative in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class InitiativeCacheModel
	implements CacheModel<Initiative>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InitiativeCacheModel)) {
			return false;
		}

		InitiativeCacheModel initiativeCacheModel =
			(InitiativeCacheModel)object;

		if (initiativeId == initiativeCacheModel.initiativeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, initiativeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", initiativeId=");
		sb.append(initiativeId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", placeTextArea=");
		sb.append(placeTextArea);
		sb.append(", inTheNameOf=");
		sb.append(inTheNameOf);
		sb.append(", videoUrl=");
		sb.append(videoUrl);
		sb.append(", externalImageURL=");
		sb.append(externalImageURL);
		sb.append(", externalImageCopyright=");
		sb.append(externalImageCopyright);
		sb.append(", mediaChoice=");
		sb.append(mediaChoice);
		sb.append(", assetEntryId=");
		sb.append(assetEntryId);
		sb.append(", publikId=");
		sb.append(publikId);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", filesIds=");
		sb.append(filesIds);
		sb.append(", publicationDate=");
		sb.append(publicationDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Initiative toEntityModel() {
		InitiativeImpl initiativeImpl = new InitiativeImpl();

		if (uuid == null) {
			initiativeImpl.setUuid("");
		}
		else {
			initiativeImpl.setUuid(uuid);
		}

		initiativeImpl.setInitiativeId(initiativeId);
		initiativeImpl.setGroupId(groupId);
		initiativeImpl.setCompanyId(companyId);
		initiativeImpl.setUserId(userId);

		if (userName == null) {
			initiativeImpl.setUserName("");
		}
		else {
			initiativeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			initiativeImpl.setCreateDate(null);
		}
		else {
			initiativeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			initiativeImpl.setModifiedDate(null);
		}
		else {
			initiativeImpl.setModifiedDate(new Date(modifiedDate));
		}

		initiativeImpl.setStatus(status);
		initiativeImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			initiativeImpl.setStatusByUserName("");
		}
		else {
			initiativeImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			initiativeImpl.setStatusDate(null);
		}
		else {
			initiativeImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			initiativeImpl.setTitle("");
		}
		else {
			initiativeImpl.setTitle(title);
		}

		if (description == null) {
			initiativeImpl.setDescription("");
		}
		else {
			initiativeImpl.setDescription(description);
		}

		if (placeTextArea == null) {
			initiativeImpl.setPlaceTextArea("");
		}
		else {
			initiativeImpl.setPlaceTextArea(placeTextArea);
		}

		if (inTheNameOf == null) {
			initiativeImpl.setInTheNameOf("");
		}
		else {
			initiativeImpl.setInTheNameOf(inTheNameOf);
		}

		if (videoUrl == null) {
			initiativeImpl.setVideoUrl("");
		}
		else {
			initiativeImpl.setVideoUrl(videoUrl);
		}

		if (externalImageURL == null) {
			initiativeImpl.setExternalImageURL("");
		}
		else {
			initiativeImpl.setExternalImageURL(externalImageURL);
		}

		if (externalImageCopyright == null) {
			initiativeImpl.setExternalImageCopyright("");
		}
		else {
			initiativeImpl.setExternalImageCopyright(externalImageCopyright);
		}

		initiativeImpl.setMediaChoice(mediaChoice);
		initiativeImpl.setAssetEntryId(assetEntryId);

		if (publikId == null) {
			initiativeImpl.setPublikId("");
		}
		else {
			initiativeImpl.setPublikId(publikId);
		}

		initiativeImpl.setImageId(imageId);

		if (filesIds == null) {
			initiativeImpl.setFilesIds("");
		}
		else {
			initiativeImpl.setFilesIds(filesIds);
		}

		if (publicationDate == Long.MIN_VALUE) {
			initiativeImpl.setPublicationDate(null);
		}
		else {
			initiativeImpl.setPublicationDate(new Date(publicationDate));
		}

		initiativeImpl.resetOriginalValues();

		return initiativeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		initiativeId = objectInput.readLong();

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
		title = objectInput.readUTF();
		description = (String)objectInput.readObject();
		placeTextArea = objectInput.readUTF();
		inTheNameOf = objectInput.readUTF();
		videoUrl = objectInput.readUTF();
		externalImageURL = objectInput.readUTF();
		externalImageCopyright = objectInput.readUTF();

		mediaChoice = objectInput.readBoolean();

		assetEntryId = objectInput.readLong();
		publikId = objectInput.readUTF();

		imageId = objectInput.readLong();
		filesIds = objectInput.readUTF();
		publicationDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(initiativeId);

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

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(description);
		}

		if (placeTextArea == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeTextArea);
		}

		if (inTheNameOf == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(inTheNameOf);
		}

		if (videoUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(videoUrl);
		}

		if (externalImageURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalImageURL);
		}

		if (externalImageCopyright == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalImageCopyright);
		}

		objectOutput.writeBoolean(mediaChoice);

		objectOutput.writeLong(assetEntryId);

		if (publikId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikId);
		}

		objectOutput.writeLong(imageId);

		if (filesIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(filesIds);
		}

		objectOutput.writeLong(publicationDate);
	}

	public String uuid;
	public long initiativeId;
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
	public String title;
	public String description;
	public String placeTextArea;
	public String inTheNameOf;
	public String videoUrl;
	public String externalImageURL;
	public String externalImageCopyright;
	public boolean mediaChoice;
	public long assetEntryId;
	public String publikId;
	public long imageId;
	public String filesIds;
	public long publicationDate;

}