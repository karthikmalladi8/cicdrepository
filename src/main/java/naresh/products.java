package naresh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class products 
{
	
		WebDriver driver;
		public products(WebDriver driver)
		{
			
			this.driver=driver;
			PageFactory.initElements(driver, this);		
		}
		
//		@FindBy(css="button.btn.btn-info")
//		List<WebElement> plist;
		
		
		
		@FindBy(css=".nav-link.btn.btn-primary")
		WebElement cart;
		
		@FindBy(css=".btn.btn-success")
		WebElement finallist;
		
		
		
	
	
	public void productList() throws InterruptedException
	{
		
	List<WebElement> lee= driver.findElements(By.cssSelector("button.btn.btn-info"));
	System.out.println(lee.size());
	for(int i=0;i<lee.size();i++)
	{
		lee.get(i).click();
		Thread.sleep(3000);
		cart.click();
		finallist.click();
		
	}
	
	
	}



	
	
	

		
}
