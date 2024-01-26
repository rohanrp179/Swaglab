package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.LoginPage;

public class HomePageTest {

	private WebDriver wd;
	private LoginPage loginPage;

	@BeforeMethod(description = "Setup the Browser and load the page")
	public void setup() {
		wd = new ChromeDriver();
		loginPage = new LoginPage(wd);
	}

	@AfterMethod
	public void tearDown() {
//		wd.quit();
	}

	@Test(description = "Validate product successfully added to cart", groups = { "sanity" })
	public void testAddingProductToCart() {
		loginPage.doLogin("standard_user", "secret_sauce").addProductToCart().clickOnCartIcon();
	}
	
	@Test(description = "Validate product removal on clicking on remove button") 
	public void testRemoveButtonFunctionality() {
		loginPage.doLogin("standard_user", "secret_sauce").addProductToCart().clickOnCartIcon().clickOnRemoveProduct();
	}

}
