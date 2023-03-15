package testCases;

import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import utilities.DataProviderUtility;
import utilities.ExcelRead;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPageTestCases extends BaseClass {//inheritance. We add the BeforeMethod and AfterMethod inside another class BaseClass and extend the same here.
	
	LoginPage lp;
	
  @Test(groups = {"Sanity"} )
  public void verifyTheTextOfSignInButton() {
	  lp=new LoginPage(driver);
	  String actualResult=lp.getTextOfSignInButton();
	  String expectedResult=Constant.SIGNINTEXT;
	  Assert.assertEquals(actualResult, expectedResult, Constant.SIGNINBUTTONERROR);
  }
  
  @Test(groups = {"Sanity"})
  public void verifyWhetherRememberMeCheckboxIsSelected() {
	  lp=new LoginPage(driver);
	  boolean actualResult=lp.isRemembermeSelected();
	  boolean expectedResult=false;
	  Assert.assertEquals(actualResult, expectedResult, Constant.CHECKBOXERROR);
  }
  
  @Test(groups = {"Regression"} )
  public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException {
	  testBasic();
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 0));
	  lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), "Sheet1", 1, 0));
	  lp.clickSignIn();
	  String actualResult=lp.URLAfterSignIn();
	  String expectedResult=prop.getProperty("SignInURL");
	  Assert.assertEquals(actualResult, expectedResult, Constant.LOGINERROR);
	  boolean actualResult1=lp.isAdminDisplayed();
	  Assert.assertTrue(actualResult1, Constant.LOGINERROR);
  }
  
  @Test(dataProvider ="dataProvider",dataProviderClass = DataProviderUtility.class, groups="Regression")
  public void verifyTheErrorMessageWhenLoginUsingInvalidCredentials(String user, String pass) {
	  lp=new LoginPage(driver);
	  lp.enterUsername(user);
	  lp.enterPassword(pass);
	  lp.clickSignIn();
	  boolean actualResult=lp.getErrorMessage(Constant.INVALIDUSERNAMEALERT);
	  Assert.assertTrue(actualResult, Constant.ALERTERROR);
  }
  
  @Test(groups = {"Sanity"})
  public void verifyTheTextOfLoginPageTitle() {
	  lp=new LoginPage(driver);
	  String actualResult=lp.textOfTitle();
	  String expectedResult=Constant.LOGINTITLETEXT;
	  Assert.assertEquals(actualResult, expectedResult, Constant.LOGINTITLE);
  }
  
  @Test(groups = {"Sanity"})
  public void verifyTheBackgroundColorOfSignInButton() {
	  lp=new LoginPage(driver);
	  String actualResult=lp.getSignInBackgroundColor();
	  String expectedResult=Constant.SIGNINBGCOLOR;
	  Assert.assertEquals(actualResult, expectedResult, Constant.BACKGROUNDCOLORERROR);
  }
  
  @Test(groups="Sanity")
  public void verifyWhetherUserIsPromptedToEnterTheUsernameIfTryingToLoginWithoutEnteringCredentials() {
	  lp=new LoginPage(driver);
	  lp.clickSignIn();
	  boolean actualResult=lp.isUsernameEnabled();
	  Assert.assertTrue(actualResult, Constant.USERNAMEERROR);
  }

}
