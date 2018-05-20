package automation.test.roi4cio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage {

	private WebDriver driver;

	@FindBy(css = ".ui.segment")
	private WebElement loginForm;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Step("Verife if login form is displayed")
	public boolean isLoginFormDisplayed() {
		return loginForm.isDisplayed();
	}
}
