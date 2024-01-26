package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ui.pages.LoginPage;

public class LoginTest {

	private WebDriver wd;
	private LoginPage loginPage;
	private SoftAssert softAssert;

	@BeforeMethod(description = "Setup the Browser and load the page")
	public void setup() {
		wd = new ChromeDriver();
		loginPage = new LoginPage(wd);
	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

	@Test(description = "Validate successful login")
	public void testLoginForWebSite() {
		Assert.assertEquals(loginPage.doLogin("standard_users", "secret_sauce").isCartIconVisible(), true,"The username or password is not valid");
	}

}
