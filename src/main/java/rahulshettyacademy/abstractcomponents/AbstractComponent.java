package rahulshettyacademy.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobject.OrderPage;
import rahulshettyacademy.pageobject.cartPage;

public class AbstractComponent 
{
	WebDriver driver;
	public AbstractComponent(WebDriver driver) 
	{
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement addtocartoption;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;

	public void waitingtoappear(By findby)
	{
	WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait1.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitforWebElementoappear(WebElement findby)
	{
	WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait1.until(ExpectedConditions.visibilityOf(findby));
	}
	
	public void waitingtodisayaiper(WebElement findin)
	{
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.invisibilityOf(findin));
	}
	
	public cartPage addcart()
	{
		addtocartoption.click();
		cartPage verify = new  cartPage (driver);
		return verify;
	
	}
	
	public OrderPage goToOrderPage()
	{
		orderHeader.click();
		OrderPage orderPage = new  OrderPage (driver);
		return orderPage;
	
	}

}
