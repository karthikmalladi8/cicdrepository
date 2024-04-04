package rahulshettyacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
//import rahulshettyacademy.pageobject.Addtocart;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.OrderPage;
import rahulshettyacademy.pageobject.Productatelogue;
import rahulshettyacademy.pageobject.cartPage;
import rahulshettyacademy.pageobject.confirmationPage;
//import rahulshettyacademy.pageobject.verifyproducts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class alone2 extends BaseTest {

	String productname="IPHONE 13 PRO";
	
	@Test(dataProvider="GetData",groups= {"purchase"})
	public void  alone2(HashMap<String,String> input) throws IOException
	{
		// TODO Auto-generated method stub
		Productatelogue productateloguesome= landed.loginApplication(input.get("Emai"),input.get("pswd"));
		List<WebElement> products = productateloguesome.getProductList();
		productateloguesome.addProductToCart(input.get("product"));
		cartPage verify=productateloguesome.addcart();
		Boolean match =verify.listchecking(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage checkpage = verify.goTocheckout();
		confirmationPage confirm = checkpage.selectCountry("india");
		String four = confirm.getconfirmesage();
		Assert.assertEquals(four, "THANKYOU FOR THE ORDER.");
		confirm.logout();
	}
	
	@Test(dependsOnMethods= {"alone2"})
	public void OrderHistoryTest()
	{
		Productatelogue productateloguesome = landed.loginApplication("karthikmalladi@gmail.com","aZaW@1533");
		OrderPage orderPage = landed.goToOrderPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productname));
	}
	
	
	//dataprovider -json	
	@DataProvider 
	public Object[][] GetData() throws IOException
	{

		List<HashMap<String,String>> data = getjsondatatomap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	

//	@DataProvider
//	public Object[] GetData()
//	{
//		return new Object[][] {{"karthikmalladi@gmail.com","aZaW@1533","IPHONE 13 PRO"},{"dsjdhsh@gmail.com","aZaW@1533","ADIDAS ORIGINAL"}};
//		
//	}
	
	
//	HashMap<String,String> map = new HashMap<String,String>();
//	map.put("Emai","karthikmalladi@gmail.com");
//	map.put("pswd", "aZaW@1533");
//	map.put("product", "IPHONE 13 PRO");
//	
//	HashMap<String,String> map1 = new HashMap<String,String>();
//	map1.put("Emai","dsjdhsh@gmail.com");
//	map1.put("pswd", "aZaW@1533");
//	map1.put("product", "ADIDAS ORIGINAL");
	
//		
	@AfterMethod
	public void finsih()
	{
		driver.close();
	}
		
	}


