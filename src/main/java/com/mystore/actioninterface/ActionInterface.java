/**
 * 
 */
package com.mystore.actioninterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author kapil.neupane
 *
 */
public interface ActionInterface {

	// added all the user actions abstract methods to achieve abstraction

	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele);

	public void click(WebDriver ldriver, WebElement ele);

	public boolean isDisplayed(WebDriver ldriver, WebElement ele);

	public boolean type(WebElement ele, String text);

	public boolean findElement(WebDriver ldriver, WebElement ele);

	public boolean isSelected(WebDriver ldriver, WebElement ele);

	public boolean isEnabled(WebDriver ldriver, WebElement ele);

	public boolean selectBySendKeys(String value, WebElement ele);

	public boolean selectbyIndex(WebElement element, int Index);

	public boolean selectByValue(WebElement element, String value);

	public boolean selectByVisibleText(String visibleText, WebElement ele);

	public boolean mouseHoverByJavaScript(WebElement locator);

	public boolean JSClick(WebDriver driver, WebElement ele);

	public boolean switchToFrameByIndex(WebDriver driver, int index);

	public boolean switchToFrameById(WebDriver driver, String idValue);

	public boolean switchToFrameByName(WebDriver driver, String nameValue);

	public boolean switchToDefaultFrame(WebDriver driver);

	public void mouseOverElement(WebDriver driver, WebElement element);

	public boolean moveToElement(WebDriver driver, WebElement element);

	public boolean mouseover(WebDriver driver, WebElement ele);

	public boolean draggable(WebDriver driver, WebElement source, int x, int y);

	public boolean draganddrop(WebDriver driver, WebElement source, WebElement target);

	public boolean slider(WebDriver driver, WebElement ele, int x, int y);

	public boolean rightClick(WebDriver driver, WebElement ele);

	public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count);

	public boolean switchToNewWindow(WebDriver driver);

	public boolean switchToOldWindow(WebDriver driver);

	public int getColumnCount(WebElement column);

	public int getRowCount(WebElement row);

	public boolean Alert(WebDriver driver);

	public boolean launchURL(WebDriver driver, String url);

	public boolean isAlertPresent(WebDriver driver);

	public String getCurrentURL(WebDriver driver);

	public String getTitle(WebDriver driver);

	public boolean click1(WebElement locator, String locatorName);

	public void fluentWait(WebDriver driver, WebElement element, int timeOut);

	public void implicitWait(WebDriver driver, int timeOut);

	public void explicitWait(WebDriver driver, WebElement element, int timeOut);

	public void pageLoadTimeOut(WebDriver driver, int timeOut);

	public String screenShot(WebDriver driver, String fileName);

	public String getCurrentTime();

}
