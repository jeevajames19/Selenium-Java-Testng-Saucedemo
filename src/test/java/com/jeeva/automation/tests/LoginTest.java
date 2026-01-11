package com.jeeva.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jeeva.automation.base.BaseTest;
import com.jeeva.automation.config.ConfigReader;
import com.jeeva.automation.pages.LoginPage;

@Listeners(com.jeeva.automation.base.listeners.TestListener.class)
public class LoginTest extends BaseTest{
	@Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.vuname(), ConfigReader.vpass());
        // Add assertion for successful login
        // e.g., Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.invuname(), ConfigReader.invpass());
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Invalid username or password");
    }
}

