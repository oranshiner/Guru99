package Oransh.Oransh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepositPage extends Page{
	
	public DepositPage() {
		super();
	}
	
	@FindBy(name = "accountno")
	WebElement accountNo;
	
	@FindBy(name = "ammount")
	WebElement Ammount;
	
	@FindBy(name = "desc")
	WebElement description;
	
	@FindBy(name = "AccSubmit")
	WebElement submit;

	public void Deposit(String CustomerNo,String Anount,String Massage) {
		PageFactory.initElements(driver, this);
		accountNo.sendKeys(CustomerNo);
		Ammount.sendKeys(Anount);
		description.sendKeys(Massage);
		submit.click();

	}
}
