package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UpcomingBikesPage extends BasePage{

	WebDriver driver;
	
	public UpcomingBikesPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='makeId']")
	WebElement dropDown_mfd;
	
	@FindBy(xpath="//*[normalize-space()='Upcoming Bikes in India']")
	WebElement upcomingBikes;
	
	@FindBy(xpath="//*[@id='makeId']/option")
	List<WebElement> dropDown_manufacture;
	
	@FindBy(xpath="//*[@id='makeId']/option[4]")
	WebElement honda_option;
	
	public void select_honda(){
		Select select = new Select(dropDown_mfd);
		select.selectByVisibleText("Honda");
	}
	
	public boolean checkUpComingBikesPage() {
		return upcomingBikes.isDisplayed();
	}
	
	public void select_mfd() {
		try {
		dropDown_mfd.click();
		}
		catch(Exception e) {
			
		}
	}
	
	public String checkMfdDisplay() {
		String res =String.valueOf(dropDown_manufacture.size());
		return res;
	}
	
	public boolean hondaDisplayed() {
		return honda_option.isDisplayed();
	}

}
