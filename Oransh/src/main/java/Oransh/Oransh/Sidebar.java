package Oransh.Oransh;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Sidebar {
	protected static WebDriver driver;

	public static void changePasswordButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[11]/a")).click();
	}
}
