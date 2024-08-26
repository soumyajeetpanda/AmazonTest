package com.cyclos.amazonTestFlow;

import com.cyclos.amazonClasses.pageClasses.PageClassAmazon;
import com.cyclos.amazonClasses.utilitiesClasses.TestListenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.cyclos.amazonClasses.pageClasses.PageClassBase;
import com.cyclos.amazonClasses.pageClasses.PageClassLogin;

@Listeners(TestListenerClass.class)
public class TestClassAmazon extends PageClassBase {

	PageClassLogin lg;
	PageClassAmazon hg;

	@BeforeTest
	public void loginToAmazon() throws InterruptedException {
		lg = new PageClassLogin();
		hg = lg.loginToWebsite();
		}

	@Test
	public void amazonSearchTest() throws InterruptedException {
		test = report.createTest("AmazonSearch TestCase", "Test Case covering UI elated amazonTest cases");
		String expectedData = hg.navigateToAmazon();
		checkSearchResults(expectedData);
	}

	public void checkSearchResults(String ExpectedData) throws InterruptedException {
		String ActualData = prop.getProperty("ActualData");
		if(ExpectedData.contains("Apple iPhone"))
		{
			ExpectedData = ExpectedData.substring(0,ExpectedData.indexOf("iPhone")+6);
		}
		System.out.println(ActualData);
		System.out.println(ExpectedData);
		Assert.assertEquals(ActualData,ExpectedData,"Data does not match.");
	}
	
	@AfterTest
	public void tearDown() {
		report.flush();
		driver.quit();
	}

}