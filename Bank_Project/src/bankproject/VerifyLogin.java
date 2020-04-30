package bankproject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.DataProvider;


import bankproject.Util;

import org.testng.annotations.*;

public class VerifyLogin {

	static WebDriver driver;
	private static String base_url;

	@DataProvider(name = "TestData")
	public Object[][] testData() {

		Object data[][] = new Object[1][2];

		data[0][0] = Util.USER_ID;
		data[0][1] = Util.PASSWORD;

//		data[1][0] = "invalid";
//		data[1][1] = Util.PASSWORD;
//
//		data[2][0] = Util.USER_ID;
//		data[2][1] = "invalid";
//
//		data[3][0] = "invalid";
//		data[3][1] = "invalid";

		return data;
	}

	@BeforeMethod
	public void openBrowser() {

		System.setProperty("webdriver.gecko.driver", Util.FIREFOX_PATH);
		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		options.setProfile(profile);

		driver = new FirefoxDriver(options);
		base_url = Util.BASE_URL;
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		driver.get(base_url + "/V4/");
	}

	@Test(dataProvider = "TestData")
	public void login(String username, String password) throws IOException {
		String actualBoxMsg;
		// Enter valid UserId
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(username);
		// Enter valid Password
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		// Click Login
		driver.findElement(By.name("btnLogin")).click();

		try {

			Alert alt = driver.switchTo().alert();
			actualBoxMsg = alt.getText(); // get content of the Alter Message
			alt.accept();
			// Compare Error Text with Expected Error Value
			assertEquals(actualBoxMsg, Util.EXPECT_ERROR);

		} catch (NoAlertPresentException Ex) {
			// Get text displayes on login page
			String pageText = driver.findElement(By.tagName("tbody")).getText();

			// Extract the dynamic text mngrXXXX on page
			String[] parts = pageText.split(Util.PATTERN);
			String dynamicText = parts[1];
			System.out.println(dynamicText);

			// Check that the dynamic text is of pattern mngrXXXX
			// First 4 characters must be "mngr"
			// get the substring after index 1 till index 5
			assertTrue(dynamicText.substring(1, 5).equals(Util.FIRST_PATTERN));
			// remain stores the "XXXX" in pattern mngrXXXX
			//substring explanation -> dynamicText= mngr257529,
			//dynamicText.length()=11(with counting the space/blank), 
			//so 11-6=5, so beginIndex starts after 5, so ( mngr), hence result is 257529 
			String remain = dynamicText.substring(dynamicText.length() - 6);
			System.out.println(dynamicText.length());
			System.out.println(remain);
			// Check remain string must be numbers;
			assertTrue(remain.matches(Util.SECOND_PATTERN));
			// Code to take Screenshot
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Code to save screenshot at desired location
			FileUtils.copyFile(scrFile, new File("d:\\screenshot.png"));
			
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
