package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageLocationPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public ManageLocationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private List<WebElement> state;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[4]")
	private WebElement deliveryCharge;
	
	public String verifyingDeliveryCharge() {
		int index=0;
		String locator=null;
		index=gu.getTableLocatorValue(state, "Trivandrum");
		locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[4]";
		WebElement deliveryCharge=driver.findElement(By.xpath(locator));
		return deliveryCharge.getText();
	}
	

}
