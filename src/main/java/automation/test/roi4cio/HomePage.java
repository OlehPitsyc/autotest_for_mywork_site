package automation.test.roi4cio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Step;

public class HomePage {

	private WebDriver driver;

	@FindBy(css = ".top-h.header-part>div:nth-of-type(1)")
	private WebElement selectHomePageDropdown;

	@FindBy(css = ".scrolling.menu.transition.visible>a:nth-child(1)")
	private WebElement goToSalesToolLink;

	@FindBy(css = ".item-btn")
	private WebElement goToLoginPage;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@Step("Click on dropdown in header and select Sale Tools home page")
	public SaleToolsPage goToSalesToolPage() throws InterruptedException {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".image-wrapper")));
		selectHomePageDropdown.click();
		goToSalesToolLink.click();
		return new SaleToolsPage(driver);
	}

	@Step("Click on login button")
	public LoginPage goToLoginPage() {
		goToLoginPage.click();
		return new LoginPage(driver);
	}
}
