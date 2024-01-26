package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtil;

public class CheckoutCompletePage extends BrowserUtil {
	
	private static final By FIRST_NAME_TEXTBOX_LOCATOR = By.id("first-name");
	private static final By LAST_NAME_TEXTBOX_LOCATOR = By.id("last-name");
	private static final By POSTAL_CODE_TEXTBOX_LOCATOR = By.id("postal-code");
	private static final By CONTINUE_BUTTON_LOCATOR = By.id("continue");
	private static final By CANCEL_BUTTON_LOCATOR = By.id("cancel");
	
	private WebDriver wd;
	
	public CheckoutCompletePage(WebDriver wd) {
		super(wd);
		this.wd = wd;
	}
	
	public CheckoutCompletePage fillCheckoutInfoDetails(String firstName, String lastName, String postalCode) {
		enterText(FIRST_NAME_TEXTBOX_LOCATOR, firstName);
		enterText(LAST_NAME_TEXTBOX_LOCATOR, lastName);
		enterText(POSTAL_CODE_TEXTBOX_LOCATOR, postalCode);
		return new CheckoutCompletePage(wd);
	}
	
	public CheckoutOverviewPage clickOnContinueToCheckoutOVerview() {
		clickOn(CONTINUE_BUTTON_LOCATOR);
		return new CheckoutOverviewPage(wd);
	}
	
	public HomePage goBackToCartPageUsingCancelButton() {
		clickOn(CANCEL_BUTTON_LOCATOR);
		return new HomePage(wd);
	}

}
