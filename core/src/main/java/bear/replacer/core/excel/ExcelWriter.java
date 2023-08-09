package bear.replacer.core.excel;

import bear.replacer.core.excel.model.ExcelWriteFailedException;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;

public class ExcelWriter {

    public void write(final Workbook workbook, final String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
        } catch (Exception e) {
            throw new ExcelWriteFailedException("Cannot writing excel to file system: " + filePath, e);
        }
    }

}
