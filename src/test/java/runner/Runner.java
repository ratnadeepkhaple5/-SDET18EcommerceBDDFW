package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".\\src\\test\\java\\features"},
		glue= {"stepdefinitions","hook"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty",
				"html:target/cucumberReport.html",
				"json:target/cucumberjson.json"}
		)

public class Runner extends AbstractTestNGCucumberTests{
}
