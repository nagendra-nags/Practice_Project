package genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenersClass extends BaseClass implements ITestListener {
	
		public void onTestFailure(ITestResult result) {
			
			String scriptName=result.getTestContext().getName()+"."+result.getMethod().getMethodName();
			driverlib.captureScreeShot(scriptName+".png",driver);
			
		}

		
		
		

	}
	

