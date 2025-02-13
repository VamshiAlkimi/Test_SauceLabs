package Pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Checkout_final extends Main_class {
	public Checkout_final(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='first-name']")
	WebElement first_name;
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement last_name;
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement post_code;
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continuebtn;

	public void setFirstname(String name) {
		await.until(ExpectedConditions.visibilityOf(first_name)).sendKeys(name);
		;
	}

	public void setLastname(String name) {
		await.until(ExpectedConditions.visibilityOf(last_name)).sendKeys(name);
		;
	}

	public void setPincode(String pin) {
		await.until(ExpectedConditions.visibilityOf(post_code)).sendKeys(pin);
		;
	}
	public void clickcontinue()
	{
		await.until(ExpectedConditions.visibilityOf(continuebtn)).click();
	}
}
