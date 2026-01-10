package com.jeeva.automation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jeeva.automation.config.ConfigReader;
import com.jeeva.automation.config.utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver(ConfigReader.getBrowser());
        driver.get(ConfigReader.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
