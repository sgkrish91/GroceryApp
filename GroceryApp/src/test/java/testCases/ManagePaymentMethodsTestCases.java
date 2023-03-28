package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constantPackage.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManagePaymentMethodsPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class ManagePaymentMethodsTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	ManagePaymentMethodsPage mp;
	ExcelRead er=new ExcelRead();
	
  @Test(groups="Sanity", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsAbleToIncreaseTheLimitOfUPIPayment() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManagePaymentMethod();
	  mp=new ManagePaymentMethodsPage(driver);
	  mp.clickEditButton();
	  mp.enterLimitValue();
	  mp.clickUpdate();
	  try {
	  boolean actualResult=mp.getAlertText(er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 31, 1));
	  Assert.assertTrue(actualResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 3, 1));
	  String actualResult1=mp.checkUpdatedLimitValue();
	  String expectedResult1="20000";
	  Assert.assertEquals(actualResult1, expectedResult1, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 3, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
		}
  }
}
