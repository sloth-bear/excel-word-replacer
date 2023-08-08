package bear.excel.excelconverter.excel.model;

public class ExcelLoadFailedException extends RuntimeException {

    public ExcelLoadFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
