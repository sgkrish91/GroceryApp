package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageContentPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class ManageContentPageTestCases extends BaseClass {
	
	LoginPage lp;
	DashboardPage dp;
	ManageContentPage mc;
	ExcelRead er=new ExcelRead();
	
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsAbleToEditPageDetailsOfExistingTitle() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageContent();
	  dp.clickManagePages();
	  mc=new ManageContentPage(driver);
	  mc.clickEditInTable();
	  mc.editPageDetails();
	  mc.clickUpdate();
	  try {
	  boolean actualResult=mc.getTextOfAlert(er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 23, 1));
		Assert.assertTrue(actualResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 3, 1));
	  String actualResult1=mc.verifyUpdatedValue();
	  String expectedResult1="NewPage150";
	  Assert.assertEquals(actualResult1, expectedResult1, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 24, 1));
	  } catch (IOException e) {
			System.out.println("Exception handled " + e);
		}
  }
}
