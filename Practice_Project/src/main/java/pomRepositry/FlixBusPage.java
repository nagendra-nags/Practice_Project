package pomRepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.FlixBusGeneric;



public class FlixBusPage extends FlixBusGeneric{
	
	@FindBy(xpath="//input[@id='searchInput-from']")
	private WebElement fromTB;
	
	@FindBy(xpath="//input[@id='searchInput-to']")
	private WebElement toTB;
	
	@FindBy(xpath="//input[@id='dateInput-from']")
	private WebElement departureDate;
	
	@FindBy(xpath="//input[@id='dateInput-to']")
	private WebElement returnDate;
		
	@FindBy(xpath="//label[@class='hcr-radio__label-4-5-2'  and @for='search-mask-trip-mode-oneway-toggle']")
	private WebElement oneWay;
	
	@FindBy(xpath="//label[@class='hcr-radio__label-4-5-2' and not(@for='search-mask-trip-mode-oneway-toggle')]")
	private WebElement roundWay;
	
	@FindBy(xpath="//input[@id='productSummary']")
	private WebElement passanger;
	
	@FindBy(xpath="//button[@class='hcr-btn-4-5-2 hcr-btn--primary-4-5-2 l_NNi']")
	private WebElement search;
	
	
	
	public WebElement getFromTB() {
		return fromTB;
	}



	public WebElement getToTB() {
		return toTB;
	}



	public WebElement getDepartureDate() {
		return departureDate;
	}

	public WebElement getreturnDate() {
		return returnDate;
	}

	public WebElement getOneWay() {
		return oneWay;
	}



	public WebElement getRoundWay() {
		return roundWay;
	}



	public WebElement getPassanger() {
		return passanger;
	}



	public WebElement getSearch() {
		return search;
	}
	
	public void oneWay(String round, String fromName, String toName, String pickMonth, String pickYear, String pickdate, String pickReturnMonth, String pickReturnYear, String pickReturndate, String adult, String child, String bike, WebDriver driver) throws InterruptedException
	
	{
		String selector="oneway";
	if(selector.equals(round)){
			oneWay.click();
	}
	else {
		roundWay.click();
	}
		fromTB.click();
		fromTB.sendKeys(fromName);
		Thread.sleep(2000);
		fromplace(driver, fromName);
		
		Thread.sleep(3000);
		toTB.click();
		toTB.sendKeys(toName);
		Thread.sleep(2000);
		fromplace(driver, toName);
		departureDate.click();
		calender(driver, pickMonth, pickYear, pickdate);
		boolean checkbox = driver.findElement(By.xpath("//label[text()='Round Trip']/parent::div/input[@id='search-mask-trip-mode-roundtrip-toggle']")).isSelected();
		if(checkbox==true) {
		returnDate.click();
		calender(driver, pickReturnMonth, pickReturnYear, pickReturndate);
		}
		passanger.click();
		
		selectPassanger(driver, adult, child, bike);
		
	//	search.click();
		
	}

	public FlixBusPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


}
