package utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public void stalenessExplicitWait(WebDriver driver,WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.stalenessOf(element));
	}
	
	public void presenceOfElementExplicitWait(WebDriver driver, String locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	
	public void elementNotInteractableExplicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void elementToBeClickableExplicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void fluentWaitUtility(WebDriver driver) {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofMillis(5000));
		wait.pollingEvery(Duration.ofMillis(200));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
