package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoyPage;
import utilities.ExcelRead;

public class ManageDeliverBoyPageTestCases extends BaseClass {
	
	LoginPage lp;
	DashboardPage dp;
	ManageDeliveryBoyPage md;
	
  @Test
  public void verifyTheUsernameOfADeliverBoy() throws IOException {
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
	  lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageDeliveryBoy();
	  md=new ManageDeliveryBoyPage(driver);
	  String actualResult=md.getTextOfUsername();
	  String expectedResult="Tristan";
	  Assert.assertEquals(actualResult, expectedResult, Constant.EXPECTEDTEXTERROR);
  }
  
  @Test
  public void verifyTheFunctionalityOfResetButton() throws IOException {
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
	  lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageDeliveryBoy();
	  md=new ManageDeliveryBoyPage(driver);
	  md.clickSearch();
	  md.enterUsername();
	  md.clickReset();
	  boolean actualResult=md.presenceOfUsername();
	  boolean expectedResult=false;
	  Assert.assertEquals(actualResult, expectedResult, Constant.ELEMENTPRESENCEERROR);
  }
}
