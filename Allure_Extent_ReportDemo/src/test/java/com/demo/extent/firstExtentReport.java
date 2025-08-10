package com.demo.extent;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class firstExtentReport {

	
	static ExtentTest logger;
	static ExtentReports report;
	
	@BeforeClass
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReportsResult.html",true);
	}
	
	@Test
	public void verifyPageTitle() {
		logger=report.startTest("Test 1 : Verify Page Title");
		String expected="Google";
		String actual="Google";
		Assert.assertEquals(actual, expected);
		logger.log(LogStatus.PASS, "Test Case Passed");
	}
	
	
	@Test
	public void verifyPageURL() {
		logger=report.startTest("Test 2 : Verify Page URL");
		String expected="www.google.com";
		String actual="www.yahoo.com";
		Assert.assertEquals(actual, expected);
		logger.log(LogStatus.FAIL, "Test Case FAIL");
	}
	

	@AfterMethod
	public void getResults(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed "+result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.log(LogStatus.FAIL, "Test Case Failed "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed "+result.getThrowable());
		}
		
		report.endTest(logger);
	}
	
	@AfterClass
	public void endTest() {
	
		report.flush();
		report.close();
	}
}
