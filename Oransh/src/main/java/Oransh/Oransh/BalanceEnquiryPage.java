package Oransh.Oransh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BalanceEnquiryPage extends Page{
	
	public BalanceEnquiryPage() {
		super();
	}

	@FindBy(name = "accountno")
	WebElement accountNo;
	
	@FindBy(name = "AccSubmit")
	WebElement submit;
	
	public void BalanceEnquiry(String AccountNo) {
		PageFactory.initElements(driver, this);
		accountNo.sendKeys(AccountNo);
		submit.click();
		//Check that A pop "Account does not exist"
		Page.AssertPopup("Account does not exist");
		//Check that Redirects to Balance Enquiry page
		Page.AssertTitle("Guru99 Bank Balance Enquiry Page");

	}
	
	public void BalanceEnquiryCustomer(String AccountNo) {
		PageFactory.initElements(driver, this);
		WebElement DropDown = driver.findElement(By.name("accountno"));  
		Select dropdown = new Select(DropDown);  
		dropdown.selectByVisibleText(AccountNo); 
		submit.click();
	}
}
