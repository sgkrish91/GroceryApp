package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoyPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class ManageDeliverBoyPageTestCases extends BaseClass {
	
	LoginPage lp;
	DashboardPage dp;
	ManageDeliveryBoyPage md;
	
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyTheUsernameOfADeliveryBoy() throws IOException {
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageDeliveryBoy();
	  md=new ManageDeliveryBoyPage(driver);
	  String actualResult=md.getTextOfUsername(Constant.DELIVERYBOYNAME);
	  String expectedResult=Constant.DELIVERYBOYUSERNAME;
	  Assert.assertEquals(actualResult, expectedResult, Constant.EXPECTEDTEXTERROR);
  }
  
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyTheFunctionalityOfResetButton() throws IOException {
	  testBasic();
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageDeliveryBoy();
	  md=new ManageDeliveryBoyPage(driver);
	  md.clickSearch();
	  md.enterUsername(Constant.DELIVERYBOYNAME);
	  md.clickReset();
	  boolean actualResult=md.presenceOfUsername();
	  boolean expectedResult=false;
	  Assert.assertEquals(actualResult, expectedResult, Constant.ELEMENTPRESENCEERROR);
  }
  
  
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyTheStatusOfDeliveryBoy() throws IOException {
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageDeliveryBoy();
	  md=new ManageDeliveryBoyPage(driver);
	  String actualResult=md.getStatus(Constant.DELIVERYBOYNAME);
	  String expectedResult=Constant.STATUSINACTIVE;
	  Assert.assertEquals(actualResult, expectedResult, Constant.EXPECTEDTEXTERROR);
  }
  
}
