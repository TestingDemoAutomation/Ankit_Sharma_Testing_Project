package QTEAutomation;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.pompage.ConfigProperties;
//import org.pompage.LoginModule;
import org.pompage.ProfileTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class TestProfile {
	
	static ExtentReports extentreport;
	static ExtentTest extentttest;
	static ExtentSparkReporter spark;
	private ConfigProperties config;
	
	WebDriver driver;
	

	
	//ProfileTest profile=new ProfileTest(driver);
	ProfileTest profile=new ProfileTest(driver);
	public Properties properties=new Properties();

	
	
	@BeforeTest
	
	public void reportTestModule() throws IOException
	{
		profile.reportTest();
		//config = new ConfigProperties("\\application.properties");
		
		config = new ConfigProperties();
		config.loadProperties();
		
	}
	
	public void config()
	{
		
	}
	
	@Test(priority=0, enabled=true)
	public void loginPageBrowserTest() throws InterruptedException, IOException
	{
		
		
		profile.profileLoginPage(config.userName(), config.password());
		Thread.sleep(3000);
		profile.screenShots();
	}
	
		

	@AfterTest
	
	public void flushReportModule() throws InterruptedException
	{
		profile.endTest();
	}
	
	
	}
	
	
	


