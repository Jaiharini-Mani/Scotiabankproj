package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankAccNavigation_Stedef {

	@Given("user is on the Scotiabank Personal Banking home page")
	public void user_is_on_the_scotiabank_personal_banking_home_page() throws InterruptedException {
		Hooks.driver.navigate().to(DataFile.homeURL);
		Thread.sleep(2000);
	}

	@Given("Scotiabank logo is displayed")
	public void scotiabank_logo_is_displayed() throws InterruptedException {
		assertTrue(Hooks.homePage.isLogoDisplayed());
		Thread.sleep(2000);
	}

	@When("user hovers mouse over the {string} menu option")
	public void user_hovers_mouse_over_the_menu_option(String menu) throws InterruptedException {
		WebElement menuElement = Hooks.driver.findElement(By.xpath("//a[.//span[text()='" + menu + "']]"));
		Hooks.actions.moveToElement(menuElement).perform();
		Thread.sleep(5000);
	}

	@When("user clicks on {string} from the dropdown")
	public void user_clicks_on_from_the_dropdown(String option) {
		WebElement optionElement = Hooks.driver.findElement(By.xpath("//a[normalize-space()='" + option + "']"));
		Hooks.actions.moveToElement(optionElement).click().perform();

	}

	@Then("user should be navigated to the Chequing Accounts page with title containing {string}")
	public void user_should_be_navigated_to_the_chequing_accounts_page_with_title_containing(String string) {

		assertEquals(string, Hooks.homePage.getChequingTitle());
	}

	@When("user clicks {string} on the {string}")
	public void user_clicks_on_the(String string, String string2) {

		Hooks.homePage.openChequingAccount();
	}

	@When("user selects {string} on the application question")
	public void user_selects_on_the_application_question(String string) {
		Hooks.homePage.getNoProducts();
	}

	@Then("{string} button should be displayed")
	public void button_should_be_displayed(String string) throws InterruptedException {
		assertTrue(Hooks.homePage.newCustButton());
		Thread.sleep(2000);
	}

	@When("user clicks on {string}")
	public void user_clicks_on(String string) throws InterruptedException {
		Hooks.homePage.newCustButtonClick();
		Thread.sleep(3000);
	}

	@Then("the page header should contain {string}")
	public void the_page_header_should_contain(String string) throws InterruptedException {
		assertTrue(Hooks.homePage.isStatusDisplayed());
		Thread.sleep(3000);
	}

	@When("user selects {string} on the citizenship question")
	public void user_selects_on_the_citizenship_question(String string) throws InterruptedException {
		Hooks.homePage.citizenButton();
		Thread.sleep(2000);
	}

	@When("user selects immigration status {string}")
	public void user_selects_immigration_status(String string) throws InterruptedException {
		Hooks.homePage.selectImmigrationStatus(string);
		Thread.sleep(2000);
	}

	@When("user clicks {string}")
	public void user_clicks(String string) throws InterruptedException {
		Hooks.homePage.clickContinueButton();
		Thread.sleep(2000);

	}

	@Then("the message {string} should be displayed")
	public void the_message_should_be_displayed(String string) {
		String actualText = Hooks.homePage.getErrorMessageText();
		assertEquals(string, actualText);
	}

}
