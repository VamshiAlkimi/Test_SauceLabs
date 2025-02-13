package Pageobjectmodels;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main_class {
		public WebDriver driver;
		public WebDriverWait await; 
		public Main_class(WebDriver driver)
		{	
			this.driver=driver;
			PageFactory.initElements(driver,this);
			await=new WebDriverWait(driver,Duration.ofSeconds(10));
		}
	
}
