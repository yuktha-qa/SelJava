package seleniumjava;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");

		driver.switchTo().frame("iframeResult");
		// xpath for iframe //iframe[@id='iframeResult']

		WebElement eleOpt = driver.findElement(By.id("cars")); // focusing / finding the webelement
		Select sel = new Select(eleOpt); // accessing the multi select list
		sel.selectByIndex(0);
		sel.selectByValue("audi");
		sel.selectByVisibleText("Saab");

		List<WebElement> selectedOpt = sel.getAllSelectedOptions();
		System.out.println(selectedOpt.size());

		for (int i = 0; i < selectedOpt.size(); i++) {
			System.out.println(selectedOpt.get(i).getText());

		}

		driver.manage().window().minimize();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		String out = driver.findElement(By.xpath("//div[@class='w3-container w3-large w3-border']")).getText();
		System.out.println(out);

		driver.close();
	}
}
