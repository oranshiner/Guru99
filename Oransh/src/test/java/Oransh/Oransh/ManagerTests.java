package Oransh.Oransh;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import junit.framework.Assert;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class ManagerTests extends Page {
	String randomEmail = RandomEmail();


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
		// Try to change password with incorrect Old Password
		Sidebar.changePasswordButton();
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		changePasswordPage.changePassword("5555", "Mqmehm11!", "Mqmehm11!");
		// SM2
		changePasswordPage.changePasswordReal("marYgaq!1", "marYgaq!12", "marYgaq!12");
		// SM3
		// Verify you can login with NEW password after the password is changed
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

		// SM4
		// Verify after Adding New Customer, page redirects to details of added customer
		// Open new customer window
		Sidebar.AddNewCustomerButton();
		NewCustomer newCustomer = new NewCustomer();
		// Add New Customer With random email
		newCustomer.NewCustomerDetails("Virendra", "04/11/2013", "Jamnagar", "Jamnagar", "567321", "8000439024",
				randomEmail, "Gujarat", "Qaz!11");
		// SM5
		// Verify a new account can be added to new customer
		Sidebar.AddNewAccountButton();
		Account newAccount = new Account();
		// ***************I NEED TO CHANGE THE CUSTOMER NUMBER TO THE ONE I GOT FROM***************
		// LAST CUSTOMER
		newAccount.NewAccountDetails("27274", "500");

	}

	@Test // Manager
	public void DeleteAccount() {
		// SM6 & SM7
		// Verify confirmation message is shown on deletion of an account
		// Verify system behaviour after Account is deleted
		Sidebar.DeleteAccountButton();
		Account account = new Account();
		// ***************I NEED TO CHANGE THE Account No TO THE ONE I GOT FROM LAST***************
		// CUSTOMER
		account.deleteAccount("70196");
		// SM8
		// Verify that mini statement is not generated for a deleted account
		Sidebar.MiniStatementButton();
		account.MiniStatement("70196");
		// SM9
		// Verify balance for deleted account
		Sidebar.BalanceEnquiryButton();
		account.BalanceEnquiry("70196");
		// SM10
		// Verify that customized statement is not generated for deleted account
		Sidebar.CustomisedStatementButton();
		account.Customizedstatement("70196");
	}

	@Test // Manager
	public void DeleteEditCustomer() {
		// SM11
		Sidebar.AddNewCustomerButton();
		NewCustomer newCustomer = new NewCustomer();
		// Add New Temporery Customer To Check Delete
		newCustomer.NewCustomerDetails("Virendra", "04/11/2013", "Jamnagar", "Jamnagar", "567321", "8000439024",randomEmail, "Gujarat", "Qaz!11");
		//Get the Temporery Customer number
		String TemporeryCustomer = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
		Sidebar.DeleteCustomerButton();
		Account account = new Account();
		//Delete Temporery Customer
		account.DeleteCustomer(TemporeryCustomer);
		AssertPopup("Do you really want to delete this Customer?");
		AssertPopup("Customer deleted Successfully");

		
	}

	@After
	public void finish() {
		if (driver != null)
			driver.close();
	}

}
