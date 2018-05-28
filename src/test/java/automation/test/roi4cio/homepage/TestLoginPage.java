package automation.test.roi4cio.homepage;

import static automation.test.roi4cio.userdata.UserData.*;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.test.roi4cio.HomePage;
import automation.test.roi4cio.LoginPage;
import automation.test.roi4cio.MyAccountPage;
import automation.test.roi4cio.Roi4cio;
import automation.test.roi4cio.listener.IWebApp;
import automation.test.roi4cio.listener.IWebAppTest;
import automation.test.roi4cio.userdata.UserModel;

public class TestLoginPage implements IWebAppTest {

	private Roi4cio roi4cio = new Roi4cio();
	private HomePage homePage;
	private LoginPage loginPage;
	private UserModel user;
	private MyAccountPage myAccountPage;

	@BeforeMethod
	private void openHomePage() {
		homePage = roi4cio.openHomePage();
	}

	@Test(priority = 1)
	public void testLoggedUserAsUser() throws InterruptedException {
		user = USER_COMPANY;
		loginPage = homePage.goToLoginPage();
		myAccountPage = loginPage.loginAs(user);
		Assert.assertEquals(myAccountPage.getLoggedUserCompanyStatus(), "Пользователь",
				"\nEMAIL :" + user.getUsername() + "\n should be logged in user company");

	}

	@Test(priority = 2)
	public void testLoggedUserAsSupplier() {
		loginPage = homePage.goToLoginPage();
		user = SUPPLIER_COMPANY;
		myAccountPage = loginPage.loginAs(user);
		Assert.assertEquals(myAccountPage.getLoggedUserCompanyStatus(), "Поставщик",
				"\nEMAIL :" + user.getUsername() + "\n should be logged in supplier company");

	}

	@Test(priority = 3)
	public void testLoggedUserAsVendor() {
		loginPage = homePage.goToLoginPage();
		user = VENDOR_COMPANY;
		myAccountPage = loginPage.loginAs(user);
		Assert.assertEquals(myAccountPage.getLoggedUserCompanyStatus(), "Производитель",
				"\nEMAIL :" + user.getUsername() + "\n should be logged in vendor company");
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
