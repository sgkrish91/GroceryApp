package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constantPackage.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.PushNotificationsPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class PushNotificationsPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	PushNotificationsPage pn;
	ExcelRead er=new ExcelRead();
	
  @Test(groups="Regression", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsAbleToSendPushNotifications() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickPushNotification();
	  pn=new PushNotificationsPage(driver);
	  pn.enterTitle();
	  pn.enterDescription();
	  pn.clickSend();
	  try {
	  boolean actualResult=pn.getAlertText(er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 35, 1));
	  Assert.assertTrue(actualResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 3, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }
  
  @Test(groups="Sanity", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsAbleToClearTheDataEnteredInTitleTextboxWhileClickingResetButton() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickPushNotification();
	  pn=new PushNotificationsPage(driver);
	  pn.enterTitle();
	  pn.clickReset();
	  String actualResult=pn.getTextOfTitle();
	  try {
	  String expectedResult=Constant.EMPTYSTRING;
		Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 27, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }
}
