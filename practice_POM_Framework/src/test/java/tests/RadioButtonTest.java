package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RadioButtonPage;

public class RadioButtonTest extends BaseTest {
	
	@Test
	public void testRadioButtonSelection() throws IOException {
		
		navigateToHomePage("DemoQA");
		HomePage page = new HomePage(driver);	
		page.clickElementsPage();
		logger.info("Navigating to Radio Button Menu");
		driver.findElement(By.xpath("//span[text() = 'Radio Button']")).click();
		
		RadioButtonPage radioPage = new RadioButtonPage(driver);
		
		radioPage.selectImpressive();
		radioPage.selectYes();

		assert !radioPage.isNoEnabled() : "'No' radio button should be disabled";
	}

}
