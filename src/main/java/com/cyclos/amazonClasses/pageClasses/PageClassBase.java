package com.cyclos.amazonClasses.pageClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.cyclos.amazonClasses.reportClasses.ExtentReportClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class PageClassBase {

	public static WebDriver driver = null;
	protected static Properties prop;
	private static final int Implicit_Wait = 10;
	public static ExtentReports report = ExtentReportClass.getExtentReportInstance();
	public static ExtentTest test;

	@BeforeSuite
	public void initalize() {
		try {
			prop = new Properties();
			FileInputStream inputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
			prop.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		openAmazon();

	}
	
	public void openAmazon() {

		if (driver == null) {
			if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
				System.setProperty("org.uncommons.reportng.escape-output", "false");
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Implicit_Wait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("amazonURL"));
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

}