package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

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
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
	  lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
	  lp.clickSignIn();
	  dp=new DashboardPage(driver);
	  dp.clickManageContent();
	  dp.clickManagePages();
	  mc=new ManageContentPage(driver);
	  mc.clickEditInTable();
	  mc.editPageDetails();
	  mc.clickUpdate();
	  String actualResult=mc.getTextOfAlert();
	  System.out.println(actualResult);
  }
}
