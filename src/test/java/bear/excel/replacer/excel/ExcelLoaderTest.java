package bear.excel.replacer.excel;

import bear.excel.replacer.excel.model.ExcelLoadFailedException;
import org.apache.poi.ss.usermodel.Workbook;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ExcelLoaderTest {

    @Test
    void givenExcelFile_whenLoad_thenReturnXSSFWorkbook() {
        // given
        final String filePath = "C:\\Users\\admin\\Documents\\git-repo\\excel-word-replacer\\src\\test\\resources\\input\\test_excel.xlsx";
        final ExcelLoader excelLoader = new ExcelLoader(filePath);

        // when
        final Workbook workbook = excelLoader.load();

        // then
        Assertions.assertThat(workbook).isNotNull();
        Assertions.assertThat(workbook.getNumberOfSheets()).isGreaterThan(0);
    }

    @Test
    void givenNonExcelFile_whenLoad_thenThrownExcelLoadFailedException() {
        // given
        final String csvFilePath = "C:\\Users\\admin\\Documents\\git-repo\\excel-word-replacer\\src\\test\\resources\\rule.csv";
        final ExcelLoader excelLoader = new ExcelLoader(csvFilePath);

        // when && then
        Assertions.assertThatThrownBy(excelLoader::load).isInstanceOf(ExcelLoadFailedException.class);
    }
}