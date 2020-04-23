package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGAssertion {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {

		try {
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get("http://gmail.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testEquality() {
		Assert.assertEquals(true, isEqual(10, 10));
		System.out.println("BooBoo");
	}

	public boolean isEqual(int a, int b) {
		if (a == b) {
			return true;
		} else {
			return false;
		}
	}

	@Test
	public void getTittle() {
		String tittle = driver.getTitle();
		Assert.assertEquals(tittle, "Gmail");
		System.out.println("Nyaaaaa");
	}

	

}