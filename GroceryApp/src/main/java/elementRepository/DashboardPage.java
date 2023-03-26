package elementRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;
import utilities.GeneralUtilities;

public class DashboardPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtility ew=new WaitUtility();
	
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
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	private WebElement manageDeliveryBoyTitle;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	private WebElement mobileSliderTitle;
	
	public void clickAdmin() {
		ew.presenceOfElementExplicitWait(driver, "//a[@data-toggle='dropdown']");
		gu.clickAButton(admin);
	}
	
	public void clickLogout() {
		gu.clickAButton(logout);
	}
	
	public void clickManageExpense() {
		gu.clickAButton(manageExpense);
	}
	
	public void clickExpenseCategory() {
		gu.clickAButton(expCategory);
	}
	
	public String getTitleOfExpCategory() {
		return gu.getElementText(expCategoryTitle);
	}
	
	public void clickManageProduct() {
		gu.clickAButton(manageProduct);
	}
	
	public void clickAdminUsers() {
		gu.clickAButton(adminUsers);
	}
	
	public void clickManageContent() {
		gu.clickAButton(manageContent);
	}
	
	public void clickManageCategory() {
		gu.clickAButton(manageCategory);
	}
	
	public void clickSubCategory() {
		gu.clickAButton(subCategory);
	}
	
	public void clickManagePaymentMethod() {
		gu.clickAButton(managePaymentMethod);
	}
	
	public void clickMobileSlider() {
		gu.clickAButton(mobileSlider);
	}
	
	public void clickManageLocation() {
		gu.clickAButton(manageLocation);
	}
	
	public void clickManagePages() {
		gu.clickAButton(managePages);
	}
	
	public void clickManageFooter() {
		gu.clickElementUsingJavascript(driver, manageFooter);
	}
	
	public void clickPushNotification() {
		gu.clickAButton(pushNot);
	}
	
	public void clickManageDeliveryBoy() {
		gu.clickAButton(manageDeliveryBoy);
	}
	
	public String getManageDeliveryBoyTitle() {
		return gu.getElementText(manageDeliveryBoyTitle);
	}
	
	public String getMobileSliderTitle() {
		return gu.getElementText(mobileSliderTitle);
	}

}
