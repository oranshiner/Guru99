package Oransh.Oransh;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChangePasswordCustomerTest extends Page{

	@Before
    public void before() {
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		driver.manage().window().maximize();
		newUser.login(Utills.CustomerIDTestUser1, Utills.CustomerPasswordTestUser1);
	}
    @After
    public void finish() {
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		// Change Back to Original Password
		System.out.println("Changing back to original");
		changePasswordPage.changePasswordReal(Utills.tempCustomerPass,Utills.CustomerPasswordTestUser1,Utills.CustomerPasswordTestUser1);
    	
        if (driver != null)
            driver.close();
    }
    
    
	@Test
	public void ChangePass() {
		
		// SC1
		//Try to change password with incorrect Old Password
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		changePasswordPage.changePassword("5555", "Mqmehm11!", "Mqmehm11!");
		// SC2
		//Try to change password with correct Old Password
		changePasswordPage.changePasswordReal(Utills.CustomerPasswordTestUser1,Utills.tempCustomerPass, Utills.tempCustomerPass);
		// SC3
		//Verify you can log in with NEW password after the password is changed
		LoginPage User = new LoginPage();
		User.login(Utills.CustomerIDTestUser1,Utills.tempCustomerPass);
		
	}
}
