package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.ScreenshotUtils;

public class TestListener extends BaseTest implements ITestListener {

	public static final Logger logger = LogManager.getLogger(TestListener.class);
	
	@Override
	public void onTestFailure(ITestResult result) {
		logger.error("Test FAILED: "+result.getName());
		Object currentClass = result.getInstance();
		WebDriver driver = ((BaseTest) currentClass).getDriver();
		String screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getName());
		logger.info(screenshotPath);	
	}
	
	public void onTestSuccess(ITestResult result) {
		
		logger.info("Test Success: "+result.getName());	
	}
	
	public void onTestStart(ITestResult result) {
		
		logger.info("Starting Test:" +result.getName());	
	}
	
	
}
