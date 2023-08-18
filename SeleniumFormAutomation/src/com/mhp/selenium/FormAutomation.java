package com.mhp.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FormAutomation {
	
	public static void main(String[] args) {
		
		//Initialize Webdriver Object
		System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//Open URL
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		//Set window size to maximum
		driver.manage().window().maximize();
		//Click on accept cookies button
		driver.findElement(By.id("ez-accept-all")).click();
		
		//Click and Set First name
		driver.findElement(By.name("firstname")).click();
		driver.findElement(By.name("firstname")).sendKeys("Lyla");
		
		//Click and Set Last name
		driver.findElement(By.name("lastname")).click();
		driver.findElement(By.name("lastname")).sendKeys("Hashimi");
		
		//Select sex
		driver.findElement(By.id("sex-1")).click();
		
		//Select year of experience
		driver.findElement(By.id("exp-3")).click();
		
		//Select and Set Date
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.id("datepicker")).sendKeys("03-03-2025");
		
		//Select Profession
		driver.findElement(By.id("profession-1")).click();
		
		//Select Automation Tool
		driver.findElement(By.id("tool-2")).click();
		
		//Select Continent
		driver.findElement(By.id("continents")).click();
        WebElement dropdown = driver.findElement(By.id("continents"));
        dropdown.findElement(By.xpath("//option[. = 'Europe']")).click();
        
        //Select Command
        WebElement dropdown_2 = driver.findElement(By.id("selenium_commands"));
        dropdown_2.findElement(By.xpath("//option[. = 'Browser Commands']")).click();
        
		//Select photo from computer
        WebElement choosefile = driver.findElement(By.id("photo"));
        choosefile.sendKeys("/Users/Polin/Downloads/myphoto.png");
        
        //Click Submit
        driver.findElement(By.id("submit")).click();
        
		//Close Browser
        driver.close();
		
	}
}
