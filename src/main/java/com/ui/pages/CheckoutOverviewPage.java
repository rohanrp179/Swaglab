package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtil;

public class CheckoutOverviewPage extends BrowserUtil {

	private static final By ITEM_PRICE_TEXT_LOCATOR = By.xpath("//div[@class='summary_subtotal_label']");
	private static final By TAX_PRICE_TEXT_LOCATOR = By.xpath("//div[@class='summary_tax_label']");
	private static final By TOTAL_FINAL_ITEM_PRICE_TEXT_LOCATOR = By.xpath("//div[@class='summary_info_label summary_total_label']");
	private static final By FINISH_BUTTON_LOCATOR = By.id("finish");
	private static final By CANCEL_BUTTON_LOCATOR = By.id("cancel");
	private static final By BACK_TO_HOME_TEXT_LOCATOR = By.id("back-to-products");
	
	private WebDriver wd;
	
	public CheckoutOverviewPage(WebDriver wd) {
		super(wd);
		this.wd = wd;
	}
	
	public int itemPriceValueText() {
		int itemPrice = Integer.parseInt(readText(ITEM_PRICE_TEXT_LOCATOR));
		return itemPrice;
	}
	
	public int taxValueText() {
		int taxValue = Integer.parseInt(readText(TAX_PRICE_TEXT_LOCATOR));
		return taxValue;
	}
	
	public int totalFinalProductValue() {
		int totalFinalProductValue = itemPriceValueText() + taxValueText();
		return totalFinalProductValue;
	}
	
	public CheckoutOverviewPage completeOrder() {
		clickOn(FINISH_BUTTON_LOCATOR);
		return new CheckoutOverviewPage(wd);
	}
	
	public HomePage cancelOrderFromFinalCheckoutStage() {
		clickOn(CANCEL_BUTTON_LOCATOR);
		return new HomePage(wd);
	}
	
	public String readBackHomeTextOnSuccessfulOrderCompletion() {
		return readText(BACK_TO_HOME_TEXT_LOCATOR);
	}
	
	
	
	

}
