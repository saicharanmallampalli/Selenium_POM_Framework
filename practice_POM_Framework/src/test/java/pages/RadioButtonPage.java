package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage {
	
	private WebDriver driver;
	
	private static final Logger logger = LogManager.getLogger(RadioButtonPage.class);
	
	public RadioButtonPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By yesRadioBtn = By.xpath("//label[@for='yesRadio']");
	By impressiveRadioBtn = By.xpath("//label[@for='impressiveRadio']");
	By noRadioBtn = By.xpath("//label[@for='noRadio']");
	
	public void selectYes() {
		
		logger.info("Yes button clicked");
		driver.findElement(yesRadioBtn).click();
		
	}
	
	public boolean isNoEnabled()  {
		
		logger.info("No button enabled");
		return driver.findElement(noRadioBtn).isEnabled();
		
	}
	
	public void selectImpressive() {
		
		logger.info("Impressive button clicked");
		driver.findElement(impressiveRadioBtn).click();
		
	}
	

}
