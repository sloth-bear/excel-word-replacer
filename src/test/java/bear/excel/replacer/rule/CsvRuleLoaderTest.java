package bear.excel.excelconverter.rule;

import bear.excel.excelconverter.rule.model.Rule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CsvRuleLoaderTest {

    @Test
    void csvTest() {
        // given
        String csvFile = "C:\\Users\\admin\\Documents\\git-repo\\excel-word-replacer\\src\\test\\resources\\rule.csv";
        CsvRuleLoader csvRuleLoader = new CsvRuleLoader(csvFile);

        // when
        List<Rule> rules = csvRuleLoader.load();

        // then
        Assertions.assertThat(rules).hasSize(2);
    }

}