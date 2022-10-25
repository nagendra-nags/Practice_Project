package genericUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver=null;
	public JavaUtility jlib= new JavaUtility();
	public ExcelUtility elib= new ExcelUtility();
	public FileUtility flib= new FileUtility();
	public WebDriverUtility driverlib= new WebDriverUtility();
	
	
	
	@BeforeSuite
	public void connectToDatabase()
	{
		System.out.println("Database is connected");
	}
	
	@AfterSuite
	public void disconnectToDatabase()
	{
		System.out.println("Database is disconnected");
	}
//	@Parameters("browser")
	
	@BeforeClass
	public void precondition() throws Exception
	{
		
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser");
		
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		//step5: maximize the window
		driver.manage().window().maximize();
		driverlib.implicitlyWait(driver);
		
		//step6: fetch the webpage
	//	driver.get(URL);

		
	}
	
	@AfterClass
	public void postcondition()
	{
		driver.quit();
	}
	
	
	
	
	

	
//	@BeforeMethod
//	public void loginToApp() throws Exception
//	{
//		String url = flib.getPropertyKeyValue("url");
//		driver.get(url);
//
//	}
//	
//	@AfterMethod
//	public void logOutFromApp()
//	{
//		
//	}


}
