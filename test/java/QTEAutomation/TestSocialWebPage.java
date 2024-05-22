package QTEAutomation;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pompage.CartPage;
import org.pompage.ConfigProperties;
import org.pompage.SocialWebPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestSocialWebPage {
	
	static ExtentReports extentreport;
	static ExtentTest extentttest;
	static ExtentSparkReporter spark;
	private ConfigProperties config;
	
	WebDriver driver;
	

	
	//ProfileTest profile=new ProfileTest(driver);
	SocialWebPage page=new SocialWebPage(driver);
	public Properties properties=new Properties();

	
	
	@BeforeTest
	
	public void reportTestModule() throws IOException
	{
		page.reportTest();
		//config = new ConfigProperties("\\application.properties");
		
		config = new ConfigProperties();
		config.loadProperties();
	}
		
	
	
	public void config()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
		
	}
	
	@Test(priority=0, enabled=true)
	public void loginPage() throws InterruptedException, IOException
	{
		
		
		page.profileLoginPage(config.userName(), config.password());
		Thread.sleep(3000);
		page.screenShotsLoginPage();
	}
	
	@Test(priority=1,enabled=true)
	public void testSocialTwitterPage() throws InterruptedException, IOException, AWTException
	{
		page.socialTwitter();
		Thread.sleep(3000);
		page.screenShotsTwitterPage();
		Thread.sleep(5000);
		page.closeWindows();
	}
	
	@Test(priority=2,enabled=true)
	
	
	
	public void testSocialFacebookPage() throws AWTException, InterruptedException, IOException
	{
		page.profileLoginPageforSocial(config.userName(), config.password());
		Thread.sleep(3000);
		page.socialFacebook();
		Thread.sleep(3000);
		page.screenShotsFacebookPage();
		Thread.sleep(5000);
		page.closeWindows();
	}
@Test(priority=3,enabled=true)
	
	
	
	public void testSocialLinkedinPage() throws AWTException, InterruptedException, IOException
	{
		page.profileLoginPageforSocial(config.userName(), config.password());
		Thread.sleep(3000);
		page.socialLinkedin();
		Thread.sleep(3000);
		page.screenShotsLinkedinPage();
		Thread.sleep(5000);
		page.closeWindows();
	}
	
		

	@AfterTest
	
	public void flushReportModule() throws InterruptedException
	{
		page.endTest();
	}



}
