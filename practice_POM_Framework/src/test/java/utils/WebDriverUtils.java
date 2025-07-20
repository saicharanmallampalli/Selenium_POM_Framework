package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	
	public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void safeClick(WebDriver driver, By locator) {
	    WebElement element = waitForElementVisible(driver, locator, 10);
	    try {
	        element.click();
	    } catch (ElementClickInterceptedException e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	    }
	}
	
	public static void scrollAndClick(WebDriver driver, By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	public static void sleep(long millis) {
	    try {
	        Thread.sleep(millis);
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
	}





}
