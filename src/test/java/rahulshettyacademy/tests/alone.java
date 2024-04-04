package rahulshettyacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class alone {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		String pname="IPHONE 13 PRO";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("karthikmalladi@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("aZaW@1533");
		driver.findElement(By.id("login")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement one =products.stream().filter(s->s.findElement(By.cssSelector(".mb-3 h5")).getText().
				equals(pname)).findFirst().orElse(null);
		one.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List<WebElement> two= driver.findElements(By.cssSelector(".cart h3"));
		Boolean three =two.stream().anyMatch(s->s.getText().equalsIgnoreCase(pname));
		Assert.assertTrue(three);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector(".form-group input")), "India").build().perform();
		driver.findElement(By.cssSelector(".ta-results button:last-of-type")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String four= driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(four, "THANKYOU FOR THE ORDER.");
		driver.findElement(By.cssSelector(".fa-sign-out")).click();
		
		
		
		
 
	}

}
