package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	/*
	 * Purpose of BasePage.java Instead of writing driver.findElementBy(...) again
	 * and again in each page class 1. Centralize WebDriver access: All page classes
	 * can access the driver through this class. 2. Common reusable methods: Like
	 * clicking, typing, waiting, scrolling, handling alerts, etc. 3. Maintain
	 * consistency: Avoid duplicating code in every page class. 4. Simplifies
	 * maintenance: Change one method in BasePage, and it reflects across all pages.
	 */
	protected WebDriver driver;
	protected WebDriverWait wait; // explicit wait

	// Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait
	}

	// 1. Wait for visibiltiy of element - wait until the element is visible on the
	// page
	public WebElement waitForVisibility(By locator) {
		WebElement visibilityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return visibilityElement;
	}

	// 2. Wait for element to be clickable
	public WebElement waitForClickable(By locator) {
		WebElement clickableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return clickableElement;
	}

	// 3. Click Element
	public void click(By locator) {
		waitForClickable(locator).click();
	}

	// 4. Type Text
	public void typeText(By locator, String text) {
		WebElement typeElement = waitForVisibility(locator);
		typeElement.clear();
		typeElement.sendKeys(text);
	}

	// 5. Get text
	public String getText(By locator) {
		return waitForVisibility(locator).getText();
	}

	// 6. Check if element is displayed
	public boolean isDisplayed(By locator) {
		try {
			return waitForVisibility(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// 7. Select dropdown by visible text
	public void selectDropdown(By locator, String visibleText) {
		WebElement dropdownElement = waitForVisibility(locator);
		Select select = new Select(dropdownElement);
		select.selectByVisibleText(visibleText);
	}

	// 8. Select dropdown by value
	public void selectDropdownByValue(By locator, String value) {
		WebElement dropdownElement = waitForVisibility(locator);
		Select select = new Select(dropdownElement);
		select.selectByValue(value);
	}

	// 9. Select dropdown by value
	public void selectDropdownByIndex(By locator, int index) {
		WebElement dropdownElement = waitForVisibility(locator);
		Select select = new Select(dropdownElement);
		select.selectByIndex(index);
	}
}