package Oransh.Oransh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCustomer extends Page{
	
	public AccountCustomer() {
		super();
	}
	
	@FindBy(name = "accountno")
	WebElement Accountno;
	
	@FindBy(name = "AccSubmit")
	WebElement submit;
	
	@FindBy(name = "payersaccount")
	WebElement accountNo;
	
	@FindBy(name = "payeeaccount")
	WebElement toAccountNo;
	
	@FindBy(name = "ammount")
	WebElement amount;
	
	@FindBy(name = "desc")
	WebElement description;
	
	@FindBy(name = "fdate")
	WebElement fromDate;

	@FindBy(name = "tdate")
	WebElement toDate;
	
	@FindBy(name = "amountlowerlimit")
	WebElement amountlowerlim;
	
	@FindBy(name = "numtransaction")
	WebElement numOfTransaction;
	
	public void BalanceEnquiry(String AccountNo) {
		PageFactory.initElements(driver, this);
		Accountno.sendKeys(AccountNo);
		submit.click();
	}

	public void Ministatement(String AccountNo) {
		PageFactory.initElements(driver, this);
		Accountno.sendKeys(AccountNo);
		submit.click();		
	}

	public void FundTransfer(String AccountNo, String ToAccountNo, String Amount, String Description) {
		PageFactory.initElements(driver, this);
		accountNo.sendKeys(AccountNo);
		toAccountNo.sendKeys(ToAccountNo);
		amount.sendKeys(Amount);
		description.sendKeys(Description);
		submit.click();

	}
	
	public void CustomizedStatementForm(String AccountNo, String FromDate, String ToDate, String MinimumTransactionValue,String NumberOfTransaction) {
		PageFactory.initElements(driver, this);
		Accountno.sendKeys(AccountNo);
		fromDate.sendKeys(FromDate);
		toDate.sendKeys(ToDate);
		amountlowerlim.sendKeys(MinimumTransactionValue);
		numOfTransaction.sendKeys(NumberOfTransaction);
		//submit.click();

	}
}
