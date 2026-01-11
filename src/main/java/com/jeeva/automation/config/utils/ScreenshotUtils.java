package com.jeeva.automation.config.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
    private static final String SCREENSHOT_PATH = "target/screenshots/";

    public static String takeScreenshot(WebDriver driver, String testName) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(SCREENSHOT_PATH + screenshotName);

            FileUtils.copyFile(src, dest);
            return dest.getAbsolutePath();

        } catch (IOException e) {
            System.err.println("Screenshot capture failed: " + e.getMessage());
            return null;
        }
    }
}
