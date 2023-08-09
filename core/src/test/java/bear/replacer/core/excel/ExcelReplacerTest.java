package bear.replacer.core.excel;

import bear.replacer.core.rule.CsvRuleLoader;
import bear.replacer.core.rule.RuleLoader;
import org.apache.poi.ss.usermodel.Workbook;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ExcelReplacerTest {

    private static final String EXCEL_FILE_PATH = "C:\\Users\\admin\\Documents\\git-repo\\excel-word-replacer\\src\\test\\resources\\input\\test_excel.xlsx";
    private static final String RULE_FILE_PATH = "rule.csv";

    @Test
    void givenWorkbook_whenReplace_thenReturnReplacedWorkbook() {
        // given
        final ExcelLoader excelLoader = new ExcelLoader(EXCEL_FILE_PATH);
        final Workbook source = excelLoader.load();

        final RuleLoader ruleLoader = new CsvRuleLoader(ClassLoader.getSystemResourceAsStream(RULE_FILE_PATH));
        final ExcelReplacer replacer = new ExcelReplacer(source, ruleLoader.load());

        // when
        final Workbook result = replacer.replace();

        // then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getNumberOfSheets()).isEqualTo(source.getNumberOfSheets());
    }

}