package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class CartPage extends BaseClass {

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@id='nav-cart']")
	private WebElement cartlogo;

	public void OpenCartPage() {
		ElementClickable(cartlogo);

	}

	public void removeItemsFromCart() {
		By cartCount = By.xpath("//span[@id='sc-subtotal-label-buybox']");
		By decrementBtn = By.xpath("//button[@data-a-selector='decrement']");

		
		while (true) {
			
			if (driver.findElements(cartCount).isEmpty()) {
	            System.out.println("Cart is empty (element not present)");
	            break;
	        }
			
			WebElement countElement = waitForVisible(cartCount);
			String itemText = countElement.getText();
			int count = Integer.parseInt(itemText.replaceAll("\\D+", ""));

			if (count == 0) {
				System.out.println("Cart is empty");
				break;
			} else {
				waitForClickable(decrementBtn).click();
				System.out.println("Item removed, remaining: " + (count - 1));
			}
		}
	}

}
