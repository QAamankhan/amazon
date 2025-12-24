package TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;

public class CartPageValidation extends BaseTest {
	
	CartPage cp;
	
	@BeforeMethod(alwaysRun = true)
	
	public void Object() {
		cp = new CartPage(driver);
	}

	
	@Test(groups = {"cart","regression"})
	public void TC01_CartValidation() {
		cp.OpenCartPage();
	}
	
	@Test(groups = {"cart","regression"})
	public void TC02_RemoveProduct() {
		cp.removeItemsFromCart();
	}
}


