package Oransh.Oransh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage extends Page{
	
	public DeleteCustomerPage() {
		super();
	}
	
	@FindBy(name = "cusid")
	WebElement customerId;
	
	@FindBy(name = "AccSubmit")
	WebElement submit;

	public void DeleteCustomer(String CustomerNo) {
		PageFactory.initElements(driver, this);
		customerId.sendKeys(CustomerNo);
		submit.click();
	}
}
