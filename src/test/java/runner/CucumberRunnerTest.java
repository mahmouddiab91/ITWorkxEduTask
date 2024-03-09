package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features", glue = "definitions",
        plugin = {"pretty"})
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

}