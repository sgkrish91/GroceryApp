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

public class MobileSliderPageTestCases extends BaseClass {
	
	LoginPage lp;
	DashboardPage dp;
	MobileSliderPage ms;
	
  @Test
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
	  ms.uploadImage();
	  ms.clickSave();
	  String actualResult=ms.getAlertText();
	  String expectedResult=Constant.MOBILESLIDERALERT;
	  Assert.assertEquals(actualResult, expectedResult, Constant.ALERTERROR);
	  dp.clickMobileSlider();
	  boolean actualResult1=ms.presenceOfImage();
	  //boolean expectedResult1=true;
	  Assert.assertTrue(actualResult1, Constant.ELEMENTPRESENCEERROR);
	  
  }
  
  @Test
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
