/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.place.model.ScheduleException;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ScheduleException in entity cache.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class ScheduleExceptionCacheModel
	implements CacheModel<ScheduleException>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ScheduleExceptionCacheModel)) {
			return false;
		}

		ScheduleExceptionCacheModel scheduleExceptionCacheModel =
			(ScheduleExceptionCacheModel)object;

		if (exceptionId == scheduleExceptionCacheModel.exceptionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, exceptionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", exceptionId=");
		sb.append(exceptionId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", openingTimes=");
		sb.append(openingTimes);
		sb.append(", firstComment=");
		sb.append(firstComment);
		sb.append(", secondComment=");
		sb.append(secondComment);
		sb.append(", thirdComment=");
		sb.append(thirdComment);
		sb.append(", fourthComment=");
		sb.append(fourthComment);
		sb.append(", fifthComment=");
		sb.append(fifthComment);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", closed=");
		sb.append(closed);
		sb.append(", placeId=");
		sb.append(placeId);
		sb.append(", subPlaceId=");
		sb.append(subPlaceId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ScheduleException toEntityModel() {
		ScheduleExceptionImpl scheduleExceptionImpl =
			new ScheduleExceptionImpl();

		if (uuid == null) {
			scheduleExceptionImpl.setUuid("");
		}
		else {
			scheduleExceptionImpl.setUuid(uuid);
		}

		scheduleExceptionImpl.setExceptionId(exceptionId);

		if (startDate == Long.MIN_VALUE) {
			scheduleExceptionImpl.setStartDate(null);
		}
		else {
			scheduleExceptionImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			scheduleExceptionImpl.setEndDate(null);
		}
		else {
			scheduleExceptionImpl.setEndDate(new Date(endDate));
		}

		if (openingTimes == null) {
			scheduleExceptionImpl.setOpeningTimes("");
		}
		else {
			scheduleExceptionImpl.setOpeningTimes(openingTimes);
		}

		if (firstComment == null) {
			scheduleExceptionImpl.setFirstComment("");
		}
		else {
			scheduleExceptionImpl.setFirstComment(firstComment);
		}

		if (secondComment == null) {
			scheduleExceptionImpl.setSecondComment("");
		}
		else {
			scheduleExceptionImpl.setSecondComment(secondComment);
		}

		if (thirdComment == null) {
			scheduleExceptionImpl.setThirdComment("");
		}
		else {
			scheduleExceptionImpl.setThirdComment(thirdComment);
		}

		if (fourthComment == null) {
			scheduleExceptionImpl.setFourthComment("");
		}
		else {
			scheduleExceptionImpl.setFourthComment(fourthComment);
		}

		if (fifthComment == null) {
			scheduleExceptionImpl.setFifthComment("");
		}
		else {
			scheduleExceptionImpl.setFifthComment(fifthComment);
		}

		if (comment == null) {
			scheduleExceptionImpl.setComment("");
		}
		else {
			scheduleExceptionImpl.setComment(comment);
		}

		scheduleExceptionImpl.setClosed(closed);
		scheduleExceptionImpl.setPlaceId(placeId);
		scheduleExceptionImpl.setSubPlaceId(subPlaceId);

		scheduleExceptionImpl.resetOriginalValues();

		return scheduleExceptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		exceptionId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		openingTimes = objectInput.readUTF();
		firstComment = objectInput.readUTF();
		secondComment = objectInput.readUTF();
		thirdComment = objectInput.readUTF();
		fourthComment = objectInput.readUTF();
		fifthComment = objectInput.readUTF();
		comment = objectInput.readUTF();

		closed = objectInput.readBoolean();

		placeId = objectInput.readLong();

		subPlaceId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(exceptionId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (openingTimes == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(openingTimes);
		}

		if (firstComment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstComment);
		}

		if (secondComment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(secondComment);
		}

		if (thirdComment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(thirdComment);
		}

		if (fourthComment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fourthComment);
		}

		if (fifthComment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fifthComment);
		}

		if (comment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comment);
		}

		objectOutput.writeBoolean(closed);

		objectOutput.writeLong(placeId);

		objectOutput.writeLong(subPlaceId);
	}

	public String uuid;
	public long exceptionId;
	public long startDate;
	public long endDate;
	public String openingTimes;
	public String firstComment;
	public String secondComment;
	public String thirdComment;
	public String fourthComment;
	public String fifthComment;
	public String comment;
	public boolean closed;
	public long placeId;
	public long subPlaceId;

}