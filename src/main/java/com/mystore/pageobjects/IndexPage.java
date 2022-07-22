package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	Action action = new Action();

	// signin button
	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;

	// logo
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;

	// search
	@FindBy(id = "search_query_top")
	WebElement searchProduct;

	// search button
	@FindBy(name = "submit_search")
	WebElement submitSearchButton;

	// initialiaze all the elements

	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickOnSignIn() {
		// signInBtn.click();
		action.click(driver, signInBtn);
		return new LoginPage();

	}

	public void validateLogo() {
		// myStoreLogo.isDisplayed();
		action.isDisplayed(driver, myStoreLogo);
	}

	public String getMyStoreTitle() {
		// driver.getTitle();
		String myStoreTitle = action.getTitle(driver);
		return myStoreTitle;
	}

	public SearchResultPage searchProduct(String productName) {
		// searchProduct.sendKeys("Test");
		action.type(searchProduct, productName);
		action.click(driver, submitSearchButton);
		return new SearchResultPage();
	}

}
