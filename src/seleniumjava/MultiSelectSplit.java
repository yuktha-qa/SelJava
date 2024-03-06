package seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectSplit {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");

		driver.switchTo().frame("iframeResult");
		WebElement eleOpt = driver.findElement(By.id("cars")); // focusing / finding the webelement
		Select sel = new Select(eleOpt); // accessing the multi select list
		sel.selectByIndex(0);
		sel.selectByValue("audi");
		sel.selectByVisibleText("Saab");

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		String out = driver.findElement(By.xpath("//div[@class='w3-container w3-large w3-border']")).getText();
		System.out.println(out);

		// This will split the output with regex & store in an array and print
		String[] arrSplit = out.split("&");
		for (int i = 0; i < arrSplit.length; i++) {
			System.out.println(arrSplit[i]);
		}
	}
}
