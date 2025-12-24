package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCases.BaseTest;
import utilities.ReadConfig;

public class ListenerClass implements ITestListener{
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	public void configureReport() {
		ReadConfig config = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
		String reportname= "report"+timestamp+".html";
		
//		htmlExtentReporter= new ExtentSparkReporter("D:\\Work_Space\\Project3\\Reports\\report.html");
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\"+reportname);
		
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//Adding system information into a report 
		
		reports.setSystemInfo("User Name", config.SystemInfo("username"));
		reports.setSystemInfo("OS",  config.SystemInfo("os"));
		reports.setSystemInfo("Browser",  config.SystemInfo("browser"));
		reports.setSystemInfo("Machine",  config.SystemInfo("machine"));

		
		
		//Changing look of report
		
		htmlReporter.config().setDocumentTitle("Test Cases Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Amazon report");
		
	}
	
	@Override
	public void onStart(ITestContext context) {
		configureReport();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		BaseTest.ScreenShots(result.getMethod().getMethodName(),"pass");
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Pass : Test Case Name " + result.getName(),ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		BaseTest.ScreenShots(result.getMethod().getMethodName(),"fail");
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Fail : Test Case Name " + result.getName(),ExtentColor.RED));

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skiped :"+result.getTestName());
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Skip : Test Case Name " + result.getName(),ExtentColor.ORANGE));
	}


	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	
	
}
