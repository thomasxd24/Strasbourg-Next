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

package eu.strasbourg.service.link.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link eu.strasbourg.service.link.service.http.LinkServiceSoap}.
 *
 * @author BenjaminBini
 * @see eu.strasbourg.service.link.service.http.LinkServiceSoap
 * @generated
 */
@ProviderType
public class LinkSoap implements Serializable {
	public static LinkSoap toSoapModel(Link model) {
		LinkSoap soapModel = new LinkSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setLinkId(model.getLinkId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setURL(model.getURL());
		soapModel.setHoverText(model.getHoverText());

		return soapModel;
	}

	public static LinkSoap[] toSoapModels(Link[] models) {
		LinkSoap[] soapModels = new LinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LinkSoap[][] toSoapModels(Link[][] models) {
		LinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LinkSoap[] toSoapModels(List<Link> models) {
		List<LinkSoap> soapModels = new ArrayList<LinkSoap>(models.size());

		for (Link model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LinkSoap[soapModels.size()]);
	}

	public LinkSoap() {
	}

	public long getPrimaryKey() {
		return _linkId;
	}

	public void setPrimaryKey(long pk) {
		setLinkId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getLinkId() {
		return _linkId;
	}

	public void setLinkId(long linkId) {
		_linkId = linkId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getURL() {
		return _URL;
	}

	public void setURL(String URL) {
		_URL = URL;
	}

	public String getHoverText() {
		return _hoverText;
	}

	public void setHoverText(String hoverText) {
		_hoverText = hoverText;
	}

	private String _uuid;
	private long _linkId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _URL;
	private String _hoverText;
}