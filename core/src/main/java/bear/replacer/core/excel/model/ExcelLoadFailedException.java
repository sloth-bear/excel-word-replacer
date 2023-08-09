package bear.replacer.core.excel.model;

public class ExcelLoadFailedException extends RuntimeException {

    public ExcelLoadFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
