package Main;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Identify_New_Bikes.Tests;
import Utilities.CaptureScreenshot;
import Utilities.xpath_sub;

public class hondaBikes {

	public static void elementCall_newBike(WebDriver driver) throws InterruptedException {
		WebElement newBike = driver.findElement(By.xpath(xpath_sub.p.getProperty("newBike_XPath"))); // Opening New
																										// bikes Drop
																										// down
		Actions action = new Actions(driver);
		action.moveToElement(newBike).perform();
		Thread.sleep(1000);
		CaptureScreenshot.takeScreenShot(driver);
	}

	public static void elementCall_upcomingBikes(WebDriver driver) {
		WebElement upcoming = driver.findElement(By.xpath(xpath_sub.p.getProperty("upcoming_XPath"))); // Opening Bike
																											// brand
																											// option
																											// from drop
																											// down
		upcoming.click();
	}

	public static void elementCall_dropDown(WebDriver driver) {
		WebElement dropDown = driver.findElement(By.xpath(xpath_sub.p.getProperty("dropDown_XPath"))); // Opening second
																										// drop down
		dropDown.click();
	}

	public static void elementCall_hondaClick(WebDriver driver) throws InterruptedException {
		WebElement honda = driver.findElement(By.xpath(xpath_sub.p.getProperty("honda_XPath"))); // Clicking on Honda
																									// bike option
		honda.click();
	}

	public static void elementCall_hondaScroll(WebDriver driver) {
		Tests.scroll(600); // Initiating Scroll function
	}

	public static void underFourLakhBikes(WebDriver driver) throws InterruptedException {

		 // Fetching Bike features within required range

		try {

			CaptureScreenshot.takeScreenShot(driver);
			List<WebElement> prices = driver.findElements(By.xpath(xpath_sub.p.getProperty("prices_XPath")));

			List<WebElement> names = driver.findElements(By.xpath(xpath_sub.p.getProperty("names_XPath")));

			List<WebElement> launchDates = driver.findElements(By.xpath(xpath_sub.p.getProperty("launchDate_XPath")));

			System.out.println("<================ Upcoming Bikes =======================>");

			for (int i = 0; i < prices.size(); i++) {
				if (Integer.parseInt(prices.get(i).getAttribute("data-price")) < 400000) {

					System.out.println();

					String details[] = new String[3];
					details[0] = names.get(i).getAttribute("title");
					System.out.println("Bike Name : " + " " + details[0]);

					details[1] = prices.get(i).getAttribute("data-price");
					System.out.println("Bike Price : " + "  " + details[1]);

					details[2] = launchDates.get(i).getText();
					System.out.println(
							"Bike Launch Date: " + (details[2].length() > 0 ? details[2].split(":")[1] : "Unrevealed"));
					
				}
			}

			System.out.println();
			System.out.println("<========================================================>");

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
