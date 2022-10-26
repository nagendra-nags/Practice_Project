package genericUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

		
		public static ExtentReports getReport()
		{
			String path=System.getProperty("user.dir")+"//reports//index.html";
			ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		    reporter.config().setReportName("flixBus");
		    reporter.config().setDocumentTitle("Test Result");
		    
		    ExtentReports extent= new ExtentReports(); 
			extent.attachReporter(reporter);
			
			extent.setSystemInfo("Tester", "Nagendra");
			return extent;
		}

	}

