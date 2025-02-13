package testbase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_test {
	public WebDriver driver;

	@BeforeMethod

	public void Setup() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void Teardown() {
		//driver.quit();
	}
	public String RandomName()
	{
		@SuppressWarnings("deprecation")
		String name=RandomStringUtils.randomAlphabetic(8);
		return name;
	}
	public String RandomPass()
	{
		@SuppressWarnings("deprecation")
		String pin=RandomStringUtils.randomNumeric(8);
		return pin;
	}
	
}
