package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

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

	public void clickOnSignIn() {
		signInBtn.click();
	}
	
	public void validateLogo() {
		myStoreLogo.isDisplayed();
	}
	
	public void getTitle() {
		driver.getTitle();
	}
	
	public void searchProduct() {
		searchProduct.sendKeys("Test");
	}

}
