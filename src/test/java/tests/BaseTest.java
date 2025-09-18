package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import drivers.DriverFactory;

public class BaseTest {
	/*
	 * Purpose of BaseTest.java 1. To initialize WebDriver before each test. 2. To
	 * quit WebDriver after each test.
	 */
	protected WebDriver driver;
	protected Properties properties; // special class in java - read key-value pair from .properties file

	@BeforeMethod
	public void setUp() throws IOException {
		// Load config.properties
		properties = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/config.properties");

		properties.load(fs);

		// Step 1: Launch browser
		String browser = properties.getProperty("browser");
		driver = DriverFactory.initDriver(browser);

		// Step 2: Navigate to URL
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}