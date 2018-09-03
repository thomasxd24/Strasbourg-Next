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

import eu.strasbourg.service.project.model.Petition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Petition in entity cache.
 *
 * @author Cedric Henry
 * @see Petition
 * @generated
 */
@ProviderType
public class PetitionCacheModel implements CacheModel<Petition>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PetitionCacheModel)) {
			return false;
		}

		PetitionCacheModel petitionCacheModel = (PetitionCacheModel)obj;

		if (petitionId == petitionCacheModel.petitionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, petitionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", petitionId=");
		sb.append(petitionId);
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
		sb.append(", filesDownload=");
		sb.append(filesDownload);
		sb.append(", petitionStatus=");
		sb.append(petitionStatus);
		sb.append(", publicationDate=");
		sb.append(publicationDate);
		sb.append(", expirationDate=");
		sb.append(expirationDate);
		sb.append(", quotaSignature=");
		sb.append(quotaSignature);
		sb.append(", nombreSignature=");
		sb.append(nombreSignature);
		sb.append(", videoUrl=");
		sb.append(videoUrl);
		sb.append(", externalImageURL=");
		sb.append(externalImageURL);
		sb.append(", externalImageCopyright=");
		sb.append(externalImageCopyright);
		sb.append(", mediaChoice=");
		sb.append(mediaChoice);
		sb.append(", consultationPlacesBody=");
		sb.append(consultationPlacesBody);
		sb.append(", assetEntryId=");
		sb.append(assetEntryId);
		sb.append(", publikId=");
		sb.append(publikId);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", filesIds=");
		sb.append(filesIds);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Petition toEntityModel() {
		PetitionImpl petitionImpl = new PetitionImpl();

		if (uuid == null) {
			petitionImpl.setUuid(StringPool.BLANK);
		}
		else {
			petitionImpl.setUuid(uuid);
		}

		petitionImpl.setPetitionId(petitionId);
		petitionImpl.setGroupId(groupId);
		petitionImpl.setCompanyId(companyId);
		petitionImpl.setUserId(userId);

		if (userName == null) {
			petitionImpl.setUserName(StringPool.BLANK);
		}
		else {
			petitionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			petitionImpl.setCreateDate(null);
		}
		else {
			petitionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			petitionImpl.setModifiedDate(null);
		}
		else {
			petitionImpl.setModifiedDate(new Date(modifiedDate));
		}

		petitionImpl.setStatus(status);
		petitionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			petitionImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			petitionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			petitionImpl.setStatusDate(null);
		}
		else {
			petitionImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			petitionImpl.setTitle(StringPool.BLANK);
		}
		else {
			petitionImpl.setTitle(title);
		}

		if (description == null) {
			petitionImpl.setDescription(StringPool.BLANK);
		}
		else {
			petitionImpl.setDescription(description);
		}

		if (placeTextArea == null) {
			petitionImpl.setPlaceTextArea(StringPool.BLANK);
		}
		else {
			petitionImpl.setPlaceTextArea(placeTextArea);
		}

		if (filesDownload == null) {
			petitionImpl.setFilesDownload(StringPool.BLANK);
		}
		else {
			petitionImpl.setFilesDownload(filesDownload);
		}

		if (petitionStatus == null) {
			petitionImpl.setPetitionStatus(StringPool.BLANK);
		}
		else {
			petitionImpl.setPetitionStatus(petitionStatus);
		}

		if (publicationDate == Long.MIN_VALUE) {
			petitionImpl.setPublicationDate(null);
		}
		else {
			petitionImpl.setPublicationDate(new Date(publicationDate));
		}

		if (expirationDate == Long.MIN_VALUE) {
			petitionImpl.setExpirationDate(null);
		}
		else {
			petitionImpl.setExpirationDate(new Date(expirationDate));
		}

		petitionImpl.setQuotaSignature(quotaSignature);
		petitionImpl.setNombreSignature(nombreSignature);

		if (videoUrl == null) {
			petitionImpl.setVideoUrl(StringPool.BLANK);
		}
		else {
			petitionImpl.setVideoUrl(videoUrl);
		}

		if (externalImageURL == null) {
			petitionImpl.setExternalImageURL(StringPool.BLANK);
		}
		else {
			petitionImpl.setExternalImageURL(externalImageURL);
		}

		if (externalImageCopyright == null) {
			petitionImpl.setExternalImageCopyright(StringPool.BLANK);
		}
		else {
			petitionImpl.setExternalImageCopyright(externalImageCopyright);
		}

		petitionImpl.setMediaChoice(mediaChoice);

		if (consultationPlacesBody == null) {
			petitionImpl.setConsultationPlacesBody(StringPool.BLANK);
		}
		else {
			petitionImpl.setConsultationPlacesBody(consultationPlacesBody);
		}

		petitionImpl.setAssetEntryId(assetEntryId);

		if (publikId == null) {
			petitionImpl.setPublikId(StringPool.BLANK);
		}
		else {
			petitionImpl.setPublikId(publikId);
		}

		petitionImpl.setImageId(imageId);

		if (filesIds == null) {
			petitionImpl.setFilesIds(StringPool.BLANK);
		}
		else {
			petitionImpl.setFilesIds(filesIds);
		}

		petitionImpl.resetOriginalValues();

		return petitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		petitionId = objectInput.readLong();

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
		description = objectInput.readUTF();
		placeTextArea = objectInput.readUTF();
		filesDownload = objectInput.readUTF();
		petitionStatus = objectInput.readUTF();
		publicationDate = objectInput.readLong();
		expirationDate = objectInput.readLong();

		quotaSignature = objectInput.readLong();

		nombreSignature = objectInput.readLong();
		videoUrl = objectInput.readUTF();
		externalImageURL = objectInput.readUTF();
		externalImageCopyright = objectInput.readUTF();

		mediaChoice = objectInput.readBoolean();
		consultationPlacesBody = objectInput.readUTF();

		assetEntryId = objectInput.readLong();
		publikId = objectInput.readUTF();

		imageId = objectInput.readLong();
		filesIds = objectInput.readUTF();
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

		objectOutput.writeLong(petitionId);

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

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (placeTextArea == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(placeTextArea);
		}

		if (filesDownload == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filesDownload);
		}

		if (petitionStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(petitionStatus);
		}

		objectOutput.writeLong(publicationDate);
		objectOutput.writeLong(expirationDate);

		objectOutput.writeLong(quotaSignature);

		objectOutput.writeLong(nombreSignature);

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

		if (consultationPlacesBody == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(consultationPlacesBody);
		}

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
	}

	public String uuid;
	public long petitionId;
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
	public String filesDownload;
	public String petitionStatus;
	public long publicationDate;
	public long expirationDate;
	public long quotaSignature;
	public long nombreSignature;
	public String videoUrl;
	public String externalImageURL;
	public String externalImageCopyright;
	public boolean mediaChoice;
	public String consultationPlacesBody;
	public long assetEntryId;
	public String publikId;
	public long imageId;
	public String filesIds;
}