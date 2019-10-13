package Oransh.Oransh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

	private static final String URL = "http://www.demo.guru99.com/V4/index.php";
	@FindBy(name = "uid")
    WebElement Id;	
	
	@FindBy(name = "password")
    WebElement Pass;	

	@FindBy(name = "btnLogin")
    WebElement LogInButton;

	LoginPage() {
		super();
	}

	public void login(String id, String password) {
		PageFactory.initElements(driver, this);
		Id.sendKeys(id);
        Pass.sendKeys(password);
        LogInButton.click();
        

	}

	public void openURL() {
		driver = new ChromeDriver();
		super.openURL(URL);
	}
	
	

}
