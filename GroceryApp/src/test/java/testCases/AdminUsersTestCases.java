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

public class AdminUsersTestCases extends BaseClass {

	LoginPage lp;
	DashboardPage dp;
	AdminUsersPage au;

	@Test
	public void verifyWhetherAdminUsersTableListsUsersAccordingToSearchCriteria() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 0));
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

	@Test
	public void verifyTheStatusOfUser() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.LOGINUSER);
		lp.enterPassword(Constant.LOGINPASSWORD);
		lp.clickSignIn();
		dp = new DashboardPage(driver);
		dp.clickAdminUsers();
		au = new AdminUsersPage(driver);
		String actualResult = au.getLocator();
		String expectedResult = AdminUsersConstant.STATUSACTIVE;
		Assert.assertEquals(actualResult, expectedResult, Constant.TABLESEARCHERROR);

	}

	@Test
	public void verifyWhetherStatusOfAUserCanBeChanged() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.LOGINUSER);
		lp.enterPassword(Constant.LOGINPASSWORD);
		lp.clickSignIn();
		dp = new DashboardPage(driver);
		dp.clickAdminUsers();
		au = new AdminUsersPage(driver);
		au.getLocatorForStatusChange();
		String actualResult = au.getTextOfAlert();
		String expectedResult = AdminUsersConstant.ALERTEXPECTEDRESULT;
		Assert.assertEquals(actualResult, expectedResult, Constant.ALERTERROR);
	}
	
	@Test
	public void verifyAlertMessageWhenNewUserIsAdded() {
		lp = new LoginPage(driver);
		lp.enterUsername(Constant.LOGINUSER);
		lp.enterPassword(Constant.LOGINPASSWORD);
		lp.clickSignIn();
		dp = new DashboardPage(driver);
		dp.clickAdminUsers();
		au = new AdminUsersPage(driver);
		au.clickNew();
		au.enterUsername(AdminUsersConstant.RANDOMUSER);
		au.enterPassword(AdminUsersConstant.RANDOMPASS);
		au.selectUser();
		au.clickSave();
		String actualResult=au.getAlertText();
		String expectedResult=AdminUsersConstant.ALERTNEWUSERADDED;
		Assert.assertEquals(actualResult, expectedResult, Constant.ALERTERROR);
	}

}
