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

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Page {

	protected static WebDriver driver;
	String OriginalPass = "marYgaq!1";
	String mannagerId = "mngr225054";
	
	Page() {
		System.setProperty("webdriver.chrome.driver", "E:\\java\\ChromeDriver.exe");
		this.driver = driver;

	}

	public static void AssertTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}
	
	public static void AssertPopup(String expectedPopup) {
		String actualpopup = driver.switchTo().alert().getText();
		System.out.println(actualpopup); //For self Checks
		assertEquals(expectedPopup, actualpopup);
		driver.switchTo().alert().accept();

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
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public String RandomEmail() {
		  
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 15;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    generatedString = generatedString + "@oran.com";
	    
	    return generatedString;
	}
	public String DodayDate() {
	// Create object of SimpleDateFormat class and decide the format
	 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	 //get current date time with Date()
	 Date date = new Date();
	 // Now format the date
	 String date1= dateFormat.format(date);
	return date1;
	}
	
	public String DateMinusTwoMounth() {
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH, -60);
    Date dateminus60 = cal.getTime();
	 String date= dateFormat.format(dateminus60);
	return date;

	}


}