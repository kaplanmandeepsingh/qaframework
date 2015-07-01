package test.java.com.qaf.utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.it.E;

public class WebConnector {

	Properties OR = null;
	Properties config = null;
	WebDriver driver = null;
	WebDriver Mozilla = null;
	WebDriver Chrome = null;
	WebDriver IE = null;


	public WebConnector(){
		if(OR == null){
			try{
				OR = new Properties();
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"src\\main\\java\\test.java.com.qaf.properties\\OR.properties");
				OR.load(fs);
				
				config = new Properties();
				FileInputStream fs1 = new FileInputStream(System.getProperty("user.dir")+"src\\main\\java\\test.java.com.qaf.properties\\config.properties");
				config.load(fs1);
				System.out.println(config.getProperty("loginURL"));
				
			}catch(Exception e){
			System.out.println("Error while initializing property file ");
			e.printStackTrace();
			}
		}
	}
	
	public void openBrowser(String browserType){
		
		if(browserType.equals("Mozilla") && Mozilla == null ){
			 driver = new FirefoxDriver();
		}else if(browserType.equals("Chrome") && Chrome == null){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\test.resources.com.qaf.resources\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		}else if(browserType.equals("IE") && IE == null){
			System.setProperty("webdriver.InternetExplorer.driver", System.getProperty("user.dir")+"\\src\\test\\java\\test.resources.com.qaf.resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void navigate(String URL){
		driver.get(config.getProperty(URL));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	public String getElementText(String objectname){

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.ignoring(WebDriverException.class);
		String elementText = "";
		//WebElement element = driver.findElement(locator);
		elementText = driver.findElement(By.xpath(OR.getProperty(objectname))).getText();
		return elementText;
	}
	
	public void click(String objectname){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.ignoring(WebDriverException.class);
		driver.findElement(By.xpath(OR.getProperty(objectname))).click();
	}
	
	public void performTextEntry( String objectname,String TextEntry){
	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.ignoring(WebDriverException.class);
		driver.findElement(By.xpath(OR.getProperty(objectname))).sendKeys(TextEntry);
	}
	
	public boolean verifyElementText(String objectname,String expectedText){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean textPresent = false;
		wait.ignoring(WebDriverException.class);
		String actualText = "";
		//WebElement element = driver.findElement(locator);
		actualText = driver.findElement(By.xpath(OR.getProperty(objectname))).getText();
		
		if(actualText.equals(expectedText)){
			textPresent = true;
		}else{
			textPresent = false;
			Assert.assertFalse(textPresent, "Expected text not present");
		}
		
		return textPresent;
	}
}
