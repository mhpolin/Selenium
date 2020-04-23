package selenium.webdriver.basicagain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicAgain {
	
    WebDriver driver;
    JavascriptExecutor jse;
	
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://www.edureka.co");
			searchCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void searchCourse() {
		
		try {
			driver.findElement(By.id("search-inp3")).click();
			driver.findElement(By.id("search-inp-overlay-new")).sendKeys("Java");
			Thread.sleep(3000);
			driver.findElement(By.id("search-button-top")).click();
			//driver.findElement(By.id("filterdropdown")).click();
			//driver.findElement(By.id("_Frontend_Developer_")).click();
			//driver.findElement(By.xpath("//label[contains(text(),'_Frontend_Developer_')]")).click();
			jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll (0,1000)");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeleniumBasicAgain myObj = new SeleniumBasicAgain();
		myObj.invokeBrowser();
		

	}

}
