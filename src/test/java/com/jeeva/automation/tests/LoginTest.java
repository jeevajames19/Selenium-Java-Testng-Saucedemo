package com.jeeva.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jeeva.automation.base.BaseTest;
import com.jeeva.automation.pages.LoginPage;

public class LoginTest extends BaseTest{
	@Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        // Add assertion for successful login
        // e.g., Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalidUser", "invalidPass");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Invalid username or password");
    }
}
