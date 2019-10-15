package Oransh.Oransh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage extends Page{
	
	public NewCustomerPage() {
		super();
	}
	
	@FindBy(name = "name")
	WebElement name;
	
	@FindBy(name = "dob")
	WebElement dob;
	
	@FindBy(name = "addr")
	WebElement addr;
	
	@FindBy(name = "city")
	WebElement city;
	
	@FindBy(name = "state")
	WebElement state;
	
	@FindBy(name = "pinno")
	WebElement pinno;
	
	@FindBy(name = "telephoneno")
	WebElement telephoneno;
	
	@FindBy(name = "emailid")
	WebElement emailid;
	
	@FindBy(name = "password")
	WebElement password1;
	
	@FindBy(name = "sub")
	WebElement sub;


	public void NewCustomerDetails(String CustomerName, String Birthdate, String Address, String City,
		String Pin, String Mobile, String Email, String State, String password) {
		PageFactory.initElements(driver, this);
		name.sendKeys(CustomerName);
		dob.sendKeys(Birthdate);
		addr.sendKeys(Address);
		city.sendKeys(City);
		state.sendKeys(State);
		pinno.sendKeys(Pin);
		telephoneno.sendKeys(Mobile);
		emailid.sendKeys(Email);
		password1.sendKeys(password);
		sub.click();
	}
}
