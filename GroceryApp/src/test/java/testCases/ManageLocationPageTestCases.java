package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constantPackage.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageLocationPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class ManageLocationPageTestCases extends BaseClass {
	
	LoginPage lp;
	DashboardPage dp;
	ManageLocationPage ml;
	ExcelRead er=new ExcelRead();
	
  @Test(groups="Sanity", retryAnalyzer = RetryUtils.class)
  public void verifyTheDeliveryChargeOfLocationTrivandrum() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageLocation();
	  ml=new ManageLocationPage(driver);
	  boolean actualResult=ml.verifyingDeliveryCharge();
	  try {
		Assert.assertTrue(actualResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 30, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }
}
