package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInStepDef {

	@When("user clicks on {string} button")
	public void user_clicks_on_button(String string) {
		Hooks.signInPage.clickSignInButton();
	}

	@Then("user should be navigated to the Sign-In page with title containing {string}")
	public void user_should_be_navigated_to_the_sign_in_page_with_title_containing(String string) {
		assertTrue(Hooks.signInPage.verifyWelcomeTitle());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) throws InterruptedException {
		Hooks.signInPage.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) throws InterruptedException {
		Hooks.signInPage.enterPassword(password);
	}

	@When("user clicks on Sign-In button")
	public void user_clicks_on_sign_in_button() throws InterruptedException {
		Hooks.signInPage.clickUserSignInButton();
		
	}


}
