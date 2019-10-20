package Oransh.Oransh;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTests extends Page{
	String TodayDate = DodayDate();
	String dateMinusTwoMounth = DateMinusTwoMounth();
	
	@Before
    public void before() {
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		driver.manage().window().maximize();
		newUser.login(Utills.CUSTOMERIDUSERTESTONE,Utills.CUSTOMERPASSWORDUSERTESTONE);
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
		BalanceEnquiryPage balanceEnquiryPage = new BalanceEnquiryPage();
		balanceEnquiryPage.BalanceEnquiryCustomer(Utills.ACCOUNTIDUSERTESTONE);

		
	}
	@Test
	public void Ministatement() {
		//SC7
		//Verify transfer details appear on the Mini statement
		MiniStatementPage ministatementCustomer = new MiniStatementPage();
		ministatementCustomer.MiniStatement(Utills.ACCOUNTIDUSERTESTONE);
		
	}
	@Test
	public void FundTransfer() {
		//SC8
		//Verify - Fund Transfer can be done
		FundTransferPage fundTransferPage = new FundTransferPage();
		//Transfer 1 USD
		fundTransferPage.FundTransfer(Utills.ACCOUNTIDUSERTESTONE,Utills.ACCOUNTIDUSERTESTTWO,Utills.Amount,Utills.description);
		//SC9
		//Verify - Fund Transfer is not done when page is reloaded(refreshed)
		refreshPage();
		//Check that a refresh Redirects to Fund Transfer input Page
		AssertTitle(Utills.FUNDTRANSFERENTRYPAGE);
		//SC10
		//Verify - transfer details appear on the Customized statement
		CustomizedStatementFormPage customizedStatementFormPage = new CustomizedStatementFormPage();
		customizedStatementFormPage.CustomizedStatementForm(Utills.ACCOUNTIDUSERTESTONE,dateMinusTwoMounth,TodayDate,Utills.Amount,Utills.NumberOftransaction);
		//SC11
		//Verify - Fund transfer for Payer Authorization 
		fundTransferPage.FundTransfer(Utills.ACCOUNTIDUSERTESTTWO,Utills.ACCOUNTIDUSERTESTONE,Utills.Amount,Utills.description);
		AssertPopup("You are not authorize to Transfer Funds from this account!!");
		AssertTitle(Utills.FUNDTRANSFERENTRYPAGE);
		//SC12
		//Verify - Fund transfer Payer or Payee account no does not  exist in database
		fundTransferPage.FundTransfer(Utills.ACCOUNTIDUSERTESTONE,Utills.wrongAccountNumber,Utills.Amount,Utills.description);
		AssertPopup("Account "+Utills.wrongAccountNumber+"does not exist!!!");
		//SC13
		//Verify - Fund transfer Payer & Payees account number are same
		fundTransferPage.FundTransfer(Utills.ACCOUNTIDUSERTESTONE,Utills.ACCOUNTIDUSERTESTONE,Utills.Amount,Utills.description);
		AssertPopup("Payers account No and Payees account No Must Not be Same!!!");
		
	}
	@Test
	public void VerifyMinistatement() {
		//SC14
		//Verify a customer can see mini statement of ONLY his account
		MiniStatementPage ministatementCustomer = new MiniStatementPage();
		ministatementCustomer.MiniStatement(Utills.ACCOUNTIDUSERTESTTWO);
		AssertPopup("You are not authorize to generate statement of this Account!!");
		//SC15
		//Verify system behavior when wrong account number is entered in the Mini statement
		ministatementCustomer.MiniStatement(Utills.wrongAccountNumber);
		AssertPopup(Utills.ACCOUNTDOESNOTEXIST);
	}
	@Test
	public void VerifyCustomizedStatement() {
		//SC16
		//Verify that customer can see Customized statement of ONLY his account
		CustomizedStatementFormPage customizedStatementFormPage = new CustomizedStatementFormPage();
		customizedStatementFormPage.CustomizedStatementForm(Utills.ACCOUNTIDUSERTESTTWO, dateMinusTwoMounth, TodayDate,Utills.Amount,Utills.NumberOftransaction);
		AssertPopup("You are not authorize to generate statement of this Account!!");
		//SC17
		// wrong account number entered
		customizedStatementFormPage.CustomizedStatementForm(Utills.wrongAccountNumber,dateMinusTwoMounth,TodayDate,Utills.Amount,Utills.NumberOftransaction);
		AssertPopup(Utills.ACCOUNTDOESNOTEXIST);
		//SC18
		//To date lower than from date Test
		customizedStatementFormPage.CustomizedStatementForm(Utills.ACCOUNTIDUSERTESTONE,TodayDate,dateMinusTwoMounth,Utills.Amount,Utills.NumberOftransaction);
		AssertPopup("FromDate field should be lower than ToDate field!!");
	}

}
