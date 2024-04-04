package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.abstractcomponents.AbstractComponent;

public class cartPage extends AbstractComponent
{
	//first created some basic class driver
	WebDriver driver;
	//created one constructor and assigned that driver from different class
	public cartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);  //pagefactory will be used  for findby
		
	}

	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	
	@FindBy(css=".cart h3")
	List<WebElement> two;
	
	@FindBy(css=".totalRow button")
	WebElement cartclick;
	
	
	
	
	
	//List<WebElement> two= driver.findElements(By.cssSelector(".cart h3"));
	//Boolean three =two.stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	
	
	public Boolean listchecking(String productname)
	{
		Boolean three = two.stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));
		return three;
	}
	
	public CheckOutPage goTocheckout()
	{
		cartclick.click();
		CheckOutPage checkpage = new CheckOutPage(driver);
		return checkpage;
		
		
	}
	
	
	
	

	
	
}
