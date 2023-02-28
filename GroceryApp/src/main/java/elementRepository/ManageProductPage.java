package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;
import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageProductPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExplicitWait ew=new ExplicitWait();
	
	public ManageProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	
	@FindBy(xpath="//input[@placeholder='Title']")
	WebElement title;
	
	@FindBy(xpath="//select[@id='cat_id']")
	WebElement category;
	
	@FindBy(id="sb")
	WebElement subCategory;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchList;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[3]")
	List<WebElement> tableCategory;
	
	public void clickSearch() {
		search.click();
	}
	
	public void selectCategory() {
		gu.selectValueFromDropDown(category, "3");
	}
	
	public void selectSubCategory() {
		//explicit wait
		ew.stalenessExplicitWait(driver, subCategory);
		gu.selectValueFromDropDown(subCategory, "18");
	}
	
	public void clickSearchInList() {
		searchList.click();
	}
	
	public boolean verifyCategoryInTable() {
		return gu.getTableColumnValue(tableCategory, "Grocery & Staples >> Oil");
		
	}
	
	

}
