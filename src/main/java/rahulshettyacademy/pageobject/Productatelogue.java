package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.abstractcomponents.AbstractComponent;

public class Productatelogue extends AbstractComponent
{
	//first created some basic class driver
	WebDriver driver;
	//created one constructor and assigned that driver from different class
	public Productatelogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);  //pagefactory will be used  for findby
		
	}

	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	
	@FindBy(css=".ng-animating")
	WebElement animating;
	
	By productBy = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toastemessage = By.id("toast-container");
	
	public List<WebElement> getProductList()
	{
		waitingtoappear(productBy);
		return products;
	}
	
	public WebElement getProductByName(String productname)
	{
	WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().
			equals(productname)).findFirst().orElse(null);
	return prod;
	}
	
	public void addProductToCart(String productname)
	{
		WebElement prod= getProductByName(productname);
		prod.findElement(addtocart).click();
		waitingtoappear(toastemessage);
		waitingtodisayaiper(animating);	
	}
	
	

	
	
}
