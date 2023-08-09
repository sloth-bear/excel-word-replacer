package bear.replacer.core.rule;

import bear.replacer.core.rule.model.Rule;
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