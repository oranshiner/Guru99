package Oransh.Oransh;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

import junit.framework.Assert;

public class HomePage extends Page{
	public static final String HOMEPAGETITLE = "Guru99 Bank Manager HomePage";
	static String actualTitle;

	public static void isHomePage() throws IOException {

		actualTitle = driver.getTitle();

		if (actualTitle.contains(HOMEPAGETITLE)) {
			System.out.println("Test case: Passed");
			HomePage.takeScreenshot("E:\\java\\homePage.png");
			popUpMassage();
			driver.switchTo().alert().accept();

			
		} else  {
			System.out.println("Test case : Failed");
			String alertMessage= driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			Assert.assertEquals(alertMessage, "User or Password is not valid");
		}

	}
	
	public static void popUpMassage() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("alert('Welcome mngr225054');");
	}
}
