
package Main;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Identify_New_Bikes.Tests;
import Utilities.CaptureScreenshot;
import Utilities.excelreadwrite;
import Utilities.xpath_sub;

public class loginGoogle extends Tests {

	public static WebElement login;
	public static WebElement googleClick;
	public static WebElement emailField;
	public static WebElement nextButton;

	public static void home(WebDriver driver) {
		WebElement home = driver.findElement(By.xpath(xpath_sub.p.getProperty("home_XPath")));		// Calling home function
		home.click();
	}

	public static void loginClick(WebDriver driver) {

		login = driver.findElement(By.xpath(xpath_sub.p.getProperty("login_XPath")));			// Clicking login Option
		login.click();

	}

	public static void googleClick(WebDriver driver) throws InterruptedException {
		googleClick = driver.findElement(By.xpath(xpath_sub.p.getProperty("GoogleClick_XPath")));			//	Choosing Google as Login Option
		googleClick.click();
		Thread.sleep(2000);
	}

	public static void windowHandle(WebDriver driver) {
			Tests.widHandle();				// Initiating Window Handle Function
	}

	public static void enterEmail(WebDriver driver) {
		emailField = driver.findElement(By.xpath(xpath_sub.p.getProperty("emailField_XPath")));
		emailField.sendKeys(excelreadwrite.incorrect_email);
		CaptureScreenshot.takeScreenShot(driver);
	}

	public static void nextButton(WebDriver driver) throws InterruptedException {
			nextButton = driver.findElement(By.xpath(xpath_sub.p.getProperty("nextField_XPath")));			//	Fetching incorrect email data from excel to email Field
			nextButton.click();
			Thread.sleep(3000);
			CaptureScreenshot.takeScreenShot(driver);
	}

	// testing methods for regression testing
	public static void regressionTest(WebDriver driver) throws InterruptedException {
		emailField = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));				// Fetching correct email data from excel to email Field
		emailField.sendKeys(excelreadwrite.correct_email);
		nextButton = driver.findElement(By.xpath(xpath_sub.p.getProperty("nextField_XPath")));			//	Fetching incorrect email data from excel to email Field
		nextButton.click();
		Thread.sleep(3000);
		CaptureScreenshot.takeScreenShot(driver);
	}
}
