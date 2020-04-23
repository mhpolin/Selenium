package selenium.webdriver.basicagain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

public class SeleniumDownloadFile {

	WebDriver driver;

	public void invokebrowser() {

		try {
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get("http://demo.guru99.com/test/yahoo.html");
			downloadFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public void downloadFile() {
		
		WebElement downloadbtn = driver.findElement(By.id("messenger-download"));
		String sourceLocation = downloadbtn.getAttribute("href");
		String wgetCommand = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;
		
		try {
			Process exec = Runtime.getRuntime().exec(wgetCommand);
	        int exitVal = exec.waitFor();
	        System.out.println("Exit value: " + exitVal);
		}catch(InterruptedException | IOException ex){
			System.out.println(ex.toString());
		}
		driver.quit();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeleniumDownloadFile obj = new SeleniumDownloadFile();
		obj.invokebrowser();

	}

}
