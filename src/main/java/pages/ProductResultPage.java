package pages;

import java.util.Base64;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseClass;

public class ProductResultPage  extends BaseClass{

	
	public ProductResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//span[@class='a-button-text a-declarative']")WebElement Featured;
	@FindBy(xpath="//a[@id='s-result-sort-select_4']") WebElement newestArrivals;
	

	public void OptOnProductPage() {
			
		ElementVisible(Featured);
		ElementClickable(Featured);
		
		ElementVisible(newestArrivals);
		ElementClickable(newestArrivals);
				
	}	
	
	@FindBy(xpath = "//button[@name='submit.addToCart']")
	List<WebElement> addToCartbtnElement;

	public void AddProductInCart() {

		int count = 0;
		for (WebElement list : addToCartbtnElement) {
			ElementVisible(list);
			ElementClickable(list);
			count++;
			if (count == 4) {
				break;
			}

		}

	}

}
