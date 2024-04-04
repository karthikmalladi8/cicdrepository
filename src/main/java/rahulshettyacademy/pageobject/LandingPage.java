package rahulshettyacademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponents.AbstractComponent;

public class LandingPage extends AbstractComponent
{
	//first created some basic class driver
	WebDriver driver;
	//created one constructor and assigned that driver from different class
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);  //pagefactory will be used  for findby
		
	}

	//WebElement userEmail = driver.findElement(By.id("userEmail")); userPassword login
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement psws;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;
	
	public Productatelogue loginApplication(String one, String two)
	{
		userEmail.sendKeys(one);
		psws.sendKeys(two);
		login.click();
		Productatelogue productateloguesome = new Productatelogue(driver);
		return productateloguesome;
	}
	
	public String getErrormessage()
	{
		waitforWebElementoappear(errormessage);
		 return errormessage.getText();
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
}
