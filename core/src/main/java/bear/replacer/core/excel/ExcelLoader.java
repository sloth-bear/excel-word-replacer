package bear.replacer.core.excel;

import bear.replacer.core.excel.model.ExcelLoadFailedException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

@RequiredArgsConstructor
public class ExcelLoader {

    private final String filePath;

    public Workbook load() {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            return new XSSFWorkbook(fis);
        } catch (Exception e) {
            throw new ExcelLoadFailedException("Cannot load excel file: " + filePath, e);
        }
    }
}
