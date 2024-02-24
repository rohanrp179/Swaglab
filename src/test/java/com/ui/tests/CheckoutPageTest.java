package com.ui.tests;

import org.openqa.selenium.WebDriver;

import com.ui.pages.LoginPage;

public class CheckoutPageTest {
	
	private WebDriver wd;
	private LoginPage loginPage;
	
	public CheckoutPageTest(WebDriver wd, LoginPage loginPage) {
		super();
		this.wd = wd;
		this.loginPage = loginPage;
	}



}
