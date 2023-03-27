package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import constant.Constant;
import utilities.ScreenshotUtilities;

public class BaseClass {

	public static Properties prop; // We use Properties class to use properties file.
	ScreenshotUtilities ss;

	public static void testBasic() {
		prop = new Properties(); // Object creation of Properties class
		FileInputStream ip;
		try {
			ip = new FileInputStream(System.getProperty("user.dir") + Constant.CONFIGPROPERTIES); // Create object for FileInputStream class and pass the location of properties file as parameter
			prop.load(ip); // Using load method, we can load the properties file into the project
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	WebDriver driver;
	Faker faker=new Faker();

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browserName) {
		testBasic();
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new ChromeDriver();
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
		} else if (browserName.equals("Edge")) {
			driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("BaseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult itestResult) {
		if (itestResult.getStatus() == itestResult.FAILURE) { // We use listener to monitor every event and identify whether a tc is pass or fail. If it fails, we need to call the method to capture screenshot
			try {
				ss.captureFailureScreenShot(driver, itestResult.getName()); // itestResult.getName() is used to get the name of the tc which is failed.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
	}

}
