package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IdTagNameNameClassName
{
	//all locators are static method present inside By class.
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","E://mydiskB//jar//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.calculator.net/mass-calculator.html");
		
		//----------examples for id----------------
		//driver.findElement(By.id("date_clicked_fri_29_jan_2021")).click();
		WebElement density = driver.findElement(By.id("cdensity"));
		density.clear();
		density.sendKeys("1000");
		//----------examples for tagname------------

		//----------examples for classname------------
		
	}
}
