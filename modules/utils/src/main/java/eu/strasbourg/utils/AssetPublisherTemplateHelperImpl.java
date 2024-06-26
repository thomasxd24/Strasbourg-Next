package eu.strasbourg.utils;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.utils.api.AssetPublisherTemplateHelperService;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = {},
        service = AssetPublisherTemplateHelperService.class)
public class AssetPublisherTemplateHelperImpl implements AssetPublisherTemplateHelperService {

    /**
     * Retourne la largeur/hauteur d'une image
     */
    @Override
    public String getImageWidthHeight(String filePath) {
        return AssetPublisherTemplateHelper.getImageWidthHeight(filePath);
    }

    /**
     * Récupère l'URL d'une image à partir des données fournies par la Structure d'un WebContent
     */
    @Override
    public String getDocumentUrl(String documentStructure){
        return AssetPublisherTemplateHelper.getDocumentUrl(documentStructure);
    }

    /**
     * Récupère l'Id d'une image à partir des données fournies par la Structure d'un WebContent
     */
    @Override
    public long getDocumentId(String documentStructure){
        return AssetPublisherTemplateHelper.getDocumentId(documentStructure);
    }

    @Override
    public String slugify(String s) {
        return AssetPublisherTemplateHelper.slugify(s);
    }

    /**
     * Remplace le renderUrl de liferay pour le site des musees
     */
    @Override
    public String createRenderUrlMusee(String type, String musee){
        return AssetPublisherTemplateHelper.createRenderUrlMusee(type,  musee);
    }
}
