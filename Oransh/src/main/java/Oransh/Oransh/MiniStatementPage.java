package Oransh.Oransh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiniStatementPage extends Page{
	
	public MiniStatementPage() {
		super();
	}

	@FindBy(name = "accountno")
	WebElement accountNo;
	
	@FindBy(name = "AccSubmit")
	WebElement submit;
	
	
	public void MiniStatement(String AccountNo) {
		PageFactory.initElements(driver, this);
		accountNo.sendKeys(AccountNo);
		submit.click();
	}

}
