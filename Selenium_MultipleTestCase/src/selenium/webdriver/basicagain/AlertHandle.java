package selenium.webdriver.basicagain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandle {



	public static void main(String[] args)throws NoAlertPresentException,InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/delete_customer.php");

		driver.findElement(By.name("cusid")).sendKeys("53920");					
		driver.findElement(By.name("submit")).submit();

		// Switching to Alert  
		Alert alert = driver.switchTo().alert();
		// Capturing alert message
		String alertMsg = driver.switchTo().alert().getText();
		// Displaying alert message
		System.out.println(alertMsg);
		Thread.sleep(5000);
		// Accepting alert
		alert.accept();
		driver.quit();



	}

}
