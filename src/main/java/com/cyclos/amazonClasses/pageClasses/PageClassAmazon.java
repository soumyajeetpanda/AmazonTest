package com.cyclos.amazonClasses.pageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClassAmazon extends PageClassBase {

	private By amazonSearchInput = By.xpath("//input[@aria-label='Search Amazon']");
	private By clickSearchButton = By.xpath("//input[@id='nav-search-submit-button']");
	private By elementText = By.xpath("//span[text()='Apple iPhone 11, US Version, 256GB, Purple - Unlocked (Renewed)']");
	WebDriverWait wait = new WebDriverWait(driver, 50);

	public String navigateToAmazon() throws InterruptedException {
		driver.findElement(amazonSearchInput).click();
		driver.findElement(amazonSearchInput).sendKeys("iPhone");
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickSearchButton));
		driver.findElement(clickSearchButton).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String expectedText = null;
		expectedText = driver.findElement(elementText).getText();
		return expectedText;
	}
}