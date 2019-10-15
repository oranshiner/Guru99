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
		newUser.login("27274", "Qaz!11");
	}
    @After
    public void finish() {
		SideBarCustomer.changePasswordButton();
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		// Change Back to Original Password
		System.out.println("Changing back to original");
		changePasswordPage.changePasswordReal("marYgaq!12", "Qaz!11", "Qaz!11");
    	
        if (driver != null)
            driver.close();
    }
    
    
	@Test
	public void ChangePass() {
		
		// SC1
		//Try to change password with incorrect Old Password
		SideBarCustomer.changePasswordButton();
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		changePasswordPage.changePassword("5555", "Mqmehm11!", "Mqmehm11!");
		// SC2
		//Try to change password with correct Old Password
		changePasswordPage.changePasswordReal("Qaz!11", "marYgaq!12", "marYgaq!12");
		// SC3
		//Verify you can log in with NEW password after the password is changed
		LoginPage User = new LoginPage();
		User.login("27274", "marYgaq!12");
		
	}
}
