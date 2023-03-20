package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.AdminUsersConstant;
import constant.Constant;
import elementRepository.AdminUsersPage;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class AdminUsersTestCases extends BaseClass {

	LoginPage lp;
	DashboardPage dp;
	AdminUsersPage au;

	@Test(groups="Functional", retryAnalyzer = RetryUtils.class)
	public void verifyWhetherAdminUsersTableListsUsersAccordingToSearchCriteria() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), Constant.SHEETINEXCEL, 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), Constant.SHEETINEXCEL, 1, 0));
		lp.clickSignIn();
		dp = new DashboardPage(driver);
		dp.clickAdminUsers();
		au = new AdminUsersPage(driver);
		au.clickSearch();
		au.selectUserType();
		au.clickSearchInList();
		boolean actualResult = au.verifyUserType();
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult, Constant.TABLESEARCHERROR);

	}

	@Test(groups="Sanity", retryAnalyzer = RetryUtils.class)
	public void verifyTheStatusOfUser() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.LOGINUSER);
		lp.enterPassword(Constant.LOGINPASSWORD);
		lp.clickSignIn();
		dp = new DashboardPage(driver);
		dp.clickAdminUsers();
		au = new AdminUsersPage(driver);
		String actualResult = au.getLocator();
		String expectedResult = Constant.STATUSACTIVE;
		Assert.assertEquals(actualResult, expectedResult, Constant.TABLESEARCHERROR);

	}

	@Test(groups="Regression", retryAnalyzer = RetryUtils.class)
	public void verifyWhetherStatusOfAUserCanBeChanged() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.LOGINUSER);
		lp.enterPassword(Constant.LOGINPASSWORD);
		lp.clickSignIn();
		dp = new DashboardPage(driver);
		dp.clickAdminUsers();
		au = new AdminUsersPage(driver);
		au.getLocatorForStatusChange();
		boolean actualResult = au.getTextOfAlert(Constant.ALERTEXPECTEDRESULT);
		Assert.assertTrue(actualResult, Constant.ALERTERROR);
	}
	
	@Test(groups="Functional", retryAnalyzer = RetryUtils.class)
	public void verifyAlertMessageWhenNewUserIsAdded() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.LOGINUSER);
		lp.enterPassword(Constant.LOGINPASSWORD);
		lp.clickSignIn();
		dp = new DashboardPage(driver);
		dp.clickAdminUsers();
		au = new AdminUsersPage(driver);
		au.clickNew();
		au.enterUsername(Constant.RANDOMUSER);
		au.enterPassword(Constant.RANDOMPASS);
		au.selectUser();
		au.clickSave();
		boolean actualResult=au.getAlertText(Constant.ALERTNEWUSERADDED);
		Assert.assertTrue(actualResult, Constant.ALERTERROR);
	}

}
