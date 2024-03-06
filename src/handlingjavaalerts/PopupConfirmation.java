package handlingjavaalerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupConfirmation {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("// button[text()='Click for JS Confirm']")).click();
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("result")).getText());

	}
}
