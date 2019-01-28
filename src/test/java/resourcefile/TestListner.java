package resourcefile;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;


public class TestListner implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) {
		Extentreport.etlogger = Extentreport.extent.createTest(result.getName());
		System.out.println("Test Case is Started and Details are :  "+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Extentreport.etlogger.log(com.aventstack.extentreports.Status.PASS, result.getName());
		System.out.println("Test Case is Success and Details are :  "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Extentreport.etlogger.log(Status.FAIL, result.getName());
		System.out.println("Test Case is Failed and Details are :   "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Extentreport.etlogger.log(Status.SKIP, result.getName());
		System.out.println("Test Case is Skipped and Details are :  "+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		Extentreport.SetExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		
		Extentreport.endReport();
	}

}
