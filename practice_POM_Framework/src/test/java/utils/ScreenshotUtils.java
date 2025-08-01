package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.BaseTest;

public class ScreenshotUtils extends BaseTest{
	
	public static String captureScreenshot(WebDriver driver, String testName) {
		 if (BaseTest.driver != null) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotName = "Screenshot/"+ testName + "_" + timeStamp + ".png";
		
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(screenshotName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return screenshotName;	
		 } else {
			 
			 System.out.println("Driver is null. Cannot take screenshot.");
		     return null;
		 }
		
	}

}
