package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;

	@BeforeTest
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void launchApp() {
		String browserName = prop.getProperty("browser");

		if (browserName.contains("Edge")) {
			driver = new EdgeDriver();

		} else if (browserName.contains("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.contains("Firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		driver.get(prop.getProperty("url"));
	}
	

	
	
	

}
