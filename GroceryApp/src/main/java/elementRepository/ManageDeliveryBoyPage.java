package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageDeliveryBoyPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[4]")
	private List<WebElement> listDeliveryBoy;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	private WebElement search;
	
	@FindBy(id="un")
	private WebElement username;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'])[2]")
	private WebElement reset;
	
	public String getTextOfUsername(String name) {
		int index=gu.getTableLocatorValue(listDeliveryBoy, name);
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[5]";
		WebElement username=driver.findElement(By.xpath(locator));
		return gu.getElementText(username);
	}
	
	public void clickSearch() {
		search.click();
	}
	
	public void enterUsername(String name) {
		username.sendKeys(name);
	}
	
	public void clickReset() {
		reset.click();
	}
	
	public boolean presenceOfUsername() {
		return username.isDisplayed();
	}
	
	public String getStatus(String name) {
		int index=gu.getTableLocatorValue(listDeliveryBoy, name);
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[6]";
		WebElement status=driver.findElement(By.xpath(locator));
		return gu.getElementText(status);
	}

}
