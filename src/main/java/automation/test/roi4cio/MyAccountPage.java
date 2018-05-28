package automation.test.roi4cio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.allure.annotations.Step;

public class MyAccountPage {

	private WebDriver driver;

	@FindBy(css = "#edit > div:nth-child(22) > div.five.wide.field")
	private WebElement companyStatus;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@Step("Verify your company status in My account page")
	public String getLoggedUserCompanyStatus() {
		return companyStatus.getText();
	}

}
