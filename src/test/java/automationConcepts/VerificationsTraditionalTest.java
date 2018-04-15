package automationConcepts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerificationsTraditionalTest {


	public int sGlobalSyncTime=30;
	
	@Test
	public void emiCalc() throws InterruptedException
	{
		//open Chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
		WebDriver oBrowser = new ChromeDriver();
		
		oBrowser.get("http://www.deal4loans.com/Contents_Calculators.php");
		
		//Check whether 'EMI Calculator' page displayed or not
		try {
			if(oBrowser.findElement(By.xpath("//h1[contains(.,'EMI Calculator')]")).isDisplayed())
			{
				System.out.println("Pass, EMI Calculator page is displayed");
			}
			else
			{
				System.out.println("Fail, EMI Calculator page is not displayed");
			}
		}catch(Exception e)
		{
			System.out.println("Fail, EMI Calculator page is not displayed");
		}
		
		if(oBrowser.findElements(By.xpath("//h1[contains(.,'EMI Calculator')]")).size()>0)
		{
			System.out.println("Pass, EMI Calculator page is displayed");
		}
		else
		{
			System.out.println("Fail, EMI Calculator page is not displayed");
		}
		
		oBrowser.findElement(By.id("Loan_Amount")).clear();
		oBrowser.findElement(By.id("Loan_Amount")).sendKeys("5000");
		oBrowser.findElement(By.name("rate")).click();
		
		String strExpectedLoanAmntText = "Rs. five thousand .";
		String strActualLoanAmntText = oBrowser.findElement(By.id("wordloanAmount")).getText();
		
		if(strExpectedLoanAmntText.equalsIgnoreCase(strActualLoanAmntText))
		{
			System.out.println("Pass, Loan Amount text is displayed as expected");
		}
		else
		{
			System.out.println("Fail, Loan Amount text is not displayed as expected");
		}
		
		oBrowser.findElement(By.name("rate")).clear();
		oBrowser.findElement(By.name("rate")).sendKeys("3");
		
		oBrowser.findElement(By.name("months")).clear();
		oBrowser.findElement(By.name("months")).sendKeys("10");
		
		oBrowser.findElement(By.xpath("//input[@value='Calculate']")).click();
		
		String sExpectedEMI = "506.9";
		String sActualEMI = oBrowser.findElement(By.name("pay")).getAttribute("value");
		
		if(sExpectedEMI.equals(sActualEMI))
		{
			System.out.println("Pass, EMI is correct");
		}
		else
		{
			System.out.println("Fail, EMI is not correct");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
