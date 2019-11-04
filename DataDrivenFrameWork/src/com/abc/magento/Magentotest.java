package com.abc.magento;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Magentotest 
{

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("E:\\Eclipse\\eclipse-workspace\\SELENIUM\\DataDrivenFrameWork\\src\\com\\abc\\utilities\\DataDriven.properties");
		
	    Properties p = new Properties();
	    p.load(fis);
	    
	    String nurl = p.getProperty("url");
	    String nemail = p.getProperty("email");
	    String npass = p.getProperty("pass");
	    
	    System.out.println(nurl);
	    System.out.println(nemail);
	    System.out.println(npass);
	    
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get(nurl);
	    
	    driver.findElement(By.linkText("My Account")).click();
	    driver.findElement(By.id("email")).sendKeys(nemail);
	    driver.findElement(By.id("pass")).sendKeys(npass);
	    driver.findElement(By.id("send2")).click();
	    driver.findElement(By.linkText("Log Out")).click();
	    
	    driver.close();
	    
	}

}
