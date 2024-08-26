package com.cyclos.amazonClasses.utilitiesClasses;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import com.cyclos.amazonClasses.pageClasses.PageClassBase;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotClass extends PageClassBase {

	public static String takeScreenshot(String methodName, WebDriver driver) {

		/**
		 * The below method will capture and save screenshot with amazonTest method name and
		 * time-stamp.
		 * 
		 */

		String name = "";

		try {

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			File screenshotName = new File("./Screenshots/" + methodName + "_" + timestamp + ".png");
			name = methodName + "_" + timestamp + ".png";
			FileHandler.copy(scrFile, screenshotName);
			return name;

		} catch (Exception e) {
			
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		return name;
	}

}