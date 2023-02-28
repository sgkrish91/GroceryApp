package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class DashboardPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	
  @Test
  public void verifyFunctionalityOfLogoutButton() throws IOException {
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
	  lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickAdmin();
	  dp.clickLogout();
	  String actualResult=lp.URLAfterSignIn();
	  String expectedResult="https://groceryapp.uniqassosiates.com/admin/login";
	  Assert.assertEquals(actualResult, expectedResult, Constant.PAGELOADERROR);
	  String actualResult1=lp.textOfTitle();
	  String expectedResult1="7rmart supermarket";
	  Assert.assertEquals(actualResult1, expectedResult1, Constant.PAGELOADERROR);
  }
  
  @Test
  public void verifyWhetherUserIsAbleToAccessExpenseCategoryPage() throws IOException {
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
	  lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageExpense();
	  dp.clickExpenseCategory();
	  String actualResult=lp.URLAfterSignIn();
	  String expectedResult="https://groceryapp.uniqassosiates.com/admin/expense-category";
	  Assert.assertEquals(actualResult, expectedResult, Constant.PAGELOADERROR);
	  String actualResult1=dp.getTitleOfExpCategory();
	  String expectedResult1="Expense Category";
	  Assert.assertEquals(actualResult1, expectedResult1, Constant.PAGELOADERROR);
  }
}
