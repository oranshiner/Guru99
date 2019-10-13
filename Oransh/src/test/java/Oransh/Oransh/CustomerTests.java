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
    @After
    public void finish() {
        if (driver != null)
            driver.close();
    }
    
    
	@Test
	public void ChangePass() {
		
		// SC1
		SideBarCustomer.changePasswordButton();
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		changePasswordPage.changePassword("5555", "Mqmehm11!", "Mqmehm11!");
		// SC2
		changePasswordPage.changePasswordReal("Qaz!11", "marYgaq!12", "marYgaq!12");
		// SC3
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
		SideBarCustomer.BalanceEnquiryButton();
		AccountCustomer accountCustomer = new AccountCustomer();
		accountCustomer.BalanceEnquiry("70270");

	}
	@Test
	public void Ministatement() {
		//SC7
		AccountCustomer accountCustomer = new AccountCustomer();
		SideBarCustomer.MinistatementButton();
		accountCustomer.Ministatement("70270");
	}
	@Test
	public void FundTransfer() {
		//SC8
		AccountCustomer accountCustomer = new AccountCustomer();
		SideBarCustomer.FundTransferButton();
		//Transfer 1 USD
		accountCustomer.FundTransfer("70270","70279","20","fund");
		//SC9
		//refrash the page
		refreshPage();
		//Check that a refresh Redirects to Fund Transfer input Page
		AssertTitle("Fund Transfer Entry Page");
		//SC10
		//Verify transfer details appear on the Customized statement
		SideBarCustomer.CustomisedStatementButton();
		accountCustomer.CustomizedStatementForm("70270", "13/10/2019", "14/10/2019", "20", "126299");
	}

}