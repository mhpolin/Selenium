package selenium.webdriver.basicagain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickOnImageUsingCssSelector {


	WebDriver driver;

	public void invokebrowser() {

		try {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get("https://www.facebook.com/login/identify/?ctx=recover&ars=royal_blue_bar");
			facebookImageClick();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void facebookImageClick() {

		try {
			//click on the "Facebook" logo on the upper left portion
			driver.findElement(By.cssSelector("a[title=\"Go to Facebook home\"]")).click();	
			Thread.sleep(2000);
			String titleOfThePage = driver.getTitle();
			System.out.println("Title of Page is: "+titleOfThePage);

			//verify that we are now back on Facebook's homepage	
			if (titleOfThePage.equals("Facebook – log in or sign up")) {

				System.out.println("We are back at Facebook Homepage!");
			}
			else {
				System.out.println("We are NOT back in Facebook Homepage");
			}
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClickOnImageUsingCssSelector obj = new ClickOnImageUsingCssSelector();
		obj.invokebrowser();

	}

}
