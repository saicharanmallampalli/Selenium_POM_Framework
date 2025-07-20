package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WebDriverUtils;

public class AlertsPage {
	
	private WebDriver driver;
	
	private static final Logger logger = LogManager.getLogger(AlertsPage.class);
	
	public AlertsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By alertBtn = By.id("alertButton");
	By timerAlertBtn = By.id("timerAlertButton");
	By confirmBtn = By.id("confirmButton");
	By promptBtn = By.id("promtButton");
	
	public void triggerAlert() {
		logger.info("triggerAlert Clicked");
		driver.findElement(alertBtn).click();		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void triggerTimerAlert() {
		logger.info("triggerTimerAlert Clicked");
		WebElement element = driver.findElement(timerAlertBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
	}
	
	public void triggerConfirm() {
		logger.info("triggerConfirm Clicked");
		boolean accept = false;
		WebElement element = driver.findElement(confirmBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Alert alert = driver.switchTo().alert();	
		if(accept) alert.accept(); else alert.dismiss();
		
	}
	
	public void triggerPrompt(String text) {
		logger.info("triggerPrompt Clicked");
		WebElement element = driver.findElement(promptBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}
	

}
