package eu.strasbourg.utils;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;

import eu.strasbourg.utils.api.AssetVocabularyHelperService;

/**
 * Classe Helper pour tout ce qui concerne les vocabulaires
 *
 */
@Component(
    immediate = true,
    property = {
    },
    service = AssetVocabularyHelperService.class
)
public class AssetVocabularyHelperImpl implements AssetVocabularyHelperService {
	@Override
	public List<AssetVocabulary> getVocabulariesForAssetType(long groupId, long classNameId) {
		return AssetVocabularyHelper.getVocabulariesForAssetType(groupId, classNameId);
	}

	/**
	 * Retourne la liste des catégories rattachées à un AssetEntry
	 */
	@Override
	public List<AssetCategory> getAssetEntryCategories(
		AssetEntry entry) {
		return AssetVocabularyHelper.getAssetEntryCategories(entry);
	}

	/**
	 * Retourne la liste des catégories d'un vocabulaire spécifique rattachées à
	 * un AssetEntry
	 * 
	 */
	@Override
	public List<AssetCategory> getAssetEntryCategoriesByVocabulary(
		AssetEntry entry, String vocabularyName) {
		return AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(entry, vocabularyName);
	}

	/**
	 * Retourne la valeur d'une propriété d'une catégorie
	 * Retourne une chaîne vide si la propriété n'existe pas
	 */
	@Override
	public String getCategoryProperty(long categoryId, String key) {
		return AssetVocabularyHelper.getCategoryProperty(categoryId, key);
	}
}
