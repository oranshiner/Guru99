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
	
	@FindBy(css = "a[href='PasswordInput.php']")
	private WebElement ChangePasswordElem;
	

	public void changePassword(String oldpassword, String newpassword, String confirmpassword) {// Test with wrong
																								// PassWord
		PageFactory.initElements(driver, this);
		ChangePasswordElem.click();
		this.oldpassword.sendKeys(oldpassword);
		this.newpassword.sendKeys(newpassword);
		this.confirmpassword.sendKeys(confirmpassword);
		sub.click();
		//Check The pop up
		Page.AssertPopup(Utills.OLDPASSWORDISINCORRECT);
		//Check that Redirects to Change Password page
		Page.AssertTitle(Utills.BankNewCustomerEntryPage);
		
	}

	public void changePasswordReal(String oldpassword, String newpassword, String confirmpassword) { // Test with
		PageFactory.initElements(driver, this);
		ChangePasswordElem.click();
		this.oldpassword.sendKeys(oldpassword);
		this.newpassword.sendKeys(newpassword);
		this.confirmpassword.sendKeys(confirmpassword);
		sub.click();
		//Check The pop up
		Page.AssertPopup("Password is Changed");
		//Check that Redirects to login page
		Page.AssertTitle(Utills.CUSTOMERHOMEPAGETITLE);
 
	}

}