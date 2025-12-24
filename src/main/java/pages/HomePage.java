package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseClass;

public class HomePage extends BaseClass {

	
	public HomePage(WebDriver driver) {
		super(driver);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}


	
	//a[@id='nav-logo-sprites']

	
	@FindBy(xpath = "//div[@class='a-row a-spacing-mini']//child::span/span") private List<WebElement> listOfLangElement;
	@FindBy(xpath = "//div[contains(text(),'EN')]")private WebElement logolangaugElement;
	@FindBy(xpath="//input[@aria-labelledby='icp-save-button-announce']")private WebElement savebtn;
	@FindBy(xpath = "//a[@id='nav-logo-sprites']")private WebElement sitelogoElement;
	@FindBy(id="nav-link-accountList-nav-line-1") private WebElement greetingElement;
	
	public boolean ChageLangauge(String lang) throws Exception {
		ElementVisible(logolangaugElement);
		ElementClickable(logolangaugElement);
		for(WebElement list: listOfLangElement) {
		    if (list.isSelected()) {
		    	String text = list.getText().trim();
		    	if (text.equalsIgnoreCase(lang)) {
					
				}
			}
		    if (text.equalsIgnoreCase(lang.toUpperCase())) {
		    	if(list.isSelected()) {
		    		if () {
						
					}
		    		
		    	}
				list.click();
				break;
			}    
		}
		
		
		ElementClickable(savebtn);
		Thread.sleep(2000);
		ElementVisible(greetingElement);
		String greet=greetingElement.getText();
		
		if(greet.contains("नमस्ते")) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
		
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchproductElement;

	public String SearchProduct(String product) {
		searchproductElement.click();
		searchproductElement.sendKeys(product);
		searchproductElement.sendKeys(Keys.ENTER);
		String title = driver.getTitle();
		return title;

	}
	
	
	
	

}
	
	
	
	
//	@FindBy(xpath = "//button[@aria-label='Add to cart']")
//	List<WebElement> addToCartbtnElement;
//
//	public void AddProductInCart() {
//
//		int count = 0;
//		for (WebElement list : addToCartbtnElement) {
//			ElementClickable(list);
//			count++;
//			if (count == 4) {
//				break;
//			}
//
//		}
//
//	}

	
	

