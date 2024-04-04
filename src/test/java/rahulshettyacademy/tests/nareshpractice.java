package rahulshettyacademy.tests;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import naresh.landingpage;
import naresh.products;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class nareshpractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String uname="rahulshettyacademy";
		String pwd="learning";
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		landingpage landed = new landingpage(driver);
		landed.gettoo();
		landed.loginsite(uname, pwd);
		
		Thread.sleep(3000);
		products coins = landed.selection();
		coins.productList();
		driver.findElement(By.id("country")).sendKeys("india");
		driver.findElement(By.xpath("//li/a[text()='India']")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("label[for$='checkbox2']")).click();
		driver.findElement(By.cssSelector(".btn-success")).click();
		String one =driver.findElement(By.cssSelector(".alert-success")).getText();
		//Assert.assertEquals(one, "Thank you! Your order will be delivered in next few weeks :-).");
		
		
		
		
		
		
				
		
		
		
		
	}

}
