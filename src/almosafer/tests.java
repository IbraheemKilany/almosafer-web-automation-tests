package almosafer;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tests {

	WebDriver driver = new ChromeDriver();
	String url = "https://global.almosafer.com/en";

	@BeforeTest
	public void beforetest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8000));// هذا الكود عشان لو صارت مشكلة معينه يستنى
																			// لحتى يحلها
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div/button[1]")).click();
	}

	@Test(enabled = false)
	public void tochecklanguege() {
		String language = driver.findElement(By.tagName("html")).getAttribute("lang");
		Assert.assertEquals(language, "en");
	}

	@Test(enabled = false)
	public void tocheckcurrency() {

		String curency = driver.findElement(By.xpath("//button[normalize-space()='SAR']")).getText();
		Assert.assertEquals(curency, "SAR");
	}

	@Test(enabled = false)
	public void checkcontractnumber() {
		WebElement contractnumber = driver.findElement(By.cssSelector("a[class='sc-hUfwpO bWcsTG'] strong"));

		String Currentcontractnumber = contractnumber.getText();
		Assert.assertEquals(Currentcontractnumber, "+966554400000");
	}

	@Test(enabled = false)
	public void tochecklogoinfooter() {
		WebElement footer = driver.findElement(By.className("sc-boCWhm"));

		boolean iffindqitaflogo = footer.findElement(By.xpath("//div[@class='sc-dznXNo iZejAw']//*[name()='svg']"))
				.isDisplayed();
		Assert.assertEquals(iffindqitaflogo, true);

	}

	@Test(enabled = false)
	public void Hotels_search_tab_isnot_selected_bydefault() {
		WebElement hotels = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String actualvalue = hotels.getAttribute("aria-selected");
		Assert.assertEquals(actualvalue, "false");
	}

	@Test(enabled = false, invocationCount = 5) // تكرار الكود 5 مرات
	public void random_method_tochange_language() {
		String[] mywebsites = { "https://global.almosafer.com/en", "https://global.almosafer.com/ar" };
		Random rand = new Random();
		int randomlang = rand.nextInt(mywebsites.length);
		driver.get(mywebsites[randomlang]);
		if (driver.getCurrentUrl().contains("ar")) {
			String language = driver.findElement(By.tagName("html")).getAttribute("lang");
			Assert.assertEquals(language, "ar");
		} else {

			String language = driver.findElement(By.tagName("html")).getAttribute("lang");
			Assert.assertEquals(language, "en");
		}
	}

	@Test()

	public void Hotels() throws InterruptedException {
		String[] arabiccity = { "جدة", "دبي" };

		Random randar = new Random();
		int arrcity = randar.nextInt(arabiccity.length);

		String[] encity = { "Dubai", "Jeddah", "Riyadh" };

		Random ranen = new Random();
		int enecity = ranen.nextInt(encity.length);

		String[] lurl = { "https://global.almosafer.com/en", "https://global.almosafer.com/ar" };
		Random rand = new Random();
		int randomlangu = rand.nextInt(lurl.length);
		driver.get(lurl[randomlangu]);
		if (driver.getCurrentUrl().contains("ar")) {
			WebElement hotelar = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
			hotelar.click();
			WebElement searchtabar = driver.findElement(By.xpath("//input[@placeholder='البحث عن فنادق أو وجهات']"));
			searchtabar.click();
			searchtabar.sendKeys(arabiccity[arrcity]);

			WebElement firstar = driver.findElement(By.xpath(
					"//li[contains(@class,'phbroq-5 kORbYL AutoComplete__ListItem AutoComplete__ListItem--highlighted AutoComplete__ListItem')]//span[@class='sc-12clos8-7 kuVhFf']"));
			firstar.click();
			WebElement searchk = driver.findElement(By.xpath(
					"//button[@class='sc-jTzLTM eJkYKb sc-1vkdpp9-6 iKBWgG js-HotelSearchBox__SearchButton btn btn-primary btn-block']"));
			searchk.click();
		
			
			WebElement selectorelement = driver.findElement(By.xpath("//select[@class='sc-dDojKJ kgmORR']"));
			Select selector=new Select(selectorelement);
			selector.selectByIndex(ranen.nextInt(2));
			Thread.sleep(3000);
		} else {
			WebElement hotelen = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
			hotelen.click();
			WebElement searchtaben = driver
					.findElement(By.xpath("//input[@placeholder='Search for hotels or places']"));
			searchtaben.click();
			searchtaben.sendKeys(encity[enecity]);
			WebElement firstelement = driver.findElement(By.xpath(
					"//li[@class='phbroq-5 dbvRBC AutoComplete__ListItem AutoComplete__ListItem--highlighted AutoComplete__ListItem ']"));
			firstelement.click();
			WebElement searchk = driver.findElement(By.xpath(
					"//button[@class='sc-jTzLTM eJkYKb sc-1vkdpp9-6 iKBWgG js-HotelSearchBox__SearchButton btn btn-primary btn-block']"));
			searchk.click();
		}
		
		WebElement selectorelement = driver.findElement(By.xpath("//select[@class='sc-dDojKJ kgmORR']"));
		Select selector=new Select(selectorelement);
		selector.selectByIndex(ranen.nextInt(2));
		Thread.sleep(3000);
	}

	@AfterTest
	public void aftertest() {
	}

}
