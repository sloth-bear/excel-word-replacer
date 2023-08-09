# excel-word-replacer

## Usage

### Cli

```bash
./gradlew :cli:bootRun --args="'<inputFile>' '<outputFile>'"
```

You can execute a command
like `./gradlew :cli:bootRun --args="'C:\\Users\\admin\\Downloads\\test.xlsx' 'C:\\Users\\admin\\Downloads\\replaced_test.xlsx'"`,
then it replaces all `String` type words based on `resources/rule/rule.csv` in `core` module, and creates output file at
the `<outputFile>`.