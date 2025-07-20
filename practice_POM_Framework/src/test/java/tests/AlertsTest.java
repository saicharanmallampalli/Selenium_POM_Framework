package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.AlertsPage;
import pages.HomePage;
import utils.WebDriverUtils;

public class AlertsTest extends BaseTest {
	
	
	@Test
	public void testTriggeringAlerts() throws IOException {
		
		navigateToHomePage("DemoQA");
		HomePage home = new HomePage(driver);
		home.clickAlertsPage();
		logger.info("Navigating to Alerts Window");
		driver.findElement(By.xpath("//span[text() = 'Alerts']")).click();
		
		AlertsPage alerts = new AlertsPage(driver);
		alerts.triggerAlert();
		alerts.triggerTimerAlert();
		alerts.triggerConfirm();
		alerts.triggerPrompt("Test Alerts");
		
		
	}
	
}
