package org.pompage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CartPage {
	
	WebDriver driver;
	Actions action;
	TakesScreenshot screenshot;
	ConfigProperties confid;
		
		public  CartPage(WebDriver driver) {
			 
			this.driver=driver;

			
					}
		

		By userName=By.name("user-name");
		By password=By.name("password");
		By loginButton=By.name("login-button");
		By SwagLabs=By.xpath("//div[text()='Swag Labs']");
		By cartButton=By.xpath("//a[@class='shopping_cart_link']");
		By checkout=By.xpath("//button[text()='Checkout']");
		By formName=By.id("first-name");
		By formLastName=By.id("last-name");
		By pinCode=By.id("postal-code");
		By continueButton=By.name("continue");
		By finish=By.xpath("//button[text()='Finish']");
		By finalOrder=By.xpath("//h2[text()='Thank you for your order!']");
		
		
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
		
		public void screenShotsLogin() throws IOException
		{
			screenshot=(TakesScreenshot)driver;
			String screenshotfile=screenshot.getScreenshotAs(OutputType.BASE64);
			byte[] b1=Base64.getDecoder().decode(screenshotfile);
			FileOutputStream datafile=new FileOutputStream(new File("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\Screenshots\\WebPage1.jpeg"));
			datafile.write(b1);
		}
		public void screenShotsSuccessOrder() throws IOException
		{
			screenshot=(TakesScreenshot)driver;
			String screenshotfile=screenshot.getScreenshotAs(OutputType.BASE64);
			byte[] b1=Base64.getDecoder().decode(screenshotfile);
			FileOutputStream datafile=new FileOutputStream(new File("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\Screenshots\\Successorder.jpeg"));
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
		
		
		
		public void cart() throws InterruptedException
		{
			boolean order=false;
			List<WebElement> cartValue=driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
			System.out.println(cartValue);
			int size=cartValue.size();
			System.out.println(size);
			action.moveToElement(cartValue.get(0)).click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(cartValue.get(5)).click().build().perform();
			Thread.sleep(3000);
			driver.findElement(cartButton).click();
			Thread.sleep(3000);
			driver.findElement(checkout).click();
			Thread.sleep(3000);
			driver.findElement(formName).sendKeys("Shridhar");
			Thread.sleep(3000);
			driver.findElement(formLastName).sendKeys("Kaushik");
			Thread.sleep(3000);
			driver.findElement(pinCode).sendKeys("122005");
			Thread.sleep(3000);
			driver.findElement(continueButton).click();
			Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			//jse.executeScript("window.scrollBy(0,1000)", "");
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(3000);
			driver.findElement(finish).click();
			Thread.sleep(3000);
			
		
			order=driver.findElement(finalOrder).isDisplayed();
			
			if(order)
			{
				System.out.println("Testcase 2 is pass");
				extentttest.log(Status.PASS, "Test case 2 is pass. Order is placed.");
				
				}
			else
			{
				System.out.println("Test Case 2 is fail.");
				extentttest.log(Status.FAIL, "Order is not placed.");
			}
			
			
		}
		public void closeWindows()
		{
			driver.quit();
		}

	}



