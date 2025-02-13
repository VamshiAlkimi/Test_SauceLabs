package Pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Final_page extends Main_class {
	public Final_page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='Thank you for your order!']")
	WebElement message;
	public String showMessage()
	{
		return message.getText();
	}
}
