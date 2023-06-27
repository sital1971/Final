package resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;

public class Listener extends BaseClass implements ITestListener {
	ExtentReports extent=new ExtentReports();
	ExtentSparkReporter reporter=new ExtentSparkReporter("C:\\Users\\sital\\eclipse-workspace\\Final\\REPORTS\\"+"extent.html");
    ExtentTest test; 
    String path;
	public Listener() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void onTestFailure(ITestResult result) {
		try {
			path=takeScreenShot(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.attachReporter(reporter);
		test=extent.createTest(result.getName());
		test.fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		test.addScreenCaptureFromPath(path);
		extent.flush();

}
	
}
