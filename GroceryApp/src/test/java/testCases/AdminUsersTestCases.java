package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constantPackage.Constant;
import elementRepository.AdminUsersPage;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class AdminUsersTestCases extends BaseClass {

	LoginPage lp;
	DashboardPage dp;
	AdminUsersPage au;
	
	ExcelRead er=new ExcelRead();

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
		Assert.assertTrue(actualResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 1, 1));
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
		try {
		String expectedResult = er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 2, 1);
			Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 1, 1));
		} catch (IOException e) {
			System.out.println("Exception handled " + e);
		}
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
		boolean actualResult = au.getTextOfAlert(prop.getProperty("AlertExpectedResult"));
		try {
			Assert.assertTrue(actualResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 3, 1));
		} catch (IOException e) {
			System.out.println("Exception handled " + e);
		}
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
		au.enterUsername(faker.name().username());
		au.enterPassword(faker.internet().password());
		au.selectUser();
		au.clickSave();
		try {
		boolean actualResult=au.getAlertText(er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 4, 1));
	    Assert.assertTrue(actualResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 3, 1));
		} catch (IOException e) {
			System.out.println("Exception handled " + e);
		}
	}

}
