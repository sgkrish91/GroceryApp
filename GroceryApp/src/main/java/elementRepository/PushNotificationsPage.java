package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class PushNotificationsPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public PushNotificationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="title")
	private WebElement title;
	
	@FindBy(id="description")
	private WebElement description;
	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
	private WebElement send;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications'])[2]")
	private WebElement reset;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	
	public void enterTitle() {
		gu.enterTextInElement(title, "Hello");
	}
	
	public void enterDescription() {
		gu.enterTextInElement(description, "Stocks are updated");
	}
	
	public void clickSend() {
		gu.clickAButton(send);
	}
	
	public void clickReset() {
		gu.clickAButton(reset);
	}
	
	public boolean getAlertText(String text) {
		return gu.getExpectedResultAlert(alert, text);
	}
	
	public String getTextOfTitle() {
		return gu.getElementText(title);
	}

}
