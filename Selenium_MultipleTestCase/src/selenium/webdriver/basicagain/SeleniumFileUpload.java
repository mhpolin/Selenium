package selenium.webdriver.basicagain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFileUpload {

	WebDriver driver;

	public void invokebrowser() {

		try {
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get("http://demo.guru99.com/test/upload/");
			uploadFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void uploadFile() {
		// enter the file path onto the file-selection input field
		driver.findElement(By.id("uploadfile_0")).sendKeys("F:\\gesamtPP.pdf");
		// check the "I accept the terms of service" check box
		driver.findElement(By.id("terms")).click();
		// click the "SubmitFile" button
		driver.findElement(By.name("send")).click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeleniumFileUpload obj = new SeleniumFileUpload();
		obj.invokebrowser();

	}

}
