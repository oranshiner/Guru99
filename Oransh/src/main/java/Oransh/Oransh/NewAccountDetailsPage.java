package Oransh.Oransh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class NewAccountDetailsPage extends Page{
	
	public NewAccountDetailsPage() {
		super();
	}
	
	@FindBy(name = "cusid")
	WebElement customerId;
	
	@FindBy(name = "inideposit")
	WebElement initialDeposit;
	
	@FindBy(name = "button2")
	WebElement submit;
	
		
	public void NewAccountDetails(String customerId1, String initialDeposit1) {
		PageFactory.initElements(driver, this);
		customerId.sendKeys(customerId1);
		initialDeposit.sendKeys(initialDeposit1);
		submit.click();
	}

}
