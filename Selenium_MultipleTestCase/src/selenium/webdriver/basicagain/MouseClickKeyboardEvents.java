package selenium.webdriver.basicagain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseClickKeyboardEvents {
	
	WebDriver driver;

	public void invokebrowser() {

		try {
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get("http://demo.guru99.com/test/newtours/");
			mouseHover();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public void mouseHover() {
		
		WebElement linkHome = driver.findElement(By.linkText("Home"));
		WebElement tdHome = driver.findElement(By.xpath("//html/body/div"+"/table/tbody/tr/td"
				+ "/table/tbody/tr/td"+"/table/tbody/tr/td"+"/table/tbody/tr"));
		Actions builder = new Actions(driver);		
		Action mouseOverHome = builder.moveToElement(linkHome).build();
		
		String bgColor = tdHome.getCssValue("background-color");
		System.out.println("Before Hover:"+bgColor);
		mouseOverHome.perform();
		bgColor = tdHome.getCssValue("background-color");
		System.out.println("After Hover:"+bgColor);
		
		//Series of Multiple Actions
		WebElement userName = driver.findElement(By.name("userName"));
		Action seriesOfActions = builder.moveToElement(userName).click().keyDown(userName, Keys.SHIFT)
				.sendKeys(userName, "hello").keyUp(userName, Keys.SHIFT).doubleClick(userName)
				.contextClick().build();
		seriesOfActions.perform();
		driver.close();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseClickKeyboardEvents obj = new MouseClickKeyboardEvents();
		obj.invokebrowser();

	}

}
