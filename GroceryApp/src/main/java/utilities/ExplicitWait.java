package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
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

}
