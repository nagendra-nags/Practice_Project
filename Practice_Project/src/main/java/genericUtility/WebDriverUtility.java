package genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
		public void implicitlyWait(WebDriver driver) 
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		}
		
		public void explicitlyWaitForPage(WebDriver driver, String partailPageURL)
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.urlContains(partailPageURL));
			
		}
		
		public void explicitlyWaitForVisibilElement(WebDriver driver, WebElement element)
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public void switchToWindow(WebDriver driver, String partialWindowTitle)
		{
			String mainwindow = driver.getWindowHandle();
			Set<String> allwindow = driver.getWindowHandles();
			Iterator<String> it= allwindow.iterator();
			
			while(it.hasNext())
			{
				String winID=it.next();
				driver.switchTo().window(winID);
				String currentWindowTitle=driver.getTitle();
				if(currentWindowTitle.contains(partialWindowTitle))
				{
					break;
				}
			}		
			//	driver.switchTo().window(mainwindow);
			
		}
		
		
		
		public void scrollpage(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("Arguments[0].scrollintoview()", element);
		}
		
		public void scrollByXandY(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js= (JavascriptExecutor) driver;
			Point location = element.getLocation();
			int x = location.getX();
			int y=location.getY();
			js.executeScript("window.scrollBy("+x+","+y+")");
		}
		
		public void selectbyvisibletext(WebElement element, String text)
		{
			Select s = new Select(element);
			s.selectByVisibleText(text);
		}
		
		public void captureScreeShot(String scriptName, WebDriver driver)
		{
		    JavaUtility jlib = new JavaUtility();	
			TakesScreenshot ts= (TakesScreenshot) driver;
			File scr = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenShots/"+jlib.getsystemdate()+"/"+scriptName);
			try {
				FileUtils.copyFile(scr, dest);
			} catch (IOException e) {
				
			}
			System.out.println("screenshot saved successfully");
		}
		
		
		
	}
