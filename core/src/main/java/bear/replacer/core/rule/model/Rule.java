package bear.replacer.core.rule.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Rule {

    private final String word;
    private final String replaceWord;

    @Override
    public String toString() {
        return String.format("[Rule] word: %s ===> replaceWord: %s", word, replaceWord);
    }
}
