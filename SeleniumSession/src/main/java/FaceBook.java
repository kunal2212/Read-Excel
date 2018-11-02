import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String Title=driver.getTitle();
		if(Title.contains("Facebook")) 
		{
			System.out.println("The Window title is" + " "+ Title);
		}
		else 
		{
			System.out.println("The Window titile is is not correct");
		}
		driver.quit();
		
}
	
	
}
