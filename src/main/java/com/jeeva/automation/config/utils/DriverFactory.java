//package com.jeeva.automation.config.utils;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class DriverFactory {
//
//	  private static WebDriver driver;
//	  
//
//	    public static WebDriver getDriver(String browser) {
//	        if (browser == null || browser.isEmpty()) {
//	            throw new RuntimeException("Browser not specified in config.properties!");
//	        }
//
//	        switch (browser.toLowerCase()) {
//	            case "chrome":
//	                // Force version to match your Chrome
//	            	WebDriverManager.chromedriver().clearResolutionCache().setup();
//	            	driver = new ChromeDriver();
//	                  break;
//	            case "edge":
//	                // Force version to match your firefox
//	            	WebDriverManager.edgedriver().setup();
//	                driver = new EdgeDriver();
//	                break; 
//	                
//	            default:
//	                throw new RuntimeException("Only Chrome is supported currently.");
//	        }
//
//	        driver.manage().window().maximize();
//	        return driver;
//	    }
//
//	    public static void quitDriver() {
//	        if (driver != null) {
//	            driver.quit();
//	            driver = null;
//	        }
//	    }
//}

package com.jeeva.automation.config.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        if (browser == null || browser.isEmpty()) {
            throw new RuntimeException("Browser not specified!");
        }

        switch (browser.toLowerCase()) {
        case "chrome":
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(chromeOptions);

//        	WebDriverManager.chromedriver().clearResolutionCache().setup();
//            driver = new ChromeDriver();
            break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
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
