package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtil;

public final class HomePage extends BrowserUtil {

	private static final By PRODUCT_NAME_TEXT_LOCATOR = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.id("add-to-cart-sauce-labs-backpack");
	private static final By CART_ICON_LOCATOR = By.xpath("//a[@class='shopping_cart_link']");
	
	private WebDriver wd;
	
	public HomePage(WebDriver wd) {
		super(wd);
		this.wd = wd;
	}
	
	public String productName() {
		String productName = readText(PRODUCT_NAME_TEXT_LOCATOR);
		return productName;
	}
	public void addProductToCart() {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
	}
	
	public CartPage clickOnCartIcon() {
		clickOn(CART_ICON_LOCATOR);
		return new CartPage(wd);
	}
	
	public boolean isCartIconVisible() {
		return elementVisibility(CART_ICON_LOCATOR);
	}
	
	

}
