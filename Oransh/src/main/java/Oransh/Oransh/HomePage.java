package Oransh.Oransh;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

import junit.framework.Assert;

public class HomePage extends Page {
	public static final String HOMEPAGETITLE = "Guru99 Bank Manager HomePage";

	public static void isHomePage() throws IOException {

		try {
			String alertMessage = driver.switchTo().alert().getText();
			System.out.println("Test case : Failed");
			AssertPopup("User or Password is not valid");
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			if (driver.getTitle().equalsIgnoreCase(HOMEPAGETITLE)) {
				System.out.println("Test case: Passed");
				HomePage.takeScreenshot("E:\\java\\homePage.png");
				popUpMassage();
				driver.switchTo().alert().accept();
			}
		}

	}

	public static void popUpMassage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('Welcome mngr225054');");
	}
}
