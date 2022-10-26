package genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;


public class ListenersClass extends BaseClass implements ITestListener {
	
	ExtentReports extent=ExtentReportNG.getReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
		public void onTestFailure(ITestResult result) {
			
			extentTest.get().fail(result.getThrowable());
			
			try {
				driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			
			
			String filepath = null;
			try {
				filepath=getScreenShot(result.getMethod().getMethodName(), driver);
			} catch (IOException e) {
				
			}
			
			
			
			extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
			
		}

		@Override
		public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		}

		@Override
		public void onFinish(ITestContext context) {
		extent.flush();
		}

		
	}
	

