/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.csmap.model.RefreshToken;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RefreshToken in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RefreshTokenCacheModel
	implements CacheModel<RefreshToken>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RefreshTokenCacheModel)) {
			return false;
		}

		RefreshTokenCacheModel refreshTokenCacheModel =
			(RefreshTokenCacheModel)object;

		if (refreshTokenId == refreshTokenCacheModel.refreshTokenId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, refreshTokenId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", refreshTokenId=");
		sb.append(refreshTokenId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", value=");
		sb.append(value);
		sb.append(", publikId=");
		sb.append(publikId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RefreshToken toEntityModel() {
		RefreshTokenImpl refreshTokenImpl = new RefreshTokenImpl();

		if (uuid == null) {
			refreshTokenImpl.setUuid("");
		}
		else {
			refreshTokenImpl.setUuid(uuid);
		}

		refreshTokenImpl.setRefreshTokenId(refreshTokenId);

		if (createDate == Long.MIN_VALUE) {
			refreshTokenImpl.setCreateDate(null);
		}
		else {
			refreshTokenImpl.setCreateDate(new Date(createDate));
		}

		if (value == null) {
			refreshTokenImpl.setValue("");
		}
		else {
			refreshTokenImpl.setValue(value);
		}

		if (publikId == null) {
			refreshTokenImpl.setPublikId("");
		}
		else {
			refreshTokenImpl.setPublikId(publikId);
		}

		refreshTokenImpl.resetOriginalValues();

		return refreshTokenImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		refreshTokenId = objectInput.readLong();
		createDate = objectInput.readLong();
		value = objectInput.readUTF();
		publikId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(refreshTokenId);
		objectOutput.writeLong(createDate);

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}

		if (publikId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikId);
		}
	}

	public String uuid;
	public long refreshTokenId;
	public long createDate;
	public String value;
	public String publikId;

}