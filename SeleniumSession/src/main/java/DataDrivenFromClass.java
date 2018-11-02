import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenFromClass {
	WebDriver driver;

	@BeforeMethod
	public void Setup() throws InterruptedException

	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	
	@DataProvider(name="TestData")
	public FreeCRMData[] FreeCRMData() 
	{
		return new FreeCRMData[]{ new FreeCRMData("Naveen","Test@123"),
								new FreeCRMData("kunal","Test@123")};
}
	
	@Test(dataProvider="TestData") 
	public void getdata(FreeCRMData Fr) throws Exception
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Fr.Username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Fr.Password);
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}
	
	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}
}
	
