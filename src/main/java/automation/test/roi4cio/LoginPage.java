package automation.test.roi4cio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.test.roi4cio.userdata.UserModel;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage {

	private WebDriver driver;

	private UserModel user;

	@FindBy(css = ".ui.segment")
	private WebElement loginForm;

	@FindBy(css = "#user")
	private WebElement loginEmail;

	@FindBy(css = "#pass")
	private WebElement password;

	@FindBy(name = "submit")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@Step("Verife if login form is displayed")
	public boolean isLoginFormDisplayed() {
		return loginForm.isDisplayed();
	}

	@Step("Enter your credential to loggin on the roi4cio site ")
	public MyAccountPage loginAs(UserModel user) {
		loginEmail.sendKeys(user.getUsername());
		password.sendKeys(user.getPassword());
		loginButton.click();
		return new MyAccountPage(driver);

	}

}
