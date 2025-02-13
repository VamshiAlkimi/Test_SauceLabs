package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjectmodels.Login_page;
import Pageobjectmodels.Product_page;
import Utilities.DataProviders;
import testbase.Base_test;

public class TC_001Login_tests extends Base_test {
	@Test(dataProvider="userdata",dataProviderClass=DataProviders.class)
	public void loginDetails(String loginid,String pass)
	{
		Login_page lp=new Login_page(driver);
		lp.setLogin(loginid);
		lp.setPassword(pass);
		lp.loginclick();
		Product_page pl=new Product_page(driver);
		pl.details();
		boolean status=pl.logout_details();
		if(status)
		{
			Assert.assertTrue(true);
			System.out.println(loginid+" "+"has successfully logged in.");
			
		}
		else{
			
			System.out.println("Invalid login for user "+loginid);
		}
	}
}
