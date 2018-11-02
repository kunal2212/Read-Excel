import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		List<WebElement> List = driver.findElements(By.tagName("a"));
		System.out.println("Total Number of Links in Page which is blank or null are " + List.size());
		System.out.println("*************************** Before Checking Null Value*************************************");
		List<WebElement> ActualLink = new ArrayList<WebElement>();
		for (int i = 0; i < List.size(); i++) {
			System.out.println(List.get(i).getAttribute("href"));
			if (List.get(i).getAttribute("href") != null
					&& (!List.get(i).getAttribute("href").contains("javascript"))) {
				ActualLink.add(List.get(i));
			}

		}
		System.out.println(
				"*************************** After Checking Null Value*****************************************");
		System.out.println("The Number of Links which are not blank or null are " + ActualLink.size());
		for (int j = 0; j < ActualLink.size(); j++) {
			// System.out.println("*************************** After Checking Null Value");
			String str=ActualLink.get(j).getText();
			if(!str.isEmpty()) 
			{
				System.out.println(ActualLink.get(j).getText());
			}
		}

		driver.close();
	}
}
