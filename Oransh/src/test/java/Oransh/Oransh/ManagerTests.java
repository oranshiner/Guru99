package Oransh.Oransh;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ManagerTests extends Page{
	String randomEmail = RandomEmail();
	String OriginalPass = "marYgaq!1";
	String tempPass =  "marYgaq!12";
	String mannagerId = "mngr225054";
	
	
	@Before
    public void before() {
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		driver.manage().window().maximize();
		newUser.login(mannagerId,OriginalPass);
	}
	
	@After
	public void finish() {
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
		changePasswordPage.changePasswordReal(OriginalPass,tempPass,tempPass);
		// SM3
		// Verify you can login with NEW password after the password is changed
		LoginPage User = new LoginPage();
		User.login(mannagerId,tempPass);
		Sidebar.changePasswordButton();
		// Change Back to Original Password
		changePasswordPage.changePasswordReal(tempPass,OriginalPass,OriginalPass);
		System.out.println("Password Changed back to original");
		// ReEnter the Site with Original Password
		User.login(mannagerId,OriginalPass);

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
		//Gets the new Customer ID
		String TempCustomerID = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
		System.out.println(TempCustomerID);
		// SM5
		// Verify a new account can be added to new customer
		Sidebar.AddNewAccountButton();
		Account newAccount = new Account();
		//New Account with the CustomerID generated in the SM4
		newAccount.NewAccountDetails(TempCustomerID, "500");

	}

	@Test // Manager
	public void DeleteAccount() {
		// SM6 & SM7
		// Verify confirmation message is shown on deletion of an account
		// Verify system behaviour after Account is deleted
		Account account = new Account();
		Sidebar.AddNewAccountButton();
		// Add New Temporery Account To Check Delete
		account.NewAccountDetails("27274", "500");
		//Get the Temporery Account number
		String TemporeryAccount = driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]")).getText();
		Sidebar.DeleteAccountButton();
		account.deleteAccount(TemporeryAccount);
		// SM8
		// Verify that mini statement is not generated for a deleted account
		Sidebar.MiniStatementButton();
		account.MiniStatement(TemporeryAccount);
		// SM9
		// Verify balance for deleted account
		Sidebar.BalanceEnquiryButton();
		account.BalanceEnquiry(TemporeryAccount);
		// SM10
		// Verify that customized statement is not generated for deleted account
		Sidebar.CustomisedStatementButton();
		account.Customizedstatement(TemporeryAccount);
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

}
