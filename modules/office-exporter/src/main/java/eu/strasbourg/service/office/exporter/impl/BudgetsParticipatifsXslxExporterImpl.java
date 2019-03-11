package eu.strasbourg.service.office.exporter.impl;

import static org.apache.commons.text.StringEscapeUtils.unescapeHtml4;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import eu.strasbourg.service.office.exporter.api.BudgetsParticipatifsXlsxExporter;
import eu.strasbourg.service.project.model.BudgetParticipatif;

@Component(
        immediate = true,
        service = BudgetsParticipatifsXlsxExporter.class
)
public class BudgetsParticipatifsXslxExporterImpl implements BudgetsParticipatifsXlsxExporter {

    private ResourceBundle bundle = ResourceBundleUtil.getBundle("content.Language",
            this.getClass().getClassLoader());

    @Override
    public void exportBudgetsParticipatifs(OutputStream stream, List<BudgetParticipatif> budgetsParticipatifs) {
        // Initialisation du document
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Creation du document
        XSSFSheet sheet = workbook.createSheet("Export budget participatif");

        // Initialisation des colonnes
        Object[][] budgetParticipatifData = {{
                LanguageUtil.get(bundle, "budget-part-phase"),
                LanguageUtil.get(bundle, "budget-part-statut"),
                LanguageUtil.get(bundle, "budget-part-title"),
                LanguageUtil.get(bundle, "budget-part-description"),
                LanguageUtil.get(bundle, "budget-part-create-date"),
                LanguageUtil.get(bundle, "budget-part-modified-date"),
                LanguageUtil.get(bundle, "budget-part-budget"),
                LanguageUtil.get(bundle, "budget-part-motif"),
                LanguageUtil.get(bundle, "budget-part-lastname"),
                LanguageUtil.get(bundle, "budget-part-firstname"),
                LanguageUtil.get(bundle, "budget-part-address"),
                LanguageUtil.get(bundle, "budget-part-postalcode"),
                LanguageUtil.get(bundle, "budget-part-city"),
                LanguageUtil.get(bundle, "budget-part-phone"),
                LanguageUtil.get(bundle, "budget-part-mobile"),
                LanguageUtil.get(bundle, "budget-part-email"),
                LanguageUtil.get(bundle, "budget-part-place-text-area"),
                LanguageUtil.get(bundle, "budget-part-is-crush"),
                LanguageUtil.get(bundle, "budget-part-crush-comment"),
                LanguageUtil.get(bundle, "thematic"),
                LanguageUtil.get(bundle, "districts"),
                LanguageUtil.get(bundle, "project"),
                LanguageUtil.get(bundle, "user-liferay")
        }};

        // Parcours des budget et creation de la ligne a ajouter dans l'excel
        for (BudgetParticipatif budgetParticipatif : budgetsParticipatifs) {
            Object[] budgetParticipatifRow = {
                    getfield(unescapeHtml4(budgetParticipatif.getPhaseTitleLabel())),
                    getfield(unescapeHtml4(budgetParticipatif.getBudgetParticipatifStatusTitle(Locale.FRANCE))),
                    getfield(unescapeHtml4(budgetParticipatif.getTitle())),
                    getfield(unescapeHtml4(budgetParticipatif.getDescription())),
                    getfield(budgetParticipatif.getCreateDate()),
                    getfield(budgetParticipatif.getModifiedDate()),
                    getfield(budgetParticipatif.getBudget()),
                    getfield(unescapeHtml4(budgetParticipatif.getMotif())),
                    getfield(unescapeHtml4(budgetParticipatif.getCitoyenLastname())),
                    getfield(unescapeHtml4(budgetParticipatif.getCitoyenFirstname())),
                    getfield(unescapeHtml4(budgetParticipatif.getCitoyenAdresse())),
                    getfield(budgetParticipatif.getCitoyenPostalCode()),
                    getfield(budgetParticipatif.getCitoyenCity()),
                    getfield(budgetParticipatif.getCitoyenPhone()),
                    getfield(budgetParticipatif.getCitoyenMobile()),
                    getfield(budgetParticipatif.getCitoyenEmail()),
                    getfield(unescapeHtml4(budgetParticipatif.getPlaceTextArea())),
                    getfield(budgetParticipatif.getIsCrush()),
                    getfield(budgetParticipatif.getCrushComment()),
                    getfield(budgetParticipatif.getThematicsLabel(Locale.FRANCE)),
                    getfield(budgetParticipatif.getDistrictLabel(Locale.FRANCE)),
                    getfield(budgetParticipatif.getProjectName()),
                    getfield(budgetParticipatif.getUserName())
            };

            budgetParticipatifData = ArrayUtil.append(budgetParticipatifData, budgetParticipatifRow);
        }

        // Parcours et ajout des donnees dans les cellules
        int rowIndex = 0;
        int columnIndex = 0;

        for (Object[] budgetParticipatifObject : budgetParticipatifData) {
            Row row = sheet.createRow(rowIndex);
            columnIndex = 0;
            for (Object field : budgetParticipatifObject) {
                Cell cell = row.createCell(columnIndex);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
                columnIndex++;
            }
            rowIndex++;
        }

        try {
            workbook.write(stream);
            workbook.close();
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getfield(Date param) {
        DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("dd/MM/yyyy");
        String result = "";
        if (param != null)
            result = dateFormat.format(param);
        return result;
    }

    private String getfield(String param) {
        String result = "";
        if (param != null && !param.isEmpty())
            result = param;
        return result;
    }

    private String getfield(boolean param) {
        return param ? "oui" : "non";
    }

    private String getfield(long param) {
        String result = "";
        if (param != 0L)
            result = String.valueOf(param);
        return result;
    }

    private String getfield(int param) {
        String result = "";
        if (param != 0)
            result = String.valueOf(Math.toIntExact(param));
        return result;
    }

}
