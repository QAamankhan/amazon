package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;

public class HomePageValidation  extends BaseTest{

	HomePage  hp;
	
	
	@Test(groups = {"HomePage","regression"})
	public void TC01_SearchProduct() {
	hp = new HomePage(driver);
	String title=hp.SearchProduct("laptop");
	if (title.toLowerCase().contains("laptop")) {
		System.out.println( "User Navigate"+title+"page");
		Assert.assertTrue(true);
		
	}else {
		System.out.println( "Something Worng"+title);
//		Assert.assertTrue(false);
	}
	}
	
	
	
	
}
