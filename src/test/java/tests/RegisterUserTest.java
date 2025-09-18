package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.RegisterUserPage;

public class RegisterUserTest extends BaseTest {

	@Parameters({ "username", "email", "password", "day", "month", "year", "firstName", "lastName", "company",
			"address1", "address2", "country", "state", "city", "zipcode", "mobile" })
	@Test
	public void testRegisterUser(String username, String email, String password, int day, String monthVal,
			String yearVal, String fName, String lName, String com, String add1, String add2, String contryName,
			String stateName, String cityName, String zip, String mobile) {

		// Initialize page object AFTER driver is set up
		RegisterUserPage registerUserPage = new RegisterUserPage(driver);

		// Step 3: Verify home page is visible
		Assert.assertTrue(registerUserPage.isHomePageIsVisible(), "Home page is not visible");

		// Step 4: Click on 'Signup / Login'
		registerUserPage.clickSignupLogin();

		// Step 5: Verify 'New User Signup!' is visible
		Assert.assertTrue(registerUserPage.isNewUserSignupVisible(), "'New User Signup!' is not visible");

		// Step 6: Enter name
		registerUserPage.enterNameAndEmail(username, email);

		// Step 7: Click Signup button
		registerUserPage.clickSignupBtn();

		// Step 8: Verify 'ENTER ACCOUNT INFORMATION' is visible
		Assert.assertTrue(registerUserPage.isEnterAccountInformationVisible(),
				"'Enter Account Information' not visible");

		// Step 9: Fill details: Title, Password, Date of birth
		registerUserPage.fillAccountInfo(password, day, monthVal, yearVal);

		// Step 10: Select checkbox 'Sign up for our newsletter!'
		registerUserPage.selectNewsletter();
		// Step 11: Select checkbox 'Receive special offers from our partners!'
		registerUserPage.selectOffers();

		// Step 12: Fill Address information
		registerUserPage.fillAddressInformation(fName, lName, com, add1, add2, contryName, stateName, cityName, zip,
				mobile);

		// Step 13: Click Create Account Button
		registerUserPage.clickCreateAcccount();

		// Step 14: Verify 'ACCOUNT CREATED!' is visible
		Assert.assertTrue(registerUserPage.isAccountCreatedVisible(), "'Account Created!' not visible");

		// Step 15: Click 'Continue' button
		registerUserPage.clickContinueBtn();

		// Step 16: Verify 'Logged in as username' is visible
		Assert.assertTrue(registerUserPage.isLoggedInVisible(), "'Logged in as username' not visible");

		// Step 17: Click 'Delete Account' button
		registerUserPage.clickDeleteAccount();

		// Step 18: Verify 'ACCOUNT DELETED!' is visible
		Assert.assertTrue(registerUserPage.isAccountDeletedVisible(), "'Account Deleted!' not visible");

		// Optional: Click Continue after deletion
		registerUserPage.clickContinueBtn();
	}
}