package Oransh.Oransh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class ChangePasswordPage extends Page {

	public ChangePasswordPage() {
		super();
	}



	public static void changePasswordButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[11]/a")).click();
	}
	public static void changePassword(String oldpassword, String newpassword, String confirmpassword) {//Test with wrong PassWord
		driver.findElement(By.name("oldpassword")).sendKeys(oldpassword);
		driver.findElement(By.name("newpassword")).sendKeys(newpassword);
		driver.findElement(By.name("confirmpassword")).sendKeys(confirmpassword);
		driver.findElement(By.name("sub")).click();
    	String alertMessage= driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		Assert.assertEquals(alertMessage, "Old Password is incorrect");
		driver.switchTo().alert().accept();
	}
		public static void changePasswordReal(String oldpassword, String newpassword, String confirmpassword) {		//Test with real Password
		driver.findElement(By.name("oldpassword")).sendKeys(oldpassword);
		driver.findElement(By.name("newpassword")).sendKeys(newpassword);
		driver.findElement(By.name("confirmpassword")).sendKeys(confirmpassword);
		driver.findElement(By.name("sub")).click();
    	String alertMessage2= driver.switchTo().alert().getText();
		System.out.println(alertMessage2);
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage2, "Password is Changed");
		}

		
		public static void changePasswordBack(String oldpassword, String newpassword, String confirmpassword) {
			driver.findElement(By.name("oldpassword")).sendKeys(oldpassword);
			driver.findElement(By.name("newpassword")).sendKeys(newpassword);
			driver.findElement(By.name("confirmpassword")).sendKeys(confirmpassword);
			driver.findElement(By.name("sub")).click();
			driver.switchTo().alert().accept();
			System.out.println("Password Changed back");

		
		

	}

		public static void Login(String id, String password) {
			driver.findElement(By.name("uid")).sendKeys(id);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("btnLogin")).click();
			System.out.println("Log in with new pass");
			
		}
}