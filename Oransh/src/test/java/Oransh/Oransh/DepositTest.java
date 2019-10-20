package Oransh.Oransh;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class DepositTest extends Page {

	@Before
	public void before() {
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		driver.manage().window().maximize();
		newUser.login(Utills.MANAGERID, Utills.MANAGERPASS);
	}

	@After
	public void finish() {
		if (driver != null)
			driver.close();
	}

	@Test // Manager
	public void Deposit() {
		// SM24
		// Verify deposit can be made to another account
		DepositPage depositPage = new DepositPage();
		depositPage.Deposit(Utills.accnum, Utills.amount, Utills.desc);
		String TransactionDetails = driver.findElement(By.xpath("//*[@id=\"deposit\"]/tbody/tr[1]/td/p")).getText();
		assertEquals("Transaction details of Deposit for Account " + Utills.accnum, TransactionDetails);
		String AccountNo = driver.findElement(By.xpath("//*[@id=\"deposit\"]/tbody/tr[7]/td[2]")).getText();
		assertEquals(Utills.accnum, AccountNo);
		String AmountCredited = driver.findElement(By.xpath("//*[@id=\"deposit\"]/tbody/tr[12]/td[2]")).getText();
		assertEquals(Utills.amount, AmountCredited);
		String TypeOfTransaction = driver.findElement(By.xpath("//*[@id=\"deposit\"]/tbody/tr[16]/td[2]")).getText();
		assertEquals(Utills.Type, TypeOfTransaction);

	}

}
