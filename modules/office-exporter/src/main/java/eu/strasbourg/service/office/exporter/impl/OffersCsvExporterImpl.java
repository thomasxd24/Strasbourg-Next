package eu.strasbourg.service.office.exporter.impl;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.ejob.model.Offer;
import eu.strasbourg.service.office.exporter.api.OffersCsvExporter;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.osgi.service.component.annotations.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Component(
	immediate = true,
	property = {},
	service = OffersCsvExporter.class
)
public class OffersCsvExporterImpl implements OffersCsvExporter {
	
	private ResourceBundle bundle = ResourceBundleUtil.getBundle("content.Language",
			this.getClass().getClassLoader());

	public boolean exportOffers(List <Offer> offers) {
		StringBundler csv = new StringBundler(); // StringBuilder du CSV

		// Le début est le même pour les deux modes
		csv.append(LanguageUtil.get(bundle, "offer-id") + ";");
		csv.append(LanguageUtil.get(bundle, "offer-url") + ";");
		csv.append(LanguageUtil.get(bundle, "title") + ";");
		csv.append(LanguageUtil.get(bundle, "description") + ";");
		csv.append(LanguageUtil.get(bundle, "publication-start-date") + ";");
		csv.append(LanguageUtil.get(bundle, "publication-end-date") + ";");
		csv.append(LanguageUtil.get(bundle, "diffusion"));
		csv.append(CharPool.NEW_LINE);

		// On construit notre CSV à partir de la liste des offres
		for (Offer offer : offers) {
			String url = "http://vm19012:8080/web/strasbourg.eu/test-azc/-/entity/id/" + offer.getOfferId();
			DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy");
			String startDate = dateFormat.format(offer.getPublicationStartDate());
			String endDate = dateFormat.format(offer.getPublicationEndDate());
			String description = "Du " + startDate + " au " + endDate;
			String diffusion = "";
			if(Validator.isNotNull(offer.getExportTotem()))
				diffusion = "Publié en " + offer.getExportTotem();

			csv.append(offer.getOfferId() + ";" + url + ";" + offer.getPost(Locale.FRANCE)
					+ ";" + description + ";" + startDate + ";" + endDate + ";" + diffusion);
			csv.append(CharPool.NEW_LINE);
		}

		String fileName = "interf_totems.csv";
//		byte[] bytes = csv.toString().replace('.', ',').getBytes();
//		String contentType = ContentTypes.APPLICATION_TEXT;
//		PortletResponseUtil.sendFile(resourceRequest, resourceResponse,
//				fileName, bytes, contentType);

		String fullPath = StrasbourgPropsUtil.getAgendaImportDirectory() + "/"
				+ fileName;
		File file = new File(fullPath);
		try (PrintWriter printWriter = new PrintWriter(file)) {
			printWriter.print(csv);
		} catch (FileNotFoundException e) {
			log.error(e);
		}

		try {
			String host = "localhost";
			int port = 21;
			String user = "";
			String password = "";

			FTPClient ftpClient = new FTPClient();
			ftpClient.connect(host, port);
			showServerReply(ftpClient);
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				log.error("Accès au serveur refusé. Code de l'erreur: " + replyCode);
				return false;
			}
			boolean success = ftpClient.login(user, password);
			showServerReply(ftpClient);
			if (!success) {
				log.error("Connexion au serveur échoué.");
				return false;
			} else {
				ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
				FileInputStream fileIS= new FileInputStream(fileName );
				ftpClient.storeFile(fileName, fileIS);
			}

			ftpClient.logout();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	private void showServerReply(FTPClient ftp) {
		String[] replies = ftp.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				log.info("SERVER: " + aReply);
			}
		}
	}

	Log log = LogFactoryUtil.getLog(this.getClass());
}
