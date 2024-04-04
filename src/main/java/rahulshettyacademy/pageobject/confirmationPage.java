package rahulshettyacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.abstractcomponents.AbstractComponent;

public class confirmationPage extends AbstractComponent
{
	
		
		WebDriver driver;
		public confirmationPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);  //pagefactory will be used  for findby
			
		}
		
		@FindBy(css=".hero-primary")
		WebElement confimationmessage;
		
		@FindBy(css=".fa-sign-out")
		WebElement logoutone;
		
		
		
//		String four= driver.findElement(By.cssSelector(".hero-primary")).getText();
//		Assert.assertEquals(four, "THANKYOU FOR THE ORDER.");
//		driver.findElement(By.cssSelector(".fa-sign-out")).click();
		
		public String getconfirmesage()
		{
			return confimationmessage.getText();
			
		}
		
		public void logout()
		{
			logoutone.click();
		}


}
