package qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	
	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}
	
	public WebDriver getDriver() {
		return this.driver.get();
	}
	
	@BeforeMethod
	@Parameters({"browser","url"})
	public void launchDriver(String browser, String url) {
		WebDriver driver = null;
		switch(browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			//options.addArguments("--headless");
			driver = new ChromeDriver(options);
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.print("browser not avialable");
			
		}
		setDriver(driver);
		getDriver().get(url);
		getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		getDriver().close();
	}

}
