package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry1;
import rahulshettyacademy.pageobject.Productatelogue;
import rahulshettyacademy.pageobject.cartPage;

public class ErrorValidations extends BaseTest {

	@Test(groups={"ErrorHandling"},retryAnalyzer=Retry1.class)
	public void  LoginErrorValidations() throws IOException
	{
		// TODO Auto-generated method stub
		String productname="IPHONE 13 PRO";
		Productatelogue productateloguesome= landed.loginApplication("karthikmalladi@gmail.com","aZaW@1733");
		Assert.assertEquals("Incorrect email or password.", landed.getErrormessage()); 
		
	}
	
	@Test
	public void ProductErrorValidation()
	{
		String productname="IPHONE 13 PRO";
		Productatelogue productateloguesome= landed.loginApplication("dsjdhsh@gmail.com","aZaW@1533");
		List<WebElement> products = productateloguesome.getProductList();
		productateloguesome.addProductToCart(productname);
		cartPage verify=productateloguesome.addcart();
		Boolean match =verify.listchecking("IPHONE");
		Assert.assertFalse(match);
	}
			
 
	}


