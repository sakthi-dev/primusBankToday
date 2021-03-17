package bank.methods;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class SeleniumOperations {

	public static WebDriver driver = null;
	public static Hashtable<String, Object> outputparameters = new Hashtable<String, Object>();

	public static Hashtable<String, Object> operatingSystem(Object[] inputparameters) {

		{
			try {
				String os = (String) inputparameters[0];
				String strBrowserName = (String) inputparameters[1];

				if (os.equalsIgnoreCase("LINUX") && strBrowserName.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
					driver = new ChromeDriver();
					driver.manage().window().maximize();

				} else if (os.equalsIgnoreCase("LINUX") && strBrowserName.equalsIgnoreCase("Edge")) {
					WebDriverManager.edgedriver().operatingSystem(OperatingSystem.LINUX).setup();
					driver = new EdgeDriver();
					driver.manage().window().maximize();
				} else if (os.equalsIgnoreCase("LINUX") && strBrowserName.equalsIgnoreCase("Firefox")) {
					WebDriverManager.firefoxdriver().operatingSystem(OperatingSystem.LINUX).setup();
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
				} else if (os.equalsIgnoreCase("MAC") && strBrowserName.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().operatingSystem(OperatingSystem.MAC).setup();
					driver = new ChromeDriver();
					driver.manage().window().maximize();

				} else if (os.equalsIgnoreCase("MAC") && strBrowserName.equalsIgnoreCase("Edge")) {
					WebDriverManager.edgedriver().operatingSystem(OperatingSystem.MAC).setup();
					driver = new EdgeDriver();
					driver.manage().window().maximize();
				} else if (os.equalsIgnoreCase("MAC") && strBrowserName.equalsIgnoreCase("Firefox")) {
					WebDriverManager.firefoxdriver().operatingSystem(OperatingSystem.MAC).setup();
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
				} else if (os.equalsIgnoreCase("WIN") && strBrowserName.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().operatingSystem(OperatingSystem.WIN).setup();
					driver = new ChromeDriver();
					driver.manage().window().maximize();

				} else if (os.equalsIgnoreCase("WIN") && strBrowserName.equalsIgnoreCase("Edge")) {
					WebDriverManager.edgedriver().operatingSystem(OperatingSystem.WIN).setup();
					driver = new EdgeDriver();
					driver.manage().window().maximize();
				} else if (os.equalsIgnoreCase("WIN") && strBrowserName.equalsIgnoreCase("Firefox")) {
					WebDriverManager.firefoxdriver().operatingSystem(OperatingSystem.WIN).setup();
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
				}

				outputparameters.put("STATUS", "PASS");
				outputparameters.put("MESSAGE", "Action: Browser Launch, Input Given:" + inputparameters[0].toString());

			} catch (Exception e) {
				outputparameters.put("STATUS", "FAIL");
				outputparameters.put("MESSAGE", "Action: Browser Launch, Input Given:" + inputparameters[0].toString());
			}
		}
		return outputparameters;
	}

	public static Hashtable<String, Object> openApplication(Object[] inputparameters) {
		try {
			String strUrl = (String) inputparameters[0];
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(strUrl);
			outputparameters.put("STATUS", "PASS");
			outputparameters.put("MESSAGE", "Action: Open Applicationb, Input Given:" + inputparameters[0].toString());

		} catch (Exception e) {
			outputparameters.put("STATUS", "FAIL");
			outputparameters.put("MESSAGE", "Action: Browser Launch, Input Given:" + inputparameters[0].toString());

		}
		return outputparameters;
	}

	public static Hashtable<String, Object> sendKeys(Object[] inputparameters) {
		try {
			String xpath = (String) inputparameters[0];
			String value = (String) inputparameters[1];
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement obj = driver.findElement(By.xpath(xpath));
			obj.clear();
			obj.sendKeys(value);
			outputparameters.put("STATUS", "PASS");
			outputparameters.put("MESSAGE", "Action: Send Keys, Input Given:" + inputparameters[1].toString());

		} catch (Exception e) {
			outputparameters.put("STATUS", "FAIL");
			outputparameters.put("MESSAGE", "Action: Send Keys, Input Given:" + inputparameters[0].toString());

		}
		return outputparameters;
	}

	public static Hashtable<String, Object> click(Object[] inputparameters) {
		try {
			String xpath = (String) inputparameters[0];
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.xpath(xpath)).click();
			outputparameters.put("STATUS", "PASS");
			outputparameters.put("MESSAGE", "Action: click, Input Given:" + inputparameters[0].toString());

		} catch (Exception e) {
			outputparameters.put("STATUS", "FAIL");
			outputparameters.put("MESSAGE", "Action: click, Input Given:" + inputparameters[0].toString());

		}

		return outputparameters;
	}

	public static Hashtable<String, Object> selectDropDownByVisibileText(Object[] inputparameters) {
		try {
			String xpath = (String) inputparameters[0];
			String value = (String) inputparameters[1];
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Select objselect = new Select(driver.findElement(By.xpath(xpath)));
			objselect.selectByVisibleText(value);
			outputparameters.put("STATUS", "PASS");
			outputparameters.put("MESSAGE", "Action: dropdown, Input Given:" + inputparameters[1].toString());

		} catch (Exception e) {
			outputparameters.put("STATUS", "FAIL");
			outputparameters.put("MESSAGE", "Action: dropdown, Input Given:" + inputparameters[1].toString());

		}
		return outputparameters;
	}

	public static Hashtable<String, Object> messageValidtion(Object[] inputparameters) {

		String xpath = (String) inputparameters[0];
		String value = (String) inputparameters[1];
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement message = driver.findElement(By.xpath(xpath));
		String valmessage = message.getText();
		try {
			if (value.equalsIgnoreCase(valmessage)) {
				System.out.println("Test Case Pass");
			} else {
				System.out.println("Test Case Fail");
			}

			outputparameters.put("STATUS", "PASS");
			outputparameters.put("MESSAGE", "Action: Validation, Input Given:" + inputparameters[1].toString());

		} catch (Exception e) {
			outputparameters.put("STATUS", "FAIL");
			outputparameters.put("MESSAGE", "Action: Validation, Input Given:" + inputparameters[1].toString());

		}

		return outputparameters;

	}

}
