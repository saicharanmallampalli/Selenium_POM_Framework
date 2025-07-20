package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WebDriverUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextBoxPage {

	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(TextBoxPage.class);
	
	public TextBoxPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	By fullNameTB = By.xpath("//input[@id='userName']");
	By userEmailTB = By.xpath("//input[@id='userEmail']");
	By currentAddressTB = By.xpath("//textarea[@id='currentAddress']");
	By permenentAddressTB = By.xpath("//textarea[@id='permanentAddress']");
	By submitBtn = By.xpath("//button[text()='Submit']");
    By outputName = By.id("name");
    By outputEmail = By.id("email");

	public void waitForTextBoxPageToLoad() {
	    WebDriverUtils.waitForElementVisible(driver, fullNameTB, 5);
	}
    
    
	
	public void enterFullName(String name) {
		logger.info("Entering fullname: "+name);
		WebDriverUtils.waitForElementVisible(driver, fullNameTB, 5);
		driver.findElement(fullNameTB).sendKeys(name);
	}
	
	public void enterUserEmail(String email) {
		logger.info("Entering userEmailTB: "+ email);
		WebDriverUtils.waitForElementVisible(driver, userEmailTB, 5);
		driver.findElement(userEmailTB).sendKeys(email);
	}
	
	public void enterCurrentAddress(String cAddress) {
		logger.info("Entering cAddress: "+ cAddress);
		WebDriverUtils.waitForElementVisible(driver, currentAddressTB, 5);
		driver.findElement(currentAddressTB).sendKeys(cAddress);
	}
	
	public void enterPermenantAddress(String pAddress) {
		logger.info("Entering cAddress: "+ pAddress);
		WebDriverUtils.waitForElementVisible(driver, permenentAddressTB, 5);
		driver.findElement(permenentAddressTB).sendKeys(pAddress);	
	}
	
	public void clickSubmitBtn() {
	    logger.info("Waiting for and clicking submitBtn...");

	    WebElement element = WebDriverUtils.waitForElementVisible(driver, submitBtn, 10);

	    // Step 1: Scroll into view
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	    // Step 2: Try removing ad iframe if present
	    try {
	        WebElement adFrame = driver.findElement(By.cssSelector("iframe[id^='google_ads_iframe']"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", adFrame);
	        logger.warn("Ad iframe removed before clicking Submit");
	    } catch (Exception e) {
	        logger.info("No ad iframe found — proceeding to click Submit");
	    }

	    // Step 3: Click via JavaScript
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	
	public String getOutputName() {
	       return driver.findElement(outputName).getText();
	    }

	public String getOutputEmail() {
	        return driver.findElement(outputEmail).getText();
	    }
	

}
