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
		newUser.login(Utills.CUSTOMERIDUSERTESTONE, Utills.CUSTOMERPASSWORDUSERTESTONE);
	}
    @After
    public void finish() {
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		// Change Back to Original Password
		changePasswordPage.changePasswordReal(Utills.CUSTOMERTEMPORERYPASS,Utills.CUSTOMERPASSWORDUSERTESTONE,Utills.CUSTOMERPASSWORDUSERTESTONE);
    	
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
		changePasswordPage.changePasswordReal(Utills.CUSTOMERPASSWORDUSERTESTONE,Utills.CUSTOMERTEMPORERYPASS, Utills.CUSTOMERTEMPORERYPASS);
		// SC3
		//Verify you can log in with NEW password after the password is changed
		LoginPage User = new LoginPage();
		User.login(Utills.CUSTOMERIDUSERTESTONE,Utills.CUSTOMERTEMPORERYPASS);
		
	}
}
