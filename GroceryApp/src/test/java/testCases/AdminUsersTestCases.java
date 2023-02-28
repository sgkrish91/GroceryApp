package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 0));
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
		String locator = au.getLocator();
		WebElement statusDetails = driver.findElement(By.xpath(locator));
		String actualResult = statusDetails.getText();
		String expectedResult = "Active";
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
		String expectedResult = "×\n" + "Alert!\n" + "User Status Changed Successfully";
		Assert.assertEquals(actualResult, expectedResult, Constant.ALERTERROR);
	}

}
