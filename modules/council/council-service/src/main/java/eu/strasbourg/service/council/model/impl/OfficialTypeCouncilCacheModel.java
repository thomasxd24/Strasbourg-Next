/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.council.model.OfficialTypeCouncil;
import eu.strasbourg.service.council.service.persistence.OfficialTypeCouncilPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OfficialTypeCouncil in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OfficialTypeCouncilCacheModel
	implements CacheModel<OfficialTypeCouncil>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OfficialTypeCouncilCacheModel)) {
			return false;
		}

		OfficialTypeCouncilCacheModel officialTypeCouncilCacheModel =
			(OfficialTypeCouncilCacheModel)object;

		if (officialTypeCouncilPK.equals(
				officialTypeCouncilCacheModel.officialTypeCouncilPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, officialTypeCouncilPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", officialId=");
		sb.append(officialId);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", result=");
		sb.append(result);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OfficialTypeCouncil toEntityModel() {
		OfficialTypeCouncilImpl officialTypeCouncilImpl =
			new OfficialTypeCouncilImpl();

		if (uuid == null) {
			officialTypeCouncilImpl.setUuid("");
		}
		else {
			officialTypeCouncilImpl.setUuid(uuid);
		}

		officialTypeCouncilImpl.setOfficialId(officialId);
		officialTypeCouncilImpl.setTypeId(typeId);
		officialTypeCouncilImpl.setGroupId(groupId);
		officialTypeCouncilImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			officialTypeCouncilImpl.setCreateDate(null);
		}
		else {
			officialTypeCouncilImpl.setCreateDate(new Date(createDate));
		}

		if (result == null) {
			officialTypeCouncilImpl.setResult("");
		}
		else {
			officialTypeCouncilImpl.setResult(result);
		}

		officialTypeCouncilImpl.resetOriginalValues();

		return officialTypeCouncilImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		officialId = objectInput.readLong();

		typeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		result = objectInput.readUTF();

		officialTypeCouncilPK = new OfficialTypeCouncilPK(officialId, typeId);
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

		objectOutput.writeLong(typeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		if (result == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(result);
		}
	}

	public String uuid;
	public long officialId;
	public long typeId;
	public long groupId;
	public long companyId;
	public long createDate;
	public String result;
	public transient OfficialTypeCouncilPK officialTypeCouncilPK;

}