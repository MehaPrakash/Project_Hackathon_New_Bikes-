package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.HondaBikesPage;
import pageObjects.UpcomingBikesPage;
import utilities.ExcelFile_Write;

public class TC_002_VerifyBikesUnderPrice {
	
	WebDriver driver;
	HondaBikesPage honObj;
	HomePage hpObj;
	UpcomingBikesPage upObj;
	@Given("the user is on the honda Upcoming Bikes page")
	public void the_user_is_on_the_honda_upcoming_bikes_page() throws InterruptedException {
	    
		
		BaseClass.getLogger().info("Navigate to home page");
		
		driver = BaseClass.getDriver();
		hpObj=new HomePage(driver);
		hpObj.moveToNewBikes(driver);
		hpObj.select_button();
		upObj = new UpcomingBikesPage(BaseClass.getDriver());
		Thread.sleep(4000);
		upObj.select_mfd();
		honObj= new HondaBikesPage(BaseClass.getDriver());
	}

	@When("the user able to see honda upcoming bikes under {int} lakhs by clicking Read more options")
	public void the_user_able_to_see_honda_upcoming_bikes_under_lakhs_by_clicking_read_more_options(Integer int1) {
	    
		BaseClass.getLogger().info("Able to see honda upcoming bikes under 4 lakhs");
		
		honObj.clickReadMore();
	}

	@Then("display those prices")
	public void display_those_prices() {
		BaseClass.getLogger().info("Verify the display of the honda bike prices under 4 lakhs");
		
		int rowSize = honObj.getRowCount();
		List<String> modelName = honObj.getModelNames();
		List<Double> priceList = honObj.getpriceList();
		List<String> priceFormat = honObj.getNormalPriceFormat();
		List<String> date = honObj.getExpectedDate();
		ArrayList<String> bikeDetailsList = new ArrayList<String>();
		
         for(int i=0;i<rowSize-1;i++){
			
			String bikeDetails = modelName.get(i) +" : "+ priceFormat.get(i) +" : "+ date.get(i);
			if(priceList.get(i)<400000.0) {
				System.out.println(bikeDetails);
				bikeDetailsList.add(bikeDetails);
			}
 		}
         
         ExcelFile_Write.writeBikesDetails(bikeDetailsList);
		
	}
}
