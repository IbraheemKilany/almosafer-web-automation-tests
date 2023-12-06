package almosafer;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tests {
	
	WebDriver driver = new ChromeDriver();
	String url ="https://global.almosafer.com/en";
	
	
	
	@BeforeTest
	public void beforetest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));// هذا الكود عشان لو صارت مشكلة معينه يستنى لحتى يحلها 
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div/button[1]")).click();
	}

	@Test()

	public void tochecklanguege() {
		String language= driver.findElement(By.tagName("html")).getAttribute("lang");
		Assert.assertEquals(language, "en");
	}
	@Test()
	public void tocheckcurrency() {
		
		String curency =driver.findElement(By.xpath("//button[normalize-space()='SAR']")).getText();
		Assert.assertEquals(curency, "SAR");
	}
	@Test()
	public void checkcontractnumber() {
	WebElement contractnumber= driver.findElement(By.cssSelector("a[class='sc-hUfwpO bWcsTG'] strong"));
	
	String Currentcontractnumber=contractnumber.getText();
	Assert.assertEquals(Currentcontractnumber, "+966554400000");
		
		
		
	}
	
	
	
	
	
		
		
		
	
		
	
	
	

	@AfterTest
	public void aftertest() {
	}

}
