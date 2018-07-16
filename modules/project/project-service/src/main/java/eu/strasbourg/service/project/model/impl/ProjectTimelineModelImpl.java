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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import eu.strasbourg.service.project.model.ProjectTimeline;
import eu.strasbourg.service.project.model.ProjectTimelineModel;
import eu.strasbourg.service.project.model.ProjectTimelineSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ProjectTimeline service. Represents a row in the &quot;project_ProjectTimeline&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ProjectTimelineModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectTimelineImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see ProjectTimelineImpl
 * @see ProjectTimeline
 * @see ProjectTimelineModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ProjectTimelineModelImpl extends BaseModelImpl<ProjectTimeline>
	implements ProjectTimelineModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project timeline model instance should use the {@link ProjectTimeline} interface instead.
	 */
	public static final String TABLE_NAME = "project_ProjectTimeline";
	public static final Object[][] TABLE_COLUMNS = {
			{ "projectTimelineId", Types.BIGINT },
			{ "startDay", Types.INTEGER },
			{ "spacing", Types.INTEGER },
			{ "date_", Types.TIMESTAMP },
			{ "title", Types.VARCHAR },
			{ "link", Types.VARCHAR },
			{ "projectId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("projectTimelineId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("startDay", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("spacing", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("date_", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("link", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table project_ProjectTimeline (projectTimelineId LONG not null primary key,startDay INTEGER,spacing INTEGER,date_ DATE null,title VARCHAR(400) null,link VARCHAR(400) null,projectId LONG)";
	public static final String TABLE_SQL_DROP = "drop table project_ProjectTimeline";
	public static final String ORDER_BY_JPQL = " ORDER BY projectTimeline.date ASC";
	public static final String ORDER_BY_SQL = " ORDER BY project_ProjectTimeline.date_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.project.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.eu.strasbourg.service.project.model.ProjectTimeline"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.project.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.eu.strasbourg.service.project.model.ProjectTimeline"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.project.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.eu.strasbourg.service.project.model.ProjectTimeline"),
			true);
	public static final long PROJECTID_COLUMN_BITMASK = 1L;
	public static final long DATE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ProjectTimeline toModel(ProjectTimelineSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ProjectTimeline model = new ProjectTimelineImpl();

		model.setProjectTimelineId(soapModel.getProjectTimelineId());
		model.setStartDay(soapModel.getStartDay());
		model.setSpacing(soapModel.getSpacing());
		model.setDate(soapModel.getDate());
		model.setTitle(soapModel.getTitle());
		model.setLink(soapModel.getLink());
		model.setProjectId(soapModel.getProjectId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ProjectTimeline> toModels(
		ProjectTimelineSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ProjectTimeline> models = new ArrayList<ProjectTimeline>(soapModels.length);

		for (ProjectTimelineSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(eu.strasbourg.service.project.service.util.PropsUtil.get(
				"lock.expiration.time.eu.strasbourg.service.project.model.ProjectTimeline"));

	public ProjectTimelineModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _projectTimelineId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectTimelineId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectTimelineId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectTimeline.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectTimeline.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectTimelineId", getProjectTimelineId());
		attributes.put("startDay", getStartDay());
		attributes.put("spacing", getSpacing());
		attributes.put("date", getDate());
		attributes.put("title", getTitle());
		attributes.put("link", getLink());
		attributes.put("projectId", getProjectId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectTimelineId = (Long)attributes.get("projectTimelineId");

		if (projectTimelineId != null) {
			setProjectTimelineId(projectTimelineId);
		}

		Integer startDay = (Integer)attributes.get("startDay");

		if (startDay != null) {
			setStartDay(startDay);
		}

		Integer spacing = (Integer)attributes.get("spacing");

		if (spacing != null) {
			setSpacing(spacing);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}
	}

	@JSON
	@Override
	public long getProjectTimelineId() {
		return _projectTimelineId;
	}

	@Override
	public void setProjectTimelineId(long projectTimelineId) {
		_projectTimelineId = projectTimelineId;
	}

	@JSON
	@Override
	public int getStartDay() {
		return _startDay;
	}

	@Override
	public void setStartDay(int startDay) {
		_startDay = startDay;
	}

	@JSON
	@Override
	public int getSpacing() {
		return _spacing;
	}

	@Override
	public void setSpacing(int spacing) {
		_spacing = spacing;
	}

	@JSON
	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_columnBitmask = -1L;

		_date = date;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	@Override
	public String getLink() {
		if (_link == null) {
			return StringPool.BLANK;
		}
		else {
			return _link;
		}
	}

	@Override
	public void setLink(String link) {
		_link = link;
	}

	@JSON
	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_columnBitmask |= PROJECTID_COLUMN_BITMASK;

		if (!_setOriginalProjectId) {
			_setOriginalProjectId = true;

			_originalProjectId = _projectId;
		}

		_projectId = projectId;
	}

	public long getOriginalProjectId() {
		return _originalProjectId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ProjectTimeline.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProjectTimeline toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ProjectTimeline)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProjectTimelineImpl projectTimelineImpl = new ProjectTimelineImpl();

		projectTimelineImpl.setProjectTimelineId(getProjectTimelineId());
		projectTimelineImpl.setStartDay(getStartDay());
		projectTimelineImpl.setSpacing(getSpacing());
		projectTimelineImpl.setDate(getDate());
		projectTimelineImpl.setTitle(getTitle());
		projectTimelineImpl.setLink(getLink());
		projectTimelineImpl.setProjectId(getProjectId());

		projectTimelineImpl.resetOriginalValues();

		return projectTimelineImpl;
	}

	@Override
	public int compareTo(ProjectTimeline projectTimeline) {
		int value = 0;

		value = DateUtil.compareTo(getDate(), projectTimeline.getDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectTimeline)) {
			return false;
		}

		ProjectTimeline projectTimeline = (ProjectTimeline)obj;

		long primaryKey = projectTimeline.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ProjectTimelineModelImpl projectTimelineModelImpl = this;

		projectTimelineModelImpl._originalProjectId = projectTimelineModelImpl._projectId;

		projectTimelineModelImpl._setOriginalProjectId = false;

		projectTimelineModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ProjectTimeline> toCacheModel() {
		ProjectTimelineCacheModel projectTimelineCacheModel = new ProjectTimelineCacheModel();

		projectTimelineCacheModel.projectTimelineId = getProjectTimelineId();

		projectTimelineCacheModel.startDay = getStartDay();

		projectTimelineCacheModel.spacing = getSpacing();

		Date date = getDate();

		if (date != null) {
			projectTimelineCacheModel.date = date.getTime();
		}
		else {
			projectTimelineCacheModel.date = Long.MIN_VALUE;
		}

		projectTimelineCacheModel.title = getTitle();

		String title = projectTimelineCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			projectTimelineCacheModel.title = null;
		}

		projectTimelineCacheModel.link = getLink();

		String link = projectTimelineCacheModel.link;

		if ((link != null) && (link.length() == 0)) {
			projectTimelineCacheModel.link = null;
		}

		projectTimelineCacheModel.projectId = getProjectId();

		return projectTimelineCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{projectTimelineId=");
		sb.append(getProjectTimelineId());
		sb.append(", startDay=");
		sb.append(getStartDay());
		sb.append(", spacing=");
		sb.append(getSpacing());
		sb.append(", date=");
		sb.append(getDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", link=");
		sb.append(getLink());
		sb.append(", projectId=");
		sb.append(getProjectId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("eu.strasbourg.service.project.model.ProjectTimeline");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectTimelineId</column-name><column-value><![CDATA[");
		sb.append(getProjectTimelineId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDay</column-name><column-value><![CDATA[");
		sb.append(getStartDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spacing</column-name><column-value><![CDATA[");
		sb.append(getSpacing());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>link</column-name><column-value><![CDATA[");
		sb.append(getLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ProjectTimeline.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ProjectTimeline.class
		};
	private long _projectTimelineId;
	private int _startDay;
	private int _spacing;
	private Date _date;
	private String _title;
	private String _link;
	private long _projectId;
	private long _originalProjectId;
	private boolean _setOriginalProjectId;
	private long _columnBitmask;
	private ProjectTimeline _escapedModel;
}