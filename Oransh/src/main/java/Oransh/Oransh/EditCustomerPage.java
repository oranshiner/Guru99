package Oransh.Oransh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage extends Page{
	
	public EditCustomerPage() {
		super();
	}
	
	@FindBy(name = "AccSubmit")
	WebElement submit;

	@FindBy(name = "cusid")
	WebElement customerId;
	
	@FindBy(css = "a[href='EditCustomer.php']")
	private WebElement EditCustomerElem;

	public void EditCustomer(String CustomerNo) {
		PageFactory.initElements(driver, this);
		EditCustomerElem.click();
		customerId.sendKeys(CustomerNo);
		submit.click();
	}
}
