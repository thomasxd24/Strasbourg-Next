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

package eu.strasbourg.service.petition.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Petition service. Represents a row in the &quot;petition_Petition&quot; database table, with each column mapped to a property of this class.
 *
 * @author Alexandre QUERE
 * @see PetitionModel
 * @see eu.strasbourg.service.petition.model.impl.PetitionImpl
 * @see eu.strasbourg.service.petition.model.impl.PetitionModelImpl
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.petition.model.impl.PetitionImpl")
@ProviderType
public interface Petition extends PetitionModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link eu.strasbourg.service.petition.model.impl.PetitionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Petition, Long> PETITION_ID_ACCESSOR = new Accessor<Petition, Long>() {
			@Override
			public Long get(Petition petition) {
				return petition.getPetitionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Petition> getTypeClass() {
				return Petition.class;
			}
		};
}