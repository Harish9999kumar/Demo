package org.sdet40.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class RetryImpClass implements IRetryAnalyzer {
	int counter=0;
	int maxRetries=4;
	public boolean retry(ITestResult result) {
		if(counter<maxRetries) {
			counter++;
			return true;
		}
		return false;
	}
}
