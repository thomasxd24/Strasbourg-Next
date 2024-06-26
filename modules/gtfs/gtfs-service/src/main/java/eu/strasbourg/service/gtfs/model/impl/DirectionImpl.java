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

package eu.strasbourg.service.gtfs.model.impl;

import org.osgi.annotation.versioning.ProviderType;
import eu.strasbourg.service.gtfs.model.Ligne;
import eu.strasbourg.service.gtfs.service.LigneLocalServiceUtil;

/**
 * The extended model implementation for the Direction service. Represents a row in the &quot;gtfs_Direction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.gtfs.model.Direction} interface.
 * </p>
 *
 * @author Cedric Henry
 */
@ProviderType
public class DirectionImpl extends DirectionBaseImpl {

	private static final long serialVersionUID = 7661063929068068674L;

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a direction model instance should use the {@link eu.strasbourg.service.gtfs.model.Direction} interface instead.
	 */
	public DirectionImpl() {
	}

	/**
	 * Renvoie la Ligne de cette direction
	 */
	@Override
	public Ligne getLigne() {
		return LigneLocalServiceUtil.getByRouteId(this.getRouteId());
	}
}