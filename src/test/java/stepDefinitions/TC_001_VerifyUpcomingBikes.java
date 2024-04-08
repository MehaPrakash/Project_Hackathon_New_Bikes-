package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.HondaBikesPage;
import pageObjects.UpcomingBikesPage;


public class TC_001_VerifyUpcomingBikes{
	
	WebDriver driver;
	HomePage hpObj;
	UpcomingBikesPage upObj;
	HondaBikesPage hondaPage;
	
	@Given("the user is on the zigwheels home page")
	public void the_user_is_on_the_zigwheels_home_page() throws IOException {
		
		BaseClass.getLogger().info("User is on the home page");
		
		driver = BaseClass.getDriver();
		hpObj=new HomePage(driver);

	}
	
	@When("the user can mouse over upcoming bikes in new bikes dropdown")
	public void the_user_can_mouse_over_upcoming_bikes_in_new_bikes_dropdown() {
		
		hpObj.moveToNewBikes(driver);
	}
	
	@Then("the user can able to see the list of elements in new bikes dropdown.")
	public void the_user_can_able_to_see_the_list_of_elements_in_new_bikes_dropdown() throws InterruptedException {
		
		boolean result =hpObj.checkUpcomingBikes();
		Assert.assertEquals(result,true);
	}
	
	@When("the user select upcoming bikes in new bikes dropdown")
	public void the_user_select_upcoming_bikes_in_new_bikes_dropdown() throws InterruptedException {
		
		BaseClass.getLogger().info("Select upcoming bikes");
	    
		hpObj.moveToNewBikes(driver);
		
		Thread.sleep(2000);
		
		hpObj.select_button();
		
	}
	
	@Then("the user should be redirected to the Upcoming Bikes page")
	public void the_user_should_be_redirected_to_the_upcoming_bikes_page() {
		
		BaseClass.getLogger().info("Redirected to the Upcoming Bikes page");
		
		upObj = new UpcomingBikesPage(driver);
		
		upObj.checkUpComingBikesPage();
	}
	
	@Given("the user is on the Upcoming bikes")
	public void the_user_is_on_the_upcoming_bikes() throws InterruptedException {
		
		BaseClass.getLogger().info("Select upcoming bikes");
		
		driver = BaseClass.getDriver();
		hpObj=new HomePage(driver);
		hpObj.moveToNewBikes(driver);
		Thread.sleep(5000);
		hpObj.select_button();
	}
	
	@When("the user select the manufacturer dropdown")
	public void the_user_select_the_manufacturer_dropdown() {
		
		BaseClass.getLogger().info("Select the manufacturer dropdown");
	    
		upObj = new UpcomingBikesPage(driver);
		upObj.select_mfd();
	}
	
	@Then("the user can able to see the list of bike models in dropdown.")
	public void the_user_can_able_to_see_the_list_of_bike_models_in_dropdown() {
	    
		
		BaseClass.getLogger().info("Able to see the list of bike models in dropdown");
		
		boolean honda=upObj.hondaDisplayed();
		Assert.assertEquals(honda,true);
	}

	

	@When("the user select honda in manufacturer dropdown")
	public void the_user_select_honda_in_manufacturer_dropdown() {
		
		BaseClass.getLogger().info("Select honda in manufacturer dropdown");
		
		BaseClass.getLogger().info("Select honda bikes");
//		upObj = new UpcomingBikesPage(driver);
		upObj.select_honda();
	    
	}

	@Then("the user should be redirected to the Honda Upcoming Bikes page")
	public void the_user_should_be_redirected_to_the_honda_upcoming_bikes_page() {
		
		BaseClass.getLogger().info("Verify the navigation");
		
		hondaPage = new HondaBikesPage(driver);
		String res = hondaPage.hondaConfirmation();
		Assert.assertEquals(res, "Honda Upcoming Bikes in India");
	}

	
	@When("the user whether search box is enabled or disabled")
	public void the_user_whether_search_box_is_enabled_or_disabled() {
		
		BaseClass.getLogger().info("Verify the search box");
		
		boolean result = hpObj.checkSearchBoxEnabled();
		Assert.assertTrue(result);
	    
	}
	

	@Then("the user enter the upcoming honda bikes in search box")
	public void the_user_enter_the_upcoming_honda_bikes_in_search_box() {
		
		BaseClass.getLogger().info("Enter the upcoming honda bikes");
	    hpObj.checkSearchBoxResults();
	}






}
