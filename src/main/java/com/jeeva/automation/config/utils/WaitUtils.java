package com.jeeva.automation.config.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jeeva.automation.config.ConfigReader;

public class WaitUtils {
	private static WebDriverWait getWait(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getTimeout()));
	}

	// ---------- VISIBILITY ----------

	public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
		return getWait(driver).until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement waitForVisibility(WebDriver driver, By locator) {
		return getWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// ---------- CLICKABLE ----------

	public static WebElement waitForClickable(WebDriver driver, WebElement element) {
		return getWait(driver).until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForClickable(WebDriver driver, By locator) {
		return getWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
	}

	// ---------- PRESENCE ----------

	public static WebElement waitForPresence(WebDriver driver, By locator) {
		return getWait(driver).until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// ---------- TEXT ----------

	public static boolean waitForText(WebDriver driver, By locator, String text) {
		return getWait(driver).until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	// ---------- URL ----------

	public static boolean waitForUrlContains(WebDriver driver, String text) {
		return getWait(driver).until(ExpectedConditions.urlContains(text));
	}

	// ---------- ALERT ----------

	public static void waitForAlert(WebDriver driver) {
		getWait(driver).until(ExpectedConditions.alertIsPresent());
	}
}
