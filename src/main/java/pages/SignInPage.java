package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BaseClass;

public class SignInPage extends BaseClass {

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath = "//a[@data-nav-role='signin']")  WebElement signElement;
	@FindBy(xpath="//div[@id='claim-collection-container']/h1") WebElement textsigninElement;
	
	public String ClickOnSignIn() {
		ElementClickable(signElement);
		
		ElementVisible(textsigninElement);
		String text = textsigninElement.getText();		
		return text;		
	}
	
	
	@FindBy(id="ap_email_login") WebElement emailElement;
	@FindBy(id="ap_password") WebElement password;
	@FindBy(id="continue") WebElement continuebtnElement;
	
	@FindBy(id="signInSubmit") WebElement signbtnElement;
	
	public void FillCredentials(String email,String pass,String expected) {
		ElementClickable(emailElement);
		emailElement.clear();
		emailElement.sendKeys(email);
		if (continuebtnElement.isEnabled()) {
			continuebtnElement.click();
		}
		else {
			ElementVisible(continuebtnElement);
			ElementClickable(continuebtnElement);
		}
		
		ElementClickable(password);
		password.clear();
		password.sendKeys(pass);
		
		if (signbtnElement.isEnabled()) {
			signbtnElement.click();
		}
		else {
			ElementVisible(signbtnElement);
			ElementClickable(signbtnElement);
		}

	}
	
	@FindBy(xpath = "//div[@class='nav-line-1-container']/span") WebElement greetingElement;
	public String ValidateLoginSucessfull() {
		
		String nametext = greetingElement.getText();
		return nametext;
	}
	
	
	@FindBy(id="nav-link-accountList") WebElement signOutHoverElement;
	@FindBy(xpath="//span[.='Sign Out']") WebElement signOutBtnElement;
	public void SignOut() {
		Actions action = new Actions(driver);
		action.moveToElement(signOutHoverElement).perform();
		ElementClickable(signOutBtnElement);
	}
	
}
