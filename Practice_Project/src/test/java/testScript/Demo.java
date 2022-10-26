package testScript;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo extends BaseClass {
	
	@Test
	public void actitimeloginscript()
	{
		
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
		
	}
	
	@Test
	public void fbloginscript()
	{
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nagendra");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("1235");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		assertTrue(false);
			
	}
	
	@Test
	public void Hrm()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("nagendra");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1235");
		driver.findElement(By.xpath("//button[contains(@class, 'oxd-button oxd')]")).click();
		assertTrue(false);
	}


}
