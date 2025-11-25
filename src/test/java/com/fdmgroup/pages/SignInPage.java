package com.fdmgroup.pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

	WebDriver driver;
	WebDriverWait wait;

	public SignInPage(WebDriver driver) {
		super();
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class,'btn-signin') and contains(@class,'desktop') and normalize-space()='Sign In']")
	private WebElement signInbutton;
	
	@FindBy(xpath = "//h1[text()='Welcome to']")
	private WebElement welcomeTitle;
	
	@FindBy(xpath = "//input[@id='usernameInput-input']")
	private WebElement usernameField;
	
	@FindBy(xpath = "//input[@id='password-input']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//button[@id='signIn']")
	private WebElement usersignInButton;
	
	@FindBy(xpath = "//span[contains(text(),'Please enter your username or card number.')]")
	private WebElement errorMessageUserName;
	
	@FindBy(xpath = "//span[contains(text(),'Please enter your password')]")
	private WebElement errorMessagePassword;
	
	@FindBy(xpath = "//div[contains(text(),'Please check your card number / username or password and try again.')]")
	private WebElement errorMessageBoth;
	
	
	
	
	public void clickSignInButton() {
		signInbutton.click();
	}
	
	public boolean verifyWelcomeTitle() {
		return welcomeTitle.isDisplayed();
	}
	
	public void enterUsername(String username) throws InterruptedException {
		usernameField.sendKeys(username);
		Thread.sleep(3000);
		
		
	}

	public void enterPassword(String password) throws InterruptedException {
		passwordField.sendKeys(password);
		Thread.sleep(3000);
		
	}
	
	public void clickUserSignInButton() throws InterruptedException {
		usersignInButton.click();
		Thread.sleep(3000);
	}
	
	
}
