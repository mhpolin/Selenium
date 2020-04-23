package selenium.webdriver.basicagain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseElementLocatorTechniques {
	
	WebDriver driver;

	public void invokebrowser(String url) {

		try {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get(url);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void elementLocatorsTechniquesUsingAmazon() {
		try {
			invokebrowser("http://www.amazon.in");
			driver.findElement(By.linkText("Amazon Pay")).click();
			driver.navigate().back();
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptops");
			driver.findElement(By.className("nav-input")).click();
			driver.navigate().back();
			driver.findElement(By.partialLinkText("Customer")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void elementLocatorsTechniquesFacebook() {
		
		try {
			invokebrowser("http://facebook.com");
			driver.findElement(By.name("firstname")).sendKeys("blabla");
			driver.findElement(By.cssSelector("input#email")).sendKeys("mmmmmm");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UseElementLocatorTechniques obj = new UseElementLocatorTechniques();
		//obj.elementLocatorsTechniquesUsingAmazon();
		obj.elementLocatorsTechniquesFacebook();

	}

}
