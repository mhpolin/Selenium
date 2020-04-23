package selenium.webdriver.basicagain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectValueDropdown {

	WebDriver driver;

	public void invokebrowser() {

		try {
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get("http://demo.guru99.com/test/newtours/register.php");
			dropdownValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void dropdownValue() {

		try {
			Select drpCountry = new Select (driver.findElement(By.name("country")));
			drpCountry.selectByVisibleText("BANGLADESH");
			
			if (drpCountry.isMultiple()) {
				System.out.println("Multiple Selectable Dropdown");
			}
			else {
				System.out.println("Dropdown is not Multiple Selectable");
			}

			//Selecting Items in a Multiple SELECT elements
			driver.get("http://jsbin.com/osebed/2");
			Select drpFruits = new Select (driver.findElement(By.id("fruits")));
			
			drpFruits.selectByValue("banana");
			drpFruits.selectByVisibleText("Apple");
			drpFruits.selectByIndex(3);
			
			drpFruits.deselectByValue("banana");
			drpFruits.deselectByVisibleText("Apple");
			drpFruits.deselectByIndex(3);
			
			drpFruits.selectByValue("orange");
			drpFruits.selectByIndex(1);
			
			if (drpFruits.isMultiple()) {
				System.out.println("Multiple Selectable Dropdown");
			}
			else {
				System.out.println("Dropdown is not Multiple Selectable");
			}
			
			Thread.sleep(2000);
			drpFruits.deselectAll();

			Thread.sleep(2000);
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectValueDropdown obj = new SelectValueDropdown();
		obj.invokebrowser();

	}

}
