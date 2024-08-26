package com.cyclos.amazonClasses.utilitiesClasses;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.cyclos.amazonClasses.pageClasses.PageClassBase;

public class TestListenerClass extends PageClassBase implements ITestListener{


	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		test.log(Status.PASS, "Pass: " + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		if (result.getStatus() == ITestResult.FAILURE) {
			// log.error("***** Error "+result.getName()+" amazonTest has failed *****");
			test.log(Status.FAIL, "Failed Case is: " + result.getName());
			test.log(Status.FAIL, result.getName() + " Fail with error " + result.getThrowable());
			String methodName = result.getName().toString().trim();
			/*
			 * ITestContext context = result.getTestContext();; WebDriver driver =
			 * (WebDriver) context.getAttribute("WebDriver");
			 */
			WebDriver driver= PageClassBase.getDriver();
			String name = ScreenshotClass.takeScreenshot(methodName, driver);
			try {
				test.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\Screenshots\\" +name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("unable to capture screenshot");
				e.printStackTrace();
			}

		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}