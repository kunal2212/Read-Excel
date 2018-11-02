import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MeadowbookAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.mbrook.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		By x1=By.xpath("//ul[@id='top-menu']//li//a[text()='Fitness']");
		By x2=By.xpath("//ul[@id='top-menu']//li//a[text()='Fitness Classes']");
		act.moveToElement(driver.findElement(x1)).build().perform();
		WebElement element = driver.findElement(x2);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		

	}

}
