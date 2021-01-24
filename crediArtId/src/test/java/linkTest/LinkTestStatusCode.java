package linkTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LinkTestStatusCode {
	public static WebDriver driver;
	public static void main(String[] args) 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","E://mydiskB//jar//chromedriverLatest.exe");
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.credihealth.com/doctor/rajesh-puri-gastroenterologist/appointment");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total links are "+links.size());
		
		for(int i=0;i<links.size();i++)
		{
			
			WebElement ele= links.get(i);
			
			String url=ele.getAttribute("href");
			
			verifyLinkActive(url);
		}
		invalidUrl();
	}
	static int count=0;
	static int countInvalid=0;
	static LinkedList<String> ls = new LinkedList<String>();
	public static void verifyLinkActive(String linkUrl)
	{
        try 
        {
           URL url = new URL(linkUrl);
           
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           
           httpURLConnect.setConnectTimeout(5000);
           
           httpURLConnect.connect();
           
           if(httpURLConnect.getResponseCode()==200)
           {
        	   count++;
               System.out.println(count+" "+linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
           //else if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) 
           else
           {
        	   count++;
        	   countInvalid++;
               System.out.println(count+" "+linkUrl+" - "+httpURLConnect.getResponseMessage() +httpURLConnect.getResponseCode());
               ls.add(countInvalid+"***"+linkUrl+"***"+httpURLConnect.getResponseCode()+"***"+httpURLConnect.getResponseMessage());
            }
        } catch (Exception e) {
           
        }
    } 
	public static void invalidUrl()
	{
		for(String invalidUrl:ls)
        {
        	System.out.println(invalidUrl);
        }
	}
}
