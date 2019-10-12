package Oransh.Oransh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class ChangePasswordPage extends Page {

	public ChangePasswordPage() {
		super();
	}

	@FindBy(name = "oldpassword")
	WebElement oldpassword;

	@FindBy(name = "newpassword")
	WebElement newpassword;

	@FindBy(name = "confirmpassword")
	WebElement confirmpassword;

	@FindBy(name = "sub")
	WebElement sub;

	public void changePassword(String oldpassword, String newpassword, String confirmpassword) {// Test with wrong
																								// PassWord
		PageFactory.initElements(driver, this);
		this.oldpassword.sendKeys(oldpassword);
		this.newpassword.sendKeys(newpassword);
		this.confirmpassword.sendKeys(confirmpassword);
		sub.click();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		Assert.assertEquals(alertMessage, "Old Password is incorrect");
		driver.switchTo().alert().accept();
	}

	public void changePasswordReal(String oldpassword, String newpassword, String confirmpassword) { // Test with
		PageFactory.initElements(driver, this);
		this.oldpassword.sendKeys(oldpassword);
		this.newpassword.sendKeys(newpassword);
		this.confirmpassword.sendKeys(confirmpassword);
		sub.click();	
		String alertMessage2 = driver.switchTo().alert().getText();
		System.out.println(alertMessage2);
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertMessage2, "Password is Changed");
	}

}