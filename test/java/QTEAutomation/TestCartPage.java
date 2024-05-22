package QTEAutomation;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.pompage.ConfigProperties;
import org.pompage.CartPage;
import org.pompage.ProfileTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestCartPage {
	
	static ExtentReports extentreport;
	static ExtentTest extentttest;
	static ExtentSparkReporter spark;
	private ConfigProperties config;
	
	WebDriver driver;
	

	
	//ProfileTest profile=new ProfileTest(driver);
	CartPage addcart=new CartPage(driver);
	public Properties properties=new Properties();

	
	
	@BeforeTest
	
	public void reportTestModule() throws IOException
	{
		addcart.reportTest();
		//config = new ConfigProperties("\\application.properties");
		
		config = new ConfigProperties();
		config.loadProperties();
		
	}
	
	public void config()
	{
		
	}
	
	@Test(priority=0, enabled=true)
	public void loginPage() throws InterruptedException, IOException
	{
		
		
		addcart.profileLoginPage(config.userName(), config.password());
		Thread.sleep(3000);
		addcart.screenShotsLogin();
	}
	
	@Test(priority=1,enabled=true)
	public void testAddCart() throws InterruptedException, IOException
	{
		addcart.cart();
		Thread.sleep(3000);
		addcart.screenShotsSuccessOrder();
		Thread.sleep(3000);
		addcart.closeWindows();
		
	}
	
		

	@AfterTest
	
	public void flushReportModule() throws InterruptedException
	{
		addcart.endTest();
	}


}
