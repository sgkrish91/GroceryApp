package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageCategoryPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	
	@FindBy(xpath="//select[@class='form-control selectpicker']")
	private WebElement selectCategory;
	
	@FindBy(id="subcategory")
	private WebElement subCategory;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement chooseFile;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr//td[1]")
	private List<WebElement> listSubCategory;
	
	public void clickNewButton() {
		newButton.click();
	}
	
	public void selectCategoryName() {
		gu.selectValueFromDropDown(selectCategory, "3");
	}
	
	public void enterSubCategoryName() {
		subCategory.sendKeys("GreenVegetables");
	}
	
	public void uploadImage(String text) throws AWTException {
		gu.fileUpload(driver, chooseFile, System.getProperty("user.dir")+ text);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public boolean getAlertText(String text) {
		return gu.getExpectedResultAlert(alert, text);
	}
	
	public void getLocatorToDelete() {
		int index=gu.getTableLocatorValue(listSubCategory, "abcd");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tr["+(index+1)+"]//td[5]//a[2]//i";
		WebElement deleteButton=driver.findElement(By.xpath(locator));
		deleteButton.click();
	}
	
	public String getDeleteAlertText() {
		return gu.getTextOfAlert(driver);
	}

}
