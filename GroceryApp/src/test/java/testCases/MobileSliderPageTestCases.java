package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.MobileSliderPage;
import utilities.ExcelRead;
import utilities.RetryUtils;

public class MobileSliderPageTestCases extends BaseClass {
	
	LoginPage lp;
	DashboardPage dp;
	MobileSliderPage ms;
	
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsAbleToAddNewImage() throws IOException, AWTException {
	  testBasic();
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickMobileSlider();
	  ms=new MobileSliderPage(driver);
	  ms.clickNew();
	  ms.uploadImage(Constant.UPLOADIMAGE);
	  ms.clickSave();
	  boolean actualResult=ms.getAlertText(Constant.MOBILESLIDERALERT);
	  Assert.assertTrue(actualResult, Constant.ALERTERROR);
	  dp.clickMobileSlider();
	  boolean actualResult1=ms.presenceOfImage();
	  Assert.assertTrue(actualResult1, Constant.ELEMENTPRESENCEERROR);
	  
  }
  
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyTheAlertTextWhileClickingDeleteButtonInMobileSliderPage() throws IOException {
	  testBasic();
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickMobileSlider();
	  ms=new MobileSliderPage(driver);
	  ms.clickDelete();
	  String actualResult=ms.getTextOfDeleteAlert();
	  String expectedResult=Constant.MOBILESLIDERDELETEALERT;
	  Assert.assertEquals(actualResult, expectedResult, Constant.ALERTERROR);
  }
}
