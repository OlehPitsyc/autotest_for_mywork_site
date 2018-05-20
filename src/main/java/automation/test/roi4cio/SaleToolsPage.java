package automation.test.roi4cio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaleToolsPage {

	private WebDriver driver;

	@FindBy(css = ".top-h.header-part>div:nth-of-type(1)")
	private WebElement selectHomePageDropdown;

	public SaleToolsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String checkHomePage() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOf(selectHomePageDropdown));
		return selectHomePageDropdown.getText();

	}

}
