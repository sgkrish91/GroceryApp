package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManagePaymentMethodsPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class ManagePaymentMethodsTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	ManagePaymentMethodsPage mp;
	
  @Test(groups="Sanity", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsAbleToIncreaseTheLimitOfUPIPayment() throws IOException {
	  testBasic();
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManagePaymentMethod();
	  mp=new ManagePaymentMethodsPage(driver);
	  mp.clickEditButton();
	  mp.enterLimitValue();
	  mp.clickUpdate();
	  boolean actualResult=mp.getAlertText(Constant.PAYMENTLIMITUPDATEALERT);
	  Assert.assertTrue(actualResult, Constant.ALERTERROR);
	  String actualResult1=mp.checkUpdatedLimitValue();
	  String expectedResult1="20000";
	  Assert.assertEquals(actualResult1, expectedResult1, Constant.ALERTERROR);
	  
  }
}
