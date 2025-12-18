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
	@FindBy(xpath="//li[@id='p_123/110955']//i[@class='a-icon a-icon-checkbox']")WebElement apple;
	@FindBy(xpath = "//li[@id='p_123/247341']//i[@class='a-icon a-icon-checkbox']") WebElement dell;

	public void OptOnProductPage() {
		ElementVisible(apple);
		ElementClickable(apple);
		
		ElementVisible(Featured);
		ElementClickable(Featured);
		
		ElementVisible(newestArrivals);
		ElementClickable(newestArrivals);
		
		
		
		
		
	}	
	
	@FindBy(xpath = "//button[@aria-label='Add to cart']")
	List<WebElement> addToCartbtnElement;

	public void AddProductInCart() {

		int count = 0;
		for (WebElement list : addToCartbtnElement) {
			ElementClickable(list);
			count++;
			if (count == 4) {
				break;
			}

		}

	}

}
