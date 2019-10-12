package Oransh.Oransh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAccount extends Page{
	
	public NewAccount() {
		super();
	}
	
	@FindBy(name = "cusid")
	WebElement customerId;
	
	@FindBy(name = "inideposit")
	WebElement initialDeposit;
	
	@FindBy(name = "button2")
	WebElement submit;
	
	public void NewAccountDetails(String customerId1, String initialDeposit1) {
		customerId.sendKeys(customerId1);
		initialDeposit.sendKeys(initialDeposit1);
		submit.click();
	}

}
