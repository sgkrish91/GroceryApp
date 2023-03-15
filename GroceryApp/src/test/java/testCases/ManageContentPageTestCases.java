package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageContentPage;
import utilities.ExcelRead;

public class ManageContentPageTestCases extends BaseClass {
	
	LoginPage lp;
	DashboardPage dp;
	ManageContentPage mc;
	
  @Test
  public void verifyWhetherUserIsAbleToEditPageDetailsOfExistingTitle() throws IOException {
	  testBasic();
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageContent();
	  dp.clickManagePages();
	  mc=new ManageContentPage(driver);
	  mc.clickEditInTable();
	  mc.editPageDetails();
	  mc.clickUpdate();
	  boolean actualResult=mc.getTextOfAlert(Constant.MANAGECONTENTPAGEEDITALERT);
	  Assert.assertTrue(actualResult, Constant.ALERTERROR);
	  String actualResult1=mc.verifyUpdatedValue();
	  String expectedResult1="NewPage150";
	  Assert.assertEquals(actualResult1, expectedResult1, Constant.UPDATEDATAERROR);
  }
}
