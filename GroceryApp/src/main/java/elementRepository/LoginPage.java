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
import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class LoginPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExplicitWait ew=new ExplicitWait();
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement signInButton;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement rememberMe;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement error;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/login']")
	WebElement title;
	
	@FindBy(xpath="//a[@class='nav-link']//img")
	WebElement admin;
	
	
	
	public String getTextOfSignInButton() {
		return gu.getElementText(signInButton);		//We have defined the functionality of getting the text of Sign in button in GeneralUtilities.
	}
	
	public boolean isRemembermeSelected() {
		return gu.isCheckboxSelected(rememberMe);
	}
	
	public void enterUsername(String user) {
		username.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickSignIn() {
		signInButton.click();
	}
	
	public String URLAfterSignIn() {
		return gu.getURLOfCurrentPage(driver);
	}
	
	public String getErrorMessage() {
		return gu.getElementText(error);
	}
	
	public String textOfTitle() {
		return gu.getElementText(title);
	}
	
	public String getSignInBackgroundColor() {
		return gu.getBackgroundColor(signInButton,"background-color");
	}
	
	public boolean isAdminDisplayed() {
		return admin.isDisplayed();
	}
	
	public boolean isUsernameSelected() {
		return username.isSelected();
	}
	
}
