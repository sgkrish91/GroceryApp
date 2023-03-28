package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constantPackage.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageCategoryPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class ManageCategoryPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	ManageCategoryPage mc;
	ExcelRead er=new ExcelRead();
	
  @Test(groups="Functional")
  public void verifyWhetherUserIsAbleToAddNewCategoryInManageCategoryPage() {
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
	  try {
		mc.uploadImage(prop.getProperty("ImageUpload"));
	} catch (AWTException e) {
		System.out.println("Exception handled " + e);
	}
	  mc.clickSaveButton();
	  boolean actualResult;
	try {
		actualResult = mc.getAlertText(er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 20, 1));
		Assert.assertTrue(actualResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 21, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	} 
  }
  
  @Test(groups="Functional")
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
	  try {
	  String expectedResult=er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 22, 1);
		Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 3, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  
  }
}
