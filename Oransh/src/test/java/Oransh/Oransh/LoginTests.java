package Oransh.Oransh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import junit.framework.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class LoginTests extends Page {

	@Parameterized.Parameter(0)
	public String username; // This is the user name parameter
	@Parameterized.Parameter(1)
	public String password; // This is the password parameter
	@Parameterized.Parameter(2)
	public boolean shouldLogin;

	@Parameterized.Parameters
	public static Collection<Object[]> testExecutionParameters() {
		return Arrays.asList(new Object[][] { { "mngr225054", "marYgaq!1", true }, // Valid User Name and password
				// {"mngr225053", "marYga", false}//, //InValid User Name and password
				// {"mngr225054", "marYga", false}, //Valid User Name and InValid password
				// ****** ביטלתי שלא סתם יפתחו 4 בבדיקות שלי
				// {"mngr225053", "marYgaq", false} //InValid User Name and Valid password
				// ****** ביטלתי שלא סתם יפתחו 4 בבדיקות שלי

		});
	}

	@Test
	public void loginTest() throws IOException {
		this.username = username;
		this.password = password;
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		newUser.takeScreenshot("E:\\java\\loginPage.png");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		newUser.login(username, password);
		HomePage.isHomePage();

	}

	@Test // Manager
	public void ChangePass() throws IOException {
		// SM1
		Sidebar.changePasswordButton();
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		changePasswordPage.changePassword("5555", "Mqmehm11!", "Mqmehm11!");
		// SM2
		changePasswordPage.changePasswordReal("marYgaq!1", "marYgaq!12", "marYgaq!12");
		// SM3
		LoginPage User = new LoginPage();
		User.login("mngr225054", "marYgaq!12");
		Sidebar.changePasswordButton();
		// Change Back to Original Password
		changePasswordPage.changePasswordReal("marYgaq!12", "marYgaq!1", "marYgaq!1");
		System.out.println("Password Changed back to original");
		// ReEnter the Site with Original Password
		User.login("mngr225054", "marYgaq!1");
		
	}

	@Test // Manager
	public void AddNewCustomerAndAccount() {
		
		//SM4
		//Open new customer window
		Sidebar.AddNewCustomerButton();
		NewCustomer newCustomer = new NewCustomer();
		//Add New Customer
		newCustomer.NewCustomerDetails("Virendra", "04/11/2013", "Jamnagar", "Jamnagar", "567321", "8000439024", "32sdVirendra@gmail.com", "Gujarat", "Qaz!11");
		//SM5
		Sidebar.AddNewAccountButton();
		Account newAccount = new Account();
		//***************I NEED TO CHANGE THE CUSTOMER NUMBER TO THE ONE I GOT FROM LAST CUSTOMER
		newAccount.NewAccountDetails("27274","500");
		
	}
	
	@Test // Manager
	public void DeleteAccount() {
		//SM6 //SM7 
		Sidebar.DeleteAccountButton();
		Account account = new Account();
		//***************I NEED TO CHANGE THE Account No TO THE ONE I GOT FROM LAST CUSTOMER
		account.deleteAccount("70196");
		//SM8 
		Sidebar.MiniStatementButton();
		account.MiniStatement("70196");
		//SM9
		Sidebar.BalanceEnquiryButton();
		account.BalanceEnquiry("70196");
		//SM10
		Sidebar.CustomisedStatementButton();
		account.Customizedstatement("70196");

		
	}
	
	

}
