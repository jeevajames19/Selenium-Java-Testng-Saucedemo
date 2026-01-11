package com.jeeva.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jeeva.automation.config.ConfigReader;
import com.jeeva.automation.config.utils.DriverFactory;

public class BaseTest {
    public WebDriver driver;

//    @BeforeMethod
//    public void setUp() {
//        driver = DriverFactory.getDriver(ConfigReader.getBrowser());
//        driver.get(ConfigReader.getUrl());
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverFactory.getDriver(ConfigReader.getBrowser());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.getUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
