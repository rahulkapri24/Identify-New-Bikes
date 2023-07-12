package Identify_New_Bikes;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Main.hondaBikes;
import Main.loginGoogle;
import Main.usedCar;
import Utilities.ExtentTestManager;
import Utilities.excelreadwrite;
import Utilities.xpath_sub;

public class Tests {
	public static WebDriver driver;
	public static ArrayList<String> window_list;

	@BeforeClass(groups = { "Smoke", "Regression" })
	public void driverConfig() throws InterruptedException, FileNotFoundException {

		ExtentTestManager.startTest("Driver Setup", "Taking user input and Setting up the driver");

		xpath_sub.readXpath(); // Reading from properties file
		excelreadwrite.readexcel(); // Reading from excel file

		// Providing Choice for browsers
		System.out.println("Enter Your Browser Choice:\n 1. Chrome\n 2. Edge");
		Scanner sc = new Scanner(System.in);
		int browser_choice = Integer.parseInt(sc.nextLine());
		if (browser_choice == 1) {
			driver = Utilities.driverSetup.driverInstantiate("Chrome");
		} else if (browser_choice == 2) {
			driver = Utilities.driverSetup.driverInstantiate("Edge");
		} else {
			System.out.println("Wrong Input");
			System.exit(0);
		}

		sc.close();
	}

	@Test(priority = 1, groups = { "Smoke", "Regression" })
	public static void elementCall_newBike() throws InterruptedException {
		ExtentTestManager.startTest("Clicking New Bikes", "Clicking on New Bikes");
		hondaBikes.elementCall_newBike(driver); // Opening New bikes Drop down
	}

	@Test(priority = 2, groups = { "Smoke", "Regression" })
	public static void elementCall_bikeBrand() {
		ExtentTestManager.startTest("Clicking Upcoming Bikes Option",
				"Clicking on upcoming bikes option in the dropdown");
		hondaBikes.elementCall_upcomingBikes(driver); // Opening Upcoming Bikes option from drop down
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" })
	public static void elementCall_dropDown() {
		ExtentTestManager.startTest("Opening bike brand dropdown", "Opening bike brand dropdown to select Honda");
		hondaBikes.elementCall_dropDown(driver); // Opening bike brand drop down
	}

	@Test(priority = 4, groups = { "Smoke", "Regression" })
	public static void elementCall_hondaClick() throws InterruptedException {
		ExtentTestManager.startTest("Clicking on Honda Bikes", "Clicking on Honda Bikes Option in the dropdown");
		hondaBikes.elementCall_hondaClick(driver); // Clicking on Honda bike option
	}

	@Test(priority = 5, groups = { "Smoke", "Regression" })
	public static void elementCall_hondaScroll() {
		ExtentTestManager.startTest("Scrolling the page", "Scroll the upcoming bikes page");
		hondaBikes.elementCall_hondaScroll(driver); // Initiating Scroll function
	}

	@Test(priority = 6, groups = { "Smoke", "Regression" })
	public static void elementCall_list() throws InterruptedException {
		ExtentTestManager.startTest("Printing bike details under 4 Lakh",
				"Printing details of bikes under 4 Lakh in console");
		hondaBikes.underFourLakhBikes(driver); // Fetching Bike features within required range
	}

	@Test(priority = 7, groups = { "Regression" })
	public static void useCar_home() {
		ExtentTestManager.startTest("Click on Logo", "Clicking on Logo to go back to Homepage");
		usedCar.useCar_backhome(driver); // Calling home function
	}

	@Test(priority = 8, groups = { "Regression" })
	public static void useCar_usedCar() {
		ExtentTestManager.startTest("Clicking Used Car Dropdown", "Clicking on used car doprdown");
		usedCar.useCar_usedCar(driver); // Clicking Used Car drop down
	}

	@Test(priority = 9, groups = { "Regression" })
	public static void useCar_ChooseCity() {
		ExtentTestManager.startTest("Choosing required city from the dropdown",
				"Choosing Chennai as the required city from the dropdown");
		usedCar.useCar_chooseCity(driver); // Choosing required City
	}

	@Test(priority = 10, groups = { "Regression" })
	public static void useCar_scroll() {
		ExtentTestManager.startTest("Scrolling the page", "Scrolling the used car page");
		usedCar.useCar_pageScroll(); // Initiating Scroll function
	}

	@Test(priority = 11, groups = { "Regression" })
	public static void useCar_list() {
		ExtentTestManager.startTest("Printing popular brands", "Printing details of popular brands in console");
		usedCar.getPopularModels(driver); // Fetching popular models of Used Cars
	}

	@Test(priority = 12, groups = { "Regression" })
	public static void login_home() {
		ExtentTestManager.startTest("Clicking on logo", "Clicking on logo to open Homepage");
		loginGoogle.home(driver); // Calling home function
	}

	@Test(priority = 13, groups = { "Regression" })
	public static void loginClick() {
		ExtentTestManager.startTest("Clicking Login button", "Clicking Login button on Homepage");
		loginGoogle.loginClick(driver); // Clicking login Option
	}

	@Test(priority = 14, groups = { "Regression" })
	public static void googleClick() throws InterruptedException {
		ExtentTestManager.startTest("Clicking Google Login option", "Clicking on Google option to test Login");
		loginGoogle.googleClick(driver); // Choosing Google as Login Option
	}

	@Test(priority = 15, groups = { "Regression" })
	public static void windowHandle() {
		ExtentTestManager.startTest("Switching tabs", "Switching tabs using Window handle");
		loginGoogle.windowHandle(driver); // Initiating Window Handle Function
	}

	@Test(priority = 16, groups = { "Regression" })
	public static void emailClick() throws InterruptedException, IOException {
		ExtentTestManager.startTest("Enter email", "Enter incorrect email fetched from excel file");
		loginGoogle.enterEmail(driver); // Fetching incorrect email data from excel to email Field
	}

	@Test(priority = 17, groups = { "Regression" })
	public static void nextButton() throws InterruptedException {
		ExtentTestManager.startTest("Clicking Next Button",
				"Clicking Next Button on Google Login to test incorrect data");
		loginGoogle.nextButton(driver); // Clicking next Button
	}

	public static void scroll(int n) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + n + ")"); // Using JavaScript Executor to
																						// scroll
	}

	public static void widHandle() {
		window_list = new ArrayList<String>(driver.getWindowHandles()); // Using Window handle to switch windows
		driver.switchTo().window(window_list.get(1));
	}

	@AfterClass(groups = { "Smoke", "Regression" })
	public void quit() {
		driver.quit(); // closing all instances of Web browser
	}

}