package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
	WebDriver driver;
	
	//constructor
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	//WebElement Locators
	
	
	@FindBy(linkText="New Bikes")
	WebElement sel_Newbikes;
	
	@FindBy(xpath="//*[contains(text(),'Upcoming Bikes')]")
	WebElement link_upcomingBikes;
	
	@FindBy(xpath = "//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/ul/li]")
	List<WebElement> list_newBikes;
	
	@FindBy(xpath="//input[@name='bysearch']")
	WebElement search_box;
	
	@FindBy(xpath="//*[@id='search-Sml']/span[3]")
	WebElement search_icon;
	
	@FindBy(linkText = "Used Cars")
	WebElement usedcars;
	
	@FindBy(xpath = "//li/span[text()='Chennai'][1]")
	WebElement Link_chennai;
	
	@FindBy(id="des_lIcon")
	WebElement btn_login;
	
	public void moveToNewBikes(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(sel_Newbikes).perform();
	}

	
	public boolean checkUpcomingBikes() {
		return link_upcomingBikes.isDisplayed();
		
	}
	
	public void select_button() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click()",link_upcomingBikes);
		link_upcomingBikes.click();
	}
	
	
	public String checkNewBikesDisplay() {
		String res =String.valueOf(list_newBikes.size());
		return res;
	}
	
	public boolean checkSearchBoxEnabled() {
		return search_box.isEnabled();
		
	}
	
	public void checkSearchBoxResults() {
		search_box.sendKeys("upcoming honda bikes");
		search_icon.click();
	}
	
	public void upcomingPage(WebDriver driver) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(sel_Newbikes).perform();
		Thread.sleep(5000);
		link_upcomingBikes.click();
	}
	
	public void selectUsedCars(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(usedcars).perform();
	}
	
	public boolean checkChennai() {
		return Link_chennai.isDisplayed();
	}
	
	public void clickChennai() {
		Link_chennai.click();
	}
	
	public boolean check_homePageNavigation(){
		try {
			boolean homepage = btn_login.isDisplayed();
			return homepage;
			}
			catch(Exception e) {
				return false;
			}
	}
	
	public void clickLoginButton() {
		btn_login.click();
	}
}
