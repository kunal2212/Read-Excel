import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	WebDriver driver;

	@BeforeMethod
	public void Setup() throws InterruptedException

	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test(priority = 2 ,groups="Image")
	public void GoogleInput() {
		boolean Img = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		System.out.println(Img);

	}

	@Test(priority = 1,groups="Title")
	public void GoogleTestTitle() {
		String title = driver.getTitle();
		assertEquals(title, "Google", "Title is not Google");

	}

	@Test(priority = 3 ,groups="Link")
	public void LinkVerification() {
		boolean link = driver.findElement(By.linkText("Gmail")).isDisplayed();
		//assertEquals(link, true);
		assertTrue(link,"Gmail Link is not Displayed");
		
		String firstname="Kunal";
		String lastname="Kunal";
		int age=10;
//		String firstname="Kunal";
		Object b[]= new Object[] {firstname,lastname,age};	
		
	for(int i=0;i<b.length;i++) {
		System.out.println(b[i]);
	}

	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

}
