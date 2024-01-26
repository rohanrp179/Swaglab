package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtil;

public class CartPage extends BrowserUtil {
	
	private static final By PRODUCT_NAME_TEXT_LOCATOR = By.xpath("//div[@class='inventory_item_name']");
	private static final By CHECKOUT_BUTTON_LOCATOR = By.id("checkout");
	private static final By CONTINUE_SHOPPING_BUTTON_LOCATOR = By.id("continue-shopping");
	private static final By REMOVE_PRODUCT_BUTTON_LOCATOR = By.id("remove-sauce-labs-backpack");
	
	private WebDriver wd;
	
	public CartPage(WebDriver wd) {
		super(wd);
		this.wd = wd;
	}
	
	public String productName() {
		String productName = readText(PRODUCT_NAME_TEXT_LOCATOR);
		return productName;
	}
	
	public void clickOnRemove() {
		clickOn(REMOVE_PRODUCT_BUTTON_LOCATOR);
	}
	
	public HomePage clickOnContinueShoppingButton() {
		clickOn(CONTINUE_SHOPPING_BUTTON_LOCATOR);
		return new HomePage(wd);
	}
	
	public CheckoutCompletePage clickOnCheckoutButton() {
		clickOn(CHECKOUT_BUTTON_LOCATOR);
		return new CheckoutCompletePage(wd);
	}
	

}
