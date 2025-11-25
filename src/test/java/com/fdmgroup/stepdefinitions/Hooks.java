package com.fdmgroup.stepdefinitions;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.fdmgroup.pages.HomePage;
import com.fdmgroup.pages.MortgagePage;
import com.fdmgroup.pages.SignInPage;
import com.fdmgroup.utilities.DriverUtilities;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;



public class Hooks {

	static DriverUtilities driverUtilities;
	static WebDriver driver;

	static HomePage homePage;
	static MortgagePage mortgagePage;
	static SignInPage signInPage;
	public static Actions actions;
	
	@BeforeAll
	public static void init() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
		
		
		homePage = new HomePage(driver);
		mortgagePage = new MortgagePage(driver);
		signInPage = new SignInPage(driver);
		actions = new Actions(driver);

		driver.manage().window().maximize();
	}

	
	@After(order = 1)
	public void saveScreenshot(Scenario scenario) throws IOException {
	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File dest = new File("C:\\Users\\appun\\eclipse-workspace\\ScotiaBankProj\\src\\test\\resources\\images" + scenario.getName() + ".png");
	    FileHandler.copy(src, dest);
	}
	
	
	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
	
	
}
