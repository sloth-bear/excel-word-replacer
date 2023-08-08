package bear.excel.replacer.rule;

import bear.excel.replacer.rule.model.Rule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CsvRuleLoaderTest {

    @Test
    void csvTest() {
        // given
        final CsvRuleLoader csvRuleLoader = new CsvRuleLoader(ClassLoader.getSystemResourceAsStream("rule.csv"));

        // when
        final List<Rule> rules = csvRuleLoader.load();

        // then
        Assertions.assertThat(rules).hasSize(2);
    }

}