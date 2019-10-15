package Oransh.Oransh;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class DepositTest extends Page {
	String OriginalPass = "marYgaq!1";
	String mannagerId = "mngr225054";

	@Before
	public void before() {
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		driver.manage().window().maximize();
		newUser.login(mannagerId, OriginalPass);
	}

	@After
	public void finish() {
		if (driver != null)
			driver.close();
	}

	@Test // Manager
	public void Deposit() {
		// SM24
		// 70279 is a Testing Account.
		String accnum = "70279";
		String amount = "1";
		String Type = "Deposit";
		String desc = "Test";
		// Verify deposit can be made to another account
		Sidebar.DepositButton();
		DepositPage depositPage = new DepositPage();
		depositPage.Deposit(accnum, amount, desc);
		String TransactionDetails = driver.findElement(By.xpath("//*[@id=\"deposit\"]/tbody/tr[1]/td/p")).getText();
		assertEquals("Transaction details of Deposit for Account 70279", TransactionDetails);
		String AccountNo = driver.findElement(By.xpath("//*[@id=\"deposit\"]/tbody/tr[7]/td[2]")).getText();
		assertEquals(accnum, AccountNo);
		String AmountCredited = driver.findElement(By.xpath("//*[@id=\"deposit\"]/tbody/tr[12]/td[2]")).getText();
		assertEquals(amount, AmountCredited);
		String TypeOfTransaction = driver.findElement(By.xpath("//*[@id=\"deposit\"]/tbody/tr[16]/td[2]")).getText();
		assertEquals(Type, TypeOfTransaction);

	}

}
