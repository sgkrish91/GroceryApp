package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
		
	public String getElementText(WebElement element) {
		String text=element.getText();
		return text;
	}
	
	public boolean isCheckboxSelected(WebElement element) {
		boolean result=element.isSelected();
		return result;
	}
	
	public String getURLOfCurrentPage(WebDriver driver) {
		String url=driver.getCurrentUrl();
		return url;
	}
	
	public String getBackgroundColor(WebElement element, String attribute) {
		String bgcolor=element.getCssValue(attribute);
		return bgcolor;
	}
	
	public String getTextOfAlert(WebDriver driver) {
		String alert=driver.switchTo().alert().getText();
		return alert;
	}
	
	public void selectValueFromDropDown(WebElement element, String value) {
		Select obj=new Select(element);
		obj.selectByValue(value);
	}
	
	public boolean getTableColumnValue(List<WebElement> element, String text) {
		boolean value=true;
		for(int i=0;i<element.size();i++) {
			if(!element.get(i).getText().equals(text)){
				value=false;
				break;
			}
		}
		return value;
	}
	
	/*public boolean verifyTableColumnElements(List<WebElement> element, String text, WebElement element2, String text2) {
		boolean value=true;
		for(int i=0;i<element.size();i++) {
			if(element.get(i).equals(text)) {
				if(!element2.getText().equals(text2)) {
					value=false;
				}
			}
		}
		return value;
	}*/
	
	public int getTableLocatorValue(List<WebElement> element, String text) {
		int index=0;
		for(int i=0;i<element.size();i++) {
			if(element.get(i).getText().equals(text)) {
				index=i;
				break;
			}
		}
		return index;
	}
	
	public void fileUpload(WebDriver driver, WebElement element, String location) throws AWTException {
		Robot obj=new Robot();
		Actions obj1=new Actions(driver);
		obj1.moveToElement(element).click().perform();
		StringSelection ss = new StringSelection(location);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    obj.delay(500);
	    obj.keyPress(KeyEvent.VK_CONTROL);
	    obj.keyPress(KeyEvent.VK_V);
	    obj.delay(500);
	    obj.keyRelease(KeyEvent.VK_CONTROL);
	    obj.keyRelease(KeyEvent.VK_V);
	    obj.delay(500);
	    obj.keyPress(KeyEvent.VK_ENTER);
	    obj.keyRelease(KeyEvent.VK_ENTER);
	    obj.delay(500);
	}
	

}
