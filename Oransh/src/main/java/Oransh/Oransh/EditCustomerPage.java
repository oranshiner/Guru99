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
	
	public void EditCustomer(String CustomerNo) {
		PageFactory.initElements(driver, this);
		customerId.sendKeys(CustomerNo);
		submit.click();
	}
}
