package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.fdmgroup.data.DataFile;
import com.fdmgroup.pages.MortgagePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MortgageCalcStepDef extends MortgagePage {

	public MortgageCalcStepDef() {
		super(Hooks.driver);
	}

	public MortgageCalcStepDef(WebDriver driver) {
		super(driver);
	}

	@Then("user should be navigated to the Mortgage Calculator page")
	public void user_should_be_navigated_to_the_mortgage_calculator_page() {
		assertTrue(Hooks.mortgagePage.isMortgageTitleDisplayed());
	}

	@Then("the page title should contain {string}")
	public void the_page_title_should_contain(String string) throws InterruptedException {

		assertEquals(string, Hooks.mortgagePage.getMortgageTitle());
		Thread.sleep(2000);
	}

	@Given("user is on Mortgage page")
	public void user_is_on_mortgage_page() throws InterruptedException {

		Hooks.driver.navigate().to(DataFile.mortgageURL);
		Thread.sleep(5000);

	}

	@When("user selects payment frequency")
	public void user_selects_payment_frequency() throws InterruptedException {
		this.scrollAndSwitchToCalculatorFrame();
		Hooks.mortgagePage.selectPaymentFrequency();
	}

	@When("user selects type of mortgage")
	public void user_selects_type_of_mortgage() throws InterruptedException {
		Hooks.mortgagePage.selectTypeOfMortgage();

	}

	@Then("the monthly payment displayed should be correct")
	public void the_monthly_payment_displayed_should_be() throws InterruptedException {
		Hooks.mortgagePage.verifyMonthlyPayment();
		assertEquals(DataFile.expectedMonthlyPayment, Hooks.mortgagePage.verifyMonthlyPayment());

	}

}
