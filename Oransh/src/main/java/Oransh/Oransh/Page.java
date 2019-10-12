package Oransh.Oransh;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

import java.io.File;
import java.io.IOException;

public class Page {

	protected static WebDriver driver;

	Page() {
		System.setProperty("webdriver.chrome.driver", "E:\\java\\ChromeDriver.exe");
		this.driver = driver;

	}

	public static void takeScreenshot(String filename) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(filename));
	}

	public void closeBrowser() {
		driver.close();
	}

	protected void openURL(String url) {
		driver.get(url);
	}

}