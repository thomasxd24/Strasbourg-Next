/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.notification.model.UserNotificationStatus;
import eu.strasbourg.service.notification.service.persistence.UserNotificationStatusPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserNotificationStatus in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class UserNotificationStatusCacheModel
	implements CacheModel<UserNotificationStatus>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserNotificationStatusCacheModel)) {
			return false;
		}

		UserNotificationStatusCacheModel userNotificationStatusCacheModel =
			(UserNotificationStatusCacheModel)object;

		if (userNotificationStatusPK.equals(
				userNotificationStatusCacheModel.userNotificationStatusPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userNotificationStatusPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{notificationId=");
		sb.append(notificationId);
		sb.append(", publikUserId=");
		sb.append(publikUserId);
		sb.append(", read=");
		sb.append(read);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserNotificationStatus toEntityModel() {
		UserNotificationStatusImpl userNotificationStatusImpl =
			new UserNotificationStatusImpl();

		userNotificationStatusImpl.setNotificationId(notificationId);

		if (publikUserId == null) {
			userNotificationStatusImpl.setPublikUserId("");
		}
		else {
			userNotificationStatusImpl.setPublikUserId(publikUserId);
		}

		userNotificationStatusImpl.setRead(read);

		userNotificationStatusImpl.resetOriginalValues();

		return userNotificationStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		notificationId = objectInput.readLong();
		publikUserId = objectInput.readUTF();

		read = objectInput.readBoolean();

		userNotificationStatusPK = new UserNotificationStatusPK(
			notificationId, publikUserId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(notificationId);

		if (publikUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikUserId);
		}

		objectOutput.writeBoolean(read);
	}

	public long notificationId;
	public String publikUserId;
	public boolean read;
	public transient UserNotificationStatusPK userNotificationStatusPK;

}