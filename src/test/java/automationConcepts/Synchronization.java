package automationConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {
	
	public int sGlobalSyncTime=30;
	
	//AJAX Calls
	public void exForExplicitWaitUsingWDW() throws InterruptedException
	{
		//open Chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
		WebDriver oBrowser = new ChromeDriver();
		oBrowser.get("http://www.deal4loans.com/Contents_Calculators.php");
		oBrowser.manage().window().maximize();
		
		oBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		oBrowser.findElement(By.id("fileUpload")).click();
		
		//Need to wait for the message - "File uploaded successfully"
		WebDriverWait oWD = new WebDriverWait(oBrowser, 180);
		oWD.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(.,'File uploaded successfully')]")));
		
		oBrowser.findElement(By.id("signout")).click();
	}
	
	public void exForExplicitWaitUsingThread() throws InterruptedException
	{
		//open Chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
		WebDriver oBrowser = new ChromeDriver();
		oBrowser.get("http://www.deal4loans.com/Contents_Calculators.php");
		oBrowser.manage().window().maximize();
		
		oBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		oBrowser.findElement(By.id("fileUpload")).click();
		//Need to wait for the message - "File uploaded successfully"
		Thread.sleep(180000);
		oBrowser.findElement(By.id("signout")).click();
	}
	
	public void exForImplicitWait() throws InterruptedException
	{
		//open Chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
		WebDriver oBrowser = new ChromeDriver();
		oBrowser.get("http://www.deal4loans.com/Contents_Calculators.php");
		oBrowser.manage().window().maximize();
		
		oBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		oBrowser.findElement(By.id("Loan_Amount123")).clear();
		oBrowser.findElement(By.id("Loan_Amount123")).sendKeys("50000");
	}
	
}
