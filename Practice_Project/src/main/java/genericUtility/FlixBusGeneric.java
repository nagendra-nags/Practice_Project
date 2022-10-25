package genericUtility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FlixBusGeneric {
		public void calender(WebDriver driver, String pickMonth, String pickYear, String pickdate) {
		
		String monthyear = driver.findElement(By.xpath("//caption[@class='hcr-clndr__caption-4-5-2']")).getText();
		
		System.out.println(monthyear);
		String month = monthyear.split(" ")[0].trim();
		String year=monthyear.split(" ")[1].trim();
		System.out.println(month);
		System.out.println(year);
		while(!(month.equals(pickMonth) && year.equals(pickYear)))
		{
			driver.findElement(By.xpath("//button[@class='hcr-btn-4-5-2 hcr-btn--square-4-5-2 hcr-btn--has-icon-4-5-2 IeOaN' and @aria-label='Next month']")).click();
			monthyear = driver.findElement(By.xpath("//caption[@class='hcr-clndr__caption-4-5-2']")).getText();
			month = monthyear.split(" ")[0].trim();
			year= monthyear.split(" ")[1].trim();
			
		}
		driver.findElement(By.xpath("//table[@class='hcr-clndr__table-4-5-2']/descendant::span[text()='"+pickdate+"']")).click();
	}
	public void selectPassanger(WebDriver driver, String adult, String child, String bike)
	{
		driver.findElement(By.xpath("//input[@id='search.form.label.adult']")).clear();
		driver.findElement(By.xpath("//input[@id='search.form.label.adult']")).sendKeys(adult);
		driver.findElement(By.xpath("//input[@id='search.form.label.children']")).sendKeys(child);
		driver.findElement(By.xpath("//input[@id='search.form.label.bike_slot']")).sendKeys(bike);
	}

	public void fromplace(WebDriver driver, String place) throws InterruptedException
	{
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='a8csG']/div/preceding-sibling::div"));
		for (WebElement lv : list) {
			String text = lv.getText();
			System.out.println(text);
			Thread.sleep(2000);
			if(text.contains(place))
			{
				driver.findElement(By.xpath("//span/mark[text()='"+place+"']/ancestor::button[@class='ob_qZ']")).click();
				break;
			}
		}
	}


}


