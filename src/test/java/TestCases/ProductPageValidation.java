package TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ProductResultPage;

public class ProductPageValidation  extends BaseTest{
	ProductResultPage pp;
	
	  @BeforeMethod(alwaysRun = true)
	    public void setupPageObject() {
	        pp = new ProductResultPage(driver);
	    }
	
	@Test(groups = {"Product" ,"regression"})
	public void TC01_SelectFeatures() {
		pp.OptOnProductPage();
	}
	
	
	@Test(groups ={"Product" ,"regression","cart"})
	public void TC02_AddProduct() {
		pp.AddProductInCart();
	}
}
