package bank.cucumbermap;



import java.util.Hashtable;

import bank.methods.HTMLReportGenerator;
import bank.methods.SeleniumOperations;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {

	@When("^user opens \"([^\"]*)\" OperatingSystem and user opens \"([^\"]*)\" browser$")
	public void user_opens_OperatingSystem_and_user_opens_browser(String opsys, String bname) {
		Object[] input = new Object[2];
		input[0] = opsys;
		input[1] = bname;
		SeleniumOperations.operatingSystem(input);
	}
	
	@When("^user enters the url \"([^\"]*)\"$")
	public void user_enters_the_url(String applink) {
		Object[] input2 = new Object[1];
		input2[0] = applink;
		SeleniumOperations.openApplication(input2);
	}
	@When("^user enters \"([^\"]*)\" as username$")
	public void user_enters_as_username(String uname) {

		Object[] input3 = new Object[2];
		input3[0] = "//*[@name='txtuId']";
		input3[1] = uname;
		Hashtable<String,Object> input3op = SeleniumOperations.sendKeys(input3);
		HTMLReportGenerator.StepDetails((String) input3op.get("STATUS".toString()),"user enters \\\"([^\\\"]*)\\\" as username", input3op.get("MESSAGE").toString());
	}
	@When("^user enters \"([^\"]*)\" as password$")
	public void user_enters_as_password(String pass) {
		Object[] input4 = new Object[2];
		input4[0] = "//*[@name='txtPword']";
		input4[1] = pass;
		Hashtable<String,Object> input4op = SeleniumOperations.sendKeys(input4);
		HTMLReportGenerator.StepDetails((String) input4op.get("STATUS".toString()),"user enters \\\"([^\\\"]*)\\\" as password", input4op.get("MESSAGE").toString());
	}
	@When("^user clicks on login  button$")
	public void user_clicks_on_login_button() throws Throwable {
		Object[] input5 = new Object[1];
		input5[0] = "//*[@name='login']";
		Hashtable<String,Object> input5op = SeleniumOperations.click(input5);
		HTMLReportGenerator.StepDetails((String) input5op.get("STATUS".toString()),"user clicks on login  button", input5op.get("MESSAGE").toString());	}

	@Then("^user is on the \"([^\"]*)\" main page and get message as welcome to Admin$")
	public void user_is_on_the_main_page_and_get_message_as_welcome_to_Admin(String msg) {
		Object[] welcome = new Object[2];
		welcome[0] = "//*[text()='Admin']";
		welcome[1] = msg;
		Hashtable<String,Object> welcomeop = SeleniumOperations.messageValidtion(welcome);
		HTMLReportGenerator.StepDetails((String) welcomeop.get("STATUS".toString()),"user is on the \\\"([^\\\"]*)\\\" main page and get message as welcome to Admin", welcomeop.get("MESSAGE").toString());
		
	}
	
	}


