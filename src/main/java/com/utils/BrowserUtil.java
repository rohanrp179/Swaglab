package com.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtil {
	
	private WebDriver wd;
	private WebDriverWait wait;
	
	public BrowserUtil(WebDriver wd) {
		super();
		this.wd = wd;
		wait = new WebDriverWait(wd, Duration.ofSeconds(30));
	}
	
	public void openWebSite(String url) {
		wd.get(url);
	}
	
	public void maximizeBrowser() {
		wd.manage().window().maximize();
	}
	
	public void enterText(By locator, String textToEnter) {
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		ele.clear();
		ele.sendKeys(textToEnter);
	}
	
	public void clickOn(By locator) {
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
		ele.click();
	}
	
	public String readText(By locator) {
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String text = ele.getText();
		return text;
	}
	
	public void sleepFor(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean elementVisibility(By locator) {
		return wd.findElement(locator).isDisplayed();
	}

}
