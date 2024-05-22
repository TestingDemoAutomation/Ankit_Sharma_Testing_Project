package QTEAutomation;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.pompage.CartSortPage;
import org.pompage.ConfigProperties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestCartSortPage {
	

	static ExtentReports extentreport;
	static ExtentTest extentttest;
	static ExtentSparkReporter spark;
	private ConfigProperties config;
	
	WebDriver driver;
	CartSortPage sortpage=new CartSortPage(driver);
	public Properties properties=new Properties();

	@BeforeTest
	
	public void reportTestModule() throws IOException
	{
		sortpage.reportTest();
		//config = new ConfigProperties("\\application.properties");
		
		config = new ConfigProperties();
		config.loadProperties();
		
	}
	@Test(priority=0,enabled=true)
	public void loginPage() throws InterruptedException, IOException
	{
		
		
		sortpage.profileLoginPage(config.userName(), config.password());
		Thread.sleep(3000);
		sortpage.screenShotsLoginPage();
		Thread.sleep(3000);
	}
	@Test(priority=1,enabled=true)
	
	public void cartTest() throws InterruptedException, IOException
	{
		sortpage.sortPage();
		Thread.sleep(3000);
		sortpage.screenShotSortedPage();
		sortpage.logoutPage();
		Thread.sleep(3000);
		sortpage.closeWindows();
	}
	
	
	@AfterTest
	public void flushReportModule() throws InterruptedException
	{
		sortpage.endTest();
	}
	

}
