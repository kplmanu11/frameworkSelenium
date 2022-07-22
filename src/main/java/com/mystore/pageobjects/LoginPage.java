/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author kapil.neupane
 *
 */
public class LoginPage extends BaseClass {
	Action action = new Action();

	@FindBy(id = "email")
	WebElement userName;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement submitLogin;

	@FindBy(id = "email_create")
	WebElement emailForNewAccount;

	@FindBy(id = "SubmitCreate")
	WebElement createNewAccount;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname, String pswd) {
		//email.sendKeys("");
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(driver, submitLogin);
		return new HomePage();
		
	}
	
	public AccountCreationPage signIn(String emailAddress) {
		action.type(emailForNewAccount,emailAddress);
		action.click(driver, createNewAccount);
		return new AccountCreationPage();
		
	}

}
