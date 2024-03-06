import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TypeOfWebElements {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.letskodeit.com/practice");
		WebElement rad = driver.findElement(By.id("bmwradio"));
		rad.click();
		System.out.println("BMW Radio Button is Selected : " + rad.isSelected());

		WebElement chk = driver.findElement(By.id("bmwcheck"));
		chk.click();

		driver.findElement(By.id("openwindow")).click();

		driver.findElement(By.id("opentab")).click();

		WebElement sel = driver.findElement(By.id("carselect"));
		Select singleSel = new Select(sel);
		singleSel.selectByIndex(0);

		WebElement msel = driver.findElement(By.id("multiple-select-example"));
		Select multiSel = new Select(msel);
		multiSel.selectByValue("orange");

		driver.findElement(By.id("autosuggest")).sendKeys("Earn");

		driver.findElement(By.id("autosuggest")).sendKeys("Earning");

		driver.findElement(By.id("disabled-button")).click();
		System.out.println("Disable Button");
		System.out.println("Enabled/ Disabled Text Box is Enabled? "
				+ driver.findElement(By.id("enabled-example-input")).isEnabled());

		System.out.println("Enabled/ Disabled Text Box is Displayed? "
				+ driver.findElement(By.id("enabled-example-input")).isDisplayed());

		Thread.sleep(2000);

		driver.findElement(By.id("enabled-button")).click();
		System.out.println("Enable Clicked");
		System.out.println("Enabled/ Disabled Text Box is Enabled? "
				+ driver.findElement(By.id("enabled-example-input")).isEnabled());

		System.out.println("Enabled/ Disabled Text Box is Displayed? "
				+ driver.findElement(By.id("enabled-example-input")).isDisplayed());

		Thread.sleep(3000);
		driver.findElement(By.id("enabled-example-input")).sendKeys("Earning");

		Thread.sleep(2000);
		driver.findElement(By.id("enabled-example-input")).clear();

		Thread.sleep(2000);
		driver.findElement(By.id("show-textbox")).click();
		System.out.println(
				"Hide/Show Text Box is Displayed : " + driver.findElement(By.id("displayed-text")).isDisplayed());
		// can be is enabled too as it is.
		driver.findElement(By.id("displayed-text")).sendKeys("Earning");

		driver.findElement(By.id("hide-textbox")).click();
		System.out.println(
				"Hide/Show Text Box is Displayed : " + driver.findElement(By.id("displayed-text")).isDisplayed());

		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();

		driver.findElement(By.id("name")).sendKeys("Earning");

	}
}
