package bear.excel.excelconverter;

import bear.excel.excelconverter.excel.ExcelLoader;
import bear.excel.excelconverter.excel.ExcelReplacer;
import bear.excel.excelconverter.excel.ExcelWriter;
import bear.excel.excelconverter.rule.CsvRuleLoader;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ExcelConverterApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(ExcelConverterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ExcelConverterApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (args.length != 2) {
            System.out.println(args[0]);
            LOG.info("1. 사용방법: replacer <inputFilePath> <outputFilePath>");
            LOG.info("2. 예시: replacer ./test-excel.xlsx ./test-excel2.xlsx");
            return;
        }

        final String input = args[0];
        final String output = args[1];

        final String rule = "C:\\Users\\admin\\Documents\\git-repo\\excel-word-replacer\\src\\main\\resources\\rule\\rule.csv";

        LOG.info("대상 파일: {}", input);
        LOG.info("대체할 문자열: {}", rule);

        final ExcelLoader excelLoader = new ExcelLoader(input);

        try (final Workbook workbook = excelLoader.load()) {
            final ExcelReplacer replacer = new ExcelReplacer(workbook, CsvRuleLoader.of(rule).load());
            final Workbook replaced = replacer.replace();

            LOG.info("Replacing workbook to: {}", output);

            final ExcelWriter excelWriter = new ExcelWriter();
            excelWriter.write(replaced, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
