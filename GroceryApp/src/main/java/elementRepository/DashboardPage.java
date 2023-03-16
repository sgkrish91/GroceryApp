package elementRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class DashboardPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExplicitWait ew=new ExplicitWait();
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	private WebElement admin;
	
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")
	private WebElement logout;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
	private WebElement manageExpense;
	
	@FindBy(xpath="//ul[@class='nav nav-treeview']//li//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	private WebElement expCategory;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	private WebElement expCategoryTitle;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-tasks']")
	private WebElement manageProduct;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-users']")
	private WebElement adminUsers;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-edit']")
	private WebElement manageContent;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-list-alt']")
	private WebElement manageCategory;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i")
	private WebElement category;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']//i")
	private WebElement subCategory;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-credit-card']")
	private WebElement managePaymentMethod;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider'])[1]")
	private WebElement mobileSlider;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location'])[1]")
	private WebElement manageLocation;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page'])[1]")
	private WebElement managePages;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")
	private WebElement manageFooter;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications']")
	private WebElement pushNot;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'])[1]")
	private WebElement manageDeliveryBoy;
	
	public void clickAdmin() {
		ew.presenceOfElementExplicitWait(driver, "//a[@data-toggle='dropdown']");
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
	
	public void clickManagePages() {
		managePages.click();
	}
	
	public void clickManageFooter() {
		JavascriptExecutor js = (JavascriptExecutor) driver;		//We use the Javascript interface to perform actions.
		js.executeScript("window.scrollBy(0,3000)");
		js.executeScript("arguments[0].click();", manageFooter);
		//manageFooter.click();
	}
	
	public void clickPushNotification() {
		pushNot.click();
	}
	
	public void clickManageDeliveryBoy() {
		manageDeliveryBoy.click();
	}

}
