package bear.replacer.core.excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class ExcelWriterTest {

    private static final String OUTPUT_FILE_PATH = "C:\\Users\\admin\\Documents\\git-repo\\excel-word-replacer\\src\\test\\resources\\output\\writing_test.xlsx";

    @AfterEach
    void teardown() {
        File file = new File(OUTPUT_FILE_PATH);

        if (file.exists() && file.delete()) {
            System.out.println("File deleted successfully: " + OUTPUT_FILE_PATH);
        }
    }

    @Test
    void givenWorkbook_whenWrite_thenWritingToFileSystem() throws IOException {
        // given && when
        try (final Workbook workbook = new XSSFWorkbook()) {
            workbook.createSheet("TEST_SHEET");

            final ExcelWriter excelWriter = new ExcelWriter();
            excelWriter.write(workbook, OUTPUT_FILE_PATH);
        }

        // then
        ExcelLoader excelLoader = new ExcelLoader(OUTPUT_FILE_PATH);
        final Workbook workbook = excelLoader.load();

        Assertions.assertThat(workbook).isNotNull();
        Assertions.assertThat(workbook.getNumberOfSheets()).isGreaterThan(0);
        Assertions.assertThat(workbook.getSheet("TEST_SHEET")).isNotNull();
    }
}