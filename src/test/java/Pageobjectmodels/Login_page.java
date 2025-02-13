package Pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login_page extends Main_class {
	public Login_page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement login;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginbtn;

	public void setLogin(String login_name) {
		await.until(ExpectedConditions.elementToBeClickable(login)).sendKeys(login_name);
	}

	public void setPassword(String password_value) {
		await.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(password_value);

	}
	public void loginclick()
	{
		await.until(ExpectedConditions.elementToBeClickable(loginbtn)).click();
	}
}
