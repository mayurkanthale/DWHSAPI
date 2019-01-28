package resourcefile;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreport {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest etlogger;

	public static void SetExtentReport() {
		htmlReporter = new ExtentHtmlReporter("./Reports/DWHS_API_Test_Report4.html");
		htmlReporter.config().setDocumentTitle("DataWarehouse API Test Report");// Title of report

		htmlReporter.config().setReportName("DataWarehouse API Test");// Name of report
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Local");
		extent.setSystemInfo("Server Name", "Windows");
		extent.setSystemInfo("Test Engineer Name", "Mechsoft");

	}

	public static void endReport() {
		extent.flush();
	}
}
