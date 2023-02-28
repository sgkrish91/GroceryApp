package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageContentPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public ManageContentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]")
	List<WebElement> listPagesTable;
	
	@FindBy(id="page")
	WebElement page;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement update;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	public void clickEditInTable() {
		int index=0;
		String locator=null;
		index=gu.getTableLocatorValue(listPagesTable, "SampleData");
		locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[5]//a[1]";
		WebElement edit=driver.findElement(By.xpath(locator));
		edit.click();
	}
	
	public void editPageDetails() {
		gu.clearTextFieldAndEnterNewData(page, "NewPage150");
	}
	
	public void clickUpdate() {
		update.click();
	}
	
	public String getTextOfAlert() {
		return gu.getElementText(alert);
	}
	
	public String verifyUpdatedValue() {
		int index=0;
		String locator=null;
		index=gu.getTableLocatorValue(listPagesTable, "SampleData");
		locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[4]";
		WebElement updatedPage=driver.findElement(By.xpath(locator));
		return updatedPage.getText();
	}

}
