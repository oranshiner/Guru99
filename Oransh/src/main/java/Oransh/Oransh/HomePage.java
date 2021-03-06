package Oransh.Oransh;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import junit.framework.Assert;

public class HomePage extends Page {

	public static void isHomePage() throws IOException {

		try {
			String alertMessage = driver.switchTo().alert().getText();
			AssertPopup(Utills.USERORPASSWORDISNOTVALID);
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			if (driver.getTitle().equalsIgnoreCase(Utills.HOMEPAGETITLE)) {
				System.out.println("Test case: Passed");
				//Home
				HomePage.takeScreenshot("E:\\java\\homePage.png");
				//Work
				//HomePage.takeScreenshot("C:\\Users\\user\\Desktop\\homePage.png");
				String mannagerMassage = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
				assertEquals("Manger Id : " + Utills.MANAGERID, mannagerMassage);
				popUpMassage();
				driver.switchTo().alert().accept();
			}
		}

	}

	//Popup Massage injection
	public static void popUpMassage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('Welcome " + Utills.MANAGERID + "');");
	}
}
