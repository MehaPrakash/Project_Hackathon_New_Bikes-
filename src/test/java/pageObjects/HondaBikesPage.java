package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HondaBikesPage extends BasePage{
	
	    WebDriver driver;
	
		public HondaBikesPage(WebDriver driver) {
			super(driver);
		}
		
		@FindBy(xpath = "//main//h1")
		WebElement hondaPageElement;
		
		@FindBy(xpath="//*[contains(text(),'...Read More')]")
		WebElement btn_ReadMore;
		
		@FindBy(xpath="//tr[@class='ml-15 ']")
		List<WebElement> rowSize;
		
		@FindBy(xpath="//tr[@class='ml-15 ']//td[1]")
		List<WebElement> modelNameList;
		
		@FindBy(xpath="//tr[@class='ml-15 ']//td[2]")
		List<WebElement> allPriceList;
		
		@FindBy(xpath="//tr[@class='ml-15 ']//td[3]")
		List<WebElement> expectedDateList;
		
		@FindBy(linkText="Used Cars")
		WebElement dropDown_UsedCars;
		
		@FindBy(xpath = "//li/span[text()='Chennai'][1]")
		WebElement click_Chennai;
		
		
		public String hondaConfirmation() {
			String res  = hondaPageElement.getText();
			return res;
		}
		
		public boolean hondaConfirmationUsingSearch() {
			boolean res  = hondaPageElement.isDisplayed();
			return res;
		}
		public void clickReadMore() {
			btn_ReadMore.click();
		}
		
		public int getRowCount() {
			return rowSize.size();
		}
		
		public List<String> getModelNames(){
			List<String> modelName = new ArrayList<String>();
//			int noOfData = rowSize.size();
			List<WebElement> names = modelNameList;
			for(WebElement res: names) {
				modelName.add(res.getText());
			}
			return modelName;
		}
		
		
		List<String> normalPrice = new ArrayList<String>();
		public List<Double> getpriceList(){
			List<Double> price = new ArrayList<Double>();
			List<WebElement> priceList = allPriceList;
			for(WebElement res: priceList) {
				String name = res.getText();
				String n[] = name.split(" ");
				String priceNo = n[1];
				Double priceL;
				if(priceNo.contains(",")){
					priceL = Double.parseDouble(priceNo.replace(",", ""));
					price.add(priceL);
					normalPrice.add("Rs."+priceNo);
				}
				else {
					priceL = Double.parseDouble(priceNo) * 100000;
					price.add(priceL);
					normalPrice.add("Rs."+priceNo+" lakhs");
				}
			}
			return price;
		}
		
		public List<String> getNormalPriceFormat(){
			return normalPrice;
		}
		
		public List<String> getExpectedDate(){
			List<String> expectedDate = new ArrayList<String>();
			List<WebElement> dateList = expectedDateList;
			for(WebElement res:dateList) {
				String date = res.getText();
				expectedDate.add(date);
			}
			return expectedDate;
		}
		
		public void selectUsedCars(WebDriver driver) throws InterruptedException {
			Actions act = new Actions(driver);
			act.moveToElement(dropDown_UsedCars).perform();
			
			Thread.sleep(2000);
			
			click_Chennai.click();
		}
		
		
}
