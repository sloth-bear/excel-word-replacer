package bear.excel.excelconverter.rule;

import bear.excel.excelconverter.rule.model.Rule;

import java.util.List;

public interface RuleLoader {

    List<Rule> load();
}
