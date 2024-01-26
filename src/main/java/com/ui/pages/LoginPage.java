package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtil;

public final class LoginPage extends BrowserUtil {

	private static final By USER_NAME_TEXTBOX_LOCATOR = By.id("user-name");
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("password");
	private static final By LOGIN_BUTTON_LOCATOR = By.id("login-button");
	
	private WebDriver wd;
	
	public LoginPage(WebDriver wd) {
		super(wd);
		this.wd = wd;
		openWebSite("https://www.saucedemo.com/");
		maximizeBrowser();
//		Thread.sleep(3);
//		sleepFor(3000);
	}
	
	public HomePage doLogin(String userName, String password) {
		enterText(USER_NAME_TEXTBOX_LOCATOR, userName);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(LOGIN_BUTTON_LOCATOR);
		return new HomePage(wd);
	}

}
