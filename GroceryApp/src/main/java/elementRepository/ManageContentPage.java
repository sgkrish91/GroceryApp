package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageContentPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExplicitWait ew=new ExplicitWait();
	
	public ManageContentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]")
	private List<WebElement> listPagesTable;
	
	@FindBy(id="page")
	private WebElement page;
	
	@FindBy(xpath="//div[@class='card-footer']//button")
	private WebElement update;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	
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
		ew.elementToBeClickableExplicitWait(driver, update);
		Actions actions=new Actions(driver);
		actions.moveToElement(update).click().build().perform();
		//update.click();
	}
	
	public boolean getTextOfAlert(String text) {
		return gu.getExpectedResultAlert(alert, text);
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
