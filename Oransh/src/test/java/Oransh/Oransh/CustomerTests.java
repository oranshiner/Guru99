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
	
	String AccountIDTestUser1 = "70270";
	String AccountIDTestUser2 = "70279";
	String Amount = "20";
	String desc = "fund";
	String TodayDate = DodayDate();

	
	
	@Before
    public void before() {
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		driver.manage().window().maximize();
		newUser.login("27274", "Qaz!11");
	}
    @After
    public void finish() {
        if (driver != null)
            driver.close();
    }
    
	
	@Test
	public void BalanceEnquiry() {
		
		//SC4
		//Verify Balance of an account
		SideBarCustomer.BalanceEnquiryButton();
		BalanceEnquiryPage balanceEnquiryPage = new BalanceEnquiryPage();
		balanceEnquiryPage.BalanceEnquiryCustomer(AccountIDTestUser1);

		
	}
	@Test
	public void Ministatement() {
		//SC7
		//Verify transfer details appear on the Mini statement
		MiniStatementPage ministatementCustomer = new MiniStatementPage();
		SideBarCustomer.MinistatementButton();
		ministatementCustomer.MiniStatement(AccountIDTestUser1);
		
	}
	@Test
	public void FundTransfer() {
		//SC8
		//Verify - Fund Transfer can be done
		FundTransferPage fundTransferPage = new FundTransferPage();
		SideBarCustomer.FundTransferButton();
		//Transfer 1 USD
		
		fundTransferPage.FundTransfer(AccountIDTestUser1,AccountIDTestUser2,Amount,desc);
		//SC9
		//Verify - Fund Transfer is not done when page is reloaded(refreshed)
		refreshPage();
		//Check that a refresh Redirects to Fund Transfer input Page
		AssertTitle("Fund Transfer Entry Page");
		//SC10
		//Verify - transfer details appear on the Customized statement
		SideBarCustomer.CustomisedStatementButton();
		CustomizedStatementFormPage customizedStatementFormPage = new CustomizedStatementFormPage();
		customizedStatementFormPage.CustomizedStatementForm(AccountIDTestUser1, "08/13/2019",TodayDate,Amount, "126299");
		//SC11
		//Verify - Fund transfer for Payer Authorization 
		SideBarCustomer.FundTransferButton();
		fundTransferPage.FundTransfer(AccountIDTestUser2,AccountIDTestUser1,Amount,desc);
		AssertPopup("You are not authorize to Transfer Funds from this account!!");
		AssertTitle("Fund Transfer Entry Page");
		//SC12
		//Verify - Fund transfer Payer or Payee account no does not  exist in database
		SideBarCustomer.FundTransferButton();
		fundTransferPage.FundTransfer(AccountIDTestUser1,"3443",Amount,desc);
		AssertPopup("Account 3443does not exist!!!");
		//SC13
		//Verify - Fund transfer Payer & Payees account number are same
		SideBarCustomer.FundTransferButton();
		fundTransferPage.FundTransfer(AccountIDTestUser1,AccountIDTestUser1,Amount,desc);
		AssertPopup("Payers account No and Payees account No Must Not be Same!!!");
		
	}
	@Test
	public void VerifyMinistatement() {
		//SC14
		//Verify a customer can see mini statement of ONLY his account
		MiniStatementPage ministatementCustomer = new MiniStatementPage();
		SideBarCustomer.MinistatementButton();
		ministatementCustomer.MiniStatement(AccountIDTestUser2);
		AssertPopup("You are not authorize to generate statement of this Account!!");
		//SC15
		//Verify system behavior when wrong account number is entered in the Mini statement
		ministatementCustomer.MiniStatement("3443");
		AssertPopup("Account does not exist");
	}
	@Test
	public void VerifyCustomizedStatement() {
		//SC16
		//Verify that customer can see Customized statement of ONLY his account
		SideBarCustomer.CustomisedStatementButton();
		CustomizedStatementFormPage customizedStatementFormPage = new CustomizedStatementFormPage();
		customizedStatementFormPage.CustomizedStatementForm(AccountIDTestUser2, "10/13/2019", TodayDate,Amount, "126299");
		AssertPopup("You are not authorize to generate statement of this Account!!");
		//SC17
		// wrong account number entered
		customizedStatementFormPage.CustomizedStatementForm("3443", "10/13/2019",TodayDate,Amount, "126299");
		AssertPopup("Account does not exist");
		//SC18
		//To date lower than from date Test
		customizedStatementFormPage.CustomizedStatementForm(AccountIDTestUser1, "08/13/2019", "07/14/2019",Amount, "126299");
		AssertPopup("FromDate field should be lower than ToDate field!!");
	}

}
