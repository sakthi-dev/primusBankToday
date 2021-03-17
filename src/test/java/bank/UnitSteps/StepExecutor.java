package bank.UnitSteps;

import bank.methods.SeleniumOperations;

public class StepExecutor {

	public static void main(String[] args) {
		// Launch browser
		Object[] input1 = new Object[2];
		input1[0] = "LINUX";
		input1[1] = "Chrome";
		SeleniumOperations.operatingSystem(input1);
		// Open Application
		Object[] input2 = new Object[1];
		input2[0] = "http://primusbank.qedgetech.com/";
		SeleniumOperations.openApplication(input2);
		// Enter User name
		Object[] input3 = new Object[2];
		input3[0] = "//*[@name='txtuId']";
		input3[1] = "Admin";
		SeleniumOperations.sendKeys(input3);
		// Enter Password
		Object[] input4 = new Object[2];
		input4[0] = "//*[@name='txtPword']";
		input4[1] = "Admin";
		SeleniumOperations.sendKeys(input4);
		// Click Login Button
		Object[] input5 = new Object[1];
		input5[0] = "//*[@name='login']";
		SeleniumOperations.click(input5);
		// Click on Branches
		Object[] input6 = new Object[1];
		input6[0] = "//*[@src='images/Branches_but.jpg']";
		SeleniumOperations.click(input6);
		// Select Country
		Object[] input7 = new Object[2];
		input7[0] = "//*[@name='lst_countryS']";
		input7[1] = "INDIA";
		SeleniumOperations.selectDropDownByVisibileText(input7);

		// Select State

		Object[] input8 = new Object[2];
		input8[0] = "//*[@name='lst_stateS']";
		input8[1] = "Andhra Pradesh";
		SeleniumOperations.selectDropDownByVisibileText(input8);
		// Select City
		Object[] input9 = new Object[2];
		input9[0] = "//*[@name='lst_cityS']";
		input9[1] = "Hyderabad";
		SeleniumOperations.selectDropDownByVisibileText(input9);
		System.out.println("Automation Script ran successfully");
		// Verify the message in the landing page
		Object[] welcome = new Object[2];
		welcome[0] = "//*[text()='Admin']";
		welcome[2] = "Admin";
		SeleniumOperations.messageValidtion(welcome);
	}
}
