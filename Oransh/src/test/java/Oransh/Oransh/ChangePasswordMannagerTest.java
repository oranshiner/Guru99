package Oransh.Oransh;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class ChangePasswordMannagerTest extends Page {
	String tempPass = "marYgaq!12";
	
	@Before
	public void before() {
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		driver.manage().window().maximize();
		newUser.login(mannagerId, OriginalPass);
	}

	@After
	public void finish() {
		Sidebar.changePasswordButton();
		// Change Back to Original Password
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		changePasswordPage.changePasswordReal(tempPass, OriginalPass, OriginalPass);
		System.out.println("Password Changed back to original");
		
		if (driver != null)
			driver.close();
	}
	
	
	@Test // Manager
	public void ChangePass() throws IOException {
		// SM1
		// Try to change password with incorrect Old Password
		Sidebar.changePasswordButton();
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		changePasswordPage.changePassword("5555", "Mqmehm11!", "Mqmehm11!");
		// SM2
		changePasswordPage.changePasswordReal(OriginalPass, tempPass, tempPass);
		// SM3
		// Verify you can login with NEW password after the password is changed
		LoginPage User = new LoginPage();
		User.login(mannagerId, tempPass);
		
	}
}
