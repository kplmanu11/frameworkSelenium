/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

/**
 * @author kapil.neupane
 *
 */
public class LoginPage extends BaseClass {

	@FindBy(id = "email")
	WebElement email;

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
	
	public void login(String uname, String pswd) {
		email.sendKeys("");
	}

}
