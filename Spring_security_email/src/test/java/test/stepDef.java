package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDef extends config{
	
	String url = "";
	WebDriver driver = null;
	//WebDriverWait wait = null;
	@Before
	public void initialise() {
		System.setProperty("webdriver.gecko.driver","/home/aswatth/Downloads/geckodriver");
		driver = new FirefoxDriver();
		 //wait = new WebDriverWait(driver, 3);
	}
	
	@Given("I am in home page")
	public void i_am_in_homePage() {
		driver.get(URL);
		}
	
	@When("I click login")
	public void i_click_login() {
		WebElement element = driver.findElement(By.id("LOGIN"));
		element.submit();
		new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(URL+"login"));
		url = driver.getCurrentUrl();
		//url = URL+"login";
	}
	@Then("I should see login {string}")
	public void i_should_see_logIn(String result) {
		assertEquals(result, url);
	}
	@Given("I am in login page")
	public void i_am_in_loginPage() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(URL+"login"));
		url = driver.getCurrentUrl();
		driver.get(url);
	}
	@When("I enter {string} and {string}")
	public void enter_credentials(String mailId,String password) {
		WebElement loginForm = driver.findElement(By.id("loginForm"));
		loginForm.findElement(By.name("username")).sendKeys(mailId);
		loginForm.findElement(By.name("password")).sendKeys(password);
		loginForm.submit();
		new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(URL+"home"));
		url = driver.getCurrentUrl();		
	}
	@Then("I should see {string}")
	public void i_should_see_home(String result) {
		assertEquals(result, url);
		//System.out.println(driver.getCurrentUrl());
	}
	
	@When("I click signUp")
	public void i_click_signUp(){
		driver.findElement(By.id("SIGNUP")).submit();
		new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(URL+"signup"));
		url = driver.getCurrentUrl();
		//url = URL+"signUp";
	}
	@Then("I should see signUp {string}")
	public void i_see_signUp_page(String signUpUrl) {
		assertEquals(signUpUrl, url);
	}
	@And("I enter {string} {string} {string}")
	public void signUp_Form(String name,String mailId, String password) {
		driver.get(url);
		WebElement signUpForm = driver.findElement(By.id("SIGN_UP"));
		signUpForm.findElement(By.name("name")).sendKeys(name);
		signUpForm.findElement(By.name("mailID")).sendKeys(mailId);
		signUpForm.findElement(By.name("password")).sendKeys(password);
		signUpForm.submit();
		new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(URL+"login"));
		url = driver.getCurrentUrl();
	}
	@When("I click logout")
	public void logout_click() {
		driver.findElement(By.linkText("Logout")).click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(URL+"login"));
		url = driver.getCurrentUrl();
	}
	@After
	public void closeConnections() {
		driver.close();
	}

}
