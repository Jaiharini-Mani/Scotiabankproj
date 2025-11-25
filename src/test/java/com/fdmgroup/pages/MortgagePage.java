package com.fdmgroup.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MortgagePage {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	JavascriptExecutor js;

	public MortgagePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.actions = new Actions(driver);
		this.js = (JavascriptExecutor) driver;
	}

	@FindBy(xpath = "//h1[contains(text(),'Mortgage Calculator')]")
	private WebElement mortgagePageTitle;

	@FindBy(xpath = "//iframe[contains(@title,'Mortgage Calculator')]")
	private WebElement MortgageCalculatorIframe;

	@FindBy(xpath = "//*[@class='payment_freqM1']")
	private WebElement frequencyDropdown;

	@FindBy(xpath = "//select[@id='payment_freqM1']/option[text()='Semi-Monthly']")
	private WebElement frequencyOption;

	@FindBy(xpath = "//select[@id='productm1']")
	private WebElement typeOfMortgageDropdown;

	@FindBy(xpath = "//select[@id='productm1']/option[text()='5 year closed']")
	private WebElement typeOfMortgageOption;

	@FindBy(xpath = "//span[contains(text(),'$') and contains(text(),'semi-monthly')]")
	private WebElement monthlyPaymentField;

	public boolean isMortgageTitleDisplayed() {
		return mortgagePageTitle.isDisplayed();
	}

	public String getMortgageTitle() {
		return mortgagePageTitle.getText();
	}

	public void scrollAndSwitchToCalculatorFrame() throws InterruptedException {

		js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", MortgageCalculatorIframe);
		Thread.sleep(2000);
		driver.switchTo().frame(MortgageCalculatorIframe);

	}

	public void selectPaymentFrequency() {
		frequencyDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(frequencyOption));
		frequencyOption.click();
	}

	public void selectTypeOfMortgage() throws InterruptedException {
		typeOfMortgageDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(typeOfMortgageOption));
		typeOfMortgageOption.click();
		Thread.sleep(4000);

	}

	public String verifyMonthlyPayment() throws InterruptedException {
		return monthlyPaymentField.getText();
	}

}
