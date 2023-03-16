package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageLocationPage;
import utilities.ExcelRead;

public class ManageLocationPageTestCases extends BaseClass {
	
	LoginPage lp;
	DashboardPage dp;
	ManageLocationPage ml;
	
  @Test
  public void verifyTheDeliveryChargeOfLocationTrivandrum() throws IOException {
	  testBasic();
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageLocation();
	  ml=new ManageLocationPage(driver);
	  boolean actualResult=ml.verifyingDeliveryCharge();
	  Assert.assertTrue(actualResult, Constant.ERRORINDELIVERYCHARGE);
  }
}
