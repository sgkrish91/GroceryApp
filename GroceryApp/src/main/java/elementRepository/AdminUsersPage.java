package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;
import utilities.GeneralUtilities;
import utilities.RandomDataGenerator;

public class AdminUsersPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class=' fa fa-search']")
	private WebElement search;
	
	@FindBy(xpath="//select[@id='ut']")
	private WebElement userType;
	
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchList;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]")
	private List<WebElement> adminUsersTable;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private List<WebElement> status;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	
	@FindBy(id="user_type")
	private WebElement userTypeDrop;
	
	@FindBy(xpath="//button[@name='Create']")
	private WebElement saveButton;
	
	public void clickSearch() {
		gu.clickAButton(search);
	}
	
	public void selectUserType() {
		gu.selectValueFromDropDown(userType, "staff");
	}
	
	public void clickSearchInList() {
		gu.clickAButton(searchList);
	}
	
	public boolean verifyUserType() {
		return gu.getTableColumnValue(adminUsersTable, "staff");
	}
	
	public String getLocator() {
		int index=gu.getTableLocatorValue(status, "hari");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[3]//a//span";
		WebElement statusDetails = driver.findElement(By.xpath(locator));
		return gu.getElementText(statusDetails);
	}
	
	public void getLocatorForStatusChange() {
		int index=gu.getTableLocatorValue(status, "arun123");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[3]//a";
		WebElement statusDetails = driver.findElement(By.xpath(locator));
		gu.clickAButton(statusDetails);
	}
	
	public boolean getTextOfAlert(String text) {
		return gu.getExpectedResultAlert(alert, text);
		
	}
	
	public void enterUsername(String user) {
		gu.enterRandomUsername(username, user);
	}
	
	public void enterPassword(String pass) {
		gu.enterTextInElement(password, pass);
	}
	
	public void clickNew() {
		gu.clickAButton(newButton);
	}
	
	public void selectUser() {
		gu.selectValueFromDropDown(userTypeDrop, "admin");
	}
	
	public void clickSave() {
		gu.clickAButton(saveButton);
	}
	
	public boolean getAlertText(String text) {
		return gu.getExpectedResultAlert(alert, text);
	}

}
