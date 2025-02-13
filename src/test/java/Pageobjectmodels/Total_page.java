package Pageobjectmodels;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Total_page extends Main_class {
	public Total_page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	List<WebElement> Prices;
	@FindBy(xpath="//button[@id='finish']") 
	WebElement finishbtn;
	public List<Double> showPrice()
	{
		List<Double> price_list=new ArrayList<>();
		for(WebElement item:Prices)
		{
			String value=item.getText().replace("$","").trim();
			price_list.add(Double.parseDouble(value));
		}
		return price_list;
		
		
	}
	public void clickFinish()
	{
		finishbtn.click();
	}
	
}
