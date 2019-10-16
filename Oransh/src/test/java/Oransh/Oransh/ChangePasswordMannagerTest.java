package Oransh.Oransh;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class ChangePasswordMannagerTest extends Page {
	
	@Before
	public void before() {
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		driver.manage().window().maximize();
		newUser.login(Utills.mannagerId, Utills.mannagerPass);
	}

	@After
	public void finish() {
		// Change Back to Original Password
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		changePasswordPage.changePasswordReal(Utills.tempManagerPass, Utills.mannagerPass, Utills.mannagerPass);
		System.out.println("Password Changed back to original");
		
		if (driver != null)
			driver.close();
	}
	
	
	@Test // Manager
	public void ChangePass() {
		// SM1
		// Try to change password with incorrect Old Password
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		changePasswordPage.changePassword("5555", "Mqmehm11!", "Mqmehm11!");
		// SM2
		changePasswordPage.changePasswordReal(Utills.mannagerPass, Utills.tempManagerPass, Utills.tempManagerPass);
		// SM3
		// Verify you can login with NEW password after the password is changed
		LoginPage User = new LoginPage();
		User.login(Utills.mannagerId, Utills.tempManagerPass);
		
	}
}
