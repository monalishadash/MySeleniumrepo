package PageObjectScript;

import java.util.concurrent.TimeUnit;

//import org.apache.maven.settings.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import persistent.code.Dashboard;
import persistent.code.Login;
import persistent.code.SettingsPage;

public class TestPageObject {
	
	WebDriver driver;
	Login log;
	Dashboard d;
	SettingsPage s;
	
	
	

	@BeforeTest
	public void setup()
	{
		driver= new FirefoxDriver();
		driver.get("https://wordpress.com/wp-login.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void Lostpasswd()
	{
		//log=new Login(driver);
		log = PageFactory.initElements(driver, Login.class);
		log.ForgotPassword("Mona");
	}
	
	
  @Test
  public void TestMethod() {
	  //log= new Login(driver);
	  PageFactory.initElements(driver, Login.class);
	  d = log.loginToWordpress("monadash", "Secret123$");
	  s = d.clickOnSetting();
	  s.modifyBlogName("My First Blog");
	  s.modifyBlogDesc("My First Blog Description");
	  s.submitModifiedSettings();
	  
	  
	 
	  
  }
  
  @AfterTest
  public void tearDown()
  {
	  driver.quit();
  }
  
  
}
