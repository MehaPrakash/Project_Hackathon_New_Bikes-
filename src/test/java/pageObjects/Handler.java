package pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Handler extends BasePage{
	public Handler(WebDriver driver) {
		super(driver);
	}
	
	public boolean windowNavigate(String WebsiteTitle) {
		Set<String> window = driver.getWindowHandles();
		for(String id : window) {
			driver.switchTo().window(id);
			String title = driver.getTitle();
			if(title.equals(WebsiteTitle)) {
				return true;
			}
		}
		return false;
	}
 
}
	
	

