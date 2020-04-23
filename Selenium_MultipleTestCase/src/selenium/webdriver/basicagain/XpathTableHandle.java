package selenium.webdriver.basicagain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class XpathTableHandle {
	
	WebDriver driver;
	
	public void startBrowser () {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		writeXpathTable();
	}
	
	public void writeXpathTable() {
//		driver.get("http://demo.guru99.com/test/write-xpath-table.html");
//		String innerText = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
//		System.out.println(innerText);
		
		// Accessing Nested Table
//		driver.get("http://demo.guru99.com/test/accessing-nested-table.html");
//		String innerText3 = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]")).getText(); 		
//		System.out.println(innerText3);
		
		//Using Attributes as Predicates
//		driver.get("http://demo.guru99.com/test/newtours/");
//		String innerText2 = driver.findElement(By.xpath("//table[@width=\"270\"]/tbody/tr[4]/td")).getText(); 		
//		System.out.println(innerText2);
		
		driver.get("http://demo.guru99.com/test/newtours/");
		String innerText4 = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[1]/table[2]/tbody[1]/tr[3]/td[2]/font[1]")).getText(); 		
		System.out.println(innerText4);
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XpathTableHandle obj = new XpathTableHandle();
		obj.startBrowser();
		

	}

}
