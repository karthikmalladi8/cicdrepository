package naresh;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.abstractcomponents.AbstractComponent;

public class landingpage 
{
	WebDriver driver;
	public landingpage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(id="username")
	WebElement unames;
	
	@FindBy(id="password")
	WebElement pwds;
	
	@FindBy(xpath="//label[@class='customradio'][2]")
	WebElement submit;
	
	@FindBy(id="okayBtn")
	WebElement message;
	
	@FindBy(xpath="//select[@class='form-control']")
	WebElement student;
	
	@FindBy(id="terms")
	WebElement term;
	
	@FindBy(id="signInBtn")
	WebElement sigin;
	
//	
//	public void waitingtodisayaiper1(WebElement findin)
//	{
//		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
//		//wait1.until(ExpectedConditions.visibilityOfElementLocated(findin));
//		wait1.until((ExpectedConditions.visibilityOfAllElements(findin));
//	}
	
	public void gettoo()
	{
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
	}
	
	
	public void loginsite(String ok,String no) throws InterruptedException
	{
		unames.sendKeys(ok);
		pwds.sendKeys(no);
		submit.click();
		Thread.sleep(2000);
		message.click();
		
		
	}
	
	public products selection() throws InterruptedException
	{
	
	WebElement options= student;
	Select main = new Select(options);
	main.selectByIndex(2);
	term.click();
	sigin.click();
	Thread.sleep(3000);
	products coins = new products(driver);
	return coins;
	
	}
}
