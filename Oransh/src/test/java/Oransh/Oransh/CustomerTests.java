package Oransh.Oransh;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTests extends Page{
	
//2 Testing Accounts

//	Account ID	70270
//	Customer ID	27274
//	Customer Name	Virendra
//	Email	32sdVirendra@gmail.com
//	Account Type	Savings
//	Date of Opening	2019-10-13
//	Current Amount	500
//	
//	
//	Account ID	70279
//	Customer ID	93712
//	Customer Name	Virendra
//	Email	oran@gmail.com
//	Account Type	Savings
//	Date of Opening	2019-10-13
//	Current Amount	500
	
	
	@Before
    public void before() {
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		newUser.login("27274", "Qaz!11");
	}
//    @After
//    public void finish() {
//        if (driver != null)
//            driver.close();
//    }
//    
//    
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
		SideBarCustomer.changePasswordButton();
		// Change Back to Original Password
		System.out.println("Changing back to original");
		changePasswordPage.changePasswordReal("marYgaq!12", "Qaz!11", "Qaz!11");
		System.out.println("Password Changed back to original");
		// ReEnter the Site with Original Password
		User.login("27274", "Qaz!11");
		
	}
	
	@Test
	public void BalanceEnquiry() {
		
		//SC4
		//Verify Balance of an account
		SideBarCustomer.BalanceEnquiryButton();
		AccountCustomer accountCustomer = new AccountCustomer();
		accountCustomer.BalanceEnquiry("70270");

		
	}
	@Test
	public void Ministatement() {
		//SC7
		//Verify transfer details appear on the Mini statement
		AccountCustomer accountCustomer = new AccountCustomer();
		SideBarCustomer.MinistatementButton();
		accountCustomer.Ministatement("70270");
		
	}
	@Test
	public void FundTransfer() {
		//SC8
		//Verify - Fund Transfer can be done
		AccountCustomer accountCustomer = new AccountCustomer();
		SideBarCustomer.FundTransferButton();
		//Transfer 1 USD
		accountCustomer.FundTransfer("70270","70279","20","fund");
		//SC9
		//Verify - Fund Transfer is not done when page is reloaded(refreshed)
		refreshPage();
		//Check that a refresh Redirects to Fund Transfer input Page
		AssertTitle("Fund Transfer Entry Page");
		//SC10
		//Verify - transfer details appear on the Customized statement
		SideBarCustomer.CustomisedStatementButton();
		accountCustomer.CustomizedStatementForm("70270", "13/10/2019", "14/10/2019", "20", "126299");
		//SC11
		//Verify - Fund transfer for Payer Authorization 
		SideBarCustomer.FundTransferButton();
		accountCustomer.FundTransfer("70279","70270","20","fund");
		AssertPopup("You are not authorize to Transfer Funds from this account!!");
		AssertTitle("Fund Transfer Entry Page");
		//SC12
		//Verify - Fund transfer Payer or Payee account no does not  exist in database
		SideBarCustomer.FundTransferButton();
		accountCustomer.FundTransfer("70270","3443","20","fund");
		AssertPopup("Account 3443does not exist!!!");
		//SC13
		//Verify - Fund transfer Payer & Payees account number are same
		SideBarCustomer.FundTransferButton();
		accountCustomer.FundTransfer("70270","70270","20","fund");
		AssertPopup("Payers account No and Payees account No Must Not be Same!!!");
		
	}
	@Test
	public void VerifyMinistatement() {
		//SC14
		//Verify a customer can see mini statement of ONLY his account
		AccountCustomer accountCustomer = new AccountCustomer();
		SideBarCustomer.MinistatementButton();
		accountCustomer.Ministatement("70279");
		AssertPopup("You are not authorize to generate statement of this Account!!");
		//SC15
		//Verify system behavior when wrong account number is entered in the Mini statement
		accountCustomer.Ministatement("3443");
		AssertPopup("Account does not exist");
	}
	@Test
	public void VerifyCustomizedStatement() {
		//SC16
		//Verify that customer can see Customized statement of ONLY his account
		SideBarCustomer.CustomisedStatementButton();
		AccountCustomer accountCustomer = new AccountCustomer();
		accountCustomer.CustomizedStatementForm("70279", "13/10/2019", "14/10/2019", "20", "126299");
		AssertPopup("You are not authorize to generate statement of this Account!!");
		//SC17
		// wrong account number entered
		accountCustomer.CustomizedStatementForm("3443", "13/10/2019", "14/10/2019", "20", "126299");
		AssertPopup("Account does not exist");
		//SC18
		//To date lower than from date Test
		accountCustomer.CustomizedStatementForm("70270", "13/08/2019", "14/07/2019", "20", "126299");
		AssertPopup("FromDate field should be lower than ToDate field!!");
	}

}
