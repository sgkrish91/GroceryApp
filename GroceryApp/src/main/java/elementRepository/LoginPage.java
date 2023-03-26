package elementRepository;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelRead;
import utilities.WaitUtility;
import utilities.GeneralUtilities;

public class LoginPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtility ew=new WaitUtility();
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signInButton;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement rememberMe;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement error;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/login']")
	private WebElement title;
	
	@FindBy(xpath="//a[@class='nav-link']//img")
	private WebElement admin;
	
	@FindBy(xpath="//label[@for='remember']")
	private WebElement rememberMeLabel;
	
	
	
	public String getTextOfSignInButton() {
		return gu.getElementText(signInButton);		
	}
	
	public boolean isRemembermeSelected() {
		return gu.isCheckboxSelected(rememberMe);
	}
	
	public void enterUsername(String user) {
		gu.enterTextInElement(username, user);
	}
	
	public void enterPassword(String pass) {
		gu.enterTextInElement(password, pass);
	}
	
	public void clickSignIn() {
		gu.clickAButton(signInButton);
	}
	
	public String URLAfterSignIn() {
		return gu.getURLOfCurrentPage(driver);
	}
	
	public boolean getErrorMessage(String text) {
		return gu.getExpectedResultAlert(error, text);
	}
	
	public String textOfTitle() {
		return gu.getElementText(title);
	}
	
	public String getSignInBackgroundColor() {
		return gu.getBackgroundColor(signInButton,"background-color");
	}
	
	public boolean isAdminDisplayed() {
		return gu.checkIfElementIsDisplayed(admin);
	}
	
	public boolean isUsernameEnabled() {
		return gu.checkIfElementIsEnabled(username);
	}
	
	public String getTextOfRememberMeLabel() {
		return gu.getElementText(rememberMeLabel);
	}
	
	
}
