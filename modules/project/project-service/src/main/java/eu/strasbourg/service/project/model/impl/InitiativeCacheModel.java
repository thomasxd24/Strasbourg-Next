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

package eu.strasbourg.service.project.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

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
 * @see Initiative
 * @generated
 */
@ProviderType
public class InitiativeCacheModel implements CacheModel<Initiative>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InitiativeCacheModel)) {
			return false;
		}

		InitiativeCacheModel initiativeCacheModel = (InitiativeCacheModel)obj;

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
		StringBundler sb = new StringBundler(53);

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
		sb.append(", author=");
		sb.append(author);
		sb.append(", description=");
		sb.append(description);
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
		sb.append(", consultationPlacesText=");
		sb.append(consultationPlacesText);
		sb.append(", consultationPlacesBody=");
		sb.append(consultationPlacesBody);
		sb.append(", publicationDate=");
		sb.append(publicationDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Initiative toEntityModel() {
		InitiativeImpl initiativeImpl = new InitiativeImpl();

		if (uuid == null) {
			initiativeImpl.setUuid(StringPool.BLANK);
		}
		else {
			initiativeImpl.setUuid(uuid);
		}

		initiativeImpl.setInitiativeId(initiativeId);
		initiativeImpl.setGroupId(groupId);
		initiativeImpl.setCompanyId(companyId);
		initiativeImpl.setUserId(userId);

		if (userName == null) {
			initiativeImpl.setUserName(StringPool.BLANK);
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
			initiativeImpl.setStatusByUserName(StringPool.BLANK);
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
			initiativeImpl.setTitle(StringPool.BLANK);
		}
		else {
			initiativeImpl.setTitle(title);
		}

		if (author == null) {
			initiativeImpl.setAuthor(StringPool.BLANK);
		}
		else {
			initiativeImpl.setAuthor(author);
		}

		if (description == null) {
			initiativeImpl.setDescription(StringPool.BLANK);
		}
		else {
			initiativeImpl.setDescription(description);
		}

		if (videoUrl == null) {
			initiativeImpl.setVideoUrl(StringPool.BLANK);
		}
		else {
			initiativeImpl.setVideoUrl(videoUrl);
		}

		if (externalImageURL == null) {
			initiativeImpl.setExternalImageURL(StringPool.BLANK);
		}
		else {
			initiativeImpl.setExternalImageURL(externalImageURL);
		}

		if (externalImageCopyright == null) {
			initiativeImpl.setExternalImageCopyright(StringPool.BLANK);
		}
		else {
			initiativeImpl.setExternalImageCopyright(externalImageCopyright);
		}

		initiativeImpl.setMediaChoice(mediaChoice);
		initiativeImpl.setAssetEntryId(assetEntryId);

		if (publikId == null) {
			initiativeImpl.setPublikId(StringPool.BLANK);
		}
		else {
			initiativeImpl.setPublikId(publikId);
		}

		initiativeImpl.setImageId(imageId);

		if (filesIds == null) {
			initiativeImpl.setFilesIds(StringPool.BLANK);
		}
		else {
			initiativeImpl.setFilesIds(filesIds);
		}

		if (consultationPlacesText == null) {
			initiativeImpl.setConsultationPlacesText(StringPool.BLANK);
		}
		else {
			initiativeImpl.setConsultationPlacesText(consultationPlacesText);
		}

		if (consultationPlacesBody == null) {
			initiativeImpl.setConsultationPlacesBody(StringPool.BLANK);
		}
		else {
			initiativeImpl.setConsultationPlacesBody(consultationPlacesBody);
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
	public void readExternal(ObjectInput objectInput) throws IOException {
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
		author = objectInput.readUTF();
		description = objectInput.readUTF();
		videoUrl = objectInput.readUTF();
		externalImageURL = objectInput.readUTF();
		externalImageCopyright = objectInput.readUTF();

		mediaChoice = objectInput.readBoolean();

		assetEntryId = objectInput.readLong();
		publikId = objectInput.readUTF();

		imageId = objectInput.readLong();
		filesIds = objectInput.readUTF();
		consultationPlacesText = objectInput.readUTF();
		consultationPlacesBody = objectInput.readUTF();
		publicationDate = objectInput.readLong();
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

		objectOutput.writeLong(initiativeId);

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

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(author);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (videoUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(videoUrl);
		}

		if (externalImageURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(externalImageURL);
		}

		if (externalImageCopyright == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(externalImageCopyright);
		}

		objectOutput.writeBoolean(mediaChoice);

		objectOutput.writeLong(assetEntryId);

		if (publikId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publikId);
		}

		objectOutput.writeLong(imageId);

		if (filesIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filesIds);
		}

		if (consultationPlacesText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(consultationPlacesText);
		}

		if (consultationPlacesBody == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(consultationPlacesBody);
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
	public String author;
	public String description;
	public String videoUrl;
	public String externalImageURL;
	public String externalImageCopyright;
	public boolean mediaChoice;
	public long assetEntryId;
	public String publikId;
	public long imageId;
	public String filesIds;
	public String consultationPlacesText;
	public String consultationPlacesBody;
	public long publicationDate;
}