package foo;

//import java.io.File;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MultipleWindows {
  @Test
  public void handleWindows() {
	  
	  WebDriver driver = new FirefoxDriver();
	  driver.get("http://www.flipkart.com/");
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  
	  driver.findElement(By.cssSelector(".facebook_icn.inner.rmargin5")).click();
	 
	  Set<String> windows = driver.getWindowHandles();
		for(String s: windows)
		{
			System.out.println("Window name: " + s +"\n"+"==========================");
			driver.switchTo().window(s);
			System.out.println("Page Title: " + driver.getTitle());
			if(driver.getTitle().contains("Online Shopping India"))
			{
				System.out.println("Window is Flipkart");
				//driver.findElement(By.linkText("Electronics")).click();
				
			}
			else if(driver.getTitle().contains("Facebook"))
			{
				System.out.println("Window is Facebook");
				driver.findElement(By.id("email")).sendKeys(Keys.F9+""+Keys.NUMPAD3+""+Keys.ARROW_DOWN);
				
				File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(screenshot, 	new File("./screenshot/facebook_login.png"));
				} catch (Exception e) {
					System.out.println("Error: "+ e);
				}
				
						
			}
		}
		
		//driver.quit();
	  
  }
}
