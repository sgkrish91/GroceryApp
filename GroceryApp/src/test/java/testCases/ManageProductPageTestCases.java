package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;

public class ManageProductPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	ManageProductPage mp;
	
  @Test
  public void verifyWhetherProductsListedAreMatchingTheSearchCriteriaCategoryAndSubcategory() {
	  
	  lp=new LoginPage(driver);
	  lp.enterUsername(Constant.LOGINUSER);
	  lp.enterPassword(Constant.LOGINPASSWORD);
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageProduct();
	  mp=new ManageProductPage(driver);
	  mp.clickSearch();
	  mp.selectCategory();
	  mp.selectSubCategory();
	  mp.clickSearchInList();
	  boolean actualResult=mp.verifyCategoryInTable();
	  //boolean expectedResult=true;
	  Assert.assertTrue(actualResult, Constant.LISTPRODUCTCATEGORYERROR);
	  
  }
  
  
}
