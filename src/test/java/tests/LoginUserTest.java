package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginUserPage;

public class LoginUserTest extends BaseTest{

	@Test
	@Parameters({"email", "password"})
	public void testLoginUser(String email, String password) {
		// object
		LoginUserPage loginUserPage = new LoginUserPage(driver);
		
		Assert.assertTrue(loginUserPage.isHomepageVisible(), "Home page is not visible");
		loginUserPage.clickSignupLogin();
		Assert.assertTrue(loginUserPage.isLoginToYourAccountVisible(), "'Login to your account' not visible");
		loginUserPage.enterEmailAddressPassword(email, password);
		loginUserPage.clickLoginButton();
		Assert.assertTrue(loginUserPage.loggedinAsVisible(), "'Logged in as username' not visible");
		loginUserPage.clickDeleteAccountButton();
		Assert.assertTrue(loginUserPage.isAccountDeletedText(), "Account deleted is not visible");
	}
}