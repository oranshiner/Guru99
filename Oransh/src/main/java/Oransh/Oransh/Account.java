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
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		Assert.assertEquals(alertMessage, "Do you really want to delete this Account?");
		driver.switchTo().alert().accept();
		String alertMessage2 = driver.switchTo().alert().getText();
		System.out.println(alertMessage2);
		Assert.assertEquals(alertMessage2, "Account Deleted Sucessfully");
		driver.switchTo().alert().accept();
	}

}
