package rahulshettyacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);  //pagefactory will be used  for findby
		
	}
	
	@FindBy(css=".form-group input")
	WebElement county;
	
	@FindBy(css=".ta-results button:last-of-type")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	public confirmationPage selectCountry(String CountryName)
	{
	
	Actions a = new Actions(driver);
	a.sendKeys(county,CountryName).build().perform();
	selectCountry.click();
	submit.click();
	confirmationPage confirm = new confirmationPage(driver);
	return confirm;
	}
}
