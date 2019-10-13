package Oransh.Oransh;

import org.junit.After;
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


	@Parameterized.Parameter(0)
	public String username; // This is the user name parameter
	@Parameterized.Parameter(1)
	public String password; // This is the password parameter
	@Parameterized.Parameter(2)
	public boolean shouldLogin;

	@Parameterized.Parameters
	public static Collection<Object[]> testExecutionParameters() {
		return Arrays.asList(new Object[][] { { "mngr225054", "marYgaq!1", true }, // Valid User Name and password
				// {"mngr225053", "marYga", false}//, //InValid User Name and password
				// {"mngr225054", "marYga", false}, //Valid User Name and InValid password
				// ****** ביטלתי שלא סתם יפתחו 4 בבדיקות שלי
				// {"mngr225053", "marYgaq", false} //InValid User Name and Valid password
				// ****** ביטלתי שלא סתם יפתחו 4 בבדיקות שלי

		});
	}

	@Test
	public void loginTest() throws IOException {
		this.username = username;
		this.password = password;
		LoginPage newUser = new LoginPage();
		newUser.openURL();
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
