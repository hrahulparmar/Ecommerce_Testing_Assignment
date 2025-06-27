package utils;

import java.io.IOException;
import java.util.logging.Level;

import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.BaseTest;

public class EventListenerUtility extends BaseTest implements ITestListener {
	
	
	
	public void onTestSuccess(ITestResult result) {
		logger.log(Level.INFO,result.getName()+" got successfully executed");
	}
	
	public void onTestFailure(ITestResult result) {
		
		logger.log(Level.SEVERE,result.getName()+" got failed");
		logger.log(Level.INFO,result.getThrowable().getMessage());
		try {
			 new BaseTest().captureScreen(result.getName());
		} catch (IOException e) {
			logger.log(Level.WARNING,"Screenshot capture failed");
			e.printStackTrace();
		}
	}
	

}
