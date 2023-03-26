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
	ExcelRead er=new ExcelRead();
	
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsAbleToAddNewImage() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickMobileSlider();
	  ms=new MobileSliderPage(driver);
	  ms.clickNew();
	  try {
		ms.uploadImage(Constant.UPLOADIMAGE);
	} catch (AWTException e) {
		System.out.println("Exception handled " + e);
	}
	  ms.clickSave();
	  try {
	  boolean actualResult=ms.getAlertText(er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 33, 1));
	  Assert.assertTrue(actualResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 3, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  dp.clickMobileSlider();
	  boolean actualResult1=ms.presenceOfImage();
	  try {
		Assert.assertTrue(actualResult1, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 27, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }
  
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyTheAlertTextWhileClickingDeleteButtonInMobileSliderPage() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickMobileSlider();
	  ms=new MobileSliderPage(driver);
	  ms.clickDelete();
	  String actualResult=ms.getTextOfDeleteAlert();
	  try {
	  String expectedResult=er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 34, 1);
	  Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 3, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }
}
