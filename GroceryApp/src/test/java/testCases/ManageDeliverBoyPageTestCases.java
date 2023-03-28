package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constantPackage.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoyPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class ManageDeliverBoyPageTestCases extends BaseClass {
	
	LoginPage lp;
	DashboardPage dp;
	ManageDeliveryBoyPage md;
	ExcelRead er=new ExcelRead();
	
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyTheUsernameOfADeliveryBoy() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageDeliveryBoy();
	  md=new ManageDeliveryBoyPage(driver);
	  String actualResult=md.getTextOfUsername(Constant.DELIVERYBOYNAME);
	  String expectedResult;
	try {
		expectedResult = er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 25, 1);
		Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 26, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  
  }
  
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyTheFunctionalityOfResetButton() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageDeliveryBoy();
	  md=new ManageDeliveryBoyPage(driver);
	  md.clickSearch();
	  md.enterUsername(Constant.DELIVERYBOYNAME);
	  md.clickReset();
	  boolean actualResult=md.presenceOfUsername();
	  boolean expectedResult=false;
	  try {
		Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 27, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }
  
  
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyTheStatusOfDeliveryBoy() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageDeliveryBoy();
	  md=new ManageDeliveryBoyPage(driver);
	  String actualResult=md.getStatus(Constant.DELIVERYBOYNAME);
	  try {
	  String expectedResult=er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 28, 1);
		Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 26, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }
  
}
