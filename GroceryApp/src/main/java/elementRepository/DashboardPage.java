package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashboardPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	WebElement admin;
	
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")
	WebElement logout;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement manageExpense;
	
	@FindBy(xpath="//ul[@class='nav nav-treeview']//li//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	WebElement expCategory;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	WebElement expCategoryTitle;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-tasks']")
	WebElement manageProduct;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-users']")
	WebElement adminUsers;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-edit']")
	WebElement manageContent;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-list-alt']")
	WebElement manageCategory;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i")
	WebElement category;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']//i")
	WebElement subCategory;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-credit-card']")
	WebElement managePaymentMethod;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider'])[1]")
	WebElement mobileSlider;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location'])[1]")
	WebElement manageLocation;
	
	public void clickAdmin() {
		admin.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	public void clickManageExpense() {
		manageExpense.click();
	}
	
	public void clickExpenseCategory() {
		expCategory.click();
	}
	
	public String getTitleOfExpCategory() {
		return gu.getElementText(expCategoryTitle);
	}
	
	public void clickManageProduct() {
		manageProduct.click();
	}
	
	public void clickAdminUsers() {
		adminUsers.click();
	}
	
	public void clickManageContent() {
		manageContent.click();
	}
	
	public void clickManageCategory() {
		manageCategory.click();
	}
	
	public void clickSubCategory() {
		subCategory.click();
	}
	
	public void clickManagePaymentMethod() {
		managePaymentMethod.click();
	}
	
	public void clickMobileSlider() {
		mobileSlider.click();
	}
	
	public void clickManageLocation() {
		manageLocation.click();
	}

}
