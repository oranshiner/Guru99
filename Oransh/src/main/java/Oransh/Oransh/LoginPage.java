package Oransh.Oransh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

	private static final String URL = "http://www.demo.guru99.com/V4/index.php";
	

	LoginPage() {
		super();
	}

	public void login(String id, String password) {
		driver.findElement(By.name("uid")).sendKeys(id);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
	}

	public void openURL() {
		driver = new ChromeDriver();
		super.openURL(URL);
	}
	
	

}
