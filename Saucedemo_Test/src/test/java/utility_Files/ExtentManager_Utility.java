package utility_Files;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager_Utility 
{
	public static ExtentReports extent;

    public static ExtentReports createInstance() {
        String fileName = "./reports/TestReport.html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Environment", "QA");
        
        return extent;
    }

}
