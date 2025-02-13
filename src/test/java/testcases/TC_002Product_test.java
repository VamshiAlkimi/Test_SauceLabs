package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjectmodels.CheckOut_page;
import Pageobjectmodels.Checkout_final;
import Pageobjectmodels.Final_page;
import Pageobjectmodels.Login_page;
import Pageobjectmodels.Product_page;
import Pageobjectmodels.Total_page;
import testbase.Base_test;

public class TC_002Product_test extends Base_test {
	@Test
	public void Product_end() throws InterruptedException {
		try {
			Login_page lp = new Login_page(driver);
			lp.setLogin("standard_user");
			lp.setPassword("secret_sauce");
			lp.loginclick();

			Product_page pg = new Product_page(driver);
			pg.select_product();
			pg.click_cart();

			CheckOut_page cp = new CheckOut_page(driver);
			cp.checkout_btn();

			String fname = (RandomName().toLowerCase());
			String lname = (RandomName().toLowerCase());
			String pin = (RandomPass());
			Checkout_final cf = new Checkout_final(driver);
			cf.setFirstname(fname);
			cf.setLastname(lname);
			cf.setPincode(pin);
			cf.clickcontinue();
			Thread.sleep(2000);
			Total_page tp = new Total_page(driver);
			tp.clickFinish();
			Final_page fp = new Final_page(driver);
			String final_message = fp.showMessage();
			Assert.assertEquals(final_message, "Thank you for your order!");
		} catch (Exception e) {
			Assert.fail();
		}

	}
}
