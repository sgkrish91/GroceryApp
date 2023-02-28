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
	  
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
	  lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickMobileSlider();
	  ms=new MobileSliderPage(driver);
	  ms.clickNew();
	  ms.uploadImage();
	  ms.clickSave();
	  String actualResult=ms.getAlertText();
	  String expectedResult="�\n"
	  		+ "Alert!\n"
	  		+ "Mobile Slider Created Successfully";
	  Assert.assertEquals(actualResult, expectedResult, Constant.ALERTERROR);
	  dp.clickMobileSlider();
	  boolean actualResult1=ms.presenceOfImage();
	  boolean expectedResult1=true;
	  Assert.assertEquals(actualResult1, expectedResult1, Constant.ELEMENTPRESENCEERROR);
	  
  }
  
  @Test
  public void verifyTheAlertTextWhileClickingDeleteButtonInMobileSliderPage() throws IOException {
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
	  lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickMobileSlider();
	  ms=new MobileSliderPage(driver);
	  ms.clickDelete();
	  String actualResult=ms.getTextOfDeleteAlert();
	  String expectedResult="Do you want to delete this Mobile Slider?";
	  Assert.assertEquals(actualResult, expectedResult, Constant.ALERTERROR);
  }
}
