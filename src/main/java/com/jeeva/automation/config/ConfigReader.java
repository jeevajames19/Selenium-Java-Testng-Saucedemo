package com.jeeva.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop = new Properties();

	static {
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getBrowser() {
		return prop.getProperty("browser");
	}

	public static String getUrl() {
		return prop.getProperty("url");
	}

	public static String vuname() {
		return prop.getProperty("validuname");
	}

	public static String vpass() {
		return prop.getProperty("validpass");
	}

	public static String invuname() {
		return prop.getProperty("invaliduname");
	}

	public static String invpass() {
		return prop.getProperty("invalidpass");
	}

	public static int getTimeout() {
		return Integer.parseInt(prop.getProperty("timeout"));
	}

}
