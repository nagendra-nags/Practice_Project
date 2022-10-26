package testScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericUtility.ExcelExample;
import genericUtility.ExcelUtility;
import genericUtility.FlixBusGeneric;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepositry.FlixBusPage;

public class FlixBus extends FlixBusGeneric {
	ExcelUtility elib=new ExcelUtility();
//	@Parameters({"round", "fromName", "toName", "pickMonth", "pickYear", "pickdate", "pickReturnMonth", "pickReturnYear", "pickReturndate", "adult", "child", "bike"})
	@Test
	public void bookBus(String round, String fromName, String toName, String pickMonth, String pickYear, String pickdate, String pickReturnMonth, String pickReturnYear, String pickReturndate, String adult, String child, String bike) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		FlixBusPage bus=new FlixBusPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://global.flixbus.com/");
		
		String round1 = System.getProperty("round");
		bus.oneWay(round1, fromName, toName, pickMonth, pickYear, pickdate, pickReturnMonth, pickReturnYear, pickReturndate, adult, child, bike, driver);
		
		
	}
	
//	@DataProvider
//	public Object[][] data() throws Throwable
//	{
//	
//		Object[][] obj=new Object[1][12];
//		obj[0][0]=elib.getdata("sheet3", 1, 0);
//		obj[0][1]=elib.getdata("sheet3", 1, 1);
//		obj[0][2]=elib.getdata("sheet3", 1, 2);
//		obj[0][3]=elib.getdata("sheet3", 1, 3);
//		
//		obj[0][4]=elib.getdata("sheet3", 1, 4);
//		obj[0][5]=elib.getdata("sheet3", 1, 5);
//		obj[0][6]=elib.getdata("sheet3", 1, 6);
//		obj[0][7]=elib.getdata("sheet3", 1, 7);
//		obj[0][8]=elib.getdata("sheet3", 1, 8);
//		obj[0][9]=elib.getdata("sheet3", 1, 9);
//		obj[0][10]=elib.getdata("sheet3", 1, 10);
//		obj[0][11]=elib.getdata("sheet3", 1, 11);
		
//		obj[1][0]="oneway";
//		obj[1][1]="Hamburg";
//		obj[1][2]="Milan";
//		obj[1][3]="February";
//		obj[1][4]="2024";
//		obj[1][5]="11";
//		obj[1][6]="March";
//		obj[1][7]="2024";
//		obj[1][8]="18";
//		obj[1][9]="4";
//		obj[1][10]="1";
//		obj[1][11]="1";
//		
//		obj[2][0]="roundway";
//		obj[2][1]="Amsterdam";
//		obj[2][2]="Paris";
//		obj[2][3]="May";
//		obj[2][4]="2024";
//		obj[2][5]="22";
//		obj[2][6]="June";
//		obj[2][7]="2024";
//		obj[2][8]="18";
//		obj[2][9]="3";
//		obj[2][10]="2";
//		obj[2][11]="1";
//		
//		obj[3][0]="roundway";
//		obj[3][1]="Paris";
//		obj[3][2]="Rossano";
//		obj[3][3]="March";
//		obj[3][4]="2024";
//		obj[3][5]="10";
//		obj[3][6]="May";
//		obj[3][7]="2024";
//		obj[3][8]="18";
//		obj[3][6]="3";
//		obj[3][7]="2";
//		obj[3][8]="1";
//		return obj;
//	}
	

}
