package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.PushNotificationsPage;
import utilities.ExcelRead;

public class PushNotificationsPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	PushNotificationsPage pn;
	
  @Test
  public void verifyWhetherUserIsAbleToSendPushNotifications() throws IOException {
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
	  lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickPushNotification();
	  pn=new PushNotificationsPage(driver);
	  pn.enterTitle();
	  pn.enterDescription();
	  pn.clickSend();
	  String actualResult=pn.getAlertText();
	  String expectedResult="×\n"
	  		+ "Alert!\n"
	  		+ "Message send successfully";
	  Assert.assertEquals(actualResult, expectedResult, Constant.ALERTERROR);
  }
  
  @Test
  public void verifyWhetherUserIsAbleToClearTheDataEnteredInTitleTextboxWhileClickingResetButton() throws IOException {
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
	  lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickPushNotification();
	  pn=new PushNotificationsPage(driver);
	  pn.enterTitle();
	  pn.clickReset();
	  String actualResult=pn.getTextOfTitle();
	  String expectedResult="";
	  Assert.assertEquals(actualResult, expectedResult, Constant.EXPECTEDTEXTERROR);
  }
}
