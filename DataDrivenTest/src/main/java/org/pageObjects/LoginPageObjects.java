package org.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	@FindBy(xpath = "//input[@name='username']")
	public WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	public WebElement passWord;
	@FindBy(xpath = "//div[@class='oxd-form-actions orangehrm-login-action']//button")
	public WebElement login;

//	public LoginPageObjects(WebDriver driver) {
//		this.initialize(driver);
//	}

	public LoginPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//	public void initialize(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}

	public void givePassWord(String passWord2) {
		passWord.sendKeys(passWord2);
	}

	public void loginButton() {
		login.click();
	}

	public void giveUserName(String userName2) {
		userName.sendKeys(userName2);
	}
}
