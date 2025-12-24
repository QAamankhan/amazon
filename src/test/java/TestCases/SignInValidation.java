package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.SignInPage;

public class SignInValidation extends BaseTest{

	
	SignInPage sp;
	
	@BeforeMethod(alwaysRun = true)
	
	public void Objcet() {
		sp = new SignInPage(driver);

	}

	@Test(groups = {"SignIn","regression","HomePage"})
	public void TC01_SignIn() {
		String text = sp.ClickOnSignIn();
		if (text.toLowerCase().contains("sign in or create account")) {
			Assert.assertTrue(true, text);
		}
	}

	@Test(dataProvider = "ExcelData", dataProviderClass = BaseTest.class,groups = {"SignIn","regression","HomePage"})
	public void TC02_FillCreds(String email, String password ,String expected) {
		sp.FillCredentials(email, password,expected);
		if (expected.equalsIgnoreCase("pass")) {
			String nametext = sp.ValidateLoginSucessfull();
			Assert.assertTrue(nametext.contains("Hello"), "Login not successful");
		}
		else {
			Assert.fail();
			
		}
	}	
	
//	@Test(groups = {"SignIn","regression"})
//	public void TC03_Signout() {
//		sp.SignOut();
//	}
}

