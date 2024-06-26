/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.like.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.like.model.Like;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Like in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class LikeCacheModel implements CacheModel<Like>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LikeCacheModel)) {
			return false;
		}

		LikeCacheModel likeCacheModel = (LikeCacheModel)object;

		if (likeId == likeCacheModel.likeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, likeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{likeId=");
		sb.append(likeId);
		sb.append(", publikUserId=");
		sb.append(publikUserId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", isDislike=");
		sb.append(isDislike);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", entityGroupId=");
		sb.append(entityGroupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Like toEntityModel() {
		LikeImpl likeImpl = new LikeImpl();

		likeImpl.setLikeId(likeId);

		if (publikUserId == null) {
			likeImpl.setPublikUserId("");
		}
		else {
			likeImpl.setPublikUserId(publikUserId);
		}

		if (title == null) {
			likeImpl.setTitle("");
		}
		else {
			likeImpl.setTitle(title);
		}

		likeImpl.setIsDislike(isDislike);
		likeImpl.setTypeId(typeId);
		likeImpl.setEntityId(entityId);
		likeImpl.setEntityGroupId(entityGroupId);

		likeImpl.resetOriginalValues();

		return likeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		likeId = objectInput.readLong();
		publikUserId = objectInput.readUTF();
		title = objectInput.readUTF();

		isDislike = objectInput.readBoolean();

		typeId = objectInput.readLong();

		entityId = objectInput.readLong();

		entityGroupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(likeId);

		if (publikUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikUserId);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeBoolean(isDislike);

		objectOutput.writeLong(typeId);

		objectOutput.writeLong(entityId);

		objectOutput.writeLong(entityGroupId);
	}

	public long likeId;
	public String publikUserId;
	public String title;
	public boolean isDislike;
	public long typeId;
	public long entityId;
	public long entityGroupId;

}