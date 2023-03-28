package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constantPackage.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;
import utilities.ExtentReportUtils;
import utilities.RetryUtils;

public class DashboardPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	ExcelRead er=new ExcelRead();
	
  @Test(groups="Sanity", retryAnalyzer = RetryUtils.class)
  public void verifyFunctionalityOfLogoutButton() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickAdmin();
	  dp.clickLogout();
	  String actualResult=lp.URLAfterSignIn();
	  String expectedResult=prop.getProperty("BaseURL");
	  try {
		Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 5, 1));
	
	  String actualResult1=lp.textOfTitle();
	  String expectedResult1=er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 6, 1);
	  Assert.assertEquals(actualResult1, expectedResult1, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 5, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
		}
  }
  
  @Test(groups="Regression", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsAbleToAccessExpenseCategoryPage() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageExpense();
	  dp.clickExpenseCategory();
	  String actualResult=lp.URLAfterSignIn();
	  String expectedResult=prop.getProperty("ExpenseCategoryURL");
	  try {
		Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 5, 1));
	  String actualResult1=dp.getTitleOfExpCategory();
	  String expectedResult1=er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 7, 1);
	  Assert.assertEquals(actualResult1, expectedResult1, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 5, 1));
	  } catch (IOException e) {
		  System.out.println("Exception handled " + e);
		}
  }
  
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsAbleToNavigateToManageDeliveryBoyPage() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageDeliveryBoy();
	  String actualResult=lp.URLAfterSignIn();
	  String expectedResult=prop.getProperty("ManageDeliveryBoyURL");
	  try {
		Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 5, 1));
	  String actualResult1=dp.getManageDeliveryBoyTitle();
	  String expectedResult1=er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 8, 1);
	  Assert.assertEquals(actualResult1, expectedResult1, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 5, 1));
	  } catch (IOException e) {
		  System.out.println("Exception handled " + e);
		}
  }
  
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsAbleToNavigateToMobileSliderPage()  {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickMobileSlider();
	  String actualResult=lp.URLAfterSignIn();
	  String expectedResult=prop.getProperty("MobileSliderURL");
	  try {
		Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 5, 1));
	  String actualResult1=dp.getMobileSliderTitle();
	  String expectedResult1=er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 9, 1);
	  Assert.assertEquals(actualResult1, expectedResult1, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 5, 1));
	  } catch (IOException e) {
		  System.out.println("Exception handled " + e);
		}
  }
}
