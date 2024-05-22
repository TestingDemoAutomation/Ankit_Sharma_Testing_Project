package org.pompage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SocialWebPage {
	
	WebDriver driver;
	Actions action;
	TakesScreenshot screenshot;
	ConfigProperties confid;
		
		public  SocialWebPage(WebDriver driver) {
			 
			this.driver=driver;

			
					}
		

		By userName=By.name("user-name");
		By password=By.name("password");
		By loginButton=By.name("login-button");
		By SwagLabs=By.xpath("//div[text()='Swag Labs']");
		By infobutton=By.xpath("//span[text()='My Info']");
		By twitter=By.xpath("//a[text()='Twitter']");
		By twitterlogin=By.xpath("//span[text()='Follow']");
		By facebook=By.xpath("//a[text()='Facebook']");
		By facebookloginid=By.xpath("//input[@class='inputtext _55r1 inputtext _1kbt _9ay4 inputtext _1kbt']");
		By facebookloginpassword=By.xpath("//input[@class='inputtext _55r1 inputtext _9npi inputtext _9npi']");
		By login=By.xpath("//button[@class='_42ft _4jy0 _52e0 _4jy6 _4jy1 selected _51sy']");
		By loginerror=By.xpath("//span[text()='Forgotten password?']");
		By linkedin=By.xpath("//a[text()='LinkedIn']");
		//By linkedinfollow=By.xpath("//a[class='top-card-layout__cta mt-2 ml-1.5 h-auto babybear:flex-auto top-card-layout__cta--secondary btn-md btn-secondary']");
		By linkedinerror=By.xpath("//h1[@class='top-card-layout__title font-sans text-lg papabear:text-xl font-bold leading-open text-color-text mb-0']");
		
		By footer=By.xpath("//div[@class='footer_copy']");
		
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
		
		public void screenShotsLoginPage() throws IOException
		{
			screenshot=(TakesScreenshot)driver;
			String screenshotfile=screenshot.getScreenshotAs(OutputType.BASE64);
			byte[] b1=Base64.getDecoder().decode(screenshotfile);
			FileOutputStream datafile=new FileOutputStream(new File("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\Screenshots\\WebPageLogin.jpeg"));
			datafile.write(b1);
		}
		public void screenShotsTwitterPage() throws IOException
		{
			screenshot=(TakesScreenshot)driver;
			String screenshotfile=screenshot.getScreenshotAs(OutputType.BASE64);
			byte[] b1=Base64.getDecoder().decode(screenshotfile);
			FileOutputStream datafile=new FileOutputStream(new File("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\Screenshots\\TwitterPageLogin.jpeg"));
			datafile.write(b1);
		}
		
		public void screenShotsFacebookPage() throws IOException
		{
			screenshot=(TakesScreenshot)driver;
			String screenshotfile=screenshot.getScreenshotAs(OutputType.BASE64);
			byte[] b1=Base64.getDecoder().decode(screenshotfile);
			FileOutputStream datafile=new FileOutputStream(new File("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\Screenshots\\FacebookLoginPage.jpeg"));
			datafile.write(b1);
		}
		public void screenShotsLinkedinPage() throws IOException
		{
			screenshot=(TakesScreenshot)driver;
			String screenshotfile=screenshot.getScreenshotAs(OutputType.BASE64);
			byte[] b1=Base64.getDecoder().decode(screenshotfile);
			FileOutputStream datafile=new FileOutputStream(new File("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\Screenshots\\LinkedinLoginPage.jpeg"));
			datafile.write(b1);
		}
		public void explictWaits()
		{
			WebDriverWait waits=new WebDriverWait(driver, Duration.ofSeconds(5000));
			
			waits.until(ExpectedConditions.visibilityOfElementLocated(footer));
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
		
		public void profileLoginPageforSocial(String username, String password1)throws InterruptedException
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
		}
		
		
		public void socialTwitter() throws InterruptedException, AWTException
		{
			boolean twiterpagelogin=false;
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			//jse.executeScript("window.scrollBy(0,1000)", "");
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");


			driver.findElement(twitter).click();
			Thread.sleep(3000);
			//driver.findElement(twitterlogin).click();
			//Thread.sleep(3000);
			String loginPageWindow=driver.getWindowHandle();
			
			Set<String> twitterWindow=driver.getWindowHandles();
			System.out.println(twitterWindow);
			Iterator<String> allWindow=twitterWindow.iterator();
			while(allWindow.hasNext())
			{
				String twiterWindow=allWindow.next();
				driver.switchTo().window(twiterWindow);
				
			}
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			if(!twiterpagelogin)
			{
				System.out.println("Test case 2 is pass.");
				extentttest.log(Status.PASS, "Test case 2 is pass. Twitter page displayed successfull.");
			}
			
			else
			{

				System.out.println("Test case 2 is fail.");
				extentttest.log(Status.PASS, "Test case 2 is fail. Twitter page did not display.");
			}
			
			
			
			
			
			//driver.close();
			//driver.switchTo().window(loginPageWindow);
			
		
		
		


}
		
		public void socialFacebook() throws AWTException, InterruptedException
		{

			boolean twiterpagelogin=false;
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			//jse.executeScript("window.scrollBy(0,1000)", "");
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			boolean facebookLoginpage=false;
			driver.findElement(facebook).click();
			String parentWindow=driver.getWindowHandle();
			Set<String> allWindow=driver.getWindowHandles();
			Iterator<String> allWindowIterator=allWindow.iterator();
			while(allWindowIterator.hasNext())
			{
				String faceBookWindow=allWindowIterator.next();
				driver.switchTo().window(faceBookWindow);
			}
			Robot robot=new Robot();
			Thread.sleep(5000);
			for(int i=1;i<4;i++)
			{
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(5000);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
			driver.findElement(facebookloginid).sendKeys("8909802846");
			Thread.sleep(3000);
			driver.findElement(facebookloginpassword).sendKeys("Change@26032011");
			Thread.sleep(3000);
			driver.findElement(login).click();
			Thread.sleep(3000);
			facebookLoginpage=driver.findElement(loginerror).isDisplayed();
			
			if(facebookLoginpage)
			{
				System.out.println("Test case 3 is pass.");
				extentttest.log(Status.PASS, "Test case 3 is pass. Facebook page displayed successfull.");
			}
			
			else
			{

				System.out.println("Test case 3 is fail.");
				extentttest.log(Status.PASS, "Test case 3 is fail. Facebook page did not display.");
			}
		}
		
		public void socialLinkedin() throws AWTException, InterruptedException
		{
			boolean linkedinpagelogin=false;
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			//jse.executeScript("window.scrollBy(0,1000)", "");
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			driver.findElement(linkedin).click();
			String parentWindow=driver.getWindowHandle();
			Set<String> allWindow=driver.getWindowHandles();
			Iterator<String> windowsIterator=allWindow.iterator();
			while(windowsIterator.hasNext())
			{
				String linkedinwindow=windowsIterator.next();
				driver.switchTo().window(linkedinwindow);
			}
			
			Robot robot=new Robot();
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			Thread.sleep(3000);

			
			linkedinpagelogin=driver.findElement(linkedinerror).isDisplayed();
			if(linkedinpagelogin)
			{
				System.out.println("Test case 4 is pass.");
				extentttest.log(Status.PASS, "Test case 4 is pass. Linkedin page displayed successfull.");
			}
			
			else
			{

				System.out.println("Test case 4 is fail.");
				extentttest.log(Status.PASS, "Test case 4 is fail. Linkedin page did not display.");
			}
			
		}
		
		public void closeWindows()
		{
			driver.quit();
		}
}
