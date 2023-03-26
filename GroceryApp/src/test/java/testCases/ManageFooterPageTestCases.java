package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageFooterPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class ManageFooterPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	ManageFooterPage mf;
	ExcelRead er=new ExcelRead();
	
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyTheFunctionalityOfResetButtonWhileEditingFooterText() {
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
	  dp.clickManageFooter();
	  mf=new ManageFooterPage(driver);
	  mf.clickEdit();
	  mf.clickReset();
	  String actualResult=mf.getURLOfPage();
	  String expectedResult=prop.getProperty("FooterPageURL");
	  try {
		Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 5, 1));
	  String actualResult1=mf.getTextOfTitle();
	  String expectedResult1=er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 29, 1);
	  Assert.assertEquals(actualResult1, expectedResult1, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 5, 1));
	  } catch (IOException e) {
		  System.out.println("Exception handled " + e);
		}
  }
}
