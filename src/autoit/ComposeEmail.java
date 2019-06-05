package autoit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComposeEmail
{
	public  WebDriver driver = null;
	public  static String  Chrome_key = "webdriver.chrome.driver";
	public static String Chrome_value = "C:\\Clients\\Seleniumworkspace\\ThirdPartyToolsDemo\\Driver\\chromedriver.exe";
	public WebDriverWait wait = null;
	
	
	
	@BeforeMethod
	public void precondition() 
	{
		System.setProperty(Chrome_key , Chrome_value );
		driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		wait = new WebDriverWait(driver , 30);
		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	public void RunAutoIt()
	{
		try
		{
			String strFilePath = "C:\\SeleniumDrivers\\document.txt";
			String strPath = "C:\\SeleniumDrivers\\Attachment.exe";
			String strParameter = strPath+" "+strFilePath;
			Runtime.getRuntime().exec(strParameter);
			
		}
		catch(Exception e)
		{
			System.out.println("Unable to attach");
		}
	}
	
	@Test
	public void composeEmailWithAttachment()
	{
		
		WebElement userName = driver.findElement(By.id("identifierId"));
		userName.sendKeys("sudheer.sun@gmail.com");
		WebElement Next = driver.findElement(By.xpath("//span[text() ='Next']"));
		Next.click();
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.sendKeys("Process123");
		WebElement pwdNext = driver.findElement(By.xpath("//span[text() ='Next']"));
		pwdNext.click();
		wait.until(ExpectedConditions.titleContains("Inbox"));
		WebElement Compose = driver.findElement(By.xpath("//div[text()='Compose']"));
		Compose.click();
		WebElement attachBtn = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
		attachBtn.click();
		RunAutoIt();     
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		//driver.close();
	}

	

}
