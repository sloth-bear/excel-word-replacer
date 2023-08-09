package bear.replacer.cli;

import bear.replacer.core.excel.ExcelWordReplacer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExcelConverterApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ExcelConverterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ExcelConverterApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (args.length != 2) {
            LOG.info("1. 사용방법: replacer <inputFilePath> <outputFilePath>");
            LOG.info("2. 예시: replacer ./test-excel.xlsx ./test-excel2.xlsx");
            return;
        }

        final String input = args[0];
        final String output = args[1];

        LOG.info("대상 파일: {}", input);
        final ExcelWordReplacer excelWordReplacer = new ExcelWordReplacer(input, output);
        excelWordReplacer.replace();
    }
}
