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

package eu.strasbourg.service.council.model.impl;

import org.osgi.annotation.versioning.ProviderType;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import eu.strasbourg.service.council.model.CouncilSession;
import eu.strasbourg.service.council.model.Official;
import eu.strasbourg.service.council.model.Procuration;
import eu.strasbourg.service.council.model.Type;
import eu.strasbourg.service.council.service.OfficialLocalServiceUtil;
import eu.strasbourg.service.council.service.ProcurationLocalServiceUtil;
import eu.strasbourg.service.council.service.TypeLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;

import java.util.List;

/**
 * The extended model implementation for the CouncilSession service. Represents a row in the &quot;council_CouncilSession&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.council.model.CouncilSession} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class CouncilSessionImpl extends CouncilSessionBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a council session model instance should use the {@link eu.strasbourg.service.council.model.CouncilSession} interface instead.
	 */

	public static final String MUNICIPAL = "municipal";
	public static final String EUROMETROPOLITAN = "eurometropolitan";

	public CouncilSessionImpl() {
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public AssetEntry getAssetEntry() {
		return AssetEntryLocalServiceUtil.fetchEntry(CouncilSession.class.getName(), this.getCouncilSessionId());
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	@Override
	public List<AssetCategory> getCategories() {
		return AssetVocabularyHelper.getAssetEntryCategories(this.getAssetEntry());
	}

	/**
	 * Renvoie la liste des procurations rattachées à cette sessions
	 */
	@Override
	public List<Procuration> getProcurations() {
		return ProcurationLocalServiceUtil.findByCouncilSessionId(this.getCouncilSessionId());
	}

	/**
	 * Renvoie l'élu président du conseil rattachées à cette sessions
	 */
	@Override
	public Official getOfficialLeader() {
		return OfficialLocalServiceUtil.fetchOfficial(this.getOfficialLeaderId());
	}

	/**
	 * Renvoie le type de conseil rattachées à cette sessions
	 */
	@Override
	public Type getTypeCouncil() {
		return TypeLocalServiceUtil.fetchType(this.getTypeId());
	}

	/**
	 * Renvoie le nom complet de l'élu président du conseil
	 */
	@Override
	public String getOfficialLeaderFullName() {
		Official official = this.getOfficialLeader();
		return official != null ? official.getFullName() : "";
	}

}