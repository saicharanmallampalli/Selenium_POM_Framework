package listeners;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseTest;
import utils.ScreenshotUtils;

import com.aventstack.extentreports.Status;

public class TestListener extends BaseTest implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
        reporter.config().setReportName("Automation Results");
        reporter.config().setDocumentTitle("Practice Framework");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Charan");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
        String path = ScreenshotUtils.captureScreenshot(driver, result.getName());
        test.get().log(Status.FAIL, result.getThrowable());
        test.get().addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {
    	System.out.println("Finished executing tests from suite: " + context.getName());
        extent.flush();
    }
}
