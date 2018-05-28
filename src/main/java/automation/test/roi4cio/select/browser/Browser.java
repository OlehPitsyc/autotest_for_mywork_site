package automation.test.roi4cio.select.browser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver getDriver() {
		String browser = System.getProperty("browser");

		if (browser == null)
			return getFireFoxDriver();
		switch (browser) {
		case "firefox":
			return getFireFoxDriver();
		case "chrome":
			return getChromeDriver();
		default:
			throw new RuntimeException("\nUnsupported browser: " + browser + "\n");
		}
	}

	private static WebDriver getFireFoxDriver() {
		String pathSeparator = File.separator;
		String pathToDriver = "assets" + pathSeparator + "webdriver" + pathSeparator + "FireFox" + pathSeparator
				+ "win64" + pathSeparator + "geckodriver(old).exe";
		System.setProperty("webdriver.gecko.driver", pathToDriver);

		return new FirefoxDriver();

	}

	private static WebDriver getChromeDriver() {
		String pathSeparator = File.separator;

		// add verifying of local OS and change path To Driver by adding the additional
		// conditions
		String pathToDriver = "assets" + pathSeparator + "webdriver" + pathSeparator + "Chrome" + pathSeparator + "win"
				+ pathSeparator + "chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", pathToDriver);

		return new ChromeDriver();

	}
	// information about my local os
	/*
	 * public static void main(String[] args) {
	 * System.out.println(System.getProperty("os.name")); }
	 */
}
