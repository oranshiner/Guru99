package Oransh.Oransh;

import org.openqa.selenium.By;

public class SideBarCustomer extends Page{
	public SideBarCustomer() {
		super();
		
	}
	
	public static void changePasswordButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[4]/a")).click();
	}
	
	public static void BalanceEnquiryButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
	}
	
	public static void MinistatementButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[5]/a")).click();
	}

	public static void FundTransferButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]/a")).click();
	}
	
	public static void CustomisedStatementButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[6]/a")).click();
	}
	
	
}
