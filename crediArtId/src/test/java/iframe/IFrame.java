package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "//home//abc//Downloads//chromedriver_linux64//chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("file:///home/abc/git/repository/crediArtId/src/test/java/htmlPages/Main.html");
		System.out.println(driver.getPageSource());
		System.out.println("-------------------");
		//switch to frame by using index********
		driver.switchTo().frame(0);
		System.out.println(driver.getPageSource());
		driver.switchTo().frame(0);
		System.out.println(driver.getPageSource());
		driver.switchTo().parentFrame();
		System.out.println(driver.getPageSource());
		driver.switchTo().parentFrame();
		System.out.println(driver.getPageSource());
		driver.close();
		WebDriver driver1=new ChromeDriver();
		driver1.navigate().to("file:///home/abc/git/repository/crediArtId/src/test/java/htmlPages/Main.html");
		System.out.println("----------main source code---------");
		System.out.println(driver1.getPageSource());
		//switch by id or name**********
		driver1.switchTo().frame("frame1");
		System.out.println(driver1.getPageSource());
		//switch by webElement**********
		driver1.switchTo().frame(driver1.findElement(By.id("frame2")));
		System.out.println(driver1.getPageSource());
		//directly switch to parent frame .ie. Main.html*********
		driver1.switchTo().defaultContent();
		System.out.println(driver1.getPageSource());
		driver1.close();
	}

}
