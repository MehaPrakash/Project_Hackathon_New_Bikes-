package stepDefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Handler;
import pageObjects.LoginRelatedPage;
import utilities.DataReader;

public class LoginDDT_Verification {
	
	WebDriver driver;
	LoginRelatedPage lp;
	List<HashMap<String, String>> datamap;
	
	@Given("the user opens zigwheels site")
	public void the_user_opens_zigwheels_site() {
		
		BaseClass.getLogger().info("User opens zigwheels site");
		
		driver = BaseClass.getDriver();
		lp =  new LoginRelatedPage(driver);
		lp.gotohome();
	}

	@Given("the user navigates to ZigWheels login page")
	public void the_user_navigates_to_zig_wheels_login_page() throws InterruptedException {
		
		BaseClass.getLogger().info("Click the Login button");
		lp.clickLoginSignUp();
	}

	@When("the user clicks on sign in with Google")
	public void the_user_clicks_on_sign_in_with_google() throws InterruptedException {
		
		BaseClass.getLogger().info("Clicks on sign in with Google");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp.selectGoogleButton();
	}
	
	@When("the user enters the invalid email id with the excel row {string}")
	public void the_user_enters_the_invalid_email_id_with_the_excel_row(String rows) throws InterruptedException {
		
		BaseClass.getLogger().info("Enter the invalid email id");
		
		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\Project_Login_Excel.xlsx", "Sheet1");
		 int index = Integer.parseInt(rows)-1;
		 String email = datamap.get(index).get("Invalid Email Id");
		 lp.setEmailInput(email);
	}

	@When("the user clicks next")
	public void the_user_clicks_next() throws InterruptedException {
		
		BaseClass.getLogger().info("Clicks next button");
		
		lp.clickNextButton();
	}

	@Then("the user should see error on the login page")
	public void the_user_should_see_error_on_the_login_page() {
		try {
			
			BaseClass.getLogger().info("Capture the error message");
			lp.captureErrorMsg();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	//Basic Functionality
	
	@When("the user clicks on Login button")
	public void the_user_clicks_on_login_button() throws InterruptedException {
		driver = BaseClass.getDriver();
		lp =  new LoginRelatedPage(driver);
		lp.clickLoginSignUp();
	}
	
	@Then("the user redirected to Login\\/Register pop-up")
	public void the_user_redirected_to_login_register_pop_up() {
	   boolean result = lp.checkLoginOrRegiserPopUp();
	   Assert.assertTrue(result);
	}
	
	@Then("the user is redirected to Google Account Page")
	public void the_user_is_redirected_to_google_account_page() {
		Handler window = new Handler(driver);
		boolean result =window.windowNavigate("Sign in - Google Accounts");
		Assert.assertTrue(result);
	}
	
}


