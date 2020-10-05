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

package eu.strasbourg.service.agenda.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ImportReport service. Represents a row in the &quot;agenda_ImportReport&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.agenda.model.impl.ImportReportModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.agenda.model.impl.ImportReportImpl</code>.
 * </p>
 *
 * @author BenjaminBini
 * @see ImportReport
 * @generated
 */
@ProviderType
public interface ImportReportModel extends BaseModel<ImportReport> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a import report model instance should use the {@link ImportReport} interface instead.
	 */

	/**
	 * Returns the primary key of this import report.
	 *
	 * @return the primary key of this import report
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this import report.
	 *
	 * @param primaryKey the primary key of this import report
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this import report.
	 *
	 * @return the uuid of this import report
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this import report.
	 *
	 * @param uuid the uuid of this import report
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the report ID of this import report.
	 *
	 * @return the report ID of this import report
	 */
	public long getReportId();

	/**
	 * Sets the report ID of this import report.
	 *
	 * @param reportId the report ID of this import report
	 */
	public void setReportId(long reportId);

	/**
	 * Returns the provider of this import report.
	 *
	 * @return the provider of this import report
	 */
	@AutoEscape
	public String getProvider();

	/**
	 * Sets the provider of this import report.
	 *
	 * @param provider the provider of this import report
	 */
	public void setProvider(String provider);

	/**
	 * Returns the filename of this import report.
	 *
	 * @return the filename of this import report
	 */
	@AutoEscape
	public String getFilename();

	/**
	 * Sets the filename of this import report.
	 *
	 * @param filename the filename of this import report
	 */
	public void setFilename(String filename);

	/**
	 * Returns the status of this import report.
	 *
	 * @return the status of this import report
	 */
	public long getStatus();

	/**
	 * Sets the status of this import report.
	 *
	 * @param status the status of this import report
	 */
	public void setStatus(long status);

	/**
	 * Returns the global error cause of this import report.
	 *
	 * @return the global error cause of this import report
	 */
	@AutoEscape
	public String getGlobalErrorCause();

	/**
	 * Sets the global error cause of this import report.
	 *
	 * @param globalErrorCause the global error cause of this import report
	 */
	public void setGlobalErrorCause(String globalErrorCause);

	/**
	 * Returns the new events count of this import report.
	 *
	 * @return the new events count of this import report
	 */
	public long getNewEventsCount();

	/**
	 * Sets the new events count of this import report.
	 *
	 * @param newEventsCount the new events count of this import report
	 */
	public void setNewEventsCount(long newEventsCount);

	/**
	 * Returns the modified events count of this import report.
	 *
	 * @return the modified events count of this import report
	 */
	public long getModifiedEventsCount();

	/**
	 * Sets the modified events count of this import report.
	 *
	 * @param modifiedEventsCount the modified events count of this import report
	 */
	public void setModifiedEventsCount(long modifiedEventsCount);

	/**
	 * Returns the error events count of this import report.
	 *
	 * @return the error events count of this import report
	 */
	public long getErrorEventsCount();

	/**
	 * Sets the error events count of this import report.
	 *
	 * @param errorEventsCount the error events count of this import report
	 */
	public void setErrorEventsCount(long errorEventsCount);

	/**
	 * Returns the unmodified events count of this import report.
	 *
	 * @return the unmodified events count of this import report
	 */
	public long getUnmodifiedEventsCount();

	/**
	 * Sets the unmodified events count of this import report.
	 *
	 * @param unmodifiedEventsCount the unmodified events count of this import report
	 */
	public void setUnmodifiedEventsCount(long unmodifiedEventsCount);

	/**
	 * Returns the new manifestations count of this import report.
	 *
	 * @return the new manifestations count of this import report
	 */
	public long getNewManifestationsCount();

	/**
	 * Sets the new manifestations count of this import report.
	 *
	 * @param newManifestationsCount the new manifestations count of this import report
	 */
	public void setNewManifestationsCount(long newManifestationsCount);

	/**
	 * Returns the modified manifestations count of this import report.
	 *
	 * @return the modified manifestations count of this import report
	 */
	public long getModifiedManifestationsCount();

	/**
	 * Sets the modified manifestations count of this import report.
	 *
	 * @param modifiedManifestationsCount the modified manifestations count of this import report
	 */
	public void setModifiedManifestationsCount(
		long modifiedManifestationsCount);

	/**
	 * Returns the error manifestations count of this import report.
	 *
	 * @return the error manifestations count of this import report
	 */
	public long getErrorManifestationsCount();

	/**
	 * Sets the error manifestations count of this import report.
	 *
	 * @param errorManifestationsCount the error manifestations count of this import report
	 */
	public void setErrorManifestationsCount(long errorManifestationsCount);

	/**
	 * Returns the un modified manifestations count of this import report.
	 *
	 * @return the un modified manifestations count of this import report
	 */
	public long getUnModifiedManifestationsCount();

	/**
	 * Sets the un modified manifestations count of this import report.
	 *
	 * @param unModifiedManifestationsCount the un modified manifestations count of this import report
	 */
	public void setUnModifiedManifestationsCount(
		long unModifiedManifestationsCount);

	/**
	 * Returns the start date of this import report.
	 *
	 * @return the start date of this import report
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this import report.
	 *
	 * @param startDate the start date of this import report
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this import report.
	 *
	 * @return the end date of this import report
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this import report.
	 *
	 * @param endDate the end date of this import report
	 */
	public void setEndDate(Date endDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		eu.strasbourg.service.agenda.model.ImportReport importReport);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.agenda.model.ImportReport>
		toCacheModel();

	@Override
	public eu.strasbourg.service.agenda.model.ImportReport toEscapedModel();

	@Override
	public eu.strasbourg.service.agenda.model.ImportReport toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}