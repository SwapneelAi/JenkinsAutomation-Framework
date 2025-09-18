package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterUserPage extends BasePage {

	// Constructor
	public RegisterUserPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	private By homePageLogo = By.cssSelector("img[alt='Website for automation practice']");
	private By signupLoginBtn = By.cssSelector("a[href='/login']");
	private By newUserSignupText = By.xpath("//h2[text()='New User Signup!']");
	private By nameField = By.cssSelector("input[name='name']");
	private By emailField = By.cssSelector("input[data-qa='signup-email']");
	private By signupBtn = By.xpath("//button[text()='Signup']");
	private By enterAccountInfoText = By.xpath("//b[text()='Enter Account Information']");
	private By titleMr = By.id("id_gender1");
	private By titleMrs = By.id("id_gender2");
	private By passwordField = By.id("password");
	private By daysDropdown = By.id("days");
	private By monthsDropdown = By.id("months");
	private By yearsDropdown = By.id("years");
	private By newsletterCheckbox = By.id("newsletter");
	private By offersCheckbox = By.id("optin");
	private By firstNameField = By.id("first_name");
	private By lastNameField = By.id("last_name");
	private By companyField = By.id("company");
	private By address1Field = By.id("address1");
	private By address2Field = By.id("address2");
	private By country = By.id("country");
	private By state = By.id("state");
	private By city = By.id("city");
	private By zipcode = By.id("zipcode");
	private By mobileNumber = By.id("mobile_number");
	private By createAccountBtn = By.xpath("//button[text()='Create Account']");
	private By accountCreatedText = By.xpath("//b[text()='Account Created!']");
	private By continueBtn = By.xpath("//a[@data-qa='continue-button']");
	private By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
	private By deleteAccountBtn = By.xpath("//a[text()=' Delete Account']");
	private By accountDeletedText = By.xpath("//b[text()='Account Deleted!']");

	// Actions
	public boolean isHomePageIsVisible() {
		return isDisplayed(homePageLogo);
	}

	public void clickSignupLogin() {
		click(signupLoginBtn);
	}

	public boolean isNewUserSignupVisible() {
		return isDisplayed(newUserSignupText);
	}

	public void enterNameAndEmail(String name, String email) {
		typeText(nameField, name);
		typeText(emailField, email);
	}

	public void clickSignupBtn() {
		click(signupBtn);
	}

	public boolean isEnterAccountInformationVisible() {
		return isDisplayed(enterAccountInfoText);
	}

	public void fillAccountInfo(String password, int day, String monthVal, String yearVal) {
		click(titleMr);
		typeText(passwordField, password);
		selectDropdownByIndex(daysDropdown, day);
		selectDropdown(monthsDropdown, monthVal);
		selectDropdownByValue(yearsDropdown, yearVal);
	}

	public void selectNewsletter() {
		click(newsletterCheckbox);
	}

	public void selectOffers() {
		click(offersCheckbox);
	}

	public void fillAddressInformation(String firstName, String lastName, String company, String address1,
			String address2, String countryVal, String stateVal, String cityVal, String zip, String mobile) {
		typeText(firstNameField, firstName);
		typeText(lastNameField, lastName);
		typeText(companyField, company);
		typeText(address1Field, address1);
		typeText(address2Field, address2);
		selectDropdown(country, countryVal);
		typeText(state, stateVal);
		typeText(city, cityVal);
		typeText(zipcode, zip);
		typeText(mobileNumber, mobile);
	}

	public void clickCreateAcccount() {
		click(createAccountBtn);
	}

	public boolean isAccountCreatedVisible() {
		return isDisplayed(accountCreatedText);
	}

	public void clickContinueBtn() {
		click(continueBtn);
	}

	public boolean isLoggedInVisible() {
		return isDisplayed(loggedInAs);
	}

	public void clickDeleteAccount() {
		click(deleteAccountBtn);
	}

	public boolean isAccountDeletedVisible() {
		return isDisplayed(accountDeletedText);
	}

}
