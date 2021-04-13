package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		
		features="./src/test/resources/apiFeatures",
		glue= {"api/stepDefinitions"},
		dryRun=false,
		monochrome=true,
		tags= {"@SW01"},
		plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber.json" }
		
		)





public class Runner {

}
