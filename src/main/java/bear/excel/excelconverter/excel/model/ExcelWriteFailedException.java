package bear.excel.excelconverter.excel.model;

public class ExcelWriteFailedException extends RuntimeException {

    public ExcelWriteFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
