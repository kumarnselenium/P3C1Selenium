package automationConcepts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class EMICalculatorTest {

	@Test
	public void emiCalc() throws InterruptedException
	{
		//open Chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
		WebDriver oBrowser = new ChromeDriver();
		
		oBrowser.get("http://www.deal4loans.com/Contents_Calculators.php");
		
		oBrowser.findElement(By.id("Loan_Amount")).clear();
		oBrowser.findElement(By.id("Loan_Amount")).sendKeys("50000");
		
		oBrowser.findElement(By.name("rate")).clear();
		oBrowser.findElement(By.name("rate")).sendKeys("5");
		
		oBrowser.findElement(By.name("months")).clear();
		oBrowser.findElement(By.name("months")).sendKeys("60");
		
		oBrowser.findElement(By.xpath("//input[@value='Calculate']")).click();
		
	}

}
