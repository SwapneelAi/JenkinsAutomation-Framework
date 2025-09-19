package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginUserPage extends BasePage {

	// Constructor
	public LoginUserPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	private By homePageLogoField = By.xpath("//img[@alt='Website for automation practice']");
	private By signupLoginBtn = By.cssSelector("a[href='/login']");
	private By loginToYourAccountTextField = By.xpath("//h2[text()='Login to your account']");
	private By emailAddressField = By.cssSelector("input[data-qa='login-email']");
	private By passwordField = By.cssSelector("input[data-qa='login-password']");
	private By loginButtonField = By.cssSelector("button[data-qa='login-button']");
	private By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
	private By deleteAccountBtn = By.xpath("//a[text()=' Delete Account']");
	private By accountDeletedText = By.xpath("//b[text()='Account Deleted!']");
	
	
	// Actions
	public boolean isHomepageVisible() {
		return isDisplayed(homePageLogoField);
	}
	
	public void clickSignupLogin() {
		click(signupLoginBtn);
	}
	
	public boolean isLoginToYourAccountVisible() {
		return isDisplayed(loginToYourAccountTextField);
	}

	public void enterEmailAddressPassword(String email, String password) {
		typeText(emailAddressField, email);
		typeText(passwordField, password);
	}
	
	public void clickLoginButton() {
		click(loginButtonField);
	}
	
	public boolean loggedinAsVisible() {
		return isDisplayed(loggedInAs);
	}
	
	public void clickDeleteAccountButton() {
		click(deleteAccountBtn);
	}
	
	public boolean isAccountDeletedText() {
		return isDisplayed(accountDeletedText);
	}
}