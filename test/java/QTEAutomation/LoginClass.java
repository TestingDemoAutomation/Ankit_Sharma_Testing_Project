package QTEAutomation;


import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class LoginClass {
	
	
	
	
	
	
	
	
	
	

	
	
	public void login() throws InterruptedException
	{
		
		ChromeOptions options = new ChromeOptions();
		
		options.addExtensions(new File("C:\\Users\\ankit\\OneDrive\\Documents\\Five9 Softphone Extension 13.0.2.0.crx"));
		WebDriver w1=new ChromeDriver(options);
		w1.manage().window().maximize();
		
		
		w1.get("https://chromewebstore.google.com/detail/five9-softphone-extension/apdkclopegaflhehflfdieginkoiejjj");
		
		
		MutableCapabilities capabilities = new MutableCapabilities();
		
		/*HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		capabilities.setCapability("browserName", "Chrome");
		browserstackOptions.put("os", "Windows");	
		browserstackOptions.put("osVersion", "10");
		capabilities.setCapability("bstack:options", browserstackOptions);*/
		
		
	}
	
	
	
	
	public static void main(String...a)throws InterruptedException, AWTException
	
	
	{
		
		
		LoginClass l1=new LoginClass();
		l1.login();
	}

}
