package bear.excel.replacer.rule;

import bear.excel.replacer.rule.model.Rule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvRuleLoader implements RuleLoader {

    private final InputStream inputStream;

    public CsvRuleLoader(final InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public List<Rule> load() {
        List<Rule> rules = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 2) {
                    rules.add(new Rule(values[0], values[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rules;
    }
}
