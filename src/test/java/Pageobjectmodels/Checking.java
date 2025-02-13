package Pageobjectmodels;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checking {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		WebDriverWait await = new WebDriverWait(driver, Duration.ofSeconds(10));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user-name']")))
				.sendKeys("standard_user");
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")))
				.sendKeys("secret_sauce");
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-button']"))).click();
		List<WebElement> prod_list =driver.findElements(By.xpath("//button[text()='Add to cart']"));
		prod_list.get(2).click();
		prod_list.get(3).click();
		Thread.sleep(3000);
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='shopping_cart_link']"))).click();
	
	}

}
