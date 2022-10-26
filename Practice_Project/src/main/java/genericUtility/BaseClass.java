package genericUtility;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver=null;
	public JavaUtility jlib= new JavaUtility();
	public ExcelUtility elib= new ExcelUtility();
	public FileUtility flib= new FileUtility();
	public WebDriverUtility driverlib= new WebDriverUtility();
	
	
	
//	@BeforeSuite
//	public void connectToDatabase()
//	{
//		System.out.println("Database is connected");
//	}
//	
//	@AfterSuite
//	public void disconnectToDatabase()
//	{
//		System.out.println("Database is disconnected");
//	}

	
	@BeforeMethod
	public void precondition() throws Exception
	{
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		//step5: maximize the window
		driver.manage().window().maximize();
		driverlib.implicitlyWait(driver);
		
	
		
	}
	
	@AfterMethod
	public void postcondition()
	{
		driver.quit();
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
	   	
		TakesScreenshot ts= (TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
			FileUtils.copyFile(scr, file);
	    return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}

}
