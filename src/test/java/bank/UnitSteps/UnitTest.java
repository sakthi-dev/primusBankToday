package bank.UnitSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class UnitTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://primusbank.qedgetech.com/");
		driver.findElement(By.xpath("//*[@name='txtuId']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='txtPword']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='login']")).click();
		driver.findElement(By.xpath("//*[@src='images/Branches_but.jpg']")).click();

		// Select Country

		Select country = new Select(driver.findElement(By.xpath("//*[@name='lst_countryS']")));
		country.selectByVisibleText("INDIA");

		// Select State

		Select state = new Select(driver.findElement(By.xpath("//*[@name='lst_stateS']")));
		state.selectByVisibleText("Andhra Pradesh");

		// Select City

		Select city = new Select(driver.findElement(By.xpath("//*[@name='lst_cityS']")));
		city.selectByVisibleText("Hyderabad");

	}

}
