package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageCategoryPage;
import utilities.RetryUtils;

public class ManageCategoryPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	ManageCategoryPage mc;
	
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsAbleToAddNewCategoryInManageCategoryPage() throws AWTException, IOException {
	  testBasic();
	  lp=new LoginPage(driver);
	  lp.enterUsername(Constant.LOGINUSER);
	  lp.enterPassword(Constant.LOGINPASSWORD);
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageCategory();
	  dp.clickSubCategory();
	  mc=new ManageCategoryPage(driver);
	  mc.clickNewButton();
	  mc.selectCategoryName();
	  mc.enterSubCategoryName();
	  mc.uploadImage(prop.getProperty("ImageUpload"));
	  mc.clickSaveButton();
	  boolean actualResult=mc.getAlertText(Constant.NEWCATEGORYALERT);
	  Assert.assertTrue(actualResult, Constant.SUBCATEGORYUPDATEERROR);
	 
  }
  
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyTheTextOfAlertWhileClickingDeleteButtonInSubCategoryTable() {
	  
	  lp=new LoginPage(driver);
	  lp.enterUsername(Constant.LOGINUSER);
	  lp.enterPassword(Constant.LOGINPASSWORD);
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageCategory();
	  dp.clickSubCategory();
	  mc=new ManageCategoryPage(driver);
	  mc.getLocatorToDelete();
	  String actualResult=mc.getDeleteAlertText();
	  String expectedResult=Constant.DELETESUBCATALERT;
	  Assert.assertEquals(actualResult, expectedResult, Constant.ALERTERROR);
	  
  }
}
