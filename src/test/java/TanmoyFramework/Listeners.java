package TanmoyFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNG;
import Resources.base;

public class Listeners extends base implements ITestListener
{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) 
	{
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		extentTest.get().log(Status.PASS, "Test Passed");	
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String TestMethodName = result.getMethod().getMethodName();
		
		try 
		{
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) 
		{
			e1.printStackTrace();
		}
		try 
		{
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(TestMethodName,driver));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		extent.flush();
		
	}

}
