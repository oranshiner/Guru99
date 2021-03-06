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
	
	@FindBy(css = "a[href='BalEnqInput.php']")
	private WebElement BalanceEnquiryElem;
	
	public void BalanceEnquiry(String AccountNo) {
		PageFactory.initElements(driver, this);
		BalanceEnquiryElem.click();
		accountNo.sendKeys(AccountNo);
		submit.click();
		//Check that A pop "Account does not exist"
		Page.AssertPopup(Utills.ACCOUNTDOESNOTEXIST);
		//Check that Redirects to Balance Enquiry page
		Page.AssertTitle(Utills.BANKBALANCEENQUIRYPAGE);

	}
	
	public void BalanceEnquiryCustomer(String AccountNo) {
		PageFactory.initElements(driver, this);
		BalanceEnquiryElem.click();
		WebElement DropDown = driver.findElement(By.name("accountno"));  
		Select dropdown = new Select(DropDown);  
		dropdown.selectByVisibleText(AccountNo); 
		submit.click();
	}
}
