package bear.replacer.core.excel;

import bear.replacer.core.rule.CsvRuleLoader;
import bear.replacer.core.rule.RuleLoader;
import bear.replacer.core.rule.model.Rule;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class ExcelWordReplacer {

    private static final Logger LOG = LoggerFactory.getLogger(ExcelWordReplacer.class);

    private final String sourceFilePath;
    private final String targetFilePath;

    public void replace() {
        final ExcelLoader excelLoader = new ExcelLoader(sourceFilePath);
        System.out.println("==============replace=================");
        System.out.println(ClassLoader.getSystemClassLoader().getResource(""));

        try (final Workbook workbook = excelLoader.load()) {
            final RuleLoader ruleLoader = new CsvRuleLoader(ClassLoader.getSystemClassLoader().getResourceAsStream("rule\\rule.csv"));
            final List<Rule> rules = ruleLoader.load();
            LOG.info("대체할 문자열: {}", rules);

            final ExcelReplacer replacer = new ExcelReplacer(workbook, rules);
            final Workbook replaced = replacer.replace();

            LOG.info("Replacing workbook to: {}", targetFilePath);

            final ExcelWriter excelWriter = new ExcelWriter();
            excelWriter.write(replaced, targetFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
