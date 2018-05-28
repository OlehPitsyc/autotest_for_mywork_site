package automation.test.roi4cio.homepage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.test.roi4cio.HomePage;
import automation.test.roi4cio.LoginPage;
import automation.test.roi4cio.Roi4cio;
import automation.test.roi4cio.SaleToolsPage;
import automation.test.roi4cio.listener.IWebApp;
import automation.test.roi4cio.listener.IWebAppTest;

public class TestHomePage implements IWebAppTest {

	Roi4cio roi4cio = new Roi4cio();
	private HomePage homePage;
	private SaleToolsPage saleToolsPage;
	private LoginPage loginPage;

	@BeforeMethod

	public void openHomePage() {
		homePage = roi4cio.openHomePage();

	}

	@Test(priority = 1)
	public void isSalesToolOpen() throws InterruptedException {
		saleToolsPage = homePage.goToSalesToolPage();
		String a = saleToolsPage.checkHomePage();
		Assert.assertEquals(a, "SalesTools");

	}

	@Test(priority = 2)
	public void isLoginPageOpen() throws InterruptedException {
		loginPage = homePage.goToLoginPage();
		Assert.assertTrue(loginPage.isLoginFormDisplayed());

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		roi4cio.close();

	}

	@Override
	public IWebApp getTestedApp() {
		return this.roi4cio;
	}
}
