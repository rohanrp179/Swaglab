package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.LoginPage;

public class HappyFlowTest {

	private WebDriver wd;
	private LoginPage loginPage;

	@BeforeMethod(description = "Setup the Browser and load the page")
	public void setup() {
		wd = new ChromeDriver();
		loginPage = new LoginPage(wd);
	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

	@Test(description = "Validate a complete order flow", groups = { "regression" })
	public void testSuccessfulCompletionOfOrder() {
		Assert.assertEquals(loginPage.doLogin("standard_user", "secret_sauce").addProductToCart().clickOnCartIcon()
				.clickOnCheckoutButton().fillCheckoutInfoDetails("Abc", "XYZ", "112020")
				.clickOnContinueToCheckoutOVerview().completeOrder().readBackHomeTextOnSuccessfulOrderCompletion(),
				"Back Home");
	}

}
