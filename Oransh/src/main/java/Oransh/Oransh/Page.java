package Oransh.Oransh;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
			
		public static void AddNewCustomerButton() {
			driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
		}
		public static void NewCustomerDetails(String CustomerName, String Birthdate, String Address, String City, String Pin, String Mobile, String Email, String State, String password) {
			driver.findElement(By.name("name")).sendKeys(CustomerName);
			driver.findElement(By.name("dob")).sendKeys(Birthdate);
			driver.findElement(By.name("addr")).sendKeys(Address);
			driver.findElement(By.name("city")).sendKeys(City);
			driver.findElement(By.name("state")).sendKeys(State);
			driver.findElement(By.name("pinno")).sendKeys(Pin);
			driver.findElement(By.name("telephoneno")).sendKeys(Mobile);
			driver.findElement(By.name("emailid")).sendKeys(Email);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("sub")).click();
		}

}