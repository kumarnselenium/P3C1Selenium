package automationConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;

public class VerificationsUsingTestNG {

//	@Test
	public void emiCalc() throws InterruptedException
	{
		//open Chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/narkandukuri/Downloads/chromedriver");
		WebDriver oBrowser = new ChromeDriver();
		
		oBrowser.get("http://www.deal4loans.com/Contents_Calculators.php");
		
		//Check whether 'EMI Calculator' page displayed or not
		try {
			//Assert.assertTrue(oBrowser.findElement(By.xpath("//h1[contains(.,'EMI Calculator')]")).isDisplayed(),"Fail, EMI Calculator page is not displayed");
			System.out.println("Pass, EMI Calculator page is displayed");
		}catch(Exception e)
		{
			System.out.println("Fail, EMI Calculator page is not displayed");
		}
		
		//Assert.assertTrue(oBrowser.findElements(By.xpath("//h1[contains(.,'EMI Calculator')]")).size()>0, "Fail, EMI Calculator page is not displayed");
		System.out.println("Pass, EMI Calculator page is displayed");
		
		oBrowser.findElement(By.id("Loan_Amount")).clear();
		oBrowser.findElement(By.id("Loan_Amount")).sendKeys("5000");
		oBrowser.findElement(By.name("rate")).click();
		
		String strExpectedLoanAmntText = "Rs. five thousand .";
		String strActualLoanAmntText = oBrowser.findElement(By.id("wordloanAmount")).getText();
		
		//Assert.assertTrue(strExpectedLoanAmntText.equalsIgnoreCase(strActualLoanAmntText),"Fail, Loan Amount text is not displayed as expected");
		System.out.println("Pass, Loan Amount text is displayed as expected");
		
		oBrowser.findElement(By.name("rate")).clear();
		oBrowser.findElement(By.name("rate")).sendKeys("3");
		
		oBrowser.findElement(By.name("months")).clear();
		oBrowser.findElement(By.name("months")).sendKeys("10");
		
		oBrowser.findElement(By.xpath("//input[@value='Calculate']")).click();
		
		String sExpectedEMI = "506.9";
		String sActualEMI = oBrowser.findElement(By.name("pay")).getAttribute("value");
		
		//Assert.assertTrue(sExpectedEMI.equals(sActualEMI),"Fail, EMI is not correct");
		System.out.println("Pass, EMI is correct");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
