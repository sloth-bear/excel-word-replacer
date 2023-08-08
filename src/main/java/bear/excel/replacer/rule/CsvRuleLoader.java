package bear.excel.replacer.rule;

import bear.excel.replacer.rule.model.Rule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvRuleLoader implements RuleLoader {

    private final String filePath;

    public CsvRuleLoader(final String filePath) {
        this.filePath = filePath;
    }

    public static CsvRuleLoader of(final String filePath) {
        return new CsvRuleLoader(filePath);
    }

    public List<Rule> load() {
        List<Rule> rules = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
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
