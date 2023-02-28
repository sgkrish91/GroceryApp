package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageFooterPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public ManageFooterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[4]")
	List<WebElement> footerTable;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'])[2]")
	WebElement reset;
	
	@FindBy(xpath="(//div[@class='col-sm-6'])[1]")
	WebElement title;
	
	public void clickEdit() {
		int index=0;
		String locator=null;
		index=gu.getTableLocatorValue(footerTable, "varkala");
		locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(index+1)+"]//td[4]";
		WebElement edit=driver.findElement(By.xpath(locator));
		edit.click();
	}
	
	public void clickReset() {
		reset.click();
	}
	
	public String getURLOfPage() {
		return gu.getURLOfCurrentPage(driver);
	}
	
	public String getTextOfTitle() {
		return gu.getElementText(title);
	}

}
