package org.pompage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;


public class ProfileTest {
	
	
	

	WebDriver driver;
Actions action;
TakesScreenshot screenshot;
ConfigProperties confid;
	
	public  ProfileTest(WebDriver driver) {
		 
		this.driver=driver;

		
				}
	

	By userName=By.name("user-name");
	By password=By.name("password");
	By loginButton=By.name("login-button");
	By SwagLabs=By.xpath("//div[text()='Swag Labs']");
	By infobutton=By.xpath("//span[text()='My Info']");
	
	
	//ChromeOptions options=new ChromeOptions();
	static ExtentReports extentreport;
	static ExtentTest extentttest;
	static ExtentSparkReporter spark;
	
	
	
	
	
	
	public void reportTest()
	{
		
		extentreport=new ExtentReports();
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"\\LoginExtentReport1.html");
		extentreport.attachReporter(spark);
		extentttest=extentreport.createTest("LoginTest");
	}
	
	public void screenShots() throws IOException
	{
		screenshot=(TakesScreenshot)driver;
		String screenshotfile=screenshot.getScreenshotAs(OutputType.BASE64);
		byte[] b1=Base64.getDecoder().decode(screenshotfile);
		FileOutputStream datafile=new FileOutputStream(new File("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\Screenshots\\WebPage.jpeg"));
		datafile.write(b1);
	}
	
	public void endTest() throws InterruptedException
	{
		extentreport.flush();	
	}
	
	public void profileLoginPage(String username, String password1)throws InterruptedException
	{
		boolean dashboardlogin=false;
		driver=new ChromeDriver();
		action=new Actions(driver);
		//confid=new ConfigProperties();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(10000);
		//List<WebElement> usernameValue=driver.findElements(By.xpath("//input[@class='oxd-input oxd-input--active']"));
		driver.findElement(userName).sendKeys(username);
		driver.findElement(password).sendKeys(password1);
		driver.findElement(loginButton).click();
		Thread.sleep(5000);
		dashboardlogin=driver.findElement(SwagLabs).isDisplayed();
		Thread.sleep(3000);
		
		if(dashboardlogin)
		{
			System.out.println("Test case 1 is pass.");
			extentttest.log(Status.PASS, "Test case 1 is pass. Login successfull.");
		}
		
		else
		{

			System.out.println("Test case 1 is fail.");
			extentttest.log(Status.PASS, "Test case 1 is fail. Invalid Credentials are provided.");
		}
		
	//	driver.close();
	
	}
	

}
