package com.cyclos.amazonClasses.reportClasses;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReportClass {
	
    // To create a rich standalone HTML file with several configurations handled
    // using config() method.
    public static ExtentHtmlReporter htmlReporter;

    // This is used to provide/add information to the HTML report
    public static ExtentReports extent;

	ExtentReports extentReport;
	ExtentTest extentTest;
    // method to return the ExtentReports object variable
    public static ExtentReports getExtentReportInstance() {
    	
        if (extent == null) {

            htmlReporter = new ExtentHtmlReporter(
                    System.getProperty("user.dir") + "/Reports/extentReport.html");
            

            extent = new ExtentReports();


            // attach the report to extent object variable
            extent.attachReporter(htmlReporter);
            
        // Name of the report
        htmlReporter.config().setReportName("Execution Report");
        htmlReporter.config().setTheme(Theme.STANDARD);

    }
    return extent;
  }

}