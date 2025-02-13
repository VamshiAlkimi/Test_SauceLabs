package Pageobjectmodels;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Product_page extends Main_class {
	public Product_page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[text()='Add to cart']")
	List<WebElement> add_item_btn;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cart_btn;
	@FindBy(xpath = "//span[text()='Products']")
	WebElement disp;

	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement detailbtn;
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement logout;

	public void select_product() {
		await.until(ExpectedConditions.elementToBeClickable(add_item_btn.get(3))).click();
		await.until(ExpectedConditions.elementToBeClickable(add_item_btn.get(4))).click();
	}

	public void click_cart() {

		await.until(ExpectedConditions.elementToBeClickable(cart_btn)).click();
	}
	public void details()
	{
		await.until(ExpectedConditions.elementToBeClickable(detailbtn)).click();
	}
	public boolean logout_details() {
		boolean status=await.until(ExpectedConditions.visibilityOf(logout)).isDisplayed();
		return status;
	}

}
