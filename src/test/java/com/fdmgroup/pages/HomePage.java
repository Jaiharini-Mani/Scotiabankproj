package com.fdmgroup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fdmgroup.stepdefinitions.Hooks;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='h--logo']")
	private WebElement scotiabankLogo;

	@FindBy(xpath = "//h1[contains(text(),\"Discover Scotia's chequing accounts\")]")
	private WebElement chequingTitle;

	@FindBy(xpath = "//a[@id='wop-ultimate-tile-en' and .//span[contains(text(),'Open an account')]]")
	private WebElement openAccountButton;

	@FindBy(xpath = "//button[@data-testid='toggleOption-button' and .//span[text()='No']]")
	private WebElement noOption;

	@FindBy(xpath = "//button[.//span[contains(text(),'Apply as a new customer')]]")
	private WebElement applyNewCustomerButton;

	@FindBy(xpath = "//h1[@data-testid='immigration-status-triage-headline']")
	private WebElement citizenshipHeader;

	@FindBy(xpath = "//button[@data-testid='toggleOption-button' and .//span[text()='No']]")
	private WebElement citizenshipNo;

	@FindBy(xpath = "//select[@id='id-imm-category-field']")
	private WebElement immigrationDropdown;

	@FindBy(xpath = "//button[@data-testid='appnav-continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//h1[@data-testid='GenericInfoScreen--Headline']")
	private WebElement errorMessage;

	public boolean isLogoDisplayed() {
		return scotiabankLogo.isDisplayed();

	}

	public String getChequingTitle() {
		return chequingTitle.getText();
	}

	public void openChequingAccount() {
		   Hooks hooks = new Hooks();
		    hooks.closeCookiesIfPresent(driver);
		openAccountButton.click();
	}

	public void getNoProducts() {

		noOption.click();
	}

	public boolean newCustButton() {

		return applyNewCustomerButton.isDisplayed();
	}

	public void newCustButtonClick() {

		applyNewCustomerButton.click();
	}

	public boolean isStatusDisplayed() {
		return citizenshipHeader.isDisplayed();

	}

	public void citizenButton() {

		citizenshipNo.click();
	}

	public void selectImmigrationStatus(String string) {
		Select select = new Select(immigrationDropdown);
		select.selectByVisibleText(string);

	}

	public void clickContinueButton() {

		continueButton.click();

	}

	public String getErrorMessageText() {
		return errorMessage.getText();
	}

}
