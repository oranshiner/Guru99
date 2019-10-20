package Oransh.Oransh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomizedstatementPage extends Page{
	
	public CustomizedstatementPage() {
		super();
	}
	
	@FindBy(name = "accountno")
	WebElement accountNo;
	
	@FindBy(name = "AccSubmit")
	WebElement submit;
	
	@FindBy(css = "a[href='CustomisedStatementInput.php']")
	private WebElement CustomizedstatementElem;

	public void Customizedstatement(String AccountNo) {
		PageFactory.initElements(driver, this);
		CustomizedstatementElem.click();
		accountNo.sendKeys(AccountNo);
		submit.click();
		//Check that A pop "Account does not exist"
		Page.AssertPopup(Utills.ACCOUNTDOESNOTEXIST);
		//Check that Redirects to Balance Enquiry page
		Page.AssertTitle(Utills.BANKSTATEMENTPAGE);
	}
}
