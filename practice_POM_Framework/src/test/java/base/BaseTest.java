package base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import utils.ConfigReader;
import utils.ExcelUtils;

public class BaseTest {
	
	protected WebDriver driver;
	protected static final Logger logger = LogManager.getLogger(BaseTest.class);
	
	public WebDriver getDriver() {
	    return driver;
	}

	
    @BeforeMethod
    public void setUp() {
    	logger.info("Launching Chrome Driver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    protected void navigateToHomePage(String siteName) throws IOException {	
    	String url = ExcelUtils.getURLfromExcel(siteName);
    	driver.get(url);
    	logger.info("Navigating to the Home Page"+ ExcelUtils.getURLfromExcel(siteName));
    }
    

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
	
}
