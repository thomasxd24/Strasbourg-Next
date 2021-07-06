package eu.strasbourg.utils.api;

import aQute.bnd.annotation.ProviderType;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Map;

/**
 * Classe de service qui peut être utilisée dans les templates L'implémentation
 * appelle des fonctions statiques présentes dans les classes Helper classiques
 * 
 * @author Benjamin Bini
 *
 */
@ProviderType
public interface UriHelperService {

	public URI appendUri(String uri, String appendQuery) throws URISyntaxException;

	public URI appendUriImagePreview(String uri) throws URISyntaxException;
}
