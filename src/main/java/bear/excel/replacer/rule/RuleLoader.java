package bear.excel.replacer.rule;

import bear.excel.replacer.rule.model.Rule;

import java.util.List;

public interface RuleLoader {

    List<Rule> load();
}
