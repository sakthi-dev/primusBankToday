package bank.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
		(
		plugin ="pretty",
		features = "/home/hp/New_Framework/PrimusBankNew/PrimusBankNew/src/test/resources/BUSINESS_LOGIC/CUCUMBER_SUITES",
		tags = "@SmokeTest",
		glue = "bank.cucumbermap",
		monochrome = true	
		)

public class RunTest {
	
	

}
