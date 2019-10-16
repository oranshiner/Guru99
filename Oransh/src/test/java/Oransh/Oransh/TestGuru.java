package Oransh.Oransh;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import junit.framework.Assert;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class TestGuru extends Page {
	
	@Before
    public void before() {
		LoginPage newUser = new LoginPage();
		newUser.openURL();
		driver.manage().window().maximize();
	}

	@Parameterized.Parameter(0)
	public String username; // This is the user name parameter
	@Parameterized.Parameter(1)
	public String password; // This is the password parameter
	@Parameterized.Parameter(2)
	public boolean shouldLogin;

	@Parameterized.Parameters
	public static Collection<Object[]> testExecutionParameters() {
		return Arrays.asList(new Object[][] { { Utills.mannagerId,Utills.mannagerPass, true }, // Valid User Name and password
				 {Utills.inValidmannagerId,Utills.inValidManagerPass, false}, //InValid User Name and password
				 {Utills.mannagerId, Utills.inValidManagerPass, false}, //Valid User Name and InValid password
				 {Utills.inValidmannagerId, Utills.mannagerPass, false} //InValid User Name and Valid password

		});
	}

	@Test
	public void loginTest() throws IOException {
		this.username = username;
		this.password = password;
		LoginPage newUser = new LoginPage();
		newUser.takeScreenshot("E:\\java\\loginPage.png");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		newUser.login(username, password);
		HomePage.isHomePage();

	}

	@After
	public void finish() {
		if (driver != null)
			driver.close();
	}

}
