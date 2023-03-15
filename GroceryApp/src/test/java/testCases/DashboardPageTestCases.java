package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;
import utilities.ExtentReportUtils;

public class DashboardPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	
  @Test(groups = "Sanity")
  public void verifyFunctionalityOfLogoutButton() throws IOException {
	  testBasic();
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickAdmin();
	  dp.clickLogout();
	  String actualResult=lp.URLAfterSignIn();
	  String expectedResult=prop.getProperty("BaseURL");
	  Assert.assertEquals(actualResult, expectedResult, Constant.PAGELOADERROR);
	  String actualResult1=lp.textOfTitle();
	  String expectedResult1=Constant.LOGINTITLETEXT;
	  Assert.assertEquals(actualResult1, expectedResult1, Constant.PAGELOADERROR);
  }
  
  @Test(groups="Regression")
  public void verifyWhetherUserIsAbleToAccessExpenseCategoryPage() throws IOException {
	  testBasic();
	  
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageExpense();
	  dp.clickExpenseCategory();
	  String actualResult=lp.URLAfterSignIn();
	  String expectedResult=prop.getProperty("ExpenseCategoryURL");
	  Assert.assertEquals(actualResult, expectedResult, Constant.PAGELOADERROR);
	  String actualResult1=dp.getTitleOfExpCategory();
	  String expectedResult1=Constant.EXPENSECATTITLE;
	  Assert.assertEquals(actualResult1, expectedResult1, Constant.PAGELOADERROR);
  }
}
