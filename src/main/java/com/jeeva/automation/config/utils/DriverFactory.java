package com.jeeva.automation.config.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	  private static WebDriver driver;
	  

	    public static WebDriver getDriver(String browser) {
	        if (browser == null || browser.isEmpty()) {
	            throw new RuntimeException("Browser not specified in config.properties!");
	        }

	        switch (browser.toLowerCase()) {
	            case "chrome":
	                // Force version to match your Chrome
	            	WebDriverManager.chromedriver().clearResolutionCache().setup();
	            	driver = new ChromeDriver();
	                  break;
	            case "edge":
	                // Force version to match your firefox
	            	WebDriverManager.edgedriver().setup();
	                driver = new EdgeDriver();
	                break; 
	                
	            default:
	                throw new RuntimeException("Only Chrome is supported currently.");
	        }

	        driver.manage().window().maximize();
	        return driver;
	    }

	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
}
