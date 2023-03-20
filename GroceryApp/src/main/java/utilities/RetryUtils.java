package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryUtils implements IRetryAnalyzer {
	
	int intialcount=0;
	int maxRetryCount=3;
	
	@Override
	public boolean retry(ITestResult result) {
		if(intialcount<maxRetryCount) {
			intialcount ++;
			return true;
		}
		return false;
	}
	

}
