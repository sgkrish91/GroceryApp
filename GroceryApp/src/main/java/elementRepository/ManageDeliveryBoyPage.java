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
	List<WebElement> listDeliveryBoy;
	
	public String getTextOfUsername() {
		int index=gu.getTableLocatorValue(listDeliveryBoy, "Trudie");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+4)+"]//td[5]";
		WebElement username=driver.findElement(By.xpath(locator));
		return gu.getElementText(username);
	}

}
