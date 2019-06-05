package autoit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginToFaceBook 
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
		driver.get("https://www.facebook.com");
		wait = new WebDriverWait(driver , 30);
		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void loginToFaceBook() throws Exception
	{
		Screen screen = new Screen();
		Pattern username = new Pattern("C:\\SeleniumDrivers\\username.PNG");
		Pattern password = new Pattern("C:\\SeleniumDrivers\\password.PNG");
		Pattern loginBtn = new Pattern("C:\\SeleniumDrivers\\loginBtn.PNG");
		screen.wait(username , 10);
		screen.type(username , "sudheer.sun@gmail.com");
		screen.type(password , "komali@7P");
		screen.click(loginBtn);
	}
	

}
