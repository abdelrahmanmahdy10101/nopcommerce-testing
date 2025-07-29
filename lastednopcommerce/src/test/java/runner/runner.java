package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/features/", // path to your feature files
        glue = "tests", // package with step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class runner extends AbstractTestNGCucumberTests {
}