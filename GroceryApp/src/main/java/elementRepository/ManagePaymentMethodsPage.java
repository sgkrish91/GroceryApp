package elementRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;

public class ManagePaymentMethodsPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public ManagePaymentMethodsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private List<WebElement> action;
	
	@FindBy(xpath="//input[@id='limit']")
	private WebElement limit;
	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
	private WebElement update;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	
	public void clickEditButton() {
		int index=gu.getTableLocatorValue(action, "UPI");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[4]//a";
		WebElement edit=driver.findElement(By.xpath(locator));
		gu.clickAButton(edit);
	}
	
	public void enterLimitValue() {
		WebDriverWait obj=new WebDriverWait(driver, Duration.ofMillis(5000));		
		obj.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='limit']")));
		gu.clearTextFieldAndEnterNewData(limit, "20000");
	}
	
	public void clickUpdate() {
		gu.clickAButton(update);
	}
	
	public boolean getAlertText(String text) {
		return gu.getExpectedResultAlert(alert, text);
	}
	
	public String checkUpdatedLimitValue() {
		int index=gu.getTableLocatorValue(action, "UPI");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[2]";
		WebElement updatedLimit=driver.findElement(By.xpath(locator));
		return gu.getElementText(updatedLimit);
	}

}
