package org.sdet40.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	private ExtentReports reports;
	private ExtentTest test;
	public static ExtentTest stest;

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("Document Title-SDET 40");
		spark.config().setReportName("Report Name -SDET40");
		spark.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "Anke Harish Kumar");
		reports.setSystemInfo("OS", " windows 11");
		reports.setSystemInfo("Browser", "chrome");
	}
	@Override
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		stest = test;
	}

	@Override // AM
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName() + "pass");
	}

	@Override // AM
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName() + "fail");
		
		System.out.println(Thread.currentThread().getId());
		
		try {
			new WebdriverUtility().screenShot(BaseClass.sdriver,BaseClass.sjavaUtil,result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//test.addScreenCaptureFromBase64String(path);
		// this is used to store the screenshot photo in screenshot folder
		// new WebDriverUtility().screenShot(BaseClass.sjv,BaseClass.sdriver ,
		//result.getMethod().getMethodName());
	}

	@Override // AM
	public void onTestSkipped(ITestResult result) {
		test.skip("Test1 skip");
		test.fail(result.getThrowable());
	}

	@Override // AM
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override // AT
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
