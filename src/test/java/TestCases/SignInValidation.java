package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SignInPage;

public class SignInValidation extends BaseTest{

	
	SignInPage sp;

	@Test(groups = {"SignIn","regression"})
	public void TC01_SignIn() {
		sp = new SignInPage(driver);
		String text = sp.ClickOnSignIn();
		if (text.toLowerCase().contains("sign in or create account")) {
			Assert.assertTrue(true, text);
		}
	}

	@Test(dataProvider = "ExcelData", dataProviderClass = BaseTest.class,groups = {"SignIn","regression"})
	public void TC02_FillCreds(String email, String password ,String expected) {
		sp.FillCredentials(email, password,expected);
		if (expected.equalsIgnoreCase("pass")) {
			String nametext = sp.ValidateLoginSucessfull();
			Assert.assertTrue(nametext.contains("Hello"), "Login not successful");
	        sp.SignOut();
		}
		else {
			Assert.fail();
			
		}
	}	
}

