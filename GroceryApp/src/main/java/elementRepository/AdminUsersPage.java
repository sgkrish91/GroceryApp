package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;
import utilities.GeneralUtilities;

public class AdminUsersPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class=' fa fa-search']")
	WebElement search;
	
	@FindBy(xpath="//select[@id='ut']")
	WebElement userType;
	
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchList;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]")
	List<WebElement> adminUsersTable;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> status;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	public void clickSearch() {
		search.click();
	}
	
	public void selectUserType() {
		gu.selectValueFromDropDown(userType, "staff");
	}
	
	public void clickSearchInList() {
		searchList.click();
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
		statusDetails.click();
	}
	
	public String getTextOfAlert() {
		return gu.getElementText(alert);
		
	}
	

}
