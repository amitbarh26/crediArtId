package imgAltTag;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class ImgAltTagDesk
{
	static WebDriver driver;
	@Test
	public static void fetchDoctorAppointmentUrl() throws InterruptedException
	{
		/*System.setProperty("webdriver.chrome.driver","//home//abc//Downloads//chromedriver_linux64//chromedriver");      
	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    LoggingPreferences loggingprefs = new LoggingPreferences();
	    loggingprefs.enable(LogType.BROWSER, Level.ALL);
	    capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
	    driver = new ChromeDriver(capabilities);
	    driver.manage().deleteAllCookies();
	    driver.get("https://www.credihealth.com");*/
		System.setProperty("webdriver.chrome.driver","//home//abc//Downloads//chromedriver_linux64//chromedriver"); 
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.myignou.com/");
		List<WebElement> imgcount = driver.findElements(By.tagName("img"));
		System.out.println(imgcount.size());
		for(WebElement eachTag:imgcount)
		{
			if(eachTag.getAttribute("alt").isEmpty())
			{
				System.out.println(eachTag.getAttribute("src"));
			}
		}
	}
}
