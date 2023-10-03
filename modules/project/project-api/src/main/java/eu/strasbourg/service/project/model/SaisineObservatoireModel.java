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

package eu.strasbourg.service.project.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the SaisineObservatoire service. Represents a row in the &quot;project_SaisineObservatoire&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.project.model.impl.SaisineObservatoireModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.project.model.impl.SaisineObservatoireImpl</code>.
 * </p>
 *
 * @author Cedric Henry
 * @see SaisineObservatoire
 * @generated
 */
@ProviderType
public interface SaisineObservatoireModel
	extends BaseModel<SaisineObservatoire>, GroupedModel, ShardedModel,
			WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a saisine observatoire model instance should use the {@link SaisineObservatoire} interface instead.
	 */

	/**
	 * Returns the primary key of this saisine observatoire.
	 *
	 * @return the primary key of this saisine observatoire
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this saisine observatoire.
	 *
	 * @param primaryKey the primary key of this saisine observatoire
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the saisine observatoire ID of this saisine observatoire.
	 *
	 * @return the saisine observatoire ID of this saisine observatoire
	 */
	public long getSaisineObservatoireId();

	/**
	 * Sets the saisine observatoire ID of this saisine observatoire.
	 *
	 * @param saisineObservatoireId the saisine observatoire ID of this saisine observatoire
	 */
	public void setSaisineObservatoireId(long saisineObservatoireId);

	/**
	 * Returns the group ID of this saisine observatoire.
	 *
	 * @return the group ID of this saisine observatoire
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this saisine observatoire.
	 *
	 * @param groupId the group ID of this saisine observatoire
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this saisine observatoire.
	 *
	 * @return the company ID of this saisine observatoire
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this saisine observatoire.
	 *
	 * @param companyId the company ID of this saisine observatoire
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this saisine observatoire.
	 *
	 * @return the user ID of this saisine observatoire
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this saisine observatoire.
	 *
	 * @param userId the user ID of this saisine observatoire
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this saisine observatoire.
	 *
	 * @return the user uuid of this saisine observatoire
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this saisine observatoire.
	 *
	 * @param userUuid the user uuid of this saisine observatoire
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this saisine observatoire.
	 *
	 * @return the user name of this saisine observatoire
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this saisine observatoire.
	 *
	 * @param userName the user name of this saisine observatoire
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this saisine observatoire.
	 *
	 * @return the create date of this saisine observatoire
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this saisine observatoire.
	 *
	 * @param createDate the create date of this saisine observatoire
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this saisine observatoire.
	 *
	 * @return the modified date of this saisine observatoire
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this saisine observatoire.
	 *
	 * @param modifiedDate the modified date of this saisine observatoire
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this saisine observatoire.
	 *
	 * @return the status of this saisine observatoire
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this saisine observatoire.
	 *
	 * @param status the status of this saisine observatoire
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this saisine observatoire.
	 *
	 * @return the status by user ID of this saisine observatoire
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this saisine observatoire.
	 *
	 * @param statusByUserId the status by user ID of this saisine observatoire
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this saisine observatoire.
	 *
	 * @return the status by user uuid of this saisine observatoire
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this saisine observatoire.
	 *
	 * @param statusByUserUuid the status by user uuid of this saisine observatoire
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this saisine observatoire.
	 *
	 * @return the status by user name of this saisine observatoire
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this saisine observatoire.
	 *
	 * @param statusByUserName the status by user name of this saisine observatoire
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this saisine observatoire.
	 *
	 * @return the status date of this saisine observatoire
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this saisine observatoire.
	 *
	 * @param statusDate the status date of this saisine observatoire
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this saisine observatoire.
	 *
	 * @return the title of this saisine observatoire
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this saisine observatoire.
	 *
	 * @param title the title of this saisine observatoire
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this saisine observatoire.
	 *
	 * @return the description of this saisine observatoire
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this saisine observatoire.
	 *
	 * @param description the description of this saisine observatoire
	 */
	public void setDescription(String description);

	/**
	 * Returns the place text area of this saisine observatoire.
	 *
	 * @return the place text area of this saisine observatoire
	 */
	@AutoEscape
	public String getPlaceTextArea();

	/**
	 * Sets the place text area of this saisine observatoire.
	 *
	 * @param placeTextArea the place text area of this saisine observatoire
	 */
	public void setPlaceTextArea(String placeTextArea);

	/**
	 * Returns the files download of this saisine observatoire.
	 *
	 * @return the files download of this saisine observatoire
	 */
	@AutoEscape
	public String getFilesDownload();

	/**
	 * Sets the files download of this saisine observatoire.
	 *
	 * @param filesDownload the files download of this saisine observatoire
	 */
	public void setFilesDownload(String filesDownload);

	/**
	 * Returns the city response of this saisine observatoire.
	 *
	 * @return the city response of this saisine observatoire
	 */
	@AutoEscape
	public String getCityResponse();

	/**
	 * Sets the city response of this saisine observatoire.
	 *
	 * @param cityResponse the city response of this saisine observatoire
	 */
	public void setCityResponse(String cityResponse);

	/**
	 * Returns the project target of this saisine observatoire.
	 *
	 * @return the project target of this saisine observatoire
	 */
	@AutoEscape
	public String getProjectTarget();

	/**
	 * Sets the project target of this saisine observatoire.
	 *
	 * @param projectTarget the project target of this saisine observatoire
	 */
	public void setProjectTarget(String projectTarget);

	/**
	 * Returns the other mechanism of this saisine observatoire.
	 *
	 * @return the other mechanism of this saisine observatoire
	 */
	@AutoEscape
	public String getOtherMechanism();

	/**
	 * Sets the other mechanism of this saisine observatoire.
	 *
	 * @param otherMechanism the other mechanism of this saisine observatoire
	 */
	public void setOtherMechanism(String otherMechanism);

	/**
	 * Returns the collective name of this saisine observatoire.
	 *
	 * @return the collective name of this saisine observatoire
	 */
	@AutoEscape
	public String getCollectiveName();

	/**
	 * Sets the collective name of this saisine observatoire.
	 *
	 * @param collectiveName the collective name of this saisine observatoire
	 */
	public void setCollectiveName(String collectiveName);

	/**
	 * Returns the petitionnaire lastname of this saisine observatoire.
	 *
	 * @return the petitionnaire lastname of this saisine observatoire
	 */
	@AutoEscape
	public String getPetitionnaireLastname();

	/**
	 * Sets the petitionnaire lastname of this saisine observatoire.
	 *
	 * @param petitionnaireLastname the petitionnaire lastname of this saisine observatoire
	 */
	public void setPetitionnaireLastname(String petitionnaireLastname);

	/**
	 * Returns the petitionnaire firstname of this saisine observatoire.
	 *
	 * @return the petitionnaire firstname of this saisine observatoire
	 */
	@AutoEscape
	public String getPetitionnaireFirstname();

	/**
	 * Sets the petitionnaire firstname of this saisine observatoire.
	 *
	 * @param petitionnaireFirstname the petitionnaire firstname of this saisine observatoire
	 */
	public void setPetitionnaireFirstname(String petitionnaireFirstname);

	/**
	 * Returns the petitionnaire birthday of this saisine observatoire.
	 *
	 * @return the petitionnaire birthday of this saisine observatoire
	 */
	public Date getPetitionnaireBirthday();

	/**
	 * Sets the petitionnaire birthday of this saisine observatoire.
	 *
	 * @param petitionnaireBirthday the petitionnaire birthday of this saisine observatoire
	 */
	public void setPetitionnaireBirthday(Date petitionnaireBirthday);

	/**
	 * Returns the petitionnaire adresse of this saisine observatoire.
	 *
	 * @return the petitionnaire adresse of this saisine observatoire
	 */
	@AutoEscape
	public String getPetitionnaireAdresse();

	/**
	 * Sets the petitionnaire adresse of this saisine observatoire.
	 *
	 * @param petitionnaireAdresse the petitionnaire adresse of this saisine observatoire
	 */
	public void setPetitionnaireAdresse(String petitionnaireAdresse);

	/**
	 * Returns the petitionnaire postal code of this saisine observatoire.
	 *
	 * @return the petitionnaire postal code of this saisine observatoire
	 */
	public long getPetitionnairePostalCode();

	/**
	 * Sets the petitionnaire postal code of this saisine observatoire.
	 *
	 * @param petitionnairePostalCode the petitionnaire postal code of this saisine observatoire
	 */
	public void setPetitionnairePostalCode(long petitionnairePostalCode);

	/**
	 * Returns the petitionnaire city of this saisine observatoire.
	 *
	 * @return the petitionnaire city of this saisine observatoire
	 */
	@AutoEscape
	public String getPetitionnaireCity();

	/**
	 * Sets the petitionnaire city of this saisine observatoire.
	 *
	 * @param petitionnaireCity the petitionnaire city of this saisine observatoire
	 */
	public void setPetitionnaireCity(String petitionnaireCity);

	/**
	 * Returns the petitionnaire phone of this saisine observatoire.
	 *
	 * @return the petitionnaire phone of this saisine observatoire
	 */
	@AutoEscape
	public String getPetitionnairePhone();

	/**
	 * Sets the petitionnaire phone of this saisine observatoire.
	 *
	 * @param petitionnairePhone the petitionnaire phone of this saisine observatoire
	 */
	public void setPetitionnairePhone(String petitionnairePhone);

	/**
	 * Returns the petitionnaire email of this saisine observatoire.
	 *
	 * @return the petitionnaire email of this saisine observatoire
	 */
	@AutoEscape
	public String getPetitionnaireEmail();

	/**
	 * Sets the petitionnaire email of this saisine observatoire.
	 *
	 * @param petitionnaireEmail the petitionnaire email of this saisine observatoire
	 */
	public void setPetitionnaireEmail(String petitionnaireEmail);

	/**
	 * Returns the video url of this saisine observatoire.
	 *
	 * @return the video url of this saisine observatoire
	 */
	@AutoEscape
	public String getVideoUrl();

	/**
	 * Sets the video url of this saisine observatoire.
	 *
	 * @param videoUrl the video url of this saisine observatoire
	 */
	public void setVideoUrl(String videoUrl);

	/**
	 * Returns the external image url of this saisine observatoire.
	 *
	 * @return the external image url of this saisine observatoire
	 */
	@AutoEscape
	public String getExternalImageURL();

	/**
	 * Sets the external image url of this saisine observatoire.
	 *
	 * @param externalImageURL the external image url of this saisine observatoire
	 */
	public void setExternalImageURL(String externalImageURL);

	/**
	 * Returns the external image copyright of this saisine observatoire.
	 *
	 * @return the external image copyright of this saisine observatoire
	 */
	@AutoEscape
	public String getExternalImageCopyright();

	/**
	 * Sets the external image copyright of this saisine observatoire.
	 *
	 * @param externalImageCopyright the external image copyright of this saisine observatoire
	 */
	public void setExternalImageCopyright(String externalImageCopyright);

	/**
	 * Returns the media choice of this saisine observatoire.
	 *
	 * @return the media choice of this saisine observatoire
	 */
	public boolean getMediaChoice();

	/**
	 * Returns <code>true</code> if this saisine observatoire is media choice.
	 *
	 * @return <code>true</code> if this saisine observatoire is media choice; <code>false</code> otherwise
	 */
	public boolean isMediaChoice();

	/**
	 * Sets whether this saisine observatoire is media choice.
	 *
	 * @param mediaChoice the media choice of this saisine observatoire
	 */
	public void setMediaChoice(boolean mediaChoice);

	/**
	 * Returns the publik ID of this saisine observatoire.
	 *
	 * @return the publik ID of this saisine observatoire
	 */
	@AutoEscape
	public String getPublikId();

	/**
	 * Sets the publik ID of this saisine observatoire.
	 *
	 * @param publikId the publik ID of this saisine observatoire
	 */
	public void setPublikId(String publikId);

	/**
	 * Returns the image ID of this saisine observatoire.
	 *
	 * @return the image ID of this saisine observatoire
	 */
	public long getImageId();

	/**
	 * Sets the image ID of this saisine observatoire.
	 *
	 * @param imageId the image ID of this saisine observatoire
	 */
	public void setImageId(long imageId);

	/**
	 * Returns the files IDs of this saisine observatoire.
	 *
	 * @return the files IDs of this saisine observatoire
	 */
	@AutoEscape
	public String getFilesIds();

	/**
	 * Sets the files IDs of this saisine observatoire.
	 *
	 * @param filesIds the files IDs of this saisine observatoire
	 */
	public void setFilesIds(String filesIds);

	/**
	 * Returns <code>true</code> if this saisine observatoire is approved.
	 *
	 * @return <code>true</code> if this saisine observatoire is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this saisine observatoire is denied.
	 *
	 * @return <code>true</code> if this saisine observatoire is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this saisine observatoire is a draft.
	 *
	 * @return <code>true</code> if this saisine observatoire is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this saisine observatoire is expired.
	 *
	 * @return <code>true</code> if this saisine observatoire is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this saisine observatoire is inactive.
	 *
	 * @return <code>true</code> if this saisine observatoire is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this saisine observatoire is incomplete.
	 *
	 * @return <code>true</code> if this saisine observatoire is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this saisine observatoire is pending.
	 *
	 * @return <code>true</code> if this saisine observatoire is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this saisine observatoire is scheduled.
	 *
	 * @return <code>true</code> if this saisine observatoire is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public SaisineObservatoire cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}