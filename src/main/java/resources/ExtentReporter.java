package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter extends BaseFile{
//	static String basePath;
	
	public static ExtentReports getReport() {
		String basePath=System.getProperty("user.dir");
		String reportPath=basePath+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("My Reports");
		reporter.config().setReportName("Extent Reports");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "RajeshNare");
		
		return extent;
		
	}

}
