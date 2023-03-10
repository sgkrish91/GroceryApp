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
		title.sendKeys("Hello");
	}
	
	public void enterDescription() {
		description.sendKeys("Stocks are updated");
	}
	
	public void clickSend() {
		send.click();
	}
	
	public void clickReset() {
		reset.click();
	}
	
	public String getAlertText() {
		return gu.getElementText(alert);
	}
	
	public String getTextOfTitle() {
		return gu.getElementText(title);
	}

}
//Test
