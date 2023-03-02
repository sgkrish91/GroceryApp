package testCases;

import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import utilities.ExcelRead;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPageTestCases extends BaseClass {//inheritance. We add the BeforeMethod and AfterMethod inside another class BaseClass and extend the same here.
	
	LoginPage lp;
	
  @Test(groups = {"Critical"} )
  public void verifyTheTextOfSignInButton() {
	  lp=new LoginPage(driver);
	  String actualResult=lp.getTextOfSignInButton();
	  String expectedResult="Sign In";
	  Assert.assertEquals(actualResult, expectedResult, Constant.SIGNINBUTTONERROR);
  }
  
  @Test(groups = {"High"})
  public void verifyWhetherRememberMeCheckboxIsSelected() {
	  lp=new LoginPage(driver);
	  boolean actualResult=lp.isRemembermeSelected();
	  boolean expectedResult=false;
	  Assert.assertEquals(actualResult, expectedResult, Constant.CHECKBOXERROR);
  }
  
  @Test(groups = {"Critical"} )
  public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException {
	  lp=new LoginPage(driver);
	  lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
	  lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 0));
	  lp.clickSignIn();
	  String actualResult=lp.URLAfterSignIn();
	  String expectedResult="https://groceryapp.uniqassosiates.com/admin";
	  Assert.assertEquals(actualResult, expectedResult, Constant.LOGINERROR);
	  boolean actualResult1=lp.isAdminDisplayed();
	  boolean expectedResult1=true;
	  Assert.assertEquals(actualResult1, expectedResult1, Constant.LOGINERROR);
  }
  
  @Test(dataProvider ="dataProvider",dataProviderClass = DataProviderTest.class)
  public void verifyTheErrorMessageWhenLoginUsingInvalidCredentials(String user, String pass) {
	  lp=new LoginPage(driver);
	  lp.enterUsername(user);
	  lp.enterPassword(pass);
	  lp.clickSignIn();
	  String actualResult=lp.getErrorMessage();
	  String expectedResult="×\n"
	  		+ "Alert!\n"
	  		+ "Invalid Username/Password";
	  Assert.assertEquals(actualResult, expectedResult, Constant.ALERTERROR);
  }
  
  @Test
  public void verifyTheTextOfLoginPageTitle() {
	  lp=new LoginPage(driver);
	  String actualResult=lp.textOfTitle();
	  String expectedResult="7rmart supermarket";
	  Assert.assertEquals(actualResult, expectedResult, Constant.LOGINTITLE);
  }
  
  @Test(groups = {"High"})
  public void verifyTheBackgroundColorOfSignInButton() {
	  lp=new LoginPage(driver);
	  String actualResult=lp.getSignInBackgroundColor();
	  String expectedResult="rgba(52, 58, 64, 1)";
	  Assert.assertEquals(actualResult, expectedResult, Constant.BACKGROUNDCOLORERROR);
  }
  
  @Test(enabled = false)
  public void verifyWhetherUserIsPromptedToEnterTheUsernameIfTryingToLoginWithoutEnteringCredentials() {
	  lp=new LoginPage(driver);
	  lp.clickSignIn();
	  boolean actualResult=lp.isUsernameSelected();
	  boolean expectedResult=true;
	  Assert.assertEquals(actualResult, expectedResult, Constant.USERNAMEERROR);
  }

}
