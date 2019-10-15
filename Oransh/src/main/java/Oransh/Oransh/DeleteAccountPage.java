package Oransh.Oransh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage extends Page{
	
	public DeleteAccountPage() {
		super();
	}
	
	@FindBy(name = "accountno")
	WebElement accountNo;
	
	@FindBy(name = "AccSubmit")
	WebElement submitDel;

	
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
}
