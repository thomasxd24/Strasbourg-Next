/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author BenjaminBini
 * @generated
 */
public class UserNotificationTypePK
	implements Comparable<UserNotificationTypePK>, Serializable {

	public String publikUserId;
	public long typeId;

	public UserNotificationTypePK() {
	}

	public UserNotificationTypePK(String publikUserId, long typeId) {
		this.publikUserId = publikUserId;
		this.typeId = typeId;
	}

	public String getPublikUserId() {
		return publikUserId;
	}

	public void setPublikUserId(String publikUserId) {
		this.publikUserId = publikUserId;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	@Override
	public int compareTo(UserNotificationTypePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = publikUserId.compareTo(pk.publikUserId);

		if (value != 0) {
			return value;
		}

		if (typeId < pk.typeId) {
			value = -1;
		}
		else if (typeId > pk.typeId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserNotificationTypePK)) {
			return false;
		}

		UserNotificationTypePK pk = (UserNotificationTypePK)object;

		if (publikUserId.equals(pk.publikUserId) && (typeId == pk.typeId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, publikUserId);
		hashCode = HashUtil.hash(hashCode, typeId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("publikUserId=");

		sb.append(publikUserId);
		sb.append(", typeId=");

		sb.append(typeId);

		sb.append("}");

		return sb.toString();
	}

}