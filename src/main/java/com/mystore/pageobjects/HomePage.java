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
public class HomePage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//span[contains(text(),'My wishlists')]")
	WebElement wishlList;

	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistoryAndDetails;

	// initialize the webelements
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateMyWishList() {
		return action.isDisplayed(driver, wishlList);

	}

	public boolean validateOrderHistory() {
		return action.isDisplayed(driver, orderHistoryAndDetails);
	}

}
