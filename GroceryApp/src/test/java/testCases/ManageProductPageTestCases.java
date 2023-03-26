package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
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
import utilities.ExcelRead;
import utilities.RetryUtils;

public class ManageProductPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	ManageProductPage mp;
	ExcelRead er=new ExcelRead();
	
  @Test(groups="Functional")
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
	  try {
		Assert.assertTrue(actualResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 32, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  
  }
  
  
}
