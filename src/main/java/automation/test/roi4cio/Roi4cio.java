package automation.test.roi4cio;

import org.openqa.selenium.WebDriver;

import automation.test.roi4cio.select.browser.Browser;
import ru.yandex.qatools.allure.annotations.Step;

public class Roi4cio {

	private WebDriver driver;
	private static final String baseUrl = "http://roi-test.my-dev.org/";

	@Step("Open roi4cio home page: " + baseUrl)
	public HomePage openHomePage() {
		driver = Browser.getDriver();
		driver.get(baseUrl);
		return new HomePage(driver);

	}

	public void close() {
		if (this.driver != null)
			this.driver.quit();
		this.driver = null;
	}
}
