package foo;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Log4jExample {
	
	private static Logger log = Logger.getLogger(Log4jExample.class);
  @Test
  public void loggingMethod() {
	  
	  DOMConfigurator.configure("log4j.xml");
	  WebDriver driver = new FirefoxDriver();
	  
	  Throwable err = new Exception();
	  
	  //log.info("WebDriver has been initialized successfully");
	
	  
	  driver.get("https://wordpressss.com/wp-login.php");
	  //log.info("WebDriver has been initialized successfully");
	  log.debug("WebDriver lunched successfully", err);
  }
}
