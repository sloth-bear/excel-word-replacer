# excel-word-replacer

## Usage

### Cli

```bash
./gradlew bootRun --args="'<inputFile>' '<outputFile>'"
```

When you execute a command
like `./gradlew bootRun --args="'C:\\Users\\admin\\Downloads\\test.xlsx' 'C:\\Users\\admin\\Downloads\\replaced_test.xlsx'"`,
it processes the `resources/rule/rule.csv` file from the classpath of this project. Then, it replaces all occurrences of
words in the input file with the word `String`, creating an output file at the specified path.