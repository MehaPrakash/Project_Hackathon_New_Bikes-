package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.UsedCarsPage;
import utilities.ExcelFile_Write;

public class TC_003_VerifyUsedCars {
	
	WebDriver driver;
	
	HomePage hpObj;
	
	UsedCarsPage carObj;
	

	@When("the user can mouse over used cars dropdown")
	public void the_user_can_mouse_over_used_cars_dropdown() {
		
		BaseClass.getLogger().info("Mouse over used cars dropdown");
		
		driver = BaseClass.getDriver();
		
		hpObj = new HomePage(driver);
		hpObj.selectUsedCars(driver);
		
	    
	}
	@Then("the user can able to see the chennai in used cars dropdown.")
	public void the_user_can_able_to_see_the_chennai_in_used_cars_dropdown() {
		
		BaseClass.getLogger().info("Mouse over used cars dropdown");
		
		boolean result =hpObj.checkChennai();
		Assert.assertEquals(result,true);
		  
	}

	@When("click on chennai in used cars dropdown")
	public void click_on_chennai_in_used_cars_dropdown() {
		
		BaseClass.getLogger().info("Mouse over used cars dropdown");
		
		hpObj.clickChennai();
	}
	
	
	@Then("the user should be redirected to the Used cars in chennai page")
	public void the_user_should_be_redirected_to_the_used_cars_in_chennai_page() {
		
		BaseClass.getLogger().info("Redirected to the Used cars in chennai page");
		carObj = new UsedCarsPage(driver);
		boolean result =carObj.Check_usedCarPage();
		Assert.assertEquals(result,true);
	}

	@Given("the user is on the used cars page")
	public void the_user_is_on_the_used_cars_page() {
		
		BaseClass.getLogger().info("User is on the used cars page");
		
		driver = BaseClass.getDriver();
		hpObj = new HomePage(driver);
		hpObj.selectUsedCars(driver);
		hpObj.clickChennai();
		carObj = new UsedCarsPage(driver);
	}
	
	
	@When("the user click on Read more option")
	public void the_user_click_on_read_more_option() {
		
		BaseClass.getLogger().info("Click on Read more option");
		
		carObj.clickmoreoption();
	}
	
	
	@Then("display the popular models in chennai")
	public void display_the_popular_models_in_chennai() {
		
		BaseClass.getLogger().info("Display the popular models in chennai");
		
		List<String> carModels = carObj.getPopularModels();
		ArrayList<String> models = (ArrayList<String>) carModels;
		ExcelFile_Write.writePopularModels(models);
		for(String result: carModels) {
			System.out.println(result);
		}
	}
	

	@When("the user click on home link")
	public void the_user_click_on_home_link() {
		
		BaseClass.getLogger().info("Click on home page link");
		
		carObj.clickHomeOption();
	}
	
	@Then("user navigate to the home page")
	public void user_navigate_to_the_home_page() throws InterruptedException {
		
		BaseClass.getLogger().info("Navigate to the home page");
		
		Thread.sleep(2000);
	    hpObj.check_homePageNavigation();
	}





}
