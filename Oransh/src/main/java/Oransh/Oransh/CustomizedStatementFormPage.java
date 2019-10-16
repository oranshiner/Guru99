package Oransh.Oransh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomizedStatementFormPage extends Page{
	
	public CustomizedStatementFormPage() {
		super();
	}

	@FindBy(name = "accountno")
	WebElement Accountno;
	
	@FindBy(name = "AccSubmit")
	WebElement submit;
	
	@FindBy(name = "fdate")
	WebElement fromDate;

	@FindBy(name = "tdate")
	WebElement toDate;
	
	@FindBy(name = "amountlowerlimit")
	WebElement amountlowerlim;
	
	@FindBy(name = "numtransaction")
	WebElement numOfTransaction;
	
	@FindBy(css = "a[href='CustomisedStatementInput.php']")
	private WebElement CustomizedStatementFormElem;
	
	public void CustomizedStatementForm(String AccountNo, String FromDate, String ToDate, String MinimumTransactionValue,String NumberOfTransaction) {
		PageFactory.initElements(driver, this);
		CustomizedStatementFormElem.click();
		Accountno.sendKeys(AccountNo);
		fromDate.sendKeys(FromDate);
		toDate.sendKeys(ToDate);
		amountlowerlim.sendKeys(MinimumTransactionValue);
		numOfTransaction.sendKeys(NumberOfTransaction);
		submit.click();

	}
}
