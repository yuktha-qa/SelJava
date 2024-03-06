package seleniumjava;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VindeepArraylist {
	public static void main(String[] args) {

		// expected data vs actual data
		ArrayList<String> expData = new ArrayList<>();
		expData.add("Days");
		expData.add("Months");
		expData.add("Years");
		for (int i = 0; i < expData.size(); i++) {
			System.out.println(expData.get(i) + " = " + expData.get(i).length());// length() gives the length of
																					// alphabets
		}

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://vindeep.com/Calculators/FDCalc.aspx");

		Select opt = new Select(driver.findElement(By.id("ContentPlaceHolder1_cphCentre_PeriodDropDown")));
		opt.selectByVisibleText("Months");
		/*
		 * mandatory line otherwise o/p [[[[ChromeDriver: chrome on windows
		 * (35fdd024a5bc2d5883f01242a11a5eed)] -> id:
		 * ContentPlaceHolder1_cphCentre_PeriodDropDown]] -> tag name: option]
		 */

		List<WebElement> actData = opt.getOptions();
		System.out.println("Actual Size of the DropDown = " + actData.size());

		System.out.println("Compare Expected vs Actual Data");
		for (int i = 0; i < actData.size(); i++) {
			System.out.print(actData.get(i).getText() + " = ");

			if ((actData.get(i).getText()).equals(expData.get(i))) {
				System.out.println("Matched");
			} else {
				System.out.println("Not Matched");
			}

		}
	}
}
