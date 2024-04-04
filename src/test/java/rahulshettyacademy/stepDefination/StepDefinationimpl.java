package rahulshettyacademy.stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.Productatelogue;
import rahulshettyacademy.pageobject.cartPage;
import rahulshettyacademy.pageobject.confirmationPage;

public class StepDefinationimpl extends BaseTest 
{
	public LandingPage landingPage;
	public Productatelogue productateloguesome;
	public confirmationPage confirm;
	public String four;
	@Given("I landed on Ecommerce Page")
	public void _I_landed_on_Ecommerce_page() throws IOException
	{
		landingPage = launchApplication();
		
	}
	
	@Given ("^Logged in with username (.+) and password (.+)$")
	public void _logged_with_username_password(String email,String pswd)
	{
	  productateloguesome= landed.loginApplication(email,pswd);
		
	}
	
	@When ("^I add product (.+) to cart$")
	public void _add_product_cart(String productName)
	{
		List<WebElement> products = productateloguesome.getProductList();
		productateloguesome.addProductToCart(productName);
	}
	
	@And ("^Checkout (.+) and submit the order$")
	public void _checkout_and_submit_order(String product)
	{
		cartPage verify=productateloguesome.addcart();
		Boolean match =verify.listchecking(product);
		Assert.assertTrue(match);
		CheckOutPage checkpage = verify.goTocheckout();
	    confirm = checkpage.selectCountry("india");
	    four = confirm.getconfirmesage();
		
	}
	
	@Then ("{string} message is displayed on confirmation page")
	public void message_displayed_confirmationpage(String string)
	{
		String four = confirm.getconfirmesage();
		Assert.assertEquals(four, string);
	}

	@Then ("{string} message is displayed")
	public void something_message_is_displayed(String string1)
	{
		Assert.assertEquals(string1, landed.getErrormessage()); 
	}
	

}
