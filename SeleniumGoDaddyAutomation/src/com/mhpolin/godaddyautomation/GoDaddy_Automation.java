package com.mhpolin.godaddyautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoDaddy_Automation {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
        // declaration and instantiation of objects/variables
		//System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	
        String baseUrl = "https://www.godaddy.com/de-de";
        String expectedTitle = "Domainnamen, Websites, Hosting und Tools für das Online-Marketing – GoDaddy DE";
        String actualTitle = "";

        // launch Chrome and direct it to the Base URL
        driver.get(baseUrl);
        driver.manage().window().maximize();
        

        // get the actual value of the title
         actualTitle = driver.getTitle();
         System.out.println(actualTitle);
         
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
     // Get Current URL
        driver.getCurrentUrl();

        //Code implementation example
        String pageURL = driver.getCurrentUrl();
        System.out.println(pageURL);

        // Validate Current Page URL
        if(baseUrl.contentEquals(pageURL)) 
        {
         System.out.println("Test Passed!");
        }
        else 
        {
         System.out.println("Test Failed.");
        }
     // Get Page Source
        String sourceCode = driver.getPageSource();
        
        if(sourceCode.contains(actualTitle))
        {
         System.out.println("Test Passed!");
        }
        else 
        {
         System.out.println("Test Failed.");
        }
        
        driver.findElement(By.className("p1td6cxw")).click();     
        WebElement Element = driver.findElement(By.className("fqpukcf"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(By.className("fqpukcf")).click();
        WebElement Element2 = driver.findElement(By.className("p1yxuuwm"));
        js.executeScript("arguments[0].scrollIntoView();", Element2);
        driver.findElement(By.className("p1yxuuwm")).click();
        
        
        String secondTitel = "Domainnamen-Suche – Kaufe und registriere verfügbare Domains - GoDaddy DE";
        String actualSecondTitel = driver.getTitle();
        
        if (actualSecondTitel.contentEquals(secondTitel)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        driver.findElement(By.className("logo-mark")).click();
     
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        //close Chrome/firefox
        driver.close();
    }

}

