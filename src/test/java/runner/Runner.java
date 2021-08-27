package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".\\src\\test\\java\\features"},
		glue= {"stepdefinitions","hook"},
		dryRun = false,
		tags="@SmokeTest",//group executions
		monochrome = true,
		plugin = {"pretty",
				"html:target/cucumberReport.html",
				"json:target/cucumberjson.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class Runner extends AbstractTestNGCucumberTests{
}
