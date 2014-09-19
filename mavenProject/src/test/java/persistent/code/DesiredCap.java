package persistent.code;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DesiredCap {
  @Test
  public void f() throws MalformedURLException {
	  
	  FirefoxProfile profile = new FirefoxProfile();
	  
	  FirefoxBinary biin = new FirefoxBinary(new File (""));
	  
	//  WebDriver = 
	  
	  profile.setPreference("network.http.phisy-user[ass-length", 255);
	  
	 /* DesiredCapabilities dc = new DesiredCapabilities();
	  dc.setBrowserName("firefox");
	  WebDriver driver = new RemoteWebDriver(new URL("http://10.44.204.218:4444/wd/hub"), dc);
	  */
	  
	  
	  
	  WebDriver driver = new FirefoxDriver(profile);
	  //set proxy username and passwd
	  driver.get("http://monalisha_dash:SecretPass123$@wordpress.com/wp-login.php");
	  
	  driver.findElement(By.id("user_login")).sendKeys("mona");
	  
	  driver.quit();
  }
}
