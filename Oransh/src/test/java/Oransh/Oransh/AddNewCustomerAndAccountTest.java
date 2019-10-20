package Oransh.Oransh;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class AddNewCustomerAndAccountTest extends Page {
	String randomEmail = RandomEmail();


	@Before
	public void before() {
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		driver.manage().window().maximize();
		newUser.login(Utills.MANAGERID, Utills.MANAGERPASS);
	}

	@After
	public void finish() {
		if (driver != null)
			driver.close();
	}

	@Test // Manager
	public void AddNewCustomerAndAccount() {

		// SM4
		// Verify after Adding New Customer, page redirects to details of added customer
		// Open new customer window
		NewCustomerPage newCustomer = new NewCustomerPage();
		// Add New Customer With random email
		newCustomer.NewCustomerDetails("Virendra", "04/11/2013", "Jamnagar", "Jamnagar", "567321", "8000439024",
				randomEmail, "Gujarat",Utills.CUSTOMERPASSWORDUSERTESTONE);
		// Gets the new Customer ID
		String tempCustomerID = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
		// SM5
		// Verify a new account can be added to new customer
		NewAccountDetailsPage newAccount = new NewAccountDetailsPage();
		// New Account with the CustomerID generated in the SM4
		newAccount.NewAccountDetails(tempCustomerID,Utills.depositAmount);

	}


}
