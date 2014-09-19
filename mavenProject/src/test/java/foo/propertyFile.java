package foo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class propertyFile {
	
  @Test
  public void propertyFileMethod() throws FileNotFoundException, IOException {
	  WebDriver driver = new FirefoxDriver();
	  
	  Properties prop = new Properties();
	  prop.load(new FileInputStream(new File("./src/test/ObjectRepository.properties")));
	  
	  
	  driver.get(prop.getProperty("testUrl"));
	 
	  String user_textbx = prop.getProperty("userLogin_txtbox");
	  String pass_textbox= prop.getProperty("userpass_txtbox");
	  String checkbox = prop.getProperty("rememberMe_chkbox");
	  String loginSubmit_btn = prop.getProperty("wordpressLoginSubmit_btn");
	  
	  List<String> list= new ArrayList();
	  list.add(user_textbx);
	  list.add(pass_textbox);
	  list.add(checkbox);
	  list.add(loginSubmit_btn);
	  
	  
	 /* driver.findElement(By.cssSelector(user_textbx)).sendKeys(prop.getProperty("wlogin"));
	  driver.findElement(By.cssSelector(pass_textbox)).sendKeys(prop.getProperty("wpasswd"));
	  driver.findElement(By.cssSelector(checkbox)).click();
	  driver.findElement(By.cssSelector(loginSubmit_btn)).click();
	  */
	  
	  for(String s: list)
	  {
		  
	  }
	 
		  int i=user_textbx.indexOf('.');
		  String locatorType = user_textbx.substring(0,i);
		  String locator = user_textbx.substring(i+1);
		  	 
		  System.out.println("Locator: "+locator + "Locator type: "+locatorType);  
		  WebElement e = null;
		  
		  if(locatorType.equalsIgnoreCase("css"))
		  {
			   e = driver.findElement(By.cssSelector(locator));
		  }
		  else if(locatorType.equalsIgnoreCase("id"))
		  {
			   e= driver.findElement(By.id(locator));
		  }
		  
		  e.sendKeys(prop.getProperty("wlogin"));
		  
	  
	 
	  
  }
}
