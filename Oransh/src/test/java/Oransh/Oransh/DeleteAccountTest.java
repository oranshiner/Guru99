package Oransh.Oransh;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class DeleteAccountTest extends Page {
	String TemporeryAccount;
	
	@Before
	public void before() {
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		driver.manage().window().maximize();
		newUser.login(Utills.mannagerId, Utills.mannagerPass);
		NewAccountDetailsPage account = new NewAccountDetailsPage();
		// Add New Temporery Account To Check Delete
		account.NewAccountDetails(Utills.CustomerIDTestUser1,Utills.depositAmount);
		// Get the Temporery Account number
	    TemporeryAccount = driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]")).getText();
	}

	@After
	public void finish() {
		if (driver != null)
			driver.close();
	}
	
	
	@Test // Manager
	public void DeleteAccount() {
		// SM6 & SM7
		// Verify confirmation message is shown on deletion of an account
		// Verify system behaviour after Account is deleted
		DeleteAccountPage deleteAccountPage = new DeleteAccountPage();
		deleteAccountPage.deleteAccount(TemporeryAccount);
		// SM8
		// Verify that mini statement is not generated for a deleted account
		MiniStatementPage miniStatementPage = new MiniStatementPage();
		miniStatementPage.MiniStatement(TemporeryAccount);
		//Check that A pop "Account does not exist"
		AssertPopup("Account does not exist");
		//Check that Redirects to MiniStatement page
		AssertTitle("Guru99 Bank Mini Statement Page");
		// SM9
		// Verify balance for deleted account
		BalanceEnquiryPage balanceEnquiryPage = new BalanceEnquiryPage();
		balanceEnquiryPage.BalanceEnquiry(TemporeryAccount);
		// SM10
		// Verify that customized statement is not generated for deleted account
		CustomizedstatementPage customizedstatementPage = new CustomizedstatementPage();
		customizedstatementPage.Customizedstatement(TemporeryAccount);
	}
}
