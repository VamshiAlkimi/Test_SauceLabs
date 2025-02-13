package Pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOut_page extends Main_class {
	public CheckOut_page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkout;
	public void checkout_btn()
	{
		await.until(ExpectedConditions.visibilityOf(checkout)).click();
	}
}
