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

	    By cartCount = By.xpath("//span[contains(@id,'sc-subtotal-label')]");
	    By decrementBtn = By.xpath("//button[@data-a-selector='decrement']");

	    int safetyCounter = 0;

	    while (safetyCounter < 10) {   // infinite loop avoid
	        safetyCounter++;

	        if (driver.findElements(cartCount).size() == 0) {
	            System.out.println("Cart is empty or subtotal not present");
	            break;
	        }

	        WebElement countElement =
	                new WebDriverWait(driver, Duration.ofSeconds(10))
	                        .until(ExpectedConditions.visibilityOfElementLocated(cartCount));

	        String itemText = countElement.getText().replaceAll("\\D+", "");

	        if (itemText.isEmpty()) {
	            System.out.println("No item count found");
	            break;
	        }

	        int count = Integer.parseInt(itemText);

	        if (count <= 0) {
	            System.out.println("Cart empty");
	            break;
	        }

	        new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.elementToBeClickable(decrementBtn))
	                .click();

	        System.out.println("Item removed, remaining: " + (count - 1));
	    }
	}

}
