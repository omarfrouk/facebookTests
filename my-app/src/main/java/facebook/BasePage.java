package facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickElemet(By locator) {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).click();
	}

	public void setFieldText(By locator, String text) {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	public void setDropdownValue(By locator, String value) {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		Select valueDropdown = new Select(element);
		valueDropdown.selectByVisibleText(value);

	}

	public String getElementText(By locator) {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));  
		return driver.findElement(locator).getText(); 

	}
 
	public boolean isElementDisplayed(By locator) {
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator).isDisplayed();
	
	}


}
