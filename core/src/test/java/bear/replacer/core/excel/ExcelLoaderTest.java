package bear.replacer.core.excel;

import bear.replacer.core.excel.model.ExcelLoadFailedException;
import org.apache.poi.ss.usermodel.Workbook;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Paths;

class ExcelLoaderTest {

    @Test
    void givenExcelFile_whenLoad_thenReturnXSSFWorkbook() throws IOException {
        // given
        final ClassPathResource resource = new ClassPathResource("input/test_excel.xlsx");
        final ExcelLoader excelLoader = new ExcelLoader(Paths.get(resource.getURI()).toString());

        // when
        final Workbook workbook = excelLoader.load();

        // then
        Assertions.assertThat(workbook).isNotNull();
        Assertions.assertThat(workbook.getNumberOfSheets()).isGreaterThan(0);
    }

    @Test
    void givenNonExcelFile_whenLoad_thenThrownExcelLoadFailedException() throws IOException {
        // given
        final ClassPathResource resource = new ClassPathResource("rule.csv");
        final ExcelLoader excelLoader = new ExcelLoader(Paths.get(resource.getURI()).toString());

        // when && then
        Assertions.assertThatThrownBy(excelLoader::load).isInstanceOf(ExcelLoadFailedException.class);
    }
}