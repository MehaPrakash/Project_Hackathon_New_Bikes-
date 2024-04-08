package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRelatedPage extends BasePage {
	public LoginRelatedPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='row qlc']//div[@class='col-lg-2']")
	public WebElement zigwheelshome;
	
	@FindBy(xpath = "//div[@id='forum_login_title_lg']")
	public WebElement loginSignUpButton;
	
	@FindBy(xpath="//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	public WebElement loginWithGoogleButton;
	
	
//	@FindBy(id="identifierId"
	@FindBy(xpath="//input[@type='email']")
	public WebElement emailInput;
	
	@FindBy(xpath = "//span[normalize-space()='Next']")
	public WebElement nextbutton;
	
	@FindBy(css=".Ekjuhf.Jj6Lae")//.o6cuMc.Jj6Lae  //.Ekjuhf.Jj6Lae ///html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/c-wiz[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]
	public WebElement errorMessage;

	public void gotohome() {
		zigwheelshome.click();
	}
	
	public void clickLoginSignUp() throws InterruptedException {
		Thread.sleep(6000);
		loginSignUpButton.click();
	}
	
	public void selectGoogleButton() throws InterruptedException {
		loginWithGoogleButton.click();
		Thread.sleep(8000);
	}
	
	public void setEmailInput(String email) throws InterruptedException {
		//Thread.sleep(6000);
		Handler window = new Handler(driver);
		window.windowNavigate("Sign in - Google Accounts");
		emailInput.sendKeys(email);//RandomStringUtils.randomAlphabetic(5) + "@gmail.com"
	}
	
	
	public void clickNextButton() throws InterruptedException {
		nextbutton.click();
		Thread.sleep(5000);
	}
	//Capturing Error message
	public void captureErrorMsg() throws IOException, InterruptedException {
		Thread.sleep(8000);
		try {
		String errorMsg = errorMessage.getText();
		System.out.println(errorMsg);
		}
		catch(Exception e) {
			
		}
		
	}
	
	public boolean checkLoginOrRegiserPopUp() {
		return loginWithGoogleButton.isDisplayed();
	}
	
	
}


