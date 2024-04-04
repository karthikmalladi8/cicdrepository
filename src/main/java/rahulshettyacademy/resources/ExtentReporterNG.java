package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
	public static ExtentReports getReportObject()
	{
		//it will create the path of the report
				/*String path = System.getProperty("user.dir")+"\\reports\\index.html";
				//it will edit the details in the report
				ExtentSparkReporter reporter =  new ExtentSparkReporter(path);
				//these both will create the modules in the path
				reporter.config().setReportName("web automation results");
				reporter.config().setDocumentTitle("Test Results");
				
				//it will create the report by using above boxes
				ExtentReports  extent = new ExtentReports();
				//it calls the report from above path
				extent.attachReporter(reporter);
				//it creates the testername
				extent.setSystemInfo("Tester", "karthik");
				return extent;*/
		

		        String path = System.getProperty("user.dir")+"\\reports\\index.html";
				//it will edit the details in the report
				ExtentSparkReporter reporter =  new ExtentSparkReporter(path);
				//these both will create the modules in the path
				reporter.config().setReportName("web automation results");
				reporter.config().setDocumentTitle("Test Results");
				
				//it will create the report by using above boxes
				ExtentReports  extent = new ExtentReports();
				//it calls the report from above path
				extent.attachReporter(reporter);
				//it creates the testername
				extent.setSystemInfo("Tester", "karthik");
				return extent;
	}

}
