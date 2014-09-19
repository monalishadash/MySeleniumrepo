package persistent.code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	WebDriver driver;
	
	@FindBy(id="user_login")
	@CacheLookup
	WebElement userId;
	
	@FindBy(id="user_pass")
	@CacheLookup
	WebElement Pass;
	
	@FindBy(id="wp-submit")
	@CacheLookup
	WebElement submit;
	
	@FindBy(xpath="//a[@title='Password Lost and Found']")
	@CacheLookup
	WebElement lostPasswd;
	
	@FindBy(id="user_login")
	@CacheLookup
	WebElement userEmail_txtbox;
	
	@FindBy(id="wp-submit")
	@CacheLookup
	WebElement sendPasswd;
	
	public Login(WebDriver driver1)
	{
		this.driver=driver1;
	}
	
	public Dashboard loginToWordpress(String userNm, String UserPass)
	{
		userId.sendKeys(userNm);
		Pass.sendKeys(UserPass);
		submit.click();
		//return new Dashboard(driver);
		return PageFactory.initElements(driver, Dashboard.class);
	}
	
	public Login ForgotPassword(String user)
	{
		lostPasswd = driver.findElement(By.xpath("//a[@title='Password Lost and Found']"));
		lostPasswd.click();
		userEmail_txtbox= driver.findElement(By.id("user_login"));
		userEmail_txtbox.sendKeys(user);
		sendPasswd = driver.findElement(By.id("wp-submit"));
		sendPasswd.click();
		return new Login(driver);
	}
}
