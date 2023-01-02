package pageObjects;

import org.baseClass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects  {
	@FindBy(xpath="//input[@name='username']")public WebElement userName;
	@FindBy(xpath="//input[@name='password']")public WebElement passWord;
	@FindBy(xpath="//div[@class='oxd-form-actions orangehrm-login-action']//button")public WebElement loginButton;
	public LoginPageObjects(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String userName2,String passWord2) {
		userName.sendKeys(userName2);
		passWord.sendKeys(passWord2);
		loginButton.click();
		
	}
//	public void enterPassword(String passWord2) {
//		
//		
//	}
//	public void login() {
//		
//		
//	}
}
