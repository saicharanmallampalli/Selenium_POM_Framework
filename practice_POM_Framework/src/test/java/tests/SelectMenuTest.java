package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SelectMenuPage;

public class SelectMenuTest extends BaseTest{
	
	
	@Test
	public void testSelectMenus() throws Exception {
		
		navigateToHomePage("DemoQA");
		logger.info("Click on the ");
		HomePage home = new HomePage(driver);
		home.clickWidgetsPage();
		WebElement element = driver.findElement(By.xpath("//span[text()= 'Select Menu']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		SelectMenuPage selectMenu = new SelectMenuPage(driver);
		selectMenu.selectValueMenu();
		selectMenu.selectOneMenu();
		selectMenu.oldStyleSelectMenu();
		selectMenu.multiSelectMenu();
		selectMenu.standardMultiSelectMenu();
		
		
	}
	 
	
}
