package com.onmobile.rbt.common;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass implements Details {
	public WebDriver driver = null;

	@BeforeSuite
	@Parameters({ "browser" })
	public WebDriver launchBrowser() {

		HashMap<String, Object> ltOptions = new HashMap<String, Object>();

		switch (Browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOtions = new ChromeOptions();
			chromeOtions.addArguments("--remote-allow-origins=*");
			ltOptions.put("build", "SSL certificates Using Selenium WebDriver");
			ltOptions.put("name", "Handling on Chrome");
			chromeOtions.setCapability("LT:Options", ltOptions);
			chromeOtions.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(chromeOtions);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxptions = new FirefoxOptions();
			firefoxptions.addArguments("--remote-allow-origins=*");
			firefoxptions.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(firefoxptions);
			break;

		default:
			break;
		}

		return driver;

	}

	@AfterSuite()
	public void name(ITestContext status) throws Exception {
		if (ITestResult.FAILURE == 2) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File capturedScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(capturedScreenshot, new File(System.getProperty("user.dir")
					+ "//src//test//resources//FiledScreenShots//screenShot2_" + System.currentTimeMillis() + ".png"));
		}
		if (driver != null) {
			driver.close();

		}
	}

}
