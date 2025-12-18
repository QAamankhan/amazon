package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {
		super(driver);
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

	
	
}
