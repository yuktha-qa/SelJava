package seleniumjava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class locators {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Dimension d = new Dimension(100, 700);
		driver.manage().window().setSize(d);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://vindeep.com/Calculators/FDCalc.aspx");

		driver.findElement(By.id("ContentPlaceHolder1_cphCentre_FDAmount")).clear();
		driver.findElement(By.id("ContentPlaceHolder1_cphCentre_FDAmount")).sendKeys("500000");

		driver.findElement(By.name("ctl00$ContentPlaceHolder1$cphCentre$Period")).clear();
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$cphCentre$Period")).sendKeys("30");

		/*
		 * WebElement dur =
		 * driver.findElement(By.id("ContentPlaceHolder1_cphCentre_PeriodDropDown"));
		 * Select sel = new Select(dur); sel.selectByValue("Days"); Same can be written
		 * in single line
		 */

		Select sel = new Select(driver.findElement(By.id("ContentPlaceHolder1_cphCentre_PeriodDropDown")));
		sel.selectByIndex(2);

		driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_cphCentre_InterestRate']")).clear();
		driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_cphCentre_InterestRate']")).sendKeys("5.5");

		Select sel1 = new Select(driver.findElement(By.id("ContentPlaceHolder1_cphCentre_FrequencyDropDown")));
		sel1.selectByVisibleText("Monthly");

		driver.findElement(By.id("ContentPlaceHolder1_cphCentre_btnFDMAmount")).click();

		Thread.sleep(3000); // If this is not given we wont get the fdamt and fdint as the website takes
							// time to load.
		String fdamt = driver.findElement(By.id("ContentPlaceHolder1_cphCentre_MaturityAmountTextBox"))
				.getAttribute("value"); // value="2,593,694"
		System.out.println("FD Amount = " + fdamt);

		driver.manage().window().minimize();
		Thread.sleep(3000);

		driver.manage().window().maximize(); // After maximising an AD pops up. during run time, is it possible to
												// handle them?

		Thread.sleep(3000);
		String fdint = driver.findElement(By.id("ContentPlaceHolder1_cphCentre_FDInterestTB")).getAttribute("value");// value="2,093,694
		System.out.println("FD Interest = " + fdint);

		driver.quit();

		/*
		 * Since we need attribute value of the text box for fd amount we use
		 * getAtrribute(String) method <input
		 * name="ctl00$ContentPlaceHolder1$cphCentre$MaturityAmountTextBox" type="text"
		 * value="2,593,694" readonly="readonly"
		 * id="ContentPlaceHolder1_cphCentre_MaturityAmountTextBox"
		 * style="color:#009900;font-family:Arial;font-size:Medium;
		 * font-weight:bold;height:25px;width:125px;text-align:right">
		 * 
		 * Copy Outer HTML <input
		 * name="ctl00$ContentPlaceHolder1$cphCentre$FDInterestTB" type="text"
		 * value="2,093,694" readonly="readonly"
		 * id="ContentPlaceHolder1_cphCentre_FDInterestTB"
		 * style="color:#009900;font-family:Arial;font-size:Medium;
		 * font-weight:normal;height:25px;width:125px;text-align:right">
		 *
		 */
	}
}
