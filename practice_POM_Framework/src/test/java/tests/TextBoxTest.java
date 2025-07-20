package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListener;
import pages.HomePage;
import pages.TextBoxPage;
import utils.WebDriverUtils;

@Listeners(TestListener.class)
public class TextBoxTest extends BaseTest {
	
	By textBoxMenu = By.xpath("//span[text()='Text Box']");	
	
	@Test
	public void testTextFormSubmission() throws Exception {
		
		navigateToHomePage("DemoQA");
		HomePage page = new HomePage(driver);	
		page.clickElementsPage();
		logger.info("Navigating to Text Box Menu");	
		WebDriverUtils.waitForElementVisible(driver, textBoxMenu, 5);  // Add explicit wait
	    driver.findElement(textBoxMenu).click(); 
	    
		TextBoxPage textBox = new TextBoxPage(driver);
		textBox.waitForTextBoxPageToLoad();
		textBox.enterFullName("Charan QA");
		textBox.enterUserEmail("saicharan@gmail.com");
		textBox.enterCurrentAddress("L.B Nagar, Hyderabad");
		textBox.enterPermenantAddress("Telangana");
		textBox.clickSubmitBtn();
		
		Assert.assertTrue(textBox.getOutputName().contains("Charan QA"),"Name out mistmatch");
		Assert.assertTrue(textBox.getOutputEmail().contains("saicharan@gmail.com"), "Email mismatch");
		
	}
	
}
