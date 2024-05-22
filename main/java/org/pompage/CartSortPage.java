package org.pompage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class CartSortPage {
	
	WebDriver driver;
	Actions action;
	WebElement element;
	Select select;
	TakesScreenshot screenshot;
	ConfigProperties confid;
	
	public CartSortPage(WebDriver driver)
	{
		this.driver=driver;
		}
	

	By userName=By.name("user-name");
	By password=By.name("password");
	By loginButton=By.name("login-button");
	By SwagLabs=By.xpath("//div[text()='Swag Labs']");
	By sorting=By.xpath("//select[@class='product_sort_container']");
	By productid=By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
	By hambutton=By.id("react-burger-menu-btn");
	By logout=By.id("logout_sidebar_link");
	
	static ExtentReports extentreport;
	static ExtentTest extentttest;
	static ExtentSparkReporter spark;
	public void reportTest()
	{
		
		extentreport=new ExtentReports();
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"\\SauseDemoExtentReport.html");
		extentreport.attachReporter(spark);
		extentttest=extentreport.createTest("LoginTest");
	}
	
	public void screenShotsLoginPage() throws IOException
	{
		screenshot=(TakesScreenshot)driver;
		String screenshotfile=screenshot.getScreenshotAs(OutputType.BASE64);
		byte[] b1=Base64.getDecoder().decode(screenshotfile);
		FileOutputStream datafile=new FileOutputStream(new File("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\Screenshots\\WebPageLogin.jpeg"));
		datafile.write(b1);
	}
	
	public void screenShotSortedPage() throws IOException
	{
		screenshot=(TakesScreenshot)driver;
		String screenshotfile=screenshot.getScreenshotAs(OutputType.BASE64);
		byte[] b1=Base64.getDecoder().decode(screenshotfile);
		FileOutputStream datafile=new FileOutputStream(new File("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\Screenshots\\SortedCart.jpeg"));
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
	//	List<WebElement> usernameValue=driver.findElements(By.xpath("//input[@class='oxd-input oxd-input--active']"));
		//usernameValue.
		driver.findElement(userName).sendKeys(username);
		//WebElement w1=driver.findElement(userName);
		//action.moveToElement(w1).keyDown(Keys.SHIFT).sendKeys("a").contextClick().build().perform();
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
	
	public void sortPage()
	{
		boolean productidvalue=false;
		WebElement cartvalue=driver.findElement(sorting);
		select =new Select(cartvalue);
	//select.selectByIndex(3);
		//select.selectByValue("za");
		select.selectByVisibleText("Price (high to low)");
		
		productidvalue=driver.findElement(productid).isDisplayed();
		if(productidvalue)
		{
			System.out.println("Test case 2 is pass. The products are sorted.");
			extentttest.log(Status.PASS, "Test case 2 is pass. The products are sorted.");
		}
		else {
			System.out.println("Test case 2 is fail. The products are not sorted.");
			extentttest.log(Status.FAIL,"Test case 2 is fail. The products are not sorted.");
		}
		
		
		
	}
	
	public void logoutPage() throws InterruptedException
	{
		driver.findElement(hambutton).click();
		Thread.sleep(3000);
		driver.findElement(logout).click();
	}
	
	public void closeWindows()
	{
		driver.quit();
	}
	
	
	
	
	

}
