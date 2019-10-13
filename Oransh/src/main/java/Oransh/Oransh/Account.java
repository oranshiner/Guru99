package Oransh.Oransh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class Account extends Page{
	
	public Account() {
		super();
	}
	
	@FindBy(name = "cusid")
	WebElement customerId;
	
	@FindBy(name = "inideposit")
	WebElement initialDeposit;
	
	@FindBy(name = "button2")
	WebElement submit;
	
	@FindBy(name = "accountno")
	WebElement accountNo;
	
	@FindBy(name = "AccSubmit")
	WebElement submitDel;
		
	public void NewAccountDetails(String customerId1, String initialDeposit1) {
		PageFactory.initElements(driver, this);
		customerId.sendKeys(customerId1);
		initialDeposit.sendKeys(initialDeposit1);
		submit.click();
	}

	public void deleteAccount(String AccountNo) {
		PageFactory.initElements(driver, this);
		accountNo.sendKeys(AccountNo);
		submitDel.click();
		//Check that A pop "Do you really want to delete this Account?"
		Page.AssertPopup("Do you really want to delete this Account?");
		//Check that A pop "Account Deleted Sucessfully"
		Page.AssertPopup("Account Deleted Sucessfully");
		//Check that Page redirected to manager home page
		Page.AssertTitle("Guru99 Bank Manager HomePage");
	}
	
	public void MiniStatement(String AccountNo) {
		PageFactory.initElements(driver, this);
		accountNo.sendKeys(AccountNo);
		submitDel.click();
		//Check that A pop "Account does not exist"
		Page.AssertPopup("Account does not exist");
		//Check that Redirects to MiniStatement page
		Page.AssertTitle("Guru99 Bank Mini Statement Page");

	}
	
	public void BalanceEnquiry(String AccountNo) {
		PageFactory.initElements(driver, this);
		accountNo.sendKeys(AccountNo);
		submitDel.click();
		//Check that A pop "Account does not exist"
		Page.AssertPopup("Account does not exist");
		//Check that Redirects to Balance Enquiry page
		Page.AssertTitle("Guru99 Bank Balance Enquiry Page");

	}

	public void Customizedstatement(String AccountNo) {
		PageFactory.initElements(driver, this);
		accountNo.sendKeys(AccountNo);
		submitDel.click();
		//Check that A pop "Account does not exist"
		Page.AssertPopup("Account does not exist");
		//Check that Redirects to Balance Enquiry page
		Page.AssertTitle("Guru99 Bank Statement Page");
	}
	public void DeleteCustomer(String CustomerNo) {
		PageFactory.initElements(driver, this);
		customerId.sendKeys(CustomerNo);
		submitDel.click();
	}
	
}
