package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageFooterPage;
import utilities.ExcelRead;

public class ManageFooterPageTestCases extends BaseClass{
	
	LoginPage lp;
	DashboardPage dp;
	ManageFooterPage mf;
	
  @Test
  public void verifyTheFunctionalityOfResetButtonWhileEditingFooterText() throws IOException {
	  testBasic();
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageContent();
	  dp.clickManageFooter();
	  mf=new ManageFooterPage(driver);
	  mf.clickEdit();
	  mf.clickReset();
	  String actualResult=mf.getURLOfPage();
	  String expectedResult=prop.getProperty("FooterPageURL");
	  Assert.assertEquals(actualResult, expectedResult, Constant.PAGELOADERROR);
	  String actualResult1=mf.getTextOfTitle();
	  String expectedResult1=Constant.FOOTERPAGETITLE;
	  Assert.assertEquals(actualResult1, expectedResult1, Constant.PAGELOADERROR);
  }
}
