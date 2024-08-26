package com.cyclos.amazonClasses.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClassLogin extends PageClassBase {


	private By loginLink = By.xpath("//a[@aria-label='Amazon']");
	/**
	 * Common actions that can be performed on login page and can be reused while
	 * designing amazonTest case.
	 * 
	 * @param userName
	 * @param pswd
	 * @return AmazonPage
	 * @throws InterruptedException
	 */

	public PageClassAmazon loginToWebsite() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(loginLink));
		//driver.findElement(username).sendKeys(userName);
		//driver.findElement(password).sendKeys(pswd);
		//driver.findElement(submit).click();
		//new WebDriverWait(driver,50).until(ExpectedConditions.visibilityOfElementLocated(banking));
		return new PageClassAmazon();
		
	}

	/**
	 * Method to perform logout from application
	 * 
	 */
	public void logout() {

		//new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(logoutIcon));
		//driver.findElement(logoutIcon).click();
		//driver.quit();
	}

	public PageClassAmazon reLoginToApplication(String userName, String pswd) throws InterruptedException {

//		driver.findElement(username).sendKeys(userName);
//		driver.findElement(password).sendKeys(pswd);
//		driver.findElement(submit).click();
		return new PageClassAmazon();
	}

}