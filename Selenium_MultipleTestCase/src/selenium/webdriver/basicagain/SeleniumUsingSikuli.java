package selenium.webdriver.basicagain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SeleniumUsingSikuli {

	WebDriver driver;
	Screen myScreen;

	public void invokebrowser() {

		try {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//driver.get("http://facebook.com");
			driver.get("http://ebay.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void facebookLoginUsingSikuli() {
		
		try {
			Pattern fbEmail =  new Pattern ("D:\\Sikuli snips\\fb_email_id.PNG");
			Pattern fbPassword =  new Pattern ("D:\\Sikuli snips\\fb_password.PNG");
			Pattern fbLoginButton =  new Pattern ("D:\\Sikuli snips\\fb_loginbtn.PNG");
			Pattern fbForgotAccount = new Pattern ("D:\\Sikuli snips\\fb_forgotaccount.PNG");
			Pattern ebayMotors = new Pattern ("D:\\Sikuli snips\\ebay_motors.PNG");
			
			myScreen = new Screen();
			//myScreen.wait(fbEmail, 3);
			//myScreen.type(fbEmail, "abcd@gmail.com");
			//myScreen.type(fbPassword, "password");
			//myScreen.click(fbLoginButton);
			//myScreen.click(fbForgotAccount);
			myScreen.wait(ebayMotors, 3);
			myScreen.click(ebayMotors);
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeleniumUsingSikuli obj = new SeleniumUsingSikuli();
		obj.invokebrowser();
		obj.facebookLoginUsingSikuli();
		
	}

}
