package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class MobileSliderPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public MobileSliderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Mobileslider/add']")
	private WebElement newButton;
	
	@FindBy(id="main_img")
	private WebElement chooseFile;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement save;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	private WebElement image;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[3]//a[2]")
	private WebElement delete;
	
	public void clickNew() {
		newButton.click();
	}
	
	public void uploadImage(String location) throws AWTException {
		gu.fileUpload(driver, chooseFile, System.getProperty("user.dir") + location);
	}
	
	public void clickSave() {
		save.click();
	}
	
	public boolean getAlertText(String text) {
		return gu.getExpectedResultAlert(alert, text);
	}
	
	public boolean presenceOfImage() {
		return image.isDisplayed();
	}
	
	public void clickDelete() {
		delete.click();
	}
	
	public String getTextOfDeleteAlert() {
		return gu.getTextOfAlert(driver);
	}

}
