package bear.replacer.core.rule;

import bear.replacer.core.rule.model.Rule;

import java.util.List;

public interface RuleLoader {

    List<Rule> load();
}
