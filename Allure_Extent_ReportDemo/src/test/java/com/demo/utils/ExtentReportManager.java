package com.demo.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // UI of the Report
	public ExtentReports extent; // populate common information on the report
	public ExtentTest test; // creating Test Case entries in the report and updating their status

	public void onStart(ITestContext context) {

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myExtentReport.html");

		sparkReporter.config().setDocumentTitle("Automation Report - Demo Extent Report"); // Title of the Report
		sparkReporter.config().setReportName("Functional Testing for Extent Demo"); // Name of the Report
		sparkReporter.config().setTheme(Theme.DARK); // Set Theme of Report (Standard or Dark)

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Test Environment", "QA");
		extent.setSystemInfo("Tester Name", "NINAD PANTANE");
		extent.setSystemInfo("os", "Windows 11");
		extent.setSystemInfo("Browser Name", "Chrome");

	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getName()); // create a new Entry in the Report
		test.log(Status.PASS, "Test Case PASSED is : " + result.getName()); // Update Status - PASS/FAIL/SKIP
	}

	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getName()); // create a new Entry in the Report
		test.log(Status.FAIL, "Test Case FAIL is : " + result.getName()); // Update Status - PASS/FAIL/SKIP
		test.log(Status.FAIL, "Test Case FAILED due to : " + result.getThrowable()); // Failed Error
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName()); // create a new Entry in the Report
		test.log(Status.SKIP, "Test Case SKIPPED is : " + result.getName()); // Update Status - PASS/FAIL/SKIP
	}

	public void onFinish(ITestContext context) {

		extent.flush(); // mandatory action to log everything in the report
	}
}
