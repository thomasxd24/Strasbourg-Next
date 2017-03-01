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

package eu.strasbourg.service.place.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the SubPlace service. Represents a row in the &quot;place_SubPlace&quot; database table, with each column mapped to a property of this class.
 *
 * @author Angelique Zunino Champougny
 * @see SubPlaceModel
 * @see eu.strasbourg.service.place.model.impl.SubPlaceImpl
 * @see eu.strasbourg.service.place.model.impl.SubPlaceModelImpl
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.place.model.impl.SubPlaceImpl")
@ProviderType
public interface SubPlace extends SubPlaceModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link eu.strasbourg.service.place.model.impl.SubPlaceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SubPlace, Long> SUB_PLACE_ID_ACCESSOR = new Accessor<SubPlace, Long>() {
			@Override
			public Long get(SubPlace subPlace) {
				return subPlace.getSubPlaceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SubPlace> getTypeClass() {
				return SubPlace.class;
			}
		};

	/**
	* Retourne les ScheduleExceptions du sous-lieu
	*/
	public java.util.List<eu.strasbourg.service.place.model.ScheduleException> getScheduleExceptions();

	/**
	* Retourne les Periods du sous-lieu
	*/
	public java.util.List<eu.strasbourg.service.place.model.Period> getPeriods();
}