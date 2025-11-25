package com.fdmgroup.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverUtilities {
	private static DriverUtilities driverUtilities;
	private WebDriver webDriver;

	private DriverUtilities() {
		super();

	}

	public static DriverUtilities getInstance() {

		if (driverUtilities == null) {
			driverUtilities = new DriverUtilities();
		}
		return driverUtilities;

	}

	// creating driver

	public WebDriver getDriver() {

		if (webDriver == null) {
			createWebDriver();
		}

		return webDriver;
	}

	private void createWebDriver() {
		String driverName = getDriverName();

		switch (driverName) {
		case "Chrome":
			this.webDriver = new ChromeDriver();
			break;
		case "Edge":
			this.webDriver = new EdgeDriver();
			break;


		default:
			break;

		}

	}

	private String getDriverName() {

		Properties config = new Properties();

		try {
			config.load(new FileInputStream("src/test/resources/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return config.getProperty("browser");

	}

}
