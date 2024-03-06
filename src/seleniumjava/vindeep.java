package seleniumjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class vindeep {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://vindeep.com/");
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		// title can be found either though view page source or inspect
		if (title.equals("VINDEEP.COM - Money & Finance and Spreadsheets")) {
			System.out.println("Title Matched");
		} else {
			System.out.println("Title Unmatched");
		}
		driver.close();

		/*
		 * get the title from view page source/ inspect Head id <title> Fixed Deposit Calculator
		 * | Calculate FD Interest, Maturity value </title>
		 */
	}
}
