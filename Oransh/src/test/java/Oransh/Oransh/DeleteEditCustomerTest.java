package Oransh.Oransh;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class DeleteEditCustomerTest extends Page{
	String randomEmail = RandomEmail();
	String TemporeryCustomer;
	
	@Before
	public void before() {
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		driver.manage().window().maximize();
		newUser.login(Utills.mannagerId, Utills.mannagerPass);
		NewCustomerPage newCustomer = new NewCustomerPage();
		// Add New Temporery Customer To Check Delete
		newCustomer.NewCustomerDetails("Virendra", "04/11/2013", "Jamnagar", "Jamnagar", "567321", "8000439024",
				randomEmail, "Gujarat", "Qaz!11");
		// Get the Temporery Customer number
		TemporeryCustomer = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
	}

	@After
	public void finish() {
		if (driver != null)
			driver.close();
	}
	
	
	@Test // Manager
	public void DeleteCustomer() {
		// SM11 & SM13
		// Verify confirmation message is shown when customer is deleted
		// Then Verify that a Customer can be Deleted
		DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage();
		// Delete Temporery Customer
		deleteCustomerPage.DeleteCustomer(TemporeryCustomer);
		AssertPopup("Do you really want to delete this Customer?");
		AssertPopup("Customer deleted Successfully");
	}
	
	@Test // Manager
	public void DeleteEditCustomer() {
		// SM12
		// Verify that customer should not be deleted if any account exists for that
		// customer
		// First We Generate a new Customer and new account
		NewAccountDetailsPage newAccount = new NewAccountDetailsPage();
		newAccount.NewAccountDetails(TemporeryCustomer, "500");
		// Now we try to delete the customer when he has an activer account.
		DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage();
		deleteCustomerPage.DeleteCustomer(TemporeryCustomer);
		AssertPopup("Do you really want to delete this Customer?");
		AssertPopup("Customer could not be deleted!!. First delete all accounts of this customer then delete the customer");
		AssertTitle("Guru99 Bank Delete Customer Page");
		// SM15
		// Verify system behaviour when manager deletes a non existing customer ID
		deleteCustomerPage.DeleteCustomer(TemporeryCustomer);
		AssertPopup("Do you really want to delete this Customer?");
		AssertPopup("Customer could not be deleted!!. First delete all accounts of this customer then delete the customer");
		AssertTitle("Guru99 Bank Delete Customer Page");
		// SM14
		// Verify deleted customer cannot be edited
		EditCustomerPage editCustomerPage = new EditCustomerPage();
		editCustomerPage.EditCustomer(TemporeryCustomer);
		AssertTitle("Guru99 Bank Edit Customer Entry Page");
	}
}
