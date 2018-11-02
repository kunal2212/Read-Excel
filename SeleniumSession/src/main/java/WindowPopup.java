import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WindowPopup {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		String ParentWindow=driver.getWindowHandle();
		System.out.println(ParentWindow);
	
		Set<String>WindowHandles=driver.getWindowHandles();
		int count=WindowHandles.size();
		System.out.println(count);
		for(String Child:WindowHandles) 
		{
			if(!ParentWindow.equalsIgnoreCase(Child)) 
			{
				driver.switchTo().window(Child);
				System.out.println("The Child Window Popup Name is" + Child);
				System.out.println("The Child Window Title is" +driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(ParentWindow);
		System.out.println(ParentWindow);
		System.out.println("The Parent Window Title is" +driver.getTitle());
		driver.close();
	
}
	}
