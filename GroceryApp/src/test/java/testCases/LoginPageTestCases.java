package testCases;

import org.testng.annotations.Test;

import constantPackage.Constant;
import elementRepository.LoginPage;
import utilities.DataProviderUtility;
import utilities.ExcelRead;
import utilities.RetryUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPageTestCases extends BaseClass {//inheritance. We add the BeforeMethod and AfterMethod inside another class BaseClass and extend the same here.
	
	LoginPage lp;
	ExcelRead er=new ExcelRead();
	
  @Test(groups="Sanity", retryAnalyzer = RetryUtils.class)
  public void verifyTheTextOfSignInButton() {
	  lp=new LoginPage(driver);
	  String actualResult=lp.getTextOfSignInButton();
	  String expectedResult;
	try {
		expectedResult = er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 10, 1);
	  Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 11, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }
  
  @Test(groups="Sanity", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherRememberMeCheckboxIsSelected() {
	  lp=new LoginPage(driver);
	  boolean actualResult=lp.isRemembermeSelected();
	  boolean expectedResult=false;
	  try {
		Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 12, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }
  
  @Test(groups="Regression", retryAnalyzer = RetryUtils.class)
  public void verifyUserIsAbleToLoginWithValidCredentials() {
	  lp=new LoginPage(driver);
	  try {
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
	  lp.clickSignIn();
	  String actualResult=lp.URLAfterSignIn();
	  String expectedResult=prop.getProperty("SignInURL");
	  try {
		Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 13, 1));
	  boolean actualResult1=lp.isAdminDisplayed();
	  Assert.assertTrue(actualResult1, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 13, 1));
	  } catch (IOException e) {
		  System.out.println("Exception handled " + e);
		}
  }
  
  @Test(dataProvider ="dataProvider",dataProviderClass = DataProviderUtility.class, groups="Regression", retryAnalyzer = RetryUtils.class)
  public void verifyTheErrorMessageWhenLoginUsingInvalidCredentials(String user, String pass) {
	  lp=new LoginPage(driver);
	  lp.enterUsername(user);
	  lp.enterPassword(pass);
	  lp.clickSignIn();
	  try {
	  boolean actualResult=lp.getErrorMessage(er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 14, 1));
		Assert.assertTrue(actualResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 3, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }
  
  @Test(groups="Sanity", retryAnalyzer = RetryUtils.class)
  public void verifyTheTextOfLoginPageTitle() {
	  lp=new LoginPage(driver);
	  String actualResult=lp.textOfTitle();
	  String expectedResult;
	try {
		expectedResult = er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 6, 1);
	  Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 15, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }
  
  @Test(groups="Sanity", retryAnalyzer = RetryUtils.class)
  public void verifyTheBackgroundColorOfSignInButton() {
	  lp=new LoginPage(driver);
	  String actualResult=lp.getSignInBackgroundColor();
	  String expectedResult;
	try {
		expectedResult = er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 16, 1);
	  Assert.assertEquals(actualResult, expectedResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 17, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }
  
  @Test(groups="Sanity", retryAnalyzer = RetryUtils.class)
  public void verifyWhetherUserIsPromptedToEnterTheUsernameIfTryingToLoginWithoutEnteringCredentials() {
	  lp=new LoginPage(driver);
	  lp.clickSignIn();
	  boolean actualResult=lp.isUsernameEnabled();
	  try {
		Assert.assertTrue(actualResult, er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 18, 1));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }
  
  @Test(groups="Functional", retryAnalyzer = RetryUtils.class)
  public void verifyTheTextOfRememberMeLogin() {
	  lp=new LoginPage(driver);
	  String actualResult=lp.getTextOfRememberMeLabel();
	  String expectedResult;
	try {
		expectedResult = er.readStringData(prop.getProperty("DataProviderExcel"), prop.getProperty("ExpectedResultSheet"), 19, 1);
	  Assert.assertEquals(actualResult, expectedResult, prop.getProperty("AlertExpectedResult"));
	} catch (IOException e) {
		System.out.println("Exception handled " + e);
	}
  }

}
