package com.newTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="firstName")
	private WebElement firstNameTxt;
	
	@FindBy(name="lastName")
	private WebElement lastNameTxt;

	@FindBy(name="email")
	private WebElement userNameTxt;
	
	@FindBy(name="password")
	private WebElement passwordTxt;

	@FindBy(name="confirmPassword")
	private WebElement confirmPasswordTxt;

	@FindBy(name="register")
	private WebElement submitButton;	
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void goTo(String url){
		this.driver.get(url);
		this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
	}
	
	public void enterUserDetails(String firstName, String lastName) {
		this.firstNameTxt.sendKeys(firstName);
		this.lastNameTxt.sendKeys(lastName);
	}
	
	public void enterUserCreds(String username, String pwd) {
		this.userNameTxt.sendKeys(username);
		this.passwordTxt.sendKeys(pwd);
		this.confirmPasswordTxt.sendKeys(pwd);
	}
	
	public void submit()
	{
		this.submitButton.click();
	}

}
