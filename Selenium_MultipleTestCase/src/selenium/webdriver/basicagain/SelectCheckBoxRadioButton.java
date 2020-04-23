package selenium.webdriver.basicagain;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCheckBoxRadioButton {
	
	WebDriver driver;

	public void invokebrowser() {

		try {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get("http://demo.guru99.com/test/radio.html");
			selectRadioButton();
			selectCheckBox();
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectRadioButton() {
		
		try {
			WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
			WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
			
			radio1.click();
			System.out.println("Radio Button Option 1 is Selected");
			Thread.sleep(2000);
			//Radio Button1 is de-selected and Radio Button2 is selected
			radio2.click();
			System.out.println("Radio Button Option 2 is Selected");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectCheckBox() {
		
		try {
			WebElement checkbox1 = driver.findElement(By.id("vfb-6-0"));
			WebElement checkbox3 = driver.findElement(By.id("vfb-6-2"));
			
			//toggle on
			checkbox1.click();
			
			if(checkbox1.isSelected()) {
				System.out.println("CheckBox is Toggled On");
			}
			else {
				System.out.println("CheckBox is Toggled Off");
			}
			Thread.sleep(2000);
			//toggle off
			checkbox1.click();
			
			if(!checkbox1.isSelected()) {
				System.out.println("CheckBox is Toggled Off!!!");
		}
			Thread.sleep(2000);
			//Selecting Checkbox and using isSelected Method
			for(int i=0;i<2;i++) {
				checkbox3.click();
				Thread.sleep(2000);
				System.out.println(checkbox3.isSelected());
			}
			
			Thread.sleep(3000);
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectCheckBoxRadioButton obj = new SelectCheckBoxRadioButton();
		obj.invokebrowser();
		

	}

}
