/**
 * 
 */
package com.mystore.actiondriver;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;

import com.mystore.actioninterface.ActionInterface;
import com.mystore.base.BaseClass;

/**
 * @author kapil.neupane
 *
 */
public class Action extends BaseClass implements ActionInterface {

	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoViee();", ele);

	}

	public void click(WebDriver ldriver, WebElement ele) {
		// TODO Auto-generated method stub
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}

	public boolean isDisplayed(WebDriver ldriver, WebElement ele) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = findElement(ldriver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is displayed");
			} else {
				System.out.println("The element is not displayed");
			}
		} else {
			System.out.println("Not displayed");
		}
		return flag;
	}

	public boolean type(WebElement ele, String text) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Locator not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter the value");
			}
		}

		return flag;
	}

	public boolean findElement(WebDriver ldriver, WebElement ele) {
		// TODO Auto-generated method stub
		boolean flag = false;

		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully foud element at");
			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}

	public boolean isSelected(WebDriver ldriver, WebElement ele) {
		// TODO Auto-generated method stub
		boolean flag = false;

		flag = findElement(ldriver, ele);
		if (flag) {
			flag = ele.isSelected();
			if (flag) {
				System.out.println("The element is selected");
			} else {
				System.out.println("The element is not selected");
			}
		} else {
			System.out.println("Not selected");
		}
		return flag;
	}

	public boolean isEnabled(WebDriver ldriver, WebElement ele) {
		// TODO Auto-generated method stub

		boolean flag = false;
		flag = findElement(ldriver, ele);

		if (flag) {
			ele.isEnabled();
			if (flag) {
				System.out.print("The element is enabled");
			} else {
				System.out.println("The element is not enabled");
			}
		} else {
			System.out.println("Not Enabled");
		}
		return flag;
	}

	public boolean selectBySendKeys(String value, WebElement ele) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from the dropdown");
			} else {
				System.out.println("Value cannot be selected from the dropdown");
			}
		}

	}

	public boolean selectbyIndex(WebElement element, int index) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by index");
			} else {
				System.out.println("Option not selected by index");
			}
		}
	}

	public boolean selectByValue(WebElement element, String value) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;

		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by value");
			} else {
				System.out.println("Option not selected by value");
			}
		}

	}

	public boolean selectByVisibleText(String visibleText, WebElement ele) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibleText);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;

		} finally {
			if (flag) {
				System.out.println("Element selected by the visible text");
			} else {
				System.out.println("Element not selecte by the visible text");
			}
		}

	}

	public boolean mouseHoverByJavaScript(WebElement ele) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("MouseOver Action is performed");
			} else {
				System.out.println("MouseOver Action is not performed");
			}
		}
	}

	public boolean JSClick(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			// driver.executeAsyncScript("arguments[0].click();", element);

			flag = true;

		}

		catch (Exception e) {
			return false;

		} finally {
			if (flag) {
				System.out.println("Click Action is performed");
			} else if (!flag) {
				System.out.println("Click Action is not performed");
			}
		}
		return flag;
	}

	public boolean switchToFrameByIndex(WebDriver driver, int index) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(index);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with index \"" + index + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + index + "\" is not selected");
			}
		}
	}

	public boolean switchToFrameById(WebDriver driver, String idValue) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			driver.switchTo().frame(idValue);
			flag = true;
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Id \"" + idValue + "\" is selected");
			} else {
				System.out.println("Frame with Id \"" + idValue + "\" is not selected");
			}
		}
	}

	public boolean switchToFrameByName(WebDriver driver, String nameValue) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is selected");
			} else if (!flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
			}
		}
	}

	public boolean switchToDefaultFrame(WebDriver driver) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			} else if (!flag) {
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}
	}

	public void mouseOverElement(WebDriver driver, WebElement element) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println(" MouserOver Action is performed on ");
			} else {
				System.out.println("MouseOver action is not performed on");
			}
		}

	}

	public boolean moveToElement(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			// actions.moveToElement(driver.findElement(locator)).build().perform();
			actions.moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean mouseover(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			/*
			 * if (flag) {
			 * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
			 * +"\""); } else {
			 * failureReport("MouseOver","MouseOver action is not performed on \""
			 * +locatorName+"\""); }
			 */
		}
	}

	public boolean draggable(WebDriver driver, WebElement source, int x, int y) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(source, x, y).build().perform();
			Thread.sleep(5000);
			flag = true;
			return true;

		} catch (Exception e) {
		
			return false;
			
		} finally {
			if (flag) {
				System.out.println("Draggable Action is performed on \""+source+"\"");			
			} else if(!flag) {
				System.out.println("Draggable action is not performed on \""+source+"\"");
			}
		}
	}

	public boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("DragAndDrop Action is performed");
			} else if(!flag) {
				System.out.println("DragAndDrop Action is not performed");
			}
		}
	}

	public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
			// .perform();
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Slider Action is performed");
			} else {
				System.out.println("Slider Action is not performed");
			}
		}
	}

	public boolean rightClick(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
			// driver.findElement(by1).sendKeys(Keys.DOWN);
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("RightClick Action is performed");
			} else {
				System.out.println("RightClick Action is not performed");
			}
		}
	}

	public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			driver.switchTo().window(array[count-1]);

			if (driver.getTitle().contains(windowTitle)){
				flag = true;
			}else{
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			//flag = true;
			return false;
		} finally {
			if (flag) {
				System.out.println("Navigated to the window with title");
			} else {
				System.out.println("The Window with title is not Selected");
			}
		}
	}

	public boolean switchToNewWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Window is Navigated with title");				
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}

	public boolean switchToOldWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Window is Navigated with title");				
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}

	public int getColumnCount(WebElement row) {
		// TODO Auto-generated method stub
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;
	}

	public int getRowCount(WebElement table) {
		// TODO Auto-generated method stub
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}

	public boolean Alert(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
		
	}

	public boolean launchURL(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Successfully launched \""+url+"\"");				
			} else {
				System.out.println("Failed to launch \""+url+"\"");
			}
		}
	}

	public boolean isAlertPresent(WebDriver driver) {
		// TODO Auto-generated method stub
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catc
	}

	public String getCurrentURL(WebDriver driver) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String text = driver.getCurrentUrl();
		if(flag) {
			System.out.println("Current URL: \""+ text+"\"");
		}
		return text;
	}

	public String getTitle(WebDriver driver) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		String text = driver.getTitle();
		if(flag) {
			System.out.println("Current URL: \""+text+"\"");
		}
		return text;
	}

	public boolean click1(WebElement locator, String locatorName) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			locator.click();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Able to click on \""+locatorName+"\"");
			} else {
				System.out.println("Click Unable to click on \""+locatorName+"\"");
			}
		}
	}

	public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
		// TODO Auto-generated method stub
		Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }

	}

	public void explicitWait(WebDriver driver, WebElement element, int timeOut) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		// TODO Auto-generated method stub
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);

	}

	public String screenShot(WebDriver driver, String filename) {
		// TODO Auto-generated method stub
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return newImageString;
	}

	public String getCurrentTime() {
		// TODO Auto-generated method stub
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

	public void implicitWait(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

}
