package pack01;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.BaseFile;
import resources.ExtentReporter;


public class Listeners extends BaseFile implements ITestListener {
	public static Logger log=LogManager.getLogger(TestCase01.class.getName());
	ExtentReports extent = ExtentReporter.getReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test is Passed");
		log.info(result.getMethod().getMethodName()+" test is succeded");
	}

	
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String methodName=result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}
		
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshot(driver, methodName), methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info(methodName+" test is failed");
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
