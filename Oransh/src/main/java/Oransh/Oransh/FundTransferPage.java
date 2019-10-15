package Oransh.Oransh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage extends Page{
	
	public FundTransferPage() {
		super();
	}
	
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
	
	
	public void FundTransfer(String AccountNo, String ToAccountNo, String Amount, String Description) {
		PageFactory.initElements(driver, this);
		accountNo.sendKeys(AccountNo);
		toAccountNo.sendKeys(ToAccountNo);
		amount.sendKeys(Amount);
		description.sendKeys(Description);
		submit.click();

	}
}
