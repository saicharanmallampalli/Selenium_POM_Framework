package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WebDriverUtils;

public class HomePage {

	WebDriver driver;
	public static final Logger logger = LogManager.getLogger(HomePage.class);
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By elementsPage = By.xpath("//h5[text()='Elements']");
	By formsPage = By.xpath("//h5[text()='Forms']");
	By alertsPage	= By.xpath("//h5[text()='Alerts, Frame & Windows']");
	By widgetsPage = By.xpath("//h5[text()='Widgets']");
	By interactionsPage = By.xpath("//h5[text()='Interactions']");
	By bookStoreAppPage = By.xpath("//h5[text()='Book Store Application']");
	
	
	public void clickElementsPage() {
		logger.info("Element Page Clicked");
		WebDriverUtils.waitForElementVisible(driver, elementsPage, 10);
		WebElement element = driver.findElement(elementsPage);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	public void clickFormsPage() {
		logger.info("Forms Page Clicked");
		driver.findElement(formsPage).click();
	}
	
	public void clickAlertsPage() {
		logger.info("Alerts Page Clicked");
		WebDriverUtils.waitForElementVisible(driver, alertsPage, 10);
		WebElement element = driver.findElement(alertsPage);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	
	public void clickWidgetsPage() {
		logger.info("Widgets Page Clicked");
		WebDriverUtils.waitForElementVisible(driver, widgetsPage, 10);
		WebElement element = driver.findElement(widgetsPage);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		
	}
	
	public void clickInteractionsPage() {
		logger.info("Interactions Page Clicked");
		driver.findElement(interactionsPage).click();
	}
	
	public void bookStoreAppPage() {
		logger.info("Book Store Page Clicked");
		driver.findElement(bookStoreAppPage).click();
	}
	
}
