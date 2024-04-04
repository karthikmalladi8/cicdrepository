package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.abstractcomponents.AbstractComponent;

public class OrderPage extends AbstractComponent
{
	//first created some basic class driver
	WebDriver driver;
	//created one constructor and assigned that driver from different class
	public OrderPage(WebDriver driver)
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
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	

	
	
	
	public Boolean VerifyOrderDisplay(String productname)
	{
		Boolean three = productNames.stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));
		return three;
	}
	

}
