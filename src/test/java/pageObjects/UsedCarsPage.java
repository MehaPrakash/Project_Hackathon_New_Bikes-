package pageObjects;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsedCarsPage extends BasePage{

   WebDriver driver;
	//constructor
	public UsedCarsPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//*[@id='usedcarttlID']")
	WebElement usedcarheader;
	
	@FindBy(xpath = "//*[contains(text(),'Read More')]")
	WebElement moreoption;
	
	@FindBy(xpath = "//*[@id='models-table']/table/tbody/tr/td[1]")
	List<WebElement> UserCarModelNames;
	
	@FindBy(linkText="Home")
	WebElement homebutton;
	
	
	
	public boolean Check_usedCarPage(){
		try {
			boolean header = usedcarheader.isDisplayed();
			return header;
			}
			catch(Exception e) {
				return false;
			}
	}
	public void clickmoreoption() {
		try {
			moreoption.click();
		}
		catch(Exception e) {
			System.out.println("no more option");
		}
	}
	public List<String> getPopularModels(){
		List<String> model = new ArrayList<String>();
		for(WebElement res: UserCarModelNames) {
			model.add(res.getText());
		}
		return model;
	}
	public void clickHomeOption() {
		homebutton.click();
	}
 
}
