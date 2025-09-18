package drivers;

import org.openqa.selenium.WebDriver;

/*
 * 1. ThreadLocal
 * 2. get driver
 * 3. set driver
 * 4. quit driver
 */
public class DriverManager {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	// set driver
	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}

	// get driver
	public static WebDriver getDriver() {
		return driver.get();
	}

	// quit driver
	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
}
