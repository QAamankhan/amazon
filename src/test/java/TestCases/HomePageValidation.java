package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageValidation extends BaseTest {

    HomePage hp;

    
    @BeforeMethod(alwaysRun = true)
    public void Object() {
    	 hp = new HomePage(driver);
    }
    
   @Test(groups = {"HomePage", "regression"})
    public void TC01_LanguageValidation() throws Exception {
        boolean reuslt = hp.ChageLangauge("HI");
        assertEquals(reuslt, true);
       }

    @Test(groups = {"HomePage", "regression","Product"})
    public void TC02_SearchProduct() {
        String title = hp.SearchProduct("laptop");

        Assert.assertTrue(
            title.toLowerCase().contains("laptop"),
            "User not navigated to laptop page"
        );

        System.out.println("User navigated to page: " + title);
    }
}
