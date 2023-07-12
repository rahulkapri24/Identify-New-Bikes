package Utilities;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class driverSetup {
	static WebDriver driver;
	public static Properties properites;
	public static String url = "https://www.zigwheels.com/";
	public static String browserName;

	public static WebDriver driverInstantiate(String browser) throws InterruptedException {

		browserName = browser;
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Input");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);

		return driver;
	}
}
