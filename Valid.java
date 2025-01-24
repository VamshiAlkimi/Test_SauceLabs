package Maintest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Valid {
	public static void main(String[] args) {
		WebDriver test = new ChromeDriver();
		WebDriverWait await = new WebDriverWait(test, Duration.ofSeconds(10));
		test.get("https://www.saucedemo.com/");
		test.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement user_name = test.findElement(By.xpath("//input[@id='user-name']"));
		WebElement password = test.findElement(By.xpath("//*[@placeholder='Password']"));
		WebElement login = test.findElement(By.xpath("//*[@type='submit']"));
		user_name.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		Set<String> validNames = Set.of("standard_user", "locked_out_user", "problem_user", "performance_glitch_user",
				"error_user", "visual_user");
		String main_pass = "secret_sauce";
		String name = user_name.getDomAttribute("value");
		String pass = password.getDomAttribute("value");

		if (name.isEmpty() || pass.isEmpty()) {
			login.click();
			WebElement errorMessage = await
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='error']")));
			if (errorMessage.isDisplayed()) {
				System.out.println("Test passed Error message displayed");
			}

		} else if (validNames.contains(name) && main_pass.equals(pass)) {
			login.click();
			System.out.println("Test passed logged in");

		} else {
			login.click();
			WebElement errorMessage = await
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='error']")));
			if (errorMessage.isDisplayed()) {
				System.out.println("Test passed Error displayed");
			}

		}

	}

}
