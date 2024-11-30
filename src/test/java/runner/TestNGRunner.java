package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/resources/features", // Path to the feature files
    glue = {"stepDefinitions"}, // Path to step definitions
    plugin = {
        "pretty", // Pretty console output
        "html:target/cucumber-reports.html", // HTML report
        "json:target/cucumber-reports.json" // JSON report
    },
    monochrome = true // Makes console output more readable
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
