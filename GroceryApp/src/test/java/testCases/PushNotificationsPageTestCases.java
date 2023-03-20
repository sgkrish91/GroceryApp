package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.PushNotificationsPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class PushNotificationsPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	PushNotificationsPage pn;
	
  @Test(groups="Regression", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsAbleToSendPushNotifications() throws IOException {
	  testBasic();
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickPushNotification();
	  pn=new PushNotificationsPage(driver);
	  pn.enterTitle();
	  pn.enterDescription();
	  pn.clickSend();
	  boolean actualResult=pn.getAlertText(Constant.PUSHNOTIFICATIONALERT);
	  Assert.assertTrue(actualResult, Constant.ALERTERROR);
  }
  
  @Test(groups="Sanity", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsAbleToClearTheDataEnteredInTitleTextboxWhileClickingResetButton() throws IOException {
	  testBasic();
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickPushNotification();
	  pn=new PushNotificationsPage(driver);
	  pn.enterTitle();
	  pn.clickReset();
	  String actualResult=pn.getTextOfTitle();
	  String expectedResult=Constant.EMPTYSTRING;
	  Assert.assertEquals(actualResult, expectedResult, Constant.EXPECTEDTEXTERROR);
  }
}
