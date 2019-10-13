package Oransh.Oransh;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sidebar extends Page{
	public Sidebar() {
		super();
		
	}

	public static void changePasswordButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[11]/a")).click();
	}
	
	public static void AddNewCustomerButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
	}
	
	public static void AddNewAccountButton() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[5]/a")).click();
	}
	
	public static void DeleteAccountButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[7]/a")).click();
	}
	
	public static void MiniStatementButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[13]/a")).click();
	}
	public static void BalanceEnquiryButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[12]/a")).click();
	}
	
	public static void CustomisedStatementButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[14]/a")).click();
	}
}
