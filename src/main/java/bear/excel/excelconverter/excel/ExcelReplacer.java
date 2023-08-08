package bear.excel.excelconverter.excel;

import bear.excel.excelconverter.rule.model.Rule;
import org.apache.poi.ss.usermodel.*;

import java.util.List;

public class ExcelReplacer {

    private final Workbook workbook;
    private final List<Rule> rules;

    public ExcelReplacer(final Workbook workbook, final List<Rule> rules) {
        this.workbook = workbook;
        this.rules = rules;
    }

    public Workbook replace() {
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    replaceByRules(cell);
                }
            }
        }

        return workbook;
    }

    private void replaceByRules(final Cell cell) {
        if (cell.getCellType() == CellType.STRING) {
            String cellValue = cell.getStringCellValue();

            for (Rule rule : rules) {
                if (cellValue.contains(rule.getWord())) {
                    cellValue = cellValue.replace(rule.getWord(), rule.getReplaceWord());
                    cell.setCellValue(cellValue);
                }
            }
        }
    }
}
