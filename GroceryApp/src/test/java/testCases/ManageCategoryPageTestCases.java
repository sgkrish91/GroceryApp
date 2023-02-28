package testCases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageCategoryPage;

public class ManageCategoryPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	ManageCategoryPage mc;
	
  @Test
  public void verifyWhetherUserIsAbleToAddNewCategoryInManageCategoryPage() throws AWTException {
	  
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
	  mc.uploadImage();
	  mc.clickSaveButton();
	  String actualResult=mc.getAlertText();
	  String expectedResult="�\n"
	  		+ "Alert!\n"
	  		+ "Sub Category Created Successfully";
	  Assert.assertEquals(actualResult, expectedResult, Constant.SUBCATEGORYUPDATEERROR);
	 
  }
  
  @Test
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
	  String expectedResult="Do you want to delete this Sub Category?";
	  Assert.assertEquals(actualResult, expectedResult, Constant.ALERTERROR);
	  
  }
}
